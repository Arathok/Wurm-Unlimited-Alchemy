package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;
import com.wurmonline.server.Items;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

//HELLOGITHUB2
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.spells.Spell;
import com.wurmonline.server.spells.SpellEffect;
import com.wurmonline.server.spells.Spells;

import java.util.HashMap;
import java.util.logging.Level;

public class SipPerformer implements ActionPerformer {

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
		if (target.getTemplateId() != AlchItems.potionIdTruehit)
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
		if (target.getTemplateId() == AlchItems.potionIdTruehit) {
			if (!cooldown.containsKey(performer.getWurmId()) || cooldown.get(performer.getWurmId()) + 300000 < System.currentTimeMillis()) {
				power = target.getCurrentQualityLevel();

				SpellEffects effs = performer.getSpellEffects();

				if (effs == null)
					effs = performer.createSpellEffects();

				SpellEffect eff = effs.getSpellEffect((byte) 30);

				if (eff == null) {
					eff = new SpellEffect(performer.getWurmId(), (byte) 30, power, Math.max(1, seconds));
					effs.addSpellEffect(eff);
				} 
				else if (eff.getPower() < power) {
					eff.setPower(power);
					eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
					performer.sendUpdateSpellEffect(eff);
				}
				
				Items.destroyItem(target.getWurmId());
				cooldown.put(performer.getWurmId(), System.currentTimeMillis());
				toxicity = 0;
			} 
			else if (toxicity == 0 && cooldown.get(performer.getWurmId()) + 300000 > System.currentTimeMillis()) {
				performer.getCommunicator().sendAlertServerMessage("You are still under influence of another potion! " +
						"Drinking another one would probably kill you because of toxicity");

				toxicity++;
			}
			else if (toxicity > 0 && cooldown.get(performer.getWurmId()) + 300000 > System.currentTimeMillis()) {
				performer.destroy();
				performer.getCommunicator().sendAlertServerMessage("You feel the rush of alchemical power in every nerve of your body, " +
						"only for the feeling of power to subside after a short while" +
						" and your body collapses under the toxins.");
			}
		}
		return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
