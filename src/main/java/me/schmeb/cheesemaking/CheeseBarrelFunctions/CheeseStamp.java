package me.schmeb.cheesemaking.CheeseBarrelFunctions;

import me.schmeb.cheesemaking.CheeseMaking;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CheeseStamp {
    public static void stampNormal(ItemMeta itemMeta){
        itemMeta.getPersistentDataContainer().set(
                new NamespacedKey(CheeseMaking.getInstance(), "normal_cheese"),
                PersistentDataType.STRING,
                "DATA"
        );
    }

    public static void stampGreat(ItemMeta itemMeta){
        itemMeta.getPersistentDataContainer().set(
                new NamespacedKey(CheeseMaking.getInstance(), "great_cheese"),
                PersistentDataType.STRING,
                "DATA"
        );
    }
}
