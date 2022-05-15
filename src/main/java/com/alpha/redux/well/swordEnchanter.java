package com.alpha.redux.well;

import java.util.List;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;;

public class swordEnchanter {
    public static boolean GoldBoost(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "gbIII":
                case "gbI":
                case "gbII":
                    return true;
            }
        }


        return false;
    }

    public static boolean Moctezuma(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "moctIII":
                case "moctI":
                case "moctII":
                    return true;
            }
        }

        return false;
    }

    public static boolean GoldBump(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "goldBumpIII":
                case "goldBumpII":
                case "goldBumpI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Sweaty(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "sweatyIII":
                case "sweatyII":
                case "sweatyI":
                    return true;
            }
        }


        return false;
    }

    public static boolean XPBoost(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "xpbIII":
                case "xpbII":
                case "xpbI":
                    return true;
            }
        }


        return false;
    }

    public static boolean XPBump(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "xpBumpIII":
                case "xpBumpII":
                case "xpBumpI":
                    return true;
            }
        }


        return false;
    }

    public static boolean execution(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "exeIII":
                case "exeII":
                case "exeI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Billion(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "billIII":
                case "billII":
                case "billI":
                    return true;
            }
        }


        return false;
    }

    public static boolean sharp(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "sharpIII":
                case "sharpII":
                case "sharpI":
                    return true;
            }
        }


        return false;
    }

    public static boolean shark(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "sharkIII":
                case "sharkII":
                case "sharkI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Kingbust(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "kingIII":
                case "kingII":
                case "kingI":
                    return true;
            }
        }


        return false;
    }

    public static boolean PerunWrath(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "perunIII":
                case "perunII":
                case "perunI":
                    return true;
            }
        }


        return false;
    }

    public static boolean gamble(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "gambIII":
                case "gambII":
                case "gambI":
                    return true;
            }
        }


        return false;
    }

    public static boolean PainFocus(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "pfIII":
                case "pfII":
                case "pfI":
                    return true;
            }
        }


        return false;
    }

    public static boolean diamondstomp(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "diamondIII":
                case "diamondII":
                case "diamondI":
                    return true;
            }
        }


        return false;
    }

    public static boolean lifesteal(List<String> lore){
        List<String> list = CheckEnchantOnSword(lore);

        for (String s : list) {
            switch (s) {
                case "lsIII":
                case "lsII":
                case "lsI":
                    return true;
            }
        }


        return false;
    }

}
