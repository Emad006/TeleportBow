package me.xyrophyte.teleportbow.commands;

import me.xyrophyte.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveTeleportBow implements CommandExecutor {

    private final TeleportBow instance;

    public GiveTeleportBow(TeleportBow instance) {
        this.instance = instance;
    }

    private final ItemStack tpBow = new ItemStack(Material.BOW);
    private final ItemStack tpArrow = new ItemStack(Material.ARROW);
    private final ItemMeta tpBowMeta = tpBow.getItemMeta();
    private final ItemMeta tpArrowMeta = tpArrow.getItemMeta();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("tb.tpbow")) {
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
            } else {
                player.sendMessage(ChatColor.RED + "Failed to run command. REASON: Not enough permission.");
                player.sendMessage(ChatColor.RED + "Please contact an administrator if you believe this is an error.");
            }
        } else {
            instance.getLogger().info(ChatColor.GOLD + "Failed to run command. Command is player only.");
        }
        return true;
    }
}
