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
	public static HashMap<Long,Integer> currentAddiction = new HashMap<Long,Integer>();
	public static HashMap<Long,Integer> previousAddiction = new HashMap<Long,Integer>();
	public static HashMap<Long, Long> weaponsWithOils = new HashMap<Long, Long>();




	@Override
	public void configure (Properties properties) {
		Config.useOils = Boolean.parseBoolean(properties.getProperty("useOils", "true"));
		Config.alchemyPower = Float.parseFloat(properties.getProperty("alchemyPower", "1.0F"));
		Config.becomeAddicted = Boolean.parseBoolean(properties.getProperty("becomeAddicted", "true"));
		Config.potionDuration = Integer.parseInt(properties.getProperty("potionDuration", "300"));
		Config.oilDuration = Integer.parseInt(properties.getProperty("oilDuration", "300"));
		Config.cooldownPotion = Integer.parseInt(properties.getProperty("cooldownPotion", "300"));
		Config.cooldownHeal = Integer.parseInt(properties.getProperty("cooldownHeal", "300"));
		Config.cooldownUltimate = Integer.parseInt(properties.getProperty("cooldownUltimate", "3600"));
		Config.purifiedWaterCooking = Boolean.parseBoolean(properties.getProperty("purifiedWaterCooking", "true"));

	}


	@Override
	public void preInit() {
		
		 ModActions.init();

		
	
	}

	@Override
	public boolean onPlayerMessage(Communicator arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onItemTemplatesCreated() {
		
		
	            try{
					logger.log(Level.INFO, "Hello, I'm the Alchemy mod and I am creating my Item templates! <3");
					AlchItems.register();
					logger.log(Level.INFO, "Done! Thank you Coldie!");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
	    
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerStarted() {
		// TODO Auto-generated method stub
	      ModActions.registerActionPerformer(new SipPerformerExcel());
	      ModActions.registerActionPerformer(new SipPerformerFog());
	      ModActions.registerActionPerformer(new SipPerformerFrenzy());
	      ModActions.registerActionPerformer(new SipPerformerGoat());
	      ModActions.registerActionPerformer(new SipPerformerHeal());
	      ModActions.registerActionPerformer(new SipPerformerRefresh());
	      ModActions.registerActionPerformer(new SipPerformerSenses());
	      ModActions.registerActionPerformer(new SipPerformerStrength());
	      ModActions.registerActionPerformer(new SipPerformerTruehit());
	      ModActions.registerActionPerformer(new SipPerformerUltimateKnowledge());
	      ModActions.registerActionPerformer(new SipPerformerWillowspine());
	      ModActions.registerActionPerformer(new SipPerformerWoodskin());
		  ModActions.registerBehaviourProvider(new PotionBehaviour());
		  ModActions.registerBehaviourProvider(new OilBehaviour());
		logger.log(Level.INFO, "Thank you Bdew!");

          logger.log(Level.INFO, "Hello, I'm the Alchemy mod and I have finished being loaded to your server! <3");
	}



	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerPoll() {
		Addiction.addictionHandler();
		
	}

    
}
