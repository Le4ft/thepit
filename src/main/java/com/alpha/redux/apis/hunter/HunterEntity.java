package com.alpha.redux.apis.hunter;

import com.alpha.redux.apis.chatManager.rank;
import com.nametagedit.plugin.NametagEdit;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static com.alpha.redux.DeathHandler.ProccessHit.KillMan;
import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static com.alpha.redux.ItemEvents.pants.*;
import static com.alpha.redux.ItemEvents.pants.Mirrors;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApiGetLevelColor;
import static com.alpha.redux.playerdata.streaks.mega_damage_amount;
import static com.alpha.redux.playerdata.streaks.true_damage_amount;

public class HunterEntity {

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

    public static void HunterDamageEvent(Player player, Player npc){
        double damage = 1;
        double true_dmg = 0;

        try {
            if(mega_damage_amount.containsKey(String.valueOf(player.getUniqueId()))){
                damage += Math.round(mega_damage_amount.get(String.valueOf(player.getUniqueId())));
            }
        }catch (Exception e){

        }

        try {
            if(true_damage_amount.containsKey(String.valueOf(player.getUniqueId()))){
                true_dmg += Math.round(true_damage_amount.get(String.valueOf(player.getUniqueId())));
            }
        }catch (Exception e){

        }

        try {
            if(player.getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS)){
                try {
                    damage -= damage * .2;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    // -= CriticallyFunkyEvent(player, player, damage, player.getInventory().getLeggings().getItemMeta().getLore());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    damage -= NotGlad(player, damage, player.getInventory().getLeggings().getItemMeta().getLore());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try{
                    damage -= ProtectionEvent(player, damage, player.getInventory().getLeggings().getItemMeta().getLore());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    true_dmg -= true_dmg * Mirrors(player, true_dmg, player.getInventory().getLeggings().getItemMeta().getLore());
                }catch (Exception e){

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (player.getHealth() - (2 + true_dmg) >= -2 && player.getHealth() - (2 + true_dmg) <= 1.5) {
            try{
                player.setHealth(20);
                player.setMaxHealth(20);
                try{
                    KillMan(npc, player);
                } catch (Exception e) {

                }

                NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId()))+ rank.getNameColor(player), "");

                PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,
                        IChatBaseComponent.ChatSerializer.a("{\"text\":\"YOU DIED\",\"color\":\"red\"}"),100,20,20);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
                return;
            } catch (Exception e) {

            }
        }else{
            try{
                if (player instanceof Damageable) {
                    ((Damageable) player).damage(damage);
                }

                player.setHealth(Math.max(player.getHealth() - true_dmg, 0));
            }catch (Exception e){}
        }

    }

}
