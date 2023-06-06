package me.schmeb.cheesemaking.EventChecker;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;

public class CheckIfAnyEntityCollides {
    public boolean isClear(Block barrel){
        // Checks if there is a block occupying above the barrel
        if(barrel.getRelative(BlockFace.UP).getType() != Material.AIR)
            return false;

        // Checks if there is an armor stand present within the radius (if barrel is already a cheese barrel)
        return barrel.getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2).isEmpty();
    }
}
