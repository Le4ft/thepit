package com.alpha.redux.DeathHandler;

import com.alpha.redux.questMaster.bossBattles.bossAttackEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;

import static com.alpha.redux.apis.actionbarplus.sendKillBar;
import static com.alpha.redux.entityHandlers.ReduxPlayerHandler.playerExists;
import static com.alpha.redux.events.events.Has_Strength;
import static com.alpha.redux.events.events.Strength;
import static com.alpha.redux.DeathHandler.killHandler.processKill;
import static com.alpha.redux.playerdata.streaks.StreakManager;

public class ProccessHit {

    public static Double StrengthPerk(Player attacker){

        if(Strength.containsKey(String.valueOf(attacker.getUniqueId()))){
            if(Strength.get(String.valueOf(attacker.getUniqueId())) >= .4){
                return .4;
            }
            Strength.put(String.valueOf(attacker.getUniqueId()), Strength.get(String.valueOf(attacker.getUniqueId())) + .01);
            return Strength.get(String.valueOf(attacker.getUniqueId()));
        }else{
            Strength.put(String.valueOf(attacker.getUniqueId()), .01);
            return Strength.get(String.valueOf(attacker.getUniqueId()));
        }
    }



    public static Double StrengthCheck(Player attacker){
        if(Strength.containsKey(String.valueOf(attacker.getUniqueId()))){
            if(Strength.get(String.valueOf(attacker.getUniqueId())) >= .4){
                return .4;
            }
        }
        return Strength.get(String.valueOf(attacker.getUniqueId()));
    }

    public static void KillMan(Player attacker, Player defender){
        sendKillBar(attacker, defender);
        processKill(playerExists(attacker), playerExists(defender));
        ReduxDeathEvent mainEvent = new ReduxDeathEvent(playerExists(attacker), playerExists(defender));
        Bukkit.getPluginManager().callEvent(mainEvent);
        if (!mainEvent.isCancelled()) {
            mainEvent.setCancelled(true);
        }
    }


}
