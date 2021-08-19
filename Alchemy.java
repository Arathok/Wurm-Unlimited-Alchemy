package org.arathok.wurmunlimited.mods.alchemy; // HELLO GITHUB!

import com.wurmonline.server.creatures.Communicator;

import javassist.ClassPool;
import javassist.CtClass;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.*;

import java.util.HashMap;
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

public class Alchemy implements WurmServerMod, Initable, PreInitable, Configurable, ItemTemplatesCreatedListener, ServerStartedListener, ServerPollListener, PlayerMessageListener{
	public static final Logger logger = Logger.getLogger("Alchemy");
	public static HashMap<Long, Long> healCooldown = new HashMap<Long, Long>();
	public static HashMap<Long, Long> cooldown = new HashMap<Long, Long>();
	public static HashMap<Long, Integer> healToxicity = new HashMap<Long, Integer>();
	public static HashMap<Long, Integer> toxicity = new HashMap<Long, Integer>();
	@Override
	public void preInit() {
		
		 ModActions.init();

		
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
		
		
	            try{
					AlchItems.register();
					logger.log(Level.INFO, "Hello, I'm the Alchemy mod and I am creating my Item templates! <3");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
	    
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerStarted() {
		// TODO Auto-generated method stub
	      ModActions.registerActionPerformer(new SipPerformerTruehit());
          ModActions.registerBehaviourProvider(new PotionBehaviour());
          logger.log(Level.INFO, "Hello, I'm the Alchemy mod and I have finished being loaded to your server! <3");
	}

	@Override
	public void configure(Properties arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerPoll() {
		// TODO Auto-generated method stub
		
	}

    
}
