/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.EmployeeModel;

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
        ae.getComboBranch().setSelectedItem("");
        ae.getComboRole().setSelectedItem("");
    }
    
    /*
    public void clear (UpdateEmp upemp) {
        upemp.getTxtFname().setText("");
        upemp.getTxtLname().setText("");
        upemp.getTxtUsername().setText("");
        upemp.getTxtPassword().setText("");
        upemp.getTxtEmail().setText("");
        upemp.getTxtContactNo().setText("");
        upemp.getTxtAddress().setText("");
        upemp.getComboRole().setSelectedItem("");
    }
    */
    
    
    public void add (AddEmp ae) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        EmployeeModel em = new EmployeeModel();
        
        em.setUsername(ae.getTxtUsername().getText().trim());
        em.setPassword(ae.getTxtPassword().getText().trim());
        
        em.setEmployee_firstname(ae.getTxtFname().getText().trim());
        em.setEmployee_lastname(ae.getTxtLname().getText().trim());
        em.setEmployee_email(ae.getTxtEmail().getText().trim());
        em.setEmployee_contactnumber(ae.getTxtContactNo().getText().trim());
        em.setEmployee_address(ae.getTxtAddress().getText().trim());
        System.out.println();
        if(ae.getComboBranch().getSelectedItem().toString().compareToIgnoreCase("Cebu")==0){
            em.setBranch_id(1);
        }else{
            em.setBranch_id(2);
        }
        if(ae.getComboRole().getSelectedItem().toString().compareToIgnoreCase("Admin")==0){
            em.setIsAdmin(1);
        }else{
            em.setIsAdmin(0);
        }
        
        if (em.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            ae.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
}
