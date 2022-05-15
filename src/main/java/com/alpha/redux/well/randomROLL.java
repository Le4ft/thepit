package com.alpha.redux.well;

import com.alpha.redux.apis.chatManager.rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.*;

import static com.alpha.redux.apis.FancyText.compileListToString;
import static com.alpha.redux.apis.FancyText.hoverText;
import static com.alpha.redux.well.enchanters.*;
import static com.alpha.redux.well.loreChecker.CheckEnchant;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;

public class randomROLL {


    public static List<String> makeEnchant(List<String> lore){

        Random rand = new Random(); //instance of random class
        boolean fresh;
        int upperbound = 41;
        int int_random = rand.nextInt(upperbound);
        List<String> new_lore = new ArrayList<>();

        List<String> list = CheckEnchantOnPant(lore);

        if(list.size() <= 0){fresh=true;}

        switch (int_random){
            case 1:

        }


        return new_lore;
    }

    public static List<String> randomRoll(Player player){
        Random rand = new Random(); //instance of random class

        double chanceII = 0.0001;
        double chanceIII = 0.0001;

        List<String> lore = new ArrayList<>();
        lore.add("§7Lives: §a20§7/20");

        List<String> enchants = new ArrayList<>();

        enchants.add("goldheart");

        enchants.add("gb");
        enchants.add("gb");
        enchants.add("gb");
        enchants.add("moct");
        enchants.add("moct");
        enchants.add("crit");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("peroxide");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("mirror");
        enchants.add("mirror");
        enchants.add("escape");
        enchants.add("rgm");
        enchants.add("reg");
        enchants.add("soli");
        enchants.add("xpBump");
        enchants.add("xpBump");
        enchants.add("glad");
        enchants.add("swimmer");
        enchants.add("frac");
        enchants.add("frac");
        enchants.add("frac");

        Collections.shuffle(enchants);

        switch (enchants.get(0)){
            case "gb":
            case "xpb":
            case "goldBump":
                chanceII = .50;
                chanceIII = .25;
                break;
            case "moct":
                chanceII = .45;
                chanceIII = .25;
                break;
            case "prot":
                chanceII = .53;
                chanceIII = .23;
                break;
            case "peroxide":
                chanceII = .54;
                chanceIII = .25;
                break;
            case "sweaty":
                chanceII = .53;
                chanceIII = .26;
                break;
            case "mirror":
                chanceII = .56;
                chanceIII = .21;
                break;
            case "escape":
            case "soli":
            case "rgm":
            case "reg":
                chanceII = .57;
                chanceIII = .28;
                break;
            case "xpBump":
                chanceII = .60;
                chanceIII = .30;
                break;
            case "glad":
                chanceII = .52;
                chanceIII = .21;
                break;
            case "crit":
                chanceII = .56;
                chanceIII = .24;
                break;
            case "goldheart":
                chanceII = .54;
                chanceIII = .24;
                break;
            case "frac":
                chanceII = .58;
                chanceIII = .62;
                break;
            case "swimmer":
                chanceII = .07;
                chanceIII = .05;
                break;
        }


        return new EnchantingMechanics(lore, enchants.get(0), chanceIII, chanceII, "PANT").getLore();
    }



    public static List<String> randomRollI(List<String> lore, Player player){
        Random rand = new Random(); //instance of random class
        int upperbound = 60;
        int int_random = rand.nextInt(upperbound);
        List<String> list = CheckEnchantOnPant(lore);

        double chanceII = 0.0001;
        double chanceIII = 0.0001;
        List<String> enchants = new ArrayList<>();

        enchants.add("goldheart");

        enchants.add("gb");
        enchants.add("gb");
        enchants.add("gb");
        enchants.add("moct");
        enchants.add("moct");
        enchants.add("crit");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("peroxide");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("mirror");
        enchants.add("mirror");
        enchants.add("escape");
        enchants.add("rgm");
        enchants.add("reg");
        enchants.add("soli");
        enchants.add("xpBump");
        enchants.add("xpBump");
        enchants.add("glad");
        enchants.add("frac");
        enchants.add("frac");
        enchants.add("frac");
       // List<String> ConcurrentEnchants = EnchantingMechanics.getEnchants(lore);

        //enchants.addAll(ConcurrentEnchants);
        //enchants.addAll(ConcurrentEnchants);
        //enchants.addAll(ConcurrentEnchants);

        Collections.shuffle(enchants);


        switch (enchants.get(0)){
            case "gb":
            case "xpb":
            case "goldBump":
                chanceII = .50;
                chanceIII = .25;
                break;
            case "moct":
                chanceII = .45;
                chanceIII = .25;
                break;
            case "prot":
                chanceII = .53;
                chanceIII = .23;
                break;
            case "peroxide":
                chanceII = .54;
                chanceIII = .25;
                break;
            case "sweaty":
                chanceII = .53;
                chanceIII = .26;
                break;
            case "mirror":
                chanceII = .56;
                chanceIII = .21;
                break;
            case "escape":
            case "soli":
            case "rgm":
            case "reg":
                chanceII = .57;
                chanceIII = .28;
                break;
            case "xpBump":
                chanceII = .60;
                chanceIII = .30;
                break;
            case "glad":
                chanceII = .52;
                chanceIII = .21;
                break;
            case "crit":
                chanceII = .56;
                chanceIII = .24;
                break;
            case "goldheart":
                chanceII = .54;
                chanceIII = .24;
                break;
            case "frac":
                chanceII = .58;
                chanceIII = .62;
                break;
            case "swimmer":
                chanceII = .07;
                chanceIII = .05;
                break;
        }


        return new EnchantingMechanics(lore, enchants.get(0), chanceIII, chanceII, "PANT").getLore();
    }

    public static List<String> randomRollII(List<String> lore, Player player){
        double chanceII = 0.0001;
        double chanceIII = 0.0001;
        List<String> enchants = new ArrayList<>();

        enchants.add("goldheart");

        enchants.add("gb");
        enchants.add("gb");
        enchants.add("gb");
        enchants.add("moct");
        enchants.add("moct");
        enchants.add("crit");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("prot");
        enchants.add("peroxide");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("mirror");
        enchants.add("mirror");
        enchants.add("escape");
        enchants.add("rgm");
        enchants.add("reg");
        enchants.add("soli");
        enchants.add("xpBump");
        enchants.add("xpBump");
        enchants.add("glad");
        enchants.add("frac");
        enchants.add("frac");
        enchants.add("frac");
        //List<String> ConcurrentEnchants = EnchantingMechanics.getEnchants(lore);

        //enchants.addAll(ConcurrentEnchants);
       // enchants.addAll(ConcurrentEnchants);
       // enchants.addAll(ConcurrentEnchants);

        Collections.shuffle(enchants);

        switch (enchants.get(0)){
            case "gb":
            case "xpb":
            case "goldBump":
                chanceII = .50;
                chanceIII = .25;
                break;
            case "moct":
                chanceII = .45;
                chanceIII = .25;
                break;
            case "prot":
                chanceII = .53;
                chanceIII = .23;
                break;
            case "peroxide":
                chanceII = .54;
                chanceIII = .25;
                break;
            case "sweaty":
                chanceII = .53;
                chanceIII = .26;
                break;
            case "mirror":
                chanceII = .56;
                chanceIII = .21;
                break;
            case "escape":
            case "soli":
            case "rgm":
            case "reg":
                chanceII = .57;
                chanceIII = .28;
                break;
            case "xpBump":
                chanceII = .60;
                chanceIII = .30;
                break;
            case "glad":
                chanceII = .52;
                chanceIII = .21;
                break;
            case "crit":
                chanceII = .56;
                chanceIII = .24;
                break;
            case "goldheart":
                chanceII = .54;
                chanceIII = .24;
                break;
            case "frac":
                chanceII = .58;
                chanceIII = .62;
                break;
            case "swimmer":
                chanceII = .07;
                chanceIII = .05;
                break;
        }


        return new EnchantingMechanics(lore, enchants.get(0), chanceIII, chanceII, "PANT").getLore();
    }
}
