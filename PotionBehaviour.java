package org.arathok.wurmunlimited.mods.alchemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;

public class PotionBehaviour implements BehaviourProvider {
	private final List<ActionEntry> consume = Collections.singletonList(new ActionEntry(Actions.DRINK, "Consume Potion", "consuming"));



	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {

		if (target.getTemplateId() == AlchItems.potionIdHeal) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdGoat) {
			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);
		} else if (target.getTemplateId() == AlchItems.potionIdExcell) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);
		} else if (target.getTemplateId() == AlchItems.potionIdFranticCharge) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdMorningFog) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdOakshell) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdSixthSense) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdTruehit) {
			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdStrength) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);
		} else if (target.getTemplateId() == AlchItems.potionIdWillowspine) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdVynora) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);
		} else if (target.getTemplateId() == AlchItems.potionIdRefresh) {

			List<ActionEntry> list = new ArrayList<>();
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else
			return null;



	return null;
	}

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
		return getBehavioursFor(performer, target);
	}
}
