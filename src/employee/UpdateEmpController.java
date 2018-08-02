/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.EmployeeModel;


/**
 *
 * @author Client
 */
public class UpdateEmpController {
    public void clear(UpdateEmp uec){
        uec.getTxtFname().setText("");
        uec.getTxtLname().setText("");
        uec.getTxtUsername().setText("");
        uec.getTxtPassword().setText("");
        uec.getTxtConfirm().setText("");
        uec.getTxtEmail().setText("");
        uec.getTxtContactNo().setText("");
        uec.getTxtAddress().setText("");
        uec.getComboRole().setSelectedIndex(0);
    }
    
    public void update(UpdateEmp uec){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        int role = 0;
        EmployeeModel em = new EmployeeModel();
        
        em.setEmployee_firstname(uec.getTxtFname().getText().trim());
        em.setEmployee_lastname(uec.getTxtLname().getText().trim());
        em.setUsername(uec.getTxtUsername().getText().trim());
        em.setPassword(uec.getTxtPassword().getText().trim());
        em.setEmployee_email(uec.getTxtEmail().getText().trim());
        em.setEmployee_contactnumber(uec.getTxtContactNo().getText().trim());
        em.setEmployee_address(uec.getTxtAddress().getText().trim());
        
        role = (uec.getcomboRole().toString().compareToIgnoreCase("CASHIER")==0)?1:0;
        em.isAdmin(role);
        
        if (em.update() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            uec.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
        
        
    }
    
    
    
}
