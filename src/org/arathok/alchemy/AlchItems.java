package org.arathok.wurmunlimited.mods.alchemy; // now add calls to registerBlah in onItemTemplatesCreated
//and make them not-private so you can actually access them

import java.io.IOException;
import java.util.Properties;

import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;

import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.items.CreationCategories;
import com.wurmonline.server.items.CreationEntryCreator;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.Materials;
import com.wurmonline.server.items.TempState;
import com.wurmonline.server.items.TempStates;


public class AlchItems {
	  public static int leaderId,phialId,mouldClayId,mouldPotteryId,purifiedWaterId,alchemicalCompoundId,glassId,
	    
	    mixtureHealId,mixtureGoatId,mixtureExcellId,mixtureOakshellId,mixtureMorningFogId,mixtureFranticChargeId,mixtureStrengthId,
	    mixtureSixthSenseId,mixtureTruehitId,mixtureWillowspineId,mixtureRefreshId,mixtureVynoraId,
	    
	    precursorHealId,precursorGoatId,precursorExcellId,precursorOakshellId,precursorMorningFogId,precursorFranticChargeId,precursorStrengthId,
	    precursorSixthSenseId,precursorTruehitId,precursorWillowspineId,precursorRefreshId,precursorVynoraId,
	    
	    potionLiquidHealId,potionLiquidGoatId,potionLiquidExcellId,potionLiquidOakshellId,potionLiquidMorningFogId,potionLiquidFranticChargeId,potionLiquidStrengthId,
	    potionLiquidSixthSenseId,potionLiquidTruehitId,potionLiquidWillowspineId,potionLiquidRefreshId,potionLiquidVynoraId,
	    
	    potionIdHeal,potionIdGoat,potionIdExcell,potionIdOakshell,potionIdMorningFog,potionIdFranticCharge,potionIdStrength,
	    potionIdSixthSense,potionIdTruehit,potionIdWillowspine,potionIdRefresh,potionIdVynora
	    ;
	    public static ItemTemplate phial,mouldClay,mouldPottery,purifiedWater,alchemicalCompound,glass,
	    
	    leader,mixtureHeal,mixtureGoat,mixtureExcell,mixtureOakshell,mixtureMorningFog,mixtureFranticCharge,mixtureStrength,
	    mixtureSixthSense,mixtureTruehit,mixtureWillowspine,mixtureRefresh,mixtureVynora,
	    
	    precursorHeal,precursorGoat,precursorExcell,precursorOakshell,precursorMorningFog,precursorFranticCharge,precursorStrength,
	    precursorSixthSense,precursorTruehit,precursorWillowspine,precursorRefresh,precursorVynora,
	    
	    potionLiquidHeal,potionLiquidGoat,potionLiquidExcell,potionLiquidOakshell,potionLiquidMorningFog,potionLiquidFranticCharge,potionLiquidStrength,
	    potionLiquidSixthSense,potionLiquidTruehit,potionLiquidWillowspine,potionLiquidRefresh,potionLiquidVynora,
	    
	    potionHeal,potionGoat,potionExcell,potionOakshell,potionMorningFog,potionFranticCharge,potionStrength,
	    potionSixthSense,potionTruehit,potionWillowspine,potionRefresh,potionVynora
	    ;
    
	    private static void registerLeader() throws IOException {
	        leader = new ItemTemplateBuilder("arathok.alchemy.leader")
	                .name("unusualleader66", "useless bums", "Hairy ass lengthy dude and a very good friend")
	                .modelName("model.decoration.statuette.magranon.")
	                .imageNumber((short) IconConstants.ICON_FOOD_PIGFOOD)
	                .itemTypes(new short[]{
	                        ItemTypes.ITEM_TYPE_POTTERY,
	                        ItemTypes.ITEM_TYPE_PLANTABLE,
	                        ItemTypes.ITEM_TYPE_DECORATION,
	                        ItemTypes.ITEM_TYPE_TURNABLE,
	                        ItemTypes.ITEM_TYPE_REPAIRABLE,
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
	      
	       
	leaderId = leader.getTemplateId();
	    }
	    
	    private static void registerGlass() throws IOException {
	        glass = new ItemTemplateBuilder("arathok.alchemy.leader")
	                .name("glass", "glass", "Crystal clear glass. If you could make a phial out of it, it could contain magic stored in potions.")
	                .modelName("model.decoration.flask.")
	                .imageNumber((short) IconConstants.ICON_FOOD_PIGFOOD)
	                .itemTypes(new short[]{
	                        
	                        ItemTypes.ITEM_TYPE_PLANTABLE,
	                        ItemTypes.ITEM_TYPE_DECORATION,
	                        ItemTypes.ITEM_TYPE_TURNABLE,
	                        ItemTypes.ITEM_TYPE_REPAIRABLE,
	                       // ItemTypes.ITEM_TYPE_TRANSPORTABLE,
	                        ItemTypes.ITEM_TYPE_METAL,
	                    
	                        
	                        
	                })
	                .decayTime(9072000L)
	                .dimensions(8, 8, 15)
	                .weightGrams(500)
	                .material(Materials.MATERIAL_IRON)
	                .behaviourType((short) 1)
	                .primarySkill(SkillList.POTTERY)
	                .difficulty(30) // no hard lock
	                .build();
	      
	       
	glassId = glass.getTemplateId();
	    }
    private static void registerMouldClay() throws IOException {
        mouldClay = new ItemTemplateBuilder("arathok.alchemy.mouldClay")
                .name("phial mould", "phial moulds", "A clay mould that could be used to make phials, but it still needs to be fired.")
                .modelName("model.mouldClay.")
                .imageNumber((short) IconConstants.ICON_KEY_MOLD)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_POTTERY,
                        ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
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

CreationEntryCreator.createSimpleEntry(SkillList.POTTERY, ItemList.bodyHand, ItemList.clay, mouldClayId, false, true, 0.0f, false, false, CreationCategories.POTTERY);
}// nichts weiter
    private static void registerMouldPottery() throws IOException {
            mouldPottery = new ItemTemplateBuilder("arathok.alchemy.mouldPottery")
                .name("phial mould", "phial moulds", "A pottery mould that is used to make glass phials")
                .modelName("model.mouldPottery.")
                .imageNumber((short) IconConstants.ICON_KEY_FORM)
                .itemTypes(new short[]{
                		 ItemTypes.ITEM_TYPE_POTTERY,
                         ItemTypes.ITEM_TYPE_PLANTABLE,
                         ItemTypes.ITEM_TYPE_DECORATION,
                         ItemTypes.ITEM_TYPE_TURNABLE,
                         ItemTypes.ITEM_TYPE_REPAIRABLE,
                        // ItemTypes.ITEM_TYPE_TRANSPORTABLE,
                         ItemTypes.ITEM_TYPE_TOOL,
                         ItemTypes.ITEM_TYPE_METAL,
                })
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
                .imageNumber((short) IconConstants.ICON_MISC_FLASK_GLASS)
                .itemTypes(new short[]{
                		 ItemTypes.ITEM_TYPE_BULK,
                         ItemTypes.ITEM_TYPE_PLANTABLE,
                         ItemTypes.ITEM_TYPE_DECORATION,
                         ItemTypes.ITEM_TYPE_TURNABLE,
                         ItemTypes.ITEM_TYPE_REPAIRABLE,
                        // ItemTypes.ITEM_TYPE_TRANSPORTABLE,
                         ItemTypes.ITEM_TYPE_TOOL,
                        
                })
                .decayTime(9072000L)
                .dimensions(5, 5, 10)
                .weightGrams(100)
                .material(Materials.MATERIAL_GLASS)
                .behaviourType((short) 1)
                .primarySkill(SkillList.ALCHEMY_NATURAL)
                .difficulty(10) // no hard lock
                .build();

phialId = phial.getTemplateId();

CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,AlchItems.mouldPotteryId , AlchItems.glassId, phialId, false, true, 0f, false, false, CreationCategories.DECORATION);
} // NO ADDITIONAL ITEMS NEEDED
    private static void registerPurifiedWater() throws IOException {
        purifiedWater = new ItemTemplateBuilder("arathok.alchemy.purifiedWater")
            .name("purified water", "purified water", "Water that has been cleaned from mundane impurities"
            		+ " and is ready to take in a powerful essence.")
            .modelName("model.purfiedWater.")
            .imageNumber((short) IconConstants.ICON_LIQUID_WATER)
            .itemTypes(new short[]{
            		
            		ItemTypes.ITEM_TYPE_BULK,
             		ItemTypes.ITEM_TYPE_LIQUID,
            		
            })
            .decayTime(9072000L)
            .dimensions(1, 1, 1)
            .weightGrams(500)
            .material(Materials.MATERIAL_MAGIC)
            .behaviourType((short) 1)
            .primarySkill(SkillList.ALCHEMY_NATURAL)
            .difficulty(5) // no hard lock
            .build();

purifiedWaterId = purifiedWater.getTemplateId();
}
    private static void registerAlchemicalCompound() throws IOException {
    	  alchemicalCompound = new ItemTemplateBuilder("arathok.alchemy.alchemicalCompound")
    			  .name("alchemical compound", "alchemical compounds", "A whiteish liquid smelling pretty badly. Its made from the essence of a beast"
                    		+ " and you can sense it holds potential to store the power of natural substances")
                  
                  .modelName("model.alchemicalCompound.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                  		 ItemTypes.ITEM_TYPE_BULK,
                  		 ItemTypes.ITEM_TYPE_LIQUID,
                  		
                         
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(1000)
                  .material(Materials.MATERIAL_MAGIC)
                  .material(Materials.MATERIAL_IRON)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.GROUP_ALCHEMY)
                  .difficulty(10) // no hard lock
                  .build();

  alchemicalCompoundId = alchemicalCompound.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY,AlchItems.purifiedWaterId , ItemList.heart, alchemicalCompoundId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }    
    private static void registerMixtureHeal() throws IOException {
  	  mixtureHeal = new ItemTemplateBuilder("arathok.alchemy.mixtureHeal")
                .name("mixture", "mixtures","A mixture of different alchemical substances. One day it might be making a fine potion."
                		+ "This seems to have some healing Properties.")
                
                .modelName("model.mixtureHeal.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                .itemTypes(new short[]{
                		 ItemTypes.ITEM_TYPE_BULK,
                		 ItemTypes.ITEM_TYPE_HERB,
                		 ItemTypes.ITEM_TYPE_PLANTABLE,
                         ItemTypes.ITEM_TYPE_DECORATION,
                         ItemTypes.ITEM_TYPE_TURNABLE,
                         ItemTypes.ITEM_TYPE_REPAIRABLE,
                        
                })
                .decayTime(9072000L)
                .dimensions(1, 1, 1)
                .weightGrams(100)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(SkillList.ALCHEMY_NATURAL)
                .difficulty(30) // no hard lock
                .build();

mixtureHealId = mixtureHeal.getTemplateId();

CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,ItemList.mushroomBrown , ItemList.wheat, mixtureHealId, true, true, 0f, false, false, CreationCategories.DECORATION);
}    
    private static void registerMixtureGoat() throws IOException {
    	  mixtureGoat = new ItemTemplateBuilder("arathok.alchemy.mixtureGoat")
                  .name("mixture of Goat", "mixtures of Goat","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ " It smells like a Goat... weird.")
                  
                  .modelName("model.mixture.goat.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(30) // no hard lock
                  .build();

  mixtureGoatId = mixtureGoat.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,ItemList.branch , ItemList.oat, mixtureGoatId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }
    private static void registermixtureExcell() throws IOException {
    	  mixtureExcell = new ItemTemplateBuilder("arathok.alchemy.mixtureExcell")
                  .name("mixture of surpass", "mixtures of surpass","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "Smelling it you feel energetic. Rubbing it on your fingers makes your skin seem to be softer and not as easy to cut."
                  		)
                  
                  .modelName("model.mixture.excell.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(30) // no hard lock
                  .build();

  mixtureExcellId = mixtureExcell.getTemplateId();

  CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL,ItemList.ginger , ItemList.sassafras, mixtureExcellId, true, true, 0f, false, false, CreationCategories.DECORATION)
  .addRequirement(new CreationRequirement(1,ItemList.mushroomRed,1,true))
  ;
  }
    private static void registermixtureOakshell() throws IOException {
    	  mixtureOakshell = new ItemTemplateBuilder("arathok.alchemy.mixtureOakshell")
                  .name("mixture of Oakshell", "mixtures of Oakshell","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "it seems to make your skin somewhat woodifies and becomes harder when you touch it."
                  		)
                  
                  .modelName("model.mixture.oakshell.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(50) // no hard lock
                  .build();

  mixtureOakshellId = mixtureOakshell.getTemplateId();

  CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.acorn, ItemList.rock, mixtureOakshellId, true, true, 0f, false, false, CreationCategories.DECORATION)
  .addRequirement(new CreationRequirement(1, ItemList.mushroomBlue, 1, true))
  .addRequirement(new CreationRequirement(2, ItemList.sage, 1, true))
  ;
    }
    private static void registermixtureMorningFog() throws IOException {
    	  mixtureMorningFog = new ItemTemplateBuilder("arathok.alchemy.mixtureFog")
                  .name("mixture of Fog", "mixtures of Fog","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "Sniffing it your body seems to bend around sharp objects as if it wants to protect itself."
                  		)
                  
                  .modelName("model.mixture.fog.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(30) // no hard lock
                  .build();

  mixtureMorningFogId = mixtureMorningFog.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,ItemList.lingonberry , ItemList.wemp, mixtureMorningFogId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }
    private static void registermixtureRefresh() throws IOException {
    	  mixtureRefresh = new ItemTemplateBuilder("arathok.alchemy.mixtureRefresh")
                  .name("mixture of refreshing", "mixtures of Refreshing","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "You sense it giving off a whiff of cool air. It seems to be able to strip some tiredness off you."
                  		)
                  
                  .modelName("model.mixture.refresh.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(20) // no hard lock
                  .build();

  mixtureRefreshId = mixtureRefresh.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,ItemList.carrot , ItemList.potato, mixtureRefreshId, true, true, 0f, false, false, CreationCategories.DECORATION);
  CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,ItemList.mint , ItemList.fennel, mixtureRefreshId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }
    private static void registermixtureSixthSense() throws IOException {
    	  mixtureSixthSense = new ItemTemplateBuilder("arathok.alchemy.mixtureSixthSense")
                  .name("mixture of senses", "mixtures of senses","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "The smell brings a certain picture before the inner eye. Like a voice telling you, to be careful with your surroundings"
                  		)
                  
                  .modelName("model.mixture.sixth.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                  		 //ItemTypes.ITEM_TYPE_BULK,
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                         
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(30) // no hard lock
                  .build();

  mixtureSixthSenseId = mixtureSixthSense.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.ALCHEMY_NATURAL,ItemList.lovage , ItemList.nettles, mixtureSixthSenseId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }
    private static void registermixtureStrength() throws IOException {
    	  mixtureStrength = new ItemTemplateBuilder("arathok.alchemy.mixture")
                  .name("mixture of Strength", "mixtures of Strength","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "The smell makes you feel like you could lift a mountain."
                  		)
                  
                  .modelName("model.mixture.strength.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                  		// ItemTypes.ITEM_TYPE_BULK,
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                         
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(40) // no hard lock
                  .build();

  mixtureStrengthId = mixtureStrength.getTemplateId();

  CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.mushroomBlack, ItemList.paprika, mixtureStrengthId, true, true, 0f, true, false, CreationCategories.ALCHEMY)
  .addRequirement(new CreationRequirement(1, ItemList.woad, 1, true));
    }
    
    private static void registermixtureTruehit() throws IOException {
    	  mixtureTruehit = new ItemTemplateBuilder("arathok.alchemy.mixtureTruehit")
                  .name("mixture of truehit", "mixtures of truehit","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "The belladonna is widening your eyes, uncovering weak spots on enemies"
                  		)
                  
                  .modelName("model.mixture.truehit.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(50) // no hard lock
                  .build();

  mixtureTruehitId = mixtureTruehit.getTemplateId();

  CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.belladonna, ItemList.garlic, mixtureTruehitId, true, true, 0f, false, false, CreationCategories.DECORATION)
  .addRequirement(new CreationRequirement(1, ItemList.mushroomGreen, 1, true));
    }
    private static void registermixtureVyn() throws IOException {
    	  mixtureVynora = new ItemTemplateBuilder("arathok.alchemy.mixtureVyn")
                  .name("mixture of Knowledge", "mixtures of Knowledge","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "This mixture has captured the essence of knowledge itself. You can feel Vynora smile down on you. You are grasping for the summit of Alchemy"
                  		)
                  
                  .modelName("model.mixture.vyn.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(90) // no hard lock
                  .build();

  mixtureVynoraId = mixtureVynora.getTemplateId();

  CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL, ItemList.mushroomYellow, ItemList.turmeric, mixtureVynoraId, true, true, 0f, false, false, CreationCategories.DECORATION)
  .addRequirement(new CreationRequirement(1, ItemList.strawberries, 1, true))
  .addRequirement(new CreationRequirement(2, ItemList.thyme, 1, true))
  .addRequirement(new CreationRequirement(2, ItemList.cumin, 1, true))
  .addRequirement(new CreationRequirement(2, ItemList.coinSilver, 1, true));
  
    }
    private static void registermixtureFrenzy() throws IOException {
    	  mixtureFranticCharge = new ItemTemplateBuilder("arathok.alchemy.mixtureFrenzy")
                  .name("mixture of frenzy", "mixtures of frenzy","A mixture of different alchemical substances. One day it might be making a fine potion."
                  		+ "Smelling this mixture makes you agressive, it seems to call to you to let out your inner beast."
                  		)
                  
                  .modelName("model.mixture.frenzy.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_HERB,
                 		 ItemTypes.ITEM_TYPE_PLANTABLE,
                          ItemTypes.ITEM_TYPE_DECORATION,
                          ItemTypes.ITEM_TYPE_TURNABLE,
                          ItemTypes.ITEM_TYPE_REPAIRABLE,
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.ALCHEMY_NATURAL)
                  .difficulty(30) // no hard lock
                  .build();

  mixtureFranticChargeId = mixtureFranticCharge.getTemplateId();

  CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL,ItemList.mushroomRed , ItemList.nutmeg, mixtureFranticChargeId, true, true, 0f, false, false, CreationCategories.DECORATION)
  .addRequirement(new CreationRequirement(1, ItemList.tomato, 1, true))
  .addRequirement(new CreationRequirement(2, ItemList.tooth, 1, true));
    }
    
    private static void registermixtureDodging() throws IOException {
  	  mixtureWillowspine = new ItemTemplateBuilder("arathok.alchemy.mixtureDodge")
                .name("mixture of shadow", "mixtures of shadow","A mixture of different alchemical substances. One day it might be making a fine potion."
                		+ "Smelling this mixture makes you feel safe. You feel like the universe is putting its protective hands around you, turn you into a Shadow."
                		+ "You feel like nothing can really hurt your new form "
                		)
                
                .modelName("model.mixture.shadow.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                .itemTypes(new short[]{
                		ItemTypes.ITEM_TYPE_BULK,
               		 ItemTypes.ITEM_TYPE_HERB,
               		 ItemTypes.ITEM_TYPE_PLANTABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
                        
                })
                .decayTime(9072000L)
                .dimensions(1, 1, 1)
                .weightGrams(100)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(SkillList.ALCHEMY_NATURAL)
                .difficulty(30) // no hard lock
                .build();

mixtureWillowspineId = mixtureWillowspine.getTemplateId();

CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL,ItemList.rosemary , ItemList.ivySeedling, mixtureFranticChargeId, true, true, 0f, false, false, CreationCategories.DECORATION)
.addRequirement(new CreationRequirement(1, ItemList.pumpkin, 1, true))
.addRequirement(new CreationRequirement(2, ItemList.eye, 1, true));
  }
    
    private static void registerPrecursorHeal() throws IOException {
    	  precursorHeal = new ItemTemplateBuilder("arathok.alchemy.precursorHeal")
                  .name("potion precursor healing", "precursors of healing", "A potion precursor. It got the essence of Healing stored within."
                  		+ "you think its magical properties could be activated by heating it.")
                  
                  .modelName("model.precursor.heal")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                		  ItemTypes.ITEM_TYPE_BULK,
                 		 ItemTypes.ITEM_TYPE_LIQUID,
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.GROUP_ALCHEMY)
                  .difficulty(30) // no hard lock
                  .build();

  precursorHealId = precursorHeal.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY,AlchItems.alchemicalCompoundId , AlchItems.mixtureHealId, precursorHealId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }
    
    private static void registerPrecursorExcell() throws IOException {
  	  precursorExcell = new ItemTemplateBuilder("arathok.alchemy.precursorExcell")
                .name("potion precursor surpassing", "precursors of surpassing", "A potion precursor. It got the essence of surpassing your foes stored within.")
                
                .modelName("model.precursor.excell.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                .itemTypes(new short[]{
                		 ItemTypes.ITEM_TYPE_BULK,
                		 ItemTypes.ITEM_TYPE_LIQUID,
                       
                        
                })
                .decayTime(9072000L)
                .dimensions(1, 1, 1)
                .weightGrams(100)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(SkillList.GROUP_ALCHEMY)
                .difficulty(30) // no hard lock
                .build();

precursorExcellId = precursorExcell.getTemplateId();

CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY,AlchItems.alchemicalCompoundId , AlchItems.mixtureExcellId, precursorExcellId, true, true, 0f, false, false, CreationCategories.DECORATION);
}
    
    private static void registerPrecursorGoat() throws IOException {
    	  precursorGoat = new ItemTemplateBuilder("arathok.alchemy.precursorGoat")
                  .name("potion precursor of goat", "precursors of goat", "A potion precursor. It got the essence of a goat stored within. Weird.")
                  
                  .modelName("model.precursor.excell.")
                  .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                  .itemTypes(new short[]{
                  		 ItemTypes.ITEM_TYPE_BULK,
                  		 ItemTypes.ITEM_TYPE_LIQUID,
                         
                          
                  })
                  .decayTime(9072000L)
                  .dimensions(1, 1, 1)
                  .weightGrams(100)
                  .material(Materials.MATERIAL_MAGIC)
                  .behaviourType((short) 1)
                  .primarySkill(SkillList.GROUP_ALCHEMY)
                  .difficulty(30) // no hard lock
                  .build();

  precursorGoatId = precursorGoat.getTemplateId();

  CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY,AlchItems.alchemicalCompoundId , AlchItems.mixtureGoatId, precursorGoatId, true, true, 0f, false, false, CreationCategories.DECORATION);
  }
    
    private static void registerPrecursorDodge() throws IOException {
  	  precursorWillowspine = new ItemTemplateBuilder("arathok.alchemy.precursorDodge")
                .name("potion precursor of dodging", "precursors of dodging", "A potion precursor. It got the essence of agility stored within.")
                
                .modelName("model.precursor.dodge.")
                .imageNumber((short) IconConstants.ICON_LIQUID_DYE_WHITE)
                .itemTypes(new short[]{
                		 ItemTypes.ITEM_TYPE_BULK,
                		 ItemTypes.ITEM_TYPE_LIQUID,
                       
                        
                })
                .decayTime(9072000L)
                .dimensions(1, 1, 1)
                .weightGrams(100)
                .material(Materials.MATERIAL_MAGIC)
                .behaviourType((short) 1)
                .primarySkill(SkillList.GROUP_ALCHEMY)
                .difficulty(30) // no hard lock
                .build();

precursorWillowspineId = precursorWillowspine.getTemplateId();

CreationEntryCreator.createSimpleEntry(SkillList.GROUP_ALCHEMY,AlchItems.alchemicalCompoundId , AlchItems.mixtureWillowspineId, precursorWillowspineId, true, true, 0f, false, false, CreationCategories.DECORATION);
}
    
      
    public static void register() throws IOException {
    	
    	registerLeader();
    	registerGlass();
    	TempStates.addState(new TempState(ItemList.sand, AlchItems.glassId, (short)4000, true, true, false));
    	registerMouldClay();
        registerMouldPottery();
        TempStates.addState(new TempState(AlchItems.mouldClayId, AlchItems.mouldPotteryId, (short)4000, true, true, false));
        registerPhial();
        registerPurifiedWater();
    	TempStates.addState(new TempState(ItemList.water, AlchItems.purifiedWaterId, (short)4000, true, true, false));
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
    	registerPrecursorHeal();
    	
    }
    
}