package org.arathok.wurmunlimited.mods.alchemy;

import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.TempState;

public class MyTempstate extends TempState {
    public MyTempstate(int aOrigItemTemplateId, int aNewItemTemplateId, short aTemperatureChangeLevel, boolean aAtIncrease, boolean aKeepWeight, boolean aKeepMaterial) {
        super(aOrigItemTemplateId, aNewItemTemplateId, aTemperatureChangeLevel, aAtIncrease, aKeepWeight, aKeepMaterial);
    }

/* EXPERIMENTAL DISCONTINIUED Java skill not high enough. Wanted to extend the TempState class to look for a certain container
    private short temperatureChangeLevel;
    private boolean atIncrease;
    private int newItemTemplateId;
    private boolean keepMaterial;
    public Item aheater;

    public MyTempstate(Item aheater, int aOrigItemTemplateId, int aNewItemTemplateId, short aTemperatureChangeLevel, boolean aAtIncrease, boolean aKeepWeight, boolean aKeepMaterial, Item aParent) {
        super(aOrigItemTemplateId, aNewItemTemplateId, aTemperatureChangeLevel, aAtIncrease, aKeepWeight, aKeepMaterial);
    }
if (aheater.getName()==0)
    public boolean changeItem(Item parent, Item item, short oldTemp, short newTemp, float qualityRatio) {

        return false;
    }
*/
}

