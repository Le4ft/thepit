package com.alpha.redux.renownShop;

import java.util.HashMap;
import com.alpha.redux.redux;

public class damageIncrease {
    private static redux plugin;

    public damageIncrease(redux instance){
        plugin = instance;
    }

    public static HashMap<String, Integer> Damage_Increase = new HashMap<>();

    public static void setIncrease(String player, int amount){
        Damage_Increase.put(player, amount);
    }

    public static void addIncrease(String player, int amount){
        Damage_Increase.put(player, Damage_Increase.get(player)+amount);
    }

    public static void removeIncrease(String player, int amount){
        Damage_Increase.put(player, Damage_Increase.get(player)-amount);
    }

    public static int getIncrease(String player){
        hasIncrease(player);
        return Damage_Increase.get(player);
    }

    public static HashMap<String, Integer> getIncreaseMap(){
        return Damage_Increase;
    }

    public static boolean hasIncrease(String player){
        if(Damage_Increase.containsKey(player)){
            return true;
        }else{
            Damage_Increase.put(player, 0);
            return true;
        }
    }

    public static redux getPlugin(){
        return plugin;
    }
}
