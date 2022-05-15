package com.alpha.redux.entityHandlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;

public class ReduxPlayerHandler implements Listener{

    private static final Map<Player, ReduxPlayer> ReduxPlayerHandlers = new HashMap<Player, ReduxPlayer>();

    public static ReduxPlayer playerExists(Player player){
        if (ReduxPlayerHandlers.containsKey(player)){
            return ReduxPlayerHandlers.get(player);
        }else{
            ReduxPlayerHandlers.put(player, new ReduxPlayer(player));
            return ReduxPlayerHandler.ReduxPlayerHandlers.get(player);
        }
    }

    @EventHandler
    public static void handleOfflinePlayers(PlayerQuitEvent event){
        Player player = event.getPlayer();

        ReduxPlayerHandlers.remove(player);
    }

}
