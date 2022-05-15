package com.alpha.redux.eventManagers;

import com.alpha.redux.entityHandlers.ReduxPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;

public class ReduxDamageEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final ReduxPlayer attacker;
    private final ReduxPlayer defender;
    private List<ItemStack> defenderArmor = new ArrayList<>();
    private List<ItemStack> attackerArmor = new ArrayList<>();
    private List<String> attackerSwordEnchants = new ArrayList<>();
    private List<String> attackerPantEnchants = new ArrayList<>();

    private ItemStack attackerSword;

    private List<String> defenderSwordEnchants = new ArrayList<>();
    private List<String> defenderPantEnchants = new ArrayList<>();

    private double damage;
    private final EntityDamageByEntityEvent event;
    private boolean isCancelled;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    private void setDefenderArmor(){
        if(this.defender.getHelmet() != null) defenderArmor.add(this.defender.getChestplate());
        if(this.defender.getChestplate() != null) defenderArmor.add(this.defender.getChestplate());
        if(this.defender.getLeggings() != null) defenderArmor.add(this.defender.getChestplate());
        if(this.defender.getBoots() != null) defenderArmor.add(this.defender.getChestplate());
    }

    private void setAttackerArmor(){
        if(this.attacker.getHelmet() != null) attackerArmor.add(this.attacker.getChestplate());
        if(this.attacker.getChestplate() != null) attackerArmor.add(this.attacker.getChestplate());
        if(this.attacker.getLeggings() != null) attackerArmor.add(this.attacker.getChestplate());
        if(this.attacker.getBoots() != null) attackerArmor.add(this.attacker.getChestplate());
    }

    private void setAttackerEnchants(){
        if(this.attackerArmor.get(2).getItemMeta().getLore() != null) this.attackerPantEnchants = CheckEnchantOnPant(this.attackerArmor.get(2).getItemMeta().getLore());
        if(this.attackerSword.getItemMeta().getLore() != null) this.attackerSwordEnchants = CheckEnchantOnSword(this.attackerSword.getItemMeta().getLore());
    }

    private void setDefenderEnchants(){
        if(this.defenderArmor.get(2).getItemMeta().getLore() != null) this.defenderPantEnchants = CheckEnchantOnPant(this.defenderArmor.get(2).getItemMeta().getLore());
    }

    public ReduxDamageEvent(ReduxPlayer attacker, ReduxPlayer defender, double damage, EntityDamageByEntityEvent event) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.event = event;
        this.isCancelled = false;
        if(this.attacker.getMainHand() != null) this.attackerSword = this.attacker.getMainHand();
        setDefenderArmor();
        setAttackerArmor();
        setAttackerEnchants();
        setDefenderEnchants();
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public EntityDamageByEntityEvent getBukkitEvent(){
        return this.event;
    }

    public ReduxPlayer getAttacker() {
        return this.attacker;
    }

    public ReduxPlayer getDefenders() {
        return this.defender;
    }

    public List<ItemStack> getDefenderArmor(){return this.defenderArmor;}

    public List<ItemStack> getAttackerArmor(){return this.attackerArmor;}

    public Double getReduxDamage() {
        return this.damage;
    }

    public void setReduxDamage(double damage) {
        this.damage = damage;
    }

    public void addReduxDamage(double damage) {
        this.damage += damage;
    }

    public void subtractReduxDamage(double damage){
        this.damage -= damage;
    }
}
