package com.alpha.redux.well;

import java.util.List;

import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;

public class enchanters {

    public static boolean GoldBoost(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

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

    public static boolean GoldHeart(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "goldheartIII":
                case "goldheartI":
                case "goldheartII":
                    return true;
            }
        }


        return false;
    }

    public static boolean Moctezuma(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

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

    public static boolean CritFunky(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "critIII":
                case "critI":
                case "critII":
                    return true;
            }
        }


        return false;
    }


    public static boolean GoldBump(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

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

    public static boolean Protection(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "protIII":
                case "protII":
                case "protI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Peroxide(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "peroxideIII":
                case "peroxideII":
                case "peroxideI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Sweaty(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

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
        List<String> list = CheckEnchantOnPant(lore);

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

    public static boolean Mirror(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "mirrorIII":
                case "mirrorII":
                case "mirrorI":
                    return true;
            }
        }


        return false;
    }

    public static boolean EscapePod(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "escapeIII":
                case "escapeII":
                case "escapeI":
                    return true;
            }
        }


        return false;
    }

    public static boolean rgm(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "rgmIII":
                case "rgmII":
                case "rgmI":
                    return true;
            }
        }


        return false;
    }

    public static boolean reg(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "regIII":
                case "regII":
                case "regI":
                    return true;
            }
        }


        return false;
    }

    public static boolean XPBump(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

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

    public static boolean NotGladiator(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "gladIII":
                case "gladII":
                case "gladI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Fractional(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "fracIII":
                case "fracII":
                case "fracI":
                    return true;
            }
        }


        return false;
    }

    public static boolean Solitude(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "fracIII":
                case "fracII":
                case "fracI":
                    return true;
            }
        }


        return false;
    }


    public static boolean Jewel(List<String> lore){
        List<String> list = CheckEnchantOnPant(lore);

        for (String s : list) {
            switch (s) {
                case "jewel":
                    return true;
            }
        }


        return false;
    }



}