package com.alpha.redux.well;

import java.util.List;
import java.util.Random;

import static com.alpha.redux.well.enchanters.*;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;
import static com.alpha.redux.well.swordChecksTiers.*;

public class pantMechanics {
    public static List<String> gheart(List<String> lore){
        double r = new Random().nextDouble();
        if (r < 0.1) {
            if(GoldHeart(lore)){
                lore = uacGoldHeart(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldheartIII").lore);
            return lore;
        }
        else if (r < 0.2) {
            if(GoldHeart(lore)){
                lore = uacGoldHeart(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldheartII").lore);
            return lore;
        }
        else {
            if(GoldHeart(lore)){
                lore = uacGoldHeart(lore);
                return lore;
            }

            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldheartI").lore);
            return lore;
        }
    }
    public static List<String> moct(List<String> lore){
        double r = new Random().nextDouble();
        if (r < 0.01) {
            if(Moctezuma(lore)){
                lore = uacMoct(lore);
                return lore;
            }

            lore.add("    ");
            lore.addAll(new swordEnchantLores("moctIII").lore);
            return lore;
        }
        else if (r < 0.2) {
            if(Moctezuma(lore)){
                lore = uacMoct(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("moctII").lore);
            return lore;
        }
        else {
            if(Moctezuma(lore)){
                lore = uacMoct(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("moctI").lore);
            return lore;
        }
    }

    public static List<String> goldBoost(List<String> lore){
        double r = new Random().nextDouble();
        if (r < 0.1) {
            if(GoldBoost(lore)){
                lore = uacGoldBoost(lore);
                return lore;
            }

            lore.add("    ");
            lore.addAll(new swordEnchantLores("gbIII").lore);
            return lore;
        }
        else if (r < 0.3) {
            if(GoldBoost(lore)){
                lore = uacGoldBoost(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("gbII").lore);
            return lore;
        }
        else {
            if(GoldBoost(lore)){
                lore = uacGoldBoost(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("gbI").lore);
            return lore;
        }
    }

    public static List<String> goldBump(List<String> lore){
        double r = new Random().nextDouble();
        if (r < 0.2) {
            if(GoldBump(lore)){
                lore = uacGoldBump(lore);
                return lore;
            }

            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldBumpIII").lore);
            return lore;
        }
        else if (r < 0.4) {
            if(GoldBump(lore)){
                lore = uacGoldBump(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldBumpII").lore);
            return lore;
        }
        else {
            if(GoldBump(lore)){
                lore = uacGoldBump(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldBumpI").lore);
            return lore;
        }
    }

    public static List<String> sweaty(List<String> lore){
        double r = new Random().nextDouble();
        if (r < 0.2) {
            if(Sweaty(lore)){
                lore = uacGoldBump(lore);
                return lore;
            }

            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldBumpIII").lore);
            return lore;
        }
        else if (r < 0.4) {
            if(Sweaty(lore)){
                lore = uacGoldBump(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldBumpII").lore);
            return lore;
        }
        else {
            if(Sweaty(lore)){
                lore = uacGoldBump(lore);
                return lore;
            }
            lore.add("    ");
            lore.addAll(new swordEnchantLores("goldBumpI").lore);
            return lore;
        }
    }
}
