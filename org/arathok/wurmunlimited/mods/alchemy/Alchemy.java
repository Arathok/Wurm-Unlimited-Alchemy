package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;

import java.io.IOException;
import java.util.Properties;

import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

public class Alchemy implements WurmServerMod, Initable, PreInitable, Configurable, ServerStartedListener, ItemTemplatesCreatedListener, PlayerMessageListener{

	@Override
	public void preInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onPlayerMessage(Communicator arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onItemTemplatesCreated() {
		
		   try {
	            AlchItems.register();
	           } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

    
}
