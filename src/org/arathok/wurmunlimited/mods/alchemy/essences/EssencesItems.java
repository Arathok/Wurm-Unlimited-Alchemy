package org.arathok.wurmunlimited.mods.alchemy.essences;

import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import java.io.IOException;

public class EssencesItems {

    public static int
        vitriolId,stoneCoreId, sandCoreId,slateCoreId,marbleCoreId,ironCoreId, zincCoreId,tinCoreId,leadCoreId,copperCoreId,silverCoreId,goldCoreId,adamantineCoreId,seryllCoreId,glimmerCoreId,
    // Core becomes available at:
    //                 20         30,                               40,            50,                                          60,          70,         80,              90,          95
        acidicEssenceId,sandEssenceId,slateEssenceId,marbleEssenceId,ironEssenceId,zincEssenceId,tinEssenceId,leadEssenceId,copperEssenceId,silverEssenceId,goldEssenceId,admantineEssenceId,seryllEssenceId,glimmerEssenceId,
        acidicExtractId, sandExtractId,slateExtractId,marbleExtractId,ironExtractId,zincExtractId,tinExtractId,leadExtractId,copperExtractId,silverExtractId,goldExtractId,adamantineExtractId,seryllExtractId,glimmerExtractId,
        activatedAcidicExtractId, activatedSandExtractId,activatedSlateExtractId,activatedMarbleExtractId,activatedIronExtractId,activatedZincExtractId,activatedTinExtractId,activatedLeadExtractId,activatedCopperExtractId,activatedSilverExtractId,activatedGoldExtractId,activatedAdamantineExtractId,activatedSeryllExtractId,activatedGlimmerExtractId;
    public static ItemTemplate
        vitriol,stoneCore, sandCore,slateCore,marbleCore,ironCore, zincCore,tinCore,leadCore,copperCore,silverCore,goldCore,adamantineCore,seryllCore,glimmerCore,
        acidicEssence, sandEssence,slateEssence,marbleEssence,ironEssence,zincEssence,tinEssence,leadEssence,copperEssence,silverEssence,goldEssence,admantineEssence,seryllEssence,glimmerEssence,
        acidicExtract, sandExtract,slateExtract,marbleExtract,ironExtract,zincExtract,tinExtract,leadExtract,copperExtract,silverExtract,goldExtract,adamantineExtract,seryllExtract,glimmerExtract,
        activatedAcidicExtract, activatedSandExtract,activatedSlateExtract,activatedMarbleExtract,activatedIronExtract,activatedZincExtract,activatedTinExtract,activatedLeadExtract,activatedCopperExtract,activatedSilverExtract,activatedGoldExtract,activatedAdamantineExtract,activatedSeryllExtract,activatedGlimmerExtract;

    private static void registerStoneCore() throws IOException {
        stoneCore = new ItemTemplateBuilder("arathok.alchemy.stoneCore")
                .name("Stone Core", "Stone Cores",
                        "A rock that is special somehow. In it you can still hear the beating heart of a mountain.")
                .modelName("model.alchemy.stoneCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_STONE)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        stoneCoreId = stoneCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.rock,ItemList.heart, stoneCoreId, true, true, 0.0f, true, true,0,20, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.rock,4,true));


    }

    private static void registerVitriol() throws IOException {
        vitriol = new ItemTemplateBuilder("arathok.alchemy.vitriol")
                .name("vitriol", "vitriol",
                        "A green crystal with highly acidic properties. Made from iron rocks charcoal and lye")
                .modelName("model.alchemy.vitriol.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        vitriolId = vitriol.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.lowQlIron,ItemList.lye, vitriolId, true, true, 0.0f, true, false,0,20, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.charcoal,1,true));


    }

    private static void registerAcidEssence() throws IOException {
        acidicEssence = new ItemTemplateBuilder("arathok.alchemy.acidEssence")
                .name("acid essence", "acid essences",
                        "A milky liquid that has some corrosive properties. Maybe Distilling it will give it even better corrosive properties, but who would want that? ")
                .modelName("model.alchemy.acidEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        acidicEssenceId = acidicEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,ItemList.gland, acidicEssenceId, true, true, 0.0f, true, false,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.fruitJuice,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }

    private static void registerAcidExtract() throws IOException {
        acidicExtract = new ItemTemplateBuilder("arathok.alchemy.acidExtract")
                .name("acid extract", "acid extracts",
                        "A liquid that has strong corrosive properties. Can be used to reduce any ore vein / reinforced cave wall to rock or destroy a rock wall.")
                .modelName("model.alchemy.acidExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        acidicExtractId = acidicExtract.getTemplateId();

    }

    private static void registerSandCore() throws IOException {
        sandCore = new ItemTemplateBuilder("arathok.alchemy.sandCore")
                .name("sand core", "sand cores",
                        "A yellowy rock that has somehow contained the essence of sand. Maybe you can use its slumbering power in some alchemic brew?")
                .modelName("model.alchemy.sandCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_SANDSTONE)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        sandCoreId = sandCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, stoneCoreId,ItemList.sandstone, sandCoreId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.sandstone,4,true));


    }

    private static void registerSandEssence() throws IOException {
        sandEssence = new ItemTemplateBuilder("arathok.alchemy.sandEssence")
                .name("sand essence", "sand essences",
                        "A milky liquid that has some abrasive properties. Maybe Distilling it will give it even better abrasive properties, but who would want that? ")
                .modelName("model.alchemy.sandEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        sandEssenceId = sandEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,sandCoreId, sandEssenceId, true, true, 0.0f, true, false,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.salt,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }

    private static void registerSandExtract() throws IOException {
        sandExtract = new ItemTemplateBuilder("arathok.alchemy.sandExtract")
                .name("sand extract", "sand extracts",
                        "A liquid that has strong abrasive properties. Can be used to reduce any ore vein to sand stone or create a sandstone vein from rock.")
                .modelName("model.alchemy.sandExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_SANDSTONE)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        sandExtractId = sandExtract.getTemplateId();

    }

    private static void registerslateCore() throws IOException {
        slateCore = new ItemTemplateBuilder("arathok.alchemy.slateCore")
                .name("slate core", "slate cores",
                        "A dark rock that has somehow contained the essence of slate. Maybe you can use its slumbering power in some alchemic brew?")
                .modelName("model.alchemy.slateCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_SLATE)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        slateCoreId = slateCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, stoneCoreId,ItemList.slateShard, slateCoreId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.slateShard,4,true));


    }

    private static void registerslateEssence() throws IOException {
        slateEssence = new ItemTemplateBuilder("arathok.alchemy.slateEssence")
                .name("slate essence", "slate essences",
                        "A milky liquid that has some black dying properties. Maybe Distilling it will give it even better properties, but who would want that? ")
                .modelName("model.alchemy.slateEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        slateEssenceId = slateEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,slateCoreId, slateEssenceId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.salt,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }

    private static void registerslateExtract() throws IOException {
        slateExtract = new ItemTemplateBuilder("arathok.alchemy.slateExtract")
                .name("slate extract", "slate extracts",
                        "A liquid that has strong dark properties. Can be used to reduce any ore vein to slate or create a slate vein from rock.")
                .modelName("model.alchemy.slateExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_SLATE)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        slateExtractId = slateExtract.getTemplateId();

    }

    private static void registermarbleCore() throws IOException {
        marbleCore = new ItemTemplateBuilder("arathok.alchemy.marbleCore")
                .name("marble core", "marble cores",
                        "A bright rock that has somehow contained the essence of marble. Maybe you can use its slumbering power in some alchemic brew?")
                .modelName("model.alchemy.marbleCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_MARBLE)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        marbleCoreId = marbleCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, stoneCoreId,ItemList.marbleShard, marbleCoreId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.marbleShard,4,true));


    }

    private static void registermarbleEssence() throws IOException {
        marbleEssence = new ItemTemplateBuilder("arathok.alchemy.marbleEssence")
                .name("marble essence", "marble essences",
                        "A milky liquid that has some white dying properties. Maybe Distilling it will give it even better properties, but who would want that? ")
                .modelName("model.alchemy.marbleEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        marbleEssenceId = marbleEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,marbleCoreId, marbleEssenceId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.salt,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }

    private static void registermarbleExtract() throws IOException {
        marbleExtract = new ItemTemplateBuilder("arathok.alchemy.marbleExtract")
                .name("marble extract", "marble extracts",
                        "A liquid that has strong light properties. Can be used to reduce any ore vein to marble or create a marble vein from rock.")
                .modelName("model.alchemy.marbleExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_COAL)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        marbleExtractId = marbleExtract.getTemplateId();

    }

    private static void registerironCore() throws IOException {
        ironCore = new ItemTemplateBuilder("arathok.alchemy.ironCore")
                .name("iron core", "iron cores",
                        "A rock that has somehow contained the essence of iron. Maybe you can use its slumbering power in some alchemic brew?")
                .modelName("model.alchemy.ironCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_IRON)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        ironCoreId = ironCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, stoneCoreId,ItemList.ironBar, ironCoreId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.ironBar,99,true));


    }

    private static void registerironEssence() throws IOException {
        ironEssence = new ItemTemplateBuilder("arathok.alchemy.ironEssence")
                .name("iron essence", "iron essences",
                        "A milky liquid that has magnetic properties. Maybe Distilling it will give it even better properties, but who would want that? ")
                .modelName("model.alchemy.ironEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        ironEssenceId = ironEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,ironCoreId, ironEssenceId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.salt,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }

    private static void registerironExtract() throws IOException {
        ironExtract = new ItemTemplateBuilder("arathok.alchemy.ironExtract")
                .name("iron extract", "iron extracts",
                        "A liquid that has strong magnetic metallic properties. Can be used to reduce any ore vein to iron or create a iron vein from rock.")
                .modelName("model.alchemy.ironExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_IRON)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        ironExtractId = ironExtract.getTemplateId();

    }
    private static void registertinCore() throws IOException {
        tinCore = new ItemTemplateBuilder("arathok.alchemy.tinCore")
                .name("tin core", "tin cores",
                        "A rock that has somehow contained the essence of tin. Maybe you can use its slumbering power in some alchemic brew?")
                .modelName("model.alchemy.tinCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_TIN)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        tinCoreId = tinCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, stoneCoreId,ItemList.tinBar, tinCoreId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.tinBar,99,true));


    }

    private static void registertinEssence() throws IOException {
        tinEssence = new ItemTemplateBuilder("arathok.alchemy.tinEssence")
                .name("tin essence", "tin essences",
                        "A milky liquid that has vey lightweight but not so durable properties. Maybe Distilling it will give it even better properties, but who would want that? ")
                .modelName("model.alchemy.tinEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        tinEssenceId = tinEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,tinCoreId, tinEssenceId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.salt,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }
/*
    private static void registertinExtract() throws IOException {
        tinExtract = new ItemTemplateBuilder("arathok.alchemy.tinExtract")
                .name("tin extract", "tin extracts",
                        "A liquid that has strong leightweight but also weak structural properties. Can be used to reduce any ore vein to tin or create a tin vein from rock.")
                .modelName("model.alchemy.tinExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_TIN)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        tinExtractId = tinExtract.getTemplateId();

    }

    private static void registertinCore() throws IOException {
        tinCore = new ItemTemplateBuilder("arathok.alchemy.tinCore")
                .name("tin core", "tin cores",
                        "A yellowy rock that has somehow contained the essence of tin. Maybe you can use its slumbering power in some alchemic brew?")
                .modelName("model.alchemy.tinCore.")
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DECORATION,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 5)
                .weightGrams(100000)
                .material(Materials.MATERIAL_TIN)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(20) // no hard lock
                .build();

        tinCoreId = tinCore.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, stoneCoreId,ItemList.tinOre, tinCoreId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.tinOre,4,true));


    }

    private static void registertinEssence() throws IOException {
        tinEssence = new ItemTemplateBuilder("arathok.alchemy.tinEssence")
                .name("tin essence", "tin essences",
                        "A milky liquid that has vey lightweight but not so durable properties. Maybe Distilling it will give it even better properties, but who would want that? ")
                .modelName("model.alchemy.tinEssence.")
                .imageNumber((short) IconConstants.ICON_FOOD_STEW)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_USES_FOOD_STATE,
                        ItemTypes.ITEM_TYPE_FERMENTED,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,

                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(99) // no hard lock
                .build();

        tinEssenceId = tinEssence.getTemplateId();
        CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.water,tinCoreId, tinEssenceId, true, true, 0.0f, true, true,0,30, CreationCategories.ALCHEMY)
                .addRequirement(new CreationRequirement(1, ItemList.salt,1,true))
                .addRequirement(new CreationRequirement(2, vitriolId,1,true));
    }

    private static void registertinExtract() throws IOException {
        tinExtract = new ItemTemplateBuilder("arathok.alchemy.tinExtract")
                .name("tin extract", "tin extracts",
                        "A liquid that has strong leightweight but also weak structural properties. Can be used to reduce any ore vein to tin or create a tin vein from rock.")
                .modelName("model.alchemy.tinExtract.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DISHWATER)
                .itemTypes(new short[] {

                        ItemTypes.ITEM_TYPE_BULK,
                        ItemTypes.ITEM_TYPE_NO_IMPROVE,
                        ItemTypes.ITEM_TYPE_DISTILLED,
                        ItemTypes.ITEM_TYPE_LIQUID,


                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(1000)
                .material(Materials.MATERIAL_TIN)
                .behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
                .build();

        tinExtractId = tinExtract.getTemplateId();

    }*/
}


