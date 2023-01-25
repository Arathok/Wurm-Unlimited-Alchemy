package org.arathok.wurmunlimited.mods.alchemy.oils;

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


		//Disable war arrow pack from wyvern exploit
		if (target.getName().contains("pack"))
			return null;

		if (source.getTemplateId() == OilItems.weaponOilDemiseAnimalId) {
            if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilDemiseMonsterId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilDemiseLegendaryId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilDemiseHumanId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilLickOfFireId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilKissOfFrostId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilHeartseekerId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilPlagueId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		} else if (source.getTemplateId() == OilItems.weaponOilPoisonId) {
			      if (OilPerformer.canUse(performer, source)&&OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);

		}	else if (source.getTemplateId() == OilItems.weaponOilLeechId) {
			if (OilPerformer.canUse(performer, source) && OilPerformer.isWeapon(target))
				return new ArrayList<>(apply);
		}else
			return null;
			return null;

	}
}
