package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.items.Item;
import org.arathok.wurmunlimited.mods.alchemy.enchantments.Enchantment;
import org.arathok.wurmunlimited.mods.alchemy.enchantments.EnchantmentHandler;

import java.util.Iterator;

public class MyHooks {

    public static String getNameHook(Item item, String base) {
        boolean itemFound=false;
        Iterator<Enchantment> itemFinder = EnchantmentHandler.enchantments.iterator();
        while (itemFinder.hasNext()) {
            Enchantment enchantedItem=itemFinder.next();
            if (enchantedItem.itemId==item.getWurmId()) // check if the item is oiled and append whatever you need
                itemFound=true;
        }
        if (itemFound)
            return base + "oiled";
        else
            return base;
    }
}
