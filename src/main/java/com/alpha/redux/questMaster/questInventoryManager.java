package com.alpha.redux.questMaster;

import com.alpha.redux.items.enchants;
import com.alpha.redux.renownShop.RenownStorage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static com.alpha.redux.playerdata.economy.*;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.summonBoss;
import static com.alpha.redux.questMaster.questLevel.addQuestLevel;
import static com.alpha.redux.renownShop.RenownStorage.getUberDrop;

public class questInventoryManager {
    public static void main(InventoryClickEvent event){
        String uuid = String.valueOf(event.getWhoClicked().getUniqueId());
        Player player = (Player) event.getWhoClicked();

        ItemStack claimRewards = questMenuItems.claimRewards(uuid);
        ItemStack KillPlayersQuest = questMenuItems.KillPlayersQuest(uuid);
        ItemStack FindCakeQuest = questMenuItems.FindCakeQuest(uuid);
        ItemStack BringVileQuest = questMenuItems.BringVileQuest(uuid);
        ItemStack BringCoinsQuest = questMenuItems.BringCoinsQuest(uuid);
        ItemStack BringFreshQuest = questMenuItems.BringFreshQuest(uuid);

        if(event.getCurrentItem().equals(FindCakeQuest)){
            if(player.getInventory().containsAtLeast(new ItemStack(Material.CAKE), 4)){
                if(getEconomy(uuid) >= 100000){
                    for (int i = 0; i < 4; i++) {
                        player.getInventory().removeItem(new ItemStack(Material.CAKE));
                    }

                    removeEconomy(uuid, 100000);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7I didn't think you would be able to complete this quest!"));

                    Random rand = new Random(); //instance of random class
                    int upperbound = 10;
                    int int_random = rand.nextInt(upperbound);

                    switch (int_random){
                        case 0:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &c&lARGH! &7I got jumped by the nasty cheater! Sorry I wasn't able to bring your reward. From the kindness of my heart I'll refund half your gold!"));
                            addEconomy(uuid, 50000);
                            break;
                        case 1:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.LIGHT_PURPLE + "Uberdrop" + ChatColor.GREEN + "!");
                            player.getInventory().addItem(getUberDrop());
                            break;
                        case 2:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+32 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 32; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 3:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+48 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 48; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 4:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+16 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 16; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 5:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+8 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 8; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 6:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+64 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 64; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 7:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+2 " + ChatColor.DARK_AQUA+ "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 2; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 8:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.DARK_AQUA + "Player Soul" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 1; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 9:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+3 " + ChatColor.DARK_AQUA + "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 3; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &7Hmm it seems as you don't have enough gold for that, come back when you have 100,000 gold!"));
                }

            }
        }else if(event.getCurrentItem().equals(KillPlayersQuest)){
            if(player.getInventory().containsAtLeast(enchants.playerSoul, 4)) {
                if (getEconomy(uuid) >= 100000) {
                    for (int i = 0; i < 16; i++) {
                        player.getInventory().removeItem(enchants.playerSoul);
                    }

                    removeEconomy(uuid, 100000);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7I didn't think you would be able to complete this quest!"));

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                    player.playSound(player.getLocation(), Sound.GHAST_SCREAM, 10, 10);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &kWHATISGOINGONTODAY"));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 10, true, true));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &cAHHH QUICK KILL HIM!!! &7I've cast a spell on you to protect you, but it'll only work when your in spawn! Hurry before time runs out!!!"));
                    summonBoss(player);
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &7Hmm it seems as you don't have enough gold for that, come back when you have 100,000 gold!"));
                }
            }
        }else if(event.getCurrentItem().equals(BringVileQuest)){
            if(player.getInventory().containsAtLeast(enchants.vile, 64)) {
                if (getEconomy(uuid) >= 100000) {
                    for (int i = 0; i < 64; i++) {
                        player.getInventory().removeItem(enchants.vile);
                    }

                    removeEconomy(uuid, 100000);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7I didn't think you would be able to complete this quest!"));

                    Random rand = new Random(); //instance of random class
                    int upperbound = 10;
                    int int_random = rand.nextInt(upperbound);

                    switch (int_random){
                        case 0:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &c&lARGH! &7I got jumped by the nasty cheater! Sorry I wasn't able to bring your reward. From the kindness of my heart I'll refund half your gold!"));
                            addEconomy(uuid, 50000);
                            break;
                        case 1:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.LIGHT_PURPLE + "Uberdrop" + ChatColor.GREEN + "!");
                            player.getInventory().addItem(getUberDrop());
                            break;
                        case 2:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+32 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 32; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 3:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+48 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 48; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 4:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+16 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 16; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }

                            break;
                        case 5:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+8 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 8; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }

                            break;
                        case 6:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+64 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 64; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 7:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+2 " + ChatColor.DARK_AQUA+ "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 2; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 8:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.DARK_AQUA + "Player Soul" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 1; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 9:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+3 " + ChatColor.DARK_AQUA + "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 3; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &7Hmm it seems as you don't have enough gold for that, come back when you have 100,000 gold!"));
                }
            }
        }else if(event.getCurrentItem().equals(BringFreshQuest)){
            if(player.getInventory().containsAtLeast(enchants.fresh_reds, 20)) {
                if (getEconomy(uuid) >= 100000) {
                    for (int i = 0; i < 20; i++) {
                        player.getInventory().removeItem(enchants.fresh_reds);
                    }

                    removeEconomy(uuid, 100000);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7I didn't think you would be able to complete this quest!"));

                    Random rand = new Random(); //instance of random class
                    int upperbound = 10;
                    int int_random = rand.nextInt(upperbound);

                    switch (int_random){
                        case 0:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &c&lARGH! &7I got jumped by the nasty cheater! Sorry I wasn't able to bring your reward. From the kindness of my heart I'll refund half your gold!"));
                            addEconomy(uuid, 50000);
                            break;
                        case 1:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.LIGHT_PURPLE + "Uberdrop" + ChatColor.GREEN + "!");
                            player.getInventory().addItem(getUberDrop());
                            break;
                        case 2:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+32 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 32; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 3:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+48 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 48; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 4:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+16 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 16; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 5:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+8 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 8; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 6:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+64 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 64; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                        case 7:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+2 " + ChatColor.DARK_AQUA+ "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 2; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 8:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.DARK_AQUA + "Player Soul" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 1; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 9:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+3 " + ChatColor.DARK_AQUA + "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 3; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &7Hmm it seems as you don't have enough gold for that, come back when you have 100,000 gold!"));
                }
            }
        }else if(event.getCurrentItem().equals(BringCoinsQuest)){
                if (getEconomy(uuid) >= 1000000) {

                    removeEconomy(uuid, 1000000);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7I didn't think you would be able to complete this quest!"));

                    Random rand = new Random(); //instance of random class
                    int upperbound = 10;
                    int int_random = rand.nextInt(upperbound);

                    switch (int_random){
                        case 0:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &c&lARGH! &7I got jumped by the nasty cheater! Sorry I wasn't able to bring your reward. From the kindness of my heart I'll refund half your gold!"));
                            addEconomy(uuid, 500000);
                            break;
                        case 1:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.LIGHT_PURPLE + "Uberdrop" + ChatColor.GREEN + "!");
                            player.getInventory().addItem(getUberDrop());
                            break;
                        case 2:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+32 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 32; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 3:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+48 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 48; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 4:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+16 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 16; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 5:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+8 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 8; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;

                        case 6:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+64 " + ChatColor.YELLOW + "Renown Tokens" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 64; i++) {
                                player.getInventory().addItem(RenownStorage.getToken());
                            }
                            break;
                        case 7:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+2 " + ChatColor.DARK_AQUA+ "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 2; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 8:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+1 " + ChatColor.DARK_AQUA + "Player Soul" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 1; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                        case 9:
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &a&lWOW! &7Your reward will be sent shortly!"));
                            player.sendMessage(ChatColor.GREEN + "+3 " + ChatColor.DARK_AQUA + "Player Souls" + ChatColor.GREEN + "!");
                            for (int i = 0; i < 3; i++) {
                                player.getInventory().addItem(enchants.playerSoul);
                            }
                            break;
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &7Hmm it seems as you don't have enough gold for that, come back when you have 100,000 gold!"));
                }
        }

        event.setCancelled(true);
    }
}
