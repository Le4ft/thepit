package com.alpha.redux.apis;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class actionbarplus {
    public static void sendActionBar(Player player, String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" +
                ChatColor.translateAlternateColorCodes('&', message) + "\"}"), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    public static void sendHealthBar(EntityDamageByEntityEvent event){


        Player player = (Player) event.getDamager();
        Player defender = (Player) event.getEntity();
        String colorPlayer = PlayerNameColor(defender);
        StringBuilder health = new StringBuilder();
        health.append(" ");
        Double defenderHealth = (double) Math.round(defender.getHealth());
        int red_heart = (int) event.getFinalDamage();
        int dark_red_heart = (int) (defenderHealth - event.getFinalDamage())  / 2;
        int gray_heart = (int) (((defenderHealth - defender.getMaxHealth())) - dark_red_heart) / 2;
        if (gray_heart == 0){
            gray_heart = (int) Math.abs((int) defender.getMaxHealth() - defenderHealth);
        }
        for (int i = 0; i < Math.abs(dark_red_heart); i++) {
            health.append("&4❤");
        }

        for (int i = 0; i < Math.abs(red_heart); i++) {
            health.append("&c❤");
        }

        for (int i = 0; i < Math.abs(gray_heart); i++) {
            health.append("&0❤");
        }


        sendActionBar(player, colorPlayer + defender.getDisplayName() + health);
    }

    public static void sendKillBar(Player player, Player defender){
        String health = " &a&lKILL!";
        String colorPlayer = PlayerNameColor(defender);

        sendActionBar(player, colorPlayer + defender.getDisplayName() + health);
    }

    public static String PlayerNameColor(Player player){
        String namecolor;

        if (player.isOp()){
            namecolor = String.valueOf(ChatColor.RED);
        }else if(player.hasPermission("MVP")){
            namecolor = String.valueOf(ChatColor.AQUA);
        }else if(player.hasPermission("VIP")){
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("YOUTUBE")){
            namecolor = String.valueOf(ChatColor.RED);
        }else if(player.hasPermission("MVP+")){
            namecolor = String.valueOf(ChatColor.AQUA);
        }else if(player.hasPermission("VIP+")){
            namecolor = String.valueOf(ChatColor.GREEN);
        }else if(player.hasPermission("HELPER")){
            namecolor = String.valueOf(ChatColor.BLUE);
        }else if(player.hasPermission("MOD")){
            namecolor = String.valueOf(ChatColor.GREEN);
        }else{
            namecolor = String.valueOf(ChatColor.GRAY);
        }

        return namecolor;
    }
}
