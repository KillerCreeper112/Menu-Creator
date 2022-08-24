package killerceepr.tutorial;

import killerceepr.tutorial.events.GeneralEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {
    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new GeneralEvents(), this);
        getLogger().info("[Tutorial]: Plugin has been enabled.");
    }

    @Override
    public void onDisable(){
        getLogger().info("[Tutorial]: Plugin has been disabled.");
    }
}
