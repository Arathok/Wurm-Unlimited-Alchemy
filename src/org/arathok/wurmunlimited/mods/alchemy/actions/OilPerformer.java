package org.arathok.wurmunlimited.mods.alchemy.actions;



import com.wurmonline.server.Items;
import com.wurmonline.server.Players;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemSpellEffects;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.enchantments.Enchantment;
import org.arathok.wurmunlimited.mods.alchemy.enchantments.EnchantmentHandler;
import org.gotti.wurmunlimited.modsupport.actions.*;

import java.util.Iterator;
import java.util.logging.Level;

public class OilPerformer implements ActionPerformer {

	public ActionEntry actionEntry;
	public OilPerformer(){



		actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "apply weapon oil", "applying", new int[]{
				6 /* ACTION_TYPE_NOMOVE */,
				48 /* ACTION_TYPE_ENEMY_ALWAYS */,
				36 /* USE SOURCE AND TARGET */,

		}).range(4).build();

		ModActions.registerAction(actionEntry);
	}

	
	int seconds = Config.oilDuration;
	float power = 0;
	Enchantment e = new Enchantment();



	@Override
	public short getActionId() {
		 return actionEntry.getNumber();
	}

	public static boolean canUse(Creature performer, Item source) {

		return performer.isPlayer() && source.getOwnerId() == performer.getWurmId() && !source.isTraded();
	}

	public static boolean isEnchantable(Creature performer, Item target) {
		Enchantment oiledWeapon;
		boolean hasOil=false;
		Iterator <Enchantment> oilChecker = EnchantmentHandler.enchantments.iterator();
		if (!Config.enchantmentsStack)
			return ((target.getSpellEffects().getEffects().length==0)||(target.getSpellEffects()==null)) &&!target.isWeaponBow() && (target.isWeapon() || target.isArrow()||target.isQuiver());
		else
			while (oilChecker.hasNext()) {
				oiledWeapon= oilChecker.next();
				if (oiledWeapon.hasOil)
				hasOil=true;
			}

			return !hasOil&&!target.isWeaponBow() && (target.isWeapon() || target.isArrow()||target.isQuiver());
	}

	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) { // Since we use target and source this time, only need that override
		/*if (target.getTemplateId() != AlchItems.weaponOilDemiseAnimalId)

			return propagate(action,
					ActionPropagation.SERVER_PROPAGATION,
					ActionPropagation.ACTION_PERFORMER_PROPAGATION);*/
		if (!canUse(performer,source)) {
			performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
			return propagate(action,
					ActionPropagation.FINISH_ACTION,
					ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
		}

		if (!isEnchantable(performer, target)) {
			performer.getCommunicator().sendAlertServerMessage("There is already a lot of magical power stored inside this weapon, you should" +
					" consult a priest to disenchant it or wait until the current oil has dried off");
			return propagate(action,
					ActionPropagation.FINISH_ACTION,
					ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);

		}
// EFFECT STUFF GOES HERE
		seconds=Config.oilDuration;
		power = source.getCurrentQualityLevel() * Config.alchemyPower;
		ItemSpellEffects effs = target.getSpellEffects();
		SpellEffect eff = null;
		if (effs!=null||effs.getEffects().length>0) // if the weapon is Enchanted
			seconds/=5;								// oil only lasts a fifth of the set time

		// DEMISE ANIMAL
		if (source.getTemplateId() == AlchItems.weaponOilDemiseAnimalId) {
			if(target.isWeapon()||target.isArrow())   {


				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
					eff = effs.getSpellEffect((byte) 11);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 11, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);

					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil,hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
												" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );

			}
			else
				if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					 effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
						eff = effs.getSpellEffect((byte) 11);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 11, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil,hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now be effective against animals for a short time.", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );

				if (fails > 0)
				performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
						"because they were already coated or enchanted already. The excess oil, drips from your " +
						target.getName()+
						" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// DEMISE HUMAN
		if (source.getTemplateId() == AlchItems.weaponOilDemiseHumanId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
					eff = effs.getSpellEffect((byte) 9);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 9, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, Murder)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against Humans" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

						effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
						eff = effs.getSpellEffect((byte) 9);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 9, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil,Murder)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against humans for a short time.", (byte) 2);
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// DEMISE MONSTER
		if (source.getTemplateId() == AlchItems.weaponOilDemiseMonsterId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 10);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 10, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil,monster hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against monsters" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 10);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 10, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil,monster hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now be effective against monsters for a short time.", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// DEMISE LEGENDARY
		if (source.getTemplateId() == AlchItems.weaponOilDemiseLegendaryId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 12);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 12, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, legendary hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against legendaries" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 12);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 12, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil, legendary hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now be effective against legendaries for a short time.", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}
		// Fires Kiss
		if (source.getTemplateId() == AlchItems.weaponOilLickOfFireId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 14);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 14, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil,flaming)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be creating flaming wounds!" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 14);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 14, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil, flaming)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now cause flaming wounds!", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}
		// Frost
		if (source.getTemplateId() == AlchItems.weaponOilKissOfFrostId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 33);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 33, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, frost)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will cause icy wounds!" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 33);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 33, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil, frost)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now cause icy wounds!", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// Leech
		if (source.getTemplateId() == AlchItems.weaponOilLeechId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 26);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 26, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, leech)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now suck out life energy from your opponents!" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 26);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 26, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil, leech)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now suck out live energy of your opponents", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// DEMISE Plague
		if (source.getTemplateId() == AlchItems.weaponOilPlagueId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 18);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 18, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, plague)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now cause infected wounds" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)

						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 18);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 18, power, (seconds));
						eff.timeleft=Config.oilDuration;
						effs.addSpellEffect(eff);
					
						arrow.setName((arrow.getName() + " (oil, plague)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now cause infected wounds!", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// Poison
		if (source.getTemplateId() == AlchItems.weaponOilPoisonId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 27);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 27, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, poison)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now poison your enemy" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 27);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 27, power, (seconds));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + " (oil, poison)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now poison your enemy!", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		// Heartseeker
		if (source.getTemplateId() == AlchItems.weaponOilHeartseekerId) {
			if(target.isWeapon()||target.isArrow())   {
				effs = target.getSpellEffects();

				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				eff = effs.getSpellEffect((byte) 32);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 32, power, (seconds));
					effs.addSpellEffect(eff);
				}
				if (target.isArrow()) // IS ARROW? THEN ONLY DESTROY A 10th
				{
					performer.getCommunicator().sendAlertServerMessage(" You pour the " + source.getName() +
							" over the " + target.getName() +
							" but much of the oil falls of to the side and leaves a messy stain on the ground." +
							" Maybe there is a way to make this more efficient if you " +
							" pour the oil into something that can hold multiple arrows?", (byte) 2);
					source.setWeight((source.getWeightGrams() - 20), true);
					if (source.getWeightGrams()<=20)
						Items.destroyItem(source.getWurmId());
				}
				else
					Items.destroyItem(source.getWurmId());

				target.setName((target.getName() + " (oil, heartseeker)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now cause wounds to be way worse" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					effs = arrow.getSpellEffects();
					if (effs != null)
						if (!Config.enchantmentsStack)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					eff = effs.getSpellEffect((byte) 32);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 32, power, (seconds));
						effs.addSpellEffect(eff);
						
						arrow.setName((arrow.getName() + " (oil, heartseeker)"));

					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
							" Your arrows will now cause wounds to be way worse.", (byte) 2);
					Alchemy.logger.log(Level.INFO,"Player "+ performer.getName()+" used a oil " + source.getName()+" on their "+target.getName() );
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}

		if (eff!=null)
		{
			e.item= target;
			e.p= Players.getInstance().getPlayerOrNull(target.getOwnerId());
			e.timeRunout = System.currentTimeMillis()+(seconds*1000L);
			e.enchantmentType = eff.type;
			e.hasOil=true;
			EnchantmentHandler.enchantments.add(e);
			
		}


		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
