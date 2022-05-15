package com.alpha.redux.apis.HeadNames;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class headnames {
    @SuppressWarnings("deprecation")
    public static void changeName(String name, Player entity) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Team red = board.registerNewTeam("Red");
        Team blue = board.registerNewTeam("Blue");
        Team yellow = board.registerNewTeam("Yellow");

        red.setPrefix(ChatColor.RED + "[RED] " + ChatColor.WHITE);
        blue.setPrefix(ChatColor.BLUE + "[BLUE] " + ChatColor.WHITE);
        yellow.setPrefix(ChatColor.YELLOW + "[YELLOW] " + ChatColor.WHITE);

        red.setAllowFriendlyFire(false);
        //red.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
        red.setCanSeeFriendlyInvisibles(false);

        blue.addPlayer(entity);
    }
}
