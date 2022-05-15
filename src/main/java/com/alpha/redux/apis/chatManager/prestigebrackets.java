package com.alpha.redux.apis.chatManager;

import com.avaje.ebeaninternal.server.cluster.Packet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static com.alpha.redux.playerdata.prestiges.getPrestige;

public class prestigebrackets {
    public static String prestigebracket(Player player){
        String prestige_bracket;
        switch (getPrestige(String.valueOf(player.getUniqueId()))){
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
                prestige_bracket = "§6§l";
                break;
            default:
                prestige_bracket = String.valueOf(ChatColor.DARK_RED);
                break;
        }
        return prestige_bracket;
    }
}
