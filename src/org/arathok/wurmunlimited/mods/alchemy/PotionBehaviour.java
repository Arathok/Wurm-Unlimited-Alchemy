package org.arathok.wurmunlimited.mods.alchemy;

import java.util.ArrayList;
import java.util.Collections;

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
            if (SipPerformerHeal.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdGoat) {
			if (SipPerformerGoat.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdExcell) {
			if (SipPerformerExcel.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdFranticCharge) {
			if (SipPerformerFrenzy.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdMorningFog) {
			if (SipPerformerFog.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdOakshell) {
			if (SipPerformerWoodskin.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdSixthSense) {
			if (SipPerformerSenses.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdTruehit) {
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdStrength) {
			if (SipPerformerStrength.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdWillowspine) {
			if (SipPerformerWillowspine.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdVynora) {
			if (SipPerformerUltimateKnowledge.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdRefresh) {
			if (SipPerformerRefresh.canUse(performer, target))
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
