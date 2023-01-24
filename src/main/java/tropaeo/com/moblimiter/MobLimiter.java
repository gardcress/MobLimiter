package tropaeo.com.moblimiter;

import org.bukkit.plugin.java.JavaPlugin;
import tropaeo.com.moblimiter.commands.ReloadCommand;
import tropaeo.com.moblimiter.listeners.MobSpawnListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MobLimiter extends JavaPlugin {
    public static List<String> disabledMobList = new ArrayList<>();
    public static MobLimiter instance;


    @Override
    public void onEnable() {
        instance = this;
        //////////////// Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        disabledMobList = getConfig().getStringList("disabled-mobs");

        Objects.requireNonNull(getCommand("mlreload")).setExecutor(new ReloadCommand());
        getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);
    }

    @Override
    public void onDisable() {

    }

}
