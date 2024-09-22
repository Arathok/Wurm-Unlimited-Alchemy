package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.creatures.Creature;

import java.util.*;
//TODO: Make Lore return possible Recipes, stir goes into add alchemical compoound phase, add Item adds to the Item List, which is checked against a lookup Table of possible Recipes, use sets with arraysAsList to check contents

public class CauldronData {
    boolean purified=false;
    boolean fireBelow=false;
    boolean compoundReadyToAdd=false;
    String possibleResultColor;

    ArrayList<Integer> insertedItems = new ArrayList<>();

    public void lore(Creature performer)
    {
        Set<Integer> insertedItemsSet=new HashSet<>(this.insertedItems);

        for (Map.Entry<String, Integer[]> oneEntry: org.arathok.wurmunlimited.mods.alchemy.cauldron.Cauldrons.possibleRecipes.entrySet())
        {
            String recipeName = oneEntry.getKey();
            if (recipeName.contains("2"))
                recipeName=recipeName.replace("2","");
            Integer[] requiredItems= oneEntry.getValue();
            Set<Integer> requiredItemsSet= new HashSet<>(Arrays.asList(requiredItems));

            Set<Integer> intersection = new HashSet<>(requiredItemsSet);
            intersection.retainAll(insertedItemsSet);

            if (!intersection.isEmpty())
                performer.getCommunicator().sendNormalServerMessage("You think with the ingredients inserted you could still make a" + recipeName);
        }
    }

    public static void stir()

    {

    }

    public static void addItem()
    {

    }

}
