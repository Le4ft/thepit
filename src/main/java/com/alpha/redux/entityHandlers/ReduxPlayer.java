package com.alpha.redux.entityHandlers;

import com.alpha.redux.DeathHandler.ProccessHit;
import com.alpha.redux.commands.commandUtils;
import com.alpha.redux.events.boards;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.playerdata.streaks;

import com.alpha.redux.playerdata.xpManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static com.alpha.redux.funEvents.event.twoTimesEvent;
import static com.alpha.redux.playerdata.economy.*;
import static com.alpha.redux.playerdata.prestiges.*;
import static com.alpha.redux.playerdata.streaks.*;
import static com.alpha.redux.playerdata.streaks.getMegaStreak;
import static com.alpha.redux.renownShop.xpIncrease.getXpIncrease;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;

public class ReduxPlayer {

    Player player;
    String uuid;
    double damageIncrease;
    double damageDecrease;
    double xpBooster = 1;
    double goldBooster = 1;
    int obbyTime = 2400;

    public ReduxPlayer(Player player) {
        this.player = player;
        this.damageIncrease = 0.01;
        this.damageDecrease = 0.01;
        this.uuid = String.valueOf(this.player.getUniqueId());
    }

    public void spawnPlayer(){
        commandUtils.spawnPlayer(this.player);
    }

    public void killPlayer(Player killer){
        ProccessHit.KillMan(killer, this.player);
    }

    public void addStreak(Player victim){
        ProccessHit.KillMan(this.player, victim);
    }

    public int getPlayerPrestige(){
        hasPrestige(this.uuid);
        return getPrestige(this.uuid);
    }

    public void setPlayerPrestige(int amount){
        hasPrestige(this.uuid);
        setPrestige(this.uuid, amount);
    }

    public void addPlayerPrestige(){
        hasPrestige(this.uuid);
        addPrestige(this.uuid, 1);
    }

    public void addPlayerPrestige(int amount){
        hasPrestige(this.uuid);
        addPrestige(this.uuid, amount);
    }

    public double getPlayerGold(){
        hasEconomy(this.uuid);
        return getEconomy(this.uuid);
    }

    public void setPlayerGold(int amount){
        hasEconomy(this.uuid);
        setEconomy(this.uuid, amount);
    }

    public void addPlayerGold(int amount){
        hasEconomy(this.uuid);
        addEconomy(this.uuid, amount);
    }

    public double getPlayerGoldBooster(){
        return this.goldBooster;
    }

    public void setPlayerGoldBooster(int amount){
        this.goldBooster += amount;
    }

    public double getPlayerXpBooster(){
        return this.xpBooster;
    }

    public void setPlayerXpBooster(double amount){
        this.xpBooster += amount;
    }

    public void setPlayerIncrease(double amount){
        this.damageIncrease = amount;
    }

    public void addPlayerIncrease(double amount){
        this.damageIncrease += amount;
    }

    public void setPlayerEXP(int amount){
        xpManager.setXp(this.uuid, amount);
    }

    public void addPlayerEXP(int amount){
        xpManager.addXp(this.uuid, amount);
    }

    public void setPlayerDecrease(double amount){
        this.damageIncrease = amount;
    }

    public void addPlayerDecrease(double amount){
        this.damageIncrease += amount;
    }

    public double getPlayerIncrease(){
        return this.damageIncrease;
    }

    public double getPlayerDecrease(){
        return this.damageDecrease;
    }

    public String getPlayerUUID(){
        return this.uuid;
    }

    public Player getPlayerObject(){
        return this.player;
    }

    public void refreshScoreBoard(){
        boards.CreateScore(this.player);
    }

    public int getObsidianTime(){return this.obbyTime;}

    public ItemStack getHelmet(){
        if (this.player.getInventory().getHelmet() != null) return this.player.getInventory().getHelmet();
        else return null;
    }

    public ItemStack getChestplate(){
        if (this.player.getInventory().getChestplate() != null) return this.player.getInventory().getChestplate();
        else return null;
    }

    public ItemStack getLeggings(){
        if (this.player.getInventory().getLeggings() != null) return this.player.getInventory().getLeggings();
        else return null;
    }

    public ItemStack getBoots(){
        if (this.player.getInventory().getBoots() != null) return this.player.getInventory().getBoots();
        else return null;
    }

    public ItemStack getMainHand(){
        if (this.player.getInventory().getItemInHand() != null) return this.player.getInventory().getItemInHand();
        else return null;
    }

    public List<String> getPantEnchants(){
        if(getLeggings() != null && getLeggings().getItemMeta().getLore() != null) return CheckEnchantOnPant(getLeggings().getItemMeta().getLore());
        else return null;
    }

    public List<String> getSwordEnchants(){
        if(getMainHand() != null && getMainHand().getItemMeta().getLore() != null) return CheckEnchantOnSword(getMainHand().getItemMeta().getLore());
        else return null;
    }

    public int calculateExperience(){
        return ReduxPlayerUtils.calculateExp(this);
    }

    public int calculateGold(){
        return ReduxPlayerUtils.calculateGoldAmount(this);
    }


}
