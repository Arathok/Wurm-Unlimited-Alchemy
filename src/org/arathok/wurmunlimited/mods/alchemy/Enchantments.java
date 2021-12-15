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
        Iterator<Map.Entry<Long, String>> enchants = Alchemy.weaponsWithOilsEnchants.entrySet().iterator();
        while (weapons.hasNext()) {
            if (weapons.next().getValue() < time) {
                wurmId = weapons.next().getKey();
                if (wurmId != null) {
                    if (!Config.enchantmentsStack) {
                        i = Items.getItem(wurmId);
                        p = Players.getInstance().getPlayerOrNull(i.getOwnerId());
                        if (time > weapons.next().getValue()) {
                            ItemSpellEffects effs = i.getSpellEffects();
                            SpellEffect[] speffs = effs.getEffects();
                            if (speffs.length > 0) {
                                effs.removeSpellEffect((speffs[0]).type);
                            }
                            p.getCommunicator().sendAlertServerMessage("The oil dried completely off your " + i.getName()
                                    + " and it goes back to a normal " + i.getTemplate().getName() + ".");
                            i.setName(i.getTemplate().getName());
                            weapons.remove();
                        }

                    } else // hier bei gestackten einfügen
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

