package com.alpha.redux.renownShop;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryClickEvent;

import static com.alpha.redux.renownShop.RenownStorage.*;

public class renownEvent {
    public static void mainEvent(InventoryClickEvent event){
        if (event.getWhoClicked().getOpenInventory().getTitle().equals(ChatColor.YELLOW + "Renown Shop")){

            event.setCancelled(true);

            BuyDamageIncrease(event);
            BuyXpIncrease(event);
            BuyCorruptedPearl(event);
            BuyDamageDecrease(event);
            BuyColorFulBoxers(event);
            BuyUberDrop(event);
            BuyThreeQuest(event);
            BuyScythe(event);
            BuyMysticism(event);
            BuyAtom(event);

            return;
        }else{
            return;
        }

    }
}
