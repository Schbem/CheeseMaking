package me.schmeb.cheesemaking.EventListeners;

import me.schmeb.cheesemaking.BacteriaFunctions.BacteriaCreate;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class OnMyceliumBreak implements Listener {
    BacteriaCreate bacteriaCreate;
    public OnMyceliumBreak(BacteriaCreate bacteriaCreate){
        this.bacteriaCreate = bacteriaCreate;
    }

    @EventHandler
    public void onMyceliumBreak(BlockBreakEvent event){
        if(event.getBlock().getType() == Material.MYCELIUM){
            if(event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) return;
            event.setDropItems(false);
            Random random = new Random();
            double RNG = random.nextDouble();

            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                if(event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1)
                {
                    if(RNG < 0.15)
                        event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation().toCenterLocation(), bacteriaCreate.returnMesophilicBacteria());
                    else
                        event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation().toCenterLocation(), new ItemStack(Material.DIRT));
                } else if(event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2)
                {
                    if(RNG < 0.25)
                        event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation().toCenterLocation(), bacteriaCreate.returnMesophilicBacteria());
                    else
                        event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation().toCenterLocation(), new ItemStack(Material.DIRT));
                }
                else if(event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3)
                {
                    event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation().toCenterLocation(), bacteriaCreate.returnMesophilicBacteria());
                }

            }
        }
    }
}
