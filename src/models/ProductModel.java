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

/**
 *
 * @author 
 */
public class ProductModel extends MyModel{
    private int product_id;
    private String product_code;
    private String product_name;
    private int category_id;
    private int product_type;
    private float product_price;
    private int deleteStatus;
    private int branch_id;
    
    public ResultSet viewAll () {
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT product_code AS 'Product Code', "
                + "product_name AS 'Name', (SELECT category.category_name FROM category WHERE product.category_id = category.category_id) AS 'Category', "
                + "(CASE WHEN product_type = 'true' THEN 'Non-Agricultural' ELSE 'Agricultural' END) AS 'Product Type', product_price AS 'Price' from product where deleteStatus = 0";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
            ResultSet rs = st.executeQuery(str);
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet viewLeyte (String id) {
        Statement st;
        this.initialize(); //initialize db
        
        String str = "SELECT product_code AS 'Product Code', "
                + "product_name AS 'Item Name', (SELECT category.category_name FROM category WHERE product.category_id = category.category_id) AS 'Category', "
                + "(CASE WHEN product_type = 'true' THEN 'Non-Agricultural' ELSE 'Agricultural' END) AS 'Type', product_price AS 'Price' from product where branch_id="+id+" AND deleteStatus = 0";
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            
            return rs;
            
        } catch (SQLException ex) {}
        return null;
    }
    
    public int add () {
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
        
        String str = "INSERT INTO  `product` (`product_id`, `product_code`, `product_name`, `product_type`, `product_price`, `branch_id`, `category_id`, `deleteStatus`) values (NULL, '"
                +this.product_code+"', '"+this.product_name+"', '"
                +this.product_type+"', '"+this.product_price+"', '"
                +this.branch_id+"', "+this.category_id+" ,0)";
        
        System.out.println(str);
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int update(){
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
          String str = "UPDATE `product` SET `product_name` = '"+this.product_name+"', `product_type` = '"+this.product_type+"', `category_id` = '"+this.category_id+"', `product_price` = '"+this.product_price+"' WHERE `product_code` = '"+this.product_code+"'"; 
        
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int delete () {
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db delete product
        
        String str = "UPDATE product set deleteStatus = 1 where product_code = '"+this.product_code+"'"; //Query
        
        System.out.println(str);
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ret;
    }
    
    public String determineBranch (String username) {
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
    
    public int determineCategory (String category) { 
        Statement st;
        ResultSet rs = null;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "select `category_id` from category where category_name = '"
                +category+"' limit 1";
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
    
    
    //Getters and Setters
    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int product_id) {
        this.branch_id = product_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_category() {
        return category_id;
    }

    public void setProduct_category(int category_id) {
        this.category_id = category_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }
    
    public int getProduct_type(){
        return product_type;
    }
    
    public void setProduct_type(int product_type){
        this.product_type = product_type;
    }

    public ResultSet viewAll(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
