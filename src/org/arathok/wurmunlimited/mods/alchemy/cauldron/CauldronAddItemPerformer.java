
package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.Items;
import com.wurmonline.server.Players;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.bodys.Wound;
import com.wurmonline.server.bodys.Wounds;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.sounds.SoundPlayer;
import com.wurmonline.server.spells.SpellEffect;
import org.arathok.wurmunlimited.mods.alchemy.addiction.Addiction;
import org.arathok.wurmunlimited.mods.alchemy.addiction.AddictionHandler;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Alchemy;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;

public class CauldronAddItemPerformer implements ActionPerformer {

    public ActionEntry actionEntry;

    Addiction playerInQuestion = null;
    Addiction playerAddiction = new Addiction(); // maybe making a variable here is bad as its stored through the entire
                                                 // performer.

    int seconds = Config.potionDuration;
    float power = 0;

    boolean playedOpeningSound = false;

    public CauldronAddItemPerformer() {
        int[] types;
       {
            types = new int[] { 6 /* ACTION_TYPE_NOMOVE */, 48 /* ACTION_TYPE_ENEMY_ALWAYS */,
                    Actions.ACTION_TYPE_ALWAYS_USE_ACTIVE_ITEM /* DON'T CARE WHETHER SOURCE OR TARGET */,
                    Actions.ACTION_TYPE_NONSTACKABLE
                    // 27, // NONSTACK

                    // 0, // quick
                    // NOSTACK IN FIGHT
            };
            actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "Add Item", "adding",
                    types)

                            .range(4).priority(1).build();
        }

        ModActions.registerAction(actionEntry);

    }


    @Override
    public short getActionId() {
        return actionEntry.getNumber();
    }

    public static boolean canUse(Creature performer, Item target, Item Source) // precondition
    {
        return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();

    }

    @Override
    public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter) {

        if (counter ==1)
        {
            performer.getCommunicator().sendSafeServerMessage("You pull a "+source.getName()+ " from your inventory and prepare to sink it into the Cauldron.");
            action.setTimeLeft(30);
            performer.sendActionControl(action.getActionString(), true, 30);


        }

        if (action.getSecond()>=3)
        {
            if (Cauldrons.cauldrons.get(target.getWurmId()).hasFire(target.getWurmId()))

                SoundPlayer.playSound("sound.alchemy.dropIntoCauldron", performer, 1.6F);
        }


        return propagate(action, ActionPropagation.CONTINUE_ACTION, ActionPropagation.NO_SERVER_PROPAGATION,
                ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
    }
}
