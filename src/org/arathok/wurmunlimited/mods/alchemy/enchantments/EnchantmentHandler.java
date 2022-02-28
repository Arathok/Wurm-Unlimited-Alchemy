package org.arathok.wurmunlimited.mods.alchemy.enchantments;

import com.wurmonline.server.Items;
import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.Players;
import com.wurmonline.server.Server;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.zones.Zones;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.oils.OilPerformer;

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
            enchantedItem = enchantmentsIterator.next();
            if (enchantedItem.timeRunout < time && !enchantedItem.item.isTraded()) {
                try {
                    Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                } catch (NoSuchItemException e) {
                    Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                    e.printStackTrace();
                }
                enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                enchantedItem.p.getCommunicator().sendAlertServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state");
                if (enchantedItem.p.isFighting())
                    enchantedItem.p.getCommunicator().sendCombatServerMessage("The weapon Oil, coating your weapon completely dried up and returned it back to its previous state", (byte) 255, (byte) 255, (byte) 0);
                enchantmentsIterator.remove();

            }

            // IF ITEM IS SENT ACROSS SERVER
            if (enchantedItem.item.isTransferred()) {
                try {
                    Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                    enchantedItem.p.getCommunicator().sendAlertServerMessage("Traveling through dimension used up all the magic of the oil coating your weapon...");
                    enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                    Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player was transferring to another server");
                } catch (NoSuchItemException e) {
                    Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                    e.printStackTrace();
                }
                enchantmentsIterator.remove();
            }


            // IF ITEM IS MAILED OR IN LETTERBOX
            String parent = enchantedItem.item.getParentOrNull().getTemplate().getName();
            String topParent = enchantedItem.item.getTopParentOrNull().getTemplate().getName();
            if (parent != null && topParent != null) {
                if (enchantedItem.item.isMailed() || parent.contains("Spirit") || topParent.contains("Spirit")) {
                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                        enchantedItem.p.getCommunicator().sendAlertServerMessage("Traveling through dimensions via mail used up all the magic of the oil coating your weapon...");
                        enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player was mailing it");

                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }
                    enchantmentsIterator.remove();
                }
            } else {
                if (enchantedItem.item.isMailed()) {
                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                        enchantedItem.p.getCommunicator().sendAlertServerMessage("Traveling through dimensions via mail used up all the magic of the oil coating your weapon...");
                        enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player was mailing it");

                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }
                    enchantmentsIterator.remove();
                }
            }

            // IF ITEM IS TOO CLOSE TO THE SERVER BORDER

            if (enchantedItem.item.getTileX() < 50 || enchantedItem.item.getTileX() > Zones.worldTileSizeX - 50 || enchantedItem.item.getTileY() < 50 || enchantedItem.item.getTileY() > Zones.worldTileSizeY - 50) {


                try {
                    Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                    enchantedItem.p.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                    enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                    Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player was too close to the world Border");
                } catch (NoSuchItemException e) {
                    Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                    e.printStackTrace();
                }
                enchantmentsIterator.remove();


            }


            // IF ITEM IS INSIDE INVENTORY OF A LOGGEDOUT PLAYER OR HAS NO OWNER


            Player owner = Players.getInstance().getPlayerOrNull(enchantedItem.item.getOwnerId());
            if (owner != null)
            {
                if (owner.isLoggedOut() || !owner.hasLink()) {
                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                        enchantedItem.p.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                        enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player logged out or lost link");
                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }
                    enchantmentsIterator.remove();
                }
            } else                        // IF THERE IS NO OWNER
            {
                try {
                    Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                    enchantedItem.p.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                    enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                    Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player logged out or lost link");
                } catch (NoSuchItemException e) {
                    Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                    e.printStackTrace();
                }
                enchantmentsIterator.remove();
            }

            // If the Server is shutting down
            if (Server.getMillisToShutDown()<10000)
            {
                try {
                    Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);
                    enchantedItem.p.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                    enchantedItem.item.setName(OilPerformer.renamedItems.get(enchantedItem.item.getWurmId()));
                    Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.item.getName() + "was removed because the player logged out or lost link");
                } catch (NoSuchItemException e) {
                    Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                    e.printStackTrace();
                }
                enchantmentsIterator.remove();
            }



        }


    }


}
