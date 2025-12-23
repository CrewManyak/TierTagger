package me.tier.tagger.hud;

import me.tier.tagger.TierDetector;
import me.tier.tagger.TierRule;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class HudRenderer {

    public static void register() {
        HudRenderCallback.EVENT.register((ctx, tick) -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player == null) return;

            TierRule rule =
                TierDetector.detect(mc.player.getDisplayName().getString());
            if (rule == null) return;

            ctx.drawText(
                mc.textRenderer,
                Text.literal("Tier: ")
                    .append(Text.literal(rule.display)
                    .styled(s -> s.withColor(rule.color))),
                5, 5,
                0xFFFFFF,
                true
            );
        });
    }
}
