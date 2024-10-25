package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.Items;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.zones.VolaTile;
import com.wurmonline.server.zones.Zones;

import javax.swing.text.html.Option;
import java.util.*;
//TODO: Make Lore return possible Recipes, stir goes into add alchemical compoound phase, add Item adds to the Item List, which is checked against a lookup Table of possible Recipes, use sets with arraysAsList to check contents
//TODO: How to cook a potion: Add Water -> wait for it to purify -> add Items -> stir -> add alchemical Compound -> adding further alchemical compound will raise ql -> Cauldron has potionPrecursor in it and shows it -> Cauldron boils down to potionLiquid -> Further Boiling QL can raise to 2x current ql but lowers output 4x
//TODO: normal output = 100ml
//TODO: cauldron gets inserted in DB polls for DB cauldrons, if cauldron is taken away, poll fails and removes the cauldron from DB
//TODO: cauldron only works if burning campfire below it.
//TODO: if wrong combination of ingredients present or cooked to long, insert suspicious stew.
//TODO: If suspicious stew is consumed random effect of: change charactermodel, teleport player, logoutplayer, player throws up and looses food and water, hurt player, heal player, spawn glibbery monster.

public class CauldronData {
    boolean purified=false;
    boolean compoundReadyToAdd=false;
    float cookingProcessComplete = 0.0F;

    String possibleResultColor;

    float resultQl=1.0F;

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
            else performer.getCommunicator().sendNormalServerMessage("You think you would make something really aweful, should you start over? Or do you want to go through with your experiments?");
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

    public boolean hasFire(long cauldronId)
    {
        Item cauldron = null;
        Optional <Item> maybeCauldron= Items.getItemOptional(cauldronId);
        if (maybeCauldron.isPresent())
        cauldron = maybeCauldron.get();
        else {
            removeFromDB(cauldronId);
            return false;
        }
        VolaTile[] tileUnderCauldron = Zones.getTilesSurrounding(cauldron.getTileX(), cauldron.getTileY(), cauldron.isOnSurface(), 0);
        Item[] tileItems = tileUnderCauldron[0].getItems();
        for (Item oneItem : tileItems) {
            if (oneItem.getTemplateId() == ItemList.campfire)
                if (oneItem.getTemperature() > 4000)
                    return true;
        }

        return cauldron.getTemperature() > 4000;
    }

    private static void removeFromDB(long cauldronId) {
    }

}


