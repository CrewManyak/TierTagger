package me.tier.tagger;

public class TierRule {
    public String match;
    public String display;
    public int color;
    public boolean enabled;

    public TierRule(String match, String display, int color, boolean enabled) {
        this.match = match;
        this.display = display;
        this.color = color;
        this.enabled = enabled;
    }
}
