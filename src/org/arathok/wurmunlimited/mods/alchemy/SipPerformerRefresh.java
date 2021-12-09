package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

import java.util.logging.Level;

public class SipPerformerRefresh implements ActionPerformer {

	int seconds = Config.potionDuration;
	float power = 0;


	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {
		return action(action, performer, target, num, counter);} // NEEDED OR THE ITEM WILL ONLY ACTIVATE IF YOU HAVE NO ITEM ACTIVE


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
		if (target.getTemplateId() != AlchItems.potionIdRefresh)
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
		if (target.getTemplateId() == AlchItems.potionIdRefresh) {
			if (!Alchemy.healCooldown.containsKey(performer.getWurmId()) || Alchemy.healCooldown.get(performer.getWurmId()) < System.currentTimeMillis()) {
				power = target.getCurrentQualityLevel()*Config.alchemyPower;

				double healingPool= ((Math.max(5.0D, power)) / 100.0D )* 65535.0D * 1.0D;
				performer.getStatus().modifyStamina((float) healingPool);

				performer.getCommunicator().sendAlertServerMessage(
						"You feel the power of the Potion flow through you! " +
								"You feel refreshed!");

				Items.destroyItem(target.getWurmId());
				Alchemy.healCooldown.put(performer.getWurmId(), (long) (System.currentTimeMillis()+(30000+( (target.getCurrentQualityLevel()/10) * 21000 ))));
				Alchemy.healToxicity.put(performer.getWurmId(),0);

				if (Config.becomeAddicted==true) {
					Integer temp = Alchemy.currentAddiction.get(performer.getWurmId());
					if (temp == null)
						temp = 0;

					Alchemy.currentAddiction.put(performer.getWurmId(), temp + 1);
					Alchemy.previousAddiction.put(performer.getWurmId(), temp);
					performer.getCommunicator().sendAlertServerMessage("You feel your body is coming a bit more addicted to the magic power of the substances. ");
				}
				Alchemy.logger.log(Level.INFO, String.format( "%s Drank a potion! :%s",performer.getName(),target.getName()));


			} else if (Alchemy.healToxicity.get(performer.getWurmId()) < 1&& Alchemy.healCooldown.get(performer.getWurmId()) >System.currentTimeMillis()) {
				performer.getCommunicator().sendAlertServerMessage(
						"You should wait another "+
						(((Alchemy.healCooldown.get(performer.getWurmId())-System.currentTimeMillis())/1000)+1)+
						"Seconds before trying to imbibe a healing or refreshing potion again");

				Alchemy.healToxicity.put(performer.getWurmId(),1);

			} else if (Alchemy.healToxicity.get(performer.getWurmId()) > 0 && Alchemy.healCooldown.get(performer.getWurmId()) >System.currentTimeMillis()) {

				performer.getCommunicator().sendAlertServerMessage(
						"You feel the rush of alchemical power in every nerve of your body, " +
						"only for the feeling of power to subside after a short while" +
						" and your body collapses under the toxins.");
				Alchemy.cooldown.put(performer.getWurmId(), System.currentTimeMillis());
				Alchemy.toxicity.put(performer.getWurmId(), 0);
				performer.die(false, "toxicity");
			}
		}
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}