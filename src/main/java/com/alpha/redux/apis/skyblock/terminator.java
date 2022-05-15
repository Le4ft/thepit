package com.alpha.redux.apis.skyblock;

import net.minecraft.server.v1_8_R3.EntityArrow;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class terminator {
    public static void Terminator(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Vector playerDirection1 = player.getLocation().add(0, 0, 0).getDirection();
        Vector playerDirection2 = player.getLocation().add(-0.5, 0, 0).getDirection();
        Vector playerDirection3 = player.getLocation().add(0.5, 0, 0).getDirection();
        EntityArrow arrow = ((CraftArrow) player.launchProjectile(Arrow.class, playerDirection1)).getHandle();
        arrow.setCritical(true);
        EntityArrow arrow2 = ((CraftArrow) player.launchProjectile(Arrow.class, playerDirection2)).getHandle();

        arrow2.fromPlayer = 0;
        arrow2.setCritical(true);
        EntityArrow arrow3 = ((CraftArrow) player.launchProjectile(Arrow.class, playerDirection3)).getHandle();
        arrow3.fromPlayer = 0;
        arrow3.setCritical(true);
    }
}
