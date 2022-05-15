package com.alpha.redux.renownShop;

import com.alpha.redux.redux;

import java.util.HashMap;

public class damageDecrease {
    private static redux plugin;

    public damageDecrease(redux instance){
        plugin = instance;
    }

    public static HashMap<String, Integer> Damage_Decrease = new HashMap<>();

    public static void setDecrease(String player, int amount){
        Damage_Decrease.put(player, amount);
    }

    public static void addDecrease(String player, int amount){
        Damage_Decrease.put(player, Damage_Decrease.get(player)+amount);
    }

    public static void removeDecrease(String player, int amount){
        Damage_Decrease.put(player, Damage_Decrease.get(player)-amount);
    }

    public static int getDecrease(String player){
        hasDecrease(player);
        return Damage_Decrease.get(player);
    }

    public static HashMap<String, Integer> getDecreaseMap(){
        return Damage_Decrease;
    }

    public static boolean hasDecrease(String player){
        if(Damage_Decrease.containsKey(player)){
            return true;
        }else{
            Damage_Decrease.put(player, 0);
            return true;
        }
    }

    public static redux getPlugin(){
        return plugin;
    }
}
