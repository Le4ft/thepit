package com.alpha.redux.apis.chatManager;

import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.DecimalFormat;
import java.util.HashMap;

import static com.alpha.redux.apis.chatManager.levelcolor.getLevelColor;
import static com.alpha.redux.events.boards.integerToRoman;
import static com.alpha.redux.playerdata.prestiges.*;
import static com.alpha.redux.playerdata.xpManager.*;

public class rank {

    public static HashMap<String, Boolean> muted = new HashMap<>();

    public static void ChatEvent(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        String msg = event.getMessage();
        String prestige_bracket;
        String rank;
        String namecolor = String.valueOf(ChatColor.GRAY);
        String chatcolor = String.valueOf(ChatColor.GRAY);


        hasPrestige(String.valueOf(player.getUniqueId()));

        Integer current_prestige = getPrestige(String.valueOf(player.getUniqueId()));

        switch (current_prestige){
            case 0:
                prestige_bracket = String.valueOf(ChatColor.GRAY);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                prestige_bracket = String.valueOf(ChatColor.BLUE);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                prestige_bracket = String.valueOf(ChatColor.YELLOW);
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                prestige_bracket = String.valueOf(ChatColor.GOLD);
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                prestige_bracket = String.valueOf(ChatColor.RED);
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                prestige_bracket = String.valueOf(ChatColor.DARK_PURPLE);
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                prestige_bracket = String.valueOf(ChatColor.LIGHT_PURPLE);
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                prestige_bracket = String.valueOf(ChatColor.WHITE);
                break;
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                prestige_bracket = String.valueOf(ChatColor.AQUA);
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                prestige_bracket = String.valueOf(ChatColor.DARK_BLUE);
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                prestige_bracket = String.valueOf(ChatColor.GREEN);
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                prestige_bracket = String.valueOf(ChatColor.DARK_GREEN);
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                prestige_bracket = String.valueOf(ChatColor.DARK_AQUA);
                break;
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
                prestige_bracket = String.valueOf(ChatColor.DARK_GRAY);
                break;
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                prestige_bracket = String.valueOf(ChatColor.MAGIC);
                break;
            default:
                prestige_bracket = String.valueOf(ChatColor.DARK_RED);
                break;
        }

        if (player.isOp()){
            rank = ChatColor.RED + "[OWNER] ";
            chatcolor = String.valueOf(ChatColor.WHITE);
            namecolor = String.valueOf(ChatColor.RED);
        }else if(player.hasPermission("ROMY")){
            rank = ChatColor.translateAlternateColorCodes('&', "&d[ROMY] ");
            namecolor = String.valueOf(ChatColor.LIGHT_PURPLE);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("NARDUPE")){
            rank = ChatColor.RED + "[OWNER"  + ChatColor.RED + "] ";
            namecolor = String.valueOf(ChatColor.RED);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("PETER")){
            rank = ChatColor.translateAlternateColorCodes('&', "&3[&4You&atub&1er &bC&2r&9a&cc&6k&4e&ed] ");
            namecolor = String.valueOf(ChatColor.DARK_AQUA);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("LEFT")){
            rank = ChatColor.YELLOW + "[HUNT] ";
            namecolor = String.valueOf(ChatColor.YELLOW);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("VIP")){
            rank = ChatColor.GREEN + "[VIP] ";
            chatcolor = String.valueOf(ChatColor.WHITE);
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("VIP+")){
            rank = ChatColor.GREEN + "[VIP" + ChatColor.WHITE + "+" + ChatColor.GREEN + "] ";
            chatcolor = String.valueOf(ChatColor.WHITE);
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("MVP")){
            rank = ChatColor.AQUA + "[MVP] ";
            chatcolor = String.valueOf(ChatColor.WHITE);
            namecolor = String.valueOf(ChatColor.AQUA);
        }else if(player.hasPermission("MVP+")){
            rank = ChatColor.AQUA + "[MVP" + ChatColor.RED + "+" + ChatColor.AQUA + "] ";
            namecolor = String.valueOf(ChatColor.AQUA);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("MVP++")){
            rank = ChatColor.GOLD + "[MVP" + ChatColor.BLACK + "++" + ChatColor.GOLD + "] ";
            namecolor = String.valueOf(ChatColor.GOLD);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("HELPER")){
            rank = ChatColor.BLUE + "[HELPER] ";
            chatcolor = String.valueOf(ChatColor.WHITE);
            namecolor = String.valueOf(ChatColor.BLUE);
        }else if(player.hasPermission("MOD")){
            rank = ChatColor.DARK_GREEN + "[MODERATOR] ";
            chatcolor = String.valueOf(ChatColor.WHITE);
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("YOUTUBE")){
            rank = ChatColor.RED + "[" + ChatColor.WHITE + "YOUTUBE" + ChatColor.RED + "] ";
            namecolor = String.valueOf(ChatColor.RED);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else if(player.hasPermission("SALMON")){
            rank = ChatColor.translateAlternateColorCodes('&', "&4[&fS&4A&fL&4M&fO&4N&f]&4+&f+ ");
            namecolor = String.valueOf(ChatColor.RED);
            chatcolor = String.valueOf(ChatColor.WHITE);
        }else{
            rank = "";
        }

        hasPrestige(String.valueOf(player.getUniqueId()));
        hasXp(String.valueOf(player.getUniqueId()));
        int[] randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);

        String prestige_number;

        if (getPrestige(String.valueOf(player.getUniqueId())) <= 0){
            prestige_number = "";
        }else{
            prestige_number = ChatColor.YELLOW + String.valueOf(integerToRoman(getPrestige(String.valueOf(player.getUniqueId())))) + prestige_bracket + "-";
        }

        if(!muted.containsKey(String.valueOf(player.getUniqueId()))){
            muted.put(String.valueOf(player.getUniqueId()), false);
        }

        if(!muted.get(String.valueOf(player.getUniqueId()))){
            event.setFormat(prestige_bracket + "[" + prestige_number + getLevelColor(randomDUDE[1]) + randomDUDE[1] + prestige_bracket + "] " + rank + namecolor +  player.getDisplayName() + ": " + chatcolor + msg);
        }
        //event.setMessage(prestige_bracket + "[" + prestige_number + getLevelColor(randomDUDE[1]) + randomDUDE[1] + prestige_bracket + "] " + rank + namecolor +  player.getDisplayName() + ": " + chatcolor + msg);

        //event.setCancelled(true);
    }

    public static String ChatEventApi(String playername, String uuid){
        String prestige_bracket;
        String namecolor = String.valueOf(ChatColor.GRAY);


        hasPrestige(uuid);

        int current_prestige = getPrestige(uuid);

        switch (current_prestige){
            case 0:
                prestige_bracket = String.valueOf(ChatColor.GRAY);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                prestige_bracket = String.valueOf(ChatColor.BLUE);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                prestige_bracket = String.valueOf(ChatColor.YELLOW);
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                prestige_bracket = String.valueOf(ChatColor.GOLD);
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                prestige_bracket = String.valueOf(ChatColor.RED);
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                prestige_bracket = String.valueOf(ChatColor.DARK_PURPLE);
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                prestige_bracket = String.valueOf(ChatColor.LIGHT_PURPLE);
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                prestige_bracket = String.valueOf(ChatColor.WHITE);
                break;
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                prestige_bracket = String.valueOf(ChatColor.AQUA);
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                prestige_bracket = String.valueOf(ChatColor.DARK_BLUE);
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                prestige_bracket = String.valueOf(ChatColor.GREEN);
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                prestige_bracket = String.valueOf(ChatColor.DARK_GREEN);
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                prestige_bracket = String.valueOf(ChatColor.DARK_AQUA);
                break;
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
                prestige_bracket = String.valueOf(ChatColor.DARK_GRAY);
                break;
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                prestige_bracket = String.valueOf(ChatColor.MAGIC);
                break;
            default:
                prestige_bracket = String.valueOf(ChatColor.DARK_RED);
                break;
        }


        hasPrestige(uuid);
        hasXp(uuid);
        int[] randomDUDE = xpManager.GetCurrentLevels(String.valueOf(uuid), xpManager.getXp(uuid), prestiges.getPrestige(uuid) );

        String prestige_number;

        if (getPrestige(uuid) <= 0){
            prestige_number = "";
        }else{
            prestige_number = ChatColor.YELLOW + String.valueOf(integerToRoman(getPrestige(uuid))) + prestige_bracket + "-";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return prestige_bracket + "[" + prestige_number + getLevelColor(randomDUDE[1]) + randomDUDE[1] + prestige_bracket + "] " + namecolor +  playername + ChatColor.GRAY + " - " + ChatColor.AQUA + formatter.format(getXp(uuid)) + " XP";
    }

    public static String ChatEventApiGetLevelColor(String playername, String uuid){
        String prestige_bracket;
        String namecolor = String.valueOf(ChatColor.GRAY);

        hasPrestige(uuid);

        int current_prestige = getPrestige(uuid);

        switch (current_prestige){
            case 0:
                prestige_bracket = String.valueOf(ChatColor.GRAY);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                prestige_bracket = String.valueOf(ChatColor.BLUE);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                prestige_bracket = String.valueOf(ChatColor.YELLOW);
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                prestige_bracket = String.valueOf(ChatColor.GOLD);
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                prestige_bracket = String.valueOf(ChatColor.RED);
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                prestige_bracket = String.valueOf(ChatColor.DARK_PURPLE);
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                prestige_bracket = String.valueOf(ChatColor.LIGHT_PURPLE);
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                prestige_bracket = String.valueOf(ChatColor.WHITE);
                break;
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                prestige_bracket = String.valueOf(ChatColor.AQUA);
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                prestige_bracket = String.valueOf(ChatColor.DARK_BLUE);
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                prestige_bracket = String.valueOf(ChatColor.GREEN);
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                prestige_bracket = String.valueOf(ChatColor.DARK_GREEN);
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                prestige_bracket = String.valueOf(ChatColor.DARK_AQUA);
                break;
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
                prestige_bracket = String.valueOf(ChatColor.DARK_GRAY);
                break;
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                prestige_bracket = String.valueOf(ChatColor.MAGIC);
                break;
            default:
                prestige_bracket = String.valueOf(ChatColor.DARK_RED);
                break;
        }



        hasPrestige(uuid);
        hasXp(uuid);
        int[] randomDUDE = GetCurrentLevels(String.valueOf(uuid), xpManager.getXp(uuid), prestiges.getPrestige(uuid));

        DecimalFormat formatter = new DecimalFormat("#,###");
        return prestige_bracket + "[" + getLevelColor(randomDUDE[1]) + randomDUDE[1] + prestige_bracket + "] ";
    }

    public static String getNameColor(Player player){
        String namecolor;

        if (player.isOp()){
            namecolor = String.valueOf(ChatColor.RED);
        }else if(player.hasPermission("VIP")){
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("VIP+")){
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("MVP")){
            namecolor = String.valueOf(ChatColor.AQUA);
        }else if(player.hasPermission("MVP+")){
            namecolor = String.valueOf(ChatColor.AQUA);
        }else if(player.hasPermission("MVP++")){
            namecolor = String.valueOf(ChatColor.GOLD);
        }else if(player.hasPermission("NARDUPE")){
            namecolor = String.valueOf(ChatColor.RED);
        }else if(player.hasPermission("PETER")){
            namecolor = String.valueOf(ChatColor.DARK_AQUA);
        }else if(player.hasPermission("LEFT")){
            namecolor = String.valueOf(ChatColor.YELLOW);
        }else if(player.hasPermission("HELPER")){
            namecolor = String.valueOf(ChatColor.BLUE);
        }else if(player.hasPermission("MOD")){
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("ROMY")){
            namecolor = String.valueOf(ChatColor.LIGHT_PURPLE);
        }else if(player.hasPermission("YOUTUBE")){
            namecolor = String.valueOf(ChatColor.RED);
        }else if(player.hasPermission("SALMON")){
            namecolor = String.valueOf(ChatColor.WHITE);
        }else{
            namecolor = String.valueOf(ChatColor.GRAY);
        }

       return namecolor;
    }

}
