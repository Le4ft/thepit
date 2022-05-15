package com.alpha.redux.questMaster.bossBattles;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class bossAttackEvent extends Event implements Cancellable{
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final NPC malding;
    private boolean isCancelled;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public bossAttackEvent(Player player, NPC malding) {
        this.player = player;
        this.malding = malding;
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

    public Player getPlayer() {
        return this.player;
    }

    public NPC getBoss() {
        return this.malding;
    }



}
