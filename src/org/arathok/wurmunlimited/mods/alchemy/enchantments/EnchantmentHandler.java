package org.arathok.wurmunlimited.mods.alchemy.enchantments;

import com.wurmonline.server.*;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.NotOwnedException;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.zones.VolaTile;
import com.wurmonline.server.zones.Zones;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.oils.OilPerformer;
import org.gotti.wurmunlimited.modsupport.ModSupportDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class EnchantmentHandler {

    public EnchantmentHandler() {

    }

    public static List<Enchantment> enchantments = new LinkedList<>();
    public static void RemoveEnchantment() throws SQLException, NoSuchItemException {
        Long time = WurmCalendar.getCurrentTime();
        //Iterate over me Baby!

        Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();
        Enchantment enchantedItem = null;
        while (enchantmentsIterator.hasNext()) {
            enchantedItem = enchantmentsIterator.next();
            //enchantedItem.itemId
            long itemToCheck = 0;
            long playerId = enchantedItem.playerId;
            Player owner = null;
            owner = Players.getInstance().getPlayerOrNull(playerId);

            if (owner != null&&!owner.isLoggedOut()) {
                Item realItem = Items.getItem(enchantedItem.itemId);


                // IF ITEM IS MAILED OR IN LETTERBOX
                String parent = realItem.getParentOrNull().getTemplate().getName();
                String topParent = realItem.getTopParentOrNull().getTemplate().getName();
                if (parent != null && topParent != null) {
                    if (realItem.isMailed() || parent.contains("Spirit") || topParent.contains("Spirit")) {
                        try {
                            Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                            if (owner.getWurmId() != -10)
                                owner.getCommunicator().sendAlertServerMessage("Traveling through dimensions via mail used up all the magic of the oil coating your weapon...");
                            realItem.setName(enchantedItem.itemNameBeforeEnchantment);
                            enchantmentsIterator.remove();
                            Enchantment.remove(Alchemy.dbconn,enchantedItem.itemId);

                            Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.itemId + realItem.getName() + "was removed because the player was mailing it");

                        } catch (NoSuchItemException e) {
                            Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                            e.printStackTrace();
                        }

                    }
                } else {
                    if (realItem.isMailed()) {
                        try {
                            Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                            if (owner.getWurmId() != -10)
                                owner.getCommunicator().sendAlertServerMessage("Traveling through dimensions via mail used up all the magic of the oil coating your weapon...");
                            realItem.setName(enchantedItem.itemNameBeforeEnchantment);
                            enchantmentsIterator.remove();
                            Enchantment.remove(Alchemy.dbconn,enchantedItem.itemId);

                            Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.itemId + realItem.getName() + "was removed because the player was mailing it");

                        } catch (NoSuchItemException e) {
                            Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                            e.printStackTrace();
                        }

                    }
                }

                // IF ITEM IS TOO CLOSE TO THE SERVER BORDER

                if (realItem.getTileX() < 50 || realItem.getTileX() > Zones.worldTileSizeX - 50 || realItem.getTileY() < 50 || realItem.getTileY() > Zones.worldTileSizeY - 50) {


                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                        if (owner.getWurmId() != -10)
                            owner.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                        realItem.setName(enchantedItem.itemNameBeforeEnchantment);
                        enchantmentsIterator.remove();
                        Enchantment.remove(Alchemy.dbconn,enchantedItem.itemId);

                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.itemId + " " + realItem.getName() + "was removed because the player was too close to the world Border");
                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }



                }


                // IF ITEM IS NEAR A PORTAL
                int itemTileX = realItem.getTileX();
                int itemTileY = realItem.getTileY();
                VolaTile[] itemTiles;
                if (realItem.isOnSurface()) {
                    itemTiles = Zones.getTilesSurrounding(itemTileX, itemTileY, true, 2);
                } else {
                    itemTiles = Zones.getTilesSurrounding(itemTileX, itemTileY, true, 2);
                }
                boolean portalFound = false;
                for (VolaTile onetile : itemTiles) {
                    Item[] items = onetile.getItems();
                    for (Item oneItem : items) {
                        if (oneItem.getTemplate().getName().contains("portal")) {
                            portalFound = true;
                            break;
                        }
                    }
                }
                if (portalFound) {


                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                        if (owner.getWurmId() != -10)
                            owner.getCommunicator().sendAlertServerMessage("Magicks of the world used up all the magic power left in the oil.");
                        realItem.setName(enchantedItem.itemNameBeforeEnchantment);
                        enchantmentsIterator.remove();
                        Enchantment.remove(Alchemy.dbconn,enchantedItem.itemId);

                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.itemId + realItem.getName() + "was removed because the player was too close to a portal");
                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }



                }

                // If the Owner Logged off or Item was dropped
                if (owner != null && (owner.isLoggedOut() || owner.getWurmId() == -10)) {
                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                        if (owner.getWurmId() == -10)
                            owner.getCommunicator().sendAlertServerMessage("As you drop your weapon the dirt mixes with the oil and the effect subsides.");
                        realItem.setName(enchantedItem.itemNameBeforeEnchantment);
                        enchantmentsIterator.remove();
                        Enchantment.remove(Alchemy.dbconn,enchantedItem.itemId);

                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.itemId + " " + realItem.getName() + "was removed because the player logged out or dropped the item");
                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }

                }


                // IF time ran out
                if (enchantedItem.timeOfEnchantment + Config.oilDuration* 8L < time) {
                    try {
                        Items.getItem(enchantedItem.itemId).getSpellEffects().removeSpellEffect(enchantedItem.enchantmentType);

                        if (owner != null && owner.getWurmId() != -10)
                            owner.getCommunicator().sendAlertServerMessage("The power of the oil vanishes as the liquid is not able to carry energy any more");

                       realItem.setName(enchantedItem.itemNameBeforeEnchantment);
                        Alchemy.logger.log(Level.INFO, "Oil on Item " + enchantedItem.itemId + " " + realItem.getName() + "was removed because the "+Config.oilDuration+" seconds timer on it ran out");
                        enchantmentsIterator.remove();
                        Enchantment.remove(Alchemy.dbconn,enchantedItem.itemId);
                    } catch (NoSuchItemException e) {
                        Alchemy.logger.log(Level.SEVERE, "No item found for the id" + enchantedItem.itemId, e);
                        e.printStackTrace();
                    }


                }


            }


        }
    }

}
