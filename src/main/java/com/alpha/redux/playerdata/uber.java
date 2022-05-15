package com.alpha.redux.playerdata;

import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.items.enchants;
import com.alpha.redux.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.alpha.redux.apis.FancyText.*;
import static com.alpha.redux.playerdata.economy.addEconomy;
import static com.alpha.redux.playerdata.streaks.GiveUberItems;

public class uber {
    public static void claimUberReward(Player player){
        Random rand = new Random(); //instance of random class
        int upperbound = 39;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);

            /*
            1x pant part, 5x pant parts, 50k gold, 100k gold,
             250k gold, 1x feather, 2x feather, 3x feather,
              1x dark fragment, 5x dark fragment, 1x sword star,
               5x sword star, prot helmet, prot chest, prot leggings,
                prot boots, sharp sword, first aid egg, bow
             */

        List<String> protection = new ArrayList<>();
        List<String> sharpness = new ArrayList<>();
        protection.add(ChatColor.GRAY + "Protection I");
        protection.add(ChatColor.BLUE + "Unbreakable");

        sharpness.add(ChatColor.GRAY + "Sharpness I");
        sharpness.add(ChatColor.BLUE + "Unbreakable");

        String FeatherLore = compileListToStringWithTitle(String.valueOf(itemManager.feather.getItemMeta().getDisplayName()) + "\n", itemManager.feather.getItemMeta().getLore());
        String FreshRedsLore = compileListToStringWithTitle(String.valueOf(enchants.fresh_reds.getItemMeta().getDisplayName()) + "\n", enchants.fresh_reds.getItemMeta().getLore());
        String VileLore = compileListToStringWithTitle(String.valueOf(enchants.vile.getItemMeta().getDisplayName()) + "\n", enchants.vile.getItemMeta().getLore());
        String BootLore = compileListToStringWithTitle(ChatColor.WHITE + "Diamond Boots"  + "\n", protection);
        String LegLore = compileListToStringWithTitle(ChatColor.WHITE + "Diamond Leggings" + "\n", protection);
        String ChestLore = compileListToStringWithTitle(ChatColor.WHITE + "Diamond Chestplate"  + "\n", protection);
        String HeadLore = compileListToStringWithTitle(ChatColor.WHITE + "Diamond Helmet" + "\n", protection);
        String DiamondSwordLore = compileListToStringWithTitle(ChatColor.WHITE + "Diamond Sword" + "\n", sharpness);
        String fttsLore = compileListToStringWithTitle(String.valueOf(itemManager.ftts.getItemMeta().getDisplayName()) + "\n", itemManager.ftts.getItemMeta().getLore());
        String MLBLore = compileListToStringWithTitle(String.valueOf(itemManager.megalongbow.getItemMeta().getDisplayName()) + "\n", itemManager.megalongbow.getItemMeta().getLore());
        String GhelmLore = compileListToStringWithTitle(String.valueOf(itemManager.goldHelm.getItemMeta().getDisplayName()) + "\n", itemManager.goldHelm.getItemMeta().getLore());
        String ArchLore = compileListToStringWithTitle(String.valueOf(itemManager.arch.getItemMeta().getDisplayName()) + "\n", itemManager.arch.getItemMeta().getLore());
        String JewelSwordLore = compileListToStringWithTitle(String.valueOf(enchants.jewl_sword.getItemMeta().getDisplayName()) + "\n", enchants.jewl_sword.getItemMeta().getLore());
        String JewelPantLore = compileListToStringWithTitle(String.valueOf(enchants.jewl_pant.getItemMeta().getDisplayName()) + "\n", enchants.jewl_pant.getItemMeta().getLore());

        switch (int_random){
            case 0:
                addEconomy(String.valueOf(player.getUniqueId()), 50000);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.GOLD + " 50,000 Gold!", ChatColor.GOLD + "Golden Bar\n" + ChatColor.GRAY + "Receive: " + ChatColor.GOLD + "50,000g");
                break;
            case 1:
                addEconomy(String.valueOf(player.getUniqueId()), 25000);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.GOLD + " 25,000 Gold!", ChatColor.GOLD + "Golden Bar\n" + ChatColor.GRAY + "Receive: " + ChatColor.GOLD + "25,000g");
                break;
            case 2:
            case 11:
            case 12:
                player.getInventory().addItem(enchants.fresh_reds);
                player.getInventory().addItem(enchants.fresh_reds);
                player.getInventory().addItem(enchants.fresh_reds);
                player.getInventory().addItem(enchants.fresh_reds);
                player.getInventory().addItem(enchants.fresh_reds);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x5 Fresh Red!", FreshRedsLore);
                break;
            case 3:
            case 13:
                player.getInventory().addItem(itemManager.DiamondBoots);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x1 Diamond Boots!", BootLore);
                break;
            case 4:
            case 22:
            case 23:
                player.getInventory().addItem(itemManager.DiamondLeggings);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x1 Diamond Leggings!", LegLore);
                break;
            case 5:
            case 21:
                player.getInventory().addItem(itemManager.DiamondChestplate);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x1 Diamond Chestplate!", ChestLore);
                break;
            case 6:
            case 19:
            case 20:
                player.getInventory().addItem(itemManager.DiamondHelmet);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x1 Diamond Helmet!", HeadLore);
                break;
            case 7:
            case 14:
                player.getInventory().addItem(itemManager.feather);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.DARK_AQUA + " x1 Funky Feather!", FeatherLore);
                break;
            case 8:
                player.getInventory().addItem(itemManager.feather);
                player.getInventory().addItem(itemManager.feather);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.DARK_AQUA + " x2 Funky Feather!", FeatherLore);
                break;
            case 9:
                player.getInventory().addItem(itemManager.feather);
                player.getInventory().addItem(itemManager.feather);
                player.getInventory().addItem(itemManager.feather);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.DARK_AQUA + " x3 Funky Feather!", FeatherLore);
                break;
            case 10:
            case 15:
                player.getInventory().addItem(itemManager.DiamondSword);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x1 Diamond Sword!", DiamondSwordLore);
                break;
            case 17:
                player.getInventory().addItem(itemManager.megalongbow);
                player.getInventory().addItem(new ItemStack(Material.ARROW));
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.RED + " x1 Bow!", MLBLore);

                break;
            case 18:
                player.getInventory().addItem(itemManager.ftts);
                player.getInventory().addItem(new ItemStack(Material.ARROW));
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.RED + " x1 Bow!", fttsLore);
                break;
            case 24:
                GiveUberItems(player, enchants.vile, 16, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.RED + " x16 Vile!", VileLore);
                break;
            case 25:
                GiveUberItems(player, enchants.vile, 8, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.RED + " x8 Vile!", VileLore);
                break;
            case 26:
                GiveUberItems(player, enchants.vile, 32, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.RED + " x32 Vile!", VileLore);
                break;
            case 27:
                GiveUberItems(player, itemManager.goldHelm, 1, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.GOLD + " x1 Golden Helmet!", GhelmLore);
                break;
            case 28:
                GiveUberItems(player, itemManager.arch, 1, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.AQUA + " x1 Archangel Chestplate!", ArchLore);
                break;
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                GiveUberItems(player, enchants.jewl_pant, 1, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.DARK_AQUA + " x1 Jewel!", JewelPantLore);
                break;
            case 35:
            case 36:
            case 37:
            case 38:
                GiveUberItems(player, enchants.jewl_sword, 1, true, null);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.DARK_AQUA + " x1 Jewel!", JewelSwordLore);
            default:
                addEconomy(String.valueOf(player.getUniqueId()), 10000);
                hoverText(rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained" + ChatColor.GOLD + " 10,000 Gold!", ChatColor.GOLD + "Golden Bar\n" + ChatColor.GRAY + "Receive: " + ChatColor.GOLD + "10,000g");
                break;
        }
    }
}
