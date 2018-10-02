/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Allysha
 */
public class StockModel extends MyModel {
    private int stock_id;
    private int product_id;
    private int stock_onhand;
    private int deleteStatus;


public ResultSet viewAll(){
    Statement st;
    ResultSet ret = null;
    this.initialize();
    
    String str = "SELECT * from stock" ;    

    try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
            ResultSet rs = st.executeQuery(str);
        } catch (SQLException ex) {}
        return null;
}




}