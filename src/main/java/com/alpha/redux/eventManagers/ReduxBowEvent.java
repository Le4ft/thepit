package com.alpha.redux.eventManagers;

import com.alpha.redux.entityHandlers.ReduxPlayer;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ReduxBowEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final ReduxPlayer attacker;
    private final ReduxPlayer defender;
    private final double damage;
    private final EntityDamageByEntityEvent event;
    private boolean isCancelled;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public ReduxBowEvent(ReduxPlayer attacker, ReduxPlayer defender, double damage, EntityDamageByEntityEvent event) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.event = event;
        this.isCancelled = false;
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

    public ReduxPlayer getDefender() {
        return this.defender;
    }

    public Double getReduxDamage() {
        return this.damage;
    }
}
