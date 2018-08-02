/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author allysh@
 */
public class SalesModel extends MyModel {
    
    private int sales_id;
    private int employee_id;
    private float changefund;
    private float total_sales;
    private String name;
    
    /*public int getEmployeeID(String name){
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "select `employee_id` from `employee` where name ='"
                +name+"' limit 1";
        System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            System.out.println("HELLO");
            ret = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {}
        return ret;
    }
    */
    
    public int addChangefund(){
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `sales` (`sales_id`,`sales_datetime`,`employee_id`, `changefund`) VALUES(NULL, CURRENT_TIMESTAMP,(SELECT `employee_id` FROM `employee` WHERE username = '"+this.name+"' ), '"+this.changefund+"')";
        //String str = "INSERT INTO `sales` (`sales_id`, `changefund`) VALUES(NULL, '"+this.changefund+"')"; 
        
        System.out.println(this.name);
        try {
            st = conn.prepareStatement(str);
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(SalesModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int getSales_id(){
        return sales_id;
    }
    
    public void setSales_id(int sales_id){
        this.sales_id = sales_id;
    }
    
    public float getChangefund(){
        return changefund;
    }
    
    public void setChangefund(float changefund){
        this.changefund = changefund;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    
    
    
}
