package me.schmeb.cheesemaking.CheeseClasses;

import me.schmeb.cheesemaking.CheeseBarrelFunctions.CheeseStamp;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public enum GoodCheese {
    PULE(0),
    ROQUEFORT(1);
    final int id;

    GoodCheese(int id) {
        this.id = id;
    }

    public void setItemMeta(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();

        switch (id) {
            case 0:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&d&lPule"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&ePule cheese has a crumbly texture and a pale yellow to"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&ewhite color. Its flavor is described as mild and slightly sweet,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&ewith a hint of grass. Due to its rarity and the specialized"));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eproduction method, Pule cheese is considered a luxury item"));
                break;
            case 1:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&d&lRoquefort"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eCreamy, moist, and crumbly. Its flavor is robust, sharp,"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand slightly salty, with pronounced earthy and tangy notes."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&ecommonly enjoyed on its own or served with bread, crackers, or fruits."));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt adds depth and richness to salads, dressings, and sauces."));
                break;
            default:
                break;
        }
        CheeseStamp.stampGreat.accept(itemMeta);
        itemMeta.lore(lore);
        item.setItemMeta(itemMeta);
    }
}
