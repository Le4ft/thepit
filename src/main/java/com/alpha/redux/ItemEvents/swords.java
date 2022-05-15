package com.alpha.redux.ItemEvents;

import com.alpha.redux.apis.Sounds;
import com.alpha.redux.entityHandlers.ReduxPlayer;
import com.alpha.redux.events.boards;
import com.alpha.redux.questMaster.bossBattles.maldingBoss;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.alpha.redux.DeathHandler.ProccessHit.StrengthCheck;
import static com.alpha.redux.DeathHandler.killHandler.getNPC;
import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.ItemEvents.executioner.playParticle;
import static com.alpha.redux.ItemEvents.sharkCalc.getSharkPlayers;
import static com.alpha.redux.apis.strikeLight.strikeLightningForPlayers;
import static com.alpha.redux.playerdata.economy.getEconomy;
import static com.alpha.redux.playerdata.economy.removeEconomy;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;
import static com.alpha.redux.well.swordEnchanter.*;

public class swords {

    public static HashMap<String, Integer> Perun_Hit = new HashMap<>();

    public static double Billionaire(Player player, Double damage, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (Billion(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "billIII":
                            if (getEconomy(String.valueOf(player.getUniqueId())) >= 350) {
                                removeEconomy(String.valueOf(player.getUniqueId()), 350);
                                boards.CreateScore(player);
                                Sounds.BILLIONAIRE.play(player.getLocation(), 1);
                                return damage * 1.5;
                            }
                            break;
                        case "billII":
                            if (getEconomy(String.valueOf(player.getUniqueId())) >= 200) {
                                removeEconomy(String.valueOf(player.getUniqueId()), 200);
                                boards.CreateScore(player);
                                Sounds.BILLIONAIRE.play(player.getLocation(), 1);
                                return damage * 1.25;
                            }
                            break;
                        case "billI":
                            if (getEconomy(String.valueOf(player.getUniqueId())) >= 100) {
                                removeEconomy(String.valueOf(player.getUniqueId()), 100);
                                boards.CreateScore(player);
                                Sounds.BILLIONAIRE.play(player.getLocation(), 1);
                                return damage * 1;
                            }
                            break;
                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double KingBuster(Player player, Player defender, Double damage, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (Kingbust(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "kingIII":
                            if (defender.getHealth() >= (defender.getMaxHealth() / 2)){
                                return damage * .20;
                            }
                            break;
                        case "kingII":
                            if (defender.getHealth() >= (defender.getMaxHealth() / 2)){
                                return damage * .13;
                            }
                            break;
                        case "kingI":
                            if (defender.getHealth() >= (defender.getMaxHealth() / 2)){
                                return damage * .07;
                            }
                            break;
                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double GambleSword(Player player, Double damage, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (gamble(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "gambIII":
                            Sounds.GAMBLE_YES.play(player.getLocation(), 1);
                            return damage * 1;
                        case "gambII":
                            Sounds.GAMBLE_YES.play(player.getLocation(), 1);
                            return damage * .75;
                        case "gambI":
                            Sounds.GAMBLE_YES.play(player.getLocation(), 1);
                            return damage * .50;

                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double DiamondStomp(ReduxPlayer player, ReduxPlayer defender, Double damage, List<String> lore){
        try {
            if (player.getPlayerObject().hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (diamondstomp(player.getPlayerObject().getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "diamondIII":
                            if(defender.getHelmet() != null && defender.getHelmet().getType().equals(Material.DIAMOND_HELMET) || defender.getChestplate() != null &&  defender.getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE) || defender.getLeggings() != null && defender.getLeggings().getType().equals(Material.DIAMOND_LEGGINGS) || defender.getBoots() != null && defender.getBoots().getType().equals(Material.DIAMOND_BOOTS)) return damage * .25;
                        case "diamondII":
                            if(defender.getHelmet() != null && defender.getHelmet().getType().equals(Material.DIAMOND_HELMET) || defender.getChestplate() != null &&  defender.getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE) || defender.getLeggings() != null && defender.getLeggings().getType().equals(Material.DIAMOND_LEGGINGS) || defender.getBoots() != null && defender.getBoots().getType().equals(Material.DIAMOND_BOOTS)) return damage * .12;
                        case "diamondI":
                            if(defender.getHelmet() != null && defender.getHelmet().getType().equals(Material.DIAMOND_HELMET) || defender.getChestplate() != null &&  defender.getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE) || defender.getLeggings() != null && defender.getLeggings().getType().equals(Material.DIAMOND_LEGGINGS) || defender.getBoots() != null && defender.getBoots().getType().equals(Material.DIAMOND_BOOTS)) return damage * .06;

                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double PainFocusEvent(ReduxPlayer player, ReduxPlayer defender, Double damage, List<String> lore){
        try {
            if (player.getPlayerObject().hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (PainFocus(player.getPlayerObject().getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "pfIII":
                            return Math.min((player.getPlayerObject().getMaxHealth() - player.getPlayerObject().getHealth()) / 2, 2) * .08;
                        case "pfII":
                            return Math.min((player.getPlayerObject().getMaxHealth() - player.getPlayerObject().getHealth()) / 2, 2) * .05;
                        case "pfI":
                            return Math.min((player.getPlayerObject().getMaxHealth() - player.getPlayerObject().getHealth()) / 2, 2) * .03;

                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double Perun(Player player, Player defender, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (PerunWrath(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                if(Perun_Hit.containsKey(String.valueOf(player.getUniqueId()))){
                    Perun_Hit.put(String.valueOf(player.getUniqueId()), Perun_Hit.get(String.valueOf(player.getUniqueId())) + 1);
                }else{
                    Perun_Hit.put(String.valueOf(player.getUniqueId()), 1);
                }

                for (String s : list) {
                    switch (s) {
                        case "perunIII":
                            if (Perun_Hit.get(String.valueOf(player.getUniqueId())) >= 4) {
                                Perun_Hit.put(String.valueOf(player.getUniqueId()), 0);
                                double diamond = 8;
                                try{
                                    if(defender.getInventory().getLeggings().getType().equals(Material.DIAMOND_LEGGINGS)){
                                        diamond += 5;
                                    }
                                } catch (Exception e) {

                                }

                                try {
                                    if (defender.getInventory().getLeggings().getType().equals(Material.DIAMOND_CHESTPLATE)) {
                                        diamond += 5;
                                    }
                                } catch (Exception e) {

                                }

                                try{
                                    if(defender.getInventory().getLeggings().getType().equals(Material.DIAMOND_BOOTS)){
                                        diamond += 5;
                                    }
                                } catch (Exception e) {

                                }
                                strikeLightningForPlayers(defender.getLocation(), player, defender);
                                return diamond;
                            }
                            break;
                        case "perunII":
                            if (Perun_Hit.get(String.valueOf(player.getUniqueId())) >= 4){
                                Perun_Hit.put(String.valueOf(player.getUniqueId()), 0);
                                strikeLightningForPlayers(defender.getLocation(), player, defender);
                                return 6;
                            }
                            break;
                        case "perunI":
                            if (Perun_Hit.get(String.valueOf(player.getUniqueId())) >= 5){
                                Perun_Hit.put(String.valueOf(player.getUniqueId()), 0);
                                strikeLightningForPlayers(defender.getLocation(), player, defender);
                                return 5;
                            }
                            break;
                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double Sharker(Player player, Player defender, Double damage, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (shark(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "sharkIII":
                            return damage * (Math.min(getSharkPlayers(player), 18) * .07 );
                        case "sharkII":
                                return damage * (Math.min(getSharkPlayers(player), 15) * .04 );
                        case "sharkI":
                            return damage * (Math.min(getSharkPlayers(player), 12) * .02 );
                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static double Lifesteals(Player player, Double damage, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (lifesteal(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "lsIII":
                            return Math.min(((damage/2) * .13), 3);
                        case "lsII":
                            return Math.min(((damage/2) * .08), 2);
                        case "lsI":
                            return Math.min(((damage/2) * .04), 1.5);
                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }

    public static boolean EXEcutioner(Player player, Player defender, Double damage, List<String> lore){
        try {

            if(isNPC(defender)){
                if(Objects.requireNonNull(getNPC(defender)).getName().equals(maldingBoss.maldingName)){
                    return false;
                }
            }

            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return false;
            } else if (execution(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "exeIII":
                            if(isNPC(defender)){
                                if(defender.getHealth() - damage <= 6){
                                    Sounds.EXE.play(player.getLocation(), 2);
                                    player.getWorld().playEffect(defender.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                                    return true;
                                }
                                break;
                            }else{
                                if(defender.getHealth() <= 5){
                                    Sounds.EXE.play(player.getLocation(), 2);
                                    player.getWorld().playEffect(defender.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                                    return true;
                                }
                                break;
                            }
                        case "exeII":
                            if(isNPC(defender)){
                                if(defender.getHealth() - damage <= 4){
                                    Sounds.EXE.play(player.getLocation(), 2);
                                    player.getWorld().playEffect(defender.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                                    return true;
                                }
                                break;
                            }else{
                                if(defender.getHealth() <= 3){
                                    Sounds.EXE.play(player.getLocation(), 2);
                                    player.getWorld().playEffect(defender.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                                    return true;
                                }
                                break;
                            }
                        case "exeI":
                            if(isNPC(defender)){
                                if(defender.getHealth() - damage <= 3){
                                    Sounds.EXE.play(player.getLocation(), 2);
                                    player.getWorld().playEffect(defender.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                                    return true;
                                }
                                break;
                            }else{
                                if(defender.getHealth() <= 2){
                                    Sounds.EXE.play(player.getLocation(), 2);
                                    player.getWorld().playEffect(defender.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                                    return true;
                                }
                                break;
                            }
                    }
                }
            }
        }catch (Exception e){return false;}

        return false;
    }

    public static double Sharpness(Player player, Double damage, List<String> lore){
        try {
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                return 0.0;
            } else if (sharp(player.getInventory().getItemInHand().getItemMeta().getLore())) {

                List<String> list = CheckEnchantOnSword(lore);

                for (String s : list) {
                    switch (s) {
                        case "sharpIII":
                            return damage * .17;
                        case "sharpII":
                            return damage * .10;
                        case "sharpI":
                            return damage * .07;
                    }
                }
            }
        }catch (Exception e){return 0.0;}

        return 0;
    }
}
