package org.arathok.wurmunlimited.mods.alchemy;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

//import com.wurmonline.server.creatures.*;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.Players;

import com.wurmonline.server.spells.SpellEffect;

public class Addiction {

	static long addictionTimer = 0;
	static Player p = null;
	static long wurmId = 0;
	SpellEffect eff = null;
	float powerRotGut = 0;
	float powerWormBrain = 0;
	static int seconds = 900;
	static int currentAddictionLevel = 0;
	static int previousAddictionLevel = 0;
	public static void addictionHandler()  {

		for (Entry<Long, Integer> set : Alchemy.currentAddiction.entrySet())
		{
			if (addictionTimer < System.currentTimeMillis()) {

				wurmId = set.getKey();
				if (wurmId != 0)
				currentAddictionLevel = set.getValue();
				previousAddictionLevel = Alchemy.previousAddiction.get(wurmId);

				p = Players.getInstance().getPlayerOrNull(wurmId);
				if (currentAddictionLevel < 4) {

					p.getCommunicator().sendAlertServerMessage("Consuming that potion you became a bit closer to becoming addicted to magic potions.");
				}

				if (currentAddictionLevel == 4)  {

					p.getCommunicator().sendAlertServerMessage("You are just one small step before becoming addicted to the power of potions. You sense some dread in that thought.");
				}

				if (currentAddictionLevel > 5)  {

					p.getCommunicator().sendAlertServerMessage("You are addicted to potions.");
				}

				if (currentAddictionLevel > 5 && previousAddictionLevel > currentAddictionLevel) {

					SpellEffects effs = p.getSpellEffects();

					if (effs == null)
						effs = p.createSpellEffects();

					SpellEffect eff = effs.getSpellEffect((byte) 41);

					if (eff == null) {
						eff = new SpellEffect(
								p.getWurmId(),
								(byte) 41,
								100,
								Math.max(1, seconds));

						effs.addSpellEffect(eff);
					} else if (eff.getPower() < 100) {
						eff.setPower(100);
						eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
						p.sendUpdateSpellEffect(eff);
					}

					p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
					p.getCommunicator().sendSafeServerMessage("Alchemical power is poisoning you. You feel weak.");
				}

				if (currentAddictionLevel < 12 && currentAddictionLevel >= 10 && previousAddictionLevel > currentAddictionLevel ) {

					p.addWoundOfType(p, (byte)10, 23, false, 1.0F, false, 10000, (float)1, 0.0F, false, true);
					p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks to tolerable levels.");
				}

				if (currentAddictionLevel < 15 && currentAddictionLevel >= 12 && previousAddictionLevel > currentAddictionLevel) {

					p.addWoundOfType(p, (byte)10, 23, false, 1.0F, false, 15000, (float)1, 0.0F, false, true);
					p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks to bearable levels.");
				}

				if (currentAddictionLevel < 20 && currentAddictionLevel >= 15 && previousAddictionLevel > currentAddictionLevel) {

					p.addWoundOfType(p, (byte)10, 23, false, 1.0F, false, 20000, (float)1, 0.0F, false, true);
					p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks but its still at dangerous levels");
					p.addWoundOfType(p, (byte)9, 1, false, 1.0F, false, 10000, 0.0F, 0.0F, false, true);
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body slightly messes with your brain.");
				}

				if (currentAddictionLevel < 25 && currentAddictionLevel >= 20 && previousAddictionLevel > currentAddictionLevel) {

					p.addWoundOfType(p, (byte)10, 23, false, 1.0F, false, 30000, (float)1, 0.0F, false, true);
					p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks but its still at dangerous levels");
					p.addWoundOfType(p, (byte)9, 1, false, 1.0F, false, 20000, 0.0F, 0.0F, false, true);
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body messes with your brain.");
				}

				if (currentAddictionLevel > 25 && previousAddictionLevel > currentAddictionLevel) {

					p.addWoundOfType(p, (byte)10, 23, false, 1.0F, false, 30000, (float)1, 0.0F, false, true);
					p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body is at dangerous levels");
					p.addWoundOfType(p, (byte)9, 1, false, 1.0F, false, 30000, 0.0F, 0.0F, false, true);
					p.getCommunicator().sendSafeServerMessage("The toxicity in your body messes heavily with your brain.");
				}

				Alchemy.currentAddiction.put(wurmId,currentAddictionLevel-1);
				Alchemy.previousAddiction.put(wurmId,currentAddictionLevel);
				addictionTimer=System.currentTimeMillis()+(seconds*1000);
			}

		}

	}
}
