package org.arathok.wurmunlimited.mods.alchemy.essences;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class EssencesBehaviourItem implements BehaviourProvider {



	private final List<ActionEntry> imbue;
	private final EssencesPerformerItem essencesPerformerItem;

	public EssencesBehaviourItem() {
	    this.essencesPerformerItem = new EssencesPerformerItem();
	    this.imbue = Collections.singletonList(essencesPerformerItem.actionEntry);
		ModActions.registerActionPerformer(essencesPerformerItem);
		Alchemy.logger.log(Level.INFO,"Registering secret Actions...");

	}

	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {

		 return null;

	}
}
