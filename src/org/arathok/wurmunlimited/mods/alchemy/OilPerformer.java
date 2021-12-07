package org.arathok.wurmunlimited.mods.alchemy;

//import net.bdew.wurm.halloween.Broom;

import com.wurmonline.server.Items;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemSpellEffects;
import com.wurmonline.server.spells.SpellEffect;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class OilPerformer implements ActionPerformer {

	int seconds = Config.potionDuration;
	float power = 0;


	@Override
	public short getActionId() {
		return Actions.HEAL_ABSORB;
	}

	public static boolean canUse(Creature performer, Item source) {
		return performer.isPlayer() && source.getOwnerId() == performer.getWurmId() && !source.isTraded();
	}

	public static boolean isEnchantable(Creature performer, Item target) {
		return !target.isWeaponBow() && (target.isWeapon() || target.isArrow()||target.isQuiver());
	}

	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) { // Since we use target and source this time, only need that override)

		/*if (target.getTemplateId() != AlchItems.weaponOilDemiseAnimalId)
			return propagate(action,
					ActionPropagation.SERVER_PROPAGATION,
					ActionPropagation.ACTION_PERFORMER_PROPAGATION);*/
		if (!canUse(performer,source))
			return propagate(action,
					ActionPropagation.FINISH_ACTION,
					ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
		if (!isEnchantable(performer, target)) {
			performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
			return propagate(action,
					ActionPropagation.FINISH_ACTION,
					ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);

		}
// EFFECT STUFF GOES HERE
		power = source.getCurrentQualityLevel() * Config.alchemyPower;

		// DEMISE ANIMAL
		if (source.getTemplateId() == AlchItems.weaponOilDemiseAnimalId) {
			if(target.isWeapon()||target.isArrow())   {
			ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 11);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 11, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
				if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 11);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 11, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 9);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 9, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against Humans" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 9);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 9, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 10);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 10, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 10);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 10, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 12);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 12, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 12);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 12, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 14);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 14, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 14);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 14, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 33);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 33, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 33);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 33, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 26);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 26, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 26);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 26, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 18);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 18, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 18);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 18, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 27);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 27, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 27);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 27, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
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
				ItemSpellEffects effs = target.getSpellEffects();
				// ALREADY ENCHANTED? YOU GET NOTHING!
				if (effs != null) {
					performer.getCommunicator().sendAlertServerMessage("The " + target.getName() +
							" is already enchanted or has another type of oil applied and thus cant hold any " +
							" more magic power. You should wait for the other Oil to dry off " +
							" or consult a priest to disenchant your weapon", (byte) 2);
					return propagate(action,
							ActionPropagation.FINISH_ACTION,
							ActionPropagation.NO_SERVER_PROPAGATION,
							ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
				}
				if (effs == null)
					effs = new ItemSpellEffects(target.getWurmId());
				SpellEffect eff = effs.getSpellEffect((byte) 32);
				if (eff == null) {
					eff = new SpellEffect(target.getWurmId(), (byte) 32, power, (Config.oilDuration));
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

				target.setName((target.getName() + "(oil,Hunt)"));
				performer.getCommunicator().sendNormalServerMessage("The " + target
						.getName() + " is now glistening from the oil and will now be effective against animals" +
						" for a short time.(" + Config.oilDuration + "seconds)", (byte) 2);


			} else
			if (target.isQuiver()) {
				int fails =0;
				Item[] arrows = target.getItemsAsArray();
				for (Item arrow:arrows) {

					ItemSpellEffects effs = arrow.getSpellEffects();
					if (effs != null)
						fails++;
					if (effs == null)
						effs = new ItemSpellEffects(arrow.getWurmId());
					SpellEffect eff = effs.getSpellEffect((byte) 32);
					if (eff == null) {

						eff = new SpellEffect(arrow.getWurmId(), (byte) 32, power, (Config.oilDuration));
						effs.addSpellEffect(eff);
						arrow.setName((arrow.getName() + "(oil,Hunt)"));
					}
				}
				performer.getCommunicator().sendNormalServerMessage("You pour the " + source.getName() +
						" in your " + target.getName() + "and see how Oil spreads across the Arrows coating them nicely."+
						" Your arrows will now be effective against animals for a short time.", (byte) 2);
				if (fails > 0)
					performer.getCommunicator().sendNormalServerMessage(fails+" arrow(s) did not accept the oil. Probably " +
							"because they were already coated or enchanted already. The excess oil, drips from your " +
							target.getName()+
							" and dries up on the ground.",(byte)2);
				Items.destroyItem(source.getWurmId());


			}

		}
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
