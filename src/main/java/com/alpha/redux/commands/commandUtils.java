package com.alpha.redux.commands;

import com.alpha.redux.events.boards;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import static com.alpha.redux.events.events.Strength;
import static com.alpha.redux.events.events.cooldowns;
import static com.alpha.redux.playerdata.streaks.*;

public class commandUtils {
    public static void spawnPlayer(Player player){
        hasStreak(String.valueOf(player.getUniqueId()));

        if (cooldowns.containsKey(String.valueOf(player.getUniqueId()))){
            // player is inside mute map
            if (cooldowns.get(String.valueOf(player.getUniqueId())) > System.currentTimeMillis()){
                // They still have time left on mute
                long timeleft = (cooldowns.get(String.valueOf(player.getUniqueId())) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "You are in combat for " + ChatColor.RED + timeleft + ChatColor.RED + " more seconds");
                return;
            }else{
                player.removePotionEffect(PotionEffectType.WEAKNESS);
                player.removePotionEffect(PotionEffectType.SLOW);
                setStreak(String.valueOf(player.getUniqueId()), 0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Location loc = new Location(Bukkit.getWorld("world"), -33, 100, 436, 0, 0);
                player.teleport(loc);
                boards.CreateScore(player);
                return;
            }

        }else{
            player.removePotionEffect(PotionEffectType.WEAKNESS);
            player.removePotionEffect(PotionEffectType.WEAKNESS);
            player.removePotionEffect(PotionEffectType.SLOW);
            setStreak(String.valueOf(player.getUniqueId()), 0);
            xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
            Strength.put(String.valueOf(player.getUniqueId()), 0.0);
            mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
            true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
            xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
            Location loc = new Location(Bukkit.getWorld("world"), -33, 100, 436, 0, 0);
            player.teleport(loc);
            boards.CreateScore(player);
        }
    }
}
