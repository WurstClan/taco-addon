package drparanoya.taco.addon;

import drparanoya.taco.addon.hud.*;
import drparanoya.taco.addon.modules.*;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;
import org.slf4j.Logger;

public class Taco extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category TACO = new Category("Taco", Items.LIGHT.getDefaultStack());
    public static final HudGroup HUD_TACO = new HudGroup("Taco");

    @Override
    public void onInitialize() {
        LOG.info("Initalizing Taco Addon");

        // Modules
        Modules.get().add(new AntiFBI());
        Modules.get().add(new PlaneAura());
        Modules.get().add(new AntiArresting());
        Modules.get().add(new NoStreakLoss());
        Modules.get().add(new AntiEnglishOrSpanish());
        Modules.get().add(new InfinityAura());
        Modules.get().add(new NoAuraLoss());
        Modules.get().add(new AutoRizz());
        Modules.get().add(new NoBrainrot());
        Modules.get().add(new GalaxyBrainer());
        Modules.get().add(new AutoSlavering());
        Modules.get().add(new NoSkillIssue());

        // HUD
        Hud.get().register(WurstClanOnTop.INFO);
        Hud.get().register(DancingTaco.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(TACO);
    }

    @Override
    public String getPackage() {
        return "drparanoya.taco.addon";
    }
}
