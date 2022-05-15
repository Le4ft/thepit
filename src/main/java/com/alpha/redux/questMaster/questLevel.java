package com.alpha.redux.questMaster;

import com.alpha.redux.redux;

import java.util.HashMap;

public class questLevel {
    private static redux plugin;

    public questLevel(redux instance){
        plugin = instance;
    }

    public static HashMap<String, Integer> QuestLevel = new HashMap<>();

    public static void setQuestLevel(String player, int amount){
        QuestLevel.put(player, amount);
    }

    public static void addQuestLevel(String player, int amount){
        hasQuestLevel(player);
        QuestLevel.put(player, QuestLevel.get(player)+amount);
    }

    public static void removeQuestLevel(String player, int amount){
        hasQuestLevel(player);
        QuestLevel.put(player, QuestLevel.get(player)-amount);
    }

    public static int getQuestLevel(String player){
        hasQuestLevel(player);
        return QuestLevel.get(player);
    }

    public static HashMap<String, Integer> getQuestLevelMap(){
        return QuestLevel;
    }

    private static boolean hasQuestLevel(String player){
        if(QuestLevel.containsKey(player)){
            return true;
        }else{
            QuestLevel.put(player, 0);
            return true;
        }
    }

    public static redux getPlugin(){
        return plugin;
    }
}
