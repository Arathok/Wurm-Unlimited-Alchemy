package org.arathok.wurmunlimited.mods.alchemy.enchantments;

import com.wurmonline.server.Items;
import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.Players;
import com.wurmonline.server.Server;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.zones.Zone;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.actions.OilPerformer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

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
            try {
                Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

            } catch (NoSuchItemException e) {
                Alchemy.logger.log(Level.SEVERE,"No item found for the id"+enchantedItem.itemId,e);
                e.printStackTrace();
            }
            enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
            enchantedItem.p.getCommunicator().sendAlertServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state");
            if (enchantedItem.p.isFighting())
            enchantedItem.p.getCommunicator().sendCombatServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state",(byte) 255,(byte) 255,(byte) 0);
            enchantmentsIterator.remove();

        }

        if (enchantedItem.timeRunout<time&&!enchantedItem.item.isTraded())
        {
            try {
                Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
            } catch (NoSuchItemException e) {
                Alchemy.logger.log(Level.SEVERE,"No item found for the id"+enchantedItem.itemId,e);
                e.printStackTrace();
            }
            enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
            enchantedItem.p.getCommunicator().sendAlertServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state");
            if (enchantedItem.p.isFighting())
                enchantedItem.p.getCommunicator().sendCombatServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state",(byte) 255,(byte) 255,(byte) 0);
            enchantmentsIterator.remove();

        }

        if(enchantedItem.item.isTransferred())
        {
            try {
                Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                enchantedItem.p.getCommunicator().sendAlertServerMessage("Traveling through dimension used up all the magic of the oil coating your weapon...");
                enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
            } catch (NoSuchItemException e) {
                Alchemy.logger.log(Level.SEVERE,"No item found for the id"+enchantedItem.itemId,e);
                e.printStackTrace();
            }
            enchantmentsIterator.remove();
        }

        if(enchantedItem.item.isMailed())
        {
            try {
                Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                enchantedItem.p.getCommunicator().sendAlertServerMessage("Traveling through dimensions via mail used up all the magic of the oil coating your weapon...");
                enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
            } catch (NoSuchItemException e) {
                Alchemy.logger.log(Level.SEVERE,"No item found for the id"+enchantedItem.itemId,e);
                e.printStackTrace();
            }
            enchantmentsIterator.remove();
        }

        if (enchantedItem.item.getPosX()< 50||enchantedItem.item.getPosX()>Config.worldMaxX-50||enchantedItem.item.getPosY()< 50||enchantedItem.item.getPosY()> Config.worldMaxY-50)
        {

Player owner =Players.getInstance().getPlayerOrNull(enchantedItem.item.getOwnerId());
        if (owner!=null)
        if (owner.isLoggedOut()||!owner.hasLink())
        {
            try {
                Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                enchantedItem.p.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
            } catch (NoSuchItemException e) {
                Alchemy.logger.log(Level.SEVERE,"No item found for the id"+enchantedItem.itemId,e);
                e.printStackTrace();
            }
            enchantmentsIterator.remove();
        }
        }

    }


}


}
