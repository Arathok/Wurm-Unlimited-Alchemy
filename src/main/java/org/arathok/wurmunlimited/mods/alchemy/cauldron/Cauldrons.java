package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import java.util.HashMap;

import static com.wurmonline.server.items.ItemList.*;

public class Cauldrons {
    public static HashMap<Long,CauldronData> cauldrons = new HashMap<Long, CauldronData>();

    public static HashMap<String,Integer[]> possibleRecipes;
    public static int[] testint= new int[]{123};

    //Todo: rewrite item lists and actions for potions
    public static void initRecipes()
    {
        possibleRecipes.put("Stamina Potion",new Integer[]{carrot,potato,mint,fennel});
    }

}
