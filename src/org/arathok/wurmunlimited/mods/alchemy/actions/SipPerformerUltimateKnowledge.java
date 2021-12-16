package org.arathok.wurmunlimited.mods.alchemy.actions;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

import java.util.logging.Level;

public class SipPerformerUltimateKnowledge implements ActionPerformer {

	int seconds = Config.potionDuration;
	float power = 0;


	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {
		return action(action, performer, target, num, counter);}

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
		if (!Alchemy.cooldown.containsKey(performer.getWurmId()) || Alchemy.cooldown.get(performer.getWurmId())  < System.currentTimeMillis()) {
			if (target.getTemplateId() == AlchItems.potionIdVynora) {

				if (performer.getFatigueLeft() < 100) {
					performer.getCommunicator().sendNormalServerMessage(" You are too tired mentally, to store your brains capacity as sleep bonus.");

				}
				else {
					power = target.getCurrentQualityLevel()*Config.alchemyPower;
					double toconvert;
					toconvert = Math.max(20.0D, power);
					toconvert = Math.min(99.0D, toconvert);
					toconvert /= 100.0D;
					int numsecondsToMove = Math.min((int) ((performer.getFatigueLeft() / 10.0F) * toconvert), 3600);
					performer.setFatigue(-numsecondsToMove);
					numsecondsToMove = (int) (numsecondsToMove * 0.2F);
					numsecondsToMove *= 2;
					if (performer.isPlayer())
						((Player) performer).getSaveFile().addToSleep(numsecondsToMove);
				}
					Items.destroyItem(target.getWurmId());
				Alchemy.cooldown.put(performer.getWurmId(), System.currentTimeMillis()+(Config.cooldownUltimate*1000));
				Alchemy.toxicity.put(performer.getWurmId(), 0);
				performer.getCommunicator().sendAlertServerMessage(
						"You feel the power of the Potion flow through you! " +
						"You feel enlightened. Vynora is proud of you. You have found the final boundaries of knowledge"+
						" and surpassed them! After having flow so much knowledge through you, you feel more exhausted than usual." +
								"You should wait quite a while before drinking the next potion, to make sure your body does not" +
								"succumb to toxicity." );


				if (Config.becomeAddicted==true) {
					Integer temp = Alchemy.currentAddiction.get(performer.getWurmId());
					if (temp == null)
						temp = 0;

					Alchemy.currentAddiction.put(performer.getWurmId(), temp + 1);
					Alchemy.previousAddiction.put(performer.getWurmId(), temp);
					performer.getCommunicator().sendAlertServerMessage("You feel your body is coming a bit more addicted to the magic power of the substances. ");
				}

				Alchemy.logger.log(Level.INFO, String.format( "%s Drank a potion! :%s",performer.getName(),target.getName()));


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
