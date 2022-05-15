package com.alpha.redux.well;

import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.alpha.redux.apis.advancedInventory.*;
import static com.alpha.redux.apis.chatManager.prestigebrackets.prestigebracket;
import static com.alpha.redux.events.boards.integerToRoman;
import static com.alpha.redux.playerdata.economy.getGoldRequireMentAmount;
import static com.alpha.redux.playerdata.prestiges.*;
import static com.alpha.redux.playerdata.streaks.getMegaStreak;
import static com.alpha.redux.playerdata.streaks.hasMegaStreak;
import static com.alpha.redux.playerdata.xpManager.GetCurrentLevel;
import static com.alpha.redux.renownShop.renownAmount.GetByPrestige;

public class gui {

    public static void base(Player player){
        Inventory gui = inv(player, 45, ChatColor.GRAY + "Mystic Well");

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) (7));
        ItemStack table = new ItemStack(Material.ENCHANTMENT_TABLE);

        ItemMeta null_meta = glass.getItemMeta();
        null_meta.setDisplayName(ChatColor.GRAY + " ");
        glass.setItemMeta(null_meta);

        ItemMeta table_meta = table.getItemMeta();
        ArrayList<String> table_lore = new ArrayList<>();
        table_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Mystic Well");
        table_lore.add(ChatColor.GRAY + "Find a " + ChatColor.AQUA + "Mystic Bow" + ChatColor.GRAY + "," + ChatColor.YELLOW + "Mystic");
        table_lore.add(ChatColor.YELLOW + "Sword " + ChatColor.GRAY + "or " + ChatColor.RED + "P" + ChatColor.GOLD + "a" + ChatColor.YELLOW + "n" + ChatColor.GREEN + "t" + ChatColor.BLUE + "s " + ChatColor.GRAY + "from");
        table_lore.add(ChatColor.GRAY + "killing players.");
        table_lore.add("");
        table_lore.add(ChatColor.GRAY + "Enchant these items in the well");
        table_lore.add(ChatColor.GRAY + "for tons of buffs.");
        table_lore.add("  ");
        table_lore.add(ChatColor.LIGHT_PURPLE + "Click an item in your inventory!");
        table_meta.setLore(table_lore);
        table.setItemMeta(table_meta);

        ItemStack[] menu_items = {null,null,null,null,null,null,null,null,null,null,glass,glass,glass,null,null,null,null,null,null,glass,null,glass,null,null,table,null,null,null,glass,glass,glass,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        gui.setContents(menu_items);
        player.openInventory(gui);
    }

    public static Inventory enchanting(Player player){
        Inventory gui = inv(player, 45, ChatColor.GRAY + "Mystic Well");

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) (7));
        ItemStack table = new ItemStack(Material.ENCHANTMENT_TABLE);

        ItemMeta null_meta = glass.getItemMeta();
        null_meta.setDisplayName(ChatColor.GRAY + " ");
        glass.setItemMeta(null_meta);

        ItemMeta table_meta = table.getItemMeta();
        ArrayList<String> table_lore = new ArrayList<>();
        table_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Mystic Well");
        table_lore.add(ChatColor.GRAY + "Find a " + ChatColor.AQUA + "Mystic Bow" + ChatColor.GRAY + "," + ChatColor.YELLOW + "Mystic");
        table_lore.add(ChatColor.YELLOW + "Sword " + ChatColor.GRAY + "or " + ChatColor.RED + "P" + ChatColor.GOLD + "a" + ChatColor.YELLOW + "n" + ChatColor.GREEN + "t" + ChatColor.BLUE + "s " + ChatColor.GRAY + "from");
        table_lore.add(ChatColor.GRAY + "killing players.");
        table_lore.add("");
        table_lore.add(ChatColor.GRAY + "Enchant these items in the well");
        table_lore.add(ChatColor.GRAY + "for tons of buffs.");
        table_lore.add("  ");
        table_lore.add(ChatColor.LIGHT_PURPLE + "Click an item in your inventory!");
        table_meta.setLore(table_lore);
        table.setItemMeta(table_meta);

        ItemStack[] menu_items = {null,null,null,null,null,null,null,null,null,null,glass,glass,glass,null,null,null,null,null,null,glass,null,glass,null,null,table,null,null,null,glass,glass,glass,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        gui.setContents(menu_items);
        player.openInventory(gui);
        return gui;
    }

    public static void finish(Player player, ItemStack item){
        Inventory gui = inv(player, 45, ChatColor.GRAY + "Mystic Well");

        ItemStack glass = cGlass();
        ItemStack table = new ItemStack(Material.ENCHANTMENT_TABLE);

        ItemMeta table_meta = table.getItemMeta();
        ArrayList<String> table_lore = new ArrayList<>();
        table_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Mystic Well");
        table_lore.add(ChatColor.GRAY + "Find a " + ChatColor.AQUA + "Mystic Bow" + ChatColor.GRAY + "," + ChatColor.YELLOW + "Mystic");
        table_lore.add(ChatColor.YELLOW + "Sword " + ChatColor.GRAY + "or " + ChatColor.RED + "P" + ChatColor.GOLD + "a" + ChatColor.YELLOW + "n" + ChatColor.GREEN + "t" + ChatColor.BLUE + "s " + ChatColor.GRAY + "from");
        table_lore.add(ChatColor.GRAY + "killing players.");
        table_lore.add("");
        table_lore.add(ChatColor.GRAY + "Enchant these items in the well");
        table_lore.add(ChatColor.GRAY + "for tons of buffs.");
        table_lore.add("  ");
        table_lore.add(ChatColor.LIGHT_PURPLE + "Click an item in your inventory!");
        table_meta.setLore(table_lore);
        table.setItemMeta(table_meta);

        ItemStack[] menu_items = {null,null,null,null,null,null,null,null,null,null,glass,glass,glass,null,null,null,null,null,null,glass,item,glass,null,null,table,null,null,null,glass,glass,glass,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        gui.setContents(menu_items);
        player.openInventory(gui);
    }

    public static void enchanting_tierI(Player player, ItemStack item){
        Inventory gui = inv(player, 45, ChatColor.GRAY + "Mystic Well");

        ItemStack glass = cGlass();
        ItemStack table = new ItemStack(Material.ENCHANTMENT_TABLE);
        ItemMeta table_meta = table.getItemMeta();
        ArrayList<String> table_lore = new ArrayList<>();
        table_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Mystic Well");
        table_lore.add(ChatColor.GRAY + "Find a " + ChatColor.AQUA + "Mystic Bow" + ChatColor.GRAY + "," + ChatColor.YELLOW + "Mystic");
        table_lore.add(ChatColor.YELLOW + "Sword " + ChatColor.GRAY + "or " + ChatColor.RED + "P" + ChatColor.GOLD + "a" + ChatColor.YELLOW + "n" + ChatColor.GREEN + "t" + ChatColor.BLUE + "s " + ChatColor.GRAY + "from");
        table_lore.add(ChatColor.GRAY + "killing players.");
        table_lore.add("");
        table_lore.add(ChatColor.GRAY + "Enchant these items in the well");
        table_lore.add(ChatColor.GRAY + "for tons of buffs.");
        table_lore.add("  ");
        table_lore.add(ChatColor.LIGHT_PURPLE + "Click an item in your inventory!");
        table_meta.setLore(table_lore);
        table.setItemMeta(table_meta);

        ItemStack[] menu_items = {null,null,null,null,null,null,null,null,null,null,glass,glass,glass,null,null,null,null,null,null,glass,item,glass,null,null,table,null,null,null,glass,glass,glass,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        gui.setContents(menu_items);
        player.openInventory(gui);
    }

    public static void NonPermanentItems(Player player){
        Inventory gui = inv(player, 27, ChatColor.GRAY + "Non-permanent items");

        ItemStack base_glass = cGlass();

        ItemStack Diamond_Sword = ItemMaker(Material.DIAMOND_SWORD, ChatColor.YELLOW + "Diamond Sword",
                ChatColor.BLUE + "+20% damage vs bountied\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "150g\n" + ChatColor.YELLOW + "Click to purchase!",
                1, true);

        ItemStack Diamond_Spade = ItemMaker(Material.DIAMOND_SPADE, ChatColor.YELLOW + "Combat Spade",
                ChatColor.GRAY + "Deals " + ChatColor.BLUE + "+1 damage per\n" + ChatColor.AQUA + "diamond piece " + ChatColor.GRAY + "on enemy." + "\n\n"  +
                        ChatColor.BLUE + "+7 Attack Damage\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                        ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "750g\n" + ChatColor.YELLOW + "Click to purchase!",
                1, true);

        ItemStack Obsidian = ItemMaker(Material.OBSIDIAN, ChatColor.YELLOW + "Obsidian",
                ChatColor.GRAY + "Remains for 120 seconds.\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                        ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "10000g\n" + ChatColor.YELLOW + "Click to purchase!",
                8, true);

        ItemStack Iron_Kit = ItemMaker(Material.IRON_HELMET, ChatColor.YELLOW + "Iron Pack",
                ChatColor.GRAY + "Contains:\n" + ChatColor.WHITE + " Iron Helmet\n " + ChatColor.WHITE + "Iron Chestplate\n " + ChatColor.WHITE + "Iron Leggings\n " +
                        ChatColor.WHITE + "Iron Boots" + "\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                        ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "200g\n" + ChatColor.YELLOW + "Click to purchase!",
                1, true);

        ItemStack Diamond_Chestplate = ItemMaker(Material.DIAMOND_CHESTPLATE, ChatColor.RED + "Diamond Chestplate",
                ChatColor.BLUE + "Auto-equips on buy!\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                        ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "500g\n" + ChatColor.YELLOW + "Click to purchase!",
                1, true);

        ItemStack Diamond_Leggings = ItemMaker(Material.DIAMOND_LEGGINGS, ChatColor.RED + "Diamond Leggings",
                ChatColor.BLUE + "Auto-equips on buy!\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                        ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "1500g\n" + ChatColor.YELLOW + "Click to purchase!",
                1, true);

        ItemStack Diamond_Boots = ItemMaker(Material.DIAMOND_BOOTS, ChatColor.RED + "Diamond Boots",
                ChatColor.BLUE + "Auto-equips on buy!\n\n" + ChatColor.GRAY + ChatColor.ITALIC + "Lost on death.\n" +
                        ChatColor.RESET + ChatColor.GRAY + "Cost: " + ChatColor.GOLD + "300g\n" + ChatColor.YELLOW + "Click to purchase!",
                1, true);

        addInv(gui, Diamond_Sword, 2, 2, false);
        addInv(gui, Diamond_Spade, 3, 2, false);
        addInv(gui, Obsidian, 4, 2, false);
        addInv(gui, Iron_Kit, 5, 2, false);
        addInv(gui, Diamond_Chestplate, 6, 2, false);
        addInv(gui, Diamond_Leggings, 7, 2, false);
        addInv(gui, Diamond_Boots, 8, 2, false);




        player.openInventory(gui);
    }

    public static void megaStreak(Player player){
        hasMegaStreak(String.valueOf(String.valueOf(player.getUniqueId())));


        Inventory gui = inv(player, 27, ChatColor.GOLD + "MegaStreak Hub");

        ItemStack base_glass = cGlass();

        ItemStack Uber_Streak = ItemMaker(Material.GOLD_SWORD, ChatColor.YELLOW + "Uberstreak",
                ChatColor.GRAY + "Triggers on: " + ChatColor.RED + "100 kills\n\n" +  ChatColor.GRAY + "On trigger:\n" + ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Gain" +
                        ChatColor.LIGHT_PURPLE + " +50%" + ChatColor.GRAY + " chance to find mystic items.\n\n" + ChatColor.GRAY + "BUT:\n" + ChatColor.RED + "⚫" + ChatColor.GRAY +
                        " Receive " + ChatColor.RED + "+10%" + ChatColor.GRAY + " damage per 100 kills.\n\n" + ChatColor.GRAY + "During the streak:\n" + ChatColor.LIGHT_PURPLE + "⚫" +
                        ChatColor.GRAY + " 100 kills: Deal " + ChatColor.RED + "-40% damage vs bots\n" + ChatColor.LIGHT_PURPLE + "⚫" + ChatColor.GRAY + " 200 kills: " + ChatColor.DARK_GRAY +
                        "permanent slowness\n" + ChatColor.LIGHT_PURPLE + "⚫" + ChatColor.GRAY + " 300 kills: Mystics are unusable\n" + ChatColor.LIGHT_PURPLE + "⚫" + ChatColor.GRAY + " 400 kills: Earn a random " +
                        ChatColor.LIGHT_PURPLE + "Uberdrop " + ChatColor.GRAY + " (sends you to spawn).\n\n"
                     + ChatColor.RED + "Requires 10k Gold to select!\n" + ChatColor.RED + "Requires level 100 to select!\n" + ChatColor.LIGHT_PURPLE + "Deselects on completion!\n" +
                ChatColor.DARK_AQUA + "Selected Mega Streak: " + ChatColor.GREEN + getMegaStreak(String.valueOf(player.getUniqueId())), 1, true);

        ItemStack BeastMode = ItemMaker(Material.DIAMOND_HELMET, ChatColor.YELLOW + "Beastmode",
                ChatColor.GRAY + "Triggers on: " + ChatColor.RED + "50 kills\n\n"  + ChatColor.GRAY + "On trigger:\n" +
                        ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Gain a " + ChatColor.AQUA + "Diamond Helmet.\n" +
                        ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Deal " + ChatColor.RED + "+25% damage \n" +
                        ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Earn " + ChatColor.AQUA + "+50% XP" + ChatColor.GRAY + "from kills.\n" +
                        ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Earn " + ChatColor.GOLD + "+75% gold" + ChatColor.GRAY + "from kills.\n\n" +
                        ChatColor.GRAY + "BUT:\n" + ChatColor.RED + "⚫" + ChatColor.GRAY + " Receive " + ChatColor.RED + "+0.1❤ " + ChatColor.GRAY + "damage per 5 kills above 50.\n\n" +
                        ChatColor.DARK_AQUA + "Selected Mega Streak: " + ChatColor.GREEN + getMegaStreak(String.valueOf(player.getUniqueId())), 1, true);

        ItemStack Highlander = ItemMaker(Material.GOLD_BOOTS, ChatColor.YELLOW + "Highlander",
                ChatColor.GRAY + "Triggers on: " + ChatColor.RED + "50 kills\n\n"  + ChatColor.GRAY + "On trigger:\n" + ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Perma " + ChatColor.YELLOW + "Speed I" + ChatColor.GRAY + ".\n" +
                     ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Earn " + ChatColor.GOLD + "+110% gold" + ChatColor.GRAY + " from kills.\n" +
                     ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Deal " + ChatColor.RED + "+33% damage " + ChatColor.GRAY + "vs bountied players.\n\n" +
                     ChatColor.GRAY + "BUT:\n" + ChatColor.RED + "⚫" + ChatColor.AQUA + " +5000g" + ChatColor.GRAY + " max bounty.\n" +
                     ChatColor.RED + "⚫ " + ChatColor.AQUA + "Receive " + ChatColor.RED + "+0.3% damage\n" + ChatColor.GRAY + "from " + ChatColor.GOLD + "Bounty Hunter " +
                     ChatColor.GRAY + "wearers per\n" + ChatColor.GRAY + "kill over 50.\n\n" +
                     ChatColor.RED + "Requires prestige 5 to use!\n" + ChatColor.RED + "Requires level 50 to select!\n" +
                     ChatColor.DARK_AQUA + "Selected Mega Streak: " + ChatColor.GREEN + getMegaStreak(String.valueOf(player.getUniqueId())), 1, true);

        ItemStack ToTheMoon = ItemMaker(Material.ENDER_STONE, ChatColor.YELLOW + "To the Moon",
                ChatColor.GRAY + "Triggers on: " + ChatColor.RED + "100 kills\n\n"  + ChatColor.GRAY + "On trigger:\n" + ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Perma " + ChatColor.YELLOW + "Speed I" + ChatColor.GRAY + ".\n" +
                        ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Earn " + ChatColor.AQUA + "+50% XP" + ChatColor.GRAY + " from kills.\n" +
                        ChatColor.GREEN + "⚫ " + ChatColor.GRAY + "Get " + ChatColor.AQUA + "7x xp cap" + ChatColor.GRAY + " from kills.\n\n" +
                        ChatColor.GRAY + "BUT:\n" + ChatColor.RED + "⚫" + ChatColor.GRAY + " Receive " + ChatColor.RED + "+.5❤ " + ChatColor.GRAY + "damage per kill above 100.\n\n" +
                        ChatColor.RED + "Requires prestige 20 to use!\n" + ChatColor.RED + "Requires level 50 to select!\n" +
                        ChatColor.DARK_AQUA + "Selected Mega Streak: " + ChatColor.GREEN + getMegaStreak(String.valueOf(player.getUniqueId())), 1, true);

        addInv(gui, base_glass, 1, 1, false);
        addInv(gui, base_glass, 2, 1, false);
        addInv(gui, base_glass, 3, 1, false);
        addInv(gui, base_glass, 4, 1, false);
        addInv(gui, base_glass, 5, 1, false);
        addInv(gui, base_glass, 6, 1, false);
        addInv(gui, base_glass, 7, 1, false);
        addInv(gui, base_glass, 8, 1, false);
        addInv(gui, base_glass, 9, 1, false);
        addInv(gui, base_glass, 1, 2, false);
        addInv(gui, base_glass, 3, 2, false);
        addInv(gui, base_glass, 4, 2, false);
        addInv(gui, base_glass, 5, 2, false);
        addInv(gui, base_glass, 6, 2, false);
        addInv(gui, base_glass, 7, 2, false);
        addInv(gui, base_glass, 9, 2, false);
        addInv(gui, base_glass, 1, 3, false);
        addInv(gui, base_glass, 2, 3, false);
        addInv(gui, base_glass, 3, 3, false);
        addInv(gui, base_glass, 4, 3, false);
        addInv(gui, base_glass, 5, 3, false);
        addInv(gui, base_glass, 6, 3, false);
        addInv(gui, base_glass, 7, 3, false);
        addInv(gui, base_glass, 8, 3, false);
        addInv(gui, base_glass, 9, 3, false);
        addInv(gui, Uber_Streak, 2, 2, false);
        addInv(gui, BeastMode, 4, 2, false);
        addInv(gui, Highlander, 8, 2, false);
        addInv(gui, ToTheMoon, 6, 2, false);
        player.openInventory(gui);

    }

    public static void Perks(Player player){
        hasMegaStreak(String.valueOf(String.valueOf(player.getUniqueId())));


        Inventory gui = inv(player, 45, ChatColor.GOLD + "Perks");

        ItemStack base_glass = cGlass();

        ItemStack Vampire = ItemMaker(Material.FERMENTED_SPIDER_EYE, ChatColor.AQUA + "Vampire",
                ChatColor.GRAY + "Gain " +  ChatColor.RED + "+.5❤ " + ChatColor.GRAY +"per hit (40% max)\n "+ ChatColor.GRAY + "Regeneration 1 (2s) on kill!\n\n" +
                        ChatColor.RED + "Don't worry it's always selected!", 1, true);

        ItemStack Strength = ItemMaker(Material.REDSTONE, ChatColor.AQUA + "Strength Chaining",
                ChatColor.GRAY + "Gain a stacking 8% damage\n" + ChatColor.GRAY + "per kill (40% max)\n\n" +
                ChatColor.RED + "Requires level 10 to select!", 1, true);

        ItemStack Tank = ItemMaker(Material.IRON_CHESTPLATE, ChatColor.AQUA + "Tank",
                ChatColor.GRAY + "Gain" + ChatColor.GRAY + " -20% damage and permanent\n" + ChatColor.GRAY + "weakness 1!\n\n" +
                        ChatColor.RED + "Requires prestige 3 to use!\n" + ChatColor.RED + "Requires level 50 to select!", 1, true);

        ItemStack Streaker = ItemMaker(Material.WHEAT, ChatColor.AQUA + "Streaker",
                ChatColor.GRAY + "Gain" + ChatColor.GRAY + " 50 more " + ChatColor.AQUA + "xp " + ChatColor.GRAY +"per kill!\n\n" +
                        ChatColor.RED + "Requires prestige 1 to use!\n" + ChatColor.RED + "Requires level 15 to select!", 1, true);

        ItemStack Aura = ItemMaker(Material.SLIME_BALL, ChatColor.AQUA + "Aura of protection",
                ChatColor.GRAY + "Gain " + ChatColor.GRAY + "an " + ChatColor.GREEN + "aura of protection\n" + ChatColor.GRAY +"every 15 kills\n\n" +
                        ChatColor.RED + "Requires prestige 10 to use!\n" + ChatColor.RED + "Requires level 100 to select!", 1, true);

        ItemStack Dirty = ItemMaker(Material.DIRT, ChatColor.AQUA + "Dirty",
                ChatColor.GRAY + "Gain " + ChatColor.GRAY + "resistance 2 on kill!\n\n" +
                        ChatColor.RED + "Requires prestige 3 to use!\n" + ChatColor.RED + "Requires level 50 to select!", 1, true);

        ItemStack Gladiator = ItemMaker(Material.BONE, ChatColor.AQUA + "Gladiator",
                ChatColor.GRAY + "Receive -3% per online player!\n\n" +
                        ChatColor.RED + "Requires prestige 3 to use!\n" + ChatColor.RED + "Requires level 10 to select!", 1, true);

        ItemStack Diamond = ItemMaker(Material.DIAMOND_BLOCK, ChatColor.RED + "COMING SOON","", 1, true);


        addInv(gui, base_glass, 1, 1, false);
        addInv(gui, base_glass, 2, 1, false);
        addInv(gui, base_glass, 3, 1, false);
        addInv(gui, base_glass, 4, 1, false);
        addInv(gui, base_glass, 5, 1, false);
        addInv(gui, base_glass, 6, 1, false);
        addInv(gui, base_glass, 7, 1, false);
        addInv(gui, base_glass, 8, 1, false);
        addInv(gui, base_glass, 9, 1, false);
        addInv(gui, base_glass, 1, 2, false);
        addInv(gui, base_glass, 3, 2, false);
        addInv(gui, base_glass, 4, 2, false);
        addInv(gui, base_glass, 6, 2, false);
        addInv(gui, base_glass, 7, 2, false);
        addInv(gui, base_glass, 9, 2, false);
        addInv(gui, base_glass, 1, 3, false);
        addInv(gui, base_glass, 2, 3, false);
        addInv(gui, base_glass, 3, 3, false);
        addInv(gui, base_glass, 4, 3, false);
        addInv(gui, base_glass, 5, 3, false);
        addInv(gui, base_glass, 6, 3, false);
        addInv(gui, base_glass, 7, 3, false);
        addInv(gui, base_glass, 8, 3, false);
        addInv(gui, base_glass, 9, 3, false);
        addInv(gui, base_glass, 1, 4, false);
        addInv(gui, base_glass, 2, 4, false);
        addInv(gui, base_glass, 3, 4, false);
        addInv(gui, base_glass, 4, 4, false);
        addInv(gui, base_glass, 5, 4, false);
        addInv(gui, base_glass, 6, 4, false);
        addInv(gui, base_glass, 7, 4, false);
        addInv(gui, base_glass, 8, 4, false);
        addInv(gui, base_glass, 9, 4, false);
        addInv(gui, base_glass, 1, 5, false);
        addInv(gui, base_glass, 2, 5, false);
        addInv(gui, base_glass, 3, 5, false);
        addInv(gui, base_glass, 4, 5, false);
        addInv(gui, base_glass, 5, 5, false);
        addInv(gui, base_glass, 6, 5, false);
        addInv(gui, base_glass, 7, 5, false);
        addInv(gui, base_glass, 8, 5, false);
        addInv(gui, base_glass, 9, 5, false);
        addInv(gui, base_glass, 1, 6, false);
        addInv(gui, base_glass, 2, 6, false);
        addInv(gui, base_glass, 3, 6, false);
        addInv(gui, base_glass, 4, 6, false);
        addInv(gui, base_glass, 5, 6, false);
        addInv(gui, base_glass, 6, 6, false);
        addInv(gui, base_glass, 7, 6, false);
        addInv(gui, base_glass, 8, 6, false);
        addInv(gui, base_glass, 9, 6, false);
        addInv(gui, base_glass, 5, 2, false);

        addInv(gui, Vampire, 2, 4, false);
        addInv(gui, Strength, 4, 4, false);
        addInv(gui, Tank, 8, 4, false);
        addInv(gui, Streaker, 6, 4, false);

        addInv(gui, Dirty, 2, 2, false);
        addInv(gui, Gladiator, 4, 2, false);
        addInv(gui, Aura, 6, 2, false);
        addInv(gui, Diamond, 8, 2, false);
        player.openInventory(gui);

    }

    public static void PrestigeMenu(Player player){
        hasPrestige(String.valueOf(String.valueOf(player.getUniqueId())));
        int[] randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);
        String req_level;

        if (randomDUDE[0] >= 120){
            DecimalFormat formatter = new DecimalFormat("#,###");
            req_level = ChatColor.translateAlternateColorCodes('&', "&7Costs:" + "\n" +"&c&l⚫ Resets &blevel &c to 1" + "\n" + "&c&l⚫ Resets &6gold &c to 0" + "\n" + "&c&l⚫ Resets &cALL &aperks and upgrades" + "\n" + "&c&l⚫ Need minimum &6" + formatter.format(getGoldRequireMentAmount(String.valueOf(player.getUniqueId()))) + "&6g" + "\n\n" + "&7Reward: &e" + GetByPrestige(getPrestige(String.valueOf(player.getUniqueId()))) + " &eRenown Tokens" + "\n\n" + "&7New prestige: &e" + integerToRoman(getPrestige(String.valueOf(player.getUniqueId())) + 1) + "\n" + ChatColor.AQUA + "+" + ((int) PrestigeXpAmount(getPrestige(String.valueOf(player.getUniqueId()))) * 10) + "%" + ChatColor.GRAY + " needed xp than normal!\n\n" + "&eClick to purchase!");
        }else{
            req_level  = ChatColor.AQUA + "+" + ((int) PrestigeXpAmount(getPrestige(String.valueOf(player.getUniqueId()))) * 10) + "%" + ChatColor.GRAY + " needed xp than normal!\n\n" + ChatColor.GRAY + "Required Level: " + prestigebracket(player) + "[" + ChatColor.AQUA + ChatColor.BOLD + "120" + prestigebracket(player) + "]" + "\n\n" + ChatColor.GRAY + "Level up to prestige!";
        }

        Inventory gui = inv(player, 27, ChatColor.GOLD + "Prestige Hub");

        ItemStack base_glass = cGlass();

        ItemStack Prestige_Block = ItemMaker(Material.DIAMOND, ChatColor.AQUA + "Prestige", ChatColor.GRAY + "Current: " + ChatColor.YELLOW + integerToRoman(getPrestige(String.valueOf(player.getUniqueId()))) + "\n" + req_level, 1, true);

        ItemStack Prestige_Shop = ItemMaker(Material.BEACON, ChatColor.YELLOW + "Renown shop",
                ChatColor.GRAY + "Use " + ChatColor.YELLOW + "Renown Tokens " + ChatColor.GRAY + "earned from\n" +
                     ChatColor.AQUA + "Prestige " + ChatColor.GRAY + "to unlock unique\n" + ChatColor.GRAY + "upgrades!\n" +
                     ChatColor.GRAY + ChatColor.ITALIC + "These upgrades are safe from prestige reset.\n\n" + ChatColor.YELLOW +
                     "Click to browse!"
                , 1, true);

        for (int i = 0; i < 10; i++) {
            addInv(gui, base_glass, i, 1, false);
            addInv(gui, base_glass, i, 2, false);
            addInv(gui, base_glass, i, 3, false);
        }
        addInv(gui, Prestige_Block, 3, 2, false);

        addInv(gui, Prestige_Shop, 7, 2, false);

        player.openInventory(gui);
    }

    public static void PerkMenu(Player player){

    }

}
