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

    GoodCheese(int id){
        this.id = id;
    }

    public void setItemMeta(ItemStack item){
        ItemMeta itemMeta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();

        switch (id){
            case 0:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&d&lPule"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&ePule cheese has a crumbly texture and a pale yellow to white color."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIts flavor is described as mild and slightly sweet, with a hint of grassiness."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eDue to its rarity and the specialized production method, Pule cheese is considered a luxury item"));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand is one of the most expensive cheeses in the world."));
                break;
            case 1:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&d&lRoquefort"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eCreamy, moist, and crumbly. Its flavor is robust, sharp, and slightly salty,"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&ewith pronounced earthy and tangy notes."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&ecommonly enjoyed on its own or served with bread, crackers, or fruits."));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt adds depth and richness to salads, dressings, and sauces."));
                break;
            default:
                break;
        }
        CheeseStamp.stampGreat(itemMeta);
        itemMeta.lore(lore);
        item.setItemMeta(itemMeta);
    }
}
