package com.alpha.redux.DeathHandler;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MysticUtils {
    public static void MysticLivesHandler(Player player, ItemStack item){
        String lives = item.getItemMeta().getLore().get(0);

        if(ChatColor.stripColor(lives).contains("Lives: 1/20")){
            player.getInventory().removeItem(item);
        }

        try{
            if(ChatColor.stripColor(player.getInventory().getLeggings().getItemMeta().getLore().get(0)).contains("Lives: 1/20")){
                player.getInventory().setLeggings(null);
            }

        } catch (Exception e) {

        }

        if(ChatColor.stripColor(lives).contains("Lives: 0/20")){
            player.getInventory().removeItem(item);
        }

        try{
            if(ChatColor.stripColor(player.getInventory().getLeggings().getItemMeta().getLore().get(0)).contains("Lives: 0/20")){
                player.getInventory().setLeggings(null);
            }

        } catch (Exception e) {

        }

        ItemMeta meta = item.getItemMeta();
        meta.setLore(MysticLivesCounter(meta.getLore()));
        item.setItemMeta(meta);

    }

    public static List<String> MysticLivesCounter(List<String> lore){
        String lives = lore.get(0);

        if(ChatColor.stripColor(lives).contains("Lives: 20/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 20/20", "§7Lives: §a19§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 19/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 19/20", "§7Lives: §a18§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 18/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 18/20", "§7Lives: §a17§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 17/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 17/20", "§7Lives: §a16§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 16/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 16/20", "§7Lives: §a15§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 15/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 15/20", "§7Lives: §a14§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 14/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 14/20", "§7Lives: §a13§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 13/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 13/20", "§7Lives: §a12§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 12/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 12/20", "§7Lives: §a11§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 11/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 11/20", "§7Lives: §a10§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 10/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 10/20", "§7Lives: §a9§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 9/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 9/20", "§7Lives: §a8§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 8/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 8/20", "§7Lives: §a7§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 7/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 7/20", "§7Lives: §a6§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 6/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 6/20", "§7Lives: §a5§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 5/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 5/20", "§7Lives: §a4§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 4/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 4/20", "§7Lives: §a3§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 3/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 3/20", "§7Lives: §a2§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 2/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 2/20", "§7Lives: §a1§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 1/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 1/20", "§7Lives: §a0§7/20"));
            return lore;
        }else{
            return lore;
        }
    }

    public static List<String> MysticRepairs(List<String> lore){
        String lives = lore.get(0);

        if(ChatColor.stripColor(lives).contains("Lives: 20/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 20/20", "§7Lives: §a19§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 19/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 19/20", "§7Lives: §a18§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 18/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 18/20", "§7Lives: §a17§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 17/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 17/20", "§7Lives: §a16§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 16/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 16/20", "§7Lives: §a15§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 15/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 15/20", "§7Lives: §a14§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 14/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 14/20", "§7Lives: §a13§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 13/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 13/20", "§7Lives: §a12§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 12/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 12/20", "§7Lives: §a11§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 11/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 11/20", "§7Lives: §a10§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 10/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 10/20", "§7Lives: §a9§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 9/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 9/20", "§7Lives: §a8§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 8/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 8/20", "§7Lives: §a7§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 7/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 7/20", "§7Lives: §a6§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 6/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 6/20", "§7Lives: §a5§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 5/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 5/20", "§7Lives: §a4§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 4/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 4/20", "§7Lives: §a3§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 3/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 3/20", "§7Lives: §a2§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 2/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 2/20", "§7Lives: §a1§7/20"));
            return lore;
        }else if(ChatColor.stripColor(lives).contains("Lives: 1/20")){
            lore.set(0, lore.get(0).replaceAll("Lives: 1/20", "§7Lives: §a0§7/20"));
            return lore;
        }else{
            return lore;
        }
    }


    public static void registerCommonItems(Player p){
        for(ItemStack i : p.getInventory().getContents()){
            try{
                if(i.getType().equals(Material.GOLD_SWORD)){
                    if(ChatColor.stripColor(i.getItemMeta().getDisplayName()).contains("Tier")){
                        MysticLivesHandler(p, i);
                    }
                }
            }catch (Exception e){

            }

            try{
                if(i.getType().equals(Material.LEATHER_LEGGINGS)){
                    if(ChatColor.stripColor(i.getItemMeta().getDisplayName()).contains("Tier")){
                        MysticLivesHandler(p, i);
                    }
                }
            } catch (Exception e) {

            }

        }

    }
}
