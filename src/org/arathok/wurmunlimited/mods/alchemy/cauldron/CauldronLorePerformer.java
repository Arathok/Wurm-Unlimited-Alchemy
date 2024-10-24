
package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.Items;
import com.wurmonline.server.Players;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.bodys.Wound;
import com.wurmonline.server.bodys.Wounds;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.sounds.SoundPlayer;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.addiction.Addiction;
import org.arathok.wurmunlimited.mods.alchemy.addiction.AddictionHandler;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;

public class CauldronLorePerformer implements ActionPerformer {

    public ActionEntry actionEntry;

    Addiction playerInQuestion = null;
    Addiction playerAddiction = new Addiction(); // maybe making a variable here is bad as its stored through the entire
                                                 // performer.

    int seconds = Config.potionDuration;
    float power = 0;

    boolean playedOpeningSound = false;

    public CauldronLorePerformer() {
        int[] types;
        if (Config.potionsDuringFighting) {
            types = new int[] { 6 /* ACTION_TYPE_NOMOVE */, 48 /* ACTION_TYPE_ENEMY_ALWAYS */,
                    35 /* DON'T CARE WHETHER SOURCE OR TARGET */,
                    // 27, // NONSTACK

                    // 28 // NOSTACK IN FIGHT
            };
            actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "Consume Potion", "consuming",
                    types)

                            .range(4).priority(1000).build();
        } else {
            types = new int[] { 6 /* ACTION_TYPE_NOMOVE */, 48 /* ACTION_TYPE_ENEMY_ALWAYS */,
                    35 /* DON'T CARE WHETHER SOURCE OR TARGET */,
                    // 27, // NONSTACK
                    // 0, // quick
                    // NOSTACK IN FIGHT
            };
            actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "Consume Potion", "consuming",
                    types)

                            .range(4).priority(1).build();
        }

        ModActions.registerAction(actionEntry);

    }

    @Override
    public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {
        return action(action, performer, target, num, counter);
    } // NEEDED OR THE ITEM WILL ONLY ACTIVATE IF YOU HAVE NO ITEM ACTIVE

    @Override
    public short getActionId() {
        return actionEntry.getNumber();
    }

    public static boolean canUse(Creature performer, Item target) // precondition
    {
        return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();

    }

    @Override
    public boolean action(Action action, Creature performer, Item target, short num, float counter) {

        return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
                ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
    }
}
