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

	long addictionTimer = 0;
	Player p = null;
	long wurmId = 0;
	SpellEffect eff = null;
	float powerRotGut = 0;
	float powerWormBrain = 0;
	int seconds = 300;
	int currentAddictionLevel = 0;
	int previousAddictionLevel = 0;
	public void addictionHandler()  {
		
		for (Entry<Long, Integer> set : Alchemy.currentAddiction.entrySet())
		{
			if (addictionTimer < System.currentTimeMillis()) {

				wurmId = set.getKey();
				currentAddictionLevel = set.getValue();

				p = Players.getInstance().getPlayerOrNull(wurmId);
				if (currentAddictionLevel > 5) {

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
				}
				Alchemy.currentAddiction.put(wurmId,currentAddictionLevel-1);
				Alchemy.previousAddiction.put(wurmId,currentAddictionLevel);
				addictionTimer=System.currentTimeMillis()+600000;
			}

		}

	}
}


