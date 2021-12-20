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

public class OilBehaviour implements BehaviourProvider {

	

	private final List<ActionEntry> apply;
	private final OilPerformer oilPerformer;

	public OilBehaviour() {
	    this.oilPerformer = new OilPerformer();
	    this.apply = Collections.singletonList(oilPerformer.actionEntry);
		ModActions.registerActionPerformer(oilPerformer);

	}

	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {

		if (source.getTemplateId() == AlchItems.weaponOilDemiseAnimalId) {
            if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilDemiseMonsterId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilDemiseLegendaryId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilDemiseHumanId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilLickOfFireId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilKissOfFrostId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilHeartseekerId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilPlagueId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == AlchItems.weaponOilPoisonId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		}  else
			return null;



	return null;

	}
}
