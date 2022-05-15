package com.alpha.redux.apis;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class commandBuilder {

    public static boolean BaseChecks(Player player, String cmd, String CheckFor, boolean CheckForOp, boolean CheckForPerm, String permLook){

        if(!cmd.equalsIgnoreCase(CheckFor)){
            return false;
        }

        if (CheckForOp){
            if(player.isOp()){
                return cmd.equalsIgnoreCase(CheckFor);
            }
            else{
                player.sendMessage(ChatColor.RED + "You need operator for this!");
                return false;
            }
        }
        if(CheckForPerm){
            if(player.hasPermission(permLook)){
                return cmd.equalsIgnoreCase(CheckFor);
            }else{
                player.sendMessage(ChatColor.RED + "You need permission to use this command!");
                return false;
            }
        }
        return cmd.equalsIgnoreCase(CheckFor);
    }

}
