import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotionBehaviour implements BehaviourProvider {
    private List<ActionEntry> consume = Collections.singletonList(new ActionEntry(Actions.USE, "Consume", ""));

    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {
        if (target.getTemplateId() == AlchItems.potionIdHeal) {
            if (SipPerformer.canUse(performer, target))
                return new ArrayList<>(consume);
        }
        return null;
    }

    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
        return getBehavioursFor(performer, target);
    }
}
