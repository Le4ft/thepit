package com.alpha.redux.apis.skyblock;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.alpha.redux.apis.advancedInventory.DyeMaker;
import static com.alpha.redux.apis.advancedInventory.ItemMaker;

public class skyblockItems {
    public static ItemStack termy;

    public static void initializeItemstack(){
        CreateTerminator();
    }

    private static void CreateTerminator(){
        termy = ItemMaker(Material.BOW, ChatColor.GOLD + "Terminator",
                ChatColor.GRAY + "Damage: " + ChatColor.RED + "+310\n" +
                        ChatColor.GRAY + "Strength: " + ChatColor.RED + "+50\n" +
                        ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+250%\n" +
                        ChatColor.GRAY + "Bonus Attack Speed: "  + ChatColor.RED + "+40%\n\n" +
                        ChatColor.GOLD + "Shortbow: Instantly shoots!\n" +
                        ChatColor.GRAY + "Shoots " + ChatColor.AQUA + "3 " + ChatColor.GRAY + "arrows at once.\n" +
                        ChatColor.GRAY + "Can damage Endermen.\n\n" + ChatColor.RED + "Divides your " + ChatColor.BLUE +
                        "Crit Chance " + ChatColor.RED + "by 4!\n\n" + ChatColor.GOLD + ChatColor.BOLD + "LEGENDARY BOW", 1, false);
    }

}
