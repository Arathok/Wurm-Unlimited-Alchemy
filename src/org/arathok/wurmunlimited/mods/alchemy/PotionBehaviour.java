package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.NotOwnedException;

import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotionBehaviour implements BehaviourProvider {
	private List<ActionEntry> consume;
	
	public PotionBehaviour() {
        consume = Collections.singletonList(new ActionEntry(Actions.USE, "Consume", "consuming"));
        
	}
	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {
		if (target.getTemplateId() == AlchItems.potionIdHeal) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdGoat) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdExcell) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdFranticCharge) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdMorningFog) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdOakshell) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdSixthSense) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdTruehit) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdStrength) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdWillowspine) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdVynora) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (target.getTemplateId() == AlchItems.potionIdRefresh) {
			try {
				if (SipPerformer.canUse(performer, target))
					return new ArrayList<>(consume);
			} catch (NotOwnedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			return null;
		return null;

	}

	@Override
	public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
		return getBehavioursFor(performer, target);
	}
}
