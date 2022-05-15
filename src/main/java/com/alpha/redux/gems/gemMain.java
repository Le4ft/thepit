package com.alpha.redux.gems;

import com.alpha.redux.apis.advancedInventory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.alpha.redux.well.EnchantingMechanics.getEnchants;

public class gemMain {

    public static ItemStack confirmButton = advancedInventory.ClayMaker((short) 5, ChatColor.GREEN + "Confirm", ChatColor.GRAY + "This action cannot be\n" +
            ChatColor.GRAY + "undone, careful!");

    public static ItemStack cancelButton = advancedInventory.ClayMaker((short) 14, ChatColor.RED + "Cancel", ChatColor.GRAY + "This action can be\n" +
            ChatColor.GRAY + "undone, careful!");

    public static Inventory makeGemGUI(Player player){
        Inventory gui = advancedInventory.inv(player, 27, ChatColor.GRAY + "Totally Legit Gem");


        ItemStack base_glass = advancedInventory.cGlass();
        List<ItemStack> mysticItems = new ArrayList<ItemStack>();


        for (ItemStack itemStack : player.getInventory().getContents()) {
            if(itemStack != null){
                if (itemStack.getType().equals(Material.LEATHER_LEGGINGS)) {
                    if (ChatColor.stripColor(itemStack.getItemMeta().getDisplayName()).contains("Tier")) {
                        for (int i = 0; i < gui.getSize(); i++) {
                            if (gui.getItem(i) == null) {
                                if(getEnchants(itemStack.getItemMeta().getLore(), "PANT", false))
                                    gui.setItem(i, itemStack);
                                break;
                            }
                        }
                    }
                }

                if (itemStack.getType().equals(Material.GOLD_SWORD)) {
                    if (ChatColor.stripColor(itemStack.getItemMeta().getDisplayName()).contains("Tier")) {
                        for (int i = 0; i < gui.getSize(); i++) {
                            if (gui.getItem(i) == null) {
                                if(getEnchants(itemStack.getItemMeta().getLore(), "SWORD", false))
                                    gui.setItem(i, itemStack);
                                break;
                            }
                        }
                    }
                }
            }


        }

        for (int i = 0; i < gui.getSize(); i++) if (gui.getItem(i) == null) gui.setItem(i, base_glass);




        return gui;
    }

    public static Inventory confirmationGui(Player player){
        Inventory gui = advancedInventory.inv(player, 27, ChatColor.GRAY + "Confirm or Cancel");


        ItemStack base_glass = advancedInventory.cGlass();

        for (int i = 0; i < gui.getSize(); i++) if (gui.getItem(i) == null) gui.setItem(i, base_glass);

        gui.setItem(12, confirmButton);
        gui.setItem(14, cancelButton);


        return gui;
    }
}
