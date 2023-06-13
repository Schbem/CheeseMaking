package me.schmeb.cheesemaking.BacteriaFunctions;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CurdleCreate {
    private final NamespacedKey mesophilicCheeseCurdles;
    private final NamespacedKey mesophilicBacteria;

    public CurdleCreate(NamespacedKey mesophilicCheeseCurdles, NamespacedKey mesophilicBacteria) {
        this.mesophilicCheeseCurdles = mesophilicCheeseCurdles;
        this.mesophilicBacteria = mesophilicBacteria;
    }
    public void createBacteria(Player player, Location location) {
        location.getNearbyEntitiesByType(Item.class, 1, 1, 1).stream()
                .filter(entity -> entity.getItemStack().getType() == Material.MILK_BUCKET ||
                        entity.getItemStack().getType() == Material.BOWL ||
                        entity.getItemStack().getItemMeta().getPersistentDataContainer().has(mesophilicBacteria) ||
                        NBTEditor.contains(entity.getItemStack(), "bacteria"))
                .forEach(Entity::remove);

        ItemStack curdles = new ItemStack(Material.SUSPICIOUS_STEW);
        ItemMeta itemMeta = curdles.getItemMeta();
        itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&l&eMesophilic Cheese Curdles"));
        itemMeta.getPersistentDataContainer().set(
                mesophilicCheeseCurdles,
                PersistentDataType.STRING,
                "MESOPHILIC"
        );
        curdles.setItemMeta(itemMeta);

        location.getWorld().dropItem(location, curdles);
        location.getWorld().dropItem(location, new ItemStack(Material.BUCKET));
        player.playSound(player, Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
    }
}
