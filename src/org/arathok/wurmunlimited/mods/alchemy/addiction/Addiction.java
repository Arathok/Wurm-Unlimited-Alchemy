package org.arathok.wurmunlimited.mods.alchemy.addiction;

import com.wurmonline.server.Players;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;

import java.util.Map.Entry;

public class Addiction {


	static Player p = null;
	static int currentAddictionLevel = 0;
	static int previousAddictionLevel = 0;
	static long coolDownHealEnd=0;
	static long coolDownBuffEnd=0;
	static int toxicityWarning=0;


}