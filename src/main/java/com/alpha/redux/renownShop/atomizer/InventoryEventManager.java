package com.alpha.redux.renownShop.atomizer;

import com.alpha.redux.apis.Sounds;
import com.alpha.redux.entityHandlers.ReduxPlayer;
import com.alpha.redux.items.enchants;
import com.alpha.redux.items.itemManager;
import com.alpha.redux.playerdata.economy;
import com.alpha.redux.renownShop.RenownStorage;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static com.alpha.redux.entityHandlers.ReduxPlayerHandler.playerExists;
import static com.alpha.redux.renownShop.RenownStorage.getToken;
import static com.alpha.redux.renownShop.atomizer.Atomizer.inventoryConstructor;

public class InventoryEventManager implements Listener {

    @EventHandler
    public static void openMenuClick(PlayerInteractEvent event){
        if(event.getPlayer().getInventory().getItemInHand() == null) return;
        if(event.getPlayer().getInventory().getItemInHand().getItemMeta() == null) return;
        if(event.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName() != null & Objects.equals(event.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE + "Nuclear Atomizer")) {
            if(playerExists(event.getPlayer()).getPlayerPrestige() >= 30) event.getPlayer().openInventory(inventoryConstructor(event.getPlayer()));
            else event.getPlayer().sendMessage(ChatColor.RED + "You aren't high enough prestige to use this!");
        }
    }

    @EventHandler
    public static void main(InventoryClickEvent event){
        if(!event.getClickedInventory().getTitle().equals(ChatColor.LIGHT_PURPLE + "Nuclear Atomizer")) return;
        ItemStack token = getToken();
        Player player = (Player) event.getWhoClicked();
        ReduxPlayer reduxPlayer = playerExists(player);
        boolean emptyInv = false;

        for(ItemStack is : player.getInventory().getContents())
            if (is == null) {
                emptyInv = true;
                break;
            }

        if(!emptyInv){
            player.sendMessage(ChatColor.RED + "Come back when you have a free inventory slot!");
            player.closeInventory();
            return;
        }


        if(event.getCurrentItem().equals(Atomizer.totallyLegitGem)){
            if (player.getInventory().containsAtLeast(token, 576) && reduxPlayer.getPlayerGold() >= 32000000){
                for (int i = 0; i < 576; i++) {
                    player.getInventory().removeItem(token);
                }

                reduxPlayer.setPlayerGold((int) (reduxPlayer.getPlayerGold() - 32000000));

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                Sounds.PRESTIGE.play(player);
                player.getInventory().addItem(enchants.gem);

            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.heistOne)){
            if (player.getInventory().containsAtLeast(token, 576) && reduxPlayer.getPlayerGold() >= 32000000){
                for (int i = 0; i < 576; i++) {
                    player.getInventory().removeItem(token);
                }

                reduxPlayer.setPlayerGold((int) (reduxPlayer.getPlayerGold() - 32000000));

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                Sounds.PRESTIGE.play(player);
                player.getInventory().addItem(itemManager.heistMasterI);

            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.heistTwo)){
            if (player.getInventory().containsAtLeast(token, 1152) && reduxPlayer.getPlayerGold() >= 64000000){
                for (int i = 0; i < 1152; i++) {
                    player.getInventory().removeItem(token);
                }

                reduxPlayer.setPlayerGold((int) (reduxPlayer.getPlayerGold() - 64000000));

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                Sounds.PRESTIGE.play(player);
                player.getInventory().addItem(itemManager.heistMasterII);

            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.heistThree)){
            if (player.getInventory().containsAtLeast(token, 1728) && reduxPlayer.getPlayerGold() >= 96000000){
                for (int i = 0; i < 1728; i++) {
                    player.getInventory().removeItem(token);
                }

                reduxPlayer.setPlayerGold((int) (reduxPlayer.getPlayerGold() - 96000000));

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                Sounds.PRESTIGE.play(player);
                player.getInventory().addItem(itemManager.heistMasterIII);

            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.xpBoost)){
            if (player.getInventory().containsAtLeast(token, 192)){

                if(reduxPlayer.getPlayerXpBooster() >= 2){
                    player.sendMessage(ChatColor.RED + "You have this buff active already!");
                    player.closeInventory();
                    return;
                }

                for (int i = 0; i < 192; i++) {
                    player.getInventory().removeItem(token);
                }

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                reduxPlayer.setPlayerXpBooster(2);
                Sounds.PRESTIGE.play(player);

                Bukkit.getScheduler().scheduleSyncDelayedTask(economy.getPlugin(), new Runnable() {
                    @Override
                    public void run() {

                        reduxPlayer.setPlayerXpBooster(1);
                        player.sendMessage(ChatColor.GRAY + "Your Experience Atom decayed and the effects have worn off!");

                    }
                }, 18000L);


            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.goldBoost)){
            if (player.getInventory().containsAtLeast(token, 128)){

                if(reduxPlayer.getPlayerGoldBooster() >= 2){
                    player.sendMessage(ChatColor.RED + "You have this buff active already!");
                    player.closeInventory();
                    return;
                }

                for (int i = 0; i < 128; i++) {
                    player.getInventory().removeItem(token);
                }

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                reduxPlayer.setPlayerGoldBooster(2);
                Sounds.PRESTIGE.play(player);

                Bukkit.getScheduler().scheduleSyncDelayedTask(economy.getPlugin(), new Runnable() {
                    @Override
                    public void run() {

                        reduxPlayer.setPlayerGoldBooster(1);
                        player.sendMessage(ChatColor.GRAY + "Your Gold Atom decayed and the effects have worn off!");

                    }
                }, 12000L);


            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.armageddon)){
            if (player.getInventory().containsAtLeast(token, 256) && reduxPlayer.getPlayerGold() >= 15000000){
                for (int i = 0; i < 256; i++) {
                    player.getInventory().removeItem(token);
                }

                reduxPlayer.setPlayerGold((int) (reduxPlayer.getPlayerGold() - 15000000));

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                Sounds.PRESTIGE.play(player);
                player.getInventory().addItem(itemManager.arma);

            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }else if(event.getCurrentItem().equals(Atomizer.venoms)){
            if (player.getInventory().containsAtLeast(token, 256) && reduxPlayer.getPlayerGold() >= 10000000){
                for (int i = 0; i < 256; i++) {
                    player.getInventory().removeItem(token);
                }

                reduxPlayer.setPlayerGold((int) (reduxPlayer.getPlayerGold() - 10000000));

                player.sendMessage(ChatColor.GREEN + "Purchased successfully!");
                Sounds.PRESTIGE.play(player);
                player.getInventory().addItem(itemManager.venom);

            }else{
                player.sendMessage(ChatColor.RED + "You can't afford this!");
                player.closeInventory();
            }
        }

        reduxPlayer.refreshScoreBoard();
        event.setCancelled(true);
    }


}
