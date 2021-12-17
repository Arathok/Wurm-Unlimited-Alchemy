package org.arathok.wurmunlimited.mods.alchemy.addiction;

import com.wurmonline.server.players.Player;

public class Addiction {


	public Player p = null;
	public int currentAddictionLevel = 0;
	public int previousAddictionLevel = 0;
	public long coolDownHealEnd =0;
	public long coolDownBuffEnd =0;
	public int toxicityWarningLevel = 0;


}