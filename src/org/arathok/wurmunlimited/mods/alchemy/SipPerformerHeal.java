package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.bodys.*;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

import java.util.HashMap;

public class SipPerformerHeal implements ActionPerformer {

	int seconds = 300;
	float power = 0;
	int toxicity = 0;

	HashMap<Long, Long> cooldown = new HashMap<Long, Long>();

	@Override
	public short getActionId() {
		return Actions.DRINK;
	}

	public static boolean canUse(Creature performer, Item target) {
		return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();
	}

	@Override
	public boolean action(Action action, Creature performer, Item target, short num, float counter) {
		//Alchemy.logger.log(Level.INFO, "BLAH BLAH HE PERFORMS");
		if (target.getTemplateId() != AlchItems.potionIdHeal)
			return propagate(action,
					ActionPropagation.SERVER_PROPAGATION,
					ActionPropagation.ACTION_PERFORMER_PROPAGATION);

		if (!canUse(performer, target)) {
			performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
			return propagate(action,
					ActionPropagation.FINISH_ACTION,
					ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);

		}
// EFFECT STUFF GOES HERE
		if (target.getTemplateId() == AlchItems.potionIdHeal) {
			if (!cooldown.containsKey(performer.getWurmId()) || cooldown.get(performer.getWurmId()) + 300000 < System.currentTimeMillis()) {
				power = target.getCurrentQualityLevel();

				double healingPool= Math.max(5.0D, power) / 100.0D * 65535.0D * 2.0D;
				Wounds tWounds = performer.getBody().getWounds();
				if (tWounds == null) {
					performer.getCommunicator().sendNormalServerMessage("You have no wounds to heal and wasted your potion!");
					Items.destroyItem(target.getWurmId());
					cooldown.put(performer.getWurmId(), System.currentTimeMillis());
					toxicity = 0;
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				for (Wound w : tWounds.getWounds()) {
					if (w.getSeverity() <= healingPool) {
						healingPool -= w.getSeverity();
						w.heal();
						performer.getCommunicator().sendNormalServerMessage("You heal one your "+ w.getName() + "Wounds!");
					}
					if (w.getSeverity() > healingPool)
					{
						w.modifySeverity((int) -healingPool);
						performer.getCommunicator().sendNormalServerMessage("You heal a part your "+ w.getName() + "Wounds! As the Power of the Potion is used up");
					}
				}

				Items.destroyItem(target.getWurmId());
				cooldown.put(performer.getWurmId(), System.currentTimeMillis());
				toxicity = 0;
				performer.getCommunicator().sendAlertServerMessage("You are still under influence of another potion! " +
						"Drinking another one would probably kill you because of toxicity");

			} else if (toxicity < 1) {
				performer.getCommunicator().sendAlertServerMessage("You are still under influence of another potion! " +
						"Drinking another one would probably kill you because of toxicity");

				toxicity++;
			} else if (toxicity > 0) {
				/* performer.addWoundOfType() TODO:RESEARCH THIS SHIT */
				performer.destroy();
				performer.getCommunicator().sendAlertServerMessage("You feel the rush of alchemical power in every nerve of your body, " +
						"only for the feeling of power to subside after a short while" +
						" and your body collapses under the toxins.");
			}
		}
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}