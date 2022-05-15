package com.alpha.redux.ItemEvents;

import com.alpha.redux.apis.Sounds;
import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.entityHandlers.ReduxPlayer;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.questMaster.bossBattles.maldingBoss;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.*;

import static com.alpha.redux.DeathHandler.killHandler.getNPC;
import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.ItemEvents.notgladiator.*;
import static com.alpha.redux.well.enchanters.*;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;

public class pants {
    public static Map<String, Boolean> escapeProc = new HashMap<String, Boolean>();
    public static Map<String, Integer> rgmHits = new HashMap<String, Integer>();
    public static Map<String, Double> critFunkyDamage = new HashMap<String, Double>();
    public static Map<String, Long> reguCD = new HashMap<String, Long>();
    public static List<UUID> DoubleHit = new ArrayList<UUID>();
    public static List<UUID> MaldingChestplate = new ArrayList<UUID>();
    public static HashMap<String, Integer> Venom_Hit = new HashMap<>();

    public static void VenomEvent(Player player, Player defender){
        try {
            if(isNPC(defender)){return;}
            if (defender.getInventory().getBoots() != null && defender.getInventory().getBoots().getItemMeta().equals(itemManager.arma.getItemMeta())) {
                Sounds.GAMBLE_NO.play(player);
            } else if (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getItemMeta().equals(itemManager.venom.getItemMeta())) {

                if(Venom_Hit.containsKey(String.valueOf(player.getUniqueId()))){
                    Venom_Hit.put(String.valueOf(player.getUniqueId()), Venom_Hit.get(String.valueOf(player.getUniqueId())) + 1);
                }else{
                    Venom_Hit.put(String.valueOf(player.getUniqueId()), 1);
                }

                if (Venom_Hit.get(String.valueOf(player.getUniqueId())) >= 4) {
                    Venom_Hit.put(String.valueOf(player.getUniqueId()), 0);

                    Sounds.VENOM.play(defender);
                    Sounds.VENOM.play(player);

                    defender.removePotionEffect(PotionEffectType.POISON);
                    defender.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 240, 1, true, true));

                    player.removePotionEffect(PotionEffectType.POISON);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 240, 1, true, true));
                }
                
            }
        }catch (Exception ignored){
        }

    }
    
    public static double criticalFunkyDamageCalculation(Player player, double tier, boolean hit){
        String uuid = String.valueOf(player.getUniqueId());
        if(hit){
            if (critFunkyDamage.containsKey(uuid)){
                double savedCrit = critFunkyDamage.get(uuid);

                critFunkyDamage.put(uuid, 0.0);

                return Math.max(savedCrit, 0.01);
            }
        }else{
            critFunkyDamage.put(uuid, tier);
        }
        return 0.01;
    }

    public static double CriticallyFunkyEvent(ReduxPlayer attacker, ReduxPlayer defender, Double damage, List<String> lore){

        Boolean Crit = attacker.getPlayerObject().isOnGround();
        try {
            if (defender.getPlayerObject().hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (CritFunky(defender.getPlayerObject().getInventory().getLeggings().getItemMeta().getLore())) {
                if (!Crit) {
                    List<String> list = CheckEnchantOnPant(lore);
                    for (String s : list) {
                        switch (s) {
                            case "critIII":
                                defender.setPlayerIncrease(.3);
                                return damage * .5;
                            case "critII":
                                defender.setPlayerIncrease(.14);
                                return damage * .65;
                            case "critI":
                                defender.setPlayerIncrease(.07);
                                return damage * .85;
                        }
                    }
                }else{
                    return 0.0;
                }
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static double RegularityEvent(Player attacker, Player defender, Double damage, List<String> lore){
        try {
            if (attacker.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (reg(attacker.getInventory().getLeggings().getItemMeta().getLore())) {
                List<String> list = CheckEnchantOnPant(lore);

                for (String s : list) {
                    if(attacker.getLocation().getY() <= 90 && defender.getLocation().getY() <= 90){
                        switch (s) {
                            case "regIII":

                                if (DoubleHit.contains(defender.getUniqueId())){
                                    return damage *.001;
                                }

                                DoubleHit.add(defender.getUniqueId());
                                //defender.setMaximumNoDamageTicks(0);
                                defender.damage(damage*.05, attacker);
                                DoubleHit.remove(defender.getUniqueId());

                                return damage *.001;

                            case "regII":

                                if (DoubleHit.contains(defender.getUniqueId())){
                                    return damage *.001;
                                }

                                DoubleHit.add(defender.getUniqueId());
                                //defender.setMaximumNoDamageTicks(0);
                                defender.damage(damage*.03, attacker);
                                DoubleHit.remove(defender.getUniqueId());

                                return damage *.001;

                            case "regI":

                                if (DoubleHit.contains(defender.getUniqueId())){
                                    return damage *.001;
                                }

                                DoubleHit.add(defender.getUniqueId());
                               // defender.setMaximumNoDamageTicks(0);
                                defender.damage(damage*.01, attacker);
                                DoubleHit.remove(defender.getUniqueId());

                                return damage *.001;
                        }
                    }

                }
            }else{
                return 0.0;
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static double triggerChestplateMalding(Player attacker, Player defender, Double damage){
        try {
            if (attacker.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            }

            if(isNPC(defender)){
                if(Objects.requireNonNull(getNPC(defender)).getName().equals(maldingBoss.maldingName)){
                    return 0.00001;
                }
            }


            if(attacker.getLocation().getY() <= 90 && defender.getLocation().getY() <= 90){
                if (MaldingChestplate.contains(defender.getUniqueId())){
                    return damage *.001;
                }

                MaldingChestplate.add(defender.getUniqueId());

                if(!isNPC(defender)){
                    defender.setFireTicks(50);
                }

                defender.damage(damage*.20, attacker);
                MaldingChestplate.remove(defender.getUniqueId());

                return damage *.001;
            }

                return 0.0;

        }catch (Exception e){}
        return 0.0;
    }

    public static double RetroGravityMicrocosm(Player attacker, Player defender, Double damage, List<String> lore){

        Boolean Crit = attacker.isOnGround();
        try {
            if (defender.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (rgm(defender.getInventory().getLeggings().getItemMeta().getLore())) {
                if (!Crit) {
                    if(rgmHits.containsKey(String.valueOf(defender.getUniqueId()))){
                        rgmHits.put(String.valueOf(defender.getUniqueId()), rgmHits.get(String.valueOf(defender.getUniqueId())) + 1);
                    }else{
                        rgmHits.put(String.valueOf(defender.getUniqueId()), 1);
                    }
                    List<String> list = CheckEnchantOnPant(lore);
                    for (String s : list) {
                        switch (s) {
                            case "rgmIII":
                                if(rgmHits.get(String.valueOf(defender.getUniqueId())) < 3){return 0.0;}
                                rgmHits.put(String.valueOf(defender.getUniqueId()), 0);
                                attacker.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&lRGM! &7Proc'd against " + rank.getNameColor(defender) + defender.getDisplayName() + "&7!"));
                                Sounds.RGM.play(attacker.getLocation(), 3);
                                defender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&lRGM! &7Procced against " + rank.getNameColor(attacker) + attacker.getDisplayName() + "&7!"));
                                defender.setHealth(Math.min(defender.getHealth() + 3, defender.getMaxHealth()));
                                attacker.setHealth(Math.max(attacker.getHealth() - 2, 2));
                            case "rgmII":
                                if(rgmHits.get(String.valueOf(defender.getUniqueId())) < 3){return 0.0;}
                                rgmHits.put(String.valueOf(defender.getUniqueId()), 0);
                                attacker.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&lRGM! &7Proc'd against " + rank.getNameColor(defender) + defender.getDisplayName() + "&7!"));
                                Sounds.RGM.play(attacker.getLocation(), 3);
                                defender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&lRGM! &7Procced against " + rank.getNameColor(attacker) + attacker.getDisplayName() + "&7!"));
                                defender.setHealth(Math.min(defender.getHealth() + 3, defender.getMaxHealth()));
                                attacker.setHealth(Math.max(attacker.getHealth() - 1, 1));
                            case "rgmI":
                                if(rgmHits.get(String.valueOf(defender.getUniqueId())) < 3){return 0.0;}
                                rgmHits.put(String.valueOf(defender.getUniqueId()), 0);
                                Sounds.RGM.play(attacker.getLocation(), 3);
                                attacker.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&lRGM! &7Proc'd against " + rank.getNameColor(defender) + defender.getDisplayName() + "&7!"));
                                defender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&lRGM! &7Procced against " + rank.getNameColor(attacker) + attacker.getDisplayName() + "&7!"));
                                defender.setHealth(Math.min(defender.getHealth() + 2, defender.getMaxHealth()));
                                attacker.setHealth(Math.max(attacker.getHealth() - .5, 1));
                        }
                    }
                }else{
                    return 0.0;
                }
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static void EscapePodEvent(Player attacker, Player defender, Double damage, List<String> lore){

        try {
            if (defender.hasPotionEffect(PotionEffectType.POISON)) {
                return;
            } else if (EscapePod(defender.getInventory().getLeggings().getItemMeta().getLore())) {
                List<String> list = CheckEnchantOnPant(lore);
                for (String s : list) {
                    switch (s) {
                        case "escapeIII":
                            if(!escapeProc.containsKey(String.valueOf(defender.getUniqueId()))){
                                escapeProc.put(String.valueOf(defender.getUniqueId()), false);
                            }
                            if(!escapeProc.get(String.valueOf(defender.getUniqueId()))){
                                if(defender.getHealth() - damage <= 14){
                                    escapeProc.put(String.valueOf(defender.getUniqueId()), true);

                                    ((Player) defender).setVelocity(defender.getVelocity().add(new Vector(0, 1.35, 0)));
                                    defender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 660, 3, true, true));
                                }
                            }
                        case "escapeII":
                            if(!escapeProc.containsKey(String.valueOf(defender.getUniqueId()))){
                                escapeProc.put(String.valueOf(defender.getUniqueId()), false);
                            }
                            if(!escapeProc.get(String.valueOf(defender.getUniqueId()))){
                                if(defender.getHealth() - damage <= 12){
                                    escapeProc.put(String.valueOf(defender.getUniqueId()), true);

                                    ((Player) defender).setVelocity(defender.getVelocity().add(new Vector(0, 1.35, 0)));
                                    defender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 660, 2, true, true));
                                }
                            }
                        case "escapeI":
                            if(!escapeProc.containsKey(String.valueOf(defender.getUniqueId()))){
                                escapeProc.put(String.valueOf(defender.getUniqueId()), false);
                            }
                            if(!escapeProc.get(String.valueOf(defender.getUniqueId()))){
                                if(defender.getHealth() - damage <= 10){
                                    escapeProc.put(String.valueOf(defender.getUniqueId()), true);

                                    ((Player) defender).setVelocity(defender.getVelocity().add(new Vector(0, 1.35, 0)));
                                    defender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 2, true, true));
                                }
                            }

                            return;
                    }
                }
            }else{
                return;
            }
        }catch (Exception e){}
        return;
    }

    public static double NotGlad(Player defender, Double damage, List<String> lore){
        try {
            if (defender.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (NotGladiator(defender.getInventory().getLeggings().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnPant(lore);

                for (String s : list) {
                    switch (s) {
                        case "gladIII":
                            return ng3(defender, damage);
                        case "gladII":
                            return ng2(defender, damage);
                        case "gladI":
                            return ng1(defender, damage);
                    }
                }
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static double solitudeEnchant(Player defender, Double damage, List<String> lore){
        try {
            if (defender.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (Solitude(defender.getInventory().getLeggings().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnPant(lore);

                for (String s : list) {
                    switch (s) {
                        case "soliIII":
                            if(ng3(defender, damage) <= .04){
                                return damage * .6;
                            }
                        case "soliII":
                            if(ng3(defender, damage) <= .04){
                                return damage * .5;
                            }
                        case "soliI":
                            if(ng3(defender, damage) <= .04){
                                return damage * .4;
                            }
                    }
                }
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static double Mirrors(Player defender, Double true_damage, List<String> lore){
        try {
            if (defender.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (Mirror(defender.getInventory().getLeggings().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnPant(lore);

                for (String s : list) {
                    switch (s) {
                        case "mirrorIII":
                            return 0;
                        case "mirrorII":
                            return .5;
                        case "mirrorI":
                            return .25;
                    }
                }
            }
        }catch (Exception e){}
        return 0.0;
    }



    public static double ProtectionEvent(Player defender, Double damage, List<String> lore){
        try {
            if (defender.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (Protection(defender.getInventory().getLeggings().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnPant(lore);

                for (String s : list) {
                    switch (s) {
                        case "protIII":
                            return damage * .1;
                        case "protII":
                            return damage * .06;
                        case "protI":
                            return damage * .04;
                    }
                }
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static double FractionEvent(ReduxPlayer defender){
        try {
            if (defender.getPlayerObject().hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (Fractional(defender.getLeggings().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnPant(defender.getLeggings().getItemMeta().getLore());

                for (String s : list) {
                    switch (s) {
                        case "fracIII":
                            return Math.min((defender.getPlayerGold() / 50000)*.01, .30);
                        case "fracII":
                            return Math.min((defender.getPlayerGold() / 50000)*.01, .21);
                        case "fracI":
                            return Math.min((defender.getPlayerGold() / 50000)*.01, .15);
                    }
                }
            }
        }catch (Exception e){}
        return 0.0;
    }

    public static void Peroxides(EntityDamageByEntityEvent event){
        Player defender = (Player) event.getEntity();
        try {
            if (isNPC(defender)){
            }else if (defender.hasPotionEffect(PotionEffectType.POISON)){
                return;
            }else if (Peroxide(defender.getInventory().getLeggings().getItemMeta().getLore())){

                List<String> list = CheckEnchantOnPant(defender.getInventory().getLeggings().getItemMeta().getLore());
                for (String s : list) {
                    switch (s) {
                        case "peroxideIII":
                            if(defender.hasPotionEffect(PotionEffectType.REGENERATION)){
                                return;
                            }else{
                                defender.removePotionEffect(PotionEffectType.REGENERATION);
                                defender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1, true, true));
                            }
                        case "peroxideII":
                            if(defender.hasPotionEffect(PotionEffectType.REGENERATION)){
                                return;
                            }else{
                                defender.removePotionEffect(PotionEffectType.REGENERATION);
                                defender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0, true, true));
                            }
                        case "peroxideI":
                            defender.setHealth(Math.min(defender.getHealth()+.5, defender.getMaxHealth()));
                            if(defender.hasPotionEffect(PotionEffectType.REGENERATION)){
                                return;
                            }else{
                                defender.removePotionEffect(PotionEffectType.REGENERATION);
                                defender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0, true, true));
                            }
                    }
                }

            }
        }catch (Exception e){

        }


    }


}
