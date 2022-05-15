package com.alpha.redux.renownShop;

import com.alpha.redux.apis.advancedInventory;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class shopGUI {
    public static Inventory mainMenu(Player player){
        
        Inventory gui = advancedInventory.inv(player, 36, ChatColor.YELLOW + "Renown Shop");
        
        ItemStack base_glass = advancedInventory.cGlass();

        ItemStack dmg_increase = RenownItems.DamageItemIncrease(String.valueOf(player.getUniqueId()));
        ItemStack dmg_decrease = RenownItems.DamageItemDecrease(String.valueOf(player.getUniqueId()));
        ItemStack xp_increase = RenownItems.XpItemIncrease(String.valueOf(player.getUniqueId()));
        ItemStack colorfulBox = RenownItems.Boxers();
        ItemStack pearl = RenownItems.CorruptedPearl();
        ItemStack uberDrop = RenownItems.UberDrop();
        ItemStack quest = RenownItems.QuesterKit();
        ItemStack scythe = RenownItems.ReaperScythe();
        ItemStack mystic = RenownItems.MysticismDropItem(String.valueOf(player.getUniqueId()));
        ItemStack atom = RenownItems.NuclearAtomizer();

        for (int i = 0; i < 10; i++) {
            advancedInventory.addInv(gui, base_glass, i, 1, false);
            advancedInventory.addInv(gui, base_glass, i, 2, false);
            advancedInventory.addInv(gui, base_glass, i, 3, false);
            advancedInventory.addInv(gui, base_glass, i, 4, false);
        }

        // First Row
        advancedInventory.addInv(gui, dmg_increase, 3, 2, false);
        advancedInventory.addInv(gui, xp_increase, 4, 2, false);
        advancedInventory.addInv(gui, pearl, 5, 2, false);
        advancedInventory.addInv(gui, dmg_decrease, 6, 2, false);
        advancedInventory.addInv(gui, colorfulBox, 7, 2, false);
        // Second Row
        advancedInventory.addInv(gui, uberDrop, 3, 3, false);
        advancedInventory.addInv(gui, quest, 4, 3, false);
        advancedInventory.addInv(gui, scythe, 5, 3, false);
        advancedInventory.addInv(gui, mystic, 6, 3, false);
        advancedInventory.addInv(gui, atom, 7, 3, false);

        return gui;

    }
}
