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
        double RNG = random.nextDouble();

        if(RNG < 0.15)
        {
            rottenCheese = new RottenCheese();
            item = rottenCheese.getItem();
        }
        else if(RNG > 0.15 && RNG < 0.20)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.BRIE.setItemMeta(item);
        }
        else if(RNG > 0.20 && RNG < 0.25)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.CAMEMBERT.setItemMeta(item);
        }
        else if(RNG > 0.25 && RNG < 0.30)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.RICOTTA.setItemMeta(item);
        }
        else if(RNG > 0.30 && RNG < 0.35)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.FETA.setItemMeta(item);
        }
        else if(RNG > 0.35 && RNG < 0.40)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.CHEDDAR.setItemMeta(item);
        }
        else if(RNG > 0.40 && RNG < 0.45)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.MOZZARELLA.setItemMeta(item);
        }
        else if(RNG > 0.45 && RNG < 0.50)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.PARMESAN.setItemMeta(item);
        }
        else if(RNG > 0.50 && RNG < 0.55)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.CREAM_CHEESE.setItemMeta(item);
        }
        else if(RNG > 0.55 && RNG < 0.60)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.STILTON.setItemMeta(item);
        }
        else if(RNG > 0.60 && RNG < 0.65)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.GOUDA.setItemMeta(item);
        }
        else if(RNG > 0.65 && RNG < 0.70)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.APPENZELLER.setItemMeta(item);
        }
        else if(RNG > 0.70 && RNG < 0.75)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.COTTAGE_CHEESE.setItemMeta(item);
        }
        else if(RNG > 0.75 && RNG < 0.80)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.CHEVRE.setItemMeta(item);
        }
        else if(RNG > 0.80 && RNG < 0.85)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.ROMANO.setItemMeta(item);
        }
        else if(RNG > 0.85 && RNG < 0.90)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            NormalCheese.MONTEREY_JACK.setItemMeta(item);
        }
        else if(RNG > 0.90 && RNG < 0.95)
        {
            item = new ItemStack(Material.APPLE);
            NormalCheese.EDAM.setItemMeta(item);
        }
        else if(RNG > 0.95 && RNG < 0.975)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            GoodCheese.PULE.setItemMeta(item);
        }
        else if(RNG > 0.975)
        {
            item = new ItemStack(Material.PUMPKIN_PIE);
            GoodCheese.ROQUEFORT.setItemMeta(item);
        }
        else
        {
            rottenCheese = new RottenCheese();
            item = rottenCheese.getItem();
        }
        return item;
    }
}
