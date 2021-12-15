package org.arathok.wurmunlimited.mods.alchemy;


import com.wurmonline.server.Items;
import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.Players;
import com.wurmonline.server.items.*;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;

import java.util.Iterator;
import java.util.Map;

public class Enchantments {

    static Item i = null;
    static Player p = null;
    static Long wurmId = 0L;

    public static void EnchantmentHandler() throws NoSuchItemException {
        long time = System.currentTimeMillis();

        Iterator<Map.Entry<Long, Long>> weapons = Alchemy.weaponsWithOils.entrySet().iterator();

        while (weapons.hasNext()) {
            if (weapons.next().getValue() < time) {
                wurmId = weapons.next().getKey();
                if (wurmId != null) {                                   // if an item was Enchanted -> Is Listed in the Hashmap
                    if (!Config.enchantmentsStack) {                    // if Enchants are not allowed to stack with vanilla enchants
                        i = Items.getItem(wurmId);                      // get the items
                        p = Players.getInstance().getPlayerOrNull(i.getOwnerId());  // get the owner
                        if (time > weapons.next().getValue()) {
                            ItemSpellEffects effs = i.getSpellEffects();    // get the spell effects from that item
                            SpellEffect[] speffs = effs.getEffects();       // get the effects from the spells
                            if (speffs.length > 0) {                        // if there are any spells
                                effs.removeSpellEffect((speffs[0]).type);   // remove them
                            }
                            p.getCommunicator().sendAlertServerMessage("The oil dried completely off your " + i.getName()    // inform the user
                                    + " and it goes back to a normal " + i.getTemplate().getName() + ".");
                            i.setName(i.getTemplate().getName());
                            weapons.remove();                           // remove that weapon entry from the hashmap
                        }
                    }
                    else
                    {
                        Iterator<Map.Entry<Long, String>> enchants = Alchemy.weaponsWithOilsEnchants.entrySet().iterator();
                        while(enchants.hasNext()){
                            i = Items.getItem(wurmId);
                            p = Players.getInstance().getPlayerOrNull(i.getOwnerId());
                            if (time > weapons.next().getValue()) {
                                ItemSpellEffects itemEffects = i.getSpellEffects();
                                SpellEffect[] spellsOnItems = itemEffects.getEffects();
                                for (SpellEffect spell : spellsOnItems) {
                                    if (spell.getName().equals(enchants.next().getValue())) {
                                        itemEffects.removeSpellEffect(spell.type);
                                    }
                                    p.getCommunicator().sendAlertServerMessage("The oil dried completely off your " + i.getName()
                                            + " and it goes back to how it was before " + i.getTemplate().getName() + ".");
                                    i.setName(i.getTemplate().getName());
                                }
                                enchants.remove();

                            }
                    }
                }
            }
        }


                    }
                }

            }




