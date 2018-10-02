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
public class DeliveryModel extends MyModel{ 
    private int delivery_id;    
    private int product_id;
    private float delivery_unitprice;
    private int delivery_numberofunits;
    private String delivery_unitofmeasure;
    private float delivery_totalcostamount;
    private int supplier_id;
    private int branch_id;
    private int employee_id;
    private int deleteStatus;
    
   
    public ResultSet showDelivery () { //Views all the deliveries after submitting a delivery form
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT DATE_FORMAT(delivery_datetime, '%y-%m-%d') AS 'Date Delivery' ,"
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' ,"
                + "delivery_unitprice AS 'Unit Price' ,"
                + "delivery_numberofunits AS 'No of Units' ,"
                + "delivery_unitofmeasure AS 'Unit of Measure' ,"
                + "delivery_totalcostamount AS 'Total Purchase',"
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Supplier' ,"
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' ,"
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Employee' FROM `delivery` WHERE branch_id=1 AND isAdmin=0 AND deleteStatus=0 ORDER BY delivery_datetime DESC";
                
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
            ResultSet rs = st.executeQuery(str);
            return rs;
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet showDelivery2 (String id) { //Views all the deliveries after submitting a delivery form
        Statement st;
        ResultSet rs = null;
        this.initialize(); //initialize db
        
        String str = "SELECT DATE_FORMAT(delivery_datetime, '%y-%m-%d') AS 'Date Delivery' ,"
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' ,"
                + "delivery_unitprice AS 'Unit Price' ,"
                + "delivery_numberofunits AS 'No of Units' ,"
                + "delivery_unitofmeasure AS 'Unit of Measure' ,"
                + "delivery_totalcostamount AS 'Total Purchase',"
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Supplier' ,"
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' ,"
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Employee' FROM `delivery` WHERE branch_id="+id+" AND isAdmin=0 AND deleteStatus=0 ORDER BY delivery_datetime DESC";
                
        try {
            st = conn.createStatement();
            rs = st.executeQuery(str);
            System.out.println(rs);
            
            return rs;
            
        } catch (SQLException ex) {}
        return rs;
    }
    
    public String determineBranch (String username){ //determines which branch is the username from, cebu or leyte branch. COMBOBRANCH
        Statement st;
        ResultSet rs = null;
        String ret = null;
        this.initialize();
        
        String str = "SELECT `branch_id` FROM branch WHERE username = '"
                +username+"' limit 1";
        System.out.println(str);
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            System.out.println("OK");
         //   ret = Integer.parseInt(rs.getString(1));
            ret = rs.getString(1);
        } catch (SQLException ex) {}
        return ret;
    }
   
    
    public int addForm(){ //query to add the deliveries to the database. this is from the add delivery form
        Statement st;
        int ret = 0;
        this.initialize();
        
        String str = "INSERT INTO `delivery` (`delivery_id`, `delivery_datetime`, `product_id`, `delivery_unitprice`, `delivery_numberofunits`, `delivery_unitofmeasure`, `supplier_id`, `branch_id`, `employee_id`, `deleteStatus`) VALUES (NULL, CURRENT_TIMESTAMP , '"
                +this.product_id+"', '"+this.delivery_unitprice+"', '"
                +this.delivery_numberofunits+"', '"+this.delivery_unitofmeasure+"', '"
                +this.supplier_id+"', '"+this.branch_id+"', '"
                +this.employee_id+"' ,0)";
                
        System.out.println(str);
        try{
            st = conn.createStatement();
            ret = st.executeUpdate(str);
            
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int determineSupplier (String supplier) { //shows a jcombo on the form to choose the supplier. add delivery form
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT `supplier_id` FROM supplier WHERE supplier_name = '"
                +supplier+"' limit 1";
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
    
    
    public int determineEmployee (String employee){ //choose who received the deliveries. add delivery form
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT `employee_id` FROM employee WHERE username = '"
                +employee+"' AND WHERE limit 1";
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
    
    public int determineProduct (String product){ //receiver will input the product code on the add delivery form
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize();
        
        String str = "SELECT `product_id` FROM product WHERE product_code = '"
                +product+"' limit 1";
        
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
    
    public String determineUser (String username) { //determines which branch is the username from, cebu or leyte branch
        Statement st;
        ResultSet rs = null;
        String ret = null;
        this.initialize(); //initialize db
        
        String str = "select `branch_id` from employee where username = '"
                +username+"' limit 1";
        
        try {
            st = conn.createStatement();     
            rs = st.executeQuery(str);
            //retrive the value from the first return row.
            rs.next();
            ret = rs.getString(1);
        } catch (SQLException ex) {}
        return ret;
    }
    
    
    //Getters and Setters
    public int getDelivery_id(){
        return delivery_id;
    }
    
    public void setDelivery_id(int delivery_id){
        this.delivery_id = delivery_id;
    }
    
    public int getProduct_code(){
        return product_id;
    }
    
    public void setProduct_code(int product_id){
        this.product_id = product_id;
    }
    
    public float getDelivery_unitprice(){
        return delivery_unitprice;
    }
    
    public void setDelivery_unitprice(float delivery_unitprice){
        this.delivery_unitprice = delivery_unitprice;
    }
    
    public int getDelivery_numberofunits(){
        return delivery_numberofunits;
    }
    
    public void setDelivery_numberofunits(int delivery_numberofunits){
        this.delivery_numberofunits = delivery_numberofunits;
    }
    
    public String getDelivery_unitofmeasure(){
        return delivery_unitofmeasure;
    }
    
    public void setDelivery_unitofmeasure(String delivery_unitofmeasure){
        this.delivery_unitofmeasure = delivery_unitofmeasure;
    }
    
    public int getSupplier_name(){
        return supplier_id;
    }
    
    public void setSupplier_name(int supplier_id){
        this.supplier_id = supplier_id;
    }
    
    public int getBranch_name(){
        return branch_id;
    }
    
    public void setBranch_name(int branch_id){
        this.branch_id = branch_id;
    }
    
    public int getUsername(){
        return employee_id;
    }
    
    public void setUsername(int employee_id){
        this.employee_id = employee_id;
    }
    
    public float getDelivery_totalcostamount(){
        return delivery_totalcostamount;
    }
    
    public void setDelivery_totalcostamount(float delivery_totalcostamount){
        this.delivery_totalcostamount = delivery_totalcostamount;
    }

    public ResultSet showDelivery(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
