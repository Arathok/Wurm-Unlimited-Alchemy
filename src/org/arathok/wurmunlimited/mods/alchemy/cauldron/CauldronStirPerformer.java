
package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

public class CauldronStirPerformer implements ActionPerformer {

    public ActionEntry actionEntry;



    public CauldronStirPerformer() {
        int[] types;

        types = new int[]{6 /* ACTION_TYPE_NOMOVE */, 48 /* ACTION_TYPE_ENEMY_ALWAYS */,
                Actions.ACTION_TYPE_MAYBE_USE_ACTIVE_ITEM /* Use activated item */,
                // 27, // NONSTACK
                // 0, // quick
                // NOSTACK IN FIGHT
        };

        actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "Stir Cauldron", "stirring",types)

                .range(4).priority(1).build();

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


        return propagate(action, ActionPropagation.CONTINUE_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
                ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
    }
}
