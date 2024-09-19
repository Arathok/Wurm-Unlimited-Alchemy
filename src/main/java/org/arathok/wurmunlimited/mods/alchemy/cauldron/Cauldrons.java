package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;

import java.util.HashMap;

import static com.wurmonline.server.items.ItemList.*;

public class Cauldrons {
    public static HashMap<Long,CauldronData> cauldrons = new HashMap<Long, CauldronData>();

    public static HashMap<String,Integer[]> possibleRecipes;


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
        possibleRecipes.put("Mana Potion", new Integer[]{PotionItems.potionLiquidHealId, AlchItems.gemPowderId});
        possibleRecipes.put("Karma Potion", new Integer[]{PotionItems.potionLiquidHealId, sourceSalt});
    }

}
