package org.arathok.wurmunlimited.mods.alchemy.enchantments;

import com.wurmonline.server.*;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.zones.Zones;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.oils.OilPerformer;
import org.gotti.wurmunlimited.modsupport.ModSupportDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        Connection dbconn = ModSupportDb.getModSupportDb();
        Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();
        Enchantment enchantedItem = null;
        while (enchantmentsIterator.hasNext()) {
            enchantedItem = enchantmentsIterator.next();
            //enchantedItem.itemId
            long itemToCheck=0;
            PreparedStatement ps = dbconn.prepareStatement("insert into Alchemy (itemID,timeOfEnchantment,enchantment) values (?,?,?)");
            ps.setLong(1,target.getWurmId());
            ps.setLong(2, WurmCalendar.getCurrentTime());
            ps.setByte(3, eff.type);
            ps.executeUpdate();




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




            // If the Server is shutting down




        }


    }


}
