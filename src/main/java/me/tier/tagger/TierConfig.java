package me.tier.tagger.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.tier.tagger.TierRule;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TierConfig {

    public static List<TierRule> TIERS = new ArrayList<>();
    private static final File FILE = new File("config/tiertagger.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void load() {
        try {
            if (!FILE.exists()) {
                TIERS.add(new TierRule("LT3", "LT3", 0x00FF00, true));
                save();
            }
            TIERS = GSON.fromJson(new FileReader(FILE), TIERS.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try (FileWriter w = new FileWriter(FILE)) {
            GSON.toJson(TIERS, w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
