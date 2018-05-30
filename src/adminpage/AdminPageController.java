/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpage;

//import function.Temp;
import models.UserModel;

/**
 *
 * @author 
 */
public class AdminPageController {

    public void deleteUser(int id) {
        UserModel um = new UserModel();
        um.setUser_id(id);
        int ret = um.delete();
    }
}
    
    
    

