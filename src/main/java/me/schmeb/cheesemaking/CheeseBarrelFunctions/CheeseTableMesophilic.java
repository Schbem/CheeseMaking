package me.schmeb.cheesemaking.CheeseBarrelFunctions;

import me.schmeb.cheesemaking.CheeseClasses.GoodCheese;
import me.schmeb.cheesemaking.CheeseClasses.NormalCheese;
import me.schmeb.cheesemaking.CheeseClasses.RottenCheese;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CheeseTableMesophilic {
    RottenCheese rottenCheese;
    public ItemStack getCheeseMesophilic(){
        ItemStack item;
        Random random = new Random();
        int probability = random.nextInt(20);

        switch (probability){
            case 3:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.BRIE.setItemMeta(item);
                break;
            case 4:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.CAMEMBERT.setItemMeta(item);
                break;
            case 5:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.RICOTTA.setItemMeta(item);
                break;
            case 6:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.FETA.setItemMeta(item);
                break;
            case 7:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.CHEDDAR.setItemMeta(item);
                break;
            case 8:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.MOZZARELLA.setItemMeta(item);
                break;
            case 9:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.PARMESAN.setItemMeta(item);
                break;
            case 10:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.CREAM_CHEESE.setItemMeta(item);
                break;
            case 11:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.STILTON.setItemMeta(item);
                break;
            case 12:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.GOUDA.setItemMeta(item);
                break;
            case 13:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.APPENZELLER.setItemMeta(item);
                break;
            case 14:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.COTTAGE_CHEESE.setItemMeta(item);
                break;
            case 15:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.CHEVRE.setItemMeta(item);
                break;
            case 16:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.ROMANO.setItemMeta(item);
                break;
            case 17:
                item = new ItemStack(Material.PUMPKIN_PIE);
                NormalCheese.MONTEREY_JACK.setItemMeta(item);
                break;
            case 18:
                item = new ItemStack(Material.APPLE);
                NormalCheese.EDAM.setItemMeta(item);
                break;
            case 19:
                if(random.nextInt(2) == 0) {
                    item = new ItemStack(Material.PUMPKIN_PIE);
                    GoodCheese.PULE.setItemMeta(item);
                }else {
                    item = new ItemStack(Material.PUMPKIN_PIE);
                    GoodCheese.ROQUEFORT.setItemMeta(item);
                }
                break;
            default:
                rottenCheese = new RottenCheese();
                item = rottenCheese.getItem();
                break;
        }
        return item;
    }
}
