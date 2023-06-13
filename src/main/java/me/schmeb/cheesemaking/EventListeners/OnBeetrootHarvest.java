package me.schmeb.cheesemaking.EventListeners;

import me.schmeb.cheesemaking.BacteriaFunctions.BacteriaCreate;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OnBeetrootHarvest implements Listener {
    private final BacteriaCreate bacteriaCreate;

    public OnBeetrootHarvest(BacteriaCreate bacteriaCreate) {
        this.bacteriaCreate = bacteriaCreate;
    }
    @EventHandler
    public void onHarvest(BlockBreakEvent event) {
        ItemStack isHoldingBowl = event.getPlayer().getInventory().getItemInMainHand();

        if(event.getBlock().getType() == Material.BEETROOTS && isHoldingBowl.getType() == Material.BOWL) {
            Ageable ageable = (Ageable) event.getBlock().getBlockData();
            if(ageable.getAge() != ageable.getMaximumAge()) return;

            Block block = event.getBlock();
            bacteriaCreate.returnMesophilicBacteria(block.getLocation());
        }
    }
}
