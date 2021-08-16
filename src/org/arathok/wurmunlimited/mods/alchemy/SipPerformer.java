package org.arathok.wurmunlimited.mods.alchemy;

//HELLOGITHUB2
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.NotOwnedException;
import com.wurmonline.server.Server;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.skills.Skill;
import com.wurmonline.shared.constants.AttitudeConstants;
import com.wurmonline.server.spells.*;

//import net.bdew.wurm.halloween.Broom;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;

public class SipPerformer implements ActionPerformer {
	@Override
	public short getActionId() {
		return Actions.USE;
	}

	public static boolean canUse(Creature performer, Item target) {
		return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();
	}

	@Override
	public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {
		return action(action, performer, target, num, counter);
	}

	@Override
	public boolean action(Action action, Creature performer, Item target, short num, float counter) {
		if (target.getTemplateId() != AlchItems.potionIdTruehit)
			return propagate(action, ActionPropagation.SERVER_PROPAGATION,
					ActionPropagation.ACTION_PERFORMER_PROPAGATION);

		if (!canUse(performer, target)) {
			performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
			return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
					ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
		}

		if (target.getTemplateId() == AlchItems.potionIdTruehit)
		// EFFECT STUFF GOES HERE
		{
			
			
			  
				      
			
				float power=target.getCurrentQualityLevel();
				 int seconds=300;
			    Spell sp = Spells.getSpell(30);
			    SpellEffects effs = performer.getSpellEffects();
			   
			    if (effs == null)
				      effs = performer.createSpellEffects(); 
			    
			    SpellEffect eff = effs.getSpellEffect(sp.getEnchantment());
			    
			    if (eff==null)
			    {
				      eff = new SpellEffect(performer.getWurmId(), sp.getEnchantment(), power, Math.max(1, seconds));
				      effs.addSpellEffect(eff);
				    } 
			    
			    else if (eff.getPower() < power) {
				      eff.setPower((float)power);
				      eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
				      performer.sendUpdateSpellEffect(eff);
				    } 
		}
			 
			  
			
		}
		// performer.consume(true);

		return propagate(action, ActionPropagation.FINISH_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
				ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
	}
}