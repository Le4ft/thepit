package com.alpha.redux.playerdata;

import com.alpha.redux.redux;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.alpha.redux.playerdata.prestiges.PrestigeXpAmount;


public class xpManager {

    private static redux plugin;

    public xpManager(redux instance){
        plugin = instance;
    }

    public static List<Integer> XpAmounts = new ArrayList<Integer>();
    public static HashMap<String, Integer> Xp = new HashMap<>();

    public static void setXp(String player, int amount){
        Xp.put(player, amount);
    }

    public static void addXp(String player, int amount){
        Xp.put(player, Xp.get(player)+amount);
    }

    public static void removeXp(String player, int amount){
        Xp.put(player, Xp.get(player)-amount);
    }

    public static int getXp(String player){
        return Xp.get(player);
    }

    public static HashMap<String, Integer> getXpMap(){
        return Xp;
    }

    public static boolean hasXp(String player){
        if(Xp.containsKey(player)){
            return true;
        }else{
            Xp.put(player, 15);
        }
        return true;
    }

    public static void XpLevelCalculation(){
        // Total XP = 59355
        // Simple For loop
        // Levels 1-9 = 135 xp
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        XpAmounts.add(15);
        // Levels 10-19 = 270 xp
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        XpAmounts.add(30);
        // Levels 20-29 = 450 xp
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        XpAmounts.add(50);
        // Levels 30-39 = 675 xp
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        XpAmounts.add(75);
        // Levels 40-49 = 1125 xp
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        XpAmounts.add(125);
        // Levels 50-59 = 2700 xp
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        XpAmounts.add(300);
        // Levels 60-69 = 5400 xp
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        XpAmounts.add(600);
        // Levels 70-79 = 7200 xp
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        XpAmounts.add(800);
        // Levels 80-89 = 8100 xp
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        XpAmounts.add(900);
        // Levels 90-99 = 9000 xp
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        XpAmounts.add(1000);
        // 100-109 = 10800 xp
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        XpAmounts.add(1200);
        // 110 - 119 = 13500 xp
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);
        XpAmounts.add(1500);

    }

    public static int[] GetCurrentLevel(String player, Integer PlayerXpAmount, Integer PlayerPrestige, Player players) {
        int CurrentXpMoment = 0;
        int current_level = 0;
        int xp_to_next_level = 0;
        for (int i = 0; i < XpAmounts.size(); i++) {
            CurrentXpMoment += XpAmounts.get(i) + (XpAmounts.get(i) * PrestigeXpAmount(PlayerPrestige));
            if (CurrentXpMoment >= PlayerXpAmount) {
                xp_to_next_level = PlayerXpAmount - CurrentXpMoment;

                current_level = Math.max(i - 1, 1);

                int[] returns = new int[2];
                returns[0] = xp_to_next_level;
                returns[1] = current_level;

                players.setLevel(current_level);
                return returns;
            }
        }

        int[] failedReturn = new int[2];
        failedReturn[0] = 323232323;
        failedReturn[1] = 120;

        return failedReturn;
    }

    public static int[] GetCurrentLevels(String player, Integer PlayerXpAmount, Integer PlayerPrestige) {
        int CurrentXpMoment = 0;
        int current_level = 0;
        int xp_to_next_level = 0;
        for (int i = 0; i < XpAmounts.size(); i++) {
            CurrentXpMoment += XpAmounts.get(i) + (XpAmounts.get(i) * PrestigeXpAmount(PlayerPrestige));
            if (CurrentXpMoment >= PlayerXpAmount) {
                xp_to_next_level = PlayerXpAmount - CurrentXpMoment;

                current_level = Math.max(i - 1, 1);

                int[] returns = new int[2];
                returns[0] = xp_to_next_level;
                returns[1] = current_level;

                return returns;
            }
        }

        int[] failedReturn = new int[2];
        failedReturn[0] = 323232323;
        failedReturn[1] = 120;

        return failedReturn;
    }

    public static redux getPlugin(){
        return plugin;
    }

}
