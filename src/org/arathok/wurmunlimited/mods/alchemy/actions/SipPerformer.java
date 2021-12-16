package org.arathok.wurmunlimited.mods.alchemy.actions;



import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.addiction.Addiction;
import org.arathok.wurmunlimited.mods.alchemy.addiction.AddictionHandler;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class SipPerformer implements ActionPerformer {

	public ActionEntry actionEntry;
	private final List<ActionEntry> consume = Collections.singletonList(new ActionEntry(Actions.HEAL_ABSORB, "Consume Potion", "consuming"));


	public void SipPerformer() {
		actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "apply weapon oil", "applying", new int[]{
				6 /* ACTION_TYPE_NOMOVE */,
				48 /* ACTION_TYPE_ENEMY_ALWAYS */,
				35 /* DONT CARE WHETHER SOURCE OR TARGET */,

		}).range(4).build();

		ModActions.registerAction(actionEntry);

	}

	int seconds = Config.potionDuration;
	float power = 0;
Addiction playerAddiction = new Addiction();

	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {
		return action(action, performer, target, num, counter);} // NEEDED OR THE ITEM WILL ONLY ACTIVATE IF YOU HAVE NO ITEM ACTIVE

	@Override
	public short getActionId() {
		return Actions.HEAL_ABSORB;
	}

	public static boolean canUse(Creature performer, Item target) {
		return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();
	}

	@Override
	public boolean action(Action action, Creature performer, Item target, short num, float counter) {

		//Alchemy.logger.log(Level.INFO, "BLAH BLAH HE PERFORMS");
		if (target.getTemplateId() != AlchItems.potionIdExcell)
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
				if (target.getTemplateId() == AlchItems.potionIdExcell) {

				power = target.getCurrentQualityLevel()*Config.alchemyPower;

				SpellEffects effs = performer.getSpellEffects();

				if (effs == null)
					effs = performer.createSpellEffects();

				SpellEffect eff = effs.getSpellEffect((byte) 28);

				if (eff == null) {
					eff = new SpellEffect(
							performer.getWurmId(),
							(byte) 28,
							power,
							Math.max(1, seconds));

					effs.addSpellEffect(eff);
				} else if (eff.getPower() < power) {
					eff.setPower(power);
					eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
					performer.sendUpdateSpellEffect(eff);
				}
				Items.destroyItem(target.getWurmId());

				performer.getCommunicator().sendAlertServerMessage(
						"You feel the power of the Potion flow through you! " +
						"You feel your skin becoming slick and silky!");
				if (Config.becomeAddicted) {
					// HIER Listenelement eintragen
					performer.getCommunicator().sendAlertServerMessage("You feel your body is coming a bit more addicted to the magic power of the substances. ");
				}
				Alchemy.logger.log(Level.INFO, String.format( "%s Drank a potion! :%s",performer.getName(),target.getName()));

			}
			// Hier Listenelement anlegen

		AddictionHandler.addictions.add(playerAddiction);
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
