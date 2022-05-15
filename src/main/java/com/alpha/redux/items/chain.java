package com.alpha.redux.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class chain {

    // Iron Armor
    public static ItemStack ChainChestplate;
    public static ItemStack ChainBoots;


    public static void init(){
        createChainBoots();
        createChainChestplate();
    }

    // Chain Armor
    private static void createChainChestplate() {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        ChainChestplate = item;
    }
    private static void createChainBoots() {
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        ChainBoots = item;
    }


}
