package me.schmeb.cheesemaking.CheeseBarrelFunctions;

import me.schmeb.cheesemaking.CheeseMaking;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.function.Consumer;

public class CheeseStamp {
    public static Consumer<ItemMeta> stampNormal = meta ->
            meta.getPersistentDataContainer().set(
                    new NamespacedKey(CheeseMaking.getInstance(), "normal_cheese"),
                    PersistentDataType.STRING,
                    "DATA"
            );

    public static Consumer<ItemMeta> stampGreat = meta ->
            meta.getPersistentDataContainer().set(
                    new NamespacedKey(CheeseMaking.getInstance(), "great_cheese"),
                    PersistentDataType.STRING,
                    "DATA"
            );
}
