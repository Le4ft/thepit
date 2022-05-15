package com.alpha.redux.commands;

import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.events.boards;
import com.alpha.redux.items.enchants;
import com.alpha.redux.playerdata.economy;
import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import com.alpha.redux.well.EnchantingMechanics;
import com.nametagedit.plugin.NametagEdit;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import com.alpha.redux.items.itemManager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alpha.redux.DeathHandler.MysticUtils.MysticRepairs;
import static com.alpha.redux.apis.FancyText.compileListToString;
import static com.alpha.redux.apis.FancyText.hoverText;
import static com.alpha.redux.apis.HeadNames.headnames.changeName;
import static com.alpha.redux.apis.TebexMoners.tebexmoners.ColorfulBoxers;
import static com.alpha.redux.apis.TebexMoners.tebexmoners.onRankBuy;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApiGetLevelColor;
import static com.alpha.redux.apis.commandBuilder.BaseChecks;
import static com.alpha.redux.apis.leaderboardsplus.leaderboards.*;
import static com.alpha.redux.apis.locations.getSpawnLocation;
import static com.alpha.redux.apis.skyblock.skyblockItems.termy;
import static com.alpha.redux.events.events.*;
import static com.alpha.redux.events.nonPermItems.ClearAndCheck;
import static com.alpha.redux.funEvents.event.endTwoTimes;
import static com.alpha.redux.funEvents.event.twoTimesEvent;
import static com.alpha.redux.items.tebexItems.giveDyes;
import static com.alpha.redux.playerdata.economy.*;
import static com.alpha.redux.playerdata.playerStats.deleteHologramStreak;
import static com.alpha.redux.playerdata.prestiges.*;
import static com.alpha.redux.playerdata.streaks.*;
import static com.alpha.redux.playerdata.xpManager.GetCurrentLevel;
import static com.alpha.redux.playerdata.xpManager.getXp;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.summonBoss;
import static com.alpha.redux.well.gui.*;
import static com.alpha.redux.well.loreChecker.CheckEnchant;

public class command implements CommandExecutor {
    public static HashMap<String, Boolean> KillMessages = new HashMap<>();

    public static Map<String, Long> freshPantsCD = new HashMap<String, Long>();

    public static Map<String, Long> ShowCD = new HashMap<String, Long>();

    List<Integer> runnables = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)) {



            if (cmd.getName().equalsIgnoreCase("makemonersrankers")) {
                onRankBuy(args[0], args[1]);
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("purchaseDyes")) {
                ColorfulBoxers(args[0]);
                return true;
            }
            return true;
        }
        Player player = (Player) sender;
        // /heal

        
        if (cmd.getName().equalsIgnoreCase("activateBooster")) {
            if(player.hasPermission("booster")){

                if(args.length < 1){
                    player.sendMessage(ChatColor.RED + "Please put a time for the booster to last for example: /activateBooster 5/10/15/20/25/30/35/40/45/50");
                    return true;
                }

                if(twoTimesEvent >= 2){
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lBOOSTER &c&lENDED!"));

                    for (Integer task : runnables) {
                        runnables.remove(task);
                    }

                    twoTimesEvent = 1;
                    return true;
                }

                int time;
                try{
                    time = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Please use a number!");
                    return true;
                }

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lBOOSTER!!! &7There is currently an active booster for &e&l" + time + "m&7."));
                twoTimesEvent += 2;
                int runnable = Bukkit.getScheduler().scheduleSyncDelayedTask(economy.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lBOOSTER &c&lENDED!"));
                        twoTimesEvent = 1;
                    }
                }, (time * 60L) * 20);

                runnables.add(runnable);

                return true;
            }
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("repairs")){
            if(player.getInventory().containsAtLeast(enchants.vile, 1)){
                try{
                    ItemMeta meta = player.getInventory().getItemInHand().getItemMeta();

                    String lives = meta.getLore().get(0);

                    if(ChatColor.stripColor(lives).contains("Lives: 20/20")){
                        player.sendMessage(ChatColor.RED + "This mystic has the max lives!");
                        return true;
                    }

                    meta.setLore(MysticRepairs(meta.getLore()));

                    player.getInventory().getItemInHand().setItemMeta(meta);
                    player.getInventory().removeItem(enchants.vile);
                    player.sendMessage(ChatColor.GREEN + "+1" + ChatColor.DARK_GRAY + " Mystic Life");
                    return true;
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "Please hold a mystic!");
                    return true;
                }
            }else{
                player.sendMessage(ChatColor.RED + "You don't have any vile!");
                return true;
            }
        }

        if(cmd.getName().equalsIgnoreCase("veloCheck")){
            if(player.hasPermission("admin.velo")){
                if(args.length < 1){
                    player.sendMessage(ChatColor.RED + "Please use this format: /veloCheck");
                }else{
                    Player checkedPlayer = null;
                    boolean success = false;
                    try{
                        checkedPlayer = Bukkit.getPlayer(args[0]);
                        success = true;
                    }catch (Exception e){
                        player.sendMessage(ChatColor.RED + "An error occured, maybe that player is offline!");
                    }

                    if(success){


                        Location playerLocation = checkedPlayer.getLocation();
                        for (int i = 0; i < 50; i++) {
                            checkedPlayer.setVelocity(player.getEyeLocation().getDirection());
                        }
                        checkedPlayer.teleport(playerLocation);
                    }
                }
            }
        }

        if(cmd.getName().equalsIgnoreCase("enchantPant")){
            if(!player.hasPermission("pantEnchant")) return true;
            if(args.length < 1){
                player.sendMessage(ChatColor.RED + "Please use this format: /enchantPant <enchant>");
                return true;
            }

            if(player.getInventory().getItemInHand() != null){

                ItemMeta meta = player.getInventory().getItemInHand().getItemMeta();

                if(player.getInventory().getItemInHand().getType().equals(Material.LEATHER_LEGGINGS)){
                    List<String> lore = new EnchantingMechanics(player.getInventory().getItemInHand().getItemMeta().getLore(), args[0], .3, .5, "PANT").getLore();

                    meta.setLore(lore);

                }else if(player.getInventory().getItemInHand().getType().equals(Material.GOLD_SWORD)){
                    List<String> lore = new EnchantingMechanics(player.getInventory().getItemInHand().getItemMeta().getLore(), args[0], .3, .5, "SWORD").getLore();

                    meta.setLore(lore);

                }

                player.getInventory().getItemInHand().setItemMeta(meta);

            }

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("play")){
            if(args[0].equalsIgnoreCase("pit")){
                hasStreak(String.valueOf(player.getUniqueId()));

                if (cooldowns.containsKey(String.valueOf(player.getUniqueId()))){
                    // player is inside mute map
                    if (cooldowns.get(String.valueOf(player.getUniqueId())) > System.currentTimeMillis()){
                        // They still have time left on mute
                        long timeleft = (cooldowns.get(String.valueOf(player.getUniqueId())) - System.currentTimeMillis()) / 1000;
                        player.sendMessage(ChatColor.RED + "You are in combat for: " + ChatColor.GREEN + timeleft + ChatColor.RED + " seconds");
                        return true;
                    }else{
                        player.removePotionEffect(PotionEffectType.WEAKNESS);
                        setStreak(String.valueOf(player.getUniqueId()), 0);
                        xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                        Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                        mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                        true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                        xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                        Location loc = getSpawnLocation();
                        player.teleport(loc);
                        boards.CreateScore(player);
                        return true;
                    }

                }else{
                    player.removePotionEffect(PotionEffectType.WEAKNESS);
                    setStreak(String.valueOf(player.getUniqueId()), 0);
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                    Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                    mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                    true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                    Location loc = getSpawnLocation();
                    player.teleport(loc);
                    boards.CreateScore(player);
                }
                return true;
            }
        }

        if(cmd.getName().equalsIgnoreCase("hub")){
            hasStreak(String.valueOf(player.getUniqueId()));

            if (cooldowns.containsKey(String.valueOf(player.getUniqueId()))){
                // player is inside mute map
                if (cooldowns.get(String.valueOf(player.getUniqueId())) > System.currentTimeMillis()){
                    // They still have time left on mute
                    long timeleft = (cooldowns.get(String.valueOf(player.getUniqueId())) - System.currentTimeMillis()) / 1000;
                    player.sendMessage(ChatColor.RED + "You are in combat for " + ChatColor.RED + timeleft + ChatColor.RED + " more seconds");
                    return true;
                }else{
                    player.removePotionEffect(PotionEffectType.WEAKNESS);
                    setStreak(String.valueOf(player.getUniqueId()), 0);
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                    Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                    mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                    true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                    Location loc = new Location(Bukkit.getWorld("world"), -33, 100, 436, 0, 0);
                    player.teleport(loc);
                    boards.CreateScore(player);
                    return true;
                }

            }else{
                player.removePotionEffect(PotionEffectType.WEAKNESS);
                setStreak(String.valueOf(player.getUniqueId()), 0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Location loc = new Location(Bukkit.getWorld("world"), -33, 100, 436, 0, 0);
                player.teleport(loc);
                boards.CreateScore(player);
            }
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("KillMessageToggle")) {
            if(!KillMessages.containsKey(String.valueOf(player.getUniqueId()))){
                KillMessages.put(String.valueOf(player.getUniqueId()), false);
                player.sendMessage(ChatColor.RED + "Death messages off!");
            }else{
                if(KillMessages.get(String.valueOf(player.getUniqueId())).equals(true)){
                    KillMessages.put(String.valueOf(player.getUniqueId()), false);
                    player.sendMessage(ChatColor.RED + "Death messages off!");
                }else{
                    KillMessages.put(String.valueOf(player.getUniqueId()), true);
                    player.sendMessage(ChatColor.GREEN + "Death messages on!");
                }
            }

            return true;
        }

        if(BaseChecks(player, cmd.getName(), "mkBoard", true, false, "null")){TopPlayers();}

        if(BaseChecks(player, cmd.getName(), "rBoard", true, false, "null")){RefreshBoard();}

        if(cmd.getName().equalsIgnoreCase("all")){
            if(player.isOp()){
                changeName(player.getDisplayName(), player);
                Inventory inv = player.getInventory();
                inv.addItem(enchants.malding_boots);
                inv.addItem(enchants.malding_chestplate);
                inv.addItem(enchants.malding_pants);
                inv.addItem(enchants.lores);
                inv.addItem(enchants.vile);
                inv.addItem(itemManager.arch);
                inv.addItem(enchants.fresh_sword);
                inv.addItem(itemManager.feather);
                inv.addItem(enchants.jewl_pant);
                inv.addItem(enchants.jewl_sword);

                inv.addItem(itemManager.DiamondSword);
                inv.addItem(itemManager.DiamondHelmet);
                inv.addItem(itemManager.DiamondChestplate);
                inv.addItem(itemManager.DiamondLeggings);
                inv.addItem(itemManager.DiamondBoots);

                inv.addItem(enchants.fresh_reds);
                inv.addItem(itemManager.megalongbow);
                inv.addItem(itemManager.goldHelm);
                inv.addItem(itemManager.ftts);
                giveDyes(player.getDisplayName());
            }

            return true;
        }

        if(cmd.getName().equalsIgnoreCase("well")) {
            base(player);
            return true;
        }

        if(BaseChecks(player, cmd.getName(), "getXp", true, false, "null")){
            player.getInventory().addItem(termy);
            twoTimesEvent();
            Bukkit.broadcastMessage(String.valueOf(getXp(String.valueOf(player.getUniqueId()))));
            int[] randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);
            Bukkit.broadcastMessage("First thingy" + randomDUDE[0]);
            Bukkit.broadcastMessage("Second thingy" + randomDUDE[1]);
            return true;
        }

        if(BaseChecks(player, cmd.getName(), "checkPants", true, false, "null")){
            endTwoTimes();
            List<String> lists = CheckEnchant(player);
            player.sendMessage(String.valueOf(lists));
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("prestige")){
            PrestigeMenu(player);
            return true;
        }

        if(BaseChecks(player, cmd.getName(), "prestiges", false, true, "SetPrestige")){
            if(args.length != 3){
                player.sendMessage(ChatColor.RED + "Hey! You cannot use that command like that!");
                player.sendMessage(ChatColor.GREEN + "Usage: /prestiges <set> <amount> <uuid>");
                return true;
            }

            if (args[0].equalsIgnoreCase("set")){
                double amount = Double.parseDouble(args[1]);
                hasPrestige(args[2]);
                setPrestige(args[2], (int) amount);
                player.sendMessage(ChatColor.GREEN + "Prestige succesfully set!");
                return true;
            }
        }

        if(BaseChecks(player, cmd.getName(), "malding", false, true, "malding")){
            summonBoss(player);
            Bukkit.broadcastMessage(ChatColor.GRAY + "A wild " + ChatColor.RED + "Malding " + ChatColor.GRAY + "has appeared!");
        }

        if(BaseChecks(player, cmd.getName(), "gold", false, true, "SetPrestige")){
            if(args.length != 2){
                player.sendMessage(ChatColor.RED + "Hey! You cannot use that command like that!");
                player.sendMessage(ChatColor.GREEN + "Usage: /gold <set> <amount>");
                return true;
            }

            if (args[0].equalsIgnoreCase("set")){
                double amount = Double.parseDouble(args[1]);
                hasEconomy(String.valueOf(player.getUniqueId()));
                setEconomy(String.valueOf(player.getUniqueId()), (int) amount);
                boards.CreateScore(player);
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("pants")){
            if(player.hasPermission("pantsCommand")){
                if (freshPantsCD.containsKey(String.valueOf(player.getUniqueId()))){
                    // player is inside mute map
                    if (freshPantsCD.get(String.valueOf(player.getUniqueId())) > System.currentTimeMillis()){
                        // They still have time left on mute
                        long timeleft = (freshPantsCD.get(String.valueOf(player.getUniqueId())) - System.currentTimeMillis()) / 1000;
                        player.sendMessage(ChatColor.RED + "Please wait a little before doing that!");
                    }else{
                        player.getInventory().addItem(enchants.fresh_reds);
                        player.getInventory().addItem(enchants.fresh_sword);
                        player.getInventory().addItem(enchants.jewl_sword);
                        player.getInventory().addItem(enchants.jewl_pant);
                        freshPantsCD.put(String.valueOf(player.getUniqueId()), System.currentTimeMillis() + (15 * 1000));
                    }

                }else{
                    player.getInventory().addItem(enchants.fresh_reds);
                    player.getInventory().addItem(enchants.fresh_sword);
                    player.getInventory().addItem(enchants.jewl_sword);
                    player.getInventory().addItem(enchants.jewl_pant);
                    freshPantsCD.put(String.valueOf(player.getUniqueId()), System.currentTimeMillis() + (15 * 1000));
                }
                return true;
            }else{
                player.sendMessage(ChatColor.RED + "You don't have permission to use this!");
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("show")){
            if (ShowCD.containsKey(String.valueOf(player.getUniqueId()))){
                    // player is inside mute map
                if (ShowCD.get(String.valueOf(player.getUniqueId())) > System.currentTimeMillis()){
                        // They still have time left on mute
                    long timeleft = (ShowCD.get(String.valueOf(player.getUniqueId())) - System.currentTimeMillis()) / 1000;
                    player.sendMessage(ChatColor.RED + "Please wait a little before doing that!");
                }else{
                    try{
                        hoverText(ChatColor.translateAlternateColorCodes('&', "&a&lSHOWOFF! " +  rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " has: " + ChatColor.RED + "Mystic item"), compileListToString(player.getItemInHand().getItemMeta().getLore()));
                    }catch (Exception e){
                        player.sendMessage(ChatColor.RED + "Please hold a mystic item!");
                    }
                    ShowCD.put(String.valueOf(player.getUniqueId()), System.currentTimeMillis() + (30 * 1000));
                }

            }else{
                try{
                    hoverText(ChatColor.translateAlternateColorCodes('&', "&a&lSHOWOFF! " + rank.getNameColor(player) + player.getDisplayName() + ChatColor.GRAY + " has: " + ChatColor.RED + "Mystic item"), compileListToString(player.getItemInHand().getItemMeta().getLore()));
                }catch (Exception e){
                    player.sendMessage(ChatColor.RED + "Please hold a mystic item!");
                }

                ShowCD.put(String.valueOf(player.getUniqueId()), System.currentTimeMillis() + (30 * 1000));
            }
            return true;
        }


        if (cmd.getName().equalsIgnoreCase("balance")) {
            hasEconomy(String.valueOf(player.getUniqueId()));
            int balance = getEconomy(String.valueOf(player.getUniqueId()));
            player.sendMessage(ChatColor.AQUA + "§lBALANCE: " + ChatColor.RESET + ChatColor.GOLD + balance + " gold");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            //deleteHologramStreak(player);
            hasStreak(String.valueOf(player.getUniqueId()));

            if (cooldowns.containsKey(String.valueOf(player.getUniqueId()))){
                // player is inside mute map
                if (cooldowns.get(String.valueOf(player.getUniqueId())) > System.currentTimeMillis()){
                    // They still have time left on mute
                    long timeleft = (cooldowns.get(String.valueOf(player.getUniqueId())) - System.currentTimeMillis()) / 1000;
                    player.sendMessage(ChatColor.RED + "You are in combat for: " + ChatColor.GREEN + timeleft + ChatColor.RED + " seconds");
                    return true;
                }else{
                    player.removePotionEffect(PotionEffectType.WEAKNESS);
                    setStreak(String.valueOf(player.getUniqueId()), 0);
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                    Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                    mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                    true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                    xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                    Location loc = getSpawnLocation();
                    player.teleport(loc);
                    NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId()))+ rank.getNameColor(player), "");

                    boards.CreateScore(player);
                    return true;
                }

            }else{
                player.removePotionEffect(PotionEffectType.WEAKNESS);
                setStreak(String.valueOf(player.getUniqueId()), 0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId()))+ rank.getNameColor(player), "");
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Location loc = getSpawnLocation();
                player.teleport(loc);
                boards.CreateScore(player);
            }
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("oof")) {
            //deleteHologramStreak(player);
            player.removePotionEffect(PotionEffectType.WEAKNESS);
            ClearAndCheck(player);
            setStreak(String.valueOf(player.getUniqueId()), 0);
            xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
            Strength.put(String.valueOf(player.getUniqueId()), 0.0);
            mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
            true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
            xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
            Location loc = getSpawnLocation();
            player.teleport(loc);
            boards.CreateScore(player);
            NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId()))+ rank.getNameColor(player), "");
            return true;
        }

        else if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel((20));
            player.sendMessage(ChatColor.GOLD + "You were Fed!");
        }

        if (cmd.getName().equalsIgnoreCase("kit")){
            player.sendMessage(ChatColor.RED + "This is currently disabled!");
            //player.getInventory().addItem(itemManager.ChainBoots, itemManager.ChainChestplate, itemManager.IronLeggings, itemManager.IronSword);
        }
        return false;
    }}