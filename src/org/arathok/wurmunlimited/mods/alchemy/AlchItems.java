package org.arathok.wurmunlimited.mods.alchemy; // now add calls to registerBlah in onItemTemplatesCreated
///TODO:mixtures/pastes no bulk and they decay
//and make them not-private so you can actually access them
import java.io.IOException;

import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import com.wurmonline.server.items.CreationCategories;
import com.wurmonline.server.items.CreationEntryCreator;
import com.wurmonline.server.items.CreationRequirement;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.Materials;
import com.wurmonline.server.items.TempState;
import com.wurmonline.server.items.TempStates;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;

// WAIT WHATS HAPPENING?!
public class AlchItems {
	public static int
			leaderId, phialId, mouldClayId, mouldPotteryId, purifiedWaterId, alchemicalCompoundId,
			glassMixtureId, glassId,

			mixtureHealId, mixtureGoatId, mixtureExcellId, mixtureOakshellId, mixtureMorningFogId,
			mixtureFranticChargeId, mixtureStrengthId, mixtureSixthSenseId, mixtureTruehitId, mixtureWillowspineId,
			mixtureRefreshId, mixtureVynoraId,

			precursorHealId, precursorGoatId, precursorExcellId, precursorOakshellId, precursorMorningFogId,
			precursorFranticChargeId, precursorStrengthId, precursorSixthSenseId, precursorTruehitId,
			precursorWillowspineId, precursorRefreshId, precursorVynoraId,

			potionLiquidHealId, potionLiquidGoatId, potionLiquidExcellId, potionLiquidOakshellId,
			potionLiquidMorningFogId, potionLiquidFranticChargeId, potionLiquidStrengthId, potionLiquidSixthSenseId,
			potionLiquidTruehitId, potionLiquidWillowspineId, potionLiquidRefreshId, potionLiquidVynoraId,

			potionIdHeal, potionIdGoat, potionIdExcell, potionIdOakshell, potionIdMorningFog, potionIdFranticCharge,
			potionIdStrength, potionIdSixthSense, potionIdTruehit, potionIdWillowspine, potionIdRefresh, potionIdVynora,

			pasteDemiseAnimalId, pasteDemiseMonsterId, pasteDemiseLegendaryId, pasteDemiseHumanId, pasteLickOfFireId,
			pasteKissOfFrostId, pasteLeechId, pasteHeartseekerId, pastePlagueId, pastePoisonId,

			sludgeDemiseAnimalId, sludgeDemiseMonsterId, sludgeDemiseLegendaryId, sludgeDemiseHumanId, sludgeLickOfFireId,
			sludgeKissOfFrostId, sludgeLeechId, sludgeHeartseekerId, sludgePlagueId, sludgePoisonId,

			oilDemiseAnimalId, oilDemiseMonsterId, oilDemiseLegendaryId, oilDemiseHumanId, oilLickOfFireId,
			oilKissOfFrostId, oilLeechId, oilHeartseekerId, oilPlagueId, oilPoisonId,

			weaponOilDemiseAnimalId, weaponOilDemiseMonsterId, weaponOilDemiseLegendaryId, weaponOilDemiseHumanId, weaponOilLickOfFireId,
			weaponOilKissOfFrostId, weaponOilLeechId, weaponOilHeartseekerId, weaponOilPlagueId, weaponOilPoisonId;

	public static ItemTemplate phial, mouldClay, mouldPottery, purifiedWater, alchemicalCompound, glassMixture, glass,

			leader, mixtureHeal, mixtureGoat, mixtureExcell, mixtureOakshell, mixtureMorningFog, mixtureFranticCharge,
			mixtureStrength, mixtureSixthSense, mixtureTruehit, mixtureWillowspine, mixtureRefresh, mixtureVynora,

			precursorHeal, precursorGoat, precursorExcell, precursorOakshell, precursorMorningFog,
			precursorFranticCharge, precursorStrength, precursorSixthSense, precursorTruehit, precursorWillowspine,
			precursorRefresh, precursorVynora,

			potionLiquidHeal, potionLiquidGoat, potionLiquidExcell, potionLiquidOakshell, potionLiquidMorningFog,
			potionLiquidFranticCharge, potionLiquidStrength, potionLiquidSixthSense, potionLiquidTruehit,
			potionLiquidWillowspine, potionLiquidRefresh, potionLiquidVynora,

			potionHeal, potionGoat, potionExcell, potionOakshell, potionMorningFog, potionFranticCharge, potionStrength,
			potionSixthSense, potionTruehit, potionWillowspine, potionRefresh, potionVynora,

			pasteDemiseAnimal, pasteDemiseMonster, pasteDemiseLegendary, pasteDemiseHuman, pasteLickOfFire,
			pasteKissOfFrost, pasteLeech, pasteHeartseeker, pastePlague, pastePoison,

			sludgeDemiseAnimal, sludgeDemiseMonster, sludgeDemiseLegendary, sludgeDemiseHuman, sludgeLickOfFire,
			sludgeKissOfFrost, sludgeLeech, sludgeHeartseeker, sludgePlague, sludgePoison,

			oilDemiseAnimal, oilDemiseMonster, oilDemiseLegendary, oilDemiseHuman, oilLickOfFire,
			oilKissOfFrost, oilLeech, oilHeartseeker, oilPlague, oilPoison,

			weaponOilDemiseAnimal, weaponOilDemiseMonster, weaponOilDemiseLegendary, weaponOilDemiseHuman, weaponOilLickOfFire,
			weaponOilKissOfFrost, weaponOilLeech, weaponOilHeartseeker, weaponOilPlague, weaponOilPoison;

	private static void registerLeader() throws IOException {
		leader = new ItemTemplateBuilder("arathok.alchemy.leader")
				.name("Alchemy EasterEgg", "useless bums", " Congratulations! You have found an EasterEgg!"
				+" Thank you Unusualleader for being the best friend one could possibly find on the internet. "
				+" Thank you Bdew for your tireless effort to teach me and the patience! Your help made this dream mod of mine possible and actually thought me quite a lot."
				+" Thanks Coldie for your tools and tutorials on how to Model and how to write a basic mod! Thank you for your help with making a texture pack! "
				+" Thanks EmmaGrace for pushing me over the edge and pushing me to make this mod.  "
				+" Thank you Wurm Modding Community Discord for hours of help!"
						)
				.modelName("model.decoration.statuette.magranon.")
				.imageNumber((short) IconConstants.ICON_FOOD_PIGFOOD)
				.itemTypes(new short[] { ItemTypes.ITEM_TYPE_POTTERY,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
						// ItemTypes.ITEM_TYPE_TRANSPORTABLE,
						ItemTypes.ITEM_TYPE_TOOL,
						ItemTypes.ITEM_TYPE_METAL,

				})
				.decayTime(9072000L)
				.dimensions(8, 8, 15)
				.weightGrams(85000).material(Materials.MATERIAL_IRON)
				.behaviourType((short) 1)
				.primarySkill(SkillList.POTTERY)
				.difficulty(30) // no hard lock
				.build();

		leaderId = leader.getTemplateId();
	}

	private static void registerGlassMixture() throws IOException {
		glassMixture = new ItemTemplateBuilder("arathok.alchemy.glassMixture").name("glass mixture", "glass mixtures",
				"A mixture made from sand, ash, and sandstone shards. Under high temperatures it will turn into a honey"
						+ "like paste. cooling it off you will get crystal clear glass. But what would a pile of glass be of use for? If you had some kind of a"
						+ "mould you could press the hot glass into shape...")
				.modelName("model.decoration.glassMixture.")
				.imageNumber((short) IconConstants.ICON_MORTAR_PILE)
				.itemTypes(new short[] {

						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
						// ItemTypes.ITEM_TYPE_TRANSPORTABLE,
						ItemTypes.ITEM_TYPE_METAL,

				})
				.decayTime(9072000L)
				.dimensions(20, 20, 20)
				.weightGrams(24000).material(Materials.MATERIAL_STONE)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(10) // no hard lock
				.build();

		glassMixtureId = glassMixture.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.sand, ItemList.ash, glassMixtureId, true, true,0.0f, true, false,0,5, CreationCategories.RESOURCES)
				.addRequirement(new CreationRequirement(1, ItemList.ash, 17, true))
				.addRequirement(new CreationRequirement(2, ItemList.sandstone, 1, true));
	}

	private static void registerGlass() throws IOException {
		glass = new ItemTemplateBuilder("arathok.alchemy.glass").name("glass", "glass",
				"Crystal clear glass. If you could make a phial out of it, it could contain magic stored in potions. " +
						"You should heat it before pressing it.")
				.modelName("model.decoration.flask.")
				.imageNumber((short) 1501)
				.itemTypes(new short[] {

						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
						// ItemTypes.ITEM_TYPE_TRANSPORTABLE,

						ItemTypes.ITEM_TYPE_METAL,

				})
				.decayTime(9072000L)
				.dimensions(20, 20, 20)
				.weightGrams(20000)
				.material(Materials.MATERIAL_GLASS)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY).difficulty(30) // no hard lock
				.build();

		glassId = glass.getTemplateId();
	}

	private static void registerMouldClay() throws IOException {
		mouldClay = new ItemTemplateBuilder("arathok.alchemy.mouldClay")
				.name("phial mould", "phial moulds",
						"A clay mould that could be used to make phials, but it still needs to be fired.")
				.modelName("model.mouldClay.")
				.imageNumber((short) 1502)
				.itemTypes(new short[] { ItemTypes.ITEM_TYPE_POTTERY,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,

						// ItemTypes.ITEM_TYPE_TRANSPORTABLE,
						ItemTypes.ITEM_TYPE_TOOL,

				})
				.decayTime(9072000L)
				.dimensions(8, 8, 15)
				.weightGrams(500)
				.material(Materials.MATERIAL_CLAY)
				.behaviourType((short) 1)
				.primarySkill(SkillList.POTTERY)
				.difficulty(30) // no hard lock
				.build();

		mouldClayId = mouldClay.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.POTTERY, ItemList.flaskPottery, ItemList.clay, mouldClayId,false, true, 0.0f, false, false, CreationCategories.POTTERY);
	}// nichts weiter

	private static void registerMouldPottery() throws IOException {
		mouldPottery = new ItemTemplateBuilder("arathok.alchemy.mouldPottery")
				.name("phial mould", "phial moulds", "A pottery mould that is used to make glass phials")
				.modelName("model.mouldPottery.")
				.imageNumber((short) 1503)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_POTTERY,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						// ItemTypes.ITEM_TYPE_TRANSPORTABLE,
						ItemTypes.ITEM_TYPE_TOOL,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
						ItemTypes.ITEM_TYPE_METAL, })
				.decayTime(9072000L)
				.dimensions(8, 8, 15)
				.weightGrams(500)
				.material(Materials.MATERIAL_POTTERY)
				.behaviourType((short) 1)
				.primarySkill(SkillList.POTTERY)
				.difficulty(30) // no hard lock
				.build();

		mouldPotteryId = mouldPottery.getTemplateId();
	}

	private static void registerPhial() throws IOException {
		phial = new ItemTemplateBuilder("arathok.alchemy.phial")
				.name("glass phial", "glass phials", "A crystal clear container for liquids, made from glass."
						+ " It is said Alchemists use these often to store their concoctions because the crystalline structure of glass is"
						+ "capable of holding strong magic powers.")

				.modelName("model.phial.")
				.imageNumber((short) 1504)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						// ItemTypes.ITEM_TYPE_TRANSPORTABLE,
						ItemTypes.ITEM_TYPE_TOOL,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(9072000L)
				.dimensions(5, 5, 10)
				.weightGrams(100)
				.material(Materials.MATERIAL_GLASS)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(10) // no hard lock
				.build();

		phialId = phial.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mouldPotteryId, AlchItems.glassId, phialId, false, true, 0f, false, false,0,10, CreationCategories.DECORATION);
	} // NO ADDITIONAL ITEMS NEEDED

	private static void registerPurifiedWater() throws IOException {
		purifiedWater = new ItemTemplateBuilder("arathok.alchemy.purifiedWater")
				.name("purified water", "purified water",
						"Water that has been cleaned from mundane impurities"
								+ " and is ready to take in a powerful essence.")
				.modelName("model.purfiedWater.")
				.imageNumber((short) IconConstants.ICON_LIQUID_WATER)
				.itemTypes(new short[] {

						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_METAL,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(9072000L)
				.dimensions(5, 5, 10)
				.weightGrams(500)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(5) // no hard lock
				.build();

		purifiedWaterId = purifiedWater.getTemplateId();
		if (!Config.purifiedWaterCooking)
			CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.water, ItemList.charcoal, purifiedWaterId, true, true, 0f, false, false,0,5, CreationCategories.DECORATION);

	}

	private static void registerAlchemicalCompound() throws IOException {
		alchemicalCompound = new ItemTemplateBuilder("arathok.alchemy.alchemicalCompound")
				.name("alchemical compound", "alchemical compounds",
						"A white-ish liquid smelling pretty bad. Its made from the essence of a beast"
								+ " and you can sense it holds potential to store the power of natural substances"
								+ "it should be used fresh but seems stable enough for a day.")

				.modelName("model.alchemicalCompound.")
				.imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
				.itemTypes(
						new short[] {
								ItemTypes.ITEM_TYPE_BULK,
								ItemTypes.ITEM_TYPE_LIQUID,
								ItemTypes.ITEM_TYPE_METAL,
								ItemTypes.ITEM_TYPE_NO_IMPROVE,

						}).decayTime(691200L)
				.dimensions(10, 10, 10)
				.weightGrams(1000)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(10) // no hard lock
				.build();

		alchemicalCompoundId = alchemicalCompound.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.purifiedWaterId, ItemList.heart,
				alchemicalCompoundId, true, true, 0f, true, false, 0,5,CreationCategories.ALCHEMY);
	}

	private static void registermixtureDodging() throws IOException {
		mixtureWillowspine = new ItemTemplateBuilder("arathok.alchemy.mixtureDodge").name("mixture of phasing",
				"mixtures of phasing",
				"A fresh mixture of different alchemical and natural substances. One day it might be making a fine potion."
						+ "Smelling this mixture makes you feel safe. You feel like the universe is putting its protective hands around you, turn you into a shadow."
						+ " You feel like nothing can really hurt your new form "
						+ " you should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.phasing.")
				.imageNumber((short) 1508)
				.itemTypes(new short[] {

						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				}).decayTime(14400L).dimensions(3, 3, 3).weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(30) // no hard lock
				.build();

		mixtureWillowspineId = mixtureWillowspine.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.rosemary, ItemList.ivySeedling,mixtureWillowspineId, true, true, 0f, true, false,0,30, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.pumpkin, 1, true))
				.addRequirement(new CreationRequirement(2, ItemList.eye, 1, true));
	}

	private static void registermixtureExcell() throws IOException {
		mixtureExcell = new ItemTemplateBuilder("arathok.alchemy.mixtureExcell").name("mixture of surpass",
				"mixtures of surpass",
				"A mixture of different alchemical substances. One day it might be making a fine potion."
						+ " Smelling it makes you feel energetic. Rubbing it on your fingers makes your skin seem to be softer and not as easy to cut."
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")
				.modelName("model.mixture.excell.").imageNumber((short) 1507)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE, })
				.decayTime(14400L).dimensions(3, 3, 3).weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(30) // no hard lock
				.build();

		mixtureExcellId = mixtureExcell.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.ginger, ItemList.sassafras, mixtureExcellId,
						true, true, 0f, true, false,0,25, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.mushroomRed, 1, true));
	}

	private static void registermixtureFrenzy() throws IOException {
		mixtureFranticCharge = new ItemTemplateBuilder("arathok.alchemy.mixtureFrenzy").name("mixture of frenzy",
				"mixtures of frenzy",
				"A mixture of different alchemical and natural substances. One day it might be making a fine potion."
						+ " Smelling this mixture makes you aggressive, it seems to call to you to let out your inner beast."
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.frenzy.").imageNumber((short) 1507)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				}).decayTime(14400L).dimensions(3, 3, 3).weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(35) // no hard lock
				.build();

		mixtureFranticChargeId = mixtureFranticCharge.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.mushroomRed, ItemList.nutmeg,
						mixtureFranticChargeId, true, true, 0f, true, false,0,35, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.tomato, 1, true))
				.addRequirement(new CreationRequirement(2, ItemList.tooth, 1, true));
	}

	private static void registerMixtureGoat() throws IOException {
		mixtureGoat = new ItemTemplateBuilder("arathok.alchemy.mixtureGoat")
				.name("mixture of Goat", "mixtures of Goat",
						"A mixture of different alchemical substances. One day it might be making a fine potion."
								+ " It smells like a wet Goat... weird.")

				.modelName("model.mixture.goat.").imageNumber((short) 1506)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE, })
				.decayTime(14400L).dimensions(3, 3, 3).weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(30) // no hard lock
				.build();

		mixtureGoatId = mixtureGoat.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.branch, ItemList.oat, mixtureGoatId,
				true, true, 0f, false, false,0,20, CreationCategories.ALCHEMY);
	}

	private static void registermixtureOakshell() throws IOException {
		mixtureOakshell = new ItemTemplateBuilder("arathok.alchemy.mixtureOakshell")
				.name("mixture of Woodskin", "mixtures of Woodskin",
						"A mixture of different alchemical substances. One day it might be making a fine potion."
								+ " It seems to make your skin somewhat woodifies and becomes harder when you touch it."
								+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.oakshell.")
				.imageNumber((short) 1508)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(50) // no hard lock
				.build();

		mixtureOakshellId = mixtureOakshell.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.acorn, ItemList.rock, mixtureOakshellId, true,true, 0f, true, false,0,40, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.mushroomBlue, 1, true))
				.addRequirement(new CreationRequirement(2, ItemList.sage, 1, true));
	}

	private static void registerMixtureHeal() throws IOException {
		mixtureHeal = new ItemTemplateBuilder("arathok.alchemy.mixtureHeal").name("mixture of health",
				"mixtures of health",
				"A mixture of different alchemical substances. One day it might be making a fine potion."
						+ " You put some of the mixture to the tip of your tongue. A small scratch you got starts to close. This seems to have some healing Properties."
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixtureHeal.").imageNumber((short) 1505)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(30) // no hard lock
				.build();

		mixtureHealId = mixtureHeal.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.mushroomBrown, ItemList.wheat,mixtureHealId, true, true, 0f, false, false,0,15, CreationCategories.ALCHEMY);
	}

	private static void registermixtureMorningFog() throws IOException {
		mixtureMorningFog = new ItemTemplateBuilder("arathok.alchemy.mixtureFog").name("mixture of fog skin",
				"mixtures of fog skin",
				"A mixture of different alchemical substances. One day it might be making a fine potion."
						+ " Sniffing it your body seems to bend around sharp objects as if it wants to protect itself."
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.fog.")
				.imageNumber((short) 1508)
				.itemTypes(new short[] {
					//	ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(30) // no hard lock
				.build();

		mixtureMorningFogId = mixtureMorningFog.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.lingonberry, ItemList.wemp,mixtureMorningFogId, true, true, 0f, false, false,0,10, CreationCategories.ALCHEMY);
	}

	private static void registermixtureRefresh() throws IOException {
		mixtureRefresh = new ItemTemplateBuilder("arathok.alchemy.mixtureRefresh").name("mixture of refreshing",
				"mixtures of Refreshing",
				"A mixture of different alchemical substances. One day it might be making a fine potion."
						+ " You sense it giving off a whiff of cool air. It seems to be able to strip some tiredness off you."
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.refresh.")
				.imageNumber((short) 1505)
				.itemTypes(new short[] {
					//	ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(20) // no hard lock
				.build();

		mixtureRefreshId = mixtureRefresh.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.carrot, ItemList.potato,mixtureRefreshId, true, true, 0f, false, false, 0,10,CreationCategories.ALCHEMY);
		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.mint, ItemList.fennel,mixtureRefreshId, true, true, 0f, false, false,0,10, CreationCategories.ALCHEMY);
	}

	private static void registermixtureSixthSense() throws IOException {
		mixtureSixthSense = new ItemTemplateBuilder("arathok.alchemy.mixtureSixthSense").name("mixture of senses",
				"mixtures of senses",
				"A mixture of different alchemical substances. One day it might be making a fine potion."
						+ " The smell brings a certain picture before the inner eye. Like a voice telling you, to be careful with your surroundings"
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.sixth.")
				.imageNumber((short) 1506)
				.itemTypes(new short[] {

					//	ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(30) // no hard lock
				.build();

		mixtureSixthSenseId = mixtureSixthSense.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, ItemList.lovage, ItemList.nettles,mixtureSixthSenseId, true, true, 0f, false, false,0,20, CreationCategories.ALCHEMY);
	}

	private static void registermixtureStrength() throws IOException {
		mixtureStrength = new ItemTemplateBuilder("arathok.alchemy.mixture")
				.name("mixture of Strength", "mixtures of Strength",
						"A mixture of different alchemical substances. One day it might be making a fine potion."
								+ " The smell makes you feel like you could lift a mountain."
								+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.strength.")
				.imageNumber((short) 1506)
				.itemTypes(new short[] {
						// ItemTypes.ITEM_TYPE_BULK,

						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(40) // no hard lock
				.build();

		mixtureStrengthId = mixtureStrength.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.mushroomBlack, ItemList.paprika,mixtureStrengthId, true, true, 0f, true, false,0,40, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.woad, 1, true));
	}

	private static void registermixtureTruehit() throws IOException {
		mixtureTruehit = new ItemTemplateBuilder("arathok.alchemy.mixtureTruehit")
				.name("mixture of truehit", "mixtures of truehit",
						"A mixture of different alchemical substances. One day it might be making a fine potion."
								+ " The belladonna is widening your eyes, uncovering weak spots on enemies"
								+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.truehit.")
				.imageNumber((short) 1507)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL).difficulty(30) // no hard lock
				.build();

		mixtureTruehitId = mixtureTruehit.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.belladonna, ItemList.garlic, mixtureTruehitId,true, true, 0f, true, false,0,25, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.mushroomGreen, 1, true));
	}

	private static void registermixtureVyn() throws IOException {
		mixtureVynora = new ItemTemplateBuilder("arathok.alchemy.mixtureVyn").name("mixture of Knowledge",
				"mixtures of Knowledge",
				"A mixture of different alchemical substances. One day it might be making a fine potion."
						+ " This mixture has captured the essence of knowledge itself. You can feel Vynora smile down on you. You are grasping for the summit of Alchemy"
						+ " You should work with it soon, since the magic energy in the herbs is dissipating fast.")

				.modelName("model.mixture.vyn.")
				.imageNumber((short) 1509)
				.itemTypes(new short[] {
						//ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE, })
				.decayTime(14400L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.ALCHEMY_NATURAL)
				.difficulty(90) // no hard lock
				.build();

		mixtureVynoraId = mixtureVynora.getTemplateId();

		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.mushroomYellow, ItemList.turmeric,	mixtureVynoraId, true, true, 0f, true, false,0,60, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.strawberries, 1, true))
				.addRequirement(new CreationRequirement(2, ItemList.thyme, 1, true))
				.addRequirement(new CreationRequirement(2, ItemList.cumin, 1, true))
				.addRequirement(new CreationRequirement(2, ItemList.coinSilver, 1, true));

	}

	private static void registerPrecursorDodge() throws IOException {
		precursorWillowspine = new ItemTemplateBuilder("arathok.alchemy.precursorDodge")
				.name("potion precursor of phasing", "precursors of phasing",
						"A potion precursor. It got the essence of agility stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.dodge.")
				.imageNumber((short) 1528)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						

				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorWillowspineId = precursorWillowspine.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,AlchItems.mixtureWillowspineId, precursorWillowspineId, true, true, 0f, false, false, CreationCategories.ALCHEMY);
	}

	private static void registerPrecursorExcell() throws IOException {
		precursorExcell = new ItemTemplateBuilder("arathok.alchemy.precursorExcell")
				.name("potion precursor surpassing", "precursors of surpassing",
						"A potion precursor. It got the essence of surpassing your foes through enduring pain stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.excell.")
				.imageNumber((short) 1527)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,

				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.GROUP_ALCHEMY).difficulty(30) // no hard lock
				.build();

		precursorExcellId = precursorExcell.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureExcellId, precursorExcellId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPrecursorGoat() throws IOException {
		precursorGoat = new ItemTemplateBuilder("arathok.alchemy.precursorGoat")
				.name("potion precursor of goat", "precursors of goat",
						"A potion precursor. It got the essence of a goat stored within. Weird."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.goat.")
				.imageNumber((short) 1526)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,

				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorGoatId = precursorGoat.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureGoatId, precursorGoatId, true, true, 0f, false, false, CreationCategories.DECORATION);
	}

	private static void registerPrecursorHeal() throws IOException {
		precursorHeal = new ItemTemplateBuilder("arathok.alchemy.precursorHeal")
				.name("potion precursor healing", "precursors of healing",
						"A potion precursor. It got the essence of Healing stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.heal")
				.imageNumber((short) 1525)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorHealId = precursorHeal.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,AlchItems.mixtureHealId, precursorHealId, true, true, 0f, false, false, CreationCategories.DECORATION);
	}

	private static void registerPrecursorFranticCharge() throws IOException {
		precursorFranticCharge = new ItemTemplateBuilder("arathok.alchemy.precursorFranticCharge")
				.name("potion precursor frenzy", "precursors of frenzy",
						"A potion precursor. It got the essence of frenzy stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.FranticChange")
				.imageNumber((short) 1527)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorFranticChargeId = precursorFranticCharge.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureFranticChargeId, precursorFranticChargeId, true, true, 0f, false, false,	CreationCategories.DECORATION);
	}

	private static void registerPrecursorMorningFog() throws IOException {
		precursorMorningFog = new ItemTemplateBuilder("arathok.alchemy.precursorMorningFog")
				.name("potion precursor of fog skin", "precursors of fog skin",
						"A potion precursor. It got the essence of mist stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.fog.")
				.imageNumber((short) 1528)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorMorningFogId = precursorMorningFog.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureMorningFogId, precursorMorningFogId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPrecursorOakshell() throws IOException {
		precursorOakshell = new ItemTemplateBuilder("arathok.alchemy.precursorOakshell")
				.name("potion precursor of woodskin", "precursors of woodskin",
						"A potion precursor. It got the essence of hard tree bark stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.oakshell.")
				.imageNumber((short) 1528)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorOakshellId = precursorOakshell.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,AlchItems.mixtureOakshellId, precursorOakshellId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPrecursorRefresh() throws IOException {
		precursorRefresh = new ItemTemplateBuilder("arathok.alchemy.precursorRefresh")
				.name("potion precursor of refresh", "precursors of refresh",
						"A potion precursor. It got the essence of stamina stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.refresh.")
				.imageNumber((short) 1525)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorRefreshId = precursorRefresh.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureRefreshId, precursorRefreshId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPrecursorSixthSense() throws IOException {
		precursorSixthSense = new ItemTemplateBuilder("arathok.alchemy.precursorSixthSense")
				.name("potion precursor of senses", "precursors of senses",
						"A potion precursor. It got the essence of heightening your senses stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.senses.")
				.imageNumber((short) 1526)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L).dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorSixthSenseId = precursorSixthSense.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureSixthSenseId, precursorSixthSenseId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPrecursorStrength() throws IOException {
		precursorStrength = new ItemTemplateBuilder("arathok.alchemy.precursorStrength")
				.name("potion precursor of demon blood", "precursors of demon blood",
						"A potion precursor. It got the essence of demonic blood stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.strength.")
				.imageNumber((short) 1526)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorStrengthId = precursorStrength.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureStrengthId, precursorStrengthId, true, true, 0f, false, false,
				CreationCategories.DECORATION);
	}

	private static void registerPrecursorTruehit() throws IOException {
		precursorTruehit = new ItemTemplateBuilder("arathok.alchemy.precursorTruehit")
				.name("potion precursor of truehit", "precursors of truehit",
						"A potion precursor. It got the essence of stamina stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.truehit.")
				.imageNumber((short) 1527)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorTruehitId = precursorTruehit.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,AlchItems.mixtureTruehitId, precursorTruehitId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPrecursorVynora() throws IOException {
		precursorVynora = new ItemTemplateBuilder("arathok.alchemy.precursorVynora")
				.name("potion precursor of vynora", "precursors of vynora",
						"A potion precursor. It got the essence of knowledge stored within."
								+ " You think its magical properties could be activated by heating it.")

				.modelName("model.precursor.vynora.")
				.imageNumber((short) 1529)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		precursorVynoraId = precursorVynora.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.alchemicalCompoundId,	AlchItems.mixtureVynoraId, precursorVynoraId, true, true, 0f, false, false,CreationCategories.DECORATION);
	}

	private static void registerPotionLiquidDodge() throws IOException {
		potionLiquidWillowspine = new ItemTemplateBuilder("arathok.alchemy.potionLiquidDodge")
				.name(" potion liquid of phasing", "potion liquids of phasing",
				"A potion liquid." + " This is almost a finished dodging potion. "
						+ " It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.dodge.")
				.imageNumber((short) 1548)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidWillowspineId = potionLiquidWillowspine.getTemplateId();
	}

	private static void registerPotionLiquidExcell() throws IOException {
		potionLiquidExcell = new ItemTemplateBuilder("arathok.alchemy.potionLiquidExcell")
				.name(" potion liquid surpassing", "potion liquids of surpassing",
				"A potion liquid. This is almost a finished eelskin potion."
						+ " It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")
				.modelName("model.potionLiquid.excell.").imageNumber((short) 1547)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(9072000L).dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidExcellId = potionLiquidExcell.getTemplateId();
	}

	private static void registerPotionLiquidGoat() throws IOException {
		potionLiquidGoat = new ItemTemplateBuilder("arathok.alchemy.potionLiquidGoat")
				.name(" potion liquid of goat",
				"potion liquids of goat",
				"A potion liquid. This is almost a finished Goatshape potion."
						+ " It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.goat.")
				.imageNumber((short) 1546)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L).dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.GROUP_ALCHEMY).difficulty(30) // no hard lock
				.build();

		potionLiquidGoatId = potionLiquidGoat.getTemplateId();
	}

	private static void registerPotionLiquidHeal() throws IOException {
		potionLiquidHeal = new ItemTemplateBuilder("arathok.alchemy.potionLiquidHeal")
				.name(" potion liquid healing",
				"potion liquids of healing",
				"A potion liquid. This is almost a finished health Potion. "
						+ "It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.heal").imageNumber((short) 1545)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidHealId = potionLiquidHeal.getTemplateId();
	}

	private static void registerPotionLiquidFranticCharge() throws IOException {
		potionLiquidFranticCharge = new ItemTemplateBuilder("arathok.alchemy.potionLiquidFranticCharge")
				.name(" potion liquid frenzy", "potion liquids of frenzy",
				"A potionLiquid. This is almost a finished frenzy potion."
						+ " It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")
				.modelName("model.potionLiquid.FranticChange")
				.imageNumber((short) 1547)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1).primarySkill(SkillList.GROUP_ALCHEMY).difficulty(30) // no hard lock
				.build();

		potionLiquidFranticChargeId = potionLiquidFranticCharge.getTemplateId();
	}

	private static void registerPotionLiquidMorningFog() throws IOException {
		potionLiquidMorningFog = new ItemTemplateBuilder("arathok.alchemy.potionLiquidMorningFog")
				.name(" potion liquid of fog skin", "potion liquids of fog skin",
				"A potion liquid. This is almost a finished fog skin potion. "
						+ "It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")
				.modelName("model.potionLiquid.fog.")
				.imageNumber((short) 1548)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidMorningFogId = potionLiquidMorningFog.getTemplateId();
	}

	private static void registerPotionLiquidOakshell() throws IOException {
		potionLiquidOakshell = new ItemTemplateBuilder("arathok.alchemy.potionLiquidOakshell")
				.name(" potion liquid of wood skin", "potionLiquids of wood skin",
				"A potion Liquid. This is almost a finished wood skin potion. "
						+ "It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.oakshell.")
				.imageNumber((short) 1548)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidOakshellId = potionLiquidOakshell.getTemplateId();
	}

	private static void registerPotionLiquidRefresh() throws IOException {
		potionLiquidRefresh = new ItemTemplateBuilder("arathok.alchemy.potionLiquidRefresh")
				.name(" potion liquid of refresh", "potion liquids of refresh",
				"A potion liquid. This is almost a finished potion of stamina. "
						+ "It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.refresh.")
				.imageNumber((short) 1545)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidRefreshId = potionLiquidRefresh.getTemplateId();
	}

	private static void registerPotionLiquidSixthSense() throws IOException {
		potionLiquidSixthSense = new ItemTemplateBuilder("arathok.alchemy.potionLiquidSixthSense")
				.name(" potion liquid of senses", "potion liquids of senses",
				"A potion liquid. This is almost a finished potion of senses. "
						+ "It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.senses.")
				.imageNumber((short) 1546)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,

						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidSixthSenseId = potionLiquidSixthSense.getTemplateId();

	}

	private static void registerPotionLiquidStrength() throws IOException {
		potionLiquidStrength = new ItemTemplateBuilder("arathok.alchemy.potionLiquidStrength")
				.name(" potion liquid of demon blood", "potion liquids of demon blood",
				"A potion liquid. This is almost a finished demon blood potion."
						+ " It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.strength.")
				.imageNumber((short) 1546)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidStrengthId = potionLiquidStrength.getTemplateId();
	}

	private static void registerPotionLiquidTruehit() throws IOException {
		potionLiquidTruehit = new ItemTemplateBuilder("arathok.alchemy.potionLiquidTruehit")
				.name(" potion liquid of truehit", "potion liquids of truehit",
				"A potion liquid. This is almost a finished truehit potion. "
						+ "It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.truehit.")
				.imageNumber((short) 1547)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidTruehitId = potionLiquidTruehit.getTemplateId();
	}

	private static void registerPotionLiquidVynora() throws IOException {
		potionLiquidVynora = new ItemTemplateBuilder("arathok.alchemy.potionLiquidVynora")
				.name(" potion Liquid of vynora", "potion Liquids of vynora",
				"A potionLiquid. This is almost a finished knowledge potion."
						+ " It just needs to be bottled in a crystal phial because only the crystal structure of the glass can activate and properly catalyse the magical properties.")

				.modelName("model.potionLiquid.vynora.")
				.imageNumber((short) 1549)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_LIQUID,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,
				})
				.decayTime(691200L)
				.dimensions(3, 3, 3)
				.weightGrams(100).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionLiquidVynoraId = potionLiquidVynora.getTemplateId();
	}

	private static void registerPotionDodge() throws IOException {
		potionWillowspine = new ItemTemplateBuilder("arathok.alchemy.potionDodge")
				.name(" potion of phasing", "potions of phasing",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.potion.dodge.")
				.imageNumber((short) 1568)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdWillowspine = potionWillowspine.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidWillowspineId, potionIdWillowspine, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerPotionExcell() throws IOException {
		potionExcell = new ItemTemplateBuilder("arathok.alchemy.potionExcell")
				.name(" potion of eelskin", "potions of eelskin",
						"An alchemistic potion, drinking it will bestow the power of eelskin to you. Your enemies wont hit as good!")

				.modelName("model.potion.excell.")
				.imageNumber((short) 1567)
				.itemTypes(new short[] {
						 ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(2073600L).dimensions(5, 5, 10)
				.weightGrams(200)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdExcell = potionExcell.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidExcellId, potionIdExcell, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerPotionGoat() throws IOException {
		potionGoat = new ItemTemplateBuilder("arathok.alchemy.potionGoat").
				name(" potion of goatshape","potions of goatshape",
				"An alchemistic potion, drinking it will bestow the power of a goat to you. Whatever that means?")

				.modelName("model.potion.goat.")
				.imageNumber((short) 1566)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(2073600L).dimensions(5, 5, 10)
				.weightGrams(200).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY).difficulty(30) // no hard lock
				.build();

		potionIdGoat = potionGoat.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId, AlchItems.potionLiquidGoatId,potionIdGoat, true, true, 0f, false, false, CreationCategories.ALCHEMY);
	}

	private static void registerPotionHeal() throws IOException {
		potionHeal = new ItemTemplateBuilder("arathok.alchemy.potionHeal")
				.name(" potion of heal", "potions of heal", "An alchemistic potion, drinking it will heal you.")

				.modelName("model.potion.heal.")
				.imageNumber((short) 1565)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdHeal = potionHeal.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId, AlchItems.potionLiquidHealId,potionIdHeal, true, true, 0f, false, false, CreationCategories.ALCHEMY);
	}

	private static void registerPotionFrenzy() throws IOException {
		potionFranticCharge = new ItemTemplateBuilder("arathok.alchemy.potionFranticCharge")
				.name(" potion of frenzy", "potions of frenzy",
						"An alchemistic potion, drinking it will bestow the power of rage to you.")

				.modelName("model.potion.FranticCharge.")
				.imageNumber((short) 1567)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdFranticCharge = potionFranticCharge.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidFranticChargeId, potionIdFranticCharge, true, true, 0f, false, false,	CreationCategories.ALCHEMY);
	}

	private static void registerPotionMorningFog() throws IOException {
		potionMorningFog = new ItemTemplateBuilder("arathok.alchemy.potionMorningFog")
				.name(" potion of fog skin", "potions of fog skin",
						"An alchemistic potion, drinking it will bestow the power of Fog to you.")

				.modelName("model.potion.fog.").imageNumber((short) 1568)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdMorningFog = potionMorningFog.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidMorningFogId, potionIdMorningFog, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerPotionOakshell() throws IOException {
		potionOakshell = new ItemTemplateBuilder("arathok.alchemy.Oakshell")
				.name(" potion of Woodskin", "potions of Woodskin",
						"An alchemistic potion, drinking it will bestow the power of wood skin to you.")

				.modelName("model.potion.Oakshell.")
				.imageNumber((short) 1568)
				.itemTypes(new short[] {
						ItemTypes.ITEM_TYPE_BULK,
						ItemTypes.ITEM_TYPE_HERB,
						ItemTypes.ITEM_TYPE_PLANTABLE,
						ItemTypes.ITEM_TYPE_DECORATION,
						ItemTypes.ITEM_TYPE_TURNABLE,
						ItemTypes.ITEM_TYPE_NO_IMPROVE,

				})
				.decayTime(2073600L).dimensions(5, 5, 10)
				.weightGrams(200)
				.material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdOakshell = potionOakshell.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidOakshellId, potionIdOakshell, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerPotionRefresh() throws IOException {
		potionRefresh = new ItemTemplateBuilder("arathok.alchemy.potionRefresh")
				.name(" potion of stamina", "potions of stamina",
						"An alchemistic potion, drinking it will regenerate some stamina for you.")

				.modelName("model.potion.stamina.").imageNumber((short) 1565)
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
				.weightGrams(200).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdRefresh = potionRefresh.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidRefreshId, potionIdRefresh, true, true, 0f, false, false,	CreationCategories.ALCHEMY);
	}

	private static void registerPotionSixthSense() throws IOException {
		potionSixthSense = new ItemTemplateBuilder("arathok.alchemy.potionSixthSense")
				.name(" potion of senses", "potions of senses",
						"An alchemistic potion, drinking it will bestow superior situational awareness to you.")

				.modelName("model.potion.SixthSense.")
				.imageNumber((short) 1566)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdSixthSense = potionSixthSense.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidSixthSenseId, potionIdSixthSense, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerPotionStrength() throws IOException {
		potionStrength = new ItemTemplateBuilder("arathok.alchemy.potionStrength")
				.name(" potion of demon blood", "potions of demon blood",
						"An alchemistic potion, drinking it will bestow the power of demonic blood and superior strength to you.")

				.modelName("model.potion.strength.")
				.imageNumber((short) 1566)
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
				.weightGrams(200).material(Materials.MATERIAL_MAGIC)
				.behaviourType((short) 1)
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdStrength = potionStrength.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidStrengthId, potionIdStrength, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerPotionTruehit() throws IOException {
		potionTruehit = new ItemTemplateBuilder("arathok.alchemy.potionTruehit")
				.name(" potion of truehit", "potions of truehit",
						"An alchemistic potion, drinking it will bestow the power superior battle focus to you.")

				.modelName("model.potion.truehit.")
				.imageNumber((short) 1567)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		potionIdTruehit = potionTruehit.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidTruehitId, potionIdTruehit, true, true, 0f, false, false,	CreationCategories.ALCHEMY);
	}

	private static void registerPotionVynora() throws IOException {
		potionVynora = new ItemTemplateBuilder("arathok.alchemy.potionVynora")
				.name(" potion of knowledge", "potions of knowledge",
						"This potion is the epitome of alchemy. It is bottled knowledge. ")

				.modelName("model.potion.vynora.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(90) // no hard lock
				.build();

		potionIdVynora = potionVynora.getTemplateId();
		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.potionLiquidVynoraId, potionIdVynora, true, true, 0f, false, false,	CreationCategories.ALCHEMY);
	}

	/// PASTES

	private static void registerPasteDemiseAnimal() throws IOException {
		pasteDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.pasteDemiseAnimal")
				.name(" paste of the Hunter", "pastes of the Hunter",
						"A paste that smells of death. Rubbing it on a piece animal flesh it seems to dissolve it. " +
								" You sense this could be turned into a coating for weapons."+
								" Due to its fresh ingredients it should be processed quickly."
				)

				.modelName("model.paste.animal.")
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(40) // no hard lock
				.build();

		pasteDemiseAnimalId = pasteDemiseAnimal.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureGoatId, ItemList.tallow,	pasteDemiseAnimalId, true, true, 0f, true, false, 0,30,CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.eye, 1, true));

	}


	private static void registerPasteDemiseMonster() throws IOException {
		pasteDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.pasteDemiseMonster")
				.name(" paste of the Monster Hunter", "pastes of the Monster Hunter",
						"A paste that smells of death. Rubbing it on a piece monster flesh it seems to dissolve it. " +
								" Yet your own skin is safe. You sense this could be turned into a coating for weapons."
						+" Due to its fresh ingredients it should be processed quickly.")

				.modelName("model.paste.monster.")
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(60) // no hard lock
				.build();

		pasteDemiseMonsterId = pasteDemiseMonster.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureGoatId, ItemList.tallow,	pasteDemiseMonsterId, true, true, 0f, true, false,0,30, CreationCategories.ALCHEMY)
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
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(70) // no hard lock
				.build();

		pasteDemiseLegendaryId = pasteDemiseLegendary.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureGoatId, ItemList.tallow,	pasteDemiseLegendaryId, true, true, 0f, true, false,0,50, CreationCategories.ALCHEMY)
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
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		pasteDemiseHumanId = pasteDemiseHuman.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureGoatId, ItemList.tallow,	pasteDemiseHumanId, true, true, 0f, true, false,0,35, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.meat, 1, true));

	}

	private static void registerPasteLickOfFire() throws IOException {
		pasteLickOfFire = new ItemTemplateBuilder("arathok.alchemy.pasteFire")
				.name(" paste of lick of fire", "pastes of lick of fire",
						"A paste that smells sulphury. It develops extreme heat on any surface it touches. " +
								"You sense this could be turned into a coating for weapons."
								+" Due to its fresh ingredients it should be processed quickly.")

				.modelName("model.paste.kissOfFire.")
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		pasteLickOfFireId = pasteLickOfFire.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureFranticChargeId, ItemList.tallow,	pasteLickOfFireId, true, true, 0f, true, false,0,40, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.charcoal, 1, true));

	}

	private static void registerPasteKissOfFrost() throws IOException {
		pasteKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.pasteFrost")
				.name(" paste of Kiss of Frost", "pastes of Kiss of Frost",
						"A paste that is cool to the touch. It freezes any surface it touches. " +
								"You sense this could be turned into a coating for weapons. "
								+"Due to its fresh ingredients it should be processed quickly.")

				.modelName("model.paste.kissOfFire.")
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		pasteKissOfFrostId = pasteKissOfFrost.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureFranticChargeId, ItemList.tallow,	pasteKissOfFrostId, true, true, 0f, true, false,0,40, CreationCategories.ALCHEMY)
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
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		pasteLeechId = pasteLeech.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureHealId, ItemList.tallow,	pasteLeechId, true, false, 0f, true, false,0,50, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.snowball, 1, true));

	}

	private static void registerPastePlague() throws IOException {
		pastePlague = new ItemTemplateBuilder("arathok.alchemy.pastePlague")
				.name(" paste of the Plague", "pastes of Plague",
						"A forbidden paste. Smearing it upon anything makes it age and rot. Very Dangerous. " +
								"You sense this could be turned into a coating for weapons. "
								+"Due to its fresh ingredients it should be processed quickly.")

				.modelName("model.paste.plague.")
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(70) // no hard lock
				.build();

		pastePlagueId = pastePlague.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureMorningFogId, ItemList.tallow,	pastePlagueId, true, true, 0f, true, false,0,50, CreationCategories.ALCHEMY)
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
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		pasteHeartseekerId = pasteHeartseeker.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureExcellId, ItemList.tallow,	pasteHeartseekerId, true, true, 0f, true, false,0,35, CreationCategories.ALCHEMY)
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
				.imageNumber((short) 1509)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		pastePoisonId = pastePoison.getTemplateId();
		CreationEntryCreator
				.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, AlchItems.mixtureHealId, ItemList.tallow,	pastePoisonId, true, true, 0f, true, false,0,50, CreationCategories.ALCHEMY)
				.addRequirement(new CreationRequirement(1, ItemList.heart, 1, true));

	}
/// Oil Precursors / Sludges
private static void registerPrecursorDemiseAnimal() throws IOException {
	sludgeDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseAnimal")
			.name(" sludge of the Hunter", "sludges of the Hunter",
					"A sludge that smells of death. Rubbing it on a piece animal flesh it seems to dissolve it. " +
							"You sense this could be turned into a coating for weapons. ")

			.modelName("model.sludge.animal.")
			.imageNumber((short) 1529)
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
			.primarySkill(SkillList.GROUP_ALCHEMY)
			.difficulty(40) // no hard lock
			.build();

	sludgeDemiseAnimalId = sludgeDemiseAnimal.getTemplateId();
	CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteDemiseAnimalId, AlchItems.alchemicalCompoundId,	sludgeDemiseAnimalId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


}


	private static void registerPrecursorDemiseMonster() throws IOException {
		sludgeDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseMonster")
				.name(" sludge of the Monster Hunter", "sludges of the Monster Hunter",
						"A sludge that smells of death. Rubbing it on a piece monster flesh it seems to dissolve it. " +
								"Yet your own skin is safe. You sense this could be turned into a coating for weapons. ")

				.modelName("model.sludge.monster.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(60) // no hard lock
				.build();

		sludgeDemiseMonsterId = sludgeDemiseMonster.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteDemiseMonsterId, AlchItems.alchemicalCompoundId,	sludgeDemiseMonsterId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}
	private static void registerPrecursorDemiseLegendary() throws IOException {
		sludgeDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseLegendary")
				.name(" sludge of the Dragon Hunter", "sludges of the Dragon Hunter",
						"A sludge that smells of death. You find that it doesn't disslolve any flesh you know " +
								"not even your own. Maybe you should test it on Dragons or so? " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.legendary.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(70) // no hard lock
				.build();

		sludgeDemiseLegendaryId = sludgeDemiseLegendary.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteDemiseLegendaryId, AlchItems.alchemicalCompoundId,	sludgeDemiseLegendaryId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorDemiseHuman() throws IOException {
		sludgeDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.sludgeDemiseHuman")
				.name(" sludge of the Murderer", "sludges of the Murderer",
						"A sludge that smells of death. You find that it dissolves your own flesh easily, " +
								"but doesn't harm animal flesh. Weird. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.human.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		sludgeDemiseHumanId = sludgeDemiseHuman.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteDemiseHumanId, AlchItems.alchemicalCompoundId,	sludgeDemiseHumanId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorLickOfFire() throws IOException {
		sludgeLickOfFire = new ItemTemplateBuilder("arathok.alchemy.sludgeFire")
				.name(" sludge of lick of fire", "sludges of lick of fire",
						"A sludge that smells sulphury. It develops extreme heat on any surface it touches. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.kissOfFire.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		sludgeLickOfFireId = sludgeLickOfFire.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteLickOfFireId, AlchItems.alchemicalCompoundId,	sludgeLickOfFireId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorKissOfFrost() throws IOException {
		sludgeKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.sludgeFrost")
				.name(" sludge of Kiss of Frost", "sludges of Kiss of Frost",
						"A sludge that is cool to the touch. It freezes any surface it touches. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.kissOfFrost.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		sludgeKissOfFrostId = sludgeKissOfFrost.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteKissOfFrostId, AlchItems.alchemicalCompoundId,	sludgeKissOfFrostId, true, true, 0f, false,true,0,30.0, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorLech() throws IOException {
		sludgeLeech = new ItemTemplateBuilder("arathok.alchemy.sludgeLeech")
				.name(" sludge of Leech", "sludges of Leech",
						"An ominous sludge. Smearing it upon a plant makes the plant wilt, but upon touching " +
								"the sludge on the plant you feel more vigorous. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.Leech.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		sludgeLeechId = sludgeLeech.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteLeechId, AlchItems.alchemicalCompoundId,	sludgeLeechId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorPlague() throws IOException {
		sludgePlague = new ItemTemplateBuilder("arathok.alchemy.sludgePlague")
				.name(" sludge of the Plague", "sludges of Plague",
						"A forbidden sludge. Smearing it upon anything makes it age and rot. Very Dangerous. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.plague.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(70) // no hard lock
				.build();

		sludgePlagueId = sludgePlague.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pastePlagueId, AlchItems.alchemicalCompoundId,	sludgePlagueId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorHeartseeker() throws IOException {
		sludgeHeartseeker = new ItemTemplateBuilder("arathok.alchemy.sludgeHeartseeker")
				.name(" sludge of the Heartseeker", "sludges of the Heartseeker",
						"An ominous sludge. Smearing it upon your hand makes it always want to grab on what you" +
								" are focusing. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.Heartseeker.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		sludgeHeartseekerId = sludgeHeartseeker.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pasteHeartseekerId, AlchItems.alchemicalCompoundId,	sludgeHeartseekerId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}

	private static void registerPrecursorPoison() throws IOException {
		sludgePoison = new ItemTemplateBuilder("arathok.alchemy.sludgePoison")
				.name(" sludge of the Snake", "sludges of the Snake",
						"A forbidden sludge. Smearing it upon your hand makes your body temperature rise in an" +
								" instant, your veins turn blackish. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.sludge.poison.")
				.imageNumber((short) 1529)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		sludgePoisonId = sludgePoison.getTemplateId();
		CreationEntryCreator
				.createSimpleEntry(SkillList.ALCHEMY_NATURAL, AlchItems.pastePoisonId, AlchItems.alchemicalCompoundId,	sludgePoisonId, true, true, 0f, false, false, CreationCategories.ALCHEMY);


	}
// OILS

	private static void registerOilDemiseAnimal() throws IOException {
		oilDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.oilDemiseAnimal")
				.name(" oil of the Hunter", "oils of the Hunter",
						"An oil that smells of death. Rubbing it on a piece animal flesh it seems to dissolve it. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.animal.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(40) // no hard lock
				.build();

		oilDemiseAnimalId = oilDemiseAnimal.getTemplateId();

	}


	private static void registeroilDemiseMonster() throws IOException {
		oilDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.oilDemiseMonster")
				.name(" oil of the Monster Hunter", "oils of the Monster Hunter",
						"An oil that smells of death. Rubbing it on a piece monster flesh it seems to dissolve it. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.monster.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(60) // no hard lock
				.build();

		oilDemiseMonsterId = oilDemiseMonster.getTemplateId();

	}
	private static void registeroilDemiseLegendary() throws IOException {
		oilDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.oilDemiseLegendary")
				.name(" oil of Legendarys Demise", "oils of Legendarys Demise",
						"An oil that smells of death. You find that it doesn't dislolve any flesh you know not even your own. Maybe you should test it on Dragons or so? " +
								"It needs to be filled into a crystalline phial to unfold its magical potential as a weapon oil.")

				.modelName("model.oil.legendary.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(70) // no hard lock
				.build();

		oilDemiseLegendaryId = oilDemiseLegendary.getTemplateId();

	}

	private static void registeroilDemiseHuman() throws IOException {
		oilDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.oilDemiseHuman")
				.name(" oil of Human Demise", "oils of Human Demise",
						"An oil that smells of death. You find that it dissolves your own flesh easily, but doesn't harm animal flesh. Weird. " +
								"It needs to be filled into a crystalline phial to unfold its magical potential as a weapon oil.")

				.modelName("model.oil.human.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		oilDemiseHumanId = oilDemiseHuman.getTemplateId();

	}

	private static void registeroilLickOfFire() throws IOException {
		oilLickOfFire = new ItemTemplateBuilder("arathok.alchemy.oilFire")
				.name(" oil of lick of fire", "oils of lick of fire",
						"An oil that smells sulphury. It develops extreme heat on any surface fit touches. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.kissOfFire.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		oilLickOfFireId = oilLickOfFire.getTemplateId();

	}

	private static void registeroilKissOfFrost() throws IOException {
		oilKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.oilFrost")
				.name(" oil of Kiss of Frost", "oils of Kiss of Frost",
						"An oil that is cool to the touch. It freezes any surface it touches. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.kissOfFire.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		oilKissOfFrostId = oilKissOfFrost.getTemplateId();

	}

	private static void registeroilLech() throws IOException {
		oilLeech = new ItemTemplateBuilder("arathok.alchemy.oilLeech")
				.name(" oil of Leech", "oils of Leech",
						"An ominous oil. Smearing it upon a plant makes the plant wilt, but upon touching the oil on the plant you feel more vigorous. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.Heartseeker.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		oilLeechId = oilLeech.getTemplateId();

	}

	private static void registeroilPlague() throws IOException {
		oilPlague = new ItemTemplateBuilder("arathok.alchemy.oilPlague")
				.name(" oil of the Plague", "oils of Plague",
						"A forbidden oil. Smearing it upon anything makes it age and rot. Very Dangerous. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.plague.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(70) // no hard lock
				.build();

		oilPlagueId = oilPlague.getTemplateId();

	}

	private static void registeroilHeartseeker() throws IOException {
		oilHeartseeker = new ItemTemplateBuilder("arathok.alchemy.oilHeartseeker")
				.name(" oil of Heartseeker", "oils of Heartseeker",
						"An ominous oil. Smearing it upon your hand makes it always want to go on what you are focusing. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.Heartseeker.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		oilHeartseekerId = oilHeartseeker.getTemplateId();

	}

	private static void registeroilPoison() throws IOException {
		oilPoison = new ItemTemplateBuilder("arathok.alchemy.oilPoison")
				.name(" oil of Poison", "oils of Poison",
						"A forbidden oil. Smearing it upon your hand makes your body temperature rise in an instant, your veins turn blackish. " +
								"You sense this could be turned into a coating for weapons.")

				.modelName("model.oil.poison.")
				.imageNumber((short) 1549)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(50) // no hard lock
				.build();

		oilPoisonId = oilPoison.getTemplateId();
/// WEAPONOILS
	}
	private static void registerweaponOilDemiseAnimal() throws IOException {
		weaponOilDemiseAnimal = new ItemTemplateBuilder("arathok.alchemy.weaponoilAnimal")
				.name(" Weapon oil of the Hunter", "Weapon Oils of the Hunter",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Hunter.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilDemiseAnimalId = weaponOilDemiseAnimal.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilDemiseAnimalId, weaponOilDemiseAnimalId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilDemiseHuman() throws IOException {
		weaponOilDemiseHuman = new ItemTemplateBuilder("arathok.alchemy.weaponoilHuman")
				.name(" Weapon oil of the Murderer", "Weapon Oils of the Murderer",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Hunter.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilDemiseHumanId = weaponOilDemiseHuman.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilDemiseHumanId, weaponOilDemiseHumanId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilDemiseMonster() throws IOException {
		weaponOilDemiseMonster = new ItemTemplateBuilder("arathok.alchemy.weaponoilMonster")
				.name(" Weapon oil of the Monster Hunter", "Weapon oils of the Monster Hunter",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Monster.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilDemiseMonsterId = weaponOilDemiseMonster.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilDemiseMonsterId, weaponOilDemiseMonsterId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilDemiseLegendary() throws IOException {
		weaponOilDemiseLegendary = new ItemTemplateBuilder("arathok.alchemy.weaponoilDragon")
				.name(" Weapon oil of the Dragon Hunter", "Weapon Oils of Dragon Hunter",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.DragonHunter.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilDemiseLegendaryId = weaponOilDemiseLegendary.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilDemiseLegendaryId, weaponOilDemiseLegendaryId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilHeartseeker() throws IOException {
		weaponOilHeartseeker = new ItemTemplateBuilder("arathok.alchemy.weaponoilHeartseeker")
				.name(" Weapon oil of the Heartseeker", "Weapon Oils of the Heartseeker",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Heartseeker.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilHeartseekerId = weaponOilHeartseeker.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilHeartseekerId, weaponOilHeartseekerId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilKissOfFrost() throws IOException {
		weaponOilKissOfFrost = new ItemTemplateBuilder("arathok.alchemy.weaponoilFrost")
				.name(" Frostkiss Weapon oil ", "Weapon oils of Frostkiss",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Frostkiss.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilKissOfFrostId = weaponOilKissOfFrost.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilKissOfFrostId, weaponOilKissOfFrostId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilLickOfFire() throws IOException {
		weaponOilLickOfFire = new ItemTemplateBuilder("arathok.alchemy.weaponoilFire")
				.name(" Lick of Fire oil", "Weapon Oils of Lick of Fire",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.FireLick.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilLickOfFireId = weaponOilLickOfFire.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilLickOfFireId, weaponOilLickOfFireId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilPoison() throws IOException {
		weaponOilPoison = new ItemTemplateBuilder("arathok.alchemy.weaponoilPoison")
				.name(" Weapon oil of the Snake", "Weapon Oils of the Snake",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Poison.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilPoisonId = weaponOilPoison.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilPoisonId, weaponOilPoisonId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilPlague() throws IOException {
		weaponOilPlague = new ItemTemplateBuilder("arathok.alchemy.weaponoilPlague")
				.name(" Weapon oil of the Plague", "Weapon Oils of Plague",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Plague.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilPlagueId = weaponOilPlague.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilPlagueId, weaponOilPlagueId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}

	private static void registerweaponOilLeech() throws IOException {
		weaponOilLeech = new ItemTemplateBuilder("arathok.alchemy.weaponoilLeech")
				.name(" Weapon oil of the Plague", "Weapon Oils of Plague",
						"An alchemistic potion, drinking it will bestow the power of phasing to you.")

				.modelName("model.WeaponOil.Leech.")
				.imageNumber((short) 1569)
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
				.primarySkill(SkillList.GROUP_ALCHEMY)
				.difficulty(30) // no hard lock
				.build();

		weaponOilLeechId = weaponOilLeech.getTemplateId();

		CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY, AlchItems.phialId,AlchItems.oilLeechId, weaponOilLeechId, true, true, 0f, false, false,CreationCategories.ALCHEMY);
	}


	public static void register() throws IOException {

		registerLeader();
		registerGlassMixture();
		registerGlass();
		TempStates.addState(new TempState(AlchItems.glassMixtureId, AlchItems.glassId, (short) 4000, true, false, false));
		registerMouldClay();
		registerMouldPottery();
		TempStates.addState(new TempState(AlchItems.mouldClayId, AlchItems.mouldPotteryId, (short) 4000, true, true, false));
		registerPhial();
		registerPurifiedWater();
		if (Config.purifiedWaterCooking)
		TempStates.addState(new TempState(ItemList.water, AlchItems.purifiedWaterId, (short) 4000, true, true, false));
		registerAlchemicalCompound();

		registerMixtureHeal();
		registermixtureDodging();
		registermixtureExcell();
		registermixtureFrenzy();
		registerMixtureGoat();
		registermixtureMorningFog();
		registermixtureOakshell();
		registermixtureRefresh();
		registermixtureSixthSense();
		registermixtureStrength();
		registermixtureTruehit();
		registermixtureVyn();

		registerPrecursorDodge();
		registerPrecursorExcell();
		registerPrecursorGoat();
		registerPrecursorFranticCharge();
		registerPrecursorHeal();
		registerPrecursorMorningFog();
		registerPrecursorOakshell();
		registerPrecursorRefresh();
		registerPrecursorSixthSense();
		registerPrecursorStrength();
		registerPrecursorTruehit();
		registerPrecursorVynora();

		registerPotionLiquidDodge();
		registerPotionLiquidExcell();
		registerPotionLiquidGoat();
		registerPotionLiquidFranticCharge();
		registerPotionLiquidHeal();
		registerPotionLiquidMorningFog();
		registerPotionLiquidOakshell();
		registerPotionLiquidRefresh();
		registerPotionLiquidSixthSense();
		registerPotionLiquidStrength();
		registerPotionLiquidTruehit();
		registerPotionLiquidVynora();

		registerPotionDodge();
		registerPotionExcell();
		registerPotionGoat();
		registerPotionFrenzy();
		registerPotionHeal();
		registerPotionMorningFog();
		registerPotionOakshell();
		registerPotionRefresh();
		registerPotionSixthSense();
		registerPotionStrength();
		registerPotionTruehit();
		registerPotionVynora();

		TempStates.addState(new TempState(AlchItems.precursorExcellId, AlchItems.potionLiquidExcellId, (short) 4000,true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorFranticChargeId, AlchItems.potionLiquidFranticChargeId,(short) 4000, true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorGoatId, AlchItems.potionLiquidGoatId, (short) 4000, true,true, false));
		TempStates.addState(new TempState(AlchItems.precursorHealId, AlchItems.potionLiquidHealId, (short) 4000, true,true, false));
		TempStates.addState(new TempState(AlchItems.precursorMorningFogId, AlchItems.potionLiquidMorningFogId,(short) 4000, true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorOakshellId, AlchItems.potionLiquidOakshellId, (short) 4000,true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorRefreshId, AlchItems.potionLiquidRefreshId, (short) 4000,true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorTruehitId, AlchItems.potionLiquidTruehitId, (short) 4000,true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorSixthSenseId, AlchItems.potionLiquidSixthSenseId,(short) 4000, true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorStrengthId, AlchItems.potionLiquidStrengthId, (short) 4000,true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorVynoraId, AlchItems.potionLiquidVynoraId, (short) 4000,true, true, false));
		TempStates.addState(new TempState(AlchItems.precursorWillowspineId, AlchItems.potionLiquidWillowspineId,(short) 4000, true, true, false));

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



			TempStates.addState(new TempState(AlchItems.sludgeHeartseekerId, AlchItems.oilHeartseekerId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeLeechId, AlchItems.oilLeechId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgePlagueId, AlchItems.oilPlagueId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgePoisonId, AlchItems.oilPoisonId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeDemiseAnimalId, AlchItems.oilDemiseAnimalId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeDemiseHumanId, AlchItems.oilDemiseHumanId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeDemiseMonsterId, AlchItems.oilDemiseMonsterId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeDemiseLegendaryId, AlchItems.oilDemiseLegendaryId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeLickOfFireId, AlchItems.oilLickOfFireId, (short) 4000, true, true, false));
			TempStates.addState(new TempState(AlchItems.sludgeKissOfFrostId, AlchItems.oilKissOfFrostId, (short) 4000, true, true, false));
		}
	}

}