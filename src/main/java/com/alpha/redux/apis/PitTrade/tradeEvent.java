package com.alpha.redux.apis.PitTrade;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class tradeEvent implements Listener {

    public static HashMap<Player,Player> tradingPlayers = new HashMap<Player,Player>();

    public static void addPlayersToTradelist(Player p1, Player p2){
        tradingPlayers.put(p1, p2);
    }

    @EventHandler
    public void onPlayerInventoryClick(InventoryClickEvent e){
        if(e.getInventory().getTitle().equals("You              Other")){
            Player p = (Player) e.getWhoClicked();
            if(tradingPlayers.containsKey(p)){ //player 1

                if(e.getSlot() <= 8 || e.getSlot() == 17 || e.getSlot() >= 27){
                    if(e.getSlot() == 17){
                        accept(p,e.getCurrentItem());
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(true);
                }

            } else { //player 2

                if(e.getSlot() >= 17){
                    if(e.getSlot() == 17){
                        accept(p,e.getCurrentItem());
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(true);
                }

            }
        }
    }

    public void accept(Player p, ItemStack item){
        if(item.getType().equals(Material.REDSTONE_BLOCK)){
            item.setType(Material.EMERALD_BLOCK);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(p.getName());
            item.setItemMeta(meta);
        } else if (item.getType().equals(Material.EMERALD_BLOCK)){
            if(item.getItemMeta().getDisplayName().equals(p.getName())){
                item.setType(Material.REDSTONE_BLOCK);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(null);
                item.setItemMeta(meta);
            } else {
                Bukkit.broadcastMessage("Trade accepted");
            }
        }
    }

}