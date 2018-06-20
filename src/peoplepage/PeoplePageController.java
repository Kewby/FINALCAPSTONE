/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import cashierpage.CashierPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import adminpage.AdminPage;
import models.ProductModel;

/**
 *
 * @author Client
 */
public class PeoplePageController {
    
    public void deleteEmp(String employee_firstname){
        EmployeeModel em = new EmployeeModel();
         
        em.setEmployee_firstname(employee_firstname);
         
        if (em.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
    }
}
