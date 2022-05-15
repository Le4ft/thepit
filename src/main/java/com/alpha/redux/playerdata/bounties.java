package com.alpha.redux.playerdata;

import com.alpha.redux.apis.chatManager.rank;
import com.nametagedit.plugin.NametagEdit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.playerdata.streaks.getStreak;
import static com.alpha.redux.playerdata.streaks.hasStreak;

public class bounties {

    public static HashMap<String, Integer> BountiesMap = new HashMap<>();

    public static void BountyManager(Player player){
        String uuid = String.valueOf(player.getUniqueId());

        hasStreak(uuid);

        if(getStreak(uuid) % 15 == 0){

            if(BountiesMap.containsKey(uuid)){
                if(BountiesMap.get(uuid) >= 20000){
                    BountiesMap.put(uuid, BountiesMap.get(uuid));
                }else{
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&6&lBOUNTY! &7bump &6&l1000g &7on " + rank.getNameColor(player) + player.getDisplayName() + "&7 for high streak"));
                    BountiesMap.put(uuid, BountiesMap.get(uuid) + 1000);
                }
            }else{
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&6&lBOUNTY! &7bump &6&l1000g &7on " + rank.getNameColor(player) + player.getDisplayName() + "&7 for high streak"));
                BountiesMap.put(uuid, 1000);
            }

            NametagEdit.getApi().setSuffix(player, ChatColor.translateAlternateColorCodes('&', " &6&l" + BountiesMap.get(uuid) + "&6&lg "));
        }
    }

    public static void BountyClaimed(Player bountied, Player claimer){
        String uuid = String.valueOf(bountied.getUniqueId());

        if(isNPC(claimer)){
            if(BountiesMap.containsKey(uuid)){
                if(BountiesMap.get(uuid) > 0){
                    NametagEdit.getApi().setSuffix(bountied, "");
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&6&lBOUNTY CLAIMED! " + "&7" + rank.getNameColor(claimer) + claimer.getDisplayName() + "&7 killed " + rank.getNameColor(bountied) + bountied.getDisplayName() + "&7 for " + "&6&l" + BountiesMap.get(uuid) + "&6&lg"));
                    BountiesMap.put(uuid, 0);
                    return;
                }
            }

        }

        if(BountiesMap.containsKey(uuid)){
            if(BountiesMap.get(uuid) > 0){
                economy.addEconomy(String.valueOf(claimer.getUniqueId()), BountiesMap.get(uuid));
                NametagEdit.getApi().setSuffix(bountied, "");
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&6&lBOUNTY CLAIMED! " + "&7" + rank.getNameColor(claimer) + claimer.getDisplayName() + "&7 killed " + rank.getNameColor(bountied) + bountied.getDisplayName() + "&7 for " + "&6&l" + BountiesMap.get(uuid) + "&6&lg"));
                BountiesMap.put(uuid, 0);
                return;
            }
        }

    }
}