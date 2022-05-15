package com.alpha.redux.renownShop;

import com.alpha.redux.apis.TebexMoners.tebexmoners;
import com.alpha.redux.items.enchants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static com.alpha.redux.apis.advancedInventory.ItemMaker;
import static com.alpha.redux.events.boards.integerToRoman;
import static com.alpha.redux.playerdata.prestiges.getPrestige;
import static com.alpha.redux.renownShop.damageIncrease.addIncrease;
import static com.alpha.redux.renownShop.damageIncrease.hasIncrease;
import static com.alpha.redux.renownShop.shopGUI.mainMenu;
import static com.alpha.redux.renownShop.xpIncrease.*;

public class RenownStorage {


    public static void BuyDamageIncrease(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.REDSTONE)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 5)){
                    if(hasIncrease(uuid)){
                            for (int i = 0; i < 5; i++) {
                                player.getInventory().removeItem(token);
                            }

                            player.sendMessage(ChatColor.GREEN + "Damage increase purchased! " + ChatColor.RED + "+5% damage!");


                            addIncrease(uuid, 5);
                            player.openInventory(mainMenu(player));
                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
    }

    public static void BuyPrestigeFive(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.REDSTONE)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 5)){
                    if(hasIncrease(uuid)){
                        if(getXpIncrease(uuid) <= 495){
                            for (int i = 0; i < 5; i++) {
                                player.getInventory().removeItem(token);
                            }


                            player.sendMessage(ChatColor.GREEN + "Damage increase purchased! " + ChatColor.RED + "+5% damage!");


                            addIncrease(uuid, 5);
                            player.openInventory(mainMenu(player));
                        }


                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
    }

    public static boolean BuyXpIncrease(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.EXP_BOTTLE)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 32)){
                    if(hasXpIncrease(uuid)){
                        for (int i = 0; i < 32; i++) {
                            player.getInventory().removeItem(token);
                        }

                        hasXpIncrease(uuid);
                        setXpIncrease(uuid, Math.min(5 + getXpIncrease(uuid), 500));

                        player.sendMessage(ChatColor.GREEN + "Factory purchased! " + ChatColor.DARK_GRAY + "Tier: " + ChatColor.GOLD + integerToRoman(getXpIncrease(uuid) / 5));

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static boolean BuyCorruptedPearl(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.EYE_OF_ENDER)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token,  64)){
                    if(hasXpIncrease(uuid)){
                        for (int i = 0; i < 64; i++) {
                            player.getInventory().removeItem(token);
                        }

                        player.getInventory().addItem(getCorruptedPearl());

                        player.sendMessage(ChatColor.GREEN + "Purchased!");

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static boolean BuyUberDrop(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.ENDER_CHEST)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token,  16)){
                    if(hasXpIncrease(uuid)){
                        for (int i = 0; i < 16; i++) {
                            player.getInventory().removeItem(token);
                        }

                        player.getInventory().addItem(getUberDrop());

                        player.sendMessage(ChatColor.GREEN + "Purchased!");

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static boolean BuyColorFulBoxers(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.LEATHER_LEGGINGS)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 5)){
                    if(hasXpIncrease(uuid)){
                        for (int i = 0; i < 5; i++) {
                            player.getInventory().removeItem(token);
                        }

                        tebexmoners.PlayerColorfulBoxers(player);

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static boolean BuyScythe(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().equals(RenownItems.ReaperScythe())){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 192)){
                    if(getPrestige(uuid) >= 15){
                        for (int i = 0; i < 192; i++) {
                            player.getInventory().removeItem(token);
                        }

                        player.getInventory().addItem(enchants.reaper_scythe);

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static boolean BuyAtom(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().equals(RenownItems.NuclearAtomizer())){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 640)){
                    if(getPrestige(uuid) >= 30){
                        for (int i = 0; i < 640; i++) {
                            player.getInventory().removeItem(token);
                        }

                        player.getInventory().addItem(NuclearAtomizerItem());

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static void BuyMysticism(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().equals(RenownItems.MysticismDropItem(uuid))){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, (int) Math.round((MysticismChance.getMysticismChance(uuid) * 1000) * 32))){
                    if(MysticismChance.getMysticismChance(uuid) >= .015){player.sendMessage(ChatColor.RED + "You maxed this already!");return;}
                    if(getPrestige(uuid) >= 5){
                        for (int i = 0; i < (int) Math.round((MysticismChance.getMysticismChance(uuid) * 1000) * 64); i++) {
                            player.getInventory().removeItem(token);
                        }

                        MysticismChance.hasMysticismChance(uuid);
                        MysticismChance.addMysticismChance(uuid, .001);

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
    }

    public static boolean BuyThreeQuest(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.NETHER_STAR)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 640)){
                    if(hasXpIncrease(uuid)){
                        for (int i = 0; i < 640; i++) {
                            player.getInventory().removeItem(token);
                        }

                        player.getInventory().addItem(getStickQuest());
                        player.getInventory().addItem(getBlazeQuest());
                        player.getInventory().addItem(getGoldQuest());

                        player.openInventory(mainMenu(player));

                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static boolean BuyDamageDecrease(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String uuid = String.valueOf(player.getUniqueId());


        if (event.getClickedInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){
            if (event.getCurrentItem().getType().equals(Material.IRON_CHESTPLATE)){
                ItemStack token = getToken();
                if (player.getInventory().containsAtLeast(token, 20)){
                    if(damageDecrease.hasDecrease(uuid)){
                        if(damageDecrease.getDecrease(uuid) <= 50){
                            for (int i = 0; i < 20; i++) {
                                player.getInventory().removeItem(token);
                            }

                            player.sendMessage(ChatColor.GREEN + "Damage resistance purchased! " + ChatColor.RED + "+5% damage resistance!");

                            
                            damageDecrease.addDecrease(uuid, 5);
                            player.openInventory(mainMenu(player));
                        }else{
                            player.sendMessage(ChatColor.RED + "You already have the max tier!");
                        }


                    }else{
                        player.sendMessage(ChatColor.RED + "You can't afford this!");
                    }
                }
            }

        }
        return false;
    }

    public static ItemStack getToken(){
        return ItemMaker(Material.TRIPWIRE_HOOK, ChatColor.YELLOW + "Renown Tokens",
                ChatColor.GRAY + "Used to buy upgrades from\n" +  ChatColor.GRAY + "the renown shop!\n\n" +
                        ChatColor.RED + "Gained on prestige!", 1, true);
    }

    public static ItemStack getCorruptedPearl(){
        return ItemMaker(Material.EYE_OF_ENDER, ChatColor.YELLOW + "Corrupted Pearl",
                ChatColor.GRAY + "Using a corrupted pearl will teleport a\n" + ChatColor.GRAY +
                        "random player to you and strike them with" + ChatColor.DARK_PURPLE + " venom!" + "\n\n" +
                        ChatColor.RED + "5 second cool down!", 1, true);
    }

    public static ItemStack getUberDrop(){
        return ItemMaker(Material.ENDER_CHEST, ChatColor.LIGHT_PURPLE + "Uberdrop",
                ChatColor.GRAY + "Kept on death\n" + ChatColor.GRAY + "Contains: " + ChatColor.LIGHT_PURPLE + "§kUberdrop!\n\n" +
                        ChatColor.YELLOW + "Hold and click to open!", 1, true);
    }

    public static ItemStack getStickQuest(){
        return ItemMaker(Material.STICK, ChatColor.DARK_AQUA + "Normal Stick",
                ChatColor.GRAY + "Kept on death\n\n" + ChatColor.GRAY +
                        "Magically allows you to pick up\n" + ChatColor.LIGHT_PURPLE +
                        "cakes " + ChatColor.GRAY + "granting a chance\n" + ChatColor.GRAY +
                        "for " + ChatColor.YELLOW + "Renown Tokens " + ChatColor.GRAY +
                        "to\n" + ChatColor.GRAY + "randomly drop!\n\n" +
                ChatColor.GRAY + ChatColor.ITALIC + "Quest Item", 1, true);
    }

    public static ItemStack getBlazeQuest(){
        return ItemMaker(Material.BLAZE_ROD, ChatColor.RED + "Flaming Rod",
                ChatColor.GRAY + "Kept on death\n\n" + ChatColor.GRAY +
                        "Grants +75% chance to get vile from kills\n" +
                        ChatColor.GRAY + "Allows you to fly around\n" + ChatColor.GRAY +
                        "the map in a " + ChatColor.RED + "blaze" + ChatColor.GRAY + ",\n" + ChatColor.GRAY + "while outside of combat\n\n" +
                        ChatColor.GRAY + ChatColor.ITALIC + "Quest Item", 1, true);
    }

    public static ItemStack NuclearAtomizerItem(){
        return ItemMaker(Material.FIREWORK_CHARGE, ChatColor.LIGHT_PURPLE + "Nuclear Atomizer",
                ChatColor.GRAY + "Atomizes renown tokens to\n" + ChatColor.GRAY + "produce temporary stat\n" +
                        ChatColor.GRAY + "boosts. Stat boosts will\n" + ChatColor.GRAY + "randomly decay and\n" +
                        ChatColor.GRAY + "return to ashes.\n" + ChatColor.RED + "Right click to open", 1, true);
    }

    public static ItemStack getGoldQuest(){
        return ItemMaker(Material.GOLD_NUGGET, ChatColor.GOLD + "Technical Enhancement",
                ChatColor.GRAY + "Kept on death\n\n" + ChatColor.GRAY +
                        "Provides you with the technology\n" + ChatColor.GRAY +
                        "needed to receive double\n" + ChatColor.GRAY + "gold from kills but \n" + ChatColor.GRAY +
                        "you're heavily slowed down!\n\n" +
                        ChatColor.GRAY + ChatColor.ITALIC + "Quest Item", 1, true);
    }

}
