package com.alpha.redux.items;

import org.bukkit.*;
//import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class itemManager {

    public static ItemStack ChainChestplate;
    public static ItemStack ChainBoots;

    public static ItemStack wand;
    public static ItemStack peroxide;
    public static ItemStack gamble;
    public static ItemStack venom;
    public static ItemStack executioner;
    public static ItemStack billionaire;
    public static ItemStack lifesteal;
    public static ItemStack perun;
    // Iron Armor
    public static ItemStack IronHelmet;
    public static ItemStack IronChestplate;
    public static ItemStack IronLeggings;
    public static ItemStack IronBoots;
    public static ItemStack IronSword;
    // Diamond Armor
    public static ItemStack DiamondHelmet;
    public static ItemStack DiamondChestplate;
    public static ItemStack DiamondLeggings;
    public static ItemStack DiamondBoots;
    public static ItemStack DiamondSword;
    public static ItemStack stick;
    // Ghelm
    public static ItemStack goldHelm;
    public static ItemStack megalongbow;
    public static ItemStack lightsaber;
    public static ItemStack feather;
    public static ItemStack ftts;
    public static ItemStack arma;
    public static ItemStack arch;
    public static ItemStack luckyfeather;
    // Moct 1, 2 and 3
    public static ItemStack moctezuma_one;
    public static ItemStack moctezuma_two;
    public static ItemStack moctezuma_three;
    public static ItemStack Moctezuma_sword_three;
    public static ItemStack billionairels;
    public static ItemStack luckyfeatherII;
    public static ItemStack luckyfeatherIII;

    public static ItemStack heistMasterI;
    public static ItemStack heistMasterII;
    public static ItemStack heistMasterIII;

    public static ItemStack GolemBuddyI;
    public static ItemStack GolemBuddyII;
    public static ItemStack GolemBuddyIII;

    public static ItemStack sweaty_one;
    public static ItemStack sweaty_two;
    public static ItemStack sweaty_three;
    public static ItemStack sweaty_sword_three;

    public static ItemStack gmc_feather;


    public static void init() {
        createWand();
        createPeroxide();
        createGamble();
        createVenom();
        createExecutioner();
        // Iron Armor
        createIronHelmet();
        createIronChestplate();
        createIronLeggings();
        createIronBoots();
        createIronSword();
        // Diamond Helmet
        createDiamondHelmet();
        createDiamondChestplate();
        createDiamondLeggings();
        createDiamondBoots();
        createDiamondSword();
        // Billionaire
        createBillionaire();
        createBillionaireLS();
        // Lifesteal
        createLifeSteal();
        // Stick
        createStick();
        // Perun
        createPerun();
        // Ghelm
        createGoldHelm();

        createMegaLongBow();
        createLightsaber();

        createFeather();

        createFtts();
        createArch();
        createArma();
        // Making Moct 1, 2, and 3
        createMoctezumaI();
        createMoctezumaII();
        createMoctezumaIII();
        createMoctezumaSwordIII();

        createLuckyFeather();
        createLuckyFeatherII();
        createLuckyFeatherIII();

        createHeistMasterI();
        createHeistMasterII();
        createHeistMasterIII();

        createGolemBuddyI();
        createGolemBuddyII();
        createGolemBuddyIII();

        createSweatyI();
        createSweatyII();
        createSweatyIII();
        createSweatySwordIII();
        createChainBoots();
        createChainChestplate();

        createGMCFeather();
    }

    // Chain Armor
    private static void createChainChestplate() {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        ChainChestplate = item;
    }
    private static void createChainBoots() {
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        ChainBoots = item;
    }

    private static void createStick(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        stick = item;
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Tier III");
        List<String> lore = new ArrayList<>();
        lore.add("§7Slap people away with this!");
        lore.add("§7Be careful!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        wand = item;

        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(item);
        sr.shape("B  ", " S ", "  S");
        sr.setIngredient('B', Material.BLAZE_POWDER);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createBillionaireLS() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Billionaire III");
        lore.add("§7Hits with this sword deal §c2x");
        lore.add("§cdamage §7but cost §6350g");
        lore.add("");
        lore.add("§9Lifesteal III");
        lore.add("§7Heal for §c12% §7of damage dealt");
        lore.add("§7to §c1.5❤");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        billionairels = item;

    }

    private static void createBillionaire() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Billionaire III");
        lore.add("§7Hits with this sword deal §c2x");
        lore.add("§cdamage §7but cost §6350g");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        billionaire = item;

    }

    private static void createMegaLongBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Bow");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Mega Longbow III");
        lore.add("§7Shooting this bow gives");
        lore.add("§7jump boost 5");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        megalongbow = item;

    }

    private static void createLightsaber()  {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§dMystical Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Lightsaber");
        lore.add("§7Each hit strikes for §c1 extra heart§7 of §etrue damage");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        lightsaber = item;
    }

    private static void createLifeSteal() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§9Lifesteal III");
        lore.add("§7Heal for §c20% §7of damage dealt up");
        lore.add("§7to §c1.5❤");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        lifesteal = item;
    }

    private static void createPerun() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Combo: Perun's Wrath III");
        lore.add("§7Every §efourth §7hit strikes");
        lore.add("§elightning §7for §c1❤ §7+ §c1❤");
        lore.add("§7per §bdiamond piece §7on your");
        lore.add("§7victim");
        lore.add("§7§oLightning deals true damage");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        perun = item;
    }

    private static void createFtts() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier III Bow");
        List<String> lore = new ArrayList<>();
        lore.add("§9Faster than their shadow III");
        lore.add("§7Hitting §f0 §7shots without");
        lore.add("§7missing grants §eSpeed IV §7(25s)");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        ftts = item;
    }

    private static void createPeroxide() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.WHITE);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Peroxide 3");
        lore.add("§7Gain§c Regen II§7 (8s) when hit");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 25, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        peroxide = item;
    }

    private static void createMoctezumaI() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.YELLOW);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Moctezuma I");
        lore.add("§7Gain an extra §6+2 Gold §7on kill!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        moctezuma_one = item;
    }

    private static void createMoctezumaII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.YELLOW);
        meta.setDisplayName("§cTier II Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Moctezuma II");
        lore.add("§7Gain an extra §6+4 Gold §7on kill!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 15, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        moctezuma_two = item;
    }

    private static void createMoctezumaIII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.YELLOW);
        meta.setDisplayName("§cTier III Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Moctezuma III");
        lore.add("§7Earn §6+18g§7 on kill (assists");
        lore.add("§7excluded)");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        moctezuma_three = item;
    }

    private static void createMoctezumaSwordIII() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier III Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§9Moctezuma III");
        lore.add("§7Earn §6+18g§7 on kill (assists");
        lore.add("§7excluded)");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        Moctezuma_sword_three = item;
    }

    private static void createSweatyI() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.SILVER);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Sweaty I");
        lore.add("§7Gain an extra §b+20 xp §7on kill!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 15, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        sweaty_one = item;
    }

    private static void createSweatyII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.ORANGE);
        meta.setDisplayName("§cTier II Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Sweaty II");
        lore.add("§7Gain an extra §b+30 xp §7on kill!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 25, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        sweaty_two = item;
    }

    private static void createSweatyIII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName("§cTier III Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Sweaty III");
        lore.add("§7Earn §b+60% XP§7 from streak XP");
        lore.add("§7bonus and §b+100 max XP§7 per kill");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        sweaty_three = item;
    }

    private static void createSweatySwordIII() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier III Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§9Sweaty III");
        lore.add("§7Earn §b+60% XP§7 from streak XP");
        lore.add("§7bonus and §b+100 max XP§7 per kill");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        sweaty_sword_three = item;
    }

    private static void createHeistMasterI() {
        ItemStack item = new ItemStack(Material.GOLD_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Boots");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§9Heist Master");
        lore.add("§e50% §7chance to double §c§lSOME §7rewards!");
        lore.add("");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        heistMasterI = item;
    }

    private static void createHeistMasterII() {
        ItemStack item = new ItemStack(Material.GOLD_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Boots");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§9Heist Master II");
        lore.add("§e100% §7chance to double §c§lSOME §7rewards!");
        lore.add("");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        heistMasterII = item;
    }

    private static void createHeistMasterIII() {
        ItemStack item = new ItemStack(Material.GOLD_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier III Boots");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§9Heist Master III");
        lore.add("§e100% §7chance to triple §c§lSOME §7rewards!");
        lore.add("");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        heistMasterIII = item;
    }

    private static void createLuckyFeather() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Lucky Feather");
        lore.add("§7Get a 100% chance to get §31");
        lore.add("§3feather§7 from §dUber Streaks");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 25, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        luckyfeather = item;
    }

    private static void createLuckyFeatherII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Lucky Feather II");
        lore.add("§7Get a 100% chance to get §32");
        lore.add("§3feathers§7 from §dUber Streaks");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 25, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        luckyfeatherII = item;
    }

    private static void createLuckyFeatherIII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9Lucky Feather III");
        lore.add("§7Get a 100% chance to get §33");
        lore.add("§3feather§7 from §dUber Streaks");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 25, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        luckyfeatherIII = item;
    }

    private static void createGolemBuddyI() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9GolemBuddy I");
        lore.add("§7Reflect §e25% §7of damage taken");
        lore.add("§7Permanent §cResistance 1");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 15, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        GolemBuddyI = item;
    }

    private static void createGolemBuddyII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9GolemBuddy II");
        lore.add("§7Reflect §e35% §7of damage taken");
        lore.add("§7Permanent §cResistance 1");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        GolemBuddyII = item;
    }

    private static void createGolemBuddyIII() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.SILVER);
        meta.setDisplayName("§cTier I Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§9GolemBuddy III");
        lore.add("§7Reflect §e50% §7of damage taken");
        lore.add("§7Permanent §cResistance 2");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 25, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        GolemBuddyIII = item;
    }

    private static void createArma() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName("§cArmageddon Boots");
        List<String> lore = new ArrayList<>();
        lore.add("§7Lives: §a20§7/20");
        lore.add("");
        lore.add("§9Evil Within");
        lore.add("§7You're invincible to venom's");
        lore.add("");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        arma = item;
    }

    private static void createArch() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bArchangel Chestplate");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Lives: " + ChatColor.GREEN + "20" + ChatColor.GRAY + "/20");
        lore.add(" ");
        lore.add("§9Guardian");
        lore.add("§7Receive §9-10% §7less damage");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        arch = item;
    }

    private static void createGamble() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Gamble III");
        lore.add("§d50% chance §7to deal§c 2❤ §7true");
        lore.add("§7damage to whoever you hit, or to");
        lore.add("§7yourself");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        gamble = item;
    }

    private static void createVenom() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.BLACK);
        meta.setDisplayName("§5Tier II Dark Pants");
        List<String> lore = new ArrayList<>();
        lore.add("§7Lives: §a20§7/20");
        lore.add("");
        lore.add("§9Somber");
        lore.add("§7You are unaffected by mystical");
        lore.add("§7enchantments.");
        lore.add("");
        lore.add("§dRARE! §9Combo: Venom");
        lore.add("§7Every §ethird §7strike §apoisons");
        lore.add("§7enemies, temporarily applying");
        lore.add("§7Somber for §512 seconds.");
        lore.add("§7Also §apoisons §7yourself!");
        lore.add("");
        lore.add("§5Enchants require heresy");
        lore.add("§5As strong as leather");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        venom = item;
    }

    private static void createExecutioner() {
        ItemStack item = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cTier I Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§dRARE! §9Executioner III");
        lore.add("§7Hitting an enemy to below§c 2❤");
        lore.add("§7instantly kills them");
        lore.add("                      ");
        lore.add("§9Sweaty III");
        lore.add("§7Earn §b+60% XP§7 from streak XP");
        lore.add("§7bonus and §b+100 max XP§7 per kill");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        executioner = item;
    }

    private static void createFeather() {
        ItemStack item = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§3Funky Feather");
        List<String> lore = new ArrayList<>();
        lore.add("§eSpecial item");
        lore.add("§7Used to keep");
        lore.add("§7items on death!");
        meta.setLore(lore);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        feather = item;
    }

    private static void createGMCFeather() {
        ItemStack item = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§3Funky Feather");
        List<String> lore = new ArrayList<>();
        lore.add("§eSpecial item");
        lore.add("§7Used to keep");
        lore.add("§7items on death!");
        meta.setLore(lore);
        //meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        gmc_feather = item;
    }

    // Iron Armor
    private static void createIronHelmet() {
        ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        IronHelmet = item;
    }
    private static void createIronChestplate() {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        IronChestplate = item;
    }
    private static void createIronLeggings() {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        IronLeggings = item;
    }
    private static void createIronBoots() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        IronBoots = item;
    }
    private static void createIronSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        IronSword = item;
    }
    // Diamond Armor
    private static void createDiamondHelmet() {
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        DiamondHelmet = item;
    }
    private static void createDiamondChestplate() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        DiamondChestplate = item;
    }
    private static void createDiamondLeggings() {
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        DiamondLeggings = item;
    }
    private static void createDiamondBoots() {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        DiamondBoots = item;
    }
    private static void createDiamondSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        DiamondSword = item;
    }

    private static void createGoldHelm() {
        ItemStack item = new ItemStack(Material.GOLD_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        meta.setDisplayName("§6Golden Helmet");
        lore.add("§7Lives §a20§7/20");
        lore.add("   ");
        lore.add(ChatColor.BLUE + "Royalty");
        lore.add("§7Earn " + ChatColor.AQUA + "+50 xp cap");
        lore.add(" ");
        lore.add(ChatColor.GOLD + "As strong as diamond");
        meta.setLore(lore);
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        goldHelm = item;
    }
}