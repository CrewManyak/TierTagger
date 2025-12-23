package me.tier.tagger;

import me.tier.tagger.config.TierConfig;
import me.tier.tagger.hud.HudRenderer;
import net.fabricmc.api.ClientModInitializer;

public class TierTaggerMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TierConfig.load();
        HudRenderer.register();
        System.out.println("TierTagger loaded");
    }
}
