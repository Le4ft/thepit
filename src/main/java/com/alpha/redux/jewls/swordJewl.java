package com.alpha.redux.jewls;

import com.alpha.redux.apis.chatManager.rank;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static com.alpha.redux.apis.FancyText.compileListToString;
import static com.alpha.redux.apis.FancyText.hoverText;
import static com.alpha.redux.well.swordEnchanter.*;
import static com.alpha.redux.well.loreChecker.CheckEnchantOnSword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class swordJewl {
    public static ItemStack generateJewelSword(Player player){

        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);


        Random rand = new Random(); //instance of random class
        int upperbound = 40;
        int int_random = rand.nextInt(upperbound);
        List<String> lore = new ArrayList<>();
        switch (int_random){
            case 0:
            case 1:
            case 2:
            case 3:
                if (Billion(lore)) {
                    break;
                }
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Billionaire III");
                lore.add("§7Hits with this swords deal §c2x");
                lore.add("§cdamage§7 but cost §6350g");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7 created &cTier I Sword!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                if(Moctezuma(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Moctezuma III");
                lore.add("§7Earn §6+18g§7 on kill (assists");
                lore.add("§7excluded)");
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                if(GoldBump(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Gold Bump III");
                lore.add("§7Earn §6+12g§7 on kill");
                break;
            case 13:
            case 14:
            case 15:
                if (lifesteal(lore)) {
                    break;
                }
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Lifesteal III");
                lore.add("§7Heal for §c13%§7 of damage dealt up");
                lore.add("§7to §c1.5❤");
                break;
            case 16:
                if (Kingbust(lore)) {
                    break;
                }
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9King Buster III");
                lore.add("§7Deal §c+20%§7 damage vs. players");
                lore.add("§7above 50% HP");
                break;
            case 17:
            case 18:
                if (execution(lore)) {
                    break;
                }
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Executioner III");
                lore.add("§7Hitting an enemy to below §c3.5❤");
                lore.add("§7instantly kills them");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7 created &cTier I Sword!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
            case 20:
            case 21:
            case 22:
                if(Sweaty(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Sweaty III");
                lore.add("§7Earn §b+60% XP§7 from streak XP");
                lore.add("§7bonus and §b+100 max XP§7 per kill");
                break;
            case 23:
            case 24:
            case 25:
            case 26:
                if(XPBoost(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9XP Boost III");
                lore.add("§7Earn §b+30% XP§7 from kills");
                break;
            case 27:
            case 28:
            case 29:
                if(XPBump(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9XP Bump III");
                lore.add("§7Earn §b+6 XP §7per");
                lore.add("§7kill");
                break;
            case 30:
            case 31:
            case 32:
            case 33:
                if(GoldBoost(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Gold Boost III");
                lore.add("§7Earn §6+45% gold (g)§7 from kill");
                break;
            case 34:
            case 35:
            case 36:
                if(shark(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Shark III");
                lore.add("§7Deal §c+7%§7 damager per other");
                lore.add("§7player below §c6❤§7 within 12");
                lore.add("§7blocks");
                break;
            case 37:
                if(sharp(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Sharp III");
                lore.add("§7Deal §c+12%§7 melee damage");
                break;
            case 38:
                if(PerunWrath(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Combo: Perun's Wrath III");
                lore.add("§7Each §efourth§7 hit strikes");
                lore.add("§elightning§7 for §c1❤§7 + §c1❤");
                lore.add("§7per §bdiamond piece§7 on your");
                lore.add("§7victim.");
                lore.add("§7§oLightning deals true damage");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7 created &cTier I Sword!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
            case 39:
                if(gamble(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Gamble! III");
                lore.add("§d50% chance §7to deal §c3❤§7 true");
                lore.add("§7damage to whoever you hit, or to");
                lore.add("§7yourself");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7 created &cTier I Sword!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
        }


        meta.setLore(lore);
        item.setItemMeta(meta);

        hoverText(ChatColor.translateAlternateColorCodes('&', "&3&lJEWEL! " + rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained: " + ChatColor.RED + "Jewel Enchant!"), compileListToString(lore));
        return item;
    }
}
