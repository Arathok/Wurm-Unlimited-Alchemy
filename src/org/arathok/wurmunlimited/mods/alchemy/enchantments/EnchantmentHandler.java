package org.arathok.wurmunlimited.mods.alchemy.enchantments;

import com.wurmonline.server.creatures.SpellEffects;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 public class EnchantmentHandler {

    public EnchantmentHandler() {

    }

    public static List enchantments = new LinkedList<Enchantment>();
    public static void RemoveEnchantment() {
    SpellEffects effs;
    Long time = System.currentTimeMillis();
    //Iterate over me Baby!
    Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();
    Enchantment enchant = null;
    while (enchantmentsIterator.hasNext()) {
        enchant=enchantmentsIterator.next();
        if (enchant.timeRunout<time)
        {
            enchant.item.getSpellEffects().removeSpellEffect(enchant.enchantmentType);
            enchant.item.setName(enchant.item.getTemplate().getName());
            enchant.p.getCommunicator().sendAlertServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state");
            enchantmentsIterator.remove();
        }

    }


}


}
