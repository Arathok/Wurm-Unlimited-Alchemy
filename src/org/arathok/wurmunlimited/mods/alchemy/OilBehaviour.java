package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;

import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OilBehaviour implements BehaviourProvider {

	

	public final List<ActionEntry> apply;
	public final OilPerformer oilPerformer;

	public OilBehaviour() {
	    this.oilPerformer = new OilPerformer();
	    this.apply = Collections.singletonList(oilPerformer.actionEntry);
	}
	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {

		if (source.getTemplateId() == AlchItems.weaponOilDemiseAnimalId) {
            if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilDemiseMonsterId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilDemiseLegendaryId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilDemiseHumanId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilLickOfFireId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilKissOfFrostId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilHeartseekerId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilPlagueId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilPoisonId) {
			if (OilPerformer.canUse(performer, source)&&OilPerformer.isEnchantable(performer,target))
				return new ArrayList<>(apply);

		}  else
			return null;



	return null;

	}
}
