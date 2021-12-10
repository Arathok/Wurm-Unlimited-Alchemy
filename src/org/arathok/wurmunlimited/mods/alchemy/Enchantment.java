package org.arathok.wurmunlimited.mods.alchemy;

import com.sun.mail.imap.protocol.Item;
import com.wurmonline.server.Players;
import com.wurmonline.server.creatures.SpellEffects;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.spells.SpellEffect;

import java.util.Map;

public class Enchantment {

    static Long oilTimer = Config.oilDuration;
    static Item i = null;
    static Long wurmId = 0;
    SpellEffect eff = null;

    public static void EnchantmentHandler()  {


        for (Map.Entry<Long, Long> set : Alchemy.weaponsWithOils.entrySet())
        {
            if (oilTimer < System.currentTimeMillis()) {

                wurmId = set.getKey();
                if (wurmId != null) {

                    if (System.currentTimeMillis()<set.getValue()) {

                        p.getCommunicator().sendAlertServerMessage("Your Alchemic Addiction is Low.");
                        p.getCommunicator().sendAlertServerMessage("You feel like you have waited long enough to drink another potion" );
                        p.getCommunicator().sendAlertServerMessage(" without getting your body addicted to the magical powers.");
                    }

                    if (currentAddictionLevel > previousAddictionLevel && currentAddictionLevel == 4) {

                        p.getCommunicator().sendAlertServerMessage("You are just one small step before becoming addicted to the power of potions. You sense some dread in that thought.");
                    }

                    if (currentAddictionLevel > 5) {

                        p.getCommunicator().sendAlertServerMessage("You are addicted to potions.");
                    }

                    if (currentAddictionLevel > 5 && previousAddictionLevel > currentAddictionLevel) {

                        SpellEffects effs = p.getSpellEffects();

                        if (effs == null)
                            effs = p.createSpellEffects();

                        SpellEffect eff = effs.getSpellEffect((byte) 41);

                        if (eff == null) {
                            eff = new SpellEffect(
                                    p.getWurmId(),
                                    (byte) 41,
                                    100,
                                    Math.max(1, seconds));

                            effs.addSpellEffect(eff);
                        } else if (eff.getPower() < 100) {
                            eff.setPower(100);
                            eff.setTimeleft(Math.max(eff.timeleft, Math.max(1, seconds)));
                            p.sendUpdateSpellEffect(eff);
                        }

                        p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
                        p.getCommunicator().sendSafeServerMessage("Alchemical power is poisoning you. You feel weak.");
                    }

                    if (currentAddictionLevel < 12 && currentAddictionLevel >= 10 && previousAddictionLevel > currentAddictionLevel) {

                        p.addWoundOfType(p, (byte) 5, 23, false, 1.0F, false, 10000, (float) 1, 0.0F, false, true);
                        p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks to tolerable levels.");
                    }

                    if (currentAddictionLevel < 15 && currentAddictionLevel >= 12 && previousAddictionLevel > currentAddictionLevel) {

                        p.addWoundOfType(p, (byte) 5, 23, false, 1.0F, false, 15000, (float) 1, 0.0F, false, true);
                        p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks to bearable levels.");
                    }

                    if (currentAddictionLevel < 20 && currentAddictionLevel >= 15 && previousAddictionLevel > currentAddictionLevel) {

                        p.addWoundOfType(p, (byte) 5, 23, false, 1.0F, false, 20000, (float) 1, 0.0F, false, true);
                        p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks but its still at dangerous levels");
                        p.addWoundOfType(p, (byte) 9, 1, false, 1.0F, false, 10000, 0.0F, 0.0F, false, true);
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body slightly messes with your brain.");
                    }

                    if (currentAddictionLevel < 25 && currentAddictionLevel >= 20 && previousAddictionLevel > currentAddictionLevel) {

                        p.addWoundOfType(p, (byte) 5, 23, false, 1.0F, false, 30000, (float) 1, 0.0F, false, true);
                        p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body sinks but its still at dangerous levels");
                        p.addWoundOfType(p, (byte) 9, 1, false, 1.0F, false, 20000, 0.0F, 0.0F, false, true);
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body messes with your brain.");
                    }

                    if (currentAddictionLevel > 25 && previousAddictionLevel > currentAddictionLevel) {

                        p.addWoundOfType(p, (byte) 5, 23, false, 1.0F, false, 30000, (float) 1, 0.0F, false, true);
                        p.getCommunicator().sendAlertServerMessage("Your addiction to potions causes withdrawal symptoms in your body.");
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body is at dangerous levels");
                        p.addWoundOfType(p, (byte) 9, 1, false, 1.0F, false, 30000, 0.0F, 0.0F, false, true);
                        p.getCommunicator().sendSafeServerMessage("The toxicity in your body messes heavily with your brain.");
                    }
                    long temp;
                    temp=seconds;
                    Alchemy.currentAddiction.put(wurmId, currentAddictionLevel - 1);
                    Alchemy.previousAddiction.put(wurmId, currentAddictionLevel);
                    oilTimer = System.currentTimeMillis() + (temp * 1000);
                }
            }

        }

    }
}


