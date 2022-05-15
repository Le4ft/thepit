package com.alpha.redux.questMaster.bossBattles;

import com.alpha.redux.DeathHandler.ReduxDeathEvent;
import com.alpha.redux.items.enchants;
import com.alpha.redux.renownShop.RenownStorage;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


import java.util.Objects;
import java.util.Random;

import static com.alpha.redux.DeathHandler.killHandler.getNPC;
import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.MaldingPlayerHandlers;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.maldingName;

public class bossEvents implements Listener {

    @EventHandler
    public static void MaldingAttackEvent(bossAttackEvent event){
        NPC boss = event.getBoss();
        Player PlayerBoss = (Player) boss.getEntity();
        Player player = event.getPlayer();

        Random rand = new Random(); //instance of random class
        int upperbound = 5;
        int int_random = rand.nextInt(upperbound);

        switch (int_random){
            case 1:
                bossAbilities.abilityMain(player, boss);
            default:
                bossAbilities.abilityNormal(player, boss);
        }

    }

    @EventHandler
    public static void MaldingDeath(ReduxDeathEvent event){

        if(isNPC(event.getDefender().getPlayerObject()) && Objects.requireNonNull(getNPC(event.getDefender().getPlayerObject())).getName().contains(maldingName)){
            if(MaldingPlayerHandlers.containsKey(event.getAttacker().getPlayerObject())){
                double r = new Random().nextDouble();
                if (r < 0.001) {
                    Bukkit.getWorld("world").dropItem(event.getAttacker().getPlayerObject().getLocation(), enchants.malding_chestplate);
                    event.getAttacker().getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found some &cMalding Chestplate&7!"));
                }
                else if (r < 0.02) {
                    Bukkit.getWorld("world").dropItem(event.getAttacker().getPlayerObject().getLocation(), enchants.malding_boots);
                    event.getAttacker().getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found some &cMalding Boots&7!"));
                }
                else if (r < 0.034) {
                    Bukkit.getWorld("world").dropItem(event.getAttacker().getPlayerObject().getLocation(), enchants.malding_pants);
                    event.getAttacker().getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found some &cMalding Pants&7!"));
                }
                else if (r < 0.75) {
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getUberDrop());
                    event.getAttacker().getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found some &dUberdrops&7!"));
                }
                else {
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().getInventory().addItem(RenownStorage.getToken());
                    event.getAttacker().getPlayerObject().playSound(event.getAttacker().getPlayerObject().getLocation(), Sound.ANVIL_LAND, 1, 1);
                    event.getAttacker().getPlayerObject().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWOW! &7you found some &eRenown Tokens&7!"));
                }


                if(isNPC(event.getDefender().getPlayerObject())){
                    NPC npc = getNPC(event.getDefender().getPlayerObject());
                    assert npc != null;
                    npc.destroy();
                    npc.despawn();
                    MaldingPlayerHandlers.remove(event.getAttacker().getPlayerObject());
                    CitizensAPI.getNPCRegistry().deregister(npc);
                    event.getAttacker().getPlayerObject().sendMessage(ChatColor.RED + "You killed Malding!");
                }
            }


        }else if(isNPC(event.getAttacker().getPlayerObject()) && Objects.requireNonNull(getNPC(event.getAttacker().getPlayerObject())).getName().contains(maldingName)){
            if(MaldingPlayerHandlers.containsKey(event.getDefender().getPlayerObject())){
                BossMalding boss = MaldingPlayerHandlers.get(event.getDefender().getPlayerObject());
                NPC npc = boss.boss;
                Player player = boss.target;

                if(npc.isSpawned()){
                    npc.destroy();
                    npc.despawn();
                    MaldingPlayerHandlers.remove(player);
                    CitizensAPI.getNPCRegistry().deregister(npc);
                    player.sendMessage(ChatColor.RED + "You failed to kill Malding!");
                }
            }
        }
    }
}
