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
    private String product_category;
    private int product_type;
    private float product_price;
    private int product_stock;
    private int deleteStatus;
    
    public int delete () {
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "update products set deleteStatus = 1 where product_number = '"+this.product_code+"'";
        
        System.out.println(str);
        try {
            st = conn.createStatement();
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ret;
    }
    
    public ResultSet viewAll () {
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "SELECT product_code AS 'Product Code', "
                + "product_name AS 'Name', category_id AS 'Category', "
                + "product_type AS 'Type', product_price AS 'Price', "
                + "product_stock AS 'Stock' from product where deleteStatus = 0";
        
        try {
            st = conn.createStatement();
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int add () {
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "insert into products values (null, '"
                +this.product_code+"', '"+this.product_name+"', '"
                +this.product_category+"', '"+this.product_type+"', "
                +this.product_price+", "+this.product_stock+",)";
        
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
        this.initialize();
        
//        String str = "UPDATE `product` SET `product_code` = '101DAD13',"
//                + "`product_name` = 'TESTING', `product_category` = 'TESTING', "
//                + "`deleteStatus` = '0' WHERE `product`.`product_id` = 19;"
        return 0;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
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

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }
    
    public int getProduct_type(){
        return product_type;
    }
    
    public void setProduct_type(int product_type){
        this.product_type = product_type;
    }
    
    
}
