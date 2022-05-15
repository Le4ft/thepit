package com.alpha.redux.renownShop;

import com.alpha.redux.redux;

import java.util.HashMap;

public class MysticismChance {

    private static redux plugin;

    public MysticismChance(redux instance){
        plugin = instance;
    }

    public static HashMap<String, Double> MysticismChanceMap = new HashMap<>();

    public static void setMysticismChance(String player, double amount){
        MysticismChanceMap.put(player, amount);
    }

    public static void addMysticismChance(String player, double amount){
        MysticismChanceMap.put(player, MysticismChanceMap.get(player)+amount);
    }

    public static void removeMysticismChance(String player, double amount){
        MysticismChanceMap.put(player, MysticismChanceMap.get(player)-amount);
    }

    public static double getMysticismChance(String player){
        hasMysticismChance(player);
        return MysticismChanceMap.get(player);
    }

    public static HashMap<String, Double> getMysticismChanceMap(){
        return MysticismChanceMap;
    }

    public static boolean hasMysticismChance(String player){
        if(MysticismChanceMap.containsKey(player)){
            return true;
        }else{
            MysticismChanceMap.put(player, 0.001);
            return true;
        }
    }

    public static redux getPlugin(){
        return plugin;
    }
    
}
