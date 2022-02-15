package org.arathok.wurmunlimited.mods.alchemy.enchantments;

import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.Players;
import com.wurmonline.server.players.Player;
import org.arathok.wurmunlimited.mods.alchemy.actions.OilPerformer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 public class EnchantmentHandler {

    public EnchantmentHandler() {

    }

    public static List<Enchantment> enchantments = new LinkedList<>();
    public static void RemoveEnchantment() {
        Long time = System.currentTimeMillis();
    //Iterate over me Baby!
    Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();
    Enchantment enchantedItem;
    while (enchantmentsIterator.hasNext()) {
        enchantedItem=enchantmentsIterator.next();
         if (enchantedItem.timeRunout<time&&!enchantedItem.item.isTraded())
        {
            enchantedItem.item.getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
            enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
            enchantedItem.p.getCommunicator().sendAlertServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state");
            if (enchantedItem.p.isFighting())
            enchantedItem.p.getCommunicator().sendCombatServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state",(byte) 255,(byte) 255,(byte) 0);
            enchantmentsIterator.remove();
        }

    }


}


}
