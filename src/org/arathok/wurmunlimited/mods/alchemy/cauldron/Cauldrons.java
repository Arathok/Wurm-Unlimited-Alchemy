package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;

import java.util.HashMap;

import static com.wurmonline.server.items.ItemList.*;

public class Cauldrons {
    public static HashMap<Long,CauldronData> cauldrons = new HashMap<Long, CauldronData>();

    public static HashMap<String,Integer[]> possibleRecipes;
<<<<<<< Updated upstream:src/org/arathok/wurmunlimited/mods/alchemy/cauldron/Cauldrons.java
    private static HashMap<String,String> potionColors = new HashMap<>();

=======
    public static HashMap<String,String> potionsAndColors;
>>>>>>> Stashed changes:src/main/java/org/arathok/wurmunlimited/mods/alchemy/cauldron/Cauldrons.java

    //Todo: rewrite item lists and actions for potions
    public static void initRecipes()
    {
        possibleRecipes.put("Stamina Potion",new Integer[]{carrot,potato});
        possibleRecipes.put("Stamina Potion2",new Integer[]{mint,fennel});
        possibleRecipes.put("Health Potion", new Integer[]{mushroomBrown, wheat});
        possibleRecipes.put("Fog Skin Potion", new Integer[]{lingonberry, wemp});
        possibleRecipes.put("Woodskin Potion", new Integer[]{acorn, rock, mushroomBlue, sage});
        possibleRecipes.put("Morning Fog Potion", new Integer[]{lingonberry, wemp});
        possibleRecipes.put("Phasing Potion", new Integer[]{rosemary, ivySeedling, pumpkin, eye});
        possibleRecipes.put("Frenzy Potion", new Integer[]{mushroomRed, nutmeg, tomato, tooth});
        possibleRecipes.put("Goat Potion", new Integer[]{branch, oat});
        possibleRecipes.put("Truehit Potion", new Integer[]{belladonna, garlic, mushroomGreen});
        possibleRecipes.put("Vynora Potion", new Integer[]{mushroomYellow, turmeric, strawberries, thyme, cumin, coinSilver});
        possibleRecipes.put("Strength Potion", new Integer[]{mushroomBlack, paprika, woad});
        possibleRecipes.put("Sixth Sense Potion", new Integer[]{lovage, nettles});
        possibleRecipes.put("Eelskin Potion", new Integer[]{ginger, sassafras,mushroomRed});
        possibleRecipes.put("Mana Potion", new Integer[]{PotionItems.potionLiquidHealId, AlchItems.gemPowderId});
        possibleRecipes.put("Eelskin Potion",new Integer[]{sassafras, ginger});
        possibleRecipes.put("Karma Potion", new Integer[]{PotionItems.potionLiquidHealId, sourceSalt});

        potionColors.put("Stamina Potion","pink");
        potionColors.put("Stamina Potion2","pink");
        potionColors.put("Health Potion", "pink");
        potionColors.put("Fog Skin Potion", "blue");
        potionColors.put("Woodskin Potion", "blue");
        potionColors.put("Morning Fog Potion", "purple");
        potionColors.put("Phasing Potion", "blue");
        potionColors.put("Frenzy Potion", "red");
        potionColors.put("Goat Potion", "purple");
        potionColors.put("Truehit Potion", "red");
        potionColors.put("Vynora Potion", "yellow");
        potionColors.put("Strength Potion","red");
        potionColors.put("Sixth Sense Potion", "blue");
        potionColors.put("Mana Potion", "blue");
        potionColors.put("Karma Potion", "purple");

    }

    public static void initColors()
    {
        potionsAndColors.put("Stamina Potion","pink");
        potionsAndColors.put("Stamina Potion2","pink");
        potionsAndColors.put("Health Potion","pink");
        potionsAndColors.put("Fog Skin Potion", "blue");
        potionsAndColors.put("Woodskin Potion", "violet");
        potionsAndColors.put("Morning Fog Potion", "violet");
        potionsAndColors.put("Phasing Potion", "violet");
        potionsAndColors.put("Frenzy Potion", new Integer[]{mushroomRed, nutmeg, tomato, tooth});
        potionsAndColors.put("Goat Potion", new Integer[]{branch, oat});
        potionsAndColors.put("Truehit Potion", new Integer[]{belladonna, garlic, mushroomGreen});
        potionsAndColors.put("Vynora Potion", new Integer[]{mushroomYellow, turmeric, strawberries, thyme, cumin, coinSilver});
        potionsAndColors.put("Strength Potion", new Integer[]{mushroomBlack, paprika, woad});
        potionsAndColors.put("Sixth Sense Potion", new Integer[]{lovage, nettles});
        potionsAndColors.put("Eelskin Potion", "violet");
        potionsAndColors.put("Mana Potion", new Integer[]{PotionItems.potionLiquidHealId, AlchItems.gemPowderId});
        potionsAndColors.put("Karma Potion", new Integer[]{PotionItems.potionLiquidHealId, sourceSalt});
    }

}
