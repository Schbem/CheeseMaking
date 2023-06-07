package me.schmeb.cheesemaking.CheeseBarrelFunctions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.block.Barrel;
import org.bukkit.entity.ArmorStand;

public class ChangeBarrelStatus {
    public static void changeToIdle(Barrel barrel){
        barrel.getBlock().getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2)
                .forEach(entity -> entity.customName(Component.text("IDLE", NamedTextColor.RED)));
    }

    public static void changeToFermenting(Barrel barrel){
        barrel.getBlock().getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2)
                .forEach(entity -> entity.customName(Component.text("Fermenting...", NamedTextColor.YELLOW)));
    }

    public static void changeToDone(Barrel barrel){
        barrel.getBlock().getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2)
                .forEach(entity -> entity.customName(Component.text("DONE", NamedTextColor.GREEN)));
    }
}
