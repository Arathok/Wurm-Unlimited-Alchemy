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
import java.util.List;

public class Enchantment {



    public long itemId=0L;
    public long timeOfEnchantment=0;
    public byte enchantmentType=0;
    public boolean hasOil=false;
    public long playerId = 0;
    public String itemNameBeforeEnchantment="";


 public static void readFromSQL(Connection dbconn, List<Enchantment> enchantments) throws SQLException {
     Enchantment e=new Enchantment();
        PreparedStatement ps = dbconn.prepareStatement("SELECT * FROM Alchemy");
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {



            e.itemId = rs.getLong("itemId"); // liest quasi den Wert von der Spalte
            e.timeOfEnchantment = rs.getLong("timeOfEnchantment");
            e.enchantmentType = rs.getByte("enchantmentType");
            e.hasOil = rs.getBoolean("hasOil");
            e.playerId = rs.getLong("playerId");
            e.itemNameBeforeEnchantment=rs.getString("itemNameBeforeEnchantment");
            EnchantmentHandler.enchantments.add(e);

        }
    }

    public void insert(Connection dbconn) throws SQLException {

        PreparedStatement ps = dbconn.prepareStatement("insert into Alchemy (itemID,playerId,timeOfEnchantment,enchantmentType,hasOil,itemNameBeforeEnchantment) values (?,?,?,?,?,?)");
        ps.setLong(1,this.itemId);
        ps.setLong(2, this.playerId);
        ps.setLong(3, this.timeOfEnchantment);
        ps.setByte(4, this.enchantmentType);
        ps.setBoolean(5,this.hasOil);
        ps.setString(6,this.itemNameBeforeEnchantment);

        ps.executeUpdate();



    }








}