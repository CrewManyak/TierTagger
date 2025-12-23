package me.tier.tagger;

import me.tier.tagger.config.TierConfig;

public class TierDetector {

    public static TierRule detect(String text) {
        for (TierRule rule : TierConfig.TIERS) {
            if (rule.enabled && text.contains(rule.match)) {
                return rule;
            }
        }
        return null;
    }
}
