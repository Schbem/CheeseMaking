package me.schmeb.cheesemaking.EventListeners;

import me.schmeb.cheesemaking.CheeseBarrelFunctions.ChangeBarrelStatus;
import me.schmeb.cheesemaking.CheeseBarrelFunctions.CheeseTableMesophilic;
import me.schmeb.cheesemaking.CheeseMaking;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Barrel;
import org.bukkit.block.TileState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Objects;

public class OnCurdlePlace implements Listener {
    CheeseTableMesophilic table;
    private final NamespacedKey mesophilicCheeseCurdles;
    private final NamespacedKey cheeseBarrelKey;

    public OnCurdlePlace(CheeseTableMesophilic table, NamespacedKey mesophilicCheeseCurdles, NamespacedKey cheeseBarrelKey){
        this.table = table;
        this.mesophilicCheeseCurdles = mesophilicCheeseCurdles;
        this.cheeseBarrelKey = cheeseBarrelKey;
    }

    @EventHandler
    public void onPlace(InventoryCloseEvent event){
        if(Arrays.stream(event.getInventory().getStorageContents()).filter(Objects::nonNull).anyMatch(item ->
                item.getType() == Material.SUSPICIOUS_STEW && item.getItemMeta().getPersistentDataContainer().has(mesophilicCheeseCurdles)))
        {
            if(event.getInventory().getHolder() instanceof Barrel){
                Barrel barrel = (Barrel) event.getInventory().getHolder();
                TileState barrelTileState = (TileState) barrel.getBlock().getState();

                if(barrelTileState.getPersistentDataContainer().has(cheeseBarrelKey)){
                    ChangeBarrelStatus.changeToFermenting(barrel);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(Arrays.stream(event.getInventory().getStorageContents()).filter(Objects::nonNull).anyMatch(item -> item.getType() == Material.SUSPICIOUS_STEW)){
                                ChangeBarrelStatus.changeToDone(barrel);
                                event.getInventory().clear();
                                event.getInventory().setItem(0, table.getCheeseMesophilic());
                                event.getInventory().setItem(1, new ItemStack(Material.BOWL));
                            }
                        }
                    }.runTaskLater(CheeseMaking.getInstance(), 10*20);
                }
            }
        }else{
            if(event.getInventory().getHolder() instanceof Barrel){
                Barrel barrel = (Barrel) event.getInventory().getHolder();
                TileState barrelTileState = (TileState) barrel.getBlock().getState();

                if(barrelTileState.getPersistentDataContainer().has(cheeseBarrelKey)){
                    ChangeBarrelStatus.changeToIdle(barrel);
                }
            }
        }
    }
}
