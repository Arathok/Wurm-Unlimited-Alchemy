package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class SipPerformerUltimateKnowledge implements ActionPerformer {

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
		if (target.getTemplateId() != AlchItems.potionIdVynora)
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
		if (!Alchemy.cooldown.containsKey(performer.getWurmId()) || Alchemy.cooldown.get(performer.getWurmId()) + 300000 < System.currentTimeMillis()) {
			if (target.getTemplateId() == AlchItems.potionIdVynora) {

				if (performer.getFatigueLeft() < 100) {
					performer.getCommunicator().sendNormalServerMessage(" You are too tired mentally, to store your brains capacity as sleep bonus.");

				}
				else {
					power = target.getCurrentQualityLevel();
					double toconvert = power;
					toconvert = Math.max(20.0D, power);
					toconvert = Math.min(99.0D, toconvert);
					toconvert /= 100.0D;
					int numsecondsToMove = Math.min((int) ((performer.getFatigueLeft() / 10.0F) * toconvert), 3600);
					performer.setFatigue(-numsecondsToMove);
					numsecondsToMove = (int) (numsecondsToMove * 0.2F);
					if (performer.isPlayer())
						((Player) performer).getSaveFile().addToSleep(numsecondsToMove);
				}
					Items.destroyItem(target.getWurmId());
				Alchemy.cooldown.put(performer.getWurmId(), System.currentTimeMillis()+3600000);
				Alchemy.toxicity.put(performer.getWurmId(), 0);
				performer.getCommunicator().sendAlertServerMessage(
						"You feel the power of the Potion flow through you! " +
						"You feel enlighted. Vynora is proud of you. You have found the final boundaries of knowledge"+
						" and surpassed them!");


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
			performer.addWoundOfType(performer,(byte)5,21,false,0.0F,false,105,0.0F,1.0F,false,false);
		}

		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
