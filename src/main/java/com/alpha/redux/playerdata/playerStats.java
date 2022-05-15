package com.alpha.redux.playerdata;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.*;

import static com.alpha.redux.playerdata.prestiges.getPrestigeMap;
import static com.alpha.redux.playerdata.streaks.*;

public class playerStats {

    public static List<String> GetHighestPrestige(){
        int max = Collections.max(getPrestigeMap().values());
        int storage_max = 0;
        int p1;
        int p2;
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : getPrestigeMap().entrySet()) {
            if (entry.getValue()==max) {
                keys.add(entry.getKey());
            }else if(entry.getValue() <= max){
                storage_max = entry.getValue();
            }
            
            if(!(entry.getValue() == max)){
                if(entry.getValue() > storage_max){

                }
            }
        }
        return keys;
    }

    public static List<Entry<String, Integer>> mainGetTop() {return findGreatest(getPrestigeMap(), 10);}

    private static <K, V extends Comparable<? super V>> List<Entry<K, V>>
    findGreatest(Map<K, V> map, int n)
    {
        Comparator<? super Entry<K, V>> comparator =
                (Comparator<Entry<K, V>>) (e0, e1) -> {
                    V v0 = e0.getValue();
                    V v1 = e1.getValue();
                    return v0.compareTo(v1);
                };
        PriorityQueue<Entry<K, V>> highest =
                new PriorityQueue<Entry<K,V>>(n, comparator);
        for (Entry<K, V> entry : map.entrySet())
        {
            highest.offer(entry);
            while (highest.size() > n)
            {
                highest.poll();
            }
        }

        List<Entry<K, V>> result = new ArrayList<Map.Entry<K,V>>();
        while (highest.size() > 0)
        {
            result.add(highest.poll());
        }
        return result;
    }

    public static void mega(Player player){
        String select_mega = "";
        boolean hasuber = false;
        String mega_color = "";
        int activate_amount = 50;
        hasMegaStreak(String.valueOf(player.getUniqueId()));
        if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "highlander")){
            select_mega = "Highlander";
            mega_color = "§6";
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "beastmode")){
            select_mega = "Beastmode";
            mega_color = "§a";
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "uber")){
            hasuber = true;
            select_mega = "Uberstreak";
            mega_color = "§d";
            activate_amount = 100;
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "moon")){
            select_mega = "To the Moon";
            mega_color = "§b";
            activate_amount = 100;
        }
        try{
            for (World w : Bukkit.getWorlds()) {
                for (Entity e : w.getEntities()) {
                    if (e instanceof ArmorStand) {
                        ((ArmorStand) e).damage(1000000);
                        /*
                        if (e.getName().equalsIgnoreCase(mega_color + select_mega + ChatColor.LIGHT_PURPLE + getStreak(String.valueOf(player.getUniqueId())))) {
                            ((ArmorStand) e).damage(10000000);
                        }else if (e.getName().equalsIgnoreCase(mega_color + select_mega)){
                            ((ArmorStand) e).damage(10000000);
                        }

                         */
                    }
                }
            }
        }catch (Exception e){
        }
        ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 1, 0), EntityType.ARMOR_STAND);
        hologram.setVisible(false);
        hologram.setGravity(false);
        hologram.setCustomNameVisible(true);
        if(hasuber){
            hologram.setCustomName(mega_color + select_mega + ChatColor.LIGHT_PURPLE + getStreak(String.valueOf(player.getUniqueId())));
        }else{
            hologram.setCustomName(mega_color + select_mega);
        }




    }

    public static void deleteHologramStreak(Player player){
        String select_mega = "";
        boolean hasuber = false;
        String mega_color = "";
        int activate_amount = 50;
        hasMegaStreak(String.valueOf(player.getUniqueId()));
        if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "highlander")){
            select_mega = "Highlander";
            mega_color = "§6";
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "beastmode")){
            select_mega = "Beastmode";
            mega_color = "§a";
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "uber")){
            hasuber = true;
            select_mega = "Uberstreak";
            mega_color = "§d";
            activate_amount = 100;
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "moon")){
            select_mega = "To the Moon";
            mega_color = "§b";
            activate_amount = 100;
        }

        for (World w : Bukkit.getWorlds()) {
            for (Entity e : w.getEntities()) {
                if (e instanceof ArmorStand) {
                    ((ArmorStand) e).damage(1000000);
                }
            }
        }
    }

/*
    public static void leaderboard(){
        ArmorStand hologram = (ArmorStand) spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        hologram.setVisible(false);
        hologram.setGravity(false);
        hologram.setCustomNameVisible(true);
        hologram.setCustomName(ChatColor.RED + "Hologram!");
        //Second line
        ArmorStand hologram2 = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, -0.5, 0), EntityType.ARMOR_STAND);
        hologram2.setVisible(false);
        hologram2.setGravity(false);
        hologram2.setCustomNameVisible(true);
        hologram2.setCustomName(ChatColor.AQUA + "Second line");
    }

 */






}
