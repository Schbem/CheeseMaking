package me.schmeb.cheesemaking.CheeseClasses;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RottenCheese{
    List<Component> lore;
    ItemStack item;

    public RottenCheese(){
        item = new ItemStack(Material.ROTTEN_FLESH);

        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lStrange Cheese"));

        lore = new ArrayList<>();
        lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eDefinitely safe to eat"));
        itemMeta.lore(lore);

        item.setItemMeta(itemMeta);
    }

    public ItemStack getItem() {
        return item;
    }
}
