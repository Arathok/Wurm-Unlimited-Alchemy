package org.arathok.wurmunlimited.mods.alchemy.enchantments;

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
    Enchantment enchant;
    while (enchantmentsIterator.hasNext()) {
        enchant=enchantmentsIterator.next();
        if (enchant.timeRunout<time)
        {
            enchant.item.getSpellEffects().removeSpellEffect(enchant.enchantmentType);
            enchant.item.setName(enchant.item.getTemplate().getName());
            enchant.p.getCommunicator().sendAlertServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state");
            if (enchant.p.isFighting())
            enchant.p.getCommunicator().sendCombatServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state",(byte) 255,(byte) 255,(byte) 0);
            enchantmentsIterator.remove();
        }

    }


}


}
