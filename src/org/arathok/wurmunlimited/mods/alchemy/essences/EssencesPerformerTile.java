package org.arathok.wurmunlimited.mods.alchemy.essences;


import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.Players;
import com.wurmonline.server.Server;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Terraforming;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.zones.VolaTile;
import com.wurmonline.shared.constants.ItemMaterials;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.enchantments.Enchantment;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.Iterator;

public class EssencesPerformerTile implements ActionPerformer {

	public ActionEntry actionEntry;

	public EssencesPerformerTile(){



		actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "imbue essence", "imbueing", new int[]{
				6 /* ACTION_TYPE_NOMOVE */,
				48 /* ACTION_TYPE_ENEMY_ALWAYS */,
				36 /* USE SOURCE AND TARGET */,

		}).range(4).build();

		ModActions.registerAction(actionEntry);
	}


	int seconds = Config.oilDuration;
	float power = 0;
	Enchantment e = new Enchantment();



	@Override
	public short getActionId() {
		 return actionEntry.getNumber();
	}

	public static boolean canUse(Creature performer, Item source) {

		return performer.isPlayer() && source.getOwnerId() == performer.getWurmId() && !source.isTraded();
	}


	@Override
	public boolean action(Action action, Creature performer, Item source, int tilex, int tiley, boolean onSurface, boolean corner, int tile, int heightOffset, short num, float counter) { // Since we use target and source this time, only need that override
		/*if (target.getTemplateId() != AlchItems.weaponOilDemiseAnimalId)

			return propagate(action,
					ActionPropagation.SERVER_PROPAGATION,
					ActionPropagation.ACTION_PERFORMER_PROPAGATION);*/
		if (!canUse(performer,source)) {
			performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
			return propagate(action,
					ActionPropagation.FINISH_ACTION,
					ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
		}


// EFFECT STUFF GOES HERE

		byte type=Tiles.decodeType(tile);

		if ((Tiles.isReinforcedCaveWall((byte)tile)||Tiles.isOreCave((byte)tile))&&source.getTemplate()==EssencesItems.acidicExtract&&source.getWeightGrams()>10000) {
			//remove walls
			Terraforming.setAsRock(tilex,tiley,false);


		}
		else if(type==(byte)Tiles.TILE_TYPE_CAVE_WALL&&source.getWeightGrams()>100000) {
			//create vein

			if (source.getMaterial()== ItemMaterials.MATERIAL_SANDSTONE)
				type=(byte)Tiles.TILE_TYPE_CAVE_WALL_SANDSTONE;
			if (source.getMaterial()== ItemMaterials.MATERIAL_MARBLE)
				type=(byte)Tiles.TILE_TYPE_CAVE_WALL_MARBLE;
			if (source.getMaterial()== ItemMaterials.MATERIAL_SLATE)
				type=(byte)Tiles.TILE_TYPE_CAVE_WALL_SLATE;
			if (source.getMaterial()== ItemMaterials.MATERIAL_IRON)
				type=(byte)Tiles.TILE_TYPE_CAVE_WALL_ORE_IRON;

			Server.caveMesh.setTile(tilex, tiley,
				Tiles.encode(Tiles.decodeHeight(tile), type,
				Tiles.decodeData(tile)));
			Players.getInstance().sendChangedTile(tilex, tiley, false, true);
		}
		else performer.getCommunicator().sendAlertServerMessage("you don't have enough Transmutation Liquid to transform the wall!");
		return propagate(action,
				ActionPropagation.FINISH_ACTION,
				ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}
