/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import cashierpage.CashierPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import adminpage.AdminPage;
import cashierpage.ChangeFund;
import javax.swing.JLabel;

/**
 *
 * @author
 */
public class LoginController {
    
    public void login (Login l) {
        EmployeeModel em = new EmployeeModel();
        
        em.setUsername(l.getInputUsername().getText().trim());
        em.setPassword(l.getInputPassword().getText().trim());
        
        ResultSet rs = em.login();
        
        try {
            if (rs.next()) {
                if (rs.getString("isAdmin").equals("1")) {
                    AdminPage ap = new AdminPage(rs.getString("username"));
                    ap.getLblUser().setText("Welcome "+rs.getString("username"));
                    ap.setVisible(true);
  
                } else {
                    ChangeFund cf = new ChangeFund();
                    cf.getLblUser().setText("Welcome "+rs.getString("username"));
                    cf.setVisible(true);
                }
                
                l.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "User or Password doesn't exist!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
