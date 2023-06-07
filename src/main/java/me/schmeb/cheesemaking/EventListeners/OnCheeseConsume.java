package me.schmeb.cheesemaking.EventListeners;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnCheeseConsume implements Listener {
    NamespacedKey normalCheese;
    NamespacedKey greatCheese;

    public OnCheeseConsume(NamespacedKey normalCheese, NamespacedKey greatCheese) {
        this.normalCheese = normalCheese;
        this.greatCheese = greatCheese;
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        ItemMeta itemMeta = event.getItem().getItemMeta();
        Player player = event.getPlayer();

        if(itemMeta.getPersistentDataContainer().has(normalCheese))
        {
            player.setFoodLevel(player.getFoodLevel() + 2);
        }

        if(itemMeta.getPersistentDataContainer().has(greatCheese))
        {
            player.setFoodLevel(player.getFoodLevel() + 4);
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*20, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120*20, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 5*20, 0));
        }
    }
}
