package org.arathok.wurmunlimited.mods.alchemy;
import com.wurmonline.server.NoSuchPlayerException;
import com.wurmonline.server.creatures.Communicator;

import javassist.ClassPool;
import javassist.CtClass;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.*;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;
import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
//import com.wurmonline.server.creatures.*;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.Players;

import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class Addiction {

	long addictionTimer = 0;
	Player p = null;
	long wurmId = 0;
	SpellEffect eff = null;
	float power = 0;
	int seconds = 300;
	public void addictionHandler()  {
		
		for (Entry<Long, Integer> set : Alchemy.addiction.entrySet())
		{
			if (addictionTimer < System.currentTimeMillis()) {

				wurmId = set.getKey();
				int x = set.getValue();

				p = Players.getInstance().getPlayerOrNull(wurmId);
				if (x > 5) {
					power = x;
					SpellEffects effs = p.getSpellEffects();

					if (effs == null)
						effs = p.createSpellEffects();

					SpellEffect eff = effs.getSpellEffect((byte) 28);

					if (eff == null) {
						eff = new SpellEffect(
								p.getWurmId(),
								(byte) 28,
								power,
								Math.max(1, seconds));

						effs.addSpellEffect(eff);
					} else if (eff.getPower() < power) {
						eff.setPower(power);
						eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
						p.sendUpdateSpellEffect(eff);
					}
				}

			}
			
		}

	}
}


