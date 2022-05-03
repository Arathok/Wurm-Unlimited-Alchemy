package org.arathok.wurmunlimited.mods.alchemy.enchantments;


import com.wurmonline.server.Players;
import com.wurmonline.server.WurmCalendar;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modsupport.ModSupportDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Enchantment {



    public long itemId=0L;
    public long timeOfEnchantment;
    public byte enchantmentType;
    public boolean hasOil;


 public static void readFromSQL(Connection dbconn, LinkedList<Enchantment> enchantments) throws SQLException {
     Enchantment e=null;
        PreparedStatement ps = dbconn.prepareStatement("SELECT * FROM Alchemy");
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {



            e.itemId = rs.getLong("itemId"); // liest quasi den Wert von der Spalte
            e.p = Players.getInstance().getPlayerOrNull(target.getOwnerId());
            e.timeRunout = System.currentTimeMillis() + (seconds * 1000L);
            e.enchantmentType = eff.type;
            e.hasOil = true;
            EnchantmentHandler.enchantments.add(e);
        }
    }

    public void insert(Connection dbconn) throws SQLException {

        PreparedStatement ps = dbconn.prepareStatement("insert into Alchemy (itemID,timeOfEnchantment,enchantment,hasOil) values (?,?,?,?)");
        ps.setLong(1,this.itemId);
        ps.setLong(2, WurmCalendar.getCurrentTime());
        ps.setByte(3, this.enchantmentType);
        ps.setBoolean(4,this.hasOil);
        ps.executeUpdate();



    }






}