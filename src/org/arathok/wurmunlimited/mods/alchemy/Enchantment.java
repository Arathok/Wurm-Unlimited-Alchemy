package org.arathok.wurmunlimited.mods.alchemy;


import com.wurmonline.server.Items;
import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.Players;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.*;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;

import java.util.Map;

public class Enchantment {

    static int oilTimer = Config.oilDuration * 1000;
    static Item i = null;
    static Player p = null;
    static Long wurmId = 0L;
    static ItemSpellEffects eff = null;

    public static void EnchantmentHandler() throws NoSuchItemException {
long time=System.currentTimeMillis();

        for (Map.Entry<Long, Long> set : Alchemy.weaponsWithOils.entrySet()) {
            if (set.getValue() < time) {

                wurmId = set.getKey();
                if (wurmId != null) {

                    i = Items.getItem(wurmId);
                    p = Players.getInstance().getPlayerOrNull(i.getOwnerId());
                    if (time > set.getValue()) {
                        ItemSpellEffects effs = i.getSpellEffects();
                        SpellEffect[] speffs = effs.getEffects();
                        if (speffs.length > 0) {
                            effs.removeSpellEffect((speffs[0]).type);
                        }

                    p.getCommunicator().sendAlertServerMessage("The oil dried completely off your "+ i.getName()
                            +" and it goes back to a normal " + i.getTemplate().getName() + "." );
                    i.setName(i.getTemplate().getName());
                    Alchemy.weaponsWithOils.remove(wurmId);
                    }


                }
            }
        }
    }
}


