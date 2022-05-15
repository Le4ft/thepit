package com.alpha.redux.ItemEvents;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class executioner {
    public static void playParticle(Player a, Player b){
        org.bukkit.Location loc = b.getLocation();
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true,
                (float) (loc.getX()), (float) (loc.getY()), (float) (loc.getZ()),(float) 0,(float) 0,(float) 0,(float) 0, 1);
        ((CraftPlayer)a).getHandle().playerConnection.sendPacket(packet);
    }
}
