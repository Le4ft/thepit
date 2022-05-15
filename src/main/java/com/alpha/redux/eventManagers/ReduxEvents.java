package com.alpha.redux.eventManagers;

import com.alpha.redux.DeathHandler.ReduxDeathEvent;
import com.alpha.redux.entityHandlers.ReduxPlayer;
import com.alpha.redux.items.enchants;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.playerdata.economy;
import com.alpha.redux.questMaster.bossBattles.BossMalding;
import com.alpha.redux.renownShop.damageDecrease;
import com.alpha.redux.renownShop.damageIncrease;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Random;

import static com.alpha.redux.DeathHandler.ProccessHit.KillMan;
import static com.alpha.redux.DeathHandler.ProccessHit.StrengthCheck;
import static com.alpha.redux.DeathHandler.killHandler.getNPC;
import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.ItemEvents.pants.*;
import static com.alpha.redux.ItemEvents.swords.*;
import static com.alpha.redux.ItemEvents.swords.EXEcutioner;
import static com.alpha.redux.apis.actionbarplus.sendHealthBar;
import static com.alpha.redux.apis.locations.getBotSpawnLocation;
import static com.alpha.redux.apis.locations.getSpawnProtection;
import static com.alpha.redux.entityHandlers.ReduxPlayerHandler.playerExists;
import static com.alpha.redux.playerdata.prestiges.getPlugin;
import static com.alpha.redux.playerdata.prestiges.getPrestige;
import static com.alpha.redux.playerdata.streaks.mega_damage_amount;
import static com.alpha.redux.playerdata.streaks.true_damage_amount;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.MaldingPlayerHandlers;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.maldingName;

public class ReduxEvents implements Listener {
    @EventHandler
    public static void InterceptEntityDamage(ReduxDamageEvent event){
        Player attacker = event.getAttacker().getPlayerObject();
        Player defender = event.getDefenders().getPlayerObject();

        ReduxPlayer ReduxAttacker = event.getAttacker();
        ReduxPlayer ReduxDefender = event.getDefenders();


        double damage = event.getReduxDamage();
        double true_dmg = 0;
        double sword_true = 0;

        if (damageIncrease.getIncrease(ReduxAttacker.getPlayerUUID()) > 10){
            event.addReduxDamage(event.getReduxDamage() * (((double) damageIncrease.getIncrease(ReduxAttacker.getPlayerUUID()) / 40) / 100));
        }else{
            event.addReduxDamage(damage * ((double) damageIncrease.getIncrease(ReduxAttacker.getPlayerUUID()) / 100));
        }


        if(true_damage_amount.containsKey(ReduxDefender.getPlayerUUID())){
            true_dmg += true_damage_amount.get(ReduxDefender.getPlayerUUID());
        }

        try {
            if (attacker.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Tier III")) {
                ItemStack sword = attacker.getItemInHand();
                if(!attacker.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.DAMAGE_ALL)){
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                }else if (attacker.getInventory().getItemInHand().getEnchantments().get(Enchantment.DAMAGE_ALL) == 2){
                    sword.removeEnchantment(Enchantment.DAMAGE_ALL);
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                }



            }

            if (attacker.getInventory().getItemInHand().equals(enchants.jewl_sword)) {
                ItemStack sword = attacker.getItemInHand();
                if(!attacker.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.DAMAGE_ALL)){
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
                }

            }
        } catch (Exception e){

        }

        try {

            if(attacker.getInventory().getItemInHand().getType().equals(Material.DIAMOND_SPADE)){

                try {
                    if(defender.getInventory().getChestplate().getType().equals(Material.DIAMOND_LEGGINGS)){
                        event.addReduxDamage(4);
                    }else if(defender.getInventory().getLeggings().getType().equals(Material.DIAMOND_CHESTPLATE)){
                        event.addReduxDamage(4);
                    }else if(defender.getInventory().getBoots().getType().equals(Material.DIAMOND_BOOTS)){
                        event.addReduxDamage(4);
                    }

                    event.addReduxDamage(5);
                }catch (Exception e){
                    event.addReduxDamage(4);
                }

            }

            if (StrengthCheck(attacker) <= 0){
                event.addReduxDamage(0);
            }else{
                event.addReduxDamage(event.getReduxDamage() * StrengthCheck(attacker));
            }

        } catch (Exception e){
            event.addReduxDamage(0);
        }

        // Pant enchants

        try{
            if(attacker.getInventory().getItemInHand().getType().equals(Material.GOLD_SWORD)){
                try{
                    if(defender.getLocation().getY() <= getSpawnProtection()){
                        sword_true += Perun(attacker, defender, attacker.getInventory().getItemInHand().getItemMeta().getLore());
                    }

                }catch (Exception e){

                }
            }
        }catch (Exception e){

        }

        try{
            if(attacker.getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS)){
                try{
                    VenomEvent(attacker, defender);
                    event.addReduxDamage(RegularityEvent(attacker, defender, damage, attacker.getInventory().getLeggings().getItemMeta().getLore()));
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }



        try {
            if(defender.getInventory().getLeggings() != null){
                if(defender.getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS)){
                    try {
                        damage -= damage * .3;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        event.subtractReduxDamage(CriticallyFunkyEvent(ReduxAttacker, ReduxDefender, event.getReduxDamage(), defender.getInventory().getLeggings().getItemMeta().getLore()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        EscapePodEvent(attacker, defender, event.getReduxDamage(), defender.getInventory().getLeggings().getItemMeta().getLore());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        event.subtractReduxDamage(NotGlad(defender, event.getReduxDamage(), defender.getInventory().getLeggings().getItemMeta().getLore()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try{
                        event.subtractReduxDamage(ProtectionEvent(defender, event.getReduxDamage(), defender.getInventory().getLeggings().getItemMeta().getLore()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        true_dmg = true_dmg * Mirrors(defender, true_dmg, defender.getInventory().getLeggings().getItemMeta().getLore());
                        sword_true = sword_true * Mirrors(defender, sword_true, defender.getInventory().getLeggings().getItemMeta().getLore());
                    }catch (Exception ignored){

                    }

                    try{
                        RetroGravityMicrocosm(attacker, defender, event.getReduxDamage(), defender.getInventory().getLeggings().getItemMeta().getLore());
                    }catch (Exception ignored){

                    }


                    try{
                        event.subtractReduxDamage(solitudeEnchant(defender, event.getReduxDamage(), defender.getInventory().getLeggings().getItemMeta().getLore()));
                    }catch (Exception ignored){

                    }


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        damage = event.getReduxDamage();

        try {
            defender.setHealth(Math.max(defender.getHealth() - sword_true, 1));
        } catch (Exception e) {

        }

        try{
            if(attacker.getInventory().getItemInHand().getType().equals(Material.GOLD_SWORD)){
                ItemStack sword = attacker.getInventory().getItemInHand();
                if (!(attacker.getLocation().getY() >= getSpawnProtection())){damage += Billionaire(attacker, damage, sword.getItemMeta().getLore());}
                if (!(attacker.getLocation().getY() >= getSpawnProtection())){damage += GambleSword(attacker, damage, sword.getItemMeta().getLore());}
                damage += damage * criticalFunkyDamageCalculation(attacker, 0.0, true);
                damage += KingBuster(attacker, defender ,damage, sword.getItemMeta().getLore());
                damage += Sharker(attacker, defender ,damage, sword.getItemMeta().getLore());
                damage += Sharpness(attacker,damage, sword.getItemMeta().getLore());
                attacker.setHealth(Math.min(attacker.getHealth() + Lifesteals(attacker, damage, sword.getItemMeta().getLore()), attacker.getMaxHealth()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            if(attacker.getInventory().getItemInHand().getType().equals(Material.WOOD_SWORD)){
                ItemStack sword = attacker.getInventory().getItemInHand();
                if (!(attacker.getLocation().getY() >= getSpawnProtection())){damage += Billionaire(attacker, damage, sword.getItemMeta().getLore());}
                if (!(attacker.getLocation().getY() >= getSpawnProtection())){damage += GambleSword(attacker, damage, sword.getItemMeta().getLore());}
                damage += DiamondStomp(ReduxAttacker, ReduxDefender, damage, sword.getItemMeta().getLore());
                damage += PainFocusEvent(ReduxAttacker, ReduxDefender ,damage, sword.getItemMeta().getLore());
                damage += damage * criticalFunkyDamageCalculation(attacker, 0.0, true);
                damage += KingBuster(attacker, defender ,damage, sword.getItemMeta().getLore());
                damage += Sharker(attacker, defender ,damage, sword.getItemMeta().getLore());
                damage += Sharpness(attacker,damage, sword.getItemMeta().getLore());
                attacker.setHealth(Math.min(attacker.getHealth() + Lifesteals(attacker, damage, sword.getItemMeta().getLore()), attacker.getMaxHealth()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(mega_damage_amount.containsKey(String.valueOf(defender.getUniqueId()))){
                damage += Math.round(mega_damage_amount.get(String.valueOf(defender.getUniqueId())));
            }
        }catch (Exception e){

        }

        try{
            attacker.setHealth(Math.min(attacker.getHealth() +.5, attacker.getMaxHealth()));
        }catch (Exception e){

        }

        try{
            if(defender.getInventory().getHelmet().equals(itemManager.goldHelm)){
                damage -= damage * .20;
            }
        } catch (Exception e) {

        }

        try{
            if(defender.getInventory().getChestplate().equals(itemManager.arch)){
                damage -= damage * .10;
            }
        } catch (Exception e) {

        }

        if(isNPC(defender)){
            if(Objects.requireNonNull(getNPC(defender)).getId() == 41){
                damage = damage / 1000;
            }
        }

        if (attacker.getLocation().getY() >= getSpawnProtection()){
            event.setCancelled(true);
            return;
        }

        try{
            if (EXEcutioner(attacker, defender, damage, attacker.getInventory().getItemInHand().getItemMeta().getLore())) {
                event.setCancelled(true);
                try{
                    KillMan(attacker, defender);
                    return;
                } catch (Exception e) {

                }

            }
        }catch (Exception e){

        }

        try{

            damage -= damage * ((double) damageDecrease.getDecrease(String.valueOf(defender.getUniqueId())) / 100);

        }catch (Exception e){

        }

        try {
            if(getPrestige(String.valueOf(attacker.getUniqueId())) <= 1){
                damage += damage * .10;
            }else if(getPrestige(String.valueOf(defender.getUniqueId())) <= 1){
                damage -= damage * .25;
            }
        }catch (Exception e){

        }

        try{
            if(isNPC(defender)){
                if(Objects.requireNonNull(getNPC(defender)).getName().contains(ChatColor.GRAY + "[lvl 1]")){
                    damage = damage / 10000;
                }
            }
        }catch (Exception e){

        }

        try {
            if (attacker.getInventory().getChestplate() != null) {
                if (attacker.getInventory().getChestplate().equals(enchants.malding_chestplate)) {
                    triggerChestplateMalding(attacker, defender, damage);
                }
            }
        } catch (Exception e) {

        }

        try{
            damage += damage * ReduxAttacker.getPlayerIncrease();
            ReduxAttacker.setPlayerIncrease(.0001);
            damage -= damage * ReduxDefender.getPlayerDecrease();
            ReduxDefender.setPlayerDecrease(.0001);
        }catch (Exception e){

        }

        try {
            if(defender.getInventory().getChestplate() != null){
                if(defender.getInventory().getChestplate().equals(enchants.malding_chestplate)){
                    damage -= damage * .10;
                }
            }
            if(defender.getInventory().getLeggings() != null){
                if(defender.getInventory().getLeggings().equals(enchants.malding_pants)){
                    damage -= damage * .10;
                }
            }
            if(defender.getInventory().getBoots() != null){
                if(defender.getInventory().getBoots().equals(enchants.malding_boots)){
                    damage -= damage * .10;
                }
            }
        } catch (Exception e) {

        }


        sendHealthBar(event.getBukkitEvent());



        if(isNPC(attacker)){
            damage = 5;
        }

        if(isNPC(defender)){

            damage = Math.max(damage / 3, 1);

            if (defender.getHealth() - (damage + true_dmg) <= 3) {
                event.setCancelled(true);
                try{
                    KillMan(attacker, defender);
                    return;
                } catch (Exception e) {

                }
            }else{
                event.getBukkitEvent().setDamage(Math.max(damage, 0));
                //defender.setHealth(Math.max(defender.getHealth()-true_dmg, 0));
            }
        }else if (defender.getHealth() - (2 + true_dmg) >= -2 && defender.getHealth() - (2 + true_dmg) <= 1.5) {
            event.setCancelled(true);
            try{
                escapeProc.put(String.valueOf(defender.getUniqueId()), false);
                KillMan(attacker, defender);
                return;
            } catch (Exception e) {

            }
        }else{
            try{
                defender.setHealth(Math.max(defender.getHealth()-true_dmg, 1));
                event.getBukkitEvent().setDamage(Math.max(damage, 0));
            }catch (Exception e){}
        }
    }

    @EventHandler
    public static void DeathEventHandler(ReduxDeathEvent event){


        ReduxPlayer ReduxAttacker = event.getAttacker();

        if(!isNPC(ReduxAttacker.getPlayerObject())){
            double r = new Random().nextDouble();
            if(ReduxAttacker.getPlayerObject().getInventory().getItemInHand().equals(enchants.reaper_scythe)){
                if (r < 0.5) {
                    ReduxAttacker.getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found a &3Player Soul&7!"));
                    ReduxAttacker.getPlayerObject().getInventory().addItem(enchants.playerSoul);
                }
            }else if (r < 0.0005) {
                ReduxAttacker.getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found a &3Player Soul&7!"));
                ReduxAttacker.getPlayerObject().getInventory().addItem(enchants.playerSoul);
            }
        }


    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

        if(event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;

        if(event.getPlayer().getLocation().getY() >= getSpawnProtection()-13){
            event.setCancelled(true);
            return;
        }

        Location playerloc = event.getBlock().getLocation();

        ReduxPlayer reduxPlayer = playerExists(event.getPlayer());


        //-7.5, 123, 5.5
        int minX = -7;
        int minY = 123;
        int minZ = 5;

        // 3.5, 145, 18.5
        int maxX = 3;
        int maxY = 145;
        int maxZ = 18;

        if (playerloc.getX() >= minX && playerloc.getX() <= maxX && playerloc.getZ() >= minZ && playerloc.getZ() <= maxZ && playerloc.getY() >= minY && playerloc.getY() <= maxY){
            event.setCancelled(true);
            return;
        }


        Block replaced = event.getBlockReplacedState().getBlock();
        if(event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        if (event.getBlockReplacedState().getType() != null && event.getBlockReplacedState().getType() == Material.AIR && event.getBlockReplacedState().getType() != Material.GRASS){
            if (event.getBlock().getType() == Material.OBSIDIAN) {

                Bukkit.getScheduler().scheduleSyncDelayedTask(economy.getPlugin(), new Runnable() {

                    @Override
                    public void run() {

                        //Bukkit.broadcastMessage(String.valueOf(replaced));

                        //if(replaced != null) event.getBlock().setType(replaced.getType());
                        //else
                        event.getBlock().setType(Material.AIR);

                    }
                }, /**/reduxPlayer.getObsidianTime());


            }
        }else{
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockBreakEvent event) {if(event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) event.setCancelled(true);}



}
