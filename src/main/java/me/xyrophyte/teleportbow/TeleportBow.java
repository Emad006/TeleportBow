package me.xyrophyte.teleportbow;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ChatColor.BLUE + "Plugin is starting up.");

        getLogger().info(ChatColor.BLUE + "Plugin started successfully.");
        getLogger().info(ChatColor.DARK_PURPLE + "For support, join:");
        getLogger().info(ChatColor.LIGHT_PURPLE + "https://discord.gg/dpYrXXWWrM");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(ChatColor.BLUE + "Plugin is shutting down.");
    }
}
