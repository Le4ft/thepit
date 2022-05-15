package com.alpha.redux.apis.TebexMoners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

import static com.alpha.redux.apis.advancedInventory.DyeMaker;
import static com.alpha.redux.apis.advancedInventory.ItemMaker;
import static com.alpha.redux.items.tebexItems.getPlayer;
import static com.alpha.redux.items.tebexItems.giveDyes;
import static com.alpha.redux.playerdata.streaks.GiveUberItems;

public class tebexmoners {
    public static void onRankBuy(String player, String rank){
        Bukkit.broadcastMessage(ChatColor.GREEN + "§lCONGRATS!" + ChatColor.GOLD + player + " has purchased: " + ChatColor.YELLOW + ChatColor.BOLD + rank);

        Location loc = new Location(Bukkit.getWorld("world"), 0.5, 95, 0.5, 0, 0);
        Bukkit.getWorld("world").strikeLightningEffect(loc);
        Bukkit.getWorld("world").strikeLightning(loc);
        Bukkit.getWorld("world").strikeLightningEffect(loc);
        Bukkit.getWorld("world").strikeLightning(loc);
        Bukkit.getWorld("world").strikeLightningEffect(loc);
        Bukkit.getWorld("world").strikeLightning(loc);
        Bukkit.getWorld("world").strikeLightningEffect(loc);
        Bukkit.getWorld("world").strikeLightning(loc);
        Bukkit.getWorld("world").strikeLightningEffect(loc);
        Bukkit.getWorld("world").strikeLightning(loc);
    }

    public static void ColorfulBoxers(String player){

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


        Random rand = new Random(); //instance of random class
        int upperbound = 10;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        // All Possible: Midnight, Crimson, Strawberry, Lemon, Tangerine, Prickly, Sapphire


        switch (int_random){
            case 0:
            case 1:
                GiveUberItems(getPlayer(player), Midnight_Dye, 7, true, null);
                GiveUberItems(getPlayer(player), Crimson_Dye, 7, true, null);
                GiveUberItems(getPlayer(player), Strawberry_Dye, 7, true, null);
                Bukkit.broadcastMessage(ChatColor.GOLD + player + " bought Colorful boxers and received:");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_GRAY + "Midnight Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.RED + "Crimson Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_GREEN + "Prickly Dye");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                GiveUberItems(getPlayer(player), Lemon_Dye, 7, true, null);
                GiveUberItems(getPlayer(player), Tangerine_Dye, 7, true, null);
                GiveUberItems(getPlayer(player), Prickly_Dye, 7, true, null);
                Bukkit.broadcastMessage(ChatColor.GOLD + player + " bought Colorful boxers and received:");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.GOLD + "Tangerine Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.YELLOW + "Lemon Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_AQUA + "Sapphire Dye");
                break;
            default:
                GiveUberItems(getPlayer(player), Strawberry_Dye, 7, true, null);
                GiveUberItems(getPlayer(player), Lemon_Dye, 7, true, null);
                GiveUberItems(getPlayer(player), Sapphire_Dye, 7, true, null);
                Bukkit.broadcastMessage(ChatColor.GOLD + player + " bought Colorful boxers and received:");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "Strawberry Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.YELLOW + "Lemon Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_AQUA + "Sapphire Dye");
                break;
        }
    }

    public static void PlayerColorfulBoxers(Player player){

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


        Random rand = new Random(); //instance of random class
        int upperbound = 10;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        // All Possible: Midnight, Crimson, Strawberry, Lemon, Tangerine, Prickly, Sapphire


        switch (int_random){
            case 0:
            case 1:
                GiveUberItems(player, Midnight_Dye, 7, true, null);
                GiveUberItems(player, Crimson_Dye, 7, true, null);
                GiveUberItems(player, Strawberry_Dye, 7, true, null);
                Bukkit.broadcastMessage(ChatColor.GOLD + player.getDisplayName() + " bought Colorful boxers and received:");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_GRAY + "Midnight Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.RED + "Crimson Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_GREEN + "Prickly Dye");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                GiveUberItems(player, Lemon_Dye, 7, true, null);
                GiveUberItems(player, Tangerine_Dye, 7, true, null);
                GiveUberItems(player, Prickly_Dye, 7, true, null);
                Bukkit.broadcastMessage(ChatColor.GOLD + player.getDisplayName() + " bought Colorful boxers and received:");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.GOLD + "Tangerine Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.YELLOW + "Lemon Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_AQUA + "Sapphire Dye");
                break;
            default:
                GiveUberItems(player, Strawberry_Dye, 7, true, null);
                GiveUberItems(player, Lemon_Dye, 7, true, null);
                GiveUberItems(player, Sapphire_Dye, 7, true, null);
                Bukkit.broadcastMessage(ChatColor.GOLD + player.getDisplayName() + " bought Colorful boxers and received:");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "Strawberry Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.YELLOW + "Lemon Dye");
                Bukkit.broadcastMessage(ChatColor.GRAY + "- " + ChatColor.DARK_AQUA + "Sapphire Dye");
                break;
        }
    }

}
