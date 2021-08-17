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

import java.util.logging.Level;

public class SipPerformer implements ActionPerformer {
	@Override
	public short getActionId() {
		return Actions.DRINK;
	}

	public static boolean canUse(Creature performer, Item target) {
		return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();
	}

	@Override
	public boolean action(Action action, Creature performer, Item target, short num, float counter) {
		Alchemy.logger.log(Level.INFO, "BLAH BLAH HE PERFORMS");
		if (target.getTemplateId() != AlchItems.potionIdTruehit)
			return propagate(action, ActionPropagation.SERVER_PROPAGATION,
					ActionPropagation.ACTION_PERFORMER_PROPAGATION);

		if (!canUse(performer, target)) {
			performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
			return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
		}
// EFFECT STUFF GOES HERE
		if (target.getTemplateId() == AlchItems.potionIdTruehit)

		{

			float power = target.getCurrentQualityLevel();
			int seconds = 300;

			SpellEffects effs = performer.getSpellEffects();

			if (effs == null)
				effs = performer.createSpellEffects();

			SpellEffect eff = effs.getSpellEffect((byte) 30);

			if (eff == null) {
				eff = new SpellEffect(performer.getWurmId(), (byte) 30, power, Math.max(1, seconds));
				effs.addSpellEffect(eff);
			}

			else if (eff.getPower() < power) {
				eff.setPower((float) power);
				eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
				performer.sendUpdateSpellEffect(eff);
			}
			Items.destroyItem(target.getWurmId());
		}

		// performer.consume(true);

		return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}