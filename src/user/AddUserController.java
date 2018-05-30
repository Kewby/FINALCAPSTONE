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
    
    public void add (AddUser au) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        UserModel um = new UserModel();
        
        um.setUsername(au.getTxtUsername().getText().trim());
        um.setPassword(au.getTxtPassword().getText().trim());
        
        um.setUser_firstname(au.getTxtFname().getText().trim());
        um.setUser_lastname(au.getTxtLname().getText().trim());
        
        
        if (um.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            au.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
}
