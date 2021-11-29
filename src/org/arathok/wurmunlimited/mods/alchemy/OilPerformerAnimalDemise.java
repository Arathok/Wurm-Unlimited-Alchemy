package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemSpellEffects;
import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

import java.util.logging.Level;

public class OilPerformerAnimalDemise implements ActionPerformer {

	int seconds = Config.potionDuration;
	float power = 0;


	@Override
	public short getActionId() {
		return Actions.HEAL_ABSORB;
	}

	public static boolean canUse(Creature performer, Item target) {
		return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();
	}

	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) { // Since we use target and source this time, only need that override)

		//Alchemy.logger.log(Level.INFO, "BLAH BLAH HE PERFORMS");
		if (target.getTemplateId() != AlchItems.weaponOilDemiseAnimalId)
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

		if (source.getTemplateId() == AlchItems.weaponOilDemiseAnimalId) {

			power = source.getCurrentQualityLevel()*Config.alchemyPower;

			ItemSpellEffects effs = target.getSpellEffects();
			if (effs == null)
				effs = new ItemSpellEffects(target.getWurmId());
			SpellEffect eff = effs.getSpellEffect((byte) 11);
			if (eff == null) {
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " will now be effective against animals for a short time.", (byte)2);
				eff = new SpellEffect(target.getWurmId(), (byte) 11, (float) power, (seconds));
				effs.addSpellEffect(eff);
			}



		}
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
