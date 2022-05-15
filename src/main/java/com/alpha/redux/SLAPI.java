package com.alpha.redux;
import com.alpha.redux.playerdata.economy;
import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import com.alpha.redux.renownShop.MysticismChance;
import com.alpha.redux.renownShop.damageDecrease;
import com.alpha.redux.renownShop.damageIncrease;

import static com.alpha.redux.playerdata.prestiges.*;
import static com.alpha.redux.playerdata.xpManager.getXpMap;
import static com.alpha.redux.renownShop.MysticismChance.getMysticismChance;
import static com.alpha.redux.renownShop.MysticismChance.getMysticismChanceMap;
import static com.alpha.redux.renownShop.damageIncrease.getIncreaseMap;
import static com.alpha.redux.renownShop.xpIncrease.*;

public class SLAPI {

    private static final redux plugin = prestiges.getPlugin();

    public static void savePrestige(){
        for(String p : getPrestigeMap().keySet()){
            plugin.getConfig().set("prestige."+p, prestiges.getPrestigeMap().get(p));
        }
        plugin.saveConfig();
    }

    public static void loadPrestige(){
        if (!plugin.getConfig().contains("prestige")) return;
        for (String s : plugin.getConfig().getConfigurationSection("prestige").getKeys(false))
        {
            prestiges.setPrestige(s, plugin.getConfig().getInt("prestige."+s));
        }
    }

    public static void saveMystic(){
        for(String p : getMysticismChanceMap().keySet()){
            plugin.getConfig().set("mystic."+p, MysticismChance.getMysticismChanceMap().get(p));
        }
        plugin.saveConfig();
    }

    public static void loadMystic(){
        if (!plugin.getConfig().contains("mystic")) return;
        for (String s : plugin.getConfig().getConfigurationSection("mystic").getKeys(false))
        {
            MysticismChance.setMysticismChance(s, plugin.getConfig().getDouble("mystic."+s));
        }
    }

    private static final redux plugin_experience = xpManager.getPlugin();

    public static void saveXp(){
        for(String p : getXpMap().keySet()){
            plugin_experience.getConfig().set("exp."+p, getXpMap().get(p));
        }
        plugin_experience.saveConfig();
    }

    public static void loadXp(){
        if (!plugin_experience.getConfig().contains("exp")) return;
        for (String s : plugin_experience.getConfig().getConfigurationSection("exp").getKeys(false))
        {
            xpManager.setXp(s, plugin_experience.getConfig().getInt("exp."+s));
        }
    }


    public static void saveDmgInc(){
        for(String p : getIncreaseMap().keySet()){
            plugin_experience.getConfig().set("damage."+p, getIncreaseMap().get(p));
        }
        plugin_experience.saveConfig();
    }


    public static void loadDmgInc(){
        if (!plugin_experience.getConfig().contains("damage")) return;
        for (String s : plugin_experience.getConfig().getConfigurationSection("damage").getKeys(false))
        {
            damageIncrease.setIncrease(s, plugin_experience.getConfig().getInt("damage."+s));
        }
    }

    public static void saveXPInc(){
        for(String p : getXpIncreaseMap().keySet()){
            plugin_experience.getConfig().set("inc."+p, getXpIncreaseMap().get(p));
        }
        plugin_experience.saveConfig();
    }

    public static void loadXPInc(){
        if (!plugin_experience.getConfig().contains("inc")) return;
        for (String s : plugin_experience.getConfig().getConfigurationSection("inc").getKeys(false))
        {
            setXpIncrease(s, plugin_experience.getConfig().getInt("inc."+s));
        }
    }

    public static void saveDmgDec(){
        for(String p : damageDecrease.getDecreaseMap().keySet()){
            plugin_experience.getConfig().set("dec."+p, damageDecrease.getDecreaseMap().get(p));
        }
        plugin_experience.saveConfig();
    }

    public static void loadDmgDec(){
        if (!plugin_experience.getConfig().contains("dec")) return;
        for (String s : plugin_experience.getConfig().getConfigurationSection("dec").getKeys(false))
        {
            damageDecrease.setDecrease(s, plugin_experience.getConfig().getInt("dec."+s));
        }
    }
}