package org.arathok.wurmunlimited.mods.alchemy.essences;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;

import org.arathok.wurmunlimited.mods.alchemy.oils.OilItems;
import org.arathok.wurmunlimited.mods.alchemy.oils.OilPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EssencesBehaviour implements BehaviourProvider {



	private final List<ActionEntry> imbue;
	private final EssencesPerformer essencesPerformer;

	public EssencesBehaviour() {
	    this.essencesPerformer = new EssencesPerformer();
	    this.imbue = Collections.singletonList(essencesPerformer.actionEntry);
		ModActions.registerActionPerformer(essencesPerformer);

	}

	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {

		if (source.getTemplateId() == OilItems.weaponOilDemiseAnimalId) {
            if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilDemiseMonsterId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilDemiseLegendaryId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilDemiseHumanId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilLickOfFireId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilKissOfFrostId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilHeartseekerId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilPlagueId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		} else if (source.getTemplateId() == OilItems.weaponOilPoisonId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);

		}	else if (source.getTemplateId() == OilItems.weaponOilLeechId) {
			if (OilPerformer.canUse(performer, source) && OilPerformer.isWeapon(target))
				return new ArrayList<>(imbue);
		}else
			return null;
			return null;

	}
}
