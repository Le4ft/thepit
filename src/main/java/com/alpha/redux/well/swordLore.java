package com.alpha.redux.well;

import com.alpha.redux.apis.chatManager.rank;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityEffect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.alpha.redux.apis.FancyText.compileListToString;
import static com.alpha.redux.apis.FancyText.hoverText;
import static com.alpha.redux.well.swordEnchanter.*;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;

public class swordLore {
    public static List<String> makeEnchant(List<String> lore){

        Random rand = new Random(); //instance of random class
        boolean fresh;
        int upperbound = 41;
        int int_random = rand.nextInt(upperbound);
        List<String> new_lore = new ArrayList<>();

        List<String> list = CheckEnchantOnSword(lore);

        if(list.size() <= 0){fresh=true;}

        switch (int_random){
            case 1:

        }


        return new_lore;
    }

    public static List<String> TierISword(Player player) {

        double chanceII = 0.0001;
        double chanceIII = 0.0001;
        List<String> enchants = new ArrayList<>();
        List<String> lore = new ArrayList<>();
        lore.add("§7Lives: §a20§7/20");


        enchants.add("gb");
        enchants.add("gb");
        enchants.add("gb");
        enchants.add("moct");
        enchants.add("moct");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpBump");
        enchants.add("xpBump");


        enchants.add("exe");
        enchants.add("bill");
        enchants.add("perun");
        enchants.add("gamb");
        enchants.add("sharp");
        enchants.add("sharp");
        enchants.add("shark");
        enchants.add("shark");
        enchants.add("king");
        enchants.add("king");
        enchants.add("king");
        enchants.add("pf");
        enchants.add("pf");
        enchants.add("pf");
        enchants.add("diamond");
        enchants.add("diamond");
        enchants.add("diamond");
        enchants.add("ls");
        enchants.add("ls");

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
            case "xpBump":
                chanceII = .47;
                chanceIII = .23;
                break;
            case "ls":
                chanceII = .43;
                chanceIII = .21;
                break;
            case "sharp":
                chanceII = .44;
                chanceIII = .20;
                break;
            case "shark":
                chanceII = .48;
                chanceIII = .22;
                break;
            case "diamond":
                chanceII = .49;
                chanceIII = .23;
                break;
            case "pf":
                chanceII = .50;
                chanceIII = .21;
                break;
            case "king":
                chanceII = .45;
                chanceIII = .26;
                break;
            case "exe":
                chanceII = .25;
                chanceIII = .18;
                break;
            case "bill":
                chanceII = .27;
                chanceIII = .19;
                break;
            case "perun":
                chanceII = .30;
                chanceIII = .25;
                break;
            case "gamb":
                chanceII = .31;
                chanceIII = .23;
                break;
        }


        return new EnchantingMechanics(lore, enchants.get(0), chanceIII, chanceII, "SWORD").getLore();

    }

    public static List<String> TierIISword(List<String> lore, Player player){
        double chanceII = 0.0001;
        double chanceIII = 0.0001;
        List<String> enchants = new ArrayList<>();
        //List<String> lore = new ArrayList<>();
        //lore.add("§7Lives: §a20§7/20");


        enchants.add("gb");
        enchants.add("gb");
        enchants.add("gb");
        enchants.add("moct");
        enchants.add("moct");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpBump");
        enchants.add("xpBump");


        enchants.add("exe");
        enchants.add("bill");
        enchants.add("perun");
        enchants.add("gamb");
        enchants.add("sharp");
        enchants.add("sharp");
        enchants.add("shark");
        enchants.add("shark");
        enchants.add("king");
        enchants.add("king");
        enchants.add("king");
        enchants.add("ls");
        enchants.add("ls");


        List<String> ConcurrentEnchants = EnchantingMechanics.getEnchants(lore, true);
        enchants.removeIf(ConcurrentEnchants::contains);



        //List<String> ConcurrentEnchants = EnchantingMechanics.getEnchants(lore);

       // enchants.addAll(ConcurrentEnchants);
       // enchants.addAll(ConcurrentEnchants);
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
            case "xpBump":
                chanceII = .47;
                chanceIII = .23;
                break;
            case "ls":
                chanceII = .43;
                chanceIII = .21;
                break;
            case "sharp":
                chanceII = .44;
                chanceIII = .20;
                break;
            case "shark":
                chanceII = .48;
                chanceIII = .22;
                break;
            case "diamond":
                chanceII = .49;
                chanceIII = .23;
                break;
            case "pf":
                chanceII = .50;
                chanceIII = .21;
                break;
            case "king":
                chanceII = .45;
                chanceIII = .26;
                break;
            case "exe":
                chanceII = .25;
                chanceIII = .18;
                break;
            case "bill":
                chanceII = .27;
                chanceIII = .19;
                break;
            case "perun":
                chanceII = .30;
                chanceIII = .25;
                break;
            case "gamb":
                chanceII = .31;
                chanceIII = .23;
                break;
        }


        return new EnchantingMechanics(lore, enchants.get(0), chanceIII, chanceII, "SWORD").getLore();
    }

    public static List<String> TierIIISword(List<String> lore, Player player){
        double chanceII = 0.0001;
        double chanceIII = 0.0001;
        List<String> enchants = new ArrayList<>();
        //List<String> lore = new ArrayList<>();
        //lore.add("§7Lives: §a20§7/20");


        enchants.add("gb");
        enchants.add("gb");
        enchants.add("gb");
        enchants.add("moct");
        enchants.add("moct");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("goldBump");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("sweaty");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpb");
        enchants.add("xpBump");
        enchants.add("xpBump");


        enchants.add("exe");
        enchants.add("bill");
        enchants.add("perun");
        enchants.add("gamb");
        enchants.add("sharp");
        enchants.add("sharp");
        enchants.add("shark");
        enchants.add("shark");
        enchants.add("king");
        enchants.add("king");
        enchants.add("king");
        enchants.add("ls");
        enchants.add("ls");



        List<String> ConcurrentEnchants = EnchantingMechanics.getEnchants(lore, true);
        enchants.removeIf(ConcurrentEnchants::contains);

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
            case "xpBump":
                chanceII = .47;
                chanceIII = .23;
                break;
            case "ls":
                chanceII = .43;
                chanceIII = .21;
                break;
            case "sharp":
                chanceII = .44;
                chanceIII = .20;
                break;
            case "shark":
                chanceII = .48;
                chanceIII = .22;
                break;
            case "diamond":
                chanceII = .49;
                chanceIII = .23;
                break;
            case "pf":
                chanceII = .50;
                chanceIII = .21;
                break;
            case "king":
                chanceII = .45;
                chanceIII = .26;
                break;
            case "exe":
                chanceII = .25;
                chanceIII = .18;
                break;
            case "bill":
                chanceII = .27;
                chanceIII = .19;
                break;
            case "perun":
                chanceII = .30;
                chanceIII = .25;
                break;
            case "gamb":
                chanceII = .31;
                chanceIII = .23;
                break;
        }


        return new EnchantingMechanics(lore, enchants.get(0), chanceIII, chanceII, "SWORD").getLore();
    }

}