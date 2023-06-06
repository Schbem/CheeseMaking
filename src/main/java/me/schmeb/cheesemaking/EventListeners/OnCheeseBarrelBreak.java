package me.schmeb.cheesemaking.EventListeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OnCheeseBarrelBreak implements Listener {
    @EventHandler
    public void onBarrelDestroy(BlockBreakEvent event){
        Block block = event.getBlock();

        if(block.getType() == Material.BARREL)
        {
            block.getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2).forEach(entity -> {
                entity.remove();
                event.getPlayer().getWorld().dropItem(entity.getLocation(), new ItemStack(Material.GOLDEN_SHOVEL));
            });
        }
    }
}
