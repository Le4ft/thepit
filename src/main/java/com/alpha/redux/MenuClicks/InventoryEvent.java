package com.alpha.redux.MenuClicks;

import com.alpha.redux.apis.chatManager.rank;
import com.alpha.redux.events.boards;
import com.alpha.redux.playerdata.prestiges;
import com.alpha.redux.playerdata.xpManager;
import com.alpha.redux.items.itemManager;
import com.nametagedit.plugin.NametagEdit;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.BufferedReader;

import static com.alpha.redux.apis.HeadNames.headnames.changeName;
import static com.alpha.redux.apis.advancedInventory.addInv;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApi;
import static com.alpha.redux.apis.chatManager.rank.ChatEventApiGetLevelColor;
import static com.alpha.redux.events.boards.integerToRoman;
import static com.alpha.redux.events.events.Strength;
import static com.alpha.redux.playerdata.economy.*;
import static com.alpha.redux.apis.advancedInventory.ItemMaker;
import static com.alpha.redux.events.events.Has_Strength;
import static com.alpha.redux.playerdata.prestiges.*;
import static com.alpha.redux.playerdata.prestiges.getPrestige;
import static com.alpha.redux.playerdata.streaks.*;
import static com.alpha.redux.playerdata.xpManager.*;
import static com.alpha.redux.renownShop.renownAmount.GetByPrestige;
import static com.alpha.redux.renownShop.renownEvent.mainEvent;
import static com.alpha.redux.renownShop.shopGUI.mainMenu;
import static com.alpha.redux.well.gui.*;
import static com.alpha.redux.well.mysticWell.*;

public class InventoryEvent {

    public static void main(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());
        if (event.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "Mystic Well")){
            if (event.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE) {
                event.setCancelled(true);
                ItemStack items = event.getClickedInventory().getItem(20);
                hasEconomy(uuid);
                event.setCancelled(true);
                if (items.getType().equals(Material.LEATHER_LEGGINGS)) {
                    event.setCancelled(true);
                    if (items.getItemMeta().getDisplayName().contains("Tier III")){
                        return;
                    } else if (items.getItemMeta().getDisplayName().contains("Tier II")) {
                        if (getEconomy(uuid) >= 8000){
                            removeEconomy(uuid, 8000);
                            boards.CreateScore(player);
                            event.getClickedInventory().setItem(20, createDropII(event.getClickedInventory().getItem(20), player));
                        } else {
                            player.sendMessage(ChatColor.RED + "You can't afford this!");
                            player.sendMessage(ChatColor.GRAY + "Reminder: You need 8000 gold to enchant this item!");
                        }
                    }else if (items.getItemMeta().getDisplayName().contains("Tier I")) {
                        if (getEconomy(uuid) >= 4000) {
                            removeEconomy(uuid, 4000);
                            boards.CreateScore(player);
                            event.getClickedInventory().setItem(20, createDropI(event.getClickedInventory().getItem(20), player));
                        } else {
                            player.sendMessage(ChatColor.RED + "You can't afford this!");
                            player.sendMessage(ChatColor.GRAY + "Reminder: You need 4000 gold to enchant this item!");
                        }
                    } else if (items.getItemMeta().getDisplayName().contains("Fresh")) {
                        if (getEconomy(uuid) >= 1000){
                            removeEconomy(uuid, 1000);
                            boards.CreateScore(player);
                            event.getClickedInventory().setItem(20, createDrop(player));
                        }else{
                            player.sendMessage(ChatColor.RED + "You can't afford this!");
                            player.sendMessage(ChatColor.GRAY + "Reminder: You need 1000 gold to enchant this item!");
                        }
                    }
                    }

                if (items.getType().equals(Material.GOLD_SWORD)) {
                    event.setCancelled(true);
                    if (items.getItemMeta().getDisplayName().contains("Tier III")){
                        return;
                    } else if (items.getItemMeta().getDisplayName().contains("Tier II")) {
                        if (getEconomy(uuid) >= 8000){
                            removeEconomy(uuid, 8000);
                            boards.CreateScore(player);
                            event.getClickedInventory().setItem(20, createSwordII(event.getClickedInventory().getItem(20), player));
                        } else {
                            player.sendMessage(ChatColor.RED + "You can't afford this!");
                            player.sendMessage(ChatColor.GRAY + "Reminder: You need 8000 gold to enchant this item!");
                        }
                    }else if (items.getItemMeta().getDisplayName().contains("Tier I")) {
                        if (getEconomy(uuid) >= 4000) {
                            removeEconomy(uuid, 4000);
                            boards.CreateScore(player);
                            event.getClickedInventory().setItem(20, createSwordI(event.getClickedInventory().getItem(20), player));
                        } else {
                            player.sendMessage(ChatColor.RED + "You can't afford this!");
                            player.sendMessage(ChatColor.GRAY + "Reminder: You need 4000 gold to enchant this item!");
                        }
                    } else if (items.getItemMeta().getDisplayName().contains("Mystic Sword")) {
                        if (getEconomy(uuid) >= 1000){
                            removeEconomy(uuid, 1000);
                            boards.CreateScore(player);
                            event.getClickedInventory().setItem(20, createSword(player));
                        }else{
                            player.sendMessage(ChatColor.RED + "You can't afford this!");
                            player.sendMessage(ChatColor.GRAY + "Reminder: You need 1000 gold to enchant this item!");
                        }

                    }

                }
                }else if (event.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "Mystic Well")){
                    if (event.getCurrentItem().getType().equals(Material.LEATHER_LEGGINGS)) {
                        player.getInventory().addItem(event.getClickedInventory().getItem(20));
                        event.getClickedInventory().setItem(20, null);
                    }else if (event.getCurrentItem().getType().equals(Material.GOLD_SWORD)) {
                        player.getInventory().addItem(event.getClickedInventory().getItem(20));
                        event.getClickedInventory().setItem(20, null);
                    }else if (event.getCurrentItem().getType() == Material.AIR){
                        event.setCancelled(true);
                    }else if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE){
                        event.setCancelled(true);
                    }else{
                        event.setCancelled(true);
                    }
                }else {
                    event.setCancelled(true);
                }

            }
        if (event.getClickedInventory().getTitle().equalsIgnoreCase(player.getInventory().getTitle())){
            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Fresh")){
                Inventory gui = enchanting(player);

                addInv(gui, event.getCurrentItem(), 3, 3, false);

                player.getInventory().removeItem(event.getCurrentItem());
                event.setCancelled(true);

            }else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Mystic Sword")){
                Inventory gui = enchanting(player);

                addInv(gui, event.getCurrentItem(), 3, 3, false);

                player.getInventory().removeItem(event.getCurrentItem());
                event.setCancelled(true);

            }else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Tier I")){
                enchanting_tierI(player, event.getCurrentItem());
                player.getInventory().removeItem(event.getCurrentItem());
                event.setCancelled(true);
            }else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Tier II")){
                enchanting_tierI(player, event.getClickedInventory().getItem(21));
                player.getInventory().removeItem(event.getCurrentItem());
                event.setCancelled(true);
            }
            }

        }
        /*else {
            hasFresh(uuid);
            if (event.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "Mystic Well")){
                if (event.getCurrentItem().getItemMeta().equals(enchants.fresh_reds.getItemMeta())){
                    base(player);
                    player.getInventory().addItem(enchants.fresh_reds);
                    setFresh(uuid, false);
                    event.setCancelled(true);
                }
            }

        }*/


    public static void NonPermItems(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());

        switch (event.getCurrentItem().getType()) {
            case DIAMOND_SWORD:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 150) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 150);
                        player.getInventory().addItem(ItemMaker(Material.DIAMOND_SWORD, "NULL", "NULL", 1, false));

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);

                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

            }
            case DIAMOND_SPADE:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 750) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 750);
                        player.getInventory().addItem(ItemMaker(Material.DIAMOND_SPADE, ChatColor.AQUA + "Combat Spade", ChatColor.GRAY + "Deals " + ChatColor.BLUE +
                                "+1 damage per\n" + ChatColor.AQUA + "diamond piece " + ChatColor.GRAY + "on enemy." + "\n\n"  +
                                ChatColor.BLUE + "+7 Attack Damage", 1, false));

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);

                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

                }
            case IRON_HELMET:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 200) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 200);
                        player.getInventory().addItem(itemManager.IronHelmet, itemManager.IronChestplate, itemManager.IronLeggings, itemManager.IronBoots);}

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);

                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

            case DIAMOND_CHESTPLATE:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 500) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 500);
                        player.getInventory().addItem(ItemMaker(Material.DIAMOND_CHESTPLATE, "NULL", "NULL", 1, false));

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);

                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

                }
            case DIAMOND_LEGGINGS:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 1500) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 1500);
                        player.getInventory().addItem(ItemMaker(Material.DIAMOND_LEGGINGS, "NULL", "NULL", 1, false));

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);

                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

                }
            case OBSIDIAN:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 10000) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 10000);
                        player.getInventory().addItem(ItemMaker(Material.OBSIDIAN, "NULL", "NULL", 8, false));

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);

                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

                }
            case DIAMOND_BOOTS:
                if (hasEconomy(String.valueOf(player.getUniqueId()))) {
                    if (getEconomy(String.valueOf(player.getUniqueId())) >= 300) {
                        removeEconomy(String.valueOf(player.getUniqueId()), 300);
                        player.getInventory().addItem(ItemMaker(Material.DIAMOND_BOOTS, "NULL", "NULL", 1, false));

                        player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 20);
                        boards.CreateScore(player);

                    } else {
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                    event.setCancelled(true);
                    break;

                }
        }
    }

    public static void PrestigeItems(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getType() == Material.DIAMOND) {
            event.setCancelled(true);
            int[] randomDUDE;
            randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);

            if (randomDUDE[1] >= 120) {
                if (getPrestige(String.valueOf(player.getUniqueId())) >= 100) {
                    setPrestige(String.valueOf(player.getUniqueId()), 100);
                    player.sendMessage(ChatColor.RED + "You've reached the max Prestige! Congrats!");
                    return;
                }
                setMega(String.valueOf(player.getUniqueId()), "beastmode");
                setStreak(String.valueOf(player.getUniqueId()), 0);
                hasEconomy(String.valueOf(player.getUniqueId()));
                setEconomy(String.valueOf(player.getUniqueId()), 0);
                hasPrestige(String.valueOf(player.getUniqueId()));
                setXp(String.valueOf(player.getUniqueId()), 0);
                ItemStack Renown_Tokens = ItemMaker(Material.TRIPWIRE_HOOK, ChatColor.YELLOW + "Renown Tokens",
                        ChatColor.GRAY + "Used to buy upgrades from\n" +  ChatColor.GRAY + "the renown shop!\n\n" +
                                ChatColor.RED + "Gained on prestige!", 1, true);
                GiveUberItems(player, Renown_Tokens, GetByPrestige(getPrestige(String.valueOf(player.getUniqueId()))), true, null);
                player.setExp(0);
                player.setLevel(0);
                NametagEdit.getApi().setNametag(player, ChatEventApiGetLevelColor(player.getDisplayName(), String.valueOf(player.getUniqueId()))+ rank.getNameColor(player), "");
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                Strength.put(String.valueOf(player.getUniqueId()), 0.0);
                mega_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                true_damage_amount.put(String.valueOf(player.getUniqueId()), 0.0);
                xp_amount_mega.put(String.valueOf(player.getUniqueId()), 0);
                addPrestige(String.valueOf(player.getUniqueId()), 1);
                addXp(String.valueOf(player.getUniqueId()), (int) (15 + (15* PrestigeXpAmount(getPrestige(String.valueOf(player.getUniqueId()))))));
                addXp(String.valueOf(player.getUniqueId()), (int) (15 + (15* PrestigeXpAmount(getPrestige(String.valueOf(player.getUniqueId()))))));
                addXp(String.valueOf(player.getUniqueId()), 1);
                randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);
                Bukkit.broadcastMessage(ChatColor.YELLOW + "§lPRESTIGE! " + ChatColor.GOLD + player.getDisplayName() + ChatColor.GRAY + " unlocked prestige " + ChatColor.YELLOW + getPrestige(String.valueOf(player.getUniqueId())) + ChatColor.GRAY + " gg!");
                boards.CreateScore(player);
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 0);
                PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,
                        IChatBaseComponent.ChatSerializer.a("{\"text\":\"PRESTIGE!\",\"bold\":true,\"color\":\"yellow\"}"), 100, 20, 20);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
                PacketPlayOutTitle sub_title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("[\"\",{\"text\":\"\",\"color\":\"gray\"},{\"text\":\"" + "You unlocked prestige" + "\",\"color\":\"gray\"},{\"text\":\"\",\"color\":\"gray\"},{\"text\":\" \",\"color\":\"gray\"},{\"text\":\"\",\"color\":\"yellow\"},{\"text\":\"" + integerToRoman(getPrestige(String.valueOf(player.getUniqueId()))) + "\",\"color\":\"gray\"},{\"text\":\"\",\"color\":\"gray\"}]"), 100, 20, 20);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(sub_title);
            } else {
                player.sendMessage(ChatColor.RED + "You need Level 120 to prestige!");
            }
        }else if (event.getCurrentItem().getType() == Material.BEACON){
            player.openInventory(mainMenu(player));
            event.setCancelled(true);
        }
        event.setCancelled(true);

    }

    public static void PerkItems(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());
        hasPrestige(String.valueOf(player.getUniqueId()));
        int[] randomDUDE = GetCurrentLevel(String.valueOf(player.getUniqueId()), xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())), player);
        switch (event.getCurrentItem().getType()) {
            case FERMENTED_SPIDER_EYE:
                player.sendMessage(ChatColor.GREEN + "You already have this selected you dummy!");
                event.setCancelled(true);
                break;
            case REDSTONE:
                event.setCancelled(true);
                if (!(randomDUDE[1] >= 10)){player.sendMessage(ChatColor.RED + "You aren't high enough level to select this!");return;}
                if (Has_Strength.containsKey(String.valueOf(player.getUniqueId()))){
                    player.sendMessage(ChatColor.RED + "Strength is already selected!");
                    event.setCancelled(true);
                    break;
                }else{
                    Has_Strength.put(String.valueOf(player.getUniqueId()), true);
                    player.sendMessage(ChatColor.RED + "Strength Chaining selected!");
                }

                break;
            case IRON_CHESTPLATE:
                if (!(prestiges.getPrestige(String.valueOf(player.getUniqueId())) >= 3)){player.sendMessage(ChatColor.RED + "You aren't high enough prestige to use select this!");return;}
                if (randomDUDE[1] >= 50){
                    player.sendMessage("Tank Selected!");
                }
                event.setCancelled(true);
                break;
              /*
            case WHEAT:
                int[] randomDUDE = GetCurrentLevel(xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())));
                if (randomDUDE[1] >= 10){
                    player.sendMessage("Strength Chaning Selected!");
                }
                event.setCancelled(true);
                break;
            case SLIME_BALL:
                int[] randomDUDE = GetCurrentLevel(xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())));
                if (randomDUDE[1] >= 10){
                    player.sendMessage("Strength Chaning Selected!");
                }
                event.setCancelled(true);
                break;
            case DIRT:
                int[] randomDUDE = GetCurrentLevel(xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())));
                if (randomDUDE[1] >= 10){
                    player.sendMessage("Strength Chaning Selected!");
                }
                event.setCancelled(true);
                break;
            case BONE:
                int[] randomDUDE = GetCurrentLevel(xpManager.getXp(String.valueOf(player.getUniqueId())), prestiges.getPrestige(String.valueOf(player.getUniqueId())));
                if (randomDUDE[1] >= 10){
                    player.sendMessage("Strength Chaning Selected!");
                }
                event.setCancelled(true);
                break;
                */

            default:
                event.setCancelled(true);
        }

    }

}
