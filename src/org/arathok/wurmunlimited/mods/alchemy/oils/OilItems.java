package org.arathok.wurmunlimited.mods.alchemy.oils;

import com.wurmonline.server.items.*;
import org.arathok.wurmunlimited.mods.alchemy.AlchItems;
import org.arathok.wurmunlimited.mods.alchemy.Config;
import org.arathok.wurmunlimited.mods.alchemy.potions.PotionItems;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import java.io.IOException;

public class OilItems {

    public static int
        pasteDemiseAnimalId, pasteDemiseMonsterId, pasteDemiseLegendaryId, pasteDemiseHumanId, pasteLickOfFireId,
        pasteKissOfFrostId, pasteLeechId, pasteHeartseekerId, pastePlagueId, pastePoisonId,

        sludgeDemiseAnimalId, sludgeDemiseMonsterId, sludgeDemiseLegendaryId, sludgeDemiseHumanId, sludgeLickOfFireId,
        sludgeKissOfFrostId, sludgeLeechId, sludgeHeartseekerId, sludgePlagueId, sludgePoisonId,

        oilDemiseAnimalId, oilDemiseMonsterId, oilDemiseLegendaryId, oilDemiseHumanId, oilLickOfFireId,
        oilKissOfFrostId, oilLeechId, oilHeartseekerId, oilPlagueId, oilPoisonId,

        weaponOilDemiseAnimalId, weaponOilDemiseMonsterId, weaponOilDemiseLegendaryId, weaponOilDemiseHumanId, weaponOilLickOfFireId,
        weaponOilKissOfFrostId, weaponOilLeechId, weaponOilHeartseekerId, weaponOilPlagueId, weaponOilPoisonId;

    public static ItemTemplate

        pasteDemiseAnimal, pasteDemiseMonster, pasteDemiseLegendary, pasteDemiseHuman, pasteLickOfFire,
        pasteKissOfFrost, pasteLeech, pasteHeartseeker, pastePlague, pastePoison,
        sludgeDemiseAnimal, sludgeDemiseMonster, sludgeDemiseLegendary, sludgeDemiseHuman, sludgeLickOfFire,

        sludgeKissOfFrost, sludgeLeech, sludgeHeartseeker, sludgePlague, sludgePoison,
        oilDemiseAnimal, oilDemiseMonster, oilDemiseLegendary, oilDemiseHuman, oilLickOfFire,
        oilKissOfFrost, oilLeech, oilHeartseeker, oilPlague, oilPoison,

        weaponOilDemiseAnimal, weaponOilDemiseMonster, weaponOilDemiseLegendary, weaponOilDemiseHuman, weaponOilLickOfFire,
        weaponOilKissOfFrost, weaponOilLeech, weaponOilHeartseeker, weaponOilPlague, weaponOilPoison;

    private static void registerPasteDemiseAnimal() throws IOException {
        pasteDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.pasteDemiseAnimal")
                .name(" paste of the Hunter", "pastes of the Hunter",
                        "A paste that smells of death. Rubbing it on a piece animal flesh it seems to dissolve it. " +
                                " You sense this could be turned into a coating for weapons."+
                                " Due to its fresh ingredients it should be processed quickly."
                )

                .modelName("model.paste.animal.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //	ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*40) // no hard lock
                .build();

        pasteDemiseAnimalId = pasteDemiseAnimal.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureGoatId, ItemList.tallow,	pasteDemiseAnimalId, true, true, 0f, true, false, 0,30,CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.eye, 1, true));

    }


    private static void registerPasteDemiseMonster() throws IOException {
        pasteDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.pasteDemiseMonster")
                .name(" paste of the Monster Hunter", "pastes of the Monster Hunter",
                        "A paste that smells of death. Rubbing it on a piece monster flesh it seems to dissolve it. " +
                                " Yet your own skin is safe. You sense this could be turned into a coating for weapons."
                                +" Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.monster.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*60) // no hard lock
                .build();

        pasteDemiseMonsterId = pasteDemiseMonster.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureGoatId, ItemList.tallow,	pasteDemiseMonsterId, true, true, 0f, true, false,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.gland, 1, true));

    }
    private static void registerPasteDemiseLegendary() throws IOException {
        pasteDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.pasteDemiseLegendary")
                .name(" paste of the Dragon Hunter", "pastes of the Dragon Hunter",
                        "A paste that smells of death. You find that it doesn't disslolve any flesh you know " +
                                "not even your own. Maybe you should test it on Dragons or so? " +
                                "You sense this could be turned into a coating for weapons."
                                +" Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.legendary.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //	ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*70) // no hard lock
                .build();

        pasteDemiseLegendaryId = pasteDemiseLegendary.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureGoatId, ItemList.tallow,	pasteDemiseLegendaryId, true, true, 0f, true, false,0,50, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.blood, 1, true));

    }

    private static void registerPasteDemiseHuman() throws IOException {
        pasteDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.pasteDemiseHuman")
                .name(" paste of the Murderer", "pastes of the Murderer",
                        "A paste that smells of death. You find that it dissolves your own flesh easily, " +
                                "but doesn't harm animal flesh. Weird. " +
                                "You sense this could be turned into a coating for weapons."
                                +" Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.human.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        pasteDemiseHumanId = pasteDemiseHuman.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureGoatId, ItemList.tallow,	pasteDemiseHumanId, true, true, 0f, true, false,0,35, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.meat, 1, true));

    }

    private static void registerPasteLickOfFire() throws IOException {
        pasteLickOfFire = new ItemTemplateBuilder("arathok.alchemy.pasteFire")
                .name(" paste of lick of fire", "pastes of lick of fire",
                        "A paste that smells sulphury. It develops extreme heat on any surface it touches. " +
                                "You sense this could be turned into a coating for weapons."
                                +" Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.kissOfFire.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //	ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        pasteLickOfFireId = pasteLickOfFire.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureFranticChargeId, ItemList.tallow,	pasteLickOfFireId, true, true, 0f, true, false,0,40, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.charcoal, 1, true));

    }

    private static void registerPasteKissOfFrost() throws IOException {
        pasteKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.pasteFrost")
                .name(" paste of Kiss of Frost", "pastes of Kiss of Frost",
                        "A paste that is cool to the touch. It freezes any surface it touches. " +
                                "You sense this could be turned into a coating for weapons. "
                                +"Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.kissOfFire.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        pasteKissOfFrostId = pasteKissOfFrost.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureFranticChargeId, ItemList.tallow,	pasteKissOfFrostId, true, true, 0f, true, false,0,40, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.snowball, 1, true));

    }

    private static void registerPasteLech() throws IOException {
        pasteLeech = new ItemTemplateBuilder("arathok.alchemy.pasteLeech")
                .name(" paste of Leech", "pastes of Leech",
                        "An ominous paste. Smearing it upon a plant makes the plant wilt, but upon touching " +
                                "the paste on the plant you feel more vigorous. " +
                                "You sense this could be turned into a coating for weapons. "
                                +"Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.Leech.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        pasteLeechId = pasteLeech.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureHealId, ItemList.tallow,	pasteLeechId, true, false, 0f, true, false,0,50, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.snowball, 1, true));

    }

    private static void registerPastePlague() throws IOException {
        pastePlague = new ItemTemplateBuilder("arathok.alchemy.pastePlague")
                .name(" paste of the Plague", "pastes of Plague",
                        "A forbidden paste. Smearing it upon anything makes it age and rot. Very Dangerous. " +
                                "You sense this could be turned into a coating for weapons. "
                                +"Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.plague.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*70) // no hard lock
                .build();

        pastePlagueId = pastePlague.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureMorningFogId, ItemList.tallow,	pastePlagueId, true, true, 0f, true, false,0,50, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.lemon, 1, true));

    }

    private static void registerPasteHeartseeker() throws IOException {
        pasteHeartseeker = new ItemTemplateBuilder("arathok.alchemy.pasteHeartseeker")
                .name(" paste of the Heartseeker", "pastes of the Heartseeker",
                        "An ominous paste. Smearing it upon your hand makes it always want to grab on what you" +
                                " are focusing. " +
                                "You sense this could be turned into a coating for weapons. "
                                +"Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.Heartseeker.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        pasteHeartseekerId = pasteHeartseeker.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureExcellId, ItemList.tallow,	pasteHeartseekerId, true, true, 0f, true, false,0,35, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.heart, 1, true));

    }

    private static void registerPastePoison() throws IOException {
        pastePoison = new ItemTemplateBuilder("arathok.alchemy.pastePoison")
                .name(" paste of the Snake", "pastes of the Snake",
                        "A forbidden paste. Smearing it upon your hand makes your body temperature rise in an" +
                                " instant, your veins turn blackish. " +
                                "You sense this could be turned into a coating for weapons. "
                                +"Due to its fresh ingredients it should be processed quickly.")

                .modelName("model.paste.poison.")
                .imageNumber(PotionItems.pasteIcon)
                .itemTypes(new short[] {
                        //ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(14400L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        pastePoisonId = pastePoison.getTemplateId();
        CreationEntryCreator
                .createAdvancedEntry(Config.skillUsed, PotionItems.mixtureHealId, ItemList.tallow,	pastePoisonId, true, true, 0f, true, false,0,50, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.heart, 1, true));

    }
    /// Oil Precursors / Sludges
    private static void registerPrecursorDemiseAnimal() throws IOException {
        sludgeDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseAnimal")
                .name(" sludge of the Hunter", "sludges of the Hunter",
                        "A sludge that smells of death. Rubbing it on a piece animal flesh it seems to dissolve it. " +
                                "You sense this could be turned into a coating for weapons. ")

                .modelName("model.sludge.animal.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,


                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*40) // no hard lock
                .build();

        sludgeDemiseAnimalId = sludgeDemiseAnimal.getTemplateId();
        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId, OilItems.pasteDemiseAnimalId, sludgeDemiseAnimalId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }


    private static void registerPrecursorDemiseMonster() throws IOException {
        sludgeDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseMonster")
                .name(" sludge of the Monster Hunter", "sludges of the Monster Hunter",
                        "A sludge that smells of death. Rubbing it on a piece monster flesh it seems to dissolve it. " +
                                "Yet your own skin is safe. You sense this could be turned into a coating for weapons. ")

                .modelName("model.sludge.monster.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*60) // no hard lock
                .build();

        sludgeDemiseMonsterId = sludgeDemiseMonster.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId, OilItems.pasteDemiseMonsterId,  sludgeDemiseMonsterId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }
    private static void registerPrecursorDemiseLegendary() throws IOException {
        sludgeDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseLegendary")
                .name(" sludge of the Dragon Hunter", "sludges of the Dragon Hunter",
                        "A sludge that smells of death. You find that it doesn't disslolve any flesh you know " +
                                "not even your own. Maybe you should test it on Dragons or so? " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.legendary.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*70) // no hard lock
                .build();

        sludgeDemiseLegendaryId = sludgeDemiseLegendary.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId,	OilItems.pasteDemiseLegendaryId, sludgeDemiseLegendaryId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorDemiseHuman() throws IOException {
        sludgeDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseHuman")
                .name(" sludge of the Murderer", "sludges of the Murderer",
                        "A sludge that smells of death. You find that it dissolves your own flesh easily, " +
                                "but doesn't harm animal flesh. Weird. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.human.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        sludgeDemiseHumanId = sludgeDemiseHuman.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId, OilItems.pasteDemiseHumanId, sludgeDemiseHumanId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorLickOfFire() throws IOException {
        sludgeLickOfFire = new ItemTemplateBuilder("arathok.alchemy.sludgeFire")
                .name(" sludge of lick of fire", "sludges of lick of fire",
                        "A sludge that smells sulphury. It develops extreme heat on any surface it touches. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.kissOfFire.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        sludgeLickOfFireId = sludgeLickOfFire.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId,	OilItems.pasteLickOfFireId, sludgeLickOfFireId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorKissOfFrost() throws IOException {
        sludgeKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.sludgeFrost")
                .name(" sludge of Kiss of Frost", "sludges of Kiss of Frost",
                        "A sludge that is cool to the touch. It freezes any surface it touches. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.kissOfFrost.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        sludgeKissOfFrostId = sludgeKissOfFrost.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId,	OilItems.pasteKissOfFrostId, sludgeKissOfFrostId, true, true, 0f, false,true,0,30.0, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorLech() throws IOException {
        sludgeLeech = new ItemTemplateBuilder("arathok.alchemy.sludgeLeech")
                .name(" sludge of Leech", "sludges of Leech",
                        "An ominous sludge. Smearing it upon a plant makes the plant wilt, but upon touching " +
                                "the sludge on the plant you feel more vigorous. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.Leech.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        sludgeLeechId = sludgeLeech.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId, OilItems.pasteLeechId,  sludgeLeechId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorPlague() throws IOException {
        sludgePlague = new ItemTemplateBuilder("arathok.alchemy.sludgePlague")
                .name(" sludge of the Plague", "sludges of Plague",
                        "A forbidden sludge. Smearing it upon anything makes it age and rot. Very Dangerous. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.plague.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*70) // no hard lock
                .build();

        sludgePlagueId = sludgePlague.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId,OilItems.pastePlagueId, 	sludgePlagueId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorHeartseeker() throws IOException {
        sludgeHeartseeker = new ItemTemplateBuilder("arathok.alchemy.sludgeHeartseeker")
                .name(" sludge of the Heartseeker", "sludges of the Heartseeker",
                        "An ominous sludge. Smearing it upon your hand makes it always want to grab on what you" +
                                " are focusing. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.Heartseeker.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        sludgeHeartseekerId = sludgeHeartseeker.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId,OilItems.pasteHeartseekerId, 	sludgeHeartseekerId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }

    private static void registerPrecursorPoison() throws IOException {
        sludgePoison = new ItemTemplateBuilder("arathok.alchemy.sludgePoison")
                .name(" sludge of the Snake", "sludges of the Snake",
                        "A forbidden sludge. Smearing it upon your hand makes your body temperature rise in an" +
                                " instant, your veins turn blackish. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.sludge.poison.")
                .imageNumber(PotionItems.sludgeIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        sludgePoisonId = sludgePoison.getTemplateId();
        CreationEntryCreator
                .createSimpleEntry(Config.skillUsed, AlchItems.alchemicalCompoundId,OilItems.pastePoisonId, 	sludgePoisonId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


    }
// OILS

    private static void registerOilDemiseAnimal() throws IOException {
        oilDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.oilDemiseAnimal")
                .name(" oil of the Hunter", "oils of the Hunter",
                        "An oil that smells of death. Rubbing it on a piece animal flesh it seems to dissolve it. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.animal.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,


                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*40) // no hard lock
                .build();

        oilDemiseAnimalId = oilDemiseAnimal.getTemplateId();

    }


    private static void registeroilDemiseMonster() throws IOException {
        oilDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.oilDemiseMonster")
                .name(" oil of the Monster Hunter", "oils of the Monster Hunter",
                        "An oil that smells of death. Rubbing it on a piece monster flesh it seems to dissolve it. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.monster.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*60) // no hard lock
                .build();

        oilDemiseMonsterId = oilDemiseMonster.getTemplateId();

    }
    private static void registeroilDemiseLegendary() throws IOException {
        oilDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.oilDemiseLegendary")
                .name(" oil of Legendarys Demise", "oils of Legendarys Demise",
                        "An oil that smells of death. You find that it doesn't dissolve any flesh you know not even your own. Maybe you should test it on Dragons or so? " +
                                "It needs to be filled into a crystalline phial to unfold its magical potential as a weapon oil.")

                .modelName("model.oil.legendary.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*70) // no hard lock
                .build();

        oilDemiseLegendaryId = oilDemiseLegendary.getTemplateId();

    }

    private static void registeroilDemiseHuman() throws IOException {
        oilDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.oilDemiseHuman")
                .name(" oil of Human Demise", "oils of Human Demise",
                        "An oil that smells of death. You find that it dissolves your own flesh easily, but doesn't harm animal flesh. Weird. " +
                                "It needs to be filled into a crystalline phial to unfold its magical potential as a weapon oil.")

                .modelName("model.oil.human.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        oilDemiseHumanId = oilDemiseHuman.getTemplateId();

    }

    private static void registeroilLickOfFire() throws IOException {
        oilLickOfFire = new ItemTemplateBuilder("arathok.alchemy.oilFire")
                .name(" oil of lick of fire", "oils of lick of fire",
                        "An oil that smells sulphury. It develops extreme heat on any surface fit touches. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.kissOfFire.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        oilLickOfFireId = oilLickOfFire.getTemplateId();

    }

    private static void registeroilKissOfFrost() throws IOException {
        oilKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.oilFrost")
                .name(" oil of Kiss of Frost", "oils of Kiss of Frost",
                        "An oil that is cool to the touch. It freezes any surface it touches. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.kissOfFire.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        oilKissOfFrostId = oilKissOfFrost.getTemplateId();

    }

    private static void registeroilLech() throws IOException {
        oilLeech = new ItemTemplateBuilder("arathok.alchemy.oilLeech")
                .name(" oil of Leech", "oils of Leech",
                        "An ominous oil. Smearing it upon a plant makes the plant wilt, but upon touching the oil on the plant you feel more vigorous. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.Heartseeker.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        oilLeechId = oilLeech.getTemplateId();

    }

    private static void registeroilPlague() throws IOException {
        oilPlague = new ItemTemplateBuilder("arathok.alchemy.oilPlague")
                .name(" oil of the Plague", "oils of Plague",
                        "A forbidden oil. Smearing it upon anything makes it age and rot. Very Dangerous. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.plague.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*70) // no hard lock
                .build();

        oilPlagueId = oilPlague.getTemplateId();

    }

    private static void registeroilHeartseeker() throws IOException {
        oilHeartseeker = new ItemTemplateBuilder("arathok.alchemy.oilHeartseeker")
                .name(" oil of Heartseeker", "oils of Heartseeker",
                        "An ominous oil. Smearing it upon your hand makes it always want to go on what you are focusing. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.Heartseeker.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        oilHeartseekerId = oilHeartseeker.getTemplateId();

    }

    private static void registeroilPoison() throws IOException {
        oilPoison = new ItemTemplateBuilder("arathok.alchemy.oilPoison")
                .name(" oil of Poison", "oils of Poison",
                        "A forbidden oil. Smearing it upon your hand makes your body temperature rise in an instant, your veins turn blackish. " +
                                "You sense this could be turned into a coating for weapons.")

                .modelName("model.oil.poison.")
                .imageNumber(PotionItems.weaponOilLiquidIcon)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_LIQUID,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                })
                .decayTime(691200L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*50) // no hard lock
                .build();

        oilPoisonId = oilPoison.getTemplateId();
/// WEAPONOILS
    }
    private static void registerweaponOilDemiseAnimal() throws IOException {
        weaponOilDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.weaponoilAnimal")
                .name(" Weapon oil of the Hunter", "Weapon Oils of the Hunter",
                        "An alchemistic weapon oil. It will make your weapons more proficient against animals.")

                .modelName("model.WeaponOil.Hunter.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilDemiseAnimalId = weaponOilDemiseAnimal.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilDemiseAnimalId, weaponOilDemiseAnimalId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilDemiseHuman() throws IOException {
        weaponOilDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.weaponoilHuman")
                .name(" Weapon oil of the Murderer", "Weapon Oils of the Murderer",
                        "An alchemistic weapon oil. It will make your weapons more proficient against other humans.")

                .modelName("model.WeaponOil.Hunter.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilDemiseHumanId = weaponOilDemiseHuman.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilDemiseHumanId, weaponOilDemiseHumanId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilDemiseMonster() throws IOException {
        weaponOilDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.weaponoilMonster")
                .name(" Weapon oil of the Monster Hunter", "Weapon oils of the Monster Hunter",
                        "An alchemistic weapon oil. It will make your weapons more proficient against monsters.")

                .modelName("model.WeaponOil.Monster.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilDemiseMonsterId = weaponOilDemiseMonster.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilDemiseMonsterId, weaponOilDemiseMonsterId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilDemiseLegendary() throws IOException {
        weaponOilDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.weaponoilDragon")
                .name(" Weapon oil of the Dragon Hunter", "Weapon Oils of Dragon Hunter",
                        "An alchemistic weapon oil. It will make your weapons more proficient against legendary monsters")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilDemiseLegendaryId = weaponOilDemiseLegendary.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilDemiseLegendaryId, weaponOilDemiseLegendaryId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilHeartseeker() throws IOException {
        weaponOilHeartseeker = new ItemTemplateBuilder("arathok.alchemy.weaponoilHeartseeker")
                .name(" Weapon oil of the Heartseeker", "Weapon Oils of the Heartseeker",
                        "An alchemistic weapon oil. It will make your weapons cut critical wounds.")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilHeartseekerId = weaponOilHeartseeker.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilHeartseekerId, weaponOilHeartseekerId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilKissOfFrost() throws IOException {
        weaponOilKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.weaponoilFrost")
                .name(" Frostkiss Weapon oil ", "Weapon oils of Frostkiss",
                        "An alchemistic weapon oil. It will make your weapons cause frostbite.")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilKissOfFrostId = weaponOilKissOfFrost.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilKissOfFrostId, weaponOilKissOfFrostId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilLickOfFire() throws IOException {
        weaponOilLickOfFire = new ItemTemplateBuilder("arathok.alchemy.weaponoilFire")
                .name(" Lick of Fire oil", "Weapon Oils of Lick of Fire",
                        "An An alchemistic weapon oil. It will make your weapons cause burns.")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilLickOfFireId = weaponOilLickOfFire.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilLickOfFireId, weaponOilLickOfFireId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilPoison() throws IOException {
        weaponOilPoison = new ItemTemplateBuilder("arathok.alchemy.weaponoilPoison")
                .name(" Weapon oil of the Snake", "Weapon Oils of the Snake",
                        "An alchemistic weapon oil. It will make your weapons poison enemies.")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilPoisonId = weaponOilPoison.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilPoisonId, weaponOilPoisonId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilPlague() throws IOException {
        weaponOilPlague = new ItemTemplateBuilder("arathok.alchemy.weaponoilPlague")
                .name(" Weapon oil of the Plague", "Weapon Oils of Plague",
                        "An alchemistic weapon oil. It will make your weapons cause infected wounds.")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilPlagueId = weaponOilPlague.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilPlagueId, weaponOilPlagueId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    private static void registerweaponOilLeech() throws IOException {
        weaponOilLeech = new ItemTemplateBuilder("arathok.alchemy.weaponoilLeech")
                .name(" Weapon oil of the Leech", "Weapon Oils of Leech",
                        "An alchemistic weapon oil. It will make your weapons draw an enemies life force.")

                .modelName("model.WeaponOil.")
                .imageNumber(PotionItems.weaponOilIcon)
                .itemTypes(new short[] {
                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_HERB,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,

                })
                .decayTime(2073600L)
                .dimensions(5, 5, 10)
                .weightGrams(200)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(Config.skillUsed)
                .difficulty(Config.baseDifficulty*30) // no hard lock
                .build();

        weaponOilLeechId = weaponOilLeech.getTemplateId();

        CreationEntryCreator.createSimpleEntry(Config.skillUsed, AlchItems.phialId,OilItems.oilLeechId, weaponOilLeechId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
    }

    public static void register() throws IOException {
        if (Config.useOils) {

            registerPasteHeartseeker();
            registerPasteLech();
            registerPasteDemiseHuman();
            registerPasteDemiseLegendary();
            registerPasteDemiseMonster();
            registerPasteDemiseAnimal();
            registerPasteKissOfFrost();
            registerPasteLickOfFire();
            registerPastePlague();
            registerPastePoison();

            registerPrecursorHeartseeker();
            registerPrecursorLech();
            registerPrecursorDemiseHuman();
            registerPrecursorDemiseAnimal();
            registerPrecursorDemiseLegendary();
            registerPrecursorDemiseMonster();
            registerPrecursorKissOfFrost();
            registerPrecursorLickOfFire();
            registerPrecursorPlague();
            registerPrecursorPoison();

            registeroilDemiseHuman();
            registeroilDemiseLegendary();
            registeroilDemiseMonster();
            registerOilDemiseAnimal();
            registeroilHeartseeker();
            registeroilKissOfFrost();
            registeroilLech();
            registeroilLickOfFire();
            registeroilPlague();
            registeroilPoison();


            registerweaponOilDemiseHuman();
            registerweaponOilDemiseLegendary();
            registerweaponOilDemiseMonster();
            registerweaponOilDemiseAnimal();
            registerweaponOilHeartseeker();
            registerweaponOilKissOfFrost();
            registerweaponOilLeech();
            registerweaponOilLickOfFire();
            registerweaponOilPlague();
            registerweaponOilPoison();


            TempStates.addState(new TempState(OilItems.sludgeHeartseekerId, OilItems.oilHeartseekerId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeLeechId, OilItems.oilLeechId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgePlagueId, OilItems.oilPlagueId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgePoisonId, OilItems.oilPoisonId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeDemiseAnimalId, OilItems.oilDemiseAnimalId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeDemiseHumanId, OilItems.oilDemiseHumanId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeDemiseMonsterId, OilItems.oilDemiseMonsterId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeDemiseLegendaryId, OilItems.oilDemiseLegendaryId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeLickOfFireId, OilItems.oilLickOfFireId, (short) 4000, true, true, false));
            TempStates.addState(new TempState(OilItems.sludgeKissOfFrostId, OilItems.oilKissOfFrostId, (short) 4000, true, true, false));

        }
    }

}
