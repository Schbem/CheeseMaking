package me.schmeb.cheesemaking.EventListeners;

import me.schmeb.cheesemaking.EventChecker.EventChecker;
import org.bukkit.block.Barrel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.Objects;

public class OnInventoryClick implements Listener {
    EventChecker eventChecker;

    public OnInventoryClick(EventChecker eventChecker) {
        this.eventChecker = eventChecker;
    }

    @EventHandler
    public void onCurdlePlaceInBarrel(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();

        if(inventory.getHolder() == null || event.getClickedInventory() == null) return;
        if(!(event.getInventory().getHolder() instanceof Barrel)) return;
        if(!(event.getClickedInventory().getType().equals(InventoryType.PLAYER))) return;

        Barrel barrel = (Barrel) event.getInventory().getHolder();

        if(eventChecker.containsCheeseBarrelKeyword(barrel)) {
            // Checks if there is at least one item in the barrel
            if(Arrays.stream(event.getInventory().getContents()).anyMatch(Objects::nonNull)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if(event.getInventory().getHolder() == null) return;
        if(!(event.getInventory().getHolder() instanceof Barrel)) return;
        Barrel barrel = (Barrel) event.getInventory().getHolder();

        if(eventChecker.containsCheeseBarrelKeyword(barrel)) {
            // Checks if there is at least one item in the cheese barrel
            if(Arrays.stream(event.getInventory().getContents()).anyMatch(Objects::nonNull))
                event.setCancelled(true);
        }
    }
}
