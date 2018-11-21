/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import Connection.DBIPAddress;
import JavaHttpUrlConnectionReader.JavaHTTPUrlConnectionReader;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import models.RoleModel;
/**
 *
 * @author Client
 */
public class UpdateEmpController {
    DBIPAddress dbip = new DBIPAddress();
    String IP = dbip.getIP();
    
    public void clear(UpdateEmp uec){
        uec.getTxtFirstname().setText("");
        uec.getTxtLastname().setText("");
        uec.getTxtUsername().setText("");
        uec.getTxtPassword().setText("");
        uec.getTxtConfirm().setText("");
        uec.getTxtEmail().setText("");
        uec.getTxtContactNumber().setText("");
        uec.getTxtAddress().setText("");
        uec.getComboRole().setSelectedIndex(0);
    }
    
    public void update(int empID, String firstName,String lastName,String username,String password,String email,String contactNumber,String address, int role){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
                
//        EmployeeModel em = new EmployeeModel();
//        
//        em.setEmployee_firstname(ue.getTxtFirstname().getText().trim());
//        em.setEmployee_lastname(ue.getTxtLastname().getText().trim());
//        em.setUsername(ue.getTxtUsername().getText().trim());
//        em.setPassword(ue.getTxtPassword().getText().trim());
//        em.setEmployee_email(ue.getTxtEmail().getText().trim());
//        em.setEmployee_contactnumber(ue.getTxtContactNumber().getText().trim());
//        em.setEmployee_address(ue.getTxtAddress().getText().trim());
//        
//        //role = (uec.getComboRole().getSelectedItem().toString().compareToIgnoreCase("CASHIER")==0)?1:0;
//        //em.isAdmin(role);
//        
//        em.setEmployee_id(ue.getEmpId());
//        
//        em.setIsAdmin(em.determineRole(ue.getComboRole().getSelectedItem().toString()));
//        
//        if (em.update() >= 1) {
//            JOptionPane.showMessageDialog(null, "Successfully Updated!");
//            ue.dispose();
//        } else {
//            JOptionPane.showMessageDialog(null, "Failed!");
//        }
//        
           UpdateEmp ue = new UpdateEmp();
           ue.getEmpId();
           System.out.println("EMP ID: "+empID);
           
           System.out.println(firstName+", "+lastName+", "+username+", "+password+", "+email+", "+contactNumber+", "+address);

          String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/employee/updateEmployee.php?empID="+empID+"&firstName="+firstName+"&lastName="+lastName+"&username="+username+""
                  + "&password="+password+"&email="+email+"&contactNumber="+contactNumber+"&address="+address+"&role="+role+"";

          new JavaHTTPUrlConnectionReader(myUrl);
          JOptionPane.showMessageDialog(null, "Successfully Updated!");
    }
    
    public ResultSet getRole() {
        RoleModel rm = new RoleModel();
        return rm.getRole();
    }
    
}
