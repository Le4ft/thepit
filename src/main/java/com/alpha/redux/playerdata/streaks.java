package com.alpha.redux.playerdata;

import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.items.enchants;
import com.nametagedit.plugin.NametagEdit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApiGetLevelColor;
import static com.alpha.redux.apis.locations.getSpawnLocation;
import static com.alpha.redux.apis.strikeLight.strikeLightningForPlayers;
import static com.alpha.redux.events.events.Strength;
import static com.alpha.redux.playerdata.bounties.BountyManager;
import static com.alpha.redux.playerdata.economy.addEconomy;
import static com.alpha.redux.playerdata.uber.claimUberReward;
import static com.alpha.redux.renownShop.RenownStorage.getUberDrop;

public class streaks {
    // Set Material to BARRIER when running unless not using custom item
    public static void GiveUberItems(Player player, ItemStack item, int amount, boolean customItem, Material material){
        if (customItem){
            for (int i = 0; i < amount; i++) {
                player.getInventory().addItem(item);
            }
        }else{
            player.getInventory().addItem(new ItemStack(material, amount));
        }

    }

    public static HashMap<String, Integer> killstreak = new HashMap<>();
    public static HashMap<String, String> megastreak = new HashMap<>();
    public static HashMap<String, Integer> xp_amount_mega = new HashMap<>();
    public static HashMap<String, Double> mega_damage_amount = new HashMap<>();
    public static HashMap<String, Double> true_damage_amount = new HashMap<>();

    public static void setStreak(String player, double amount){
        killstreak.put(player, (int) amount);
    }

    public static void addStreak(String player, double amount){
        killstreak.put(player, (int) (killstreak.get(player)+amount));
    }

    public static int getStreak(String player){
        return killstreak.get(player);
    }

    public static boolean hasStreak(String player){
        if(killstreak.containsKey(player)){
            return true;
        }else{
            killstreak.put(player, 0);
        }
        return true;
    }

    public static void setMega(String player, String mega){
        megastreak.put(player, mega);
    }

    public static String getMegaStreak(String player){
        return megastreak.get(player);
    }

    public static boolean hasMegaStreak(String player){
        if(megastreak.containsKey(player)){
            return true;
        }else{
            megastreak.put(player, "beastmode");
        }
        return true;
    }

    public static int Uber(Player player){
        hasStreak(String.valueOf(player.getUniqueId()));
        if (getStreak(String.valueOf(player.getUniqueId())) == 100){
            Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " Is on a 100 Uber Streak, 300 more kills!");
        }else if (getStreak(String.valueOf(player.getUniqueId())) == 200){
            NametagEdit.getApi().setNametag(player, "§d§lUBER 200 " + rank.getNameColor(player), "");
            Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " Is on a 200 Uber Streak, 200 more kills!");
        }else if (getStreak(String.valueOf(player.getUniqueId())) == 300) {
            NametagEdit.getApi().setNametag(player, "§d§lUBER 300 " + rank.getNameColor(player), "");
            Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " Is on a 300 Uber Streak, 100 more kills!");
            if (getStreak(String.valueOf(player.getUniqueId())) <= 1) {
                player.sendMessage(ChatColor.RED + "You have started the Uberstreak, Good Luck!");
            }}

        UberRewardClaimDeath(player);

        // Player Reaches Uber 400

        return 1;
    }

    public static void UberRewardClaimDeath(Player player){
        if(Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "uber")){
            if (getStreak(String.valueOf(player.getUniqueId())) >= 400){
                player.setMaxHealth(20);
                player.setHealth(player.getMaxHealth());
                player.removePotionEffect(PotionEffectType.SLOW);
                player.removePotionEffect(PotionEffectType.POISON);
                setMega(String.valueOf(player.getUniqueId()), "beastmode");
                NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId())) + rank.getNameColor(player), "");
                setStreak(String.valueOf(player.getUniqueId()), 0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                player.getInventory().addItem(getUberDrop());
                Location loc = getSpawnLocation();
                player.teleport(loc);
            }
        }

    }

    public static int Beast(Player player){
        hasStreak(String.valueOf(player.getUniqueId()));
        if (getStreak(String.valueOf(player.getUniqueId())) >= 50){
            if(mega_damage_amount.containsKey(String.valueOf(player.getUniqueId()))){
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), mega_damage_amount.get(String.valueOf(player.getUniqueId())) + .001);
            }
            if(xp_amount_mega.containsKey(String.valueOf(player.getUniqueId()))){
                if(getStreak(String.valueOf(player.getUniqueId())) % 15 == 0){
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), xp_amount_mega.get(String.valueOf(player.getUniqueId())) + 5);
                }

            }
            return 2;
        }
        return 1;
    }

    public static int Moon(Player player){
        hasStreak(String.valueOf(player.getUniqueId()));
        if (getStreak(String.valueOf(player.getUniqueId())) >= 100){
            if(mega_damage_amount.containsKey(String.valueOf(player.getUniqueId()))){
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), mega_damage_amount.get(String.valueOf(player.getUniqueId())) + .005);
            }
            if(xp_amount_mega.containsKey(String.valueOf(player.getUniqueId()))){
                if(getStreak(String.valueOf(player.getUniqueId())) % 15 == 0){
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), xp_amount_mega.get(String.valueOf(player.getUniqueId())) + 10);
                }

            }
            return 7;
        }
        return 1;
    }

    public static int Highlander(Player player){
        hasStreak(String.valueOf(player.getUniqueId()));
        if (getStreak(String.valueOf(player.getUniqueId())) >= 50){
            if(mega_damage_amount.containsKey(String.valueOf(player.getUniqueId()))){
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), mega_damage_amount.get(String.valueOf(player.getUniqueId())) + .001);
            }
            return 3;
        }
        return 1;
    }

    public static int StreakManager(Player player){
        hasStreak(String.valueOf(player.getUniqueId()));
        if(!isNPC(player)){
            BountyManager(player);
        }


        if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "beastmode")){
            if(getStreak(String.valueOf(player.getUniqueId())) > 49 && getStreak(String.valueOf(player.getUniqueId())) < 51){
                NametagEdit.getApi().setNametag(player, "§a§lBEAST " + rank.getNameColor(player), "");
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 1);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.3);
                strikeLightningForPlayers(player.getLocation(), player);
            }
            return Beast(player);
        }if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "moon")){
            if(getStreak(String.valueOf(player.getUniqueId())) > 99 && getStreak(String.valueOf(player.getUniqueId())) < 101){
                NametagEdit.getApi().setNametag(player, "§b§lMOON " + rank.getNameColor(player), "");
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 10);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), .5);
                strikeLightningForPlayers(player.getLocation(), player);
            }
            return Moon(player);
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "uber")){
            if(getStreak(String.valueOf(player.getUniqueId())) > 99 && getStreak(String.valueOf(player.getUniqueId())) < 101){
                NametagEdit.getApi().setNametag(player, "§d§lUBER 100 " + rank.getNameColor(player), "");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 32000, 0, true, true));
                strikeLightningForPlayers(player.getLocation(), player);
                if(mega_damage_amount.containsKey(String.valueOf(player.getUniqueId()))){
                    mega_damage_amount.put(String.valueOf(player.getUniqueId()), mega_damage_amount.get(String.valueOf(player.getUniqueId())) + .025);
                }
            }
            return Uber(player);
        }else if (Objects.equals(getMegaStreak(String.valueOf(player.getUniqueId())), "highlander")){
            if(getStreak(String.valueOf(player.getUniqueId())) > 49 && getStreak(String.valueOf(player.getUniqueId())) < 51){
                NametagEdit.getApi().setNametag(player, "§6§lHIGH " + rank.getNameColor(player), "");
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.01);
                strikeLightningForPlayers(player.getLocation(), player);
            }
            return Highlander(player);
        }else{
            return 1;
        }
    }

}
