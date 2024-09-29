package drparanoya.taco.addon.hud;

import java.lang.Thread;
import drparanoya.taco.addon.Taco;
import meteordevelopment.meteorclient.renderer.GL;
import meteordevelopment.meteorclient.renderer.Renderer2D;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import meteordevelopment.meteorclient.mixin.MinecraftClientAccessor;

public class DancingTaco extends HudElement {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Double> tacoScale = sgGeneral.add(new DoubleSetting.Builder()
        .name(".taco scale")
        .description("Changes the size of the .taco.")
        .defaultValue(1)
        .min(0)
        .sliderRange(0, 10)
        .build()
    );
    private final Identifier[] tacos =
		    {
            Identifier.of("taco", "taco1.png"),
			Identifier.of("taco", "taco2.png"),
			Identifier.of("taco", "taco3.png"),
			Identifier.of("taco", "taco4.png")
            };
    public int ticks = 0;
    public int taconum = 0;
    public static final HudElementInfo<DancingTaco> INFO = new HudElementInfo<>(Taco.HUD_TACO, ".taco", "Spawns a dancing taco on your hotbar.\nI love that little guy. So cute!\n -WiZARD", DancingTaco::new);



    public DancingTaco() {super(INFO);}


    @Override
    public void render(HudRenderer renderer) {

        if (ticks < (MinecraftClientAccessor.getFps() / 4))
        {
            ticks++;
        }
        else if (taconum == 3)
        {
            taconum = 0;
            ticks = 0;
        }
        else
        {
            taconum++;
            ticks = 0;
        }



        setSize(192 * tacoScale.get(),133  * tacoScale.get());
        MatrixStack matrixStack = new MatrixStack();
        GL.bindTexture(tacos[taconum]);
        Renderer2D.TEXTURE.begin();
        Renderer2D.TEXTURE.texQuad(x, y, tacoScale.get() * 192, tacoScale.get() * 133, new Color(255, 255, 255, 255));
        Renderer2D.TEXTURE.render(matrixStack);
   }
}
