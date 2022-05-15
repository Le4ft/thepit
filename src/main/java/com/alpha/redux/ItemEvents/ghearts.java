package com.alpha.redux.ItemEvents;

import com.alpha.redux.redux;

import java.util.HashMap;

public class ghearts {
    public static HashMap<String, Double> Absorbtion = new HashMap<>();
    

    public static void setAbsorbtion(String player, double amount){
        Absorbtion.put(player, amount);
    }

    public static void addAbsorbtion(String player, double amount){
        Absorbtion.put(player, Absorbtion.get(player)+amount);
    }

    public static void removeAbsorbtion(String player, double amount){
        Absorbtion.put(player, Absorbtion.get(player)-amount);
    }

    public static Double getAbsorbtion(String player){
        return Absorbtion.get(player);
    }

    public static boolean hasAbsorbtion(String player){
        if(Absorbtion.containsKey(player)){
            return true;
        }else{
            Absorbtion.put(player, 0.0);
        }
        return true;
    }

}
