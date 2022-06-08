package org.arathok.wurmunlimited.mods.alchemy.essences;

import com.wurmonline.mesh.Tiles;
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

public class EssencesBehaviourItem implements BehaviourProvider {



	private final List<ActionEntry> imbue;
	private final EssencesPerformerItem essencesPerformerItem;

	public EssencesBehaviourItem() {
	    this.essencesPerformerItem = new EssencesPerformerItem();
	    this.imbue = Collections.singletonList(essencesPerformerItem.actionEntry);
		ModActions.registerActionPerformer(essencesPerformerItem);

	}

	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {

		 return null;

	}
}
