package com.alpha.redux.ItemEvents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class sharkCalc {
    public static int getSharkPlayers(Player player){

        int pAmount = 0;

        for(Entity players : player.getNearbyEntities(12, 12, 12)){
            if(players instanceof Player){
                Player current = (Player) players;
                if((current.getHealth()/2) <= 10){
                    pAmount++;
                }
            }
        }
        return pAmount;
    }

    public static int getGladPlayers(Player player){

        int pAmount = 0;

        for(Entity players : player.getNearbyEntities(12, 12, 12)){
            if(players instanceof Player){
                Player current = (Player) players;
                    pAmount++;
            }
        }
        return Math.min(pAmount, 10);
    }
}
