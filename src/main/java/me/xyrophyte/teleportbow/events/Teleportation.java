package me.xyrophyte.teleportbow.events;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Teleportation implements Listener {
    @EventHandler
    public void arrowLand(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Player player = (Player) event.getEntity().getShooter();
            Location location = event.getEntity().getLocation();
            assert player != null;
            player.teleport(location);
        }
    }
}
