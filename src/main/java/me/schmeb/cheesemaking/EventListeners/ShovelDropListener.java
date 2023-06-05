package me.schmeb.cheesemaking.EventListeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ShovelDropListener implements Listener {
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        if(event.getItemDrop().getItemStack().getType() != Material.GOLDEN_SHOVEL) return;
    }
}
