package com.alpha.redux.apis.PitTrade;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static com.alpha.redux.apis.PitTrade.tradeEvent.addPlayersToTradelist;

public class tradeCommand implements CommandExecutor {

    HashMap<Player,Player> requestTrade = new HashMap<Player,Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 2){
                if(args[0].equals("request")){
                    Player tradeWith = Bukkit.getPlayer(args[1]);
                    if(Bukkit.getOnlinePlayers().contains(tradeWith)){
                        p.sendMessage("You sent a trade request to: " + ChatColor.YELLOW + args[1]);
                        requestTrade.put(tradeWith, p);
                        tradeWith.sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.WHITE + " wants to trade with you");
                    } else {
                        p.sendMessage(ChatColor.YELLOW + args[1] + ChatColor.WHITE + " is not online");
                    }
                }
            } else if (args.length == 1){
                if(args[0].equals("accept")){
                    if(requestTrade.containsKey(p)){
                        Player tradeWith = requestTrade.get(p);
                        addPlayersToTradelist(((Player) sender).getPlayer(), requestTrade.get(p));
                        if(Bukkit.getOnlinePlayers().contains(tradeWith)){
                            Inventory tradeInv = Bukkit.createInventory(null, 27, "You              Other");

                            p.openInventory(tradeInv);
                            tradeWith.openInventory(tradeInv);
                            requestTrade.remove(p);
                        } else {
                            p.sendMessage("Player is not online anymore");
                            requestTrade.remove(p);
                        }
                    } else {
                        p.sendMessage("There is no one that wants to trade with you");
                    }
                }
            }

            return true;
        }

        return true;
    }

}