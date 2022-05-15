package com.alpha.redux.events;

import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.DecimalFormat;
import java.util.Objects;

import static com.alpha.redux.apis.HeadNames.headnames.changeName;
import static com.alpha.redux.apis.chatManager.levelcolor.getLevelColor;
import static com.alpha.redux.apis.chatManager.prestigebrackets.prestigebracket;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApi;
import static com.alpha.redux.playerdata.economy.getEconomy;
import static com.alpha.redux.playerdata.economy.hasEconomy;
import static com.alpha.redux.events.events.Has_Strength;
import static com.alpha.redux.events.events.Strength;
import static com.alpha.redux.playerdata.prestiges.getPrestige;
import static com.alpha.redux.playerdata.prestiges.hasPrestige;
import static com.alpha.redux.playerdata.streaks.*;
import static com.alpha.redux.playerdata.xpManager.GetCurrentLevel;
import static com.alpha.redux.playerdata.xpManager.hasXp;
import static java.lang.Math.abs;
import static java.lang.Math.round;

public class boards {
    public static void CreateScore(Player player){
        String select_mega = "";
        String mega_color = "";
        int activate_amount = 50;
        hasMegaStreak(String.valueOf(player.getUniqueId()));
        if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "highlander")){
            select_mega = "Highlander";
            mega_color = "§6";
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "beastmode")){
            select_mega = "Beastmode";
            mega_color = "§a";
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "uber")){
            select_mega = "Uberstreak";
            mega_color = "§d";
            activate_amount = 100;
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "moon")){
            select_mega = "To the Moon";
            mega_color = "§b";
            activate_amount = 100;
        }

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("Title", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.YELLOW + "§lTHE BETTER PIT");

        hasStreak(String.valueOf(player.getUniqueId()));
        hasEconomy(String.valueOf(player.getUniqueId()));
        hasPrestige(String.valueOf(player.getUniqueId()));

        hasXp(String.valueOf(player.getUniqueId()));
        int[] randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);

        String prestige_bracket = prestigebracket(player);

        Score score = objective.getScore(ChatColor.GRAY + "v1.8.0"); //create a line for the board
        Score s2 = objective.getScore(" "); //blank space
        Score s3 = objective.getScore(ChatColor.WHITE + "Prestige: " + ChatColor.YELLOW + integerToRoman(getPrestige(String.valueOf(player.getUniqueId()))));
        Score s4 = objective.getScore(ChatColor.WHITE + "Level: " + prestige_bracket + "[" + ChatColor.AQUA + getLevelColor(randomDUDE[1]) + randomDUDE[1] + prestige_bracket + "]");
        Score s5 = objective.getScore("  ");
        DecimalFormat formatter = new DecimalFormat("#,###");
        Score s6 = objective.getScore(ChatColor.WHITE + "Gold: " + ChatColor.GOLD + formatter.format(getEconomy(String.valueOf(player.getUniqueId()))) + "g");
        Score s7 = objective.getScore("   ");
        Score s8 = objective.getScore(ChatColor.WHITE + "Streak: " + ChatColor.GREEN + getStreak(String.valueOf(player.getUniqueId())));
        Score s9 = null;
        if (getStreak(String.valueOf(player.getUniqueId())) >= activate_amount){
            s9 = objective.getScore(ChatColor.WHITE + "Status: " + ChatColor.RESET + mega_color + select_mega);
        }else if (getStreak(String.valueOf(player.getUniqueId())) >= 1 && getStreak(String.valueOf(player.getUniqueId())) <= 49){
            s9 = objective.getScore(ChatColor.WHITE + "Status: " + ChatColor.RED + "Fighting");
        }else{
            s9 = objective.getScore(ChatColor.WHITE + "Status: " + ChatColor.GREEN + "Idling");
        }

        Score s10 = objective.getScore("    ");

        Score s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "Not Selected");

        if (Strength.get(String.valueOf(player.getUniqueId())) == null){
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "NONE");
        }else if(Strength.get(String.valueOf(player.getUniqueId())) >= 0 && Strength.get(String.valueOf(player.getUniqueId())) <= .10){
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "1");
        }else if(Strength.get(String.valueOf(player.getUniqueId())) >= .10 && Strength.get(String.valueOf(player.getUniqueId())) <= .20){
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "2");
        }else if(Strength.get(String.valueOf(player.getUniqueId())) >= .20 && Strength.get(String.valueOf(player.getUniqueId())) <= .30){
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "3");
        }else if(Strength.get(String.valueOf(player.getUniqueId())) >= .30 && Strength.get(String.valueOf(player.getUniqueId())) <= .40){
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "4");
        }else if(Strength.get(String.valueOf(player.getUniqueId())) >= .40 && Strength.get(String.valueOf(player.getUniqueId())) <= .50){
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "5");
        }else{
            s11 = objective.getScore(ChatColor.WHITE + "Strength: " + ChatColor.RED + "NONE");
        }

        Score s12 = objective.getScore("     ");

        Score s13;
        if (randomDUDE[0] == 323232323){
            s13 = objective.getScore(ChatColor.WHITE + "Needed XP: " + ChatColor.GOLD + "MAX");
        }else{
            s13 = objective.getScore(ChatColor.WHITE + "Needed XP: " + ChatColor.AQUA + formatter.format(abs(randomDUDE[0])));
        }


        score.setScore(13);
        s2.setScore(12);
        s3.setScore(11);
        s4.setScore(10);
        s5.setScore(9);
        s6.setScore(8);
        s7.setScore(7);
        s8.setScore(6);
        s9.setScore(5);
        s10.setScore(4);
        s11.setScore(3);
        s12.setScore(2);
        s13.setScore(1);

        player.setScoreboard(scoreboard);
    }

    public static StringBuilder integerToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman;
    }



}
