package org.arathok.wurmunlimited.mods.alchemy.addiction;

import com.wurmonline.server.FailedException;
import com.wurmonline.server.Items;
import com.wurmonline.server.Players;
import com.wurmonline.server.WurmId;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemFactory;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.NoSuchTemplateException;
import com.wurmonline.server.spells.SpellEffect;
import com.wurmonline.shared.constants.ItemMaterials;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class AddictionHandler
{
    public AddictionHandler()
    {

    }

    public static long addictionTimer = 30;
    public static int seconds = 0;
    public static Random random = new Random();
    public static List addictions = new LinkedList<Addiction>();

    public static void AddictionEffects()
    {
        long time = System.currentTimeMillis();
        Addiction addictedPlayer;
        if (addictionTimer < time)
        {
            Iterator<Addiction> addictionHandler = addictions.iterator();
            while (addictionHandler.hasNext()) {

                addictedPlayer = addictionHandler.next();
                int index = AddictionHandler.addictions.indexOf(addictedPlayer);
                if (addictedPlayer.currentAddictionLevel < addictedPlayer.previousAddictionLevel) {
                    addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                            "You are slowly coming down from your addiction:");
                    if (addictedPlayer.currentAddictionLevel <= 3) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is marginal. You feel it is now safe to consume " +
                                        "potions "

                        );
                    }
                    if (addictedPlayer.currentAddictionLevel == 4) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is very low. You are on the verge of being addicted" +
                                        ". You should wait a little while before drinking potions again.");


                    }

                    if (addictedPlayer.currentAddictionLevel < 5) {
                        Item[] items = addictedPlayer.p.getInventory().getItemsAsArray();
                        for (Item item : items) {
                            if (item.getTemplateId() == AlchItems.weakLegsId)
                                Items.destroyItem(item.getWurmId());
                        }
                    }

                    if (addictedPlayer.currentAddictionLevel >= 5) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is low. The withdrawal causes you to tremble and " +
                                        "you feel weak."
                        );
                        ItemTemplate template = AlchItems.weakLegs;
                        try {
                            Item legs = ItemFactory.createItem(AlchItems.weakLegsId,99.0F,"Addiction");
                            addictedPlayer.p.getInventory().getItems().add(legs);
                        } catch (FailedException e) {
                            e.printStackTrace();
                        } catch (NoSuchTemplateException e) {
                            e.printStackTrace();
                            Alchemy.logger.log(Level.SEVERE, "I was trying to create an item but that template didn't exist! Weird!");
                        }


                    }


                    if (addictedPlayer.currentAddictionLevel >= 10 && addictedPlayer.currentAddictionLevel <= 12) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is moderate. You are suffering from a negligible poisoning"
                        );

                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 5, 23, false, 1.0F, false, 5000, (float) 1, 0.0F, false, true);
                    }

                    if (addictedPlayer.currentAddictionLevel >= 12 && addictedPlayer.currentAddictionLevel <= 15) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is moderate. You are suffering from a mild poisoning"
                        );
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 5, 23, false, 1.0F, false, 10000, (float) 1, 0.0F, false, true);
                    }

                    if (addictedPlayer.currentAddictionLevel >= 15 && addictedPlayer.currentAddictionLevel <= 20) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is high. You are suffering from a hefty poisoning and you feel a sharp pain inside your head"
                        );
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 5, 23, false, 1.0F, false, 15000, (float) 1, 0.0F, false, true);
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 9, 1, false, 1.0F, false, 5000, 0.0F, 0.0F, false, true);

                    }

                    if (addictedPlayer.currentAddictionLevel >= 20 && addictedPlayer.currentAddictionLevel <= 25) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is high. You are suffering from a severe poisoning and your brain feels like its full of knives"
                        );
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 5, 23, false, 1.0F, false, 20000, (float) 1, 0.0F, false, true);
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 9, 1, false, 1.0F, false, 10000, 0.0F, 0.0F, false, true);

                    }
                    if (addictedPlayer.currentAddictionLevel >= 25) {
                        addictedPlayer.p.getCommunicator().sendAlertServerMessage(
                                "Your addiction to magical energy is deadly high. You are suffering from a severe poisoning and your brain loses the connection to reality"
                        );
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 5, 23, false, 1.0F, false, 25000, (float) 1, 0.0F, false, true);
                        addictedPlayer.p.addWoundOfType(addictedPlayer.p, (byte) 9, 1, false, 1.0F, false, 20000, 0.0F, 0.0F, false, true);

                    }
                }
                    addictedPlayer.previousAddictionLevel = addictedPlayer.currentAddictionLevel;
                    addictedPlayer.currentAddictionLevel = addictedPlayer.currentAddictionLevel - 1;
                    if (addictedPlayer.currentAddictionLevel < 0)
                    {
                        addictedPlayer.currentAddictionLevel = 0;
                    }
                    AddictionHandler.addictions.set(index, addictedPlayer);

            }
            addictionTimer = (System.currentTimeMillis() + (Config.addictionTimer * 1000));
        }

    }
}