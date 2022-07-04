package com.adum.plugin.joinleave;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class EventListener implements Listener {

    FileConfiguration config;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(!config.getBoolean("joinon")) {
            e.setJoinMessage("");
            return;
        }
        String message = config.getString("joinmessage");
        e.setJoinMessage(String.format(message, e.getPlayer().getName()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        if(!config.getBoolean("quiton")) {
            e.setQuitMessage("");
            return;
        }
        String message = config.getString("quitmessage");
        e.setQuitMessage(String.format(message, e.getPlayer().getName()));
    }

    public void setConfig(FileConfiguration config) {
        this.config = config;
    }
}
