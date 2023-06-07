package me.schmeb.cheesemaking.BacteriaFunctions;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static org.bukkit.persistence.PersistentDataType.STRING;

public class BacteriaCreate {
    private final NamespacedKey mesophilicBacteria;

    public BacteriaCreate(NamespacedKey mesophilicBacteria){
        this.mesophilicBacteria = mesophilicBacteria;
    }

    public ItemStack returnMesophilicBacteria(){
        ItemStack bacteria = new ItemStack(Material.MELON_SEEDS);
        ItemMeta itemMeta = bacteria.getItemMeta();

        itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&d&lMesophilic Bacteria"));
        itemMeta.getPersistentDataContainer().set(
                mesophilicBacteria,
                STRING,
                "MESOPHILIC"
        );
        bacteria.setItemMeta(itemMeta);

        return bacteria;
    }
}
