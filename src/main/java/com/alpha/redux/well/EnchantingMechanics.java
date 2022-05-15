package com.alpha.redux.well;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.alpha.redux.well.loreChecker.CheckEnchantOnPant;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;

enum MysticType{
    SWORD,
    PANT,
    BOW
}

public class EnchantingMechanics {

    List<String> lore;
    String enchant;
    String mysticType;

    public EnchantingMechanics(List<String> lore, String enchant, double thirdChance, double secondChance, String mysticType){
        this.lore = lore;
        this.enchant = enchant;
        this.mysticType = mysticType;

        double r = new Random().nextDouble();
        if (r < thirdChance) {
            if(checkForEnchant(mysticType)){
                upgradeTiers();
                return;
            }

            lore.add("    ");
            if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)) lore.addAll(new swordEnchantLores( this.enchant + "III").lore);
            else lore.addAll(new pantEnchantLores( this.enchant + "III").lore);

        }
        else if (r < secondChance) {
            if(checkForEnchant(mysticType)){
                upgradeTiers();
                return;
            }

            lore.add("    ");

            if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)) lore.addAll(new swordEnchantLores( this.enchant + "II").lore);
            else lore.addAll(new pantEnchantLores( this.enchant + "II").lore);
        }
        else {
            if(checkForEnchant(mysticType)){
                upgradeTiers();
                return;
            }

            lore.add("    ");
            if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)) lore.addAll(new swordEnchantLores( this.enchant + "I").lore);
            else lore.addAll(new pantEnchantLores( this.enchant + "I").lore);
        }
    }

    private void upgradeTiers(){
        if(checkForEnchant(mysticType)){

            String tierIII = this.enchant + "III";
            String tierII = this.enchant + "II";
            String tierI = this.enchant + "I";
            List<String> list = null;
            List<String> tempList = new ArrayList<>();
            tempList.add(lore.get(0));


            if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)) list = CheckEnchantOnSword(lore);
            if(MysticType.valueOf(mysticType).equals(MysticType.PANT)) list = CheckEnchantOnPant(lore);


            assert list != null;
            for (String s : list) {

                if(s.equals(tierIII)){
                    if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)){
                        List<String> temp = getEnchants("SWORD", tierIII);

                        for(String obj : temp){
                            tempList.add("    ");
                            tempList.addAll(new swordEnchantLores(obj).lore);
                        }

                        tempList.add("    ");
                        tempList.addAll(new swordEnchantLores(tierIII).lore);

                        lore = tempList;
                    }else {
                        List<String> temp = getEnchants("PANT", tierIII);

                        for(String obj : temp){
                            tempList.add("    ");
                            tempList.addAll(new pantEnchantLores(obj).lore);
                        }

                        tempList.add("    ");
                        tempList.addAll(new pantEnchantLores(tierIII).lore);

                        lore = tempList;
                    }
                    return;

                }else if(s.equals(tierII)){
                    if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)){
                        List<String> temp = getEnchants("SWORD", tierII);

                        for(String obj : temp){
                            tempList.add("    ");
                            tempList.addAll(new swordEnchantLores(obj).lore);
                        }

                        tempList.add("    ");
                        tempList.addAll(new swordEnchantLores(tierIII).lore);

                        lore = tempList;
                    }else {
                        List<String> temp = getEnchants("PANT", tierII);

                        for(String obj : temp){
                            tempList.add("    ");
                            tempList.addAll(new pantEnchantLores(obj).lore);
                        }

                        tempList.add("    ");
                        tempList.addAll(new pantEnchantLores(tierIII).lore);

                        lore = tempList;
                    }
                    return;
                }else if(s.equals(tierI)){
                    if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)){
                        List<String> temp = getEnchants("SWORD", tierI);

                        for(String obj : temp){
                            tempList.add("    ");
                            tempList.addAll(new swordEnchantLores(obj).lore);
                        }

                        tempList.add("    ");
                        tempList.addAll(new swordEnchantLores(tierII).lore);

                        lore = tempList;
                    }else {
                        List<String> temp = getEnchants("PANT", tierI);

                        for(String obj : temp){
                            tempList.add("    ");
                            tempList.addAll(new pantEnchantLores(obj).lore);
                        }

                        tempList.add("    ");
                        tempList.addAll(new pantEnchantLores(tierII).lore);

                        lore = tempList;
                    }
                }
            }

        }
    }

    private boolean checkForEnchant(String mystic){

        if(MysticType.valueOf(mystic).equals(MysticType.PANT)){
            List<String> list = CheckEnchantOnPant(lore);
            return list.contains(this.enchant + "III") || list.contains(this.enchant + "II") || list.contains(this.enchant + "I");
        } else if(MysticType.valueOf(mystic).equals(MysticType.SWORD)){
            List<String> list = CheckEnchantOnSword(lore);
            return list.contains(this.enchant + "III") || list.contains(this.enchant + "II") || list.contains(this.enchant + "I");
        }


        return false;
    }

    private List<String> getEnchants(String mystic, String exclude){

        List<String> totalEnchants = new ArrayList<>();

        if(MysticType.valueOf(mystic).equals(MysticType.PANT)){
            List<String> list = CheckEnchantOnPant(lore);

            for(String obj : list) if(!obj.contains(exclude)) totalEnchants.add(obj);

        } else if(MysticType.valueOf(mystic).equals(MysticType.SWORD)){
            List<String> list = CheckEnchantOnSword(lore);

            for(String obj : list) if(!obj.contains(exclude)) totalEnchants.add(obj);
        }


        return totalEnchants;
    }

    public static List<String> getEnchants(List<String> lore, String mysticType){

        List<String> list = new ArrayList<>();

        if(MysticType.valueOf(mysticType).equals(MysticType.PANT)){
            list = CheckEnchantOnPant(lore);
        }else if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)){
            list = CheckEnchantOnSword(lore);
        }


        List<String> enchants = new ArrayList<>();

        for(String obj : list){
            String regex = "[I]";

            // Compile the regex to create pattern
            // using compile() method
            Pattern pattern = Pattern.compile(regex);

            // Get a matcher object from pattern
            Matcher matcher = pattern.matcher(obj);

            // Replace every matched pattern with the
            // target string using replaceAll() method
            obj = matcher.replaceAll("");

            enchants.add(obj);
        }


        return enchants;
    }

    public static boolean getEnchants(List<String> lore, String mysticType, boolean f){

        List<String> list = new ArrayList<>();

        if(MysticType.valueOf(mysticType).equals(MysticType.PANT)){
            list = CheckEnchantOnPant(lore);
        }else if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)){
            list = CheckEnchantOnSword(lore);
        }
        int hasEnchants = 0;

        String accepted = ChatColor.GREEN + " ACCEPTED";


        for(String obj : list){
            if(obj.contains("III"))
                hasEnchants += 1;
        }

        if(hasEnchants == list.size()) accepted = ChatColor.RED + " REJECTED";

        Bukkit.broadcastMessage(ChatColor.RED + mysticType + ChatColor.WHITE + " enchants: " + String.valueOf(list) + accepted + " " +  ChatColor.GREEN + hasEnchants + " " + ChatColor.DARK_GRAY + !(hasEnchants == list.size()));

        return !(hasEnchants == list.size());
    }

    public static List<String> enchantPool(List<String> lore, String mysticType){

        List<String> list = new ArrayList<>();

        if(MysticType.valueOf(mysticType).equals(MysticType.PANT)) list = CheckEnchantOnPant(lore);
        else if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)) list = CheckEnchantOnSword(lore);


        list.removeIf(obj -> obj.contains("III"));

        return list;
    }

    public static List<String> getEnchants(List<String> lore, boolean check){

        List<String> list = CheckEnchantOnSword(lore);

        list.removeIf(object -> object.contains("III"));

        return list;
    }

    public static List<String> getUpgradeableEnchants(List<String> lore, String mysticType){

        List<String> list = new ArrayList<>();

        if(MysticType.valueOf(mysticType).equals(MysticType.PANT)){
            list = CheckEnchantOnPant(lore);
        }else if(MysticType.valueOf(mysticType).equals(MysticType.SWORD)){
            list = CheckEnchantOnSword(lore);
        }


        List<String> enchants = new ArrayList<>();

        for(String obj : list){
            if(obj.contains("III")) continue;
            String regex = "[I]";

            // Compile the regex to create pattern
            // using compile() method
            Pattern pattern = Pattern.compile(regex);

            // Get a matcher object from pattern
            Matcher matcher = pattern.matcher(obj);

            // Replace every matched pattern with the
            // target string using replaceAll() method
            obj = matcher.replaceAll("");

            enchants.add(obj);
        }


        return enchants;
    }

    public List<String> getLore(){
        return this.lore;
    }
}
