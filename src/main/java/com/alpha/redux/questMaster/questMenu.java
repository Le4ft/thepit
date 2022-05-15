package com.alpha.redux.questMaster;

import com.alpha.redux.apis.advancedInventory;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class questMenu {
    public static Inventory makeMainMenu(Player player){
        Inventory gui = advancedInventory.inv(player, 27, ChatColor.YELLOW + "Quest Master");

        // Get String uuid of player in
        String uuid = String.valueOf(player.getUniqueId());

        // Place holder glass
        ItemStack base_glass = advancedInventory.cGlass();

        // Custom Items
        ItemStack claimRewards = questMenuItems.claimRewards(uuid);
        ItemStack KillPlayersQuest = questMenuItems.KillPlayersQuest(uuid);
        ItemStack FindCakeQuest = questMenuItems.FindCakeQuest(uuid);
        ItemStack BringVileQuest = questMenuItems.BringVileQuest(uuid);
        ItemStack BringCoinsQuest = questMenuItems.BringCoinsQuest(uuid);
        ItemStack BringFreshQuest = questMenuItems.BringFreshQuest(uuid);

        for (int i = 0; i < 10; i++) {
            advancedInventory.addInv(gui, base_glass, i, 1, false);
            advancedInventory.addInv(gui, base_glass, i, 2, false);
            advancedInventory.addInv(gui, base_glass, i, 3, false);
        }

        advancedInventory.addInv(gui, claimRewards, 9, 3, false);

        advancedInventory.addInv(gui, BringFreshQuest, 3, 2, false);
        advancedInventory.addInv(gui, BringVileQuest, 4, 2, false);
        advancedInventory.addInv(gui, KillPlayersQuest, 5, 2, false);
        advancedInventory.addInv(gui, FindCakeQuest, 6, 2, false);
        advancedInventory.addInv(gui, BringCoinsQuest, 7, 2, false);

        return gui;
    }
}
