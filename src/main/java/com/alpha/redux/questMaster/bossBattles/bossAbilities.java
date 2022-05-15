package com.alpha.redux.questMaster.bossBattles;

import net.citizensnpcs.api.npc.NPC;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class bossAbilities {

    private static int tp_amount = 0;

    public static void abilityMain(Player player, NPC npc){
        Player PlayerBoss = (Player) npc.getEntity();
        player.playSound(player.getLocation(), Sound.EXPLODE, 1F, 1F);

        double X = player.getLocation().getX();
        double Y = player.getLocation().getY();
        double Z = player.getLocation().getZ();

        Bukkit.getWorld("world").createExplosion(X, Y, Z, 0, false, false);

    }

    public static void abilityNormal(Player player, NPC npc){
        Player PlayerBoss = (Player) npc.getEntity();

        if (PlayerBoss.getHealth() <= 10 && tp_amount <= 10){
            tp_amount++;
            if(player.isOnGround()){
                if(player.getLocation().add(0,2,0).getBlock().getType().equals(Material.AIR)){
                    player.teleport(player.getLocation().add(0, 2, 0));
                }

                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 4, true, true));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 4, true, true));
                player.playSound(player.getLocation(), Sound.ENDERMAN_HIT, 1F, 1F);

                PacketPlayOutWorldParticles animationPacket = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float) player.getLocation().getX(), (float) player.getEyeLocation().getY() + 2, (float) player.getLocation().getZ(), 255, 255, 255, (float) 1, 0);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(animationPacket);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(animationPacket);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(animationPacket);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(animationPacket);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(animationPacket);
            }

        }
    }
}
