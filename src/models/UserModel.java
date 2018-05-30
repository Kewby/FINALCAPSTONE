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
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class UserModel extends MyModel {
    
    private int user_id;
    private String user_firstname;
    private String user_lastname;
    private String username;
    private String password;
    private String user_email;
    private String user_contactnumber;
    private String user_address;
    private int branch_id;
    private int isAdmin;
    private int deleteStatus;
    
    public int delete () {
        Statement st;
        int ret = 0;
        this.initialize(); //initialize db
        
        String str = "UPDATE user SET deleteStatus = 1 WHERE user_id = '"+this.user_id+"'";
        
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
        this.initialize(); //initialize db
        
        String str = "SELECT user_firstname AS 'First Name', user_lastname AS 'Last Name', username AS 'Username', user_email AS 'E-mail', user_contactnumber AS 'Contact Number' FROM user WHERE branch_id=1 AND isAdmin=0 AND deleteStatus=0"; //all not admin user 
        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            
            return rs;
            
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet viewLeyte () {
        Statement st;
        this.initialize(); //initialize db
        
        String str = "SELECT user_firstname AS 'First Name', user_lastname AS 'Last Name', username AS 'Username', user_email AS 'E-mail', user_contactnumber AS 'Contact Number' FROM user WHERE branch_id=2 AND isAdmin=0 AND deleteStatus=0"; //all not admin user 
        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            
            return rs;
            
        } catch (SQLException ex) {}
        return null;
    }
    
    public ResultSet login () {
        Statement st;
        ResultSet ret = null;
        this.initialize(); //initialize db
        
        String str = "select * from user where username = '"
                +this.username+"' and password = '"+this.password+"' limit 1";
        
        
        try {
            st = conn.createStatement();     
            ret = st.executeQuery(str);
        } catch (SQLException ex) {}
        return ret;
    }
    
    public int add () {
        Statement st;
        int ret = 0;
        this.initialize();
        String str = "INSERT into USER values (null, '"+this.user_firstname+"','"+this.user_lastname+"', '"+this.username+"','"+this.password+"', '"+this.user_email+"','"+this.user_contactnumber+"', '"+this.user_address+"', '"+this.branch_id+"', '"+this.isAdmin+"' 0)";
          
        
        try {
            st = conn.prepareStatement(str);
            ret = st.executeUpdate(str);
        } catch (SQLException ex) {
        }
        
        return ret;
    }
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
   
    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUser_email(){
        return user_email;
    }
    
    public void setUser_email(String user_email){
        this.user_address = user_email;    
    }
    
    public String getUser_contactnumber() {
        return user_contactnumber;
    }

    public void setUser_contactnumber(String user_contactnumber) {
        this.user_contactnumber = user_contactnumber;
    }
    
    public String getUser_address(){
        return user_address;
    }
    
    public void setUser_address(String user_address){
        this.user_address = user_address;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public int getBranch_id () {
        return branch_id;
    }
    
    public void setBranch_id(int branch_id){
        this.branch_id = branch_id;
    }

    public void setUser_firtname(String user_firstname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
