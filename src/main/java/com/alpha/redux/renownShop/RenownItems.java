package com.alpha.redux.renownShop;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import static com.alpha.redux.apis.advancedInventory.ItemMaker;
import static com.alpha.redux.renownShop.xpIncrease.getXpIncrease;

import com.alpha.redux.events.boards;

public class RenownItems {

    public static ItemStack DamageItemIncrease(String uuid){
        return ItemMaker(Material.REDSTONE, ChatColor.YELLOW + "Damage Increase",
                ChatColor.GRAY + "Each purchase gives you " + ChatColor.RED + "+5% damage\n" + ChatColor.GRAY +
                "Starts dividing by" + ChatColor.YELLOW + " 40 " + ChatColor.GRAY + "past " + ChatColor.RED + "+10%\n\n" + ChatColor.GRAY +
                "Current boost: " + ChatColor.RED +  "+" + damageIncrease.getIncrease(uuid) + "%\n\n" +
                ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "5 Renown Tokens", 1, true);
    }

    public static ItemStack DamageItemDecrease(String uuid){
        return ItemMaker(Material.IRON_CHESTPLATE, ChatColor.YELLOW + "Damage Resistance",
                ChatColor.GRAY + "Each purchase gives you " + ChatColor.RED + "+5% resistance\n" + ChatColor.GRAY +
                "Max tier: " + ChatColor.RED + "X\n"+ ChatColor.GRAY +
                "Current tier: " + ChatColor.RED + boards.integerToRoman(damageDecrease.getDecrease(uuid) / 5) + "\n\n" +
                ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "20 Renown Tokens", 1, true);
    }


    public static ItemStack XpItemIncrease(String uuid){
        return ItemMaker(Material.EXP_BOTTLE, ChatColor.YELLOW + "Factory",
                ChatColor.GRAY + "Each purchase gives you " + ChatColor.AQUA + "+5 xp cap!\n" + ChatColor.GRAY +
                        "But is capped at" + ChatColor.YELLOW + " 500\n\n" + ChatColor.GRAY +
                        "Current boost: " + ChatColor.AQUA +  "+" + getXpIncrease(uuid) + " cap\n\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "32 Renown Tokens", 1, true);
    }

    public static ItemStack CorruptedPearl(){
        return ItemMaker(Material.EYE_OF_ENDER, ChatColor.YELLOW + "Corrupted Pearl",
                ChatColor.GRAY + "Each purchase gives you " + ChatColor.LIGHT_PURPLE + "+1 Corrupted Pearl!\n" + ChatColor.GRAY +
                        "Using a corrupted pearl will teleport a\n" + ChatColor.GRAY +
                        "random player to you and strike them with" + ChatColor.DARK_PURPLE + " venom!" + "\n\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "64 Renown Tokens", 1, true);
    }

    public static ItemStack QuesterKit(){
        return ItemMaker(Material.NETHER_STAR, ChatColor.YELLOW + "3 Questeteers",
                ChatColor.GRAY + "Gives you the 3 necessary\n" + ChatColor.GRAY +
                        "questing tools. Use these\n" + ChatColor.GRAY +
                        "while doing quests or finding cakes\n" + ChatColor.GRAY + "or maybe just for fun!\n\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "640 Renown Tokens", 1, true);
    }

    public static ItemStack ReaperScythe(){
        return ItemMaker(Material.DIAMOND_HOE, ChatColor.YELLOW + "Reaper Scythe",
                ChatColor.GRAY + "Gives you the necessary\n" + ChatColor.GRAY +
                        "tool to harvest souls.\n" + ChatColor.GRAY +
                        "Be careful how you use it!\n\n" +
                        ChatColor.RED + "Requires prestige XV\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "192 Renown Tokens", 1, true);
    }

    public static ItemStack MysticismDropItem(String uuid){
        return ItemMaker(Material.ENCHANTMENT_TABLE, ChatColor.YELLOW + "Mysticism",
                ChatColor.GRAY + "Current: " + ChatColor.LIGHT_PURPLE +
                        "+" + Math.round(MysticismChance.getMysticismChance(uuid) * 1000) + "% chance\n" +
                        ChatColor.GRAY + "Grants you a higher drop\n" + ChatColor.GRAY + "chance for mystics.\n\n" +
                        ChatColor.RED + "Requires prestige V\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + Math.round((MysticismChance.getMysticismChance(uuid) * 1000) * 64) +" Renown Tokens", 1, true);
    }

    public static ItemStack NuclearAtomizer(){
        return ItemMaker(Material.FIREWORK_CHARGE, ChatColor.YELLOW + "Nuclear Atomizer",
                ChatColor.GRAY + "Atomizes renown tokens to\n" + ChatColor.GRAY + "produce temporary stat\n" +
                        ChatColor.GRAY + "boosts. Stat boosts will\n" + ChatColor.GRAY + "randomly decay and\n" +
                        ChatColor.GRAY + "return to ashes.\n\n" + ChatColor.RED + "Requires prestige XXX\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "640 Renown Tokens", 1, true);
    }

    public static ItemStack UberDrop(){
        return ItemMaker(Material.ENDER_CHEST, ChatColor.YELLOW + "Uberdrop",
                ChatColor.GRAY + "Each purchase gives you " + ChatColor.LIGHT_PURPLE + "+1 Uberdrop!\n" + ChatColor.GRAY +
                        "Left clicking with an Uberdrop will\n" + ChatColor.GRAY +
                        "grant you a random uberdrop!\n\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "16 Renown Tokens", 1, true);
    }

    public static ItemStack Boxers(){
        return ItemMaker(Material.LEATHER_LEGGINGS, ChatColor.YELLOW + "Colorful Boxers",
                ChatColor.GRAY + "Each purchase gives you a\n" + ChatColor.GRAY + "to roll 3 of these dyes:\n" +
                        ChatColor.GRAY + "- " + ChatColor.DARK_GRAY + "Midnight Dye\n" +
                        ChatColor.GRAY + "- " + ChatColor.RED + "Crimson Dye\n" +
                        ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "Strawberry Dye\n" +
                        ChatColor.GRAY + "- " + ChatColor.YELLOW + "Lemon Dye\n" +
                        ChatColor.GRAY + "- " + ChatColor.DARK_AQUA + "Sapphire Dye\n" +
                        ChatColor.GRAY + "- " + ChatColor.GOLD + "Tangerine Dye\n" +
                        ChatColor.GRAY + "- " + ChatColor.DARK_GREEN + "Prickly Dye\n\n" +
                        ChatColor.GRAY + "Cost: " + ChatColor.YELLOW + "5 Renown Tokens", 1, true);
    }
}
