package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OilBehaviour implements BehaviourProvider {
	private final List<ActionEntry> apply = Collections.singletonList(new ActionEntry(Actions.HEAL_ABSORB, "apply Weapon Oil", "applying"));

	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {

		if (target.getTemplateId() == AlchItems.weaponOilDemiseAnimalId) {
            if (SipPerformerHeal.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilDemiseMonsterId) {
			if (SipPerformerGoat.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilDemiseLegendaryId) {
			if (SipPerformerExcel.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilDemiseHumanId) {
			if (SipPerformerFrenzy.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilLickOfFireId) {
			if (SipPerformerFog.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilKissOfFrostId) {
			if (SipPerformerWoodskin.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilHeartseekerId) {
			if (SipPerformerSenses.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilPlagueId) {
			if (SipPerformerTruehit.canUse(performer, target))
				return new ArrayList<>(apply);

		} else if (target.getTemplateId() == AlchItems.weaponOilPoisonId) {
			if (SipPerformerStrength.canUse(performer, target))
				return new ArrayList<>(apply);

		}  else
			return null;



	return null;
	}

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
		return getBehavioursFor(performer, target);
	}
}
