package com.alpha.redux.well;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class swordEnchantLores {
    List<String> lore = new ArrayList<>();

    public swordEnchantLores(String enchant) {
        switch (enchant) {
            case "gbIII":
                assert false;
                this.lore.add("§9Gold Boost III");
                this.lore.add("§7Earn §6+45% gold (g)§7 from kill");
                break;
            case "gbII":
                assert false;
                this.lore.add("§9Gold Boost II");
                this.lore.add("§7Earn §6+30% gold (g)§7 from kill");
                break;
            case "gbI":
                assert false;
                this.lore.add("§9Gold Boost");
                this.lore.add("§7Earn §6+15% gold (g)§7 from kill");
                break;
            case "moctIII":
                assert false;
                this.lore.add("§9Moctezuma III");
                this.lore.add("§7Earn §6+18g§7 on kill (assists");
                this.lore.add("§7excluded)");
                break;
            case "moctII":
                assert false;
                this.lore.add("§9Moctezuma II");
                this.lore.add("§7Earn §6+12g§7 on kill (assists");
                this.lore.add("§7excluded)");
                break;
            case "moctI":
                assert false;
                this.lore.add("§9Moctezuma");
                this.lore.add("§7Earn §6+7g§7 on kill (assists");
                this.lore.add("§7excluded)");
                break;
            case "goldBumpIII":
                assert false;
                this.lore.add("§9Gold Bump III");
                this.lore.add("§7Earn §6+12g§7 on kill");
                break;
            case "goldBumpII":
                assert false;
                this.lore.add("§9Gold Bump II");
                this.lore.add("§7Earn §6+8g§7 on kill");
                break;
            case "goldBumpI":
                assert false;
                this.lore.add("§9Gold Bump");
                this.lore.add("§7Earn §6+4g§7 on kill");
                break;
            case "sweatyIII":
                assert false;
                this.lore.add("§9Sweaty III");
                this.lore.add("§7Earn §b+60% XP§7 from streak XP");
                this.lore.add("§7bonus and §b+100 max XP§7 per kill");
                break;
            case "sweatyII":
                assert false;
                this.lore.add("§9Sweaty II");
                this.lore.add("§7Earn §b+40% XP§7 from streak XP");
                this.lore.add("§7bonus and §b+50 max XP§7 per kill");
                break;
            case "sweatyI":
                assert false;
                this.lore.add("§9Sweaty");
                this.lore.add("§b+20% §7XP§7 from streak XP bonus");
                break;
            case "xpIII":
                assert false;
                this.lore.add("§9XP Boost III");
                this.lore.add("§7Earn §b+30% XP§7 from kills");
                break;
            case "xpII":
                assert false;
                this.lore.add("§9XP Boost II");
                this.lore.add("§7Earn §b+20% XP§7 from kills");
                break;
            case "xpI":
                assert false;
                this.lore.add("§9XP Boost");
                this.lore.add("§7Earn §b+10% XP§7 from kills");
                break;
            case "xpbIII":
                assert false;
                this.lore.add("§9XP Bump III");
                this.lore.add("§7Earn §b+6 XP §7per");
                this.lore.add("§7kill");
                break;
            case "xpbII":
                assert false;
                this.lore.add("§9XP Bump II");
                this.lore.add("§7Earn §b+4 XP §7per");
                this.lore.add("§7kill");
                break;
            case "xpbI":
                assert false;
                this.lore.add("§9XP Bump");
                this.lore.add("§7Earn §b+2 XP §7per");
                this.lore.add("§7kill");
                break;
                // ^ All Resource Enchants
            case "exeIII":
                assert false;
                this.lore.add("§dRARE! §9Executioner III");
                this.lore.add("§7Hitting an enemy to below §c3.5❤");
                this.lore.add("§7instantly kills them");
                break;
            case "exeII":
                assert false;
                this.lore.add("§dRARE! §9Executioner II");
                this.lore.add("§7Hitting an enemy to below §c2.5❤");
                this.lore.add("§7instantly kills them");
                break;
            case "exeI":
                assert false;
                this.lore.add("§dRARE! §9Executioner");
                this.lore.add("§7Hitting an enemy to below §c1.5❤");
                this.lore.add("§7instantly kills them");
                break;
            case "billIII":
                assert false;
                this.lore.add("§dRARE! §9Billionaire III");
                this.lore.add("§7Hits with this swords deal §c2x");
                this.lore.add("§cdamage§7 but cost §6350g");
                break;
            case "billII":
                assert false;
                this.lore.add("§dRARE! §9Billionaire II");
                this.lore.add("§7Hits with this swords deal §c1.67x");
                this.lore.add("§cdamage§7 but cost §6200g");
                break;
            case "billI":
                assert false;
                this.lore.add("§dRARE! §9Billionaire");
                this.lore.add("§7Hits with this swords deal §c1.33x");
                this.lore.add("§cdamage§7 but cost §6100g");
                break;
            case "perunIII":
                assert false;
                this.lore.add("§dRARE! §9Combo: Perun's Wrath III");
                this.lore.add("§7Each §efourth§7 hit strikes");
                this.lore.add("§elightning§7 for §c1❤§7 + §c1❤");
                this.lore.add("§7per §bdiamond piece§7 on your");
                this.lore.add("§7victim.");
                this.lore.add("§7§oLightning deals true damage");
                break;
            case "perunII":
                assert false;
                this.lore.add("§dRARE! §9Combo: Perun's Wrath II");
                this.lore.add("§7Each §efourth§7 hit strikes");
                this.lore.add("§elightning§7 for §c2❤§7.");
                this.lore.add("§7§oLightning deals true damage");
                break;
            case "perunI":
                assert false;
                this.lore.add("§dRARE! §9Combo: Perun's Wrath");
                this.lore.add("§7Each §efifth§7 hit strikes");
                this.lore.add("§elightning§7 for §c1.5❤§7.");
                this.lore.add("§7§oLightning deals true damage");
                break;
            case "gambIII":
                assert false;
                this.lore.add("§dRARE! §9Gamble! III");
                this.lore.add("§d50% chance §7to deal §c3❤§7 true");
                this.lore.add("§7damage to whoever you hit, or to");
                this.lore.add("§7yourself");
                break;
            case "gambII":
                assert false;
                this.lore.add("§dRARE! §9Gamble! II");
                this.lore.add("§d50% chance §7to deal §c2❤§7 true");
                this.lore.add("§7damage to whoever you hit, or to");
                this.lore.add("§7yourself");
                break;
            case "gambI":
                assert false;
                this.lore.add("§dRARE! §9Gamble!");
                this.lore.add("§d50% chance §7to deal §c1❤§7 true");
                this.lore.add("§7damage to whoever you hit, or to");
                this.lore.add("§7yourself");
                break;
                // ^ All Rares
            case "sharpIII":
                assert false;
                this.lore.add("§9Sharp III");
                this.lore.add("§7Deal §c+12%§7 melee damage");
                break;
            case "sharpII":
                assert false;
                this.lore.add("§9Sharp II");
                this.lore.add("§7Deal §c+7%§7 melee damage");
                break;
            case "sharpI":
                assert false;
                this.lore.add("§9Sharp");
                this.lore.add("§7Deal §c+4%§7 melee damage");
                break;
            case "sharkIII":
                assert false;
                this.lore.add("§9Shark III");
                this.lore.add("§7Deal §c+7%§7 damager per other");
                this.lore.add("§7player below §c6❤§7 within 12");
                this.lore.add("§7blocks");
                break;
            case "sharkII":
                assert false;
                this.lore.add("§9Shark II");
                this.lore.add("§7Deal §c+4%§7 damager per other");
                this.lore.add("§7player below §c6❤§7 within 12");
                this.lore.add("§7blocks");
                break;
            case "sharkI":
                assert false;
                this.lore.add("§9Shark");
                this.lore.add("§7Deal §c+2%§7 damager per other");
                this.lore.add("§7player below §c6❤§7 within 12");
                this.lore.add("§7blocks");
                break;
            case "kingIII":
                assert false;
                this.lore.add("§9King Buster III");
                this.lore.add("§7Deal §c+20%§7 damage vs. players");
                this.lore.add("§7above 50% HP");
                break;
            case "kingII":
                assert false;
                this.lore.add("§9King Buster II");
                this.lore.add("§7Deal §c+13%§7 damage vs. players");
                this.lore.add("§7above 50% HP");
                break;
            case "kingI":
                assert false;
                this.lore.add("§9King Buster");
                this.lore.add("§7Deal §c+7%§7 damage vs. players");
                this.lore.add("§7above 50% HP");
                break;
            case "lsIII":
                assert false;
                this.lore.add("§9Lifesteal III");
                this.lore.add("§7Heal for §c13%§7 of damage dealt up");
                this.lore.add("§7to §c1.5❤");
                break;
            case "lsII":
                assert false;
                this.lore.add("§9Lifesteal II");
                this.lore.add("§7Heal for §c8%§7 of damage dealt up");
                this.lore.add("§7to §c1.5❤");
                break;
            case "lsI":
                assert false;
                this.lore.add("§9Lifesteal");
                this.lore.add("§7Heal for §c4%§7 of damage dealt up");
                this.lore.add("§7to §c1.5❤");
                break;
            // ^ Normal Enchants (Yes I know very little)


            case "pfIII":
                assert false;
                this.lore.add("§9Pain Focus III");
                this.lore.add("§7Deal §c+5%§7 damage per §c❤");
                this.lore.add("§7you're missing");
                break;
            case "pfII":
                assert false;
                this.lore.add("§9Pain Focus II");
                this.lore.add("§7Deal §c+2%§7 damage per §c❤");
                this.lore.add("§7you're missing");
                break;
            case "pfI":
                assert false;
                this.lore.add("§9Pain Focus");
                this.lore.add("§7Deal §c+1%§7 damage per §c❤");
                this.lore.add("§7you're missing");
                break;

            case "diamondIII":
                assert false;
                this.lore.add("§9Diamond Stomp III");
                this.lore.add("§7Deal §c+25%§7 damage vs. players");
                this.lore.add("§7wearing diamond armor");
                break;
            case "diamondII":
                assert false;
                this.lore.add("§9Diamond Stomp II");
                this.lore.add("§7Deal §c+12%§7 damage vs. players");
                this.lore.add("§7wearing diamond armor");
                break;
            case "diamondI":
                assert false;
                this.lore.add("§9Diamond Stomp");
                this.lore.add("§7Deal §c+6%§7 damage vs. players");
                this.lore.add("§7wearing diamond armor");
                break;

        }
    }

    public List<String> getLore() {
        return this.lore;
    }
}
