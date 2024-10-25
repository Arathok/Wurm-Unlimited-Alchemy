package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;

import java.util.*;
//TODO: Make Lore return possible Recipes, stir goes into add alchemical compoound phase, add Item adds to the Item List, which is checked against a lookup Table of possible Recipes, use sets with arraysAsList to check contents

public class CauldronData {
    boolean purified=false;
    boolean fireBelow=false;
    boolean compoundReadyToAdd=false;
    ArrayList<Integer> insertedItems = new ArrayList();
    String possibleResultColor;

    float resultQl=1.0F;
// TODO: at alchemical distillery turns potion precursor into potion liquid divides liquid amount by 10 but raises ql by  Distillery ql/10
    ArrayList<Integer> insertedItems = new ArrayList<>();

    public void lore(Creature performer)
    {
        Set<Integer> insertedItemsSet=new HashSet<>(this.insertedItems);

        for (Map.Entry<String, Integer[]> oneEntry: Cauldrons.possibleRecipes.entrySet())
        {
            String recipeName = oneEntry.getKey();
            if (recipeName.contains("2"))
                recipeName=recipeName.replace("2","");
            Integer[] requiredItems= oneEntry.getValue();
            Set<Integer> requiredItemsSet= new HashSet<>(Arrays.asList(requiredItems));

            Set<Integer> intersection = new HashSet<>(requiredItemsSet);
            intersection.retainAll(insertedItemsSet);

            if (!intersection.isEmpty())
                performer.getCommunicator().sendNormalServerMessage("You think with the ingredients inserted you could make a" + recipeName);
            else performer.getCommunicator().sendNormalServerMessage("You think you made something really aweful");
        }
    }

    public static void stir()

    {

    }

    public void addItem(Item addedItem)
    {
        this.insertedItems.add(addedItem.getTemplateId());
        this.resultQl=(this.resultQl+addedItem.getQualityLevel())/2;
    }

}
