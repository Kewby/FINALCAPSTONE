/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpage;

//import function.Temp;
import models.EmployeeModel;

/**
 *
 * @author 
 */
public class AdminPageController {

    public void deleteUser(int id) {
        EmployeeModel em = new EmployeeModel();
        em.setEmployee_id(id);
        int ret = em.delete();
    }
}
    
    
    

