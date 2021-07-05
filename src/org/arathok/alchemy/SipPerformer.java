package org.arathok.wurmunlimited.mods.alchemy;
//HELLOGITHUB
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
//import net.bdew.wurm.halloween.Broom;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class SipPerformer implements ActionPerformer {
    @Override
    public short getActionId() {
        return Actions.DISEMBARK;
    }

    public static boolean canUse(Creature performer, Item target) {
        return performer.isPlayer() && performer.getVehicle() == target.getWurmId();
    }

    @Override
    public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {
        return action(action, performer, target, num, counter);
    }

    @Override
    public boolean action(Action action, Creature performer, Item target, short num, float counter) {
        if (target.getTemplateId() != 8000)
            return propagate(action, ActionPropagation.SERVER_PROPAGATION, ActionPropagation.ACTION_PERFORMER_PROPAGATION);

        if (!canUse(performer, target)) {
            performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
            return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION, ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
        }

        if (performer.getVisionArea() != null) {
            performer.getVisionArea().broadCastUpdateSelectBar(performer.getWurmId(), true);
        }
        performer.disembark(true);

        return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION, ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
    }
}