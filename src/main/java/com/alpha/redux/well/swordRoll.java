package com.alpha.redux.well;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.alpha.redux.well.enchanters.*;
import static com.alpha.redux.well.enchanters.NotGladiator;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;

public class swordRoll {
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

        public static List<String> randomRoll(){
            Random rand = new Random(); //instance of random class
            int upperbound = 41;
            int int_random = rand.nextInt(upperbound);
            List<String> lore = new ArrayList<>();
            switch (int_random){
                case 1:
                    lore.add("&dRARE! &9Executioner III");
                    lore.add("&7Hitting an enemy to below &c2❤");
                    lore.add("&7instantly kills them");
                    break;
                case 2:
                    lore.add("&dRARE! &9Executioner II");
                    lore.add("&7Hitting an enemy to below &c1.5❤");
                    lore.add("&7instantly kills them");
                    break;
                case 3:
                    lore.add("&dRARE! &9Executioner");
                    lore.add("&7Hitting an enemy to below &c1❤");
                    lore.add("&7instantly kills them");
                    break;
                case 4:
                    lore.add("&dRARE! &9Billionaire III");
                    lore.add("&7Hits with this swords deal &c2x");
                    lore.add("&cdamage&7 but cost &6350g");
                    break;
                case 5:
                    lore.add("&dRARE! &9Billionaire II");
                    lore.add("&7Hits with this swords deal &c1.67x");
                    lore.add("&cdamage&7 but cost &6200g");
                    break;
                case 7:
                    lore.add("&dRARE! &9Billionaire");
                    lore.add("&7Hits with this swords deal &c1.33x");
                    lore.add("&cdamage&7 but cost &6100g");
                    break;
                case 8:
                    lore.add("&9Lifesteal III");
                    lore.add("&7Heal for &c13%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 9:
                    lore.add("&9Lifesteal II");
                    lore.add("&7Heal for &c8%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 10:
                    lore.add("&9Lifesteal");
                    lore.add("&7Heal for &c4%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 11:
                    lore.add("&9King Buster III");
                    lore.add("&7Deal &c+20%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                case 12:
                    lore.add("&9King Buster II");
                    lore.add("&7Deal &c+13%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                case 13:
                    lore.add("&9King Buster");
                    lore.add("&7Deal &c+7%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                default:
                    lore.add("§9McSwimmer III");
                    lore.add("§7Receive §9-60% melee damage");
                    lore.add("§7while swimming in water or lava");
                    break;
            }
            return lore;
        }



        public static List<String> randomRollI(List<String> lore){
            Random rand = new Random(); //instance of random class
            int upperbound = 45;
            int int_random = rand.nextInt(upperbound);
            List<String> list = CheckEnchantOnPant(lore);
            switch (int_random){
                case 1:
                    lore.add("&dRARE! &9Executioner III");
                    lore.add("&7Hitting an enemy to below &c2❤");
                    lore.add("&7instantly kills them");
                    break;
                case 2:
                    lore.add("&dRARE! &9Executioner II");
                    lore.add("&7Hitting an enemy to below &c1.5❤");
                    lore.add("&7instantly kills them");
                    break;
                case 3:
                    lore.add("&dRARE! &9Executioner");
                    lore.add("&7Hitting an enemy to below &c1❤");
                    lore.add("&7instantly kills them");
                    break;
                case 4:
                    lore.add("&dRARE! &9Billionaire III");
                    lore.add("&7Hits with this swords deal &c2x");
                    lore.add("&cdamage&7 but cost &6350g");
                    break;
                case 5:
                    lore.add("&dRARE! &9Billionaire II");
                    lore.add("&7Hits with this swords deal &c1.67x");
                    lore.add("&cdamage&7 but cost &6200g");
                    break;
                case 7:
                    lore.add("&dRARE! &9Billionaire");
                    lore.add("&7Hits with this swords deal &c1.33x");
                    lore.add("&cdamage&7 but cost &6100g");
                    break;
                case 8:
                    lore.add("&9Lifesteal III");
                    lore.add("&7Heal for &c13%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 9:
                    lore.add("&9Lifesteal II");
                    lore.add("&7Heal for &c8%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 10:
                    lore.add("&9Lifesteal");
                    lore.add("&7Heal for &c4%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 11:
                    lore.add("&9King Buster III");
                    lore.add("&7Deal &c+20%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                case 12:
                    lore.add("&9King Buster II");
                    lore.add("&7Deal &c+13%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                case 13:
                    lore.add("&9King Buster");
                    lore.add("&7Deal &c+7%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                default:
                    lore.add("§9McSwimmer III");
                    lore.add("§7Receive §9-60% melee damage");
                    lore.add("§7while swimming in water or lava");
                    break;
            }
            return lore;
        }

        public static List<String> randomRollII(List<String> lore){
            Random rand = new Random(); //instance of random class
            int upperbound = 44;
            int int_random = rand.nextInt(upperbound);
            switch (int_random){
                case 1:
                    lore.add("&dRARE! &9Executioner III");
                    lore.add("&7Hitting an enemy to below &c2❤");
                    lore.add("&7instantly kills them");
                    break;
                case 2:
                    lore.add("&dRARE! &9Executioner II");
                    lore.add("&7Hitting an enemy to below &c1.5❤");
                    lore.add("&7instantly kills them");
                    break;
                case 3:
                    lore.add("&dRARE! &9Executioner");
                    lore.add("&7Hitting an enemy to below &c1❤");
                    lore.add("&7instantly kills them");
                    break;
                case 4:
                    lore.add("&dRARE! &9Billionaire III");
                    lore.add("&7Hits with this swords deal &c2x");
                    lore.add("&cdamage&7 but cost &6350g");
                    break;
                case 5:
                    lore.add("&dRARE! &9Billionaire II");
                    lore.add("&7Hits with this swords deal &c1.67x");
                    lore.add("&cdamage&7 but cost &6200g");
                    break;
                case 7:
                    lore.add("&dRARE! &9Billionaire");
                    lore.add("&7Hits with this swords deal &c1.33x");
                    lore.add("&cdamage&7 but cost &6100g");
                    break;
                case 8:
                    lore.add("&9Lifesteal III");
                    lore.add("&7Heal for &c13%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 9:
                    lore.add("&9Lifesteal II");
                    lore.add("&7Heal for &c8%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 10:
                    lore.add("&9Lifesteal");
                    lore.add("&7Heal for &c4%&7 of damage dealt up");
                    lore.add("&7to &c1.5❤");
                    break;
                case 11:
                    lore.add("&9King Buster III");
                    lore.add("&7Deal &c+20%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                case 12:
                    lore.add("&9King Buster II");
                    lore.add("&7Deal &c+13%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                case 13:
                    lore.add("&9King Buster");
                    lore.add("&7Deal &c+7%&7 damage vs. players");
                    lore.add("&7above 50% HP");
                    break;
                default:
                    lore.add("§9McSwimmer III");
                    lore.add("§7Receive §9-60% melee damage");
                    lore.add("§7while swimming in water or lava");
                    break;
            }
            return lore;
        }
    }


