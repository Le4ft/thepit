package com.alpha.redux.questMaster;

import com.alpha.redux.renownShop.damageIncrease;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.alpha.redux.apis.advancedInventory.ItemMaker;

public class questMenuItems {
    public static ItemStack claimRewards(String uuid){
        return ItemMaker(Material.GOLD_BLOCK, ChatColor.YELLOW + "Quests!", ChatColor.GRAY + "Complete these quests for rewards!\n" + ChatColor.GRAY + " For each quest completed gain\n" + ChatColor.GRAY + "small stat boosts!", 1, true);
    }

    public static ItemStack KillPlayersQuest(String uuid){
        return ItemMaker(Material.GHAST_TEAR, ChatColor.DARK_AQUA + "▀▀▀▀▀▀▀▀▀▀", ChatColor.GRAY + "Bring me 16 " + ChatColor.DARK_AQUA + "Player Souls " + ChatColor.GRAY + "trust me.\n\n" + ChatColor.RED + "Costs: " + ChatColor.GOLD + "50,000g" +
                "\n\n" + ChatColor.DARK_AQUA + "▀▀▀▀▀▀▀▀▀▀", 1, true);
    }
    public static ItemStack FindCakeQuest(String uuid){
        return ItemMaker(Material.CAKE, ChatColor.LIGHT_PURPLE + "▀▀▀▀▀▀▀▀▀▀", ChatColor.GRAY + "Find the hidden cake!\n" +
                ChatColor.GRAY + "return it here to earn rewards!\n" + ChatColor.GRAY + "Being able to harvest the\n" + ChatColor.GRAY +
                "cake needs special magic!\n" + ChatColor.GRAY + "I think its 4 cakes for the ritual.\n" +
                ChatColor.RED + "Costs: " + ChatColor.GOLD + "100,000g" +
                "\n\n" + ChatColor.LIGHT_PURPLE + "▀▀▀▀▀▀▀▀▀▀", 1, true);
    }

    public static ItemStack BringVileQuest(String uuid){
        return ItemMaker(Material.COAL, ChatColor.DARK_PURPLE + "▀▀▀▀▀▀▀▀▀▀", ChatColor.GRAY + "Bring me vile!\n" + ChatColor.GRAY +
                "Please I'm very in need of this.\n" + ChatColor.GRAY + "Would you mind giving me 64?\n\n" +
                ChatColor.RED + "Costs: " + ChatColor.GOLD + "100,000g" +
                "\n\n" + ChatColor.DARK_PURPLE + "▀▀▀▀▀▀▀▀▀▀", 1, true);
    }

    public static ItemStack BringCoinsQuest(String uuid){
        return ItemMaker(Material.GOLD_INGOT, ChatColor.GOLD + "▀▀▀▀▀▀▀▀▀▀", ChatColor.GRAY + "Hey I'm in desperate need\n" +
                ChatColor.GRAY + "of gold, I've been starving\n" + ChatColor.GRAY + " and so has my family.\n\n" +
                ChatColor.RED + "Costs: " + ChatColor.GOLD + "1,000,000g" +
                "\n\n" + ChatColor.GOLD + "▀▀▀▀▀▀▀▀▀▀", 1, true);
    }

    public static ItemStack BringFreshQuest(String uuid){
        return ItemMaker(Material.LEATHER_LEGGINGS, ChatColor.RED + "▀▀▀▀▀▀▀▀▀▀", ChatColor.GRAY + "Hey I'd like to enchant 5 fresh,\n" +
                ChatColor.GRAY + "but I don't have any fresh.\n" + ChatColor.GRAY + "Could you bring me some?\n\n" + ChatColor.RED + "Costs: " + ChatColor.GOLD + "150,000g" +
                "\n\n" + ChatColor.RED + "▀▀▀▀▀▀▀▀▀▀", 1, true);
    }
}
