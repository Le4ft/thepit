package com.alpha.redux.well;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class loreChecker {
    public static List<String> CheckEnchant(Player player) {

        List<String> list=new ArrayList<String>();

        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Boo-boo III")){
            list.add("boobooIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Boo-boo II")){
            list.add("boobooII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Boo-boo"))
            list.add("boobooI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Peroxide III")){
            list.add("peroxideIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Peroxide II")){
            list.add("peroxideII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Peroxide"))
            list.add("peroxideI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Pit Blob III")){
            list.add("blobIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Pit Blob II")){
            list.add("blobII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Pit Blob"))
            list.add("blobI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Combo: Venom"))
            list.add("venom");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Golden Heart III")){
            list.add("goldheartIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Golden Heart II")){
            list.add("goldheartII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Golden Heart"))
            list.add("goldheartI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Moctezuma III")){
            list.add("moctIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Moctezuma II")){
            list.add("moctII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Moctezuma"))
            list.add("moctI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Escape Pod III")){
            list.add("escapeIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Escape Pod II")) {
            list.add("escapeII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Escape Pod"))
            list.add("escapeI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Gold Bump III")){
            list.add("goldBumpIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Gold Bump II")){
            list.add("goldBumpII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Gold Bump"))
            list.add("goldBumpI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Solitude III")){
            list.add("soliIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Solitude II")){
            list.add("soliII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Solitude"))
            list.add("soliI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Protection III")){
            list.add("protIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Protection II")){
            list.add("protII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Protection"))
            list.add("protI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9David and Goliath III")){
            list.add("davidIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9David and Goliath II")){
            list.add("davidII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9David and Goliath"))
            list.add("davidI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9\"Not\" Gladiator III")){
            list.add("gladIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9\"Not\" Gladiator II")){
            list.add("gladII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9\"Not\" Gladiator"))
            list.add("gladI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Critically Funky III")){
            list.add("critIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Critically Funky II")){
            list.add("critII");
        }if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Critically Funky"))
            list.add("critI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Misery"))
            list.add("misery");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Fractional Reserve III")){
            list.add("fracIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Fractional Reserve II")){
            list.add("fracII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Fractional Reserve"))
            list.add("fracI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Mirror III")){
            list.add("mirrorIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Mirror II")){
            list.add("mirrorII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Mirror"))
            list.add("mirrorIII");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Retro-Gravity Microcosm III")){
            list.add("rgmIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Retro-Gravity Microcosm II")){
            list.add("rgmII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§dRARE! §9Retro-Gravity Microcosm")){
            list.add("rgmI");
        }


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Sweaty III")){
            list.add("sweatyIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Sweaty II")){
            list.add("sweatyII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Sweaty"))
            list.add("sweatyI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9XP Boost III")){
            list.add("xpIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9XP Boost II")){
            list.add("xpII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9XP Boost"))
            list.add("xpI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Gold Boost III")){
            list.add("gbIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Gold Boost II")){
            list.add("gbII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Gold Boost"))
            list.add("gbI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Diamond Allergy III")){
            list.add("daIII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Diamond Allergy II")){
            list.add("daII");
        }else if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Diamond Allergy"))
            list.add("daI");


        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9Spite"))
            list.add("spite");

        if (player.getInventory().getLeggings().getItemMeta().getLore().contains("§9McSwimmer III"))
            list.add("mcIII");

        return list;
    }


    public static List<String> CheckEnchantOnPant(List<String> lore) {

        List<String> list=new ArrayList<String>();


        if (lore.contains("§9Boo-boo III")){
            list.add("boobooIII");
        }else if (lore.contains("§9Boo-boo II")){
            list.add("boobooII");
        }else if (lore.contains("§9Boo-boo"))
            list.add("boobooI");

        if (lore.contains("§9Hidden Jewel"))
            list.add("jewel");

        if (lore.contains("§9Peroxide III")){
            list.add("peroxideIII");
        }else if (lore.contains("§9Peroxide II")){
            list.add("peroxideII");
        }else if (lore.contains("§9Peroxide"))
            list.add("peroxideI");


        if (lore.contains("§dRARE! §9Pit Blob III")){
            list.add("blobIII");
        }else if (lore.contains("§dRARE! §9Pit Blob II")){
            list.add("blobII");
        }else if (lore.contains("§dRARE! §9Pit Blob"))
            list.add("blobI");


        if (lore.contains("§dRARE! §9Combo: Venom"))
            list.add("venom");


        if (lore.contains("§9Golden Heart III")){
            list.add("goldheartIII");
        }else if (lore.contains("§9Golden Heart II")){
            list.add("goldheartII");
        }else if (lore.contains("§9Golden Heart"))
            list.add("goldheartI");


        if (lore.contains("§9Moctezuma III")){
            list.add("moctIII");
        }else if (lore.contains("§9Moctezuma II")){
            list.add("moctII");
        }else if (lore.contains("§9Moctezuma"))
            list.add("moctI");


        if (lore.contains("§dRARE! §9Escape Pod III")){
            list.add("escapeIII");
        }else if (lore.contains("§dRARE! §9Escape Pod II")) {
            list.add("escapeII");
        }else if (lore.contains("§dRARE! §9Escape Pod"))
            list.add("escapeI");

        if (lore.contains("§dRARE! §9Regularity III")){
            list.add("regIII");
        }else if (lore.contains("§dRARE! §9Regularity II")) {
            list.add("regII");
        }else if (lore.contains("§dRARE! §9Regularity"))
            list.add("regI");


        if (lore.contains("§9Gold Bump III")){
            list.add("goldBumpIII");
        }else if (lore.contains("§9Gold Bump II")){
            list.add("goldBumpII");
        }else if (lore.contains("§9Gold Bump"))
            list.add("goldBumpI");


        if (lore.contains("§dRARE! §9Solitude III")){
            list.add("soliIII");
        }else if (lore.contains("§dRARE! §9Solitude II")){
            list.add("soliII");
        }else if (lore.contains("§dRARE! §9Solitude"))
            list.add("soliI");


        if (lore.contains("§9Protection III")){
            list.add("protIII");
        }else if (lore.contains("§9Protection II")){
            list.add("protII");
        }else if (lore.contains("§9Protection"))
            list.add("protI");


        if (lore.contains("§9David and Goliath III")){
            list.add("davidIII");
        }else if (lore.contains("§9David and Goliath II")){
            list.add("davidII");
        }else if (lore.contains("§9David and Goliath"))
            list.add("davidI");


        if (lore.contains("§9\"Not\" Gladiator III")){
            list.add("gladIII");
        }else if (lore.contains("§9\"Not\" Gladiator II")){
            list.add("gladII");
        }else if (lore.contains("§9\"Not\" Gladiator"))
            list.add("gladI");


        if (lore.contains("§9Critically Funky III")){
            list.add("critIII");
        }else if (lore.contains("§9Critically Funky II")){
            list.add("critII");
        }if (lore.contains("§9Critically Funky"))
            list.add("critI");


        if (lore.contains("§9Misery"))
            list.add("misery");


        if (lore.contains("§9Fractional Reserve III")){
            list.add("fracIII");
        }else if (lore.contains("§9Fractional Reserve II")){
            list.add("fracII");
        }else if (lore.contains("§9Fractional Reserve"))
            list.add("fracI");


        if (lore.contains("§9Mirror III")){
            list.add("mirrorIII");
        }else if (lore.contains("§9Mirror II")){
            list.add("mirrorII");
        }else if (lore.contains("§9Mirror"))
            list.add("mirrorIII");


        if (lore.contains("§dRARE! §9Retro-Gravity Microcosm III")){
            list.add("rgmIII");
        }else if (lore.contains("§dRARE! §9Retro-Gravity Microcosm II")){
            list.add("rgmII");
        }else if (lore.contains("§dRARE! §9Retro-Gravity Microcosm")){
            list.add("rgmI");
        }


        if (lore.contains("§9Sweaty III")){
            list.add("sweatyIII");
        }else if (lore.contains("§9Sweaty II")){
            list.add("sweatyII");
        }else if (lore.contains("§9Sweaty"))
            list.add("sweatyI");


        if (lore.contains("§9XP Boost III")){
            list.add("xpIII");
        }else if (lore.contains("§9XP Boost II")){
            list.add("xpII");
        }else if (lore.contains("§9XP Boost"))
            list.add("xpI");

        if (lore.contains("§9XP Bump III")){
            list.add("xpbIII");
        }else if (lore.contains("§9XP Bump II")){
            list.add("xpbII");
        }else if (lore.contains("§9XP Bump"))
            list.add("xpbI");

        if (lore.contains("§9Gold Boost III")){
            list.add("gbIII");
        }else if (lore.contains("§9Gold Boost II")){
            list.add("gbII");
        }else if (lore.contains("§9Gold Boost"))
            list.add("gbI");


        if (lore.contains("§9Diamond Allergy III")){
            list.add("daIII");
        }else if (lore.contains("§9Diamond Allergy II")){
            list.add("daII");
        }else if (lore.contains("§9Diamond Allergy"))
            list.add("daI");


        if (lore.contains("§9Spite"))
            list.add("spite");

        if (lore.contains("§9McSwimmer III"))
            list.add("mcIII");

        return list;
    }

    public static List<String> CheckEnchantOnSword(List<String> lore) {

        List<String> list=new ArrayList<String>();


        if (lore.contains("§dRARE! §9Billionaire III")){
            list.add("billIII");
        }else if (lore.contains("§dRARE! §9Billionaire II")){
            list.add("billII");
        }else if (lore.contains("§dRARE! §9Billionaire"))
            list.add("billI");

        if (lore.contains("§dRARE! §9Combo: Perun's Wrath III")){
            list.add("perunIII");
        }else if (lore.contains("§dRARE! §9Combo: Perun's Wrath II")){
            list.add("perunII");
        }else if (lore.contains("§dRARE! §9Combo: Perun's Wrath"))
            list.add("perunI");

        if (lore.contains("§9Lifesteal III")){
            list.add("lsIII");
        }else if (lore.contains("§9Lifesteal II")){
            list.add("lsII");
        }else if (lore.contains("§9Lifesteal"))
            list.add("lsI");

        if (lore.contains("§9Pain Focus III")){
            list.add("pfIII");
        }else if (lore.contains("§9Pain Focus II")){
            list.add("pfII");
        }else if (lore.contains("§9Pain Focus"))
            list.add("pfI");

        if (lore.contains("§9Diamond Stomp III")){
            list.add("diamondIII");
        }else if (lore.contains("§9Diamond Stomp II")){
            list.add("diamondII");
        }else if (lore.contains("§9Diamond Stomp"))
            list.add("diamondI");

        if (lore.contains("§9Pain Focus III")){
            list.add("lsIII");
        }else if (lore.contains("§9Pain Focus II")){
            list.add("lsII");
        }else if (lore.contains("§9Pain Focus"))
            list.add("lsI");

        if (lore.contains("§dRARE! §9Gamble! III")){
            list.add("gambIII");
        }else if (lore.contains("§dRARE! §9Gamble! II")){
            list.add("gambII");
        }else if (lore.contains("§dRARE! §9Gamble!"))
            list.add("gambI");


        if (lore.contains("§9King Buster III")){
            list.add("kingIII");
        }else if (lore.contains("§9King Buster II")){
            list.add("kingII");
        }else if (lore.contains("§9King Buster"))
            list.add("kingI");

        if (lore.contains("§9Sharp III")){
            list.add("sharpIII");
        }else if (lore.contains("§9Sharp II")){
            list.add("sharpII");
        }else if (lore.contains("§9Sharp"))
            list.add("sharpI");

        if (lore.contains("§9Shark III")){
            list.add("sharkIII");
        }else if (lore.contains("§9Shark II")){
            list.add("sharkII");
        }else if (lore.contains("§9Shark"))
            list.add("sharkI");

        if (lore.contains("§9King Buster III")){
            list.add("kingIII");
        }else if (lore.contains("§9King Buster II")){
            list.add("kingII");
        }else if (lore.contains("§9King Buster"))
            list.add("kingI");

        if (lore.contains("§dRARE! §9Executioner III")){
            list.add("exeIII");
        }else if (lore.contains("§dRARE! §9Executioner II")){
            list.add("exeII");
        }else if (lore.contains("§dRARE! §9Executioner"))
            list.add("exeI");


        if (lore.contains("§9Moctezuma III")){
            list.add("moctIII");
        }else if (lore.contains("§9Moctezuma II")){
            list.add("moctII");
        }else if (lore.contains("§9Moctezuma"))
            list.add("moctI");


        if (lore.contains("§9Gold Bump III")){
            list.add("goldBumpIII");
        }else if (lore.contains("§9Gold Bump II")){
            list.add("goldBumpII");
        }else if (lore.contains("§9Gold Bump"))
            list.add("goldBumpI");


        if (lore.contains("§9Sweaty III")){
            list.add("sweatyIII");
        }else if (lore.contains("§9Sweaty II")){
            list.add("sweatyII");
        }else if (lore.contains("§9Sweaty"))
            list.add("sweatyI");


        if (lore.contains("§9XP Boost III")){
            list.add("xpIII");
        }else if (lore.contains("§9XP Boost II")){
            list.add("xpII");
        }else if (lore.contains("§9XP Boost I"))
            list.add("xpI");

        if (lore.contains("§9XP Bump III")){
            list.add("xpbIII");
        }else if (lore.contains("§9XP Bump II")){
            list.add("xpbII");
        }else if (lore.contains("§9XP Bump"))
            list.add("xpbI");

        if (lore.contains("§9Gold Boost III")){
            list.add("gbIII");
        }else if (lore.contains("§9Gold Boost II")){
            list.add("gbII");
        }else if (lore.contains("§9Gold Boost"))
            list.add("gbI");


        return list;
    }

}