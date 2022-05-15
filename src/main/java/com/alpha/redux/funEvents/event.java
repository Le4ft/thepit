package com.alpha.redux.funEvents;

import com.alpha.redux.playerdata.economy;
import com.earth2me.essentials.api.Economy;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.BufferedReader;

import static com.alpha.redux.apis.locations.getBotSpawnLocation;

public class event {

    private static Hologram hologram = HologramsAPI.createHologram(economy.getPlugin(), getBotSpawnLocation().add(0, 32, 0));
    public static int twoTimesEvent = 1;

    public static void twoTimesEvent(){
        /*for (Player player : Bukkit.getOnlinePlayers()){
            barUtil.setBar(player,  "§d§lMINOR EVENT!" + ChatColor.YELLOW + " 2x " + ChatColor.AQUA + "XP" + ChatColor.LIGHT_PURPLE + "/" + ChatColor.GOLD + "gold" + ChatColor.YELLOW + "!", 100);
        }

         */

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&d&lMINOR EVENT! &e2x in &e&lPit Area"));

        if(hologram.isDeleted()){
            refreshHoloGram();
        }

        hologram.clearLines();

        hologram.appendTextLine(ChatColor.translateAlternateColorCodes('&', "&d&lMINOR EVENT!"));
        hologram.appendTextLine(ChatColor.translateAlternateColorCodes('&', "&e2x &bXP &d/&6gold&e!"));
        hologram.appendTextLine(ChatColor.translateAlternateColorCodes('&', "&ein Pit Area"));


        if(twoTimesEvent > 2) twoTimesEvent += 1;
        else twoTimesEvent = 2;

    }

    public static void handleTwoEvent(){
        if(!hologram.isDeleted()){
            endTwoTimes();
        }else{
            twoTimesEvent();
        }
    }

    public static void endTwoTimes(){
        /*for (Player player: Bukkit.getOnlinePlayers()){
            barUtil.removeBar(player);
        }

         */

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&d&lMINOR EVENT! &e2x in &e&lPit Area &c&lENDED"));
        hologram.delete();

        if(twoTimesEvent > 2) twoTimesEvent -= 1;
        else twoTimesEvent = 1;

    }

    public static void refreshHoloGram(){
        hologram = HologramsAPI.createHologram(economy.getPlugin(), getBotSpawnLocation().add(0, 21 ,0));
    }
}
