package me.someone3.nodeathstats;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoDeathStats extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerStatisticIncrementListener(), this);
    }

}
