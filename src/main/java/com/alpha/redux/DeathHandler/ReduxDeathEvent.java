package com.alpha.redux.DeathHandler;

import com.alpha.redux.entityHandlers.ReduxPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ReduxDeathEvent extends Event implements Cancellable{
    private static final HandlerList HANDLERS = new HandlerList();
    private final ReduxPlayer attacker;
    private final ReduxPlayer defender;
    private boolean isCancelled;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public ReduxDeathEvent(ReduxPlayer attacker, ReduxPlayer defender) {
        this.attacker = attacker;
        this.defender = defender;
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

    public ReduxPlayer getAttacker() {
        return this.attacker;
    }

    public ReduxPlayer getDefender() {
        return this.defender;
    }
}
