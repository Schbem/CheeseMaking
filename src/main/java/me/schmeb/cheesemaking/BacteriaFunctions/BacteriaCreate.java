package me.schmeb.cheesemaking.BacteriaFunctions;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

import static org.bukkit.persistence.PersistentDataType.STRING;

public class BacteriaCreate {
    private final NamespacedKey mesophilicBacteria;

    public BacteriaCreate(NamespacedKey mesophilicBacteria) {
        this.mesophilicBacteria = mesophilicBacteria;
    }

    public void returnMesophilicBacteria(Location blockLocation) {
        ItemStack bacteria = new ItemStack(Material.MELON_SEEDS);
        ItemMeta itemMeta = bacteria.getItemMeta();

        itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&d&lMesophilic Bacteria"));
        itemMeta.getPersistentDataContainer().set(
                mesophilicBacteria,
                STRING,
                "MESOPHILIC"
        );
        itemMeta.lore(Collections.singletonList(LegacyComponentSerializer.legacyAmpersand().deserialize("&e&oProduces ATP from Lactose")));
        bacteria.setItemMeta(itemMeta);

        blockLocation.getWorld().dropItem(blockLocation.toCenterLocation(), bacteria);
    }
}
