package com.alpha.redux.events;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class MultiAuraProtection {
    public static HashMap<String, Integer> HitAmount = new HashMap<>();

    public static void addHitAmount(String player, int amount){
        HitAmount.put(player, HitAmount.get(player)+amount);
    }

    public static int getHitAmount(String player){
        return HitAmount.get(player);
    }

    public static boolean hasHitAmount(String player){
        if(HitAmount.containsKey(player)){
            return true;
        }else{
            HitAmount.put(player, 0);
        }
        return true;
    }


    public static void KickMultiAura(Player player){

    }


}
