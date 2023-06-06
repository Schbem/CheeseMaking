package me.schmeb.cheesemaking.EventChecker;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;

public class CheckLocationOfShovel {
    public boolean checkIfLocationIsValid(Item item){
        return item.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BARREL;
    }
}
