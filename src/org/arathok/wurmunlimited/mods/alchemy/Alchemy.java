package org.arathok.wurmunlimited.mods.alchemy; // HELLO GITHUB!

import com.wurmonline.server.creatures.Communicator;
import org.arathok.wurmunlimited.mods.alchemy.oils.OilBehaviour;
import org.arathok.wurmunlimited.mods.alchemy.oils.OilItems;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionBehaviour;
import org.arathok.wurmunlimited.mods.alchemy.addiction.AddictionHandler;
import org.arathok.wurmunlimited.mods.alchemy.enchantments.EnchantmentHandler;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;
import org.gotti.wurmunlimited.modloader.interfaces.*;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alchemy implements WurmServerMod, Initable, PreInitable, Configurable, ItemTemplatesCreatedListener, ServerStartedListener, ServerPollListener, PlayerMessageListener{
	public static final Logger logger = Logger.getLogger("Alchemy");
	public static HashMap<Long, Long> healCooldown = new HashMap<>();
	public static HashMap<Long, Long> cooldown = new HashMap<>();
	public static HashMap<Long, Integer> healToxicity = new HashMap<>();
	public static HashMap<Long, Integer> toxicity = new HashMap<>();
	public static HashMap<Long,Integer> currentAddiction = new HashMap<>();
	public static HashMap<Long,Integer> previousAddiction = new HashMap<>();





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
		Config.addictionTimer = Integer.parseInt(properties.getProperty("addictionTimer", "900"));
		Config.enchantmentsStack = Boolean.parseBoolean(properties.getProperty("enchantmentsStack", "true"));
		Config.oilDurationOnEnchanted = Float.parseFloat(properties.getProperty("oilDurationOnEnchant", "1.0F"));
		Config.versionNumber = Float.parseFloat(properties.getProperty("versionNumber", "0.63F"));
	//	Config.worldMaxX = Integer.parseInt(properties.getProperty("worldMaxX", "4096"));
	//	Config.worldMaxY = Integer.parseInt(properties.getProperty("worldMaxY", "4096"));

	}


	@Override
	public void preInit() {
	/*	try {
			ClassPool classPool = HookManager.getInstance().getClassPool();

			CtClass ctItem = classPool.getCtClass("com.wurmonline.server.items.Item");
			ctItem.getMethod("getName", "(Z)Ljava/lang/String;").insertAfter(
					"return path.to.MyHooks.getNameHook(this, $_);"
			);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}*/
		 ModActions.init();

		
	
	}

	@Override
	public boolean onPlayerMessage(Communicator communicator, String message) {
		if (message != null&&message.startsWith("#AlchemyVersion"))
		{

			communicator.sendSafeServerMessage("You are on Alchemy Version 0.8.5 ");

		}
		return false;
	}

	@Override
	public void onItemTemplatesCreated() {
		
		
	            try{

					AlchItems.register();
					PotionItems.register();
					OilItems.register();
					logger.log(Level.INFO, "Alchemy is Done loading its Item Templates! Thank you Coldie!");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
	    
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerStarted() {
		// TODO Auto-generated method stub

		  ModActions.registerBehaviourProvider(new PotionBehaviour());
		  ModActions.registerBehaviourProvider(new OilBehaviour());
		  new EnchantmentHandler();
		  new AddictionHandler();
		logger.log(Level.INFO, "Alchemy is done registering its Actions! Thank you Bdew!");
		logger.log(Level.INFO, "Hello, I'm the Alchemy mod and I have finished being loaded to your server! <3");
	}



	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerPoll() {
		AddictionHandler.AddictionEffects();
		EnchantmentHandler.RemoveEnchantment();
		

	}

    
}
