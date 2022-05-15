package com.alpha.redux.apis;


import net.minecraft.server.v1_8_R3.EntityLightning;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityWeather;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;


public class strikeLight {
    public static void strikeLightningForPlayers(Location location, Player... players) {
        World world = ((CraftWorld) location.getWorld()).getHandle();

        for(Player player : players) {
            EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
            entityPlayer.playerConnection.sendPacket(new PacketPlayOutSpawnEntityWeather(
                    new EntityLightning(world, location.getX(), location.getY(), location.getZ(), false)));

            player.playSound(location, Sound.AMBIENCE_THUNDER, 10, 1);
            player.playSound(location, Sound.EXPLODE, 10, (float) (Math.random() * 0.2 + 0.6));
        }
    }
}
