package org.arathok.wurmunlimited.mods.alchemy.addiction;

import com.wurmonline.server.Players;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;

import java.util.Map.Entry;

public class Addiction {


	public Player p = null;
	public int currentAddictionLevel = 0;
	public int previousAddictionLevel = 0;
	public long coolDownHealEnd=0;
	public long coolDownBuffEnd=0;
	public int toxicityWarning=0;


}