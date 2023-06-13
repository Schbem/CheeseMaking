package me.schmeb.cheesemaking.CheeseBarrelFunctions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.block.Barrel;
import org.bukkit.entity.ArmorStand;

import java.util.function.Consumer;

public class ChangeBarrelStatus {
    public static Consumer<Barrel> changeToIdle = barrel ->
            barrel.getBlock().getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2)
                    .forEach(entity -> entity.customName(Component.text("IDLE", NamedTextColor.RED)));

    public static Consumer<Barrel> changeToFermenting = barrel ->
            barrel.getBlock().getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2)
                    .forEach(entity -> entity.customName(Component.text("Fermenting...", NamedTextColor.YELLOW)));

    public static Consumer<Barrel> changeToDone = barrel ->
            barrel.getBlock().getLocation().toCenterLocation().getNearbyEntitiesByType(ArmorStand.class, 0.2, 0.2, 0.2)
                    .forEach(entity -> entity.customName(Component.text("DONE", NamedTextColor.GREEN)));
}
