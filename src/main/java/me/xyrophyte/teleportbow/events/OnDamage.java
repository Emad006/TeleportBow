package me.xyrophyte.teleportbow.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnDamage implements Listener {
    @EventHandler
    public void onDamage (EntityDamageEvent event) {
        if(event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if(event.getEntity() instanceof Player) {
                if(event.getEntity().hasPermission("tpbow.nofall")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
