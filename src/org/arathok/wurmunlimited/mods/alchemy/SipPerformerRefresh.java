package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.bodys.Wound;
import com.wurmonline.server.bodys.Wounds;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class SipPerformerRefresh implements ActionPerformer {

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
			if (!Alchemy.healCooldown.containsKey(performer.getWurmId()) || Alchemy.healCooldown.get(performer.getWurmId()) + 300000 < System.currentTimeMillis()) {
				power = target.getCurrentQualityLevel();

				double healingPool= ((Math.max(5.0D, power)) / 100.0D )* 65535.0D * 1.0D;
				performer.getStatus().modifyStamina((float) healingPool);

				performer.getCommunicator().sendAlertServerMessage(
						"You feel the power of the Potion flow through you! " +
								"You feel refreshed!");

				Items.destroyItem(target.getWurmId());
				Alchemy.healCooldown.put(performer.getWurmId(), (long) (System.currentTimeMillis()+(30000+( (target.getCurrentQualityLevel()/10) * 21000 ))));
				Alchemy.healToxicity.put(performer.getWurmId(),0);


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
				performer.addWoundOfType(performer,(byte)5,21,false,0.0F,false,105,0.0F,1.0F,false,false);
			}
		}
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}