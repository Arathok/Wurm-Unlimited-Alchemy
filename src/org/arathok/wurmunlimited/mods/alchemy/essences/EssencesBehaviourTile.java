package org.arathok.wurmunlimited.mods.alchemy.essences;

import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EssencesBehaviourTile implements BehaviourProvider {



	private final List<ActionEntry> imbue;
	private final EssencesPerformerTile essencesPerformerTile;

	public EssencesBehaviourTile() {
	    this.essencesPerformerTile = new EssencesPerformerTile();
	    this.imbue = Collections.singletonList(essencesPerformerTile.actionEntry);
		ModActions.registerActionPerformer(essencesPerformerTile);

	}

	//, , , , ,
	//, , , , ;

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item subject, int tilex, int tiley, boolean onSurface, int tile, int dir) {
		byte type = Tiles.decodeType(tile);
		if (type==Tiles.TILE_TYPE_CAVE_WALL
				&&subject.getTemplate()==EssencesItems.ironExtract
				||subject.getTemplate()==EssencesItems.slateExtract
				||subject.getTemplate()==EssencesItems.sandExtract
				||subject.getTemplate()==EssencesItems.marbleExtract)
		{
			return new ArrayList<>(imbue);
		}
		else if ((type==Tiles.TILE_TYPE_CAVE_WALL_REINFORCED||Tiles.isOreCave((byte)tile))&&subject.getTemplate()==EssencesItems.acidicExtract)
		{
			return new ArrayList<>(imbue);
		}
		else return null;
		
	}
}
