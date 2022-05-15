package com.alpha.redux.well;

import java.util.List;

import static com.alpha.redux.well.enchanters.*;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;

public class swordChecksTiers {
    public static List<String> uacGoldHeart(List<String> lore){
        if(GoldHeart(lore)){

            List<String> list = CheckEnchantOnPant(lore);

            for (String s : list) {
                switch (s) {
                    case "goldheartIII":
                        return lore;
                    case "goldheartII":

                        lore.removeAll(new swordEnchantLores("goldheartII").lore);

                        lore.addAll(new swordEnchantLores("goldheartIII").lore);

                        return lore;
                    case "goldheartI":

                        lore.removeAll(new swordEnchantLores("goldheartI").lore);

                        lore.addAll(new swordEnchantLores("goldheartII").lore);

                        return lore;
                }
            }

        }
        return lore;
    }

    public static List<String> uacMoct(List<String> lore){
        if(Moctezuma(lore)){

            List<String> list = CheckEnchantOnPant(lore);

            for (String s : list) {
                switch (s) {
                    case "moctIII":
                        return lore;
                    case "moctII":

                        lore.removeAll(new swordEnchantLores("moctII").lore);

                        lore.addAll(new swordEnchantLores("moctIII").lore);

                        return lore;
                    case "moctI":

                        lore.removeAll(new swordEnchantLores("moctI").lore);

                        lore.addAll(new swordEnchantLores("moctII").lore);

                        return lore;
                }
            }

        }
        return lore;
    }

    public static List<String> uacGoldBoost(List<String> lore){
        if(GoldBoost(lore)){

            List<String> list = CheckEnchantOnPant(lore);

            for (String s : list) {
                switch (s) {
                    case "gbIII":
                        return lore;
                    case "gbII":

                        lore.removeAll(new swordEnchantLores("gbII").lore);

                        lore.addAll(new swordEnchantLores("gbIII").lore);

                        return lore;
                    case "gbI":

                        lore.removeAll(new swordEnchantLores("gbI").lore);

                        lore.addAll(new swordEnchantLores("gbII").lore);

                        return lore;
                }
            }

        }
        return lore;
    }

    public static List<String> uacGoldBump(List<String> lore){
        if(GoldBump(lore)){

            List<String> list = CheckEnchantOnPant(lore);

            for (String s : list) {
                switch (s) {
                    case "goldBumpIII":
                        return lore;
                    case "goldBumpII":

                        lore.removeAll(new swordEnchantLores("goldBumpII").lore);

                        lore.addAll(new swordEnchantLores("goldBumpIII").lore);

                        return lore;
                    case "goldBumpI":

                        lore.removeAll(new swordEnchantLores("goldBumpI").lore);

                        lore.addAll(new swordEnchantLores("goldBumpII").lore);

                        return lore;
                }
            }

        }
        return lore;
    }
}
