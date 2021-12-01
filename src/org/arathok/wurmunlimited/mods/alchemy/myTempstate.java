package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.TempState;
import com.wurmonline.server.items.TempStates;

public class myTempstate extends TempState {


    public myTempstate(int aOrigItemTemplateId, int aNewItemTemplateId, short aTemperatureChangeLevel, boolean aAtIncrease, boolean aKeepWeight, boolean aKeepMaterial, Item aParent) {
        super(aOrigItemTemplateId, aNewItemTemplateId, aTemperatureChangeLevel, aAtIncrease, aKeepWeight, aKeepMaterial);
    }
}

