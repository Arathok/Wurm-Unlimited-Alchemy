package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.NotOwnedException;

import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotionBehaviour implements BehaviourProvider {
	private List<ActionEntry> consume;

	public PotionBehaviour() {
		consume = Collections.singletonList(new ActionEntry(Actions.USE, "Consume", "consuming"));

	}

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {
		if (target.getTemplateId() == AlchItems.potionIdHeal) {

			if (SipPerformer.canUse(performer, target))
				return new ArrayList<>(consume);

		} else if (target.getTemplateId() == AlchItems.potionIdGoat) {

			if (SipPerformer.canUse(performer, target))
				return new ArrayList<>(consume);
		} else if (target.getTemplateId() == AlchItems.potionIdExcell) {

			if (SipPerformer.canUse(performer, target))
				return new ArrayList<>(consume);
	} 
		else if (target.getTemplateId() == AlchItems.potionIdFranticCharge) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
		
		} else if (target.getTemplateId() == AlchItems.potionIdMorningFog) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			
		} else if (target.getTemplateId() == AlchItems.potionIdOakshell) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			
		} else if (target.getTemplateId() == AlchItems.potionIdSixthSense) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			
		} else if (target.getTemplateId() == AlchItems.potionIdTruehit) {
			 List<ActionEntry> list = new ArrayList<>();
			 list.add(Actions.actionEntrys[Actions.USE]);
				if (SipPerformer.canUse(performer, target))
					return consume;
			
		} else if (target.getTemplateId() == AlchItems.potionIdStrength) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			
		} else if (target.getTemplateId() == AlchItems.potionIdWillowspine) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
		
		} else if (target.getTemplateId() == AlchItems.potionIdVynora) {
			
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			
		} else if (target.getTemplateId() == AlchItems.potionIdRefresh) {
			
				if (SipPerformer.canUse(performer, target))
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
