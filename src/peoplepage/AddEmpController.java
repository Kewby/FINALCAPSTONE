/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import models.RoleModel;

/**
 *
 * @author
 */
public class AddEmpController {
        
    public void clear (AddEmp ae) {
        ae.getTxtFname().setText("");
        ae.getTxtLname().setText("");
        ae.getTxtUsername().setText("");
        ae.getTxtPassword().setText("");
        ae.getTxtEmail().setText("");
        ae.getTxtContactNo().setText("");
        ae.getTxtAddress().setText("");
        ae.getComboRole().setSelectedItem("");
    }    
    
    public void add (AddEmp ae) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        EmployeeModel em = new EmployeeModel();
        
        em.setUsername(ae.getTxtUsername().getText().trim());
        em.setPassword(ae.getTxtPassword().getText().trim());
        
        em.setEmployee_firstname(ae.getTxtFname().getText().trim());
        em.setEmployee_lastname(ae.getTxtLname().getText().trim());
        em.setEmployee_email(ae.getTxtEmail().getText().trim());
        em.setEmployee_contactnumber(ae.getTxtContactNo().getText().trim());
        em.setEmployee_address(ae.getTxtAddress().getText().trim());
        
        em.setBranch_id(Integer.parseInt(em.determineBranch(ae.getName())));
        em.setIsAdmin(Integer.parseInt(Integer.toString(em.determineRole(ae.getComboRole().getSelectedItem().toString()))));
        
        if (em.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            ae.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
}
