package com.alpha.redux.DeathHandler;

import org.bukkit.entity.Player;

import java.util.HashMap;

import static com.alpha.redux.jewls.pantJewl.generateJewlPants;
import static com.alpha.redux.jewls.swordJewl.generateJewelSword;
import static com.alpha.redux.well.enchanters.Jewel;

public class jewls {
    public static HashMap<String, Integer> jewl_pant_counter = new HashMap<>();
    public static HashMap<String, Integer> jewl_sword_counter = new HashMap<>();

    public static void PlayerFinishedJewl(Player player){
        try {
            if(Jewel(player.getInventory().getLeggings().getItemMeta().getLore())){

                if(!jewl_pant_counter.containsKey(String.valueOf(player.getUniqueId()))){
                    jewl_pant_counter.put(String.valueOf(player.getUniqueId()), 1);
                }else{
                    jewl_pant_counter.put(String.valueOf(player.getUniqueId()), jewl_pant_counter.get(String.valueOf(player.getUniqueId())) + 1);
                }

                if(jewl_pant_counter.get(String.valueOf(player.getUniqueId())) >= 120){
                    player.getInventory().setLeggings(generateJewlPants(player));
                    jewl_pant_counter.put(String.valueOf(player.getUniqueId()), 0);
                }

            }
        } catch (Exception e) {

        }

        try {
            if(Jewel(player.getInventory().getItemInHand().getItemMeta().getLore())){

                if(!jewl_sword_counter.containsKey(String.valueOf(player.getUniqueId()))){
                    jewl_sword_counter.put(String.valueOf(player.getUniqueId()), 1);
                }else{
                    jewl_sword_counter.put(String.valueOf(player.getUniqueId()), jewl_sword_counter.get(String.valueOf(player.getUniqueId())) + 1);
                }

                if(jewl_sword_counter.get(String.valueOf(player.getUniqueId())) >= 120){
                    player.getInventory().setItemInHand(generateJewelSword(player));
                    jewl_sword_counter.put(String.valueOf(player.getUniqueId()), 0);
                }

            }
        } catch (Exception e) {

        }
    }
}