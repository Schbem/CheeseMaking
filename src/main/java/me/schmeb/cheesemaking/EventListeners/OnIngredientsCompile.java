package me.schmeb.cheesemaking.EventListeners;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import me.schmeb.cheesemaking.BacteriaFunctions.CurdleCreate;
import me.schmeb.cheesemaking.CheeseMaking;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class OnIngredientsCompile implements Listener {
    CurdleCreate curdleCreate;
    private final NamespacedKey mesophilicBacteria;

    public OnIngredientsCompile(CurdleCreate curdleCreate, NamespacedKey mesophilicBacteria){
        this.curdleCreate = curdleCreate;
        this.mesophilicBacteria = mesophilicBacteria;
    }
    @EventHandler
    public void onIngredientsMix(PlayerDropItemEvent event){
        if(event.getItemDrop().getItemStack().getType() == Material.MILK_BUCKET ||
                event.getItemDrop().getItemStack().getType() == Material.BOWL ||
                event.getItemDrop().getItemStack().getItemMeta().getPersistentDataContainer().has(mesophilicBacteria)) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Block blockUnder = event.getItemDrop().getLocation().getBlock();
                    if(blockUnder.getType() == Material.CAULDRON && blockUnder.getRelative(BlockFace.DOWN).getType() == Material.CAMPFIRE) {
                        boolean hasMilk = event.getItemDrop().getLocation().getNearbyEntitiesByType(Item.class, 1, 1, 1).stream()
                                .anyMatch(entity -> entity.getItemStack().getType() == Material.MILK_BUCKET);

                        boolean hasBowl = event.getItemDrop().getLocation().getNearbyEntitiesByType(Item.class, 1, 1, 1).stream()
                                .anyMatch(entity -> entity.getItemStack().getType() == Material.BOWL);

                        boolean hasBacteria = event.getItemDrop().getLocation().getNearbyEntitiesByType(Item.class, 1, 1, 1).stream()
                                .anyMatch(entity -> entity.getItemStack().getItemMeta().getPersistentDataContainer().has(mesophilicBacteria)
                                        || NBTEditor.contains(entity.getItemStack(), "bacteria"));

                        if(hasMilk && hasBowl && hasBacteria) {
                            curdleCreate.createBacteria(event.getPlayer(), event.getItemDrop().getLocation());
                        }
                    }
                }
            }.runTaskLater(CheeseMaking.getInstance(), 10);
        }
    }
}
