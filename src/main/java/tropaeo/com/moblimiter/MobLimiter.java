package tropaeo.com.moblimiter;

import org.bukkit.plugin.java.JavaPlugin;

public final class MobLimiter extends JavaPlugin {

    @Override
    public void onEnable() {
        //////////////// Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();


    }

    @Override
    public void onDisable() {

    }
}
