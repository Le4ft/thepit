package com.alpha.redux.ItemEvents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import static com.alpha.redux.DeathHandler.killHandler.isNPC;


public class notgladiator {
    public static double ng3(Player defender, Double damage){

        double dmg_reduction = 0.0;

        for (org.bukkit.entity.Entity player : defender.getNearbyEntities(15, 15, 15)){

            if (player instanceof Player){
                dmg_reduction += .02;

            }
        }

        return damage * Math.min(dmg_reduction, .2);
    }

    public static double ng2(Player defender, Double damage){
        double dmg_reduction = 0.0;

        for (org.bukkit.entity.Entity player : defender.getNearbyEntities(15, 15, 15)){

            if (player instanceof Player){
                dmg_reduction += .015;

            }
        }

        return damage * Math.min(dmg_reduction, .15);
    }

    public static double ng1(Player defender, Double damage){
        double dmg_reduction = 0.0;

        for (org.bukkit.entity.Entity player : defender.getNearbyEntities(15, 15, 15)){

            if (player instanceof Player){
                dmg_reduction += .01;

            }
        }

        return damage * Math.min(dmg_reduction, .10);
    }
}
