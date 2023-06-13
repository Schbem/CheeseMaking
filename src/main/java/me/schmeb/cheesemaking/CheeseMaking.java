package me.schmeb.cheesemaking;

import me.schmeb.cheesemaking.BacteriaFunctions.BacteriaCreate;
import me.schmeb.cheesemaking.BacteriaFunctions.CurdleCreate;
import me.schmeb.cheesemaking.CheeseBarrelFunctions.CheeseTableMesophilic;
import me.schmeb.cheesemaking.CheeseBarrelFunctions.CreateCheeseBarrel;
import me.schmeb.cheesemaking.EventChecker.EventChecker;
import me.schmeb.cheesemaking.EventListeners.*;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;
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
        registerListeners();
    }
    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerListeners() {
        EventChecker eventChecker = new EventChecker(cheeseBarrelKey);
        CreateCheeseBarrel barrelCreator = new CreateCheeseBarrel(eventChecker, cheeseBarrelKey);
        CheeseTableMesophilic table = new CheeseTableMesophilic();
        CurdleCreate curdleCreate = new CurdleCreate(mesophilicCheeseCurdles, mesophilicBacteria);
        BacteriaCreate bacteriaCreate = new BacteriaCreate(mesophilicBacteria);

        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new ShovelDropListener(eventChecker, barrelCreator), this);
        pluginManager.registerEvents(new OnCheeseBarrelBreak(), this);
        pluginManager.registerEvents(new OnCurdlePlace(table, mesophilicCheeseCurdles, cheeseBarrelKey), this);
        pluginManager.registerEvents(new OnInventoryClick(eventChecker), this);
        pluginManager.registerEvents(new HopperPlaceCancel(), this);
        pluginManager.registerEvents(new OnIngredientsCompile(curdleCreate, mesophilicBacteria), this);
        pluginManager.registerEvents(new onMyceliumBreak(bacteriaCreate), this);
        pluginManager.registerEvents(new OnBeetrootHarvest(bacteriaCreate), this);
        pluginManager.registerEvents(new OnCheeseConsume(normalCheese, greatCheese), this);
    }

    public static CheeseMaking getInstance() {
        return instance;
    }
}
