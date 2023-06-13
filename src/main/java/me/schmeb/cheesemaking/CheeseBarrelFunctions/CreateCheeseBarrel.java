package me.schmeb.cheesemaking.CheeseBarrelFunctions;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import io.papermc.paper.math.Rotations;
import me.schmeb.cheesemaking.EventChecker.EventChecker;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class CreateCheeseBarrel {
    EventChecker eventChecker;
    private final NamespacedKey cheeseBarrelKey;

    public CreateCheeseBarrel(EventChecker eventChecker, NamespacedKey cheeseBarrelKey) {
        this.eventChecker = eventChecker;
        this.cheeseBarrelKey = cheeseBarrelKey;
    }
    public void createBarrel(Block barrel, Player player, Item item) {
        if(!eventChecker.isClear(barrel)) {
            player.sendMessage("Make sure the top of the barrel is clear or is not already a cheese barrel!");
            return;
        }

        //removes the shovel
        item.remove();

        TileState tileState = (TileState) barrel.getState();
        tileState.getPersistentDataContainer().set(
                cheeseBarrelKey,
                PersistentDataType.STRING,
                "PLACEHOLDER"
        );
        tileState.update();

        ItemStack skullItem = NBTEditor.getHead(
                "http://textures.minecraft.net/texture/68c57baeae2534a67ff7368905998ff6ce373ee6130ca20b63261b0f769e12ec");

        Location location = item.getLocation().toCenterLocation();
        location.setY(item.getLocation().getBlockY() - 0.9);

        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setDisabledSlots(
                EquipmentSlot.CHEST,
                EquipmentSlot.FEET,
                EquipmentSlot.HAND,
                EquipmentSlot.HEAD,
                EquipmentSlot.LEGS,
                EquipmentSlot.OFF_HAND
        );
        armorStand.setInvulnerable(true);
        armorStand.setInvisible(true);
        armorStand.setCanMove(false);

        armorStand.setRotation(0, 0);
        armorStand.setHeadRotations(Rotations.ofDegrees(180, 45, 0));

        EntityEquipment entityEquipment = armorStand.getEquipment();
        entityEquipment.setHelmet(skullItem);
        player.playSound(player, Sound.BLOCK_SCAFFOLDING_BREAK, 1, 0.5F);

        armorStand.customName(Component.text("IDLE", NamedTextColor.RED));
        armorStand.setCustomNameVisible(true);
    }
}
