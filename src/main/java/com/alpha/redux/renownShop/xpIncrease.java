package com.alpha.redux.renownShop;

import com.alpha.redux.redux;

import java.util.HashMap;

public class xpIncrease {
    private static redux plugin;

    public xpIncrease(redux instance){
        plugin = instance;
    }

    public static HashMap<String, Integer> xpIncrease = new HashMap<>();

    public static void setXpIncrease(String player, int amount){
        xpIncrease.put(player, amount);
    }

    public static void addXpIncrease(String player, int amount){
        xpIncrease.put(player, xpIncrease.get(player)+amount);
    }

    public static void removeXpIncrease(String player, int amount){
        xpIncrease.put(player, xpIncrease.get(player)-amount);
    }

    public static int getXpIncrease(String player){
        hasXpIncrease(player);
        return xpIncrease.get(player);
    }

    public static HashMap<String, Integer> getXpIncreaseMap(){
        return xpIncrease;
    }

    public static boolean hasXpIncrease(String player){
        if(xpIncrease.containsKey(player)){
            return true;
        }else{
            xpIncrease.put(player, 0);
            return true;
        }
    }

    public static redux getPlugin(){
        return plugin;
    }
}
