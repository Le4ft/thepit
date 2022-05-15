package com.alpha.redux.gems;

import com.alpha.redux.apis.advancedInventory;
import com.alpha.redux.items.enchants;
import com.alpha.redux.well.EnchantingMechanics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.alpha.redux.gems.gemMain.*;
import static com.alpha.redux.well.EnchantingMechanics.getUpgradeableEnchants;

public class gemEvents {

    private static HashMap<String, ItemStack> storedMystic = new HashMap<>();

    public static void gemClickEvent(InventoryClickEvent event){
        gemRunTime(event);
        acceptMenu(event);



    }

    public static void gemRunTime(InventoryClickEvent event){
        if(event == null) return;
        if(event.getClickedInventory().getTitle() == null) return;
        if(event.getClickedInventory().getTitle().equals(ChatColor.GRAY + "Totally Legit Gem")){
            event.setCancelled(true);

            ItemStack base_glass = advancedInventory.cGlass();

            if(event.getCurrentItem() != null){
                if(event.getCurrentItem().getType() != base_glass.getType()){
                    storedMystic.put(String.valueOf(event.getWhoClicked().getUniqueId()), event.getCurrentItem());
                    if(storedMystic.get(String.valueOf(event.getWhoClicked().getUniqueId())).getItemMeta().getLore().get(0).contains(ChatColor.GREEN + "♦")){
                        event.getWhoClicked().sendMessage(ChatColor.RED + "You can't gem this item!");
                        return;
                    }
                    event.getWhoClicked().openInventory(confirmationGui((Player) event.getWhoClicked()));
                }

            }
        }
    }

    public static void acceptMenu(InventoryClickEvent event){
        if(event == null) return;
        if(event.getClickedInventory().getTitle() == null) return;
        if(event.getClickedInventory().getTitle().equals(ChatColor.GRAY + "Confirm or Cancel")) {

            if(event.getCurrentItem().equals(confirmButton)){
                ItemStack mystic = storedMystic.get(String.valueOf(event.getWhoClicked().getUniqueId()));
                event.getWhoClicked().getInventory().removeItem(mystic);

                ItemMeta mysticMeta = mystic.getItemMeta();

                List<String> lore = null;

                List<String> upgrades = null;
                if(mystic.getType().equals(Material.GOLD_SWORD)) upgrades = getUpgradeableEnchants(mysticMeta.getLore(), "SWORD");
                if(mystic.getType().equals(Material.LEATHER_LEGGINGS)) upgrades = getUpgradeableEnchants(mysticMeta.getLore(), "PANT");
                assert upgrades != null;
                Collections.shuffle(upgrades);

                if(mystic.getType().equals(Material.GOLD_SWORD)) lore = new EnchantingMechanics(mysticMeta.getLore(), upgrades.get(0), .50, .75, "SWORD").getLore();

                if(mystic.getType().equals(Material.LEATHER_LEGGINGS)) lore = new EnchantingMechanics(mysticMeta.getLore(), upgrades.get(0), .50, .75, "PANT").getLore();

                assert lore != null;
                lore.set(0, lore.get(0) + ChatColor.GREEN + " ♦");

                mysticMeta.setLore(lore);
                mystic.setItemMeta(mysticMeta);

                event.getWhoClicked().sendMessage(ChatColor.GRAY + "Mystic Item successfully upgraded!");
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().getInventory().removeItem(enchants.gem);
                event.getWhoClicked().getInventory().addItem(mystic);


            }else if(event.getCurrentItem().equals(cancelButton)) {
                event.getWhoClicked().closeInventory();
            }

            event.setCancelled(true);
        }
    }
}
