package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class SipPerformerExcel implements ActionPerformer {

	int seconds = 300;
	float power = 0;


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
		if (!Alchemy.cooldown.containsKey(performer.getWurmId()) || Alchemy.cooldown.get(performer.getWurmId()) < System.currentTimeMillis()) {
			if (target.getTemplateId() == AlchItems.potionIdExcell) {

				power = target.getCurrentQualityLevel();

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
				Alchemy.cooldown.put(performer.getWurmId(), System.currentTimeMillis()+300000);
				Alchemy.toxicity.put(performer.getWurmId(), 0);
				performer.getCommunicator().sendAlertServerMessage(
						"You feel the power of the Potion flow through you! " +
						"You feel your skin becoming slick and silky!");
				int temp = Alchemy.currentAddiction.get(performer.getWurmId());
				Alchemy.currentAddiction.put(performer.getWurmId(),temp+1);
				Alchemy.previousAddiction.put(performer.getWurmId(),temp);


			}

		}
		else if (Alchemy.toxicity.get(performer.getWurmId()) < 1&& Alchemy.cooldown.get(performer.getWurmId()) >System.currentTimeMillis()) {
			performer.getCommunicator().sendAlertServerMessage(
					"You are still under influence of another Buff potion! " +
					"Drinking another one would probably kill you because of toxicity");
			performer.getCommunicator().sendAlertServerMessage(
					"You should wait another "+
					(((Alchemy.cooldown.get(performer.getWurmId())-System.currentTimeMillis())/1000)+1)+
					"Seconds before trying to imbibe a potion again");

			Alchemy.toxicity.put(performer.getWurmId(),1);

		} else if (Alchemy.toxicity.get(performer.getWurmId()) > 0 && Alchemy.cooldown.get(performer.getWurmId()) >System.currentTimeMillis()) {

			performer.getCommunicator().sendAlertServerMessage(
					"You feel the rush of alchemical power in every nerve of your body, " +
					"only for the feeling of power to subside after a short while" +
					" and your body collapses under the toxins.");
			Alchemy.cooldown.put(performer.getWurmId(), System.currentTimeMillis());
			Alchemy.toxicity.put(performer.getWurmId(), 0);
			performer.die(false, "toxicity");


		}

		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
