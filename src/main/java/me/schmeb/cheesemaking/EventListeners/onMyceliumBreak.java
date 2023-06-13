package me.schmeb.cheesemaking.EventListeners;

import me.schmeb.cheesemaking.BacteriaFunctions.BacteriaCreate;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class onMyceliumBreak implements Listener {
    BacteriaCreate bacteriaCreate;
    public onMyceliumBreak(BacteriaCreate bacteriaCreate) {
        this.bacteriaCreate = bacteriaCreate;
    }

    @EventHandler
    public void onMyceliumBreakEvent(BlockBreakEvent event){
        if(event.getBlock().getType() == Material.MYCELIUM) {
            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
            if(item.containsEnchantment(Enchantment.SILK_TOUCH)) return;

            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                Random random = new Random();
                double RNG = random.nextDouble();
                Location blockLocation = event.getBlock().getLocation();

                switch (item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)) {
                    case 1:
                        if(RNG < 0.15) {
                            event.setDropItems(false);
                            bacteriaCreate.returnMesophilicBacteria(blockLocation);
                        }
                        break;
                    case 2:
                        if(RNG < 0.25) {
                            event.setDropItems(false);
                            bacteriaCreate.returnMesophilicBacteria(blockLocation);
                        }
                        break;
                    case 3:
                        event.setDropItems(false);
                        bacteriaCreate.returnMesophilicBacteria(blockLocation);
                        break;
                    default:
                        if(RNG < 0.1) {
                            event.setDropItems(false);
                            bacteriaCreate.returnMesophilicBacteria(blockLocation);
                        }
                        break;
                }
            }
        }
    }
}
