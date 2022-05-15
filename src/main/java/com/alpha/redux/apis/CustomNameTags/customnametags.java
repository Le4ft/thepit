package com.alpha.redux.apis.CustomNameTags;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class customnametags {

    @SuppressWarnings("deprecation")
    public void createTeam(Player player){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Stats", "dummy");
        objective.setDisplayName("Stats");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team red = board.registerNewTeam("Red");
        Team blue = board.registerNewTeam("Blue");
        Team yellow = board.registerNewTeam("Yellow");

        red.setPrefix(ChatColor.RED + "[RED] " + ChatColor.WHITE);
        blue.setPrefix(ChatColor.BLUE + "[BLUE] " + ChatColor.WHITE);
        yellow.setPrefix(ChatColor.YELLOW + "[YELLOW] " + ChatColor.WHITE);

        red.setAllowFriendlyFire(false);
        red.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
        red.setCanSeeFriendlyInvisibles(false);

        if(Bukkit.getOnlinePlayers().size() % 3 == 0){
            red.addPlayer(player);
        } else if (Bukkit.getOnlinePlayers().size()%3 ==1){
            blue.addPlayer(player);
        } else {
            yellow.addPlayer(player);
        }
        //onlinePlayers
        Score score = objective.getScore("players:");
        score.setScore(Bukkit.getOnlinePlayers().size());
        //money
        Score money = objective.getScore(ChatColor.GREEN + "money: " + ChatColor.WHITE + 10);
        money.setScore(2);
        //xp
        Score xp = objective.getScore(ChatColor.BLUE + "xp: "  + ChatColor.WHITE + 5);
        xp.setScore(0);

        player.setScoreboard(board);
    }

}
