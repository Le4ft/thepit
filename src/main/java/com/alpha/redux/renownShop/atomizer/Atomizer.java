package com.alpha.redux.renownShop.atomizer;

import com.alpha.redux.apis.advancedInventory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static com.alpha.redux.well.EnchantingMechanics.getEnchants;

public class Atomizer {

    public static ItemStack totallyLegitGem = advancedInventory.ItemMaker(Material.EMERALD, ChatColor.RED + "Totally Legit Gem", ChatColor.translateAlternateColorCodes('&',
            "&7Adds &d1 tier&7 to a\n &c&lrandom &7mystic enchant.\n\n&7Renown Cost: &e576 Renown Tokens\n&7Gold Cost: &632,000,000g"),
            1, true);

    public static ItemStack heistOne = advancedInventory.ItemMaker(Material.GOLD_BOOTS, ChatColor.RED + "Heist Master", ChatColor.translateAlternateColorCodes('&',
                    "&e50% &7chance to double &c&lSOME &7rewards!\n\n&7Renown Cost: &e576 Renown Tokens\n&7Gold Cost: &632,000,000g"),
            1, true);


    public static ItemStack heistTwo = advancedInventory.ItemMaker(Material.GOLD_BOOTS, ChatColor.RED + "Heist Master II", ChatColor.translateAlternateColorCodes('&',
                    "&e100% &7chance to double &c&lSOME &7rewards!\n\n&7Renown Cost: &e1152 Renown Tokens\n&7Gold Cost: &664,000,000g"),
            1, true);

    public static ItemStack heistThree = advancedInventory.ItemMaker(Material.GOLD_BOOTS, ChatColor.RED + "Heist Master III", ChatColor.translateAlternateColorCodes('&',
                    "&e100% &7chance to triple &c&lSOME &7rewards!\n\n&7Renown Cost: &e1728 Renown Tokens\n&7Gold Cost: &696,000,000g"),
            1, true);

    public static ItemStack armageddon = advancedInventory.ItemMaker(Material.LEATHER_BOOTS, ChatColor.RED + "Armageddon Boots", ChatColor.translateAlternateColorCodes('&',
                    "&7You're invincible to &avenom's\n\n&7Renown Cost: &e256 Renown Tokens\n&7Gold Cost: &615,000,000g"),
            1, true);

    public static ItemStack venoms = advancedInventory.ItemMaker(Material.LEATHER_LEGGINGS, ChatColor.RED + "Venom Pants", ChatColor.translateAlternateColorCodes('&',
                    "&7Infect people with a\n&7vicious venom rendering their\n&7mystics unstable.\n\n&7Renown Cost: &e256 Renown Tokens\n&7Gold Cost: &610,000,000g"),
            1, true);

    public static ItemStack xpBoost = advancedInventory.DyeMaker((short) 6, ChatColor.RED + "Experience Atom", ChatColor.translateAlternateColorCodes('&',
                    "&7Doubles all experience income. Decays\n&7over a span of 15 minutes.\n\n&7Renown Cost: &e192 Renown Tokens"));

    public static ItemStack goldBoost = advancedInventory.DyeMaker((short) 14, ChatColor.RED + "Gold Atom", ChatColor.translateAlternateColorCodes('&',
                    "&7Doubles all gold income. Decays\n&7over a span of 10 minutes.\n\n&7Renown Cost: &e128 Renown Tokens"));

    public static Inventory inventoryConstructor(Player player){

        Inventory gui = advancedInventory.inv(player, 27, ChatColor.LIGHT_PURPLE + "Nuclear Atomizer");
        ItemStack base_glass = advancedInventory.cGlass();

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, totallyLegitGem);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, heistOne);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, heistTwo);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, heistThree);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, xpBoost);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, goldBoost);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, armageddon);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, venoms);
                break;
            }
        }

        for (int i = 0; i < gui.getSize(); i++) if (gui.getItem(i) == null) gui.setItem(i, base_glass);

        return gui;
    }

}
