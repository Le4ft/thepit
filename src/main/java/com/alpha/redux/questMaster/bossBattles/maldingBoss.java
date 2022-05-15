package com.alpha.redux.questMaster.bossBattles;

import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.entityHandlers.ReduxPlayer;
import com.alpha.redux.funEvents.event;
import com.alpha.redux.items.enchants;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.playerdata.economy;
import com.nametagedit.plugin.NametagEdit;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.trait.Equipment;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApiGetLevelColor;

public class maldingBoss {


    public static Map<Player, BossMalding> MaldingPlayerHandlers = new HashMap<Player, BossMalding>();
    public static String maldingName = ChatColor.GRAY + "[lvl 1]-" + ChatColor.RED + "Malding";

    public static boolean summonBoss(Player player){

        if(MaldingPlayerHandlers.containsKey(player)){
            player.sendMessage(ChatColor.RED + "You are already fighting a malding! Beat him first before coming back for another challenge!");
            return true;
        }else{

            Bukkit.getScheduler().scheduleSyncDelayedTask(economy.getPlugin(), new Runnable() {
                @Override
                public void run() {

                    NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, ChatColor.GRAY + "[lvl 1]-" + ChatColor.RED + "Malding");
                    citizensUtils.skin(npc, "BiggestPotato");

                    npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.BOOTS, enchants.malding_boots);
                    npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.LEGGINGS, enchants.malding_pants);
                    npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.CHESTPLATE, enchants.malding_chestplate);

                    npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.HAND, enchants.malding_sword);

                    npc.setBukkitEntityType(EntityType.PLAYER);

                    npc.spawn(player.getLocation());


                    npc.teleport(player.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);

                    npc.setProtected(false);

                    npc.getNavigator().getDefaultParameters()
                            .speedModifier(4);

                    BossMalding malding = new BossMalding(npc, player);
                    MaldingPlayerHandlers.put(player, malding);

                    long timeInTicks = 5L;

                    BukkitTask runnable = new BukkitRunnable() {

                        @Override
                        public void run() {

                            if(npc.isSpawned()){
                                npc.getNavigator().setTarget(player.getLocation());
                                npc.faceLocation(player.getLocation());

                                if (gearNearby(npc.getEntity(), 3.2, 3.2, 3.2).contains(player)) {
                                    if(player.isOnGround() || player.isFlying()){
                                        for (Player players : gearNearby(npc.getEntity(), 4, 4, 4)){
                                            PacketPlayOutAnimation animationPacket = new PacketPlayOutAnimation(((CraftEntity) npc.getEntity()).getHandle(), 0);
                                            ((CraftPlayer) players).getHandle().playerConnection.sendPacket(animationPacket);
                                        }

                                        player.damage(5, npc.getEntity()); // Use your event's data

                                        bossAttackEvent mainEvent = new bossAttackEvent(player, npc);
                                        Bukkit.getPluginManager().callEvent(mainEvent);
                                        if (!mainEvent.isCancelled()) {
                                            mainEvent.setCancelled(true);
                                        }
                                    }

                                }
                            }



                        }
                    }.runTaskTimer(economy.getPlugin(), timeInTicks, timeInTicks);


                    Bukkit.getScheduler().scheduleSyncDelayedTask(economy.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            runnable.cancel();
                            if(npc.isSpawned()){
                                npc.destroy();
                                npc.despawn();
                                MaldingPlayerHandlers.remove(player);
                                CitizensAPI.getNPCRegistry().deregister(npc);
                                player.sendMessage(ChatColor.RED + "You failed to kill Malding!");
                            }

                        }
                    }, 3600L);

                }
            }, 200L);



        }



        return false;
    }

    public static List<Player> gearNearby(Entity hunter, double x, double y, double z){

        List<Player> playerList = new ArrayList<Player>();

        for (org.bukkit.entity.Entity player : hunter.getNearbyEntities(x, y, z)){

            if (player instanceof Player){
                if(!isNPC((Player) player)){
                    playerList.add((Player) player);
                }

            }
        }

        return playerList;
    }
}
