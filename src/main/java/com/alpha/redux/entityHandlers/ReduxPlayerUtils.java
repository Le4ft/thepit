package com.alpha.redux.entityHandlers;

import com.alpha.redux.items.itemManager;
import com.alpha.redux.playerdata.streaks;
import com.alpha.redux.renownShop.RenownStorage;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.Random;

import static com.alpha.redux.funEvents.event.twoTimesEvent;
import static com.alpha.redux.playerdata.streaks.*;
import static com.alpha.redux.renownShop.xpIncrease.getXpIncrease;

public class ReduxPlayerUtils {

    public static int calculateExp(ReduxPlayer player){
        List<String> enchants = null;

        double xp_Amount = 18;
        int XP_CAP = 80;
        int master = 1;

        int MULTIPLIER = streaks.StreakManager(player.player);
        int XP_MULTIPLIER = 0;
        if (MULTIPLIER == 2) XP_MULTIPLIER += 2;
        else if (MULTIPLIER == 3) XP_MULTIPLIER += 1;
        else if(MULTIPLIER == 1) XP_MULTIPLIER += 1;
        else if(MULTIPLIER == 7) XP_MULTIPLIER += 3;


        if(player.getPantEnchants() != null) enchants = player.getPantEnchants();

        if(enchants != null)
            for (String sw : enchants) {
                switch (sw) {

                    case "sweatyIII":
                        XP_MULTIPLIER += 2;
                        XP_CAP += 150;
                        break;
                    case "sweatyII":
                        XP_MULTIPLIER += 1.2;
                        XP_CAP += 50;
                        break;
                    case "sweatyI":
                        XP_MULTIPLIER += 1;
                        break;

                    case "xpIII":
                        XP_MULTIPLIER += .3;
                        break;
                    case "xpII":
                        XP_MULTIPLIER += .2;
                        break;
                    case "xpI":
                        XP_MULTIPLIER += .1;
                        break;

                    case "xpbIII":
                        XP_CAP += 6;
                        break;
                    case "xpbII":
                        XP_CAP += 4;
                        break;
                    case "xpbI":
                        XP_CAP += 2;
                        break;

                }
            }

        if(player.getSwordEnchants() != null) enchants = player.getSwordEnchants();

        if(enchants != null)
            for (String sw : enchants) {
                switch (sw) {

                    case "sweatyIII":
                        XP_MULTIPLIER += 2;
                        XP_CAP += 150;
                        break;
                    case "sweatyII":
                        XP_MULTIPLIER += 1.2;
                        XP_CAP += 50;
                        break;
                    case "sweatyI":
                        XP_MULTIPLIER += 1;
                        break;

                    case "xpIII":
                        XP_MULTIPLIER += .3;
                        break;
                    case "xpII":
                        XP_MULTIPLIER += .2;
                        break;
                    case "xpI":
                        XP_MULTIPLIER += .1;
                        break;

                    case "xpbIII":
                        XP_CAP += 6;
                        break;
                    case "xpbII":
                        XP_CAP += 4;
                        break;
                    case "xpbI":
                        XP_CAP += 2;
                        break;

                }
            }

        if (player.getHelmet() != null && player.getHelmet().getItemMeta().equals(itemManager.goldHelm.getItemMeta())) {
            XP_CAP += 50;
        }



        if (player.getBoots() != null && player.getBoots().getItemMeta().equals(itemManager.heistMasterI.getItemMeta())) if (new Random().nextInt(2) == 1) master = 2;
        if (player.getBoots() != null && player.getBoots().getItemMeta().equals(itemManager.heistMasterII.getItemMeta())) master = 2;
        if (player.getBoots() != null && player.getBoots().getItemMeta().equals(itemManager.heistMasterIII.getItemMeta())) master = 3;


        if (xp_amount_mega.containsKey(player.uuid)) {
            xp_Amount += xp_amount_mega.get(player.uuid);
        }

        double final_xp_amount = (xp_Amount * XP_MULTIPLIER)*twoTimesEvent;

        hasMegaStreak(player.uuid);
        if(getMegaStreak(player.uuid).equalsIgnoreCase("beastmode")) return (int) (Math.round((Math.min((final_xp_amount + getXpIncrease(player.uuid) * twoTimesEvent), (XP_CAP + 100 + getXpIncrease(player.uuid)) * twoTimesEvent))*player.getPlayerXpBooster())) * master;
        else if(getMegaStreak(player.uuid).equalsIgnoreCase("moon")) return (int) (Math.round((Math.min((final_xp_amount + getXpIncrease(player.uuid)) * twoTimesEvent, (XP_CAP + 7000 + getXpIncrease(player.uuid) )* twoTimesEvent))*player.getPlayerXpBooster())) * master;
        else return (int) (((int) (Math.round(Math.min((final_xp_amount + getXpIncrease(player.uuid)) * twoTimesEvent, (XP_CAP + getXpIncrease(player.uuid))*twoTimesEvent))) * player.getPlayerXpBooster())) * master;


    }

    public static int calculateGoldAmount(ReduxPlayer player){
        List<String> enchants = null;

        int Gold_Amount = 18;

        int MULTIPLIER = StreakManager(player.player);
        int GOLD_MULTIPLIER = 0;
        if (MULTIPLIER == 2) GOLD_MULTIPLIER += 1;
        else if (MULTIPLIER == 3) GOLD_MULTIPLIER += 5;
        else if(MULTIPLIER == 1) GOLD_MULTIPLIER += 1;
        else if(MULTIPLIER == 7) GOLD_MULTIPLIER =1;



        if(player.getPantEnchants() != null) enchants = player.getPantEnchants();

        if(enchants != null)
            for (String sw : enchants) {
                switch (sw) {
                    case "moctIII":
                        Gold_Amount += 18;
                        break;
                    case "moctII":
                    case "goldBumpIII":
                        Gold_Amount += 12;
                        break;
                    case "moctI":
                        Gold_Amount += 7;
                        break;
                    case "goldBumpII":
                        Gold_Amount += 8;
                        break;
                    case "goldBumpI":
                        Gold_Amount += 4;
                        break;
                    case "gbIII":
                        Gold_Amount += Gold_Amount * .45;
                        break;
                    case "gbII":
                        Gold_Amount += Gold_Amount * .30;
                        break;
                    case "gbI":
                        Gold_Amount += Gold_Amount * .15;
                        break;

                }
            }

        if(player.getSwordEnchants() != null) enchants = player.getSwordEnchants();

        if(enchants != null)
            for (String sw : enchants) {
                switch (sw) {
                    case "moctIII":
                        Gold_Amount += 18;
                        break;
                    case "moctII":
                    case "goldBumpIII":
                        Gold_Amount += 12;
                        break;
                    case "moctI":
                        Gold_Amount += 7;
                        break;
                    case "goldBumpII":
                        Gold_Amount += 8;
                        break;
                    case "goldBumpI":
                        Gold_Amount += 4;
                        break;
                    case "gbIII":
                        Gold_Amount += Gold_Amount * .45;
                        break;
                    case "gbII":
                        Gold_Amount += Gold_Amount * .30;
                        break;
                    case "gbI":
                        Gold_Amount += Gold_Amount * .15;
                        break;

                }
            }

        int master = 1;

        if(player.getPlayerObject().getInventory().contains(RenownStorage.getGoldQuest())){Gold_Amount += Gold_Amount;}

        if (player.getBoots() != null && player.getBoots().getItemMeta().equals(itemManager.heistMasterI.getItemMeta())) if (new Random().nextInt(2) == 1) master = 2;
        if (player.getBoots() != null && player.getBoots().getItemMeta().equals(itemManager.heistMasterII.getItemMeta())) master = 2;
        if (player.getBoots() != null && player.getBoots().getItemMeta().equals(itemManager.heistMasterIII.getItemMeta())) master = 3;


        return ((int) (((Gold_Amount + (Gold_Amount *GOLD_MULTIPLIER)) * twoTimesEvent) * player.getPlayerGoldBooster())) * master;
    }

}
