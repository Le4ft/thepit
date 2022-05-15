package com.alpha.redux.well;

import com.alpha.redux.redux;

import java.util.HashMap;

public class containsFresh {

    public static HashMap<String, Boolean> Fresh = new HashMap<>();

    public static void setFresh(String player, Boolean amount){
        Fresh.put(player, amount);
    }

    public static Boolean getFresh(String player){
        return Fresh.get(player);
    }

    public static boolean hasFresh(String player){
        if(Fresh.containsKey(player)){
            return true;
        }else{
            Fresh.put(player, false);
        }
        return true;
    }
    
}
