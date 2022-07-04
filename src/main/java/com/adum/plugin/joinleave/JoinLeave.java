package com.adum.plugin.joinleave;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeave extends JavaPlugin {

    EventListener listener = new EventListener();
    @Override
    public void onEnable() {
        getConfig().addDefault("joinon", true);
        getConfig().addDefault("joinmessage", ChatColor.YELLOW + "%s has joined the game");
        getConfig().addDefault("quiton", true);
        getConfig().addDefault("quitmessage", ChatColor.YELLOW + "%s has left the game");
        getConfig().options().copyDefaults(true);
        saveConfig();
        listener.setConfig(this.getConfig());
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
