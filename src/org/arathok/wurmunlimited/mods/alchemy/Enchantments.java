package org.arathok.wurmunlimited.mods.alchemy;


import com.wurmonline.server.Items;
import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.Players;
import com.wurmonline.server.items.*;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;

import java.util.Map;

public class Enchantments {

    static Item i = null;
    static Player p = null;
    static Long wurmId = 0L;

    public static void EnchantmentHandler() throws NoSuchItemException {
        long time = System.currentTimeMillis();

        for (Map.Entry<Long, Long> weapons : Alchemy.weaponsWithOils.entrySet()) {
            if (weapons.getValue() < time) {

                wurmId = weapons.getKey();
                if (wurmId != null) {
                    if (!Config.enchantmentsStack) {
                        i = Items.getItem(wurmId);
                        p = Players.getInstance().getPlayerOrNull(i.getOwnerId());
                        if (time > weapons.getValue()) {
                            ItemSpellEffects effs = i.getSpellEffects();
                            SpellEffect[] speffs = effs.getEffects();
                            if (speffs.length > 0) {
                                effs.removeSpellEffect((speffs[0]).type);
                            }

                            p.getCommunicator().sendAlertServerMessage("The oil dried completely off your " + i.getName()
                                    + " and it goes back to a normal " + i.getTemplate().getName() + ".");
                            i.setName(i.getTemplate().getName());
                            Alchemy.weaponsWithOils.remove(wurmId);
                        }

                    } else // hier bei gestackten einfügen
                        for (Map.Entry<Long, String> enchants : Alchemy.weaponsWithOilsEnchants.entrySet()) {
                            i = Items.getItem(wurmId);
                            p = Players.getInstance().getPlayerOrNull(i.getOwnerId());
                            if (time > weapons.getValue()) {
                                ItemSpellEffects itemEffects = i.getSpellEffects();
                                SpellEffect[] spellsOnItems = itemEffects.getEffects();

                                for (SpellEffect spell : spellsOnItems) {
                                    if (spell.getName().equals(enchants.getValue())) {
                                        itemEffects.removeSpellEffect(spell.type);
                                    }
                                }
                                Alchemy.weaponsWithOils.remove(wurmId);
                                Alchemy.weaponsWithOilsEnchants.remove(wurmId);
                            }

                   }
                }
            }
        }
    }
}


