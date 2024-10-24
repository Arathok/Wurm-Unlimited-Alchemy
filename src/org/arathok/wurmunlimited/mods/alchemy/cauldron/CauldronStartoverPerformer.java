
package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.Items;
import com.wurmonline.server.Players;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.bodys.Wound;
import com.wurmonline.server.bodys.Wounds;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.sounds.SoundPlayer;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.addiction.Addiction;
import org.arathok.wurmunlimited.mods.alchemy.addiction.AddictionHandler;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;

public class CauldronStartoverPerformer implements ActionPerformer {

    public ActionEntry actionEntry;



    public CauldronStartoverPerformer() {
        int[] types;

        types = new int[]{6 /* ACTION_TYPE_NOMOVE */, 48 /* ACTION_TYPE_ENEMY_ALWAYS */,
                Actions.ACTION_TYPE_MAYBE_USE_ACTIVE_ITEM /* Use activated item */,
                // 27, // NONSTACK
                // 0, // quick
                // NOSTACK IN FIGHT
        };

        actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "Start Over", "thinking",types)

                .range(4).priority(1).build();

        ModActions.registerAction(actionEntry);

    }
        //TODO: if at inserted ingredients stage - destroy ingredients they are lost, if at brewing stage empty cauldron to the floor random negative effect
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

    }
}
