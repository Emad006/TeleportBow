package me.xyrophyte.teleportbow.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnJoin implements Listener {

    private final ItemStack tpBow = new ItemStack(Material.BOW);
    private final ItemStack tpArrow = new ItemStack(Material.ARROW);
    private final ItemMeta tpBowMeta = tpBow.getItemMeta();
    private final ItemMeta tpArrowMeta = tpArrow.getItemMeta();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("tpbow.bowonjoin")) {
            assert tpBowMeta != null;
            assert tpArrowMeta != null;
            tpBowMeta.setDisplayName(ChatColor.AQUA + "Teleport Bow");
            tpArrowMeta.setDisplayName(ChatColor.AQUA + "Teleport Arrow");
            tpBowMeta.setUnbreakable(true);
            tpArrowMeta.setUnbreakable(true);
            tpBow.setItemMeta(tpBowMeta);
            tpArrow.setItemMeta(tpArrowMeta);
            tpBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            player.getInventory().addItem(tpBow, tpArrow);
        }
    }
}
