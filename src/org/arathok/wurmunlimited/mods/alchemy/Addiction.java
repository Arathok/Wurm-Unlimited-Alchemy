package org.arathok.wurmunlimited.mods.alchemy;
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
import com.wurmonline.server.creatures.*;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.Players;
import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class Addiction {
	
	
	public void addictionHandler()
	{
		
		for (Entry<Long, Integer> set : Alchemy.addiction.entrySet())
		{
			Creature player;
			long wurmId= set.getKey();
			int x=set.getValue();
			SpellEffect eff;
			player = Players.getPlayerById(wurmId);
			if (x > 10)
			{
			
				float power = x;

				

				
				
			}
			
			
			
		}
		
	}
}


