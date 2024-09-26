package drparanoya.taco.addon.hud;

import drparanoya.taco.addon.Taco;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class WurstClanOnTop extends HudElement {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public static final HudElementInfo<WurstClanOnTop> INFO = new HudElementInfo<>(Taco.HUD_TACO, "WurstClanOnTop", "WurstClanOnTop", WurstClanOnTop::new);

    public WurstClanOnTop() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        setSize(renderer.textWidth("WurstClanOnTop", true), renderer.textHeight(true));

        // Render text
        renderer.text("WurstClanOnTop", x, y, Color.WHITE, true);
    }
}
