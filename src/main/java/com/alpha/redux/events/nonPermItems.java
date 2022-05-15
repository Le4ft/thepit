package com.alpha.redux.events;

import com.alpha.redux.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static com.alpha.redux.DeathHandler.MysticUtils.MysticLivesHandler;
import static com.alpha.redux.DeathHandler.MysticUtils.registerCommonItems;
import static com.alpha.redux.apis.advancedInventory.ItemMaker;
import static com.alpha.redux.playerdata.streaks.*;

public class nonPermItems {

    public static void ClearAndCheck(Player player){
        try {
            if (player.getInventory().containsAtLeast(itemManager.feather, 1)) {
                if(getStreak(String.valueOf(player.getUniqueId())) <= 249){
                    player.getInventory().removeItem(itemManager.feather);
                    player.sendMessage(ChatColor.AQUA + "Your funky feather just saved your items!");
                    return;
                }else{
                    player.sendMessage(ChatColor.GREEN + "Congrats! " + ChatColor.GRAY + "you reached a 250 kill streak and kept your" + ChatColor.DARK_AQUA + " Funky Feather" + ChatColor.GRAY + "!");
                }

            }else if (player.getInventory().containsAtLeast(itemManager.gmc_feather, 1)) {
                if(getStreak(String.valueOf(player.getUniqueId())) <= 249){
                    player.getInventory().removeItem(itemManager.gmc_feather);
                    player.sendMessage(ChatColor.AQUA + "Your funky feather just saved your items!");
                    return;
                }else{
                    player.sendMessage(ChatColor.GREEN + "Congrats! " + ChatColor.GRAY + "you reached a 250 kill streak and kept your" + ChatColor.DARK_AQUA + " Funky Feather" + ChatColor.GRAY + "!");
                }

            }else {

                hasStreak(String.valueOf(player.getUniqueId()));

                if(getStreak(String.valueOf(player.getUniqueId())) > 100){
                    player.sendMessage(ChatColor.GREEN + "Congrats! " + ChatColor.GRAY + "you reached a 100 kill streak and kept your lives!");
                }

                try {
                    if(Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "uber")){
                        registerCommonItems(player);
                    }else if(getStreak(String.valueOf(player.getUniqueId())) < 99){
                        try{
                            if(player.getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS)){
                                MysticLivesHandler(player, player.getInventory().getLeggings());
                            }
                        } catch (Exception e) {

                        }

                        registerCommonItems(player);
                    }


                } catch (Exception e) {

                }

                try {
                    if(player.getInventory().getLeggings().getItemMeta().equals(itemManager.moctezuma_three.getItemMeta())){
                        player.getInventory().setLeggings(null);
                    }

                    if(player.getInventory().contains(itemManager.moctezuma_three)){
                        player.getInventory().remove(itemManager.moctezuma_three);
                    }
                }catch (Exception e){

                }

                try {
                    if(player.getInventory().getLeggings().getItemMeta().equals(itemManager.sweaty_three.getItemMeta())){
                        player.getInventory().setLeggings(null);
                    }
                    if(player.getInventory().contains(itemManager.sweaty_three)){
                        player.getInventory().remove(itemManager.sweaty_three);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(ItemMaker(Material.OBSIDIAN, "NULL", "NULL", 1, false))){
                        player.getInventory().remove(ItemMaker(Material.OBSIDIAN, "NULL", "NULL", 1, false));
                    }
                }catch (Exception e){

                }

                try {
                    if(player.getInventory().contains(itemManager.Moctezuma_sword_three)){
                        player.getInventory().remove(itemManager.Moctezuma_sword_three);
                    }

                    if(player.getInventory().contains(itemManager.sweaty_sword_three)){
                        player.getInventory().remove(itemManager.sweaty_sword_three);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(ItemMaker(Material.DIAMOND_SWORD, "NULL", "NULL", 1, false))) {
                        player.getInventory().remove(ItemMaker(Material.DIAMOND_SWORD, "NULL", "NULL", 1, false));
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(ItemMaker(Material.DIAMOND_SPADE, ChatColor.AQUA + "Combat Spade", ChatColor.GRAY + "Deals " + ChatColor.BLUE +
                            "+1 damage per\n" + ChatColor.AQUA + "diamond piece " + ChatColor.GRAY + "on enemy." + "\n\n" +
                            ChatColor.BLUE + "+7 Attack Damage", 1, false))) {
                        player.getInventory().remove(ItemMaker(Material.DIAMOND_SPADE, ChatColor.AQUA + "Combat Spade", ChatColor.GRAY + "Deals " + ChatColor.BLUE +
                                "+1 damage per\n" + ChatColor.AQUA + "diamond piece " + ChatColor.GRAY + "on enemy." + "\n\n" +
                                ChatColor.BLUE + "+7 Attack Damage", 1, false));
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().getLeggings().equals(itemManager.DiamondLeggings)) {
                        player.getInventory().setLeggings(null);
                    }
                }catch (Exception e){

                }

                try {
                    if ((player.getInventory().getChestplate().equals(itemManager.DiamondChestplate))) {
                        player.getInventory().setChestplate(null);
                    }
                }catch (Exception e){

                }


                try {
                    if ((player.getInventory().getBoots().equals(itemManager.DiamondBoots))) {
                        player.getInventory().setBoots(null);
                    }
                }catch (Exception e){

                }

                try {
                    if ((player.getInventory().getHelmet().equals(itemManager.DiamondHelmet))) {
                        player.getInventory().setHelmet(null);
                    }
                }catch (Exception e){

                }


                try {
                    if (player.getInventory().contains(itemManager.DiamondBoots)) {
                        player.getInventory().remove(itemManager.DiamondBoots);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(itemManager.DiamondChestplate)) {
                        player.getInventory().remove(itemManager.DiamondChestplate);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(itemManager.DiamondSword)) {
                        player.getInventory().remove(itemManager.DiamondSword);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(itemManager.DiamondBoots)) {
                        player.getInventory().remove(itemManager.DiamondBoots);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(itemManager.DiamondLeggings)) {
                        player.getInventory().remove(itemManager.DiamondLeggings);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(itemManager.DiamondHelmet)) {
                        player.getInventory().remove(itemManager.DiamondHelmet);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(ItemMaker(Material.DIAMOND_BOOTS, "NULL", "NULL", 1, false))) {
                        player.getInventory().remove(ItemMaker(Material.DIAMOND_BOOTS, "NULL", "NULL", 1, false));
                    }

                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(ItemMaker(Material.DIAMOND_LEGGINGS, "NULL", "NULL", 1, false))) {
                        player.getInventory().remove(ItemMaker(Material.DIAMOND_LEGGINGS, "NULL", "NULL", 1, false));
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().contains(ItemMaker(Material.DIAMOND_CHESTPLATE, "NULL", "NULL", 1, false))) {
                        player.getInventory().remove(ItemMaker(Material.DIAMOND_CHESTPLATE, "NULL", "NULL", 1, false));
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().getLeggings().equals(ItemMaker(Material.DIAMOND_LEGGINGS, "NULL", "NULL", 1, false))) {
                        player.getInventory().setLeggings(null);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().getChestplate().equals(ItemMaker(Material.DIAMOND_CHESTPLATE, "NULL", "NULL", 1, false))) {
                        player.getInventory().setChestplate(null);
                    }
                }catch (Exception e){

                }

                try {
                    if (player.getInventory().getBoots().equals(ItemMaker(Material.DIAMOND_BOOTS, "NULL", "NULL", 1, false))) {
                        player.getInventory().setBoots(null);
                    }

                }catch (Exception e){

                }




            }

        }catch(Exception e){
                return;
            }


        }
    }
