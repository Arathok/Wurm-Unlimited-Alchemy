package org.arathok.wurmunlimited.mods.alchemy.actions;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotionBehaviour implements BehaviourProvider {


	private final List<ActionEntry> consume;
	private final SipPerformer sipPerformer;

	public PotionBehaviour() {
		this.sipPerformer = new SipPerformer();
		this.consume = Collections.singletonList(sipPerformer.actionEntry);
		ModActions.registerActionPerformer(sipPerformer);

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

		} else if (target.getTemplateId() == AlchItems.potionIdFranticCharge) {
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
			if (SipPerformer.canUse(performer, target))
				return new ArrayList<>(consume);

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

		}else if (target.getTemplateId() == AlchItems.potionManaId) {
			if (SipPerformer.canUse(performer, target))
				return new ArrayList<>(consume);

		}else if (target.getTemplateId() == AlchItems.potionKarmaId) {
			if (SipPerformer.canUse(performer, target))
				return new ArrayList<>(consume);

		}else
			return null;



	return null;
	}

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
		return getBehavioursFor(performer, target);
	}
}
