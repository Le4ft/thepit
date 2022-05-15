package com.alpha.redux.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

import java.util.*;

import static com.alpha.redux.apis.advancedInventory.DyeMaker;
import static com.alpha.redux.apis.advancedInventory.ItemMaker;
import static com.alpha.redux.playerdata.streaks.GiveUberItems;
import static org.bukkit.Bukkit.getOnlinePlayers;

public class tebexItems {

    public static void giveDyes(String player){
        ItemStack Midnight_Dye = ItemMaker(Material.INK_SACK, ChatColor.DARK_GRAY + "Midnight Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!", 1, true);

        ItemStack Crimson_Dye = DyeMaker((short) 1, ChatColor.RED + "Crimson Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!");

        ItemStack Strawberry_Dye = DyeMaker((short) 9, ChatColor.LIGHT_PURPLE + "Strawberry Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!");

        ItemStack Lemon_Dye = DyeMaker((short) 11, ChatColor.YELLOW + "Lemon Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!");

        ItemStack Sapphire_Dye = DyeMaker((short) 12, ChatColor.DARK_AQUA + "Sapphire Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!");

        ItemStack Tangerine_Dye = DyeMaker((short) 14, ChatColor.GOLD + "Tangerine Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!");

        ItemStack Prickly_Dye = DyeMaker((short) 2, ChatColor.DARK_GREEN + "Prickly Dye",
                ChatColor.GRAY + "Use in the crafting menu!\n\n" +
                        ChatColor.LIGHT_PURPLE + "Purely cosmetic!");

        GiveUberItems(getPlayer(player), Midnight_Dye, 7, true, null);
        GiveUberItems(getPlayer(player), Crimson_Dye, 7, true, null);
        GiveUberItems(getPlayer(player), Strawberry_Dye, 7, true, null);
        GiveUberItems(getPlayer(player), Lemon_Dye, 7, true, null);
        GiveUberItems(getPlayer(player), Sapphire_Dye, 7, true, null);
        GiveUberItems(getPlayer(player), Tangerine_Dye, 7, true, null);
        GiveUberItems(getPlayer(player), Prickly_Dye, 7, true, null);
    }

    public static Player getPlayer(String playername){
        /*
        ArrayList<Player> list = new ArrayList<Player>(getOnlinePlayers());
        //For every player, add their name to gui

        for (Player value : list) {
            //Set player info on the item
            String name = value.getDisplayName();

            if (name.equals(playername)){
                return value;
            }

        }
        return null;

         */
        return Bukkit.getPlayer(playername);
    }
}
