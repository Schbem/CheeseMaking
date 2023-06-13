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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Objects;

public class OnCurdlePlace implements Listener {
    CheeseTableMesophilic table;
    private final NamespacedKey mesophilicCheeseCurdles;
    private final NamespacedKey cheeseBarrelKey;

    public OnCurdlePlace(CheeseTableMesophilic table, NamespacedKey mesophilicCheeseCurdles, NamespacedKey cheeseBarrelKey) {
        this.table = table;
        this.mesophilicCheeseCurdles = mesophilicCheeseCurdles;
        this.cheeseBarrelKey = cheeseBarrelKey;
    }

    @EventHandler
    public void onPlace(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if(Arrays.stream(inventory.getStorageContents())
                .filter(Objects::nonNull)
                .filter(ItemStack::hasItemMeta)
                .anyMatch(item -> item.getItemMeta().getPersistentDataContainer().has(mesophilicCheeseCurdles))) {
            if(inventory.getHolder() instanceof Barrel) {
                Barrel barrel = (Barrel) inventory.getHolder();
                TileState barrelTileState = (TileState) barrel.getBlock().getState();

                if(barrelTileState.getPersistentDataContainer().has(cheeseBarrelKey)) {
                    ChangeBarrelStatus.changeToFermenting.accept(barrel);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(Arrays.stream(inventory.getStorageContents())
                                    .filter(Objects::nonNull)
                                    .anyMatch(item -> item.getItemMeta().getPersistentDataContainer().has(mesophilicCheeseCurdles))) {

                                ChangeBarrelStatus.changeToDone.accept(barrel);
                                event.getInventory().clear();
                                event.getInventory().setItem(0, table.getCheeseMesophilic());
                                event.getInventory().setItem(1, new ItemStack(Material.BOWL));
                            }
                        }
                    }.runTaskLater(CheeseMaking.getInstance(), 1800*20);
                }
            }
        }else{
            if(inventory.getHolder() instanceof Barrel) {
                Barrel barrel = (Barrel) inventory.getHolder();
                TileState barrelTileState = (TileState) barrel.getBlock().getState();

                if(barrelTileState.getPersistentDataContainer().has(cheeseBarrelKey)) {
                    ChangeBarrelStatus.changeToIdle.accept(barrel);
                }
            }
        }
    }
}
