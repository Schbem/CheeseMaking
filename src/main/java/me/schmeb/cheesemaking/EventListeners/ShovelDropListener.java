package me.schmeb.cheesemaking.EventListeners;

import me.schmeb.cheesemaking.CheeseBarrelFunctions.CreateCheeseBarrel;
import me.schmeb.cheesemaking.CheeseMaking;
import me.schmeb.cheesemaking.EventChecker.CheckLocationOfShovel;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ShovelDropListener implements Listener {
    CheckLocationOfShovel checker;
    CreateCheeseBarrel barrelCreator;
    public ShovelDropListener(CheckLocationOfShovel checker, CreateCheeseBarrel barrelCreator){
        this.checker = checker;
        this.barrelCreator = barrelCreator;
    }
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        Item item = event.getItemDrop();
        if(item.getItemStack().getType() != Material.GOLDEN_SHOVEL) return;
        new BukkitRunnable(){
            @Override
            public void run() {
                if(checker.checkIfLocationIsValid(item))
                {
                    barrelCreator.createBarrel(item.getLocation().getBlock().getRelative(BlockFace.DOWN), event.getPlayer(), item);
                }
            }
        }.runTaskLater(CheeseMaking.getInstance(), 6);
    }
}
