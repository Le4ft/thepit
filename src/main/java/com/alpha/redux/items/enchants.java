package com.alpha.redux.items;

import com.alpha.redux.well.pantEnchantLores;
import com.alpha.redux.well.swordEnchantLores;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class enchants {
    public static ItemStack lores;
    public static ItemStack fresh_reds;
    public static ItemStack fresh_sword;
    public static ItemStack vile;
    public static ItemStack jewl_pant;
    public static ItemStack jewl_sword;
    public static ItemStack gem;
    public static ItemStack malding_pants;
    public static ItemStack malding_chestplate;
    public static ItemStack malding_boots;
    public static ItemStack malding_sword;
    public static ItemStack reaper_scythe;
    public static ItemStack playerSoul;

    public static void init(){
        createLores();
        createFreshReds();
        createFreshSword();
        createVile();
        createJewlPant();
        createJewlSword();
        createGem();
        createMaldingPants();
        createMaldingChestplate();
        createMaldingBoots();
        createMaldingSword();
        createReaperScythe();
        createPlayerSoul();
    }

    private static void createLores() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName("§cTier I Red Pants");
        List<String> lore = new ArrayList<>();


        lore.add("§9Critically Funky III");
        lore.add("§7Critical hits against you deal");
        lore.add("§950% §7of the damage they");
        lore.add("§7normally would and empower your");
        lore.add("§7next strike for §c+30%§7 damage");

        lore.add("§9Peroxide III");
        lore.add("§7Gain §cRegen II §7(8s) when hit");

        lore.add("§9Boo-boo III");
        lore.add("§7Passively regain §c1❤§7 every 4");
        lore.add("§7seconds");

        lore.add("§9Fractional Reserve III");
        lore.add("§7Recieve §9-1% damage§7 per");
        lore.add("§610,000g §7you have (§9-30%");
        lore.add("§7max)");

        lore.add("§9Mirror III");
        lore.add("§7You do not take true damage and");
        lore.add("§7instead reflect §e50% §7of it to");
        lore.add("§7your attacker");

        lore.add("§dRARE! §9Retro-Gravity Microcosm III");
        lore.add("§7When a player hits you from");
        lore.add("§7above ground §e3 times§7 in a row:");
        lore.add("§7You heal §c1.25❤");
        lore.add("§7Gain §c+1.5❤ §7damage vs them for 30s");
        lore.add("§7They take §c0.5❤§7 true damage");

        lore.add("§9Sweaty III");
        lore.add("§7Earn §b+60% XP§7 from streak XP");
        lore.add("§7bonus and §b+100 max XP§7 per kill");

        lore.add("§9XP Boost III");
        lore.add("§7Earn §b+30% XP§7 from kills");

        lore.add("§dRARE! §9Solitude III");
        lore.add("§7Recieve §9-60% §7damage when two");
        lore.add("§7or less players are within 7");
        lore.add("§7blocks");

        lore.add("§9Moctezuma III");
        lore.add("§7Earn §6+18g§7 on kill (assists");
        lore.add("§7excluded)");

        lore.add("§9Gold Bump III");
        lore.add("§7Earn §6+12g§7 on kill");

        lore.add("§9Gold Boost III");
        lore.add("§7Earn §6+45% gold (g)§7 from kill");

        lore.add("§9Protection III");
        lore.add("§7Recieve §9-10%§7 damage");

        lore.add("§9Diamond Allergy III");
        lore.add("§7Receive §9-30% damage from");
        lore.add("§7diamond weapons");

        lore.add("§9David and Goliath III");
        lore.add("§7Receive §9-40% damage from");
        lore.add("§7players with a bounty");

        lore.add("§9\"Not\" Gladiator III");
        lore.add("§7Receive §9-2% damage per nearby");
        lore.add("§7player (max 10 players)");

        lore.add("§9Golden Heart III");
        lore.add("§7Gain §6+2❤§7 absorption on kill");
        lore.add("§7(max §6❤§7)");

        lore.add("§9Spite");
        lore.add("§7Deal §c+20% damage§7 but receive");
        lore.add("§c+5% damage§7 versus players");
        lore.add("§7wearing leather armor");

        lore.add("§dRARE! §9Pit Blob III");
        lore.add("§7Kills respawn §aThe Blob§7. This");
        lore.add("§7slimy pet will follow you around");
        lore.add("§7and kill your enemies. §aThe Blob");
        lore.add("§7grows and gains health for every");
        lore.add("§7enemy you kill.");

        lore.add("§dRARE! §9Escape Pod III");
        lore.add("§7When hit below §c2§7, launch");
        lore.add("§7into the air dealing §c3 §7damage");
        lore.add("§7to nearby enemies and gaining");
        lore.add("§aRegen IV§7 (30s). Can launch");
        lore.add("§7once per life");

        lore.add("§dRARE! §9Combo: Venom");
        lore.add("§7Every §ethird §7strike §apoisons");
        lore.add("§7enemies, temporarily applying");
        lore.add("§7Somber for §512 seconds.");
        lore.add("§7Also §apoisons §7yourself!");

        lore.add("§9Misery");
        lore.add("§7Deal §c+0.5❤ §7true damage against");
        lore.add("§7players wearing leather pants but");
        lore.add("§7take §c0.3❤");

        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        lores = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("SSS", "SSS", "SSS");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createFreshReds() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.fromRGB(255, 51, 51));
        meta.setDisplayName("§cFresh Red Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§7Kept on death");

        lore.add("§cUsed in the mystic well");
        lore.add("§cAlso, a fashion statement");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        fresh_reds = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createMaldingChestplate() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.fromRGB(145, 49, 49));
        meta.setDisplayName("§cTier I Chestplate");
        List<String> lore = new ArrayList<>();

        lore.add("§7Lives: §a20§7/20");
        lore.add("    ");
        lore.add("§dRARE! §9Flaming");
        lore.add("§7If the final damage of your strike");
        lore.add("§7deals less than §c1.5❤§7 §7damage,");
        lore.add("§7ignite opponent in §a0.1s §7for §c75%");
        lore.add("§7damage");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        item.setItemMeta(meta);
        malding_chestplate = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createMaldingBoots() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.fromRGB(145, 49, 49));
        meta.setDisplayName("§cTier I Boots");
        List<String> lore = new ArrayList<>();

        lore.add("§7Lives: §a20§7/20");
        lore.add("    ");
        lore.add("§dRARE! §9Glamorous");
        lore.add("§7Leave a fancy trail behind you");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        item.setItemMeta(meta);
        malding_boots = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createMaldingPants() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.fromRGB(145, 49, 49));
        meta.setDisplayName("§cTier III Red Pants");
        List<String> lore = new ArrayList<>();

        lore.add("§7Lives: §a20§7/20");
        lore.add("    ");
        lore.addAll(new pantEnchantLores("protIII").getLore());

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        item.setItemMeta(meta);
        malding_pants = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createMaldingSword() {
        ItemStack item = new ItemStack(Material.WOOD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();

        lore.add("§7Lives: §a20§7/20");
        lore.add("    ");
        lore.addAll(new swordEnchantLores("sharpIII").getLore());

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        malding_sword = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createReaperScythe() {
        ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§3Reaper Scythe");
        List<String> lore = new ArrayList<>();

        lore.add("§7Lives: §aNONE");
        lore.add("    ");
        lore.add("§dRARE! §9Harvest! III");
        lore.add("§d5% chance §7to get a");
        lore.add("§3Player Soul §7on kill!");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        reaper_scythe = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createFreshSword() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§eMystic Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§7Kept on death");
        lore.add("");
        lore.add("§7Used in the mystic well");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        fresh_sword = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("SSS", "S S", "S S");
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createPlayerSoul() {
        ItemStack item = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§3Player Soul");
        List<String> lore = new ArrayList<>();
        lore.add("§7Kept on death");
        lore.add("");
        lore.add("§7Used to summon the §cMalding");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        playerSoul = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("SSS", "SSS", "SSS");
        sr.setIngredient('S', Material.GHAST_TEAR);
        Bukkit.getServer().addRecipe(sr);
    }


    private static void createVile() {
        ItemStack item = new ItemStack(Material.COAL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Chunk of Vile");
        List<String> lore = new ArrayList<>();
        lore.add("§7Kept on death");
        lore.add("");
        lore.add("§cHeretic artifact");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        vile = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("SSS", "SSS", "SSS");
        sr.setIngredient('S', Material.COAL);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createJewlPant() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.fromRGB(125,195,131));
        meta.setDisplayName("§3Tier I Sewer Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§7Lives: §a20§7/20");
        lore.add("        ");
        lore.add("§9Hidden Jewel");
        lore.add("§7Kill §c120§7 players to recycle");
        lore.add("§7into Tier I pants with a Tier III");
        lore.add("§7enchant.");
        lore.add("          ");
        lore.add("§3As strong as iron");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        jewl_pant = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.STONE);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createJewlSword() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§7Lives: §a20§7/20");
        lore.add("    ");
        lore.add("§9Hidden Jewel");
        lore.add("§7Kill §c120§7 players to recycle");
        lore.add("§7into Tier I sword with a Tier III");
        lore.add("§7enchant.");

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        jewl_sword = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("S S", "S S", "S S");
        sr.setIngredient('S', Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createGem() {
        ItemStack item = new ItemStack(Material.EMERALD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aTotally Legit Gem");
        List<String> lore = new ArrayList<>();
        lore.add("§7Kept on death");
        lore.add("§7Adds §d1 tier§7 to a mystic enchant.");
        lore.add("§8Once per item!");
        lore.add("");
        lore.add("§eHold and right-click to use!");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        gem = item;
        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("SSS", "SSS", "SSS");
        sr.setIngredient('S', Material.EMERALD_BLOCK);
        Bukkit.getServer().addRecipe(sr);
    }
}
