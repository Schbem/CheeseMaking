package me.schmeb.cheesemaking.EventChecker;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Barrel;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.TileState;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;

public class EventChecker {

    private final NamespacedKey cheeseBarrelKey;

    public EventChecker(NamespacedKey cheeseBarrelKey) {
        this.cheeseBarrelKey = cheeseBarrelKey;
    }
    public boolean isClear(Block barrel) {
        // Checks if there is a block occupying above the barrel
        if(barrel.getRelative(BlockFace.UP).getType() != Material.AIR) return false;

        // Checks if there is an armor stand present within the radius (if barrel is already a cheese barrel)
        return barrel.getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2).isEmpty();
    }

    public boolean checkIfLocationIsValid(Item item) {
        return item.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BARREL;
    }

    //checks if the cheese barrel contains persistent data referring to "cheese_barrel"
    public boolean containsCheeseBarrelKeyword(Barrel barrel) {
        TileState barrelTileState = (TileState) barrel.getBlock().getState();
        return barrelTileState.getPersistentDataContainer().has(cheeseBarrelKey);
    }
}
