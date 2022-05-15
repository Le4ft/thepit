package com.alpha.redux;

import com.alpha.redux.apis.PitTrade.tradeCommand;
import com.alpha.redux.apis.PitTrade.tradeEvent;
import com.alpha.redux.apis.Sounds;
import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.apis.hunter.HunterEntity;
import com.alpha.redux.apis.skyblock.skyblockEvents;
import com.alpha.redux.apis.skyblock.skyblockItems;
import com.alpha.redux.commands.command;
import com.alpha.redux.entityHandlers.ReduxPlayerHandler;
import com.alpha.redux.eventManagers.ReduxEvents;
import com.alpha.redux.funEvents.barUtil;
import com.alpha.redux.playerdata.economy;
import com.alpha.redux.events.events;
import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.items.enchants;
import com.alpha.redux.questMaster.bossBattles.BossMalding;
import com.alpha.redux.questMaster.bossBattles.bossEvents;
import com.alpha.redux.renownShop.atomizer.InventoryEventManager;
import com.nametagedit.plugin.NametagEdit;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.logging.Level;

import static com.alpha.redux.DeathHandler.killHandler.getNPC;
import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApiGetLevelColor;
import static com.alpha.redux.apis.leaderboardsplus.leaderboards.*;
import static com.alpha.redux.apis.locations.getCakeLocation;
import static com.alpha.redux.events.boards.CreateScore;
import static com.alpha.redux.funEvents.event.handleTwoEvent;
import static com.alpha.redux.funEvents.event.twoTimesEvent;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.MaldingPlayerHandlers;
import static com.alpha.redux.questMaster.bossBattles.maldingBoss.gearNearby;

public class redux extends JavaPlugin {

    @Override
    public void onEnable() {
        new prestiges(this);
        new economy(this);
        new xpManager(this);
        command commands = new command();
        skyblockItems.initializeItemstack();
        itemManager.init();
        enchants.init();
        getServer().getPluginManager().registerEvents(new events(),this);
        getServer().getPluginManager().registerEvents(new bossEvents(), this);
        getServer().getPluginManager().registerEvents(new ReduxEvents(), this);
        getServer().getPluginManager().registerEvents(new skyblockEvents(), this);
        getServer().getPluginManager().registerEvents(new ReduxPlayerHandler(), this);
        getServer().getPluginManager().registerEvents(new InventoryEventManager(), this);
        getCommand("enchantPant").setExecutor(commands);
        getCommand("activateBooster").setExecutor(commands);
        getCommand("purchaseDyes").setExecutor(commands);
        getCommand("show").setExecutor(commands);
        getCommand("repairs").setExecutor(commands);
        getCommand("hub").setExecutor(commands);
        getCommand("veloCheck").setExecutor(commands);
        getCommand("play").setExecutor(commands);
        getCommand("oof").setExecutor(commands);
        getCommand("mkBoard").setExecutor(commands);
        getCommand("makeMonersRankers").setExecutor(commands);
        getCommand("rBoard").setExecutor(commands);
        getCommand("spawn").setExecutor(commands);
        getCommand("spawn").setExecutor(commands);
        getCommand("all").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("shop").setExecutor(commands);
        getCommand("kit").setExecutor(commands);
        getCommand("streak").setExecutor(commands);
        getCommand("balance").setExecutor(commands);
        getCommand("KillMessageToggle").setExecutor(commands);
        getCommand("prestige").setExecutor(commands);
        getCommand("prestiges").setExecutor(commands);
        getCommand("mega").setExecutor(commands);
        getCommand("gold").setExecutor(commands);
        getCommand("checkPants").setExecutor(commands);
        getCommand("well").setExecutor(commands);
        getCommand("getXp").setExecutor(commands);
        getCommand("pants").setExecutor(commands);
        getCommand("malding").setExecutor(commands);
        SLAPI.loadPrestige();

        //SLAPI.loadGold();
        SLAPI.loadXp();
        xpManager.XpLevelCalculation();
        SLAPI.loadXPInc();
        SLAPI.loadDmgInc();
        SLAPI.loadDmgDec();
        SLAPI.loadMystic();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Redux] plugin is enabled");


        redux plugin = this;

        new BukkitRunnable() {

            @Override
            public void run() {


                if(twoTimesEvent >= 3){
                    for (Player player : Bukkit.getOnlinePlayers()){
                        if(!isNPC(player)){
                            Sounds.BOOSTER_REMIND.play(player.getLocation(), 1);
                        }
                    }

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lBOOSTER! &7There is currently an active &e&l3x &7booster!"));

                }

            }
        }.runTaskTimer(plugin, 3600, 3600);

        new BukkitRunnable() {

            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()){
                    if(!isNPC(player)){
                        if(player.getInventory().getBoots() != null){
                            if(player.getInventory().getBoots().equals(enchants.malding_boots)){
                                PacketPlayOutWorldParticles animationPacket = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float) player.getLocation().getX(), (float) player.getLocation().getY(), (float) player.getLocation().getZ(), 255, 255, 255, (float) 1, 0);
                                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(animationPacket);
                                for (Player players : gearNearby(player, 5, 5, 5)){
                                    ((CraftPlayer) players).getHandle().playerConnection.sendPacket(animationPacket);
                                }
                            }
                        }
                    }
                }

            }
        }.runTaskTimer(plugin, 1, 1);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {


                RefreshBoard();
                handleTwoEvent();
                Bukkit.broadcastMessage(ChatColor.RED + "Refreshing leader boards!");

            }
        }, 0L, 12000L); //0 Tick initial delay, 20 Tick (1 Second) between repeats

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (World w : Bukkit.getWorlds()) {
                    for (Entity e : w.getEntities()) {
                        if (e instanceof Arrow) {
                            e.remove();
                        }
                    }

            }

            for (Player player : Bukkit.getOnlinePlayers()){
                CreateScore(player);
            }
        }}, 0L,  200L); //0 Tick initial delay, 20 Tick (1 Second) between repeats

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()){
                    NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId()))+ rank.getNameColor(player), "");
                }
            }
        }, 50L);

        getCakeLocation().getBlock().setType(Material.CAKE_BLOCK);

    }

    @Override
    public void onDisable() {
        for (Player player : MaldingPlayerHandlers.keySet()){

            NPC npc = MaldingPlayerHandlers.get(player).getBoss();
            assert npc != null;
            npc.destroy();
            npc.despawn();
            MaldingPlayerHandlers.remove(player);
            CitizensAPI.getNPCRegistry().deregister(npc);

        }
        getCakeLocation().getBlock().setType(Material.AIR);
        SLAPI.savePrestige();
        SLAPI.saveXp();
        delBoard();
        SLAPI.saveDmgInc();
        SLAPI.saveXPInc();
        SLAPI.saveDmgDec();
        SLAPI.saveMystic();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Redux] plugin is disabled");

    }

    public static Vector getVelocity(double x, double z) {
        double y = 0.533; // this way, like normal knockback, it hits a player a little bit up
        double multiplier = Math.sqrt((0.25 * 0.25) / ((x*x)  + y + (z*z))); // get a constant that, when multiplied by the vector, results in the speed we want
        return new Vector(x, y, z).multiply(multiplier).setY(y);
    }

}
