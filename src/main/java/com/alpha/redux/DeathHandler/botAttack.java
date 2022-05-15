package com.alpha.redux.DeathHandler;

import net.citizensnpcs.api.event.NPCDamageEntityEvent;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;

import static com.alpha.redux.DeathHandler.ProccessHit.KillMan;
import static com.alpha.redux.DeathHandler.ProccessHit.StrengthCheck;
import static com.alpha.redux.events.events.cooldowns;
import static com.alpha.redux.playerdata.streaks.mega_damage_amount;
import static com.alpha.redux.playerdata.streaks.true_damage_amount;

public class botAttack {
    public static void BotKillerActions(NPCDamageEntityEvent event){
        cooldowns.put(String.valueOf(event.getDamaged().getUniqueId()), System.currentTimeMillis() + (5 * 1000));
        Player attacker = (Player) event.getNPC();
        Player defender = (Player) event.getDamaged();
        double damage = event.getDamage();
        double true_dmg = 0;

        try {
            if(mega_damage_amount.containsKey(String.valueOf(defender.getUniqueId()))){
                damage += mega_damage_amount.get(String.valueOf(defender.getUniqueId()));
            }
        }catch (Exception e){

        }

        try {
            if(true_damage_amount.containsKey(String.valueOf(defender.getUniqueId()))){
                true_dmg += true_damage_amount.get(String.valueOf(defender.getUniqueId()));
            }
        }catch (Exception e){

        }

        // Pant enchants


        try{
            if (event.getDamaged() instanceof Damageable) {
                ((Damageable) event.getDamaged()).damage(damage);
            }
        }catch (Exception e){

        }


        if (attacker.getLocation().getY() >= 80){
            event.setCancelled(true);
            return;
        }

        if (defender.getHealth() - (2 + true_dmg) >= -2 && defender.getHealth() - (2 + true_dmg) <= 1.5) {
            event.setCancelled(true);
            KillMan(attacker, defender);
        }else{try{
            defender.setHealth(Math.min(defender.getHealth() - true_dmg, defender.getMaxHealth()));
        }catch (Exception e){}}
    }
}
