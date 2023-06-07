package me.schmeb.cheesemaking;

import me.schmeb.cheesemaking.BacteriaFunctions.BacteriaCreate;
import me.schmeb.cheesemaking.BacteriaFunctions.CurdleCreate;
import me.schmeb.cheesemaking.CheeseBarrelFunctions.CheeseTableMesophilic;
import me.schmeb.cheesemaking.CheeseBarrelFunctions.CreateCheeseBarrel;
import me.schmeb.cheesemaking.EventChecker.CheckIfAnyEntityCollides;
import me.schmeb.cheesemaking.EventChecker.CheckLocationOfShovel;
import me.schmeb.cheesemaking.EventChecker.IsCheeseBarrel;
import me.schmeb.cheesemaking.EventListeners.*;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class CheeseMaking extends JavaPlugin {
    public static CheeseMaking instance;
    private final NamespacedKey cheeseBarrelKey = new NamespacedKey(this, "cheese_barrel");
    private final NamespacedKey mesophilicCheeseCurdles = new NamespacedKey(this, "mesophilic_cheese_curdles");
    private final NamespacedKey mesophilicBacteria = new NamespacedKey(this, "mesophilic_bacteria");
    private final NamespacedKey normalCheese = new NamespacedKey(this, "normal_cheese");
    private final NamespacedKey greatCheese = new NamespacedKey(this, "great_cheese");

    @Override
    public void onEnable() {
        instance = this;
        CheckIfAnyEntityCollides checkIfAnyEntityCollides = new CheckIfAnyEntityCollides();
        CheckLocationOfShovel checker = new CheckLocationOfShovel();
        CreateCheeseBarrel barrelCreator = new CreateCheeseBarrel(checkIfAnyEntityCollides);
        IsCheeseBarrel isCheeseBarrel = new IsCheeseBarrel(cheeseBarrelKey);
        CheeseTableMesophilic table = new CheeseTableMesophilic();
        CurdleCreate curdleCreate = new CurdleCreate(mesophilicCheeseCurdles, mesophilicBacteria);
        BacteriaCreate bacteriaCreate = new BacteriaCreate(mesophilicBacteria);

        getServer().getPluginManager().registerEvents(new ShovelDropListener(checker, barrelCreator), this);
        getServer().getPluginManager().registerEvents(new OnCheeseBarrelBreak(), this);
        getServer().getPluginManager().registerEvents(new OnCurdlePlace(table, mesophilicCheeseCurdles, cheeseBarrelKey), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClick(isCheeseBarrel), this);
        getServer().getPluginManager().registerEvents(new HopperPlaceCancel(), this);
        getServer().getPluginManager().registerEvents(new OnIngredientsCompile(curdleCreate, mesophilicBacteria), this);
        getServer().getPluginManager().registerEvents(new onMyceliumBreak(bacteriaCreate), this);
        getServer().getPluginManager().registerEvents(new OnBeetrootHarvest(bacteriaCreate), this);
        getServer().getPluginManager().registerEvents(new OnCheeseConsume(normalCheese, greatCheese), this);
    }
    @Override
    public void onDisable() {
        instance = null;
    }

    public static CheeseMaking getInstance(){
        return instance;
    }
}
