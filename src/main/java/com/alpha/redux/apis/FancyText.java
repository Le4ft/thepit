package com.alpha.redux.apis;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.bukkit.craftbukkit.v1_8_R3.*;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import java.awt.*;
import java.util.List;

import static com.alpha.redux.DeathHandler.killHandler.isNPC;
import static org.bukkit.Bukkit.spigot;


public class FancyText {

    public static void hoverText(String deliverText, String descText){

        TextComponent message = new TextComponent(deliverText);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(descText).create()));
        spigot().broadcast(message);

    }

    public static String compileListToString(List<String> list){

        StringBuilder stringy = new StringBuilder();

        stringy.append(ChatColor.RED + "Mystic Item\n");

        for (String s : list) {
            stringy.append(s);
            stringy.append("\n");
        }
        return stringy.toString();
    }

    public static String compileListToStringWithTitle(String title, List<String> list){

        StringBuilder stringy = new StringBuilder();

        stringy.append(title);

        for (String s : list) {
            stringy.append(s).append("\n");
        }
        return stringy.toString();
    }

/*
    LinkedHashMap<String, MessageComponent> message = new LinkedHashMap<String, MessageComponent>();


    public FancyText addText(String text){
        this.message.put(text, new MessageComponent(text, null, null));
        return this;
    }

    public FancyText addClickableLink(String text,String link){
        this.message.put(link, new MessageComponent(text, link, ChatClickable.EnumClickAction.OPEN_URL));
        return null;



    }

    public FancyText addRunnableCommand(String text, String command){

        this.message.put(text, new MessageComponent(text, command, ChatClickable.EnumClickAction.RUN_COMMAND));
        return this;
    }

    public FancyText addChatSuggestion(String text,String suggestion){

        this.message.put(text, new MessageComponent(text, suggestion, ChatClickable.EnumClickAction.SUGGEST_COMMAND));

        return this;
    }


    public FancyText addHoverEvent(String text, String hover){

        this.message.put(text, new MessageComponent(text, hover, ChatHoverable.EnumHoverAction.SHOW_TEXT));

        return this;
    }




    public void sendToPlayer(Player player){
        ChatComponentText master = new ChatComponentText("");
        for (String text: message.keySet()){
            for (IChatBaseComponent m: message.get(text).compile()) {
                master.a(m);
            }

        }
        CraftPlayer craftp = (CraftPlayer) player; //CraftBukkit
        craftp.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(master));
    }

    public void sendToAllPlayers(){
        for (Player player: Bukkit.getOnlinePlayers()){
            this.sendToPlayer(player);
        }
    }
    public static class MessageComponent {

        Enum<?> e;
        String data;
        String text;
        IChatBaseComponent[] chat;

        public MessageComponent(String text, String data, Enum<?> e){
            this.e = e;
            this.text = text;
            this.data = data;
            chat = CraftChatMessage.fromString(text);
        }





        public IChatBaseComponent[] compile(){
            for (IChatBaseComponent c: chat){
                if (data == null || e == null){

                    return chat;
                }
                if (e instanceof ChatClickable.EnumClickAction){
                    c.getChatModifier().setChatClickable(new ChatClickable((ChatClickable.EnumClickAction) e, data));
                }else if (e instanceof ChatHoverable.EnumHoverAction){
                    c.getChatModifier().a((new ChatHoverable((ChatHoverable.EnumHoverAction)e, new ChatComponentText(data))));
                    c.getChatModifier().a((new ChatHoverable((ChatHoverable.EnumHoverAction)e, new ChatComponentText(data))));
                }
            }

            return chat;
        }

    }


 */

}