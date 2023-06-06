package me.schmeb.cheesemaking.CheeseClasses;

import me.schmeb.cheesemaking.CheeseBarrelFunctions.CheeseStamp;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public enum NormalCheese {
    BRIE(0),
    CAMEMBERT(1),
    RICOTTA(2),
    FETA(3),
    CHEDDAR(4),
    MOZZARELLA(5),
    PARMESAN(6),
    CREAM_CHEESE(7),
    STILTON(8),
    GOUDA(9),
    APPENZELLER(10),
    COTTAGE_CHEESE(11),
    CHEVRE(12),
    ROMANO(13),
    MONTEREY_JACK(14),
    EDAM(15);

    final int id;
    NormalCheese(int id){
        this.id = id;
    }

    public void setItemMeta(ItemStack item){
        ItemMeta itemMeta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();

        switch (id){
            case 0:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lBrie"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eA type of cheese made from cow's milk,"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eThis cheese has a soft texture and a light color,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eoften displaying a delicate white mold on its surface,"));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&ewhich may have a faint hint of gray."));
                break;
            case 1:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lCamembert"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eCow's milk cheese that is moist, soft, and creamy,"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand it undergoes surface ripening."));
                break;
            case 2:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lRicotta"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eMade from the whey leftover during the production of other cheeses,"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eoften used in both sweet and savory dishes,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eincluding pasta fillings, desserts, and breakfast recipes."));
                break;
            case 3:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lFeta"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eTraditionally made from sheep's milk or a combination of sheep's and goat's milk."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eFeta cheese has a crumbly texture and a tangy, salty flavor."));
                break;
            case 4:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lCheddar"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is a firm to hard cheese that is typically made from cow's milk."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eCheddar cheese has a rich, creamy flavor that becomes sharper and more complex as it ages."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt has a smooth and dense texture with a slightly crumbly consistency."));
                break;
            case 5:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lMozzarella"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eThe cheese is typically white in color and has a mild, slightly tangy flavor."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eMozzarella cheese is commonly used in Italian cuisine,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eespecially in dishes such as pizza, lasagna, and caprese salad."));
                break;
            case 6:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lParmesan"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is made from cow's milk and has a granular texture with a rich, nutty flavor."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eParmesan cheese is aged for a minimum of 12 months,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand some varieties are aged for even longer periods, which intensifies its flavor."));
                break;
            case 7:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lCream Cheese"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eSoft, spreadable cheese with a smooth and creamy texture."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is made from cow's milk and is known for its mild, slightly tangy flavor."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eCream cheese is commonly used as a spread"));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eon bagels, toast, crackers, and sandwiches."));
                break;
            case 8:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lStilton"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eDistinct blue veins and crumbly texture."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eStilton cheese is typically made from pasteurized cow's milk and has a rich,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&ecreamy flavor with a tangy and slightly salty taste."));
                break;
            case 9:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lGouda"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is a semi-hard cheese made from cow's milk"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand is known for its rich, creamy flavor and smooth texture."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eThe cheese is aged for varying periods, which influences its taste and texture."));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eYoung Gouda has a mild and buttery flavor."));
                break;
            case 10:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lAppenzeller"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is a semi-hard cheese made from cow's milk"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand is renowned for its robust flavor and distinctive aroma."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&ePale yellow to golden color and a smooth, firm texture."));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is often characterized by small, uneven holes called 'eyes.'"));
                break;
            case 11:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lCottage Cheese"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eFresh cheese that is made from the curds of cow's milk."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt has a mild flavor and a creamy, slightly lumpy texture."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eThe texture of cottage cheese is characterized by small curds,"));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&ewhich give it a grainy and slightly chunky consistency."));
                break;
            case 12:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lChevre"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is characterized by its distinct flavor, creamy texture,"));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand often has a slightly tart or tangy taste."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&ePairs well with fruits, vegetables, salads, and bread."));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is also a common ingredient in salads, pastas, pizzas, and appetizers."));
                break;
            case 13:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lRomano"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eRomano cheese has a pale yellow to ivory color and a firm, crumbly texture."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eRomano cheese is commonly used as a grating cheese."));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is often grated or shredded and sprinkled over"));
                lore.add(3, LegacyComponentSerializer.legacyAmpersand().deserialize("&epasta dishes, soups, salads, and vegetables to add a bold and savory taste."));
                break;
            case 14:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lMonterey Jack"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is a mild and creamy cheese known for its smooth texture and versatile flavor."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&eis mild and buttery, with a subtle tang. It is a popular choice for melting,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&emaking it ideal for use in various dishes."));
                break;
            case 15:
                itemMeta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize("&6&lEdam"));
                lore.add(0, LegacyComponentSerializer.legacyAmpersand().deserialize("&eIt is a semi-hard cheese known for its distinctive shape and mild, slightly nutty flavor."));
                lore.add(1, LegacyComponentSerializer.legacyAmpersand().deserialize("&emild and slightly tangy, with a subtle nuttiness. It has a firm but smooth texture,"));
                lore.add(2, LegacyComponentSerializer.legacyAmpersand().deserialize("&eand it becomes denser as it ages."));
                break;
            default:
                break;
        }
        CheeseStamp.stampNormal(itemMeta);
        itemMeta.lore(lore);
        item.setItemMeta(itemMeta);
    }
}
