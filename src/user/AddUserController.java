/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.UserModel;

/**
 *
 * @author
 */
public class AddUserController {
        
    public void clear (AddUser au) {
        au.getTxtFname().setText("");
        au.getTxtLname().setText("");
        au.getTxtUsername().setText("");
        au.getTxtPassword().setText("");
        au.getTxtEmail().setText("");
        au.getTxtContactNo().setText("");
        au.getTxtAddress().setText("");
        au.getComboBranch().setSelectedItem("");
        au.getComboRole().setSelectedItem("");
    }
    
    public void clear (UpdateUser upuser) {
        upuser.getTxtFname().setText("");
        upuser.getTxtLname().setText("");
        upuser.getTxtUsername().setText("");
        upuser.getTxtPassword().setText("");
        upuser.getTxtEmail().setText("");
        upuser.getTxtContactNo().setText("");
        upuser.getTxtAddress().setText("");
        upuser.getComboBranch().setSelectedItem("");
        upuser.getComboRole().setSelectedItem("");
    }
    
    
    
    public void add (AddUser au) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        UserModel um = new UserModel();
        
        um.setUsername(au.getTxtUsername().getText().trim());
        um.setPassword(au.getTxtPassword().getText().trim());
        
        um.setUser_firstname(au.getTxtFname().getText().trim());
        um.setUser_lastname(au.getTxtLname().getText().trim());
        um.setUser_email(au.getTxtEmail().getText().trim());
        um.setUser_contactnumber(au.getTxtContactNo().getText().trim());
        um.setUser_address(au.getTxtAddress().getText().trim());
        System.out.println();
        if(au.getComboBranch().getSelectedItem().toString().compareToIgnoreCase("Cebu")==0){
            um.setBranch_id(1);
        }else{
            um.setBranch_id(2);
        }
        if(au.getComboRole().getSelectedItem().toString().compareToIgnoreCase("Admin")==0){
            um.setIsAdmin(1);
        }else{
            um.setIsAdmin(0);
        }
        
        if (um.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            au.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
}
