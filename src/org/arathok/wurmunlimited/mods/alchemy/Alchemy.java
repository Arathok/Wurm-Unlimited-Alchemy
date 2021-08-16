package org.arathok.wurmunlimited.mods.alchemy; // HELLO GITHUB!

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;

import com.wurmonline.server.Servers;
import com.wurmonline.server.creatures.Communicator;
import javassist.ClassPool;
import javassist.CtClass;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.*;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

public class Alchemy implements WurmServerMod, Initable, PreInitable, Configurable, ServerStartedListener, ItemTemplatesCreatedListener, PlayerMessageListener{

	@Override
	public void preInit() {
		
		try
		{
		ClassPool classPool = HookManager.getInstance().getClassPool();
		CtClass ctPlayers = classPool.getCtClass("com.wurmonline.server.Players");
        ctPlayers.getMethod("sendStartKingdomChat", "(Lcom/wurmonline/server/players/Player;)V").setBody("return;");
        ctPlayers.getMethod("sendStartGlobalKingdomChat", "(Lcom/wurmonline/server/players/Player;)V").setBody("return;");
		
		CtClass ctPlayer = classPool.getCtClass("com.wurmonline.server.players.Player");

        ctPlayer.getMethod("isKingdomChat", "()Z").setBody("return false;");
        ctPlayer.getMethod("isGlobalChat", "()Z").setBody("return false;");
        ctPlayer.getMethod("seesPlayerAssistantWindow", "()Z").setBody("return false;");
		 } catch (Throwable e) {
	            throw new RuntimeException(e);
		 }

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     
	    
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerStarted() {
		// TODO Auto-generated method stub
	      ModActions.registerActionPerformer(new SipPerformer());
          ModActions.registerBehaviourProvider(new PotionBehaviour());
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
