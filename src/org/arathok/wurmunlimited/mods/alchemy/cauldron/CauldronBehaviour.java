package org.arathok.wurmunlimited.mods.alchemy.cauldron;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class CauldronBehaviour implements BehaviourProvider {

    private final List<ActionEntry> consume;
    private final CauldronAddItemPerformer cauldronAddItemPerformer;

    public CauldronBehaviour() {
        this.cauldronAddItemPerformer = new CauldronAddItemPerformer();
        this.consume = Collections.singletonList(cauldronAddItemPerformer.actionEntry);
        ModActions.registerActionPerformer(cauldronAddItemPerformer);
        Alchemy.logger.log(Level.INFO, "Registering Potion Actions...");

    }

    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {

        if (target.getTemplateId() == PotionItems.potionIdHeal) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdGoat) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdExcell) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdFranticCharge) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdMorningFog) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdOakshell) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdSixthSense) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdTruehit) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdStrength) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdWillowspine) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdVynora) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionIdRefresh) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionManaId) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else if (target.getTemplateId() == PotionItems.potionKarmaId) {
            if (CauldronAddItemPerformer.canUse(performer, target))
                return new ArrayList<>(consume);

        }
        else
            return null;

        return null;
    }

    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
        return getBehavioursFor(performer, target);
    }
}
