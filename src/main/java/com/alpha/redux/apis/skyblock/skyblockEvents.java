package com.alpha.redux.apis.skyblock;

import com.alpha.redux.redux;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static com.alpha.redux.apis.skyblock.skyblockItems.termy;
import static com.alpha.redux.playerdata.prestiges.getPrestige;
import static com.alpha.redux.questMaster.questMenu.makeMainMenu;
import static com.alpha.redux.well.gui.*;

public class skyblockEvents implements Listener {

    @EventHandler
    public static void terminate(PlayerInteractEvent event){
        try{
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                if(event.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Terminator")){
                    if(event.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)){
                        Location PlayerLocation = event.getPlayer().getEyeLocation();
                        Location loc = PlayerLocation.add(PlayerLocation.getDirection().multiply(1.2));

                        Player shooter = event.getPlayer();

                        Arrow arrow = (Arrow) loc.getWorld().spawnEntity(loc, EntityType.ARROW);
                        arrow.setCritical(true);
                        arrow.setVelocity(shooter.getLocation().getDirection().multiply(2.90));
                        arrow.setShooter(shooter);

                        Arrow arrow1 = (Arrow) loc.add(-0.5, 0, 0).getWorld().spawnEntity(loc, EntityType.ARROW);
                        arrow1.setCritical(true);
                        arrow1.setVelocity(shooter.getLocation().getDirection().multiply(2.90));
                        arrow1.setShooter(shooter);

                        Arrow arrow2 = (Arrow) loc.add(1, 0, 0).getWorld().spawnEntity(loc, EntityType.ARROW);
                        arrow2.setCritical(true);
                        arrow2.setVelocity(shooter.getLocation().getDirection().multiply(2.90));
                        arrow2.setShooter(shooter);

                        arrow.setKnockbackStrength(10);
                        arrow.setCritical(true);
                        arrow1.setCritical(true);
                        arrow2.setCritical(true);

                        if(!event.getPlayer().getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.ARROW_INFINITE)){
                            event.getPlayer().getInventory().removeItem(new ItemStack(Material.ARROW));
                        }

                    }
                }
            }
        }catch (Exception e){

        }

    }

    @EventHandler
    public static void NpcShop(NPCRightClickEvent event){

        Player player = event.getClicker();

        if (event.getNPC().getId() == 2){
            NonPermanentItems(player);
        }else if (event.getNPC().getId() == 4){
            PrestigeMenu(player);
        }else if (event.getNPC().getId() == 3){
            megaStreak(player);
        }else if(event.getNPC().getId() == 1){
            if(getPrestige(String.valueOf(player.getUniqueId())) >= 15){
                player.openInventory(makeMainMenu(player));
            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bQuest Master&8 >> &7Hey you need at least prestige &eXV&7 to talk to me!"));
            }

            //Perks(player);
        }else if(event.getNPC().getName().contains("TheAlpha64")){
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Hey welcome to Better Pit!");
            player.sendMessage(ChatColor.GRAY + "Do /kit to get the starter kit!");
            player.sendMessage(ChatColor.GRAY + "Also check out the store at: " + ChatColor.AQUA + "https://betterpit-store.tebex.io/");
            player.sendMessage(ChatColor.AQUA + "Join the discord at: " + ChatColor.DARK_AQUA + "https://discord.gg/eZkkNxVR");
            //Perks(player);
        }else if(event.getNPC().getName().contains("Tinykloon")){
            player.sendMessage(ChatColor.BLUE + "https://discord.gg/eZkkNxVR");
        }else if(event.getNPC().getName().contains("lkjv")){
            player.sendMessage(ChatColor.BLUE + "https://betterpit-store.tebex.io/");
        }
    }

}
