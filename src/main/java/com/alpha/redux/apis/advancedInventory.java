package com.alpha.redux.apis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.Arrays;
import static org.bukkit.Bukkit.getServer;

public class advancedInventory {

    public static Inventory inv(Player player, int size , String string){
        return Bukkit.createInventory(player, size, string);
    }

    public static ItemStack cGlass(){
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) (7));
        ItemMeta null_meta = glass.getItemMeta();
        null_meta.setDisplayName(ChatColor.GRAY + " ");
        glass.setItemMeta(null_meta);
        return glass;
    }

    public static ItemStack ItemMaker(Material material, String name, String lore, int amount, Boolean guiItem){
        if (!guiItem){
            ItemStack item = new ItemStack(material, amount);
            ItemMeta null_meta = item.getItemMeta();
            if (!"NULL".equalsIgnoreCase(name)) {
                String[] lines = lore.split("\\n");
                ArrayList<String> table_lore = new ArrayList<>(Arrays.asList(lines));
                null_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
                null_meta.setDisplayName(name);
                null_meta.setLore(table_lore);
            }
            null_meta.spigot().setUnbreakable(true);
            item.setItemMeta(null_meta);
            return item;
        }
        ItemStack item = new ItemStack(material, amount);
        ItemMeta null_meta = item.getItemMeta();
        null_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        String[] lines = lore.split("\\n");
        ArrayList<String> table_lore = new ArrayList<>(Arrays.asList(lines));
        null_meta.setDisplayName(name);
        null_meta.setLore(table_lore);
        item.setItemMeta(null_meta);
        return item;
    }

    public static ItemStack DyeMaker(short dyeColor, String DisplayName, String lore){
        ItemStack dye = new ItemStack(351, 1, dyeColor);
        ItemMeta meta = dye.getItemMeta();
        meta.setDisplayName(DisplayName);
        String[] lines = lore.split("\\n");
        ArrayList<String> dye_lore = new ArrayList<>(Arrays.asList(lines));
        meta.setLore(dye_lore);
        dye.setItemMeta(meta);
        return dye;
    }

    public static ItemStack ClayMaker(short clayColor, String DisplayName, String lore){
        ItemStack dye = new ItemStack(159, 1, clayColor);
        ItemMeta meta = dye.getItemMeta();
        meta.setDisplayName(DisplayName);
        String[] lines = lore.split("\\n");
        ArrayList<String> dye_lore = new ArrayList<>(Arrays.asList(lines));
        meta.setLore(dye_lore);
        dye.setItemMeta(meta);
        return dye;
    }

    public static void addInv(Inventory inventory, ItemStack item, int x, int y, boolean null_stack){
        // Note: The first inventory slot in addInv starts 0 0 instead of 1 1 but supports 1 1 as origin as well.

        if (y <= 0){y++;}
        if (x <= 0){x++;}

        int invSize = inventory.getSize() / 9;

        if (y > invSize) {getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ERROR] Y coordinate is greater than possible."); return;}else if(x > 9){getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ERROR] X coordinate is greater than possible."); return;}

        int slot = ((y-1)*9) + (x-1);

        try{if (!null_stack) {inventory.setItem(slot, item);} else {inventory.setItem(slot, null);}
        }catch (Exception ignored){}

    }

}
