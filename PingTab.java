package me.kriteak.pingtab;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PingTab extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PingTab enabled!");

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    int ping = player.getPing(); // PaperMC supports this directly
                    String displayName = ChatColor.GREEN + player.getName() + ChatColor.GRAY + " (" + ChatColor.AQUA + ping + "ms" + ChatColor.GRAY + ")";
                    player.setPlayerListName(displayName);
                }
            }
        }.runTaskTimer(this, 0L, 40L); // Updates every 2 seconds
    }

    @Override
    public void onDisable() {
        getLogger().info("PingTab disabled!");
    }
}
