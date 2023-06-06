package me.schmeb.cheesemaking.EventChecker;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Barrel;
import org.bukkit.block.TileState;

public class IsCheeseBarrel {
    private final NamespacedKey cheeseBarrelKey;

    public IsCheeseBarrel(NamespacedKey cheeseBarrelKey){
        this.cheeseBarrelKey = cheeseBarrelKey;
    }

    //checks if the cheese barrel contains persistent data referring to "cheese_barrel"
    public boolean containsCheeseBarrelKeyword(Barrel barrel){
        TileState barrelTileState = (TileState) barrel.getBlock().getState();
        return barrelTileState.getPersistentDataContainer().has(cheeseBarrelKey);
    }
}
