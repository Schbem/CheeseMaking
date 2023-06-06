package me.schmeb.cheesemaking.EventListeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class HopperPlaceCancel implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onHopperPlace(BlockPlaceEvent event){
        if(event.getBlock().getType() == Material.HOPPER) event.setCancelled(true);
    }
}
