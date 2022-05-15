package com.alpha.redux.well;

import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static com.alpha.redux.well.enchanters.GoldBoost;

public class pantEnchantLores {

    List<String> lore = new ArrayList<>();

    public pantEnchantLores(String enchant) {
        switch (enchant){
            case "goldheartIII":
                

                lore.add("§9Golden Heart III");
                lore.add("§7Gain §6+2❤§7 absorption on kill");
                lore.add("§7(max §6❤§7)");
                break;
            case "goldheartII":
                

                lore.add("§9Golden Heart II");
                lore.add("§7Gain §6+1❤§7 absorption on kill");
                lore.add("§7(max §6❤§7)");
                break;
            case "goldheartI":
                
                lore.add("§9Golden Heart");
                lore.add("§7Gain §6+0.5❤§7 absorption on kill");
                lore.add("§7(max §6❤§7)");
                break;
            case "gbIII":
                
                lore.add("§9Gold Boost III");
                lore.add("§7Earn §6+45% gold (g)§7 from kill");
                break;
            case "gbII":
                
                lore.add("§9Gold Boost II");
                lore.add("§7Earn §6+30% gold (g)§7 from kill");
                break;
            case "gbI":
                
                lore.add("§9Gold Boost");
                lore.add("§7Earn §6+15% gold (g)§7 from kill");
                break;
            case "moctIII":
                
                lore.add("§9Moctezuma III");
                lore.add("§7Earn §6+18g§7 on kill (assists");
                lore.add("§7excluded)");
                break;
            case "moctII":
                
                lore.add("§9Moctezuma II");
                lore.add("§7Earn §6+12g§7 on kill (assists");
                lore.add("§7excluded)");
                break;
            case "moctI":
                
                lore.add("§9Moctezuma");
                lore.add("§7Earn §6+7g§7 on kill (assists");
                lore.add("§7excluded)");
                break;
            case "critIII":
                
                lore.add("§9Critically Funky III");
                lore.add("§7Critical hits against you deal");
                lore.add("§950% §7of the damage they");
                lore.add("§7normally would and empower your");
                lore.add("§7next strike for §c+30%§7 damage");
                break;
            case "critII":
                
                lore.add("§9Critically Funky II");
                lore.add("§7Critical hits against you deal");
                lore.add("§965% §7of the damage they");
                lore.add("§7normally would and empower your");
                lore.add("§7next strike for §c+14%§7 damage");
                break;
            case "critI":
                
                lore.add("§9Critically Funky");
                lore.add("§7Critical hits against you deal");
                lore.add("§980% §7of the damage they");
                lore.add("§7normally would");
                break;
            case "goldBumpIII":
                
                lore.add("§9Gold Bump III");
                lore.add("§7Earn §6+12g§7 on kill");
                break;
            case "goldBumpII":
                
                lore.add("§9Gold Bump II");
                lore.add("§7Earn §6+8g§7 on kill");
                break;
            case "goldBumpI":
                
                lore.add("§9Gold Bump");
                lore.add("§7Earn §6+4g§7 on kill");
                break;
            case "protIII":
                
                lore.add("§9Protection III");
                lore.add("§7Receive §9-10%§7 damage");
                break;
            case "protII":
                
                lore.add("§9Protection II");
                lore.add("§7Receive §9-6%§7 damage");
                break;
            case "protI":
                
                lore.add("§9Protection");
                lore.add("§7Receive §9-4%§7 damage");
                break;
            case "peroxideIII":
                
                lore.add("§9Peroxide III");
                lore.add("§7Gain §cRegen II §7(8s) when hit");
                break;
            case "peroxideII":
                
                lore.add("§9Peroxide II");
                lore.add("§7Gain §cRegen I §7(8s) when hit");
                break;
            case "peroxideI":
                
                lore.add("§9Peroxide");
                lore.add("§7Gain §cRegen I §7(5s) when hit");
                break;
            case "sweatyIII":
                
                lore.add("§9Sweaty III");
                lore.add("§7Earn §b+60% XP§7 from streak XP");
                lore.add("§7bonus and §b+100 max XP§7 per kill");
                break;
            case "sweatyII":
                
                lore.add("§9Sweaty II");
                lore.add("§7Earn §b+40% XP§7 from streak XP");
                lore.add("§7bonus and §b+50 max XP§7 per kill");
                break;
            case "sweatyI":
                
                lore.add("§9Sweaty");
                lore.add("§b+20% §7XP§7 from streak XP bonus");
                break;
            case "xpIII":
                
                lore.add("§9XP Boost III");
                lore.add("§7Earn §b+30% XP§7 from kills");
                break;
            case "xpII":
                
                lore.add("§9XP Boost II");
                lore.add("§7Earn §b+20% XP§7 from kills");
                break;
            case "xpI":
                
                lore.add("§9XP Boost");
                lore.add("§7Earn §b+10% XP§7 from kills");
                break;
            case "mirrorIII":
                
                lore.add("§9Mirror III");
                lore.add("§7You are immune to true damage");
                break;
            case "mirrorII":
                
                lore.add("§9Mirror II");
                lore.add("§7You receive §e50%§7 less true damage!");
                break;
            case "mirrorI":
                
                lore.add("§9Mirror");
                lore.add("§7You receive §e25%§7 less true damage!");
                break;
            case "escapeIII":
                
                lore.add("§dRARE! §9Escape Pod III");
                lore.add("§7When hit below §c2 §7, launch");
                lore.add("§7into the air dealing §c3 §7damage");
                lore.add("§7to nearby enemies and gaining");
                lore.add("§aRegen IV§7 (30s), Can launch");
                lore.add("§7once per life.");
                break;
            case "escapeII":
                
                lore.add("§dRARE! §9Escape Pod II");
                lore.add("§7When hit below §c2 §7, launch");
                lore.add("§7into the air dealing §c3 §7damage");
                lore.add("§7to nearby enemies and gaining");
                lore.add("§aRegen III§7 (30s), Can launch");
                lore.add("§7once per life.");
                break;
            case "escapeI":
                
                lore.add("§dRARE! §9Escape Pod");
                lore.add("§7When hit below §c2 §7, launch");
                lore.add("§7into the air dealing §c3 §7damage");
                lore.add("§7to nearby enemies and gaining");
                lore.add("§aRegen III§7 (15s), Can launch");
                lore.add("§7once per life.");
                break;
            case "rgmIII":
                
                lore.add("§dRARE! §9Retro-Gravity Microcosm III");
                lore.add("§7When a player hits you from");
                lore.add("§7above ground §e3 times§7 in a row:");
                lore.add("§7You heal §c1.2❤");
                lore.add("§7Gain §c+1.5❤§f §cdamage §fvs them for §e30s");
                lore.add("§7They take §c1❤ §ftrue damage");
                break;
            case "rgmII":
                
                lore.add("§dRARE! §9Retro-Gravity Microcosm II");
                lore.add("§7When a player hits you from");
                lore.add("§7above ground §e3 times §fin a row:");
                lore.add("§7You heal §c1.5❤");
                lore.add("§7They take §c.5❤ §ftrue damage");
                break;
            case "rgmI":
                
                lore.add("§dRARE! §9Retro-Gravity Microcosm");
                lore.add("§7When a player hits you from");
                lore.add("§7above ground §e3 times §fin a row:");
                lore.add("§7You heal §c1❤");
                lore.add("§7They take §c1❤ §ftrue damage");
                break;
            case "regIII":
                
                lore.add("§dRARE! §9Regularity III");
                lore.add("§7If the final damage of your strike");
                lore.add("§7deals less than §c1.5❤§7 §7damage,");
                lore.add("§7strike again in §a0.1s §7for §c75%");
                lore.add("§7damage");
                break;
            case "regII":
                
                lore.add("§dRARE! §9Regularity II");
                lore.add("§7If the final damage of your strike");
                lore.add("§7deals less than §c1.5❤§7 §7damage,");
                lore.add("§7strike again in §a0.1s §7for §c75%");
                lore.add("§7damage");
                break;
            case "regI":
                
                lore.add("§dRARE! §9Regularity");
                lore.add("§7If the final damage of your strike");
                lore.add("§7deals less than §c1.5❤§7 §7damage,");
                lore.add("§7strike again in §a0.1s §7for §c75%");
                lore.add("§7damage");
                break;
            case "soliIII":

                lore.add("§dRARE! §9Solitude III");
                lore.add("§7Receive §9-60% §7damage when two");
                lore.add("§7or less players are within 7");
                lore.add("§7blocks.");
                break;
            case "soliII":
                
                lore.add("§dRARE! §9Solitude II");
                lore.add("§7Receive §9-50% §7damage when two");
                lore.add("§7or less players are within 7");
                lore.add("§7blocks.");
                break;
            case "soliI":
                
                lore.add("§dRARE! §9Solitude");
                lore.add("§7Receive §9-40% §7damage when two");
                lore.add("§7or less players are within 7");
                lore.add("§7blocks.");
                break;
            case "swimmerIII":
                
                lore.add("§9McSwimmer III");
                lore.add("§7Receive §9-60% melee damage");
                lore.add("§7while swimming in water or lava");
                break;
            case "swimmerII":

                lore.add("§9McSwimmer III");
                lore.add("§7Receive §9-40% melee damage");
                lore.add("§7while swimming in water or lava");
                break;
            case "swimmerI":

                lore.add("§9McSwimmer III");
                lore.add("§7Receive §9-20% melee damage");
                lore.add("§7while swimming in water or lava");
                break;
            case "xpbIII":
                
                lore.add("§9XP Bump III");
                lore.add("§7Earn §b+6 XP §7per");
                lore.add("§7kill");
                break;
            case "xpbII":
                
                lore.add("§9XP Bump II");
                lore.add("§7Earn §b+4 XP §7per");
                lore.add("§7kill");
                break;
            case "xpbI":
                
                lore.add("§9XP Bump");
                lore.add("§7Earn §b+2 XP §7per");
                lore.add("§7kill");
                break;
            case "gladIII":
                
                lore.add("§9\"Not\" Gladiator III");
                lore.add("§7Receive §9-2% damage per nearby");
                lore.add("§7player (max 10 players)");
                break;
            case "gladII":
                
                lore.add("§9\"Not\" Gladiator II");
                lore.add("§7Receive §9-1.5% damage per nearby");
                lore.add("§7player (max 10 players)");
                break;
            case "gladI":
                
                lore.add("§9\"Not\" Gladiator");
                lore.add("§7Receive §9-1% damage per nearby");
                lore.add("§7player (max 10 players)");
                break;
            case "jewel":
                
                lore.add("§9Hidden Jewel");
                lore.add("§7Kill §c120§7 players to recycle");
                lore.add("§7into Tier I pants with a Tier III");
                lore.add("§7enchant.");
                break;


            case "fracIII":
                lore.add("§9Fractional Reserve III");
                lore.add("§7Recieve §9-1% damage§7 per");
                lore.add("§650,000g §7you have (§9-30%");
                lore.add("§7max)");
                break;
            case "fracII":
                lore.add("§9Fractional Reserve II");
                lore.add("§7Recieve §9-1% damage§7 per");
                lore.add("§650,000g §7you have (§9-21%");
                lore.add("§7max)");
                break;
            case "fracI":
                lore.add("§9Fractional Reserve");
                lore.add("§7Recieve §9-1% damage§7 per");
                lore.add("§650,000g §7you have (§9-15%");
                lore.add("§7max)");
                break;

        }

    }


    public List<String> getLore(){
        return this.lore;
    }

}
