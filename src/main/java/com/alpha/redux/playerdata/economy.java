package com.alpha.redux.playerdata;

import com.alpha.redux.redux;
import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;
import net.ess3.api.MaxMoneyException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.UUID;

import static com.alpha.redux.playerdata.prestiges.GoldRequireMent;
import static com.alpha.redux.playerdata.prestiges.getPrestige;
import static com.earth2me.essentials.api.Economy.*;

public class economy {

    private static redux plugin;

    public economy(redux instance){
        plugin = instance;
    }

     //public static HashMap<String, Integer> Economy = new HashMap<>();

    public static void setEconomy(String player, int amount){
        try{
            setMoney(ChatColor.stripColor(Bukkit.getPlayer(UUID.fromString(player)).getDisplayName()), amount);
        } catch (UserDoesNotExistException | NoLoanPermittedException | MaxMoneyException e) {
            e.printStackTrace();
        }

    }

    public static void addEconomy(String player, int amount){
        try{
            add(ChatColor.stripColor(Bukkit.getPlayer(UUID.fromString(player)).getDisplayName()), amount);
        } catch (UserDoesNotExistException | NoLoanPermittedException | MaxMoneyException e) {
            e.printStackTrace();
        }

    }

    public static void removeEconomy(String player, int amount){
        try{
            subtract(ChatColor.stripColor(Bukkit.getPlayer(UUID.fromString(player)).getDisplayName()), amount);
        } catch (UserDoesNotExistException | NoLoanPermittedException | MaxMoneyException e) {
            e.printStackTrace();
        }
    }

    public static int getEconomy(String player){
        try{
            return (int) getMoney(ChatColor.stripColor(Bukkit.getPlayer(UUID.fromString(player)).getDisplayName()));
        } catch (UserDoesNotExistException e) {
            return 0;
        }

    }

    public static boolean hasEconomy(String player){
        try{
            if(playerExists(UUID.fromString(player))){
                return true;
            }else{
                setMoney(ChatColor.stripColor(Bukkit.getPlayer(UUID.fromString(player)).getDisplayName()), 0);
            }
            return true;
        } catch (UserDoesNotExistException | NoLoanPermittedException | MaxMoneyException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static double getGoldRequireMentAmount(String player){
        return GoldRequireMent(getPrestige(player));
    }

    public static redux getPlugin(){
        return plugin;
    }

}
