package com.alpha.redux.jewls;

import com.alpha.redux.apis.chatManager.rank;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.alpha.redux.apis.FancyText.compileListToString;
import static com.alpha.redux.apis.FancyText.hoverText;
import static com.alpha.redux.well.enchanters.*;
import static com.alpha.redux.well.enchanters.Mirror;

public class pantJewl {
    public static ItemStack generateJewlPants(Player player){

        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.fromRGB(255, 51, 51));
        meta.setDisplayName("§cTier I Red Pants");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);


        Random rand = new Random(); //instance of random class
        int upperbound = 41;
        int int_random = rand.nextInt(upperbound);
        List<String> lore = new ArrayList<>();
        switch (int_random){
            case 0:
            case 1:
            case 2:
            case 3:
                if(GoldHeart(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Golden Heart III");
                lore.add("§7Gain §6+2❤§7 absorption on kill");
                lore.add("§7(max §6❤§7)");
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
                 if(Protection(lore)){break;}
                 lore.add("§7Lives: §a20§7/20");
                 lore.add("    ");
                 lore.add("§9Protection III");
                 lore.add("§7Receive §9-10%§7 damage");
                 break;
            case 16:
                 if(CritFunky(lore)){break;}
                 lore.add("§7Lives: §a20§7/20");
                 lore.add("    ");
                 lore.add("§9Critically Funky III");
                 lore.add("§7Critical hits against you deal");
                 lore.add("§950% §7of the damage they");
                 lore.add("§7normally would and empower your");
                 lore.add("§7next strike for §c+30%§7 damage");
                 break;
            case 17:
            case 18:
                 if(Peroxide(lore)){break;}
                 lore.add("§7Lives: §a20§7/20");
                 lore.add("    ");
                 lore.add("§9Peroxide III");
                 lore.add("§7Gain §cRegen II §7(8s) when hit");
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
                if(NotGladiator(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9\"Not\" Gladiator III");
                lore.add("§7Receive §9-2% damage per nearby");
                lore.add("§7player (max 10 players)");
                break;
            case 37:
                if(Mirror(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§9Mirror III");
                lore.add("§7You are immune to true damage");
                break;
            case 38:
                if(EscapePod(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Escape Pod III");
                lore.add("§7When hit below §c2 §7, launch");
                lore.add("§7into the air dealing §c3 §7damage");
                lore.add("§7to nearby enemies and gaining");
                lore.add("§aRegen IV§7 (30s), Can launch");
                lore.add("§7once per item life. (Removes 3 lives on proc)");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7created &cTier I Pants!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
            case 39:
                if(rgm(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Retro-Gravity Microcosm III");
                lore.add("§7When a player hits you from");
                lore.add("§7above ground §e3 times§7 in a row:");
                lore.add("§7You heal §c1.2❤");
                lore.add("§7Gain §c+1.5❤§f §cdamage§f vs them for §e30s");
                lore.add("§7They take §c0.5❤§f §ftrue damage");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7created &cTier I Pants!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
            case 40:
                if(reg(lore)){break;}
                lore.add("§7Lives: §a20§7/20");
                lore.add("    ");
                lore.add("§dRARE! §9Regularity III");
                lore.add("§7If the final damage of your strike");
                lore.add("§7deals less than §c1.5❤§7 §7damage,");
                lore.add("§7strike again in §a0.1s §7for §c75%");
                lore.add("§7damage");
                hoverText(ChatColor.translateAlternateColorCodes('&', "&d&lRARE! " + rank.getNameColor(player) + player.getDisplayName() + "&7created &cTier I Pants!"), compileListToString(lore));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                break;
            }

        hoverText(ChatColor.translateAlternateColorCodes('&', "&3&lJEWEL! " + rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " obtained: " + ChatColor.RED + "Jewel Enchant!"), compileListToString(lore));

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
