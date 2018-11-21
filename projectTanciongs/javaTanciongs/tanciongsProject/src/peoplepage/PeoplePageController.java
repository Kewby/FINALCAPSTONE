/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import Connection.DBIPAddress;
import Connection.DL_json_fromIP;
import JavaHttpUrlConnectionReader.JavaHTTPUrlConnectionReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import models.EmployeeModel;
import models.SupplierModel;


/**
 *
 * @author Allysha
 */
public class PeoplePageController {
    DBIPAddress dbip = new DBIPAddress();
    String IP = dbip.getIP();
    
    public void getEmployee (){
     System.out.println("START VIEW EMPLOYEE");

        DL_json_fromIP download = new DL_json_fromIP();
        String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/employee/viewEmployee.php?";
        System.out.println("View Employee PHP: Connection Success");
        new JavaHTTPUrlConnectionReader(myUrl);
        System.out.println(myUrl);
        try {
            download.downloadData("http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/employee/viewEmployee.json", "viewEmployee");
        } catch (IOException ex) {
            //Logger.getLogger(Medication_list.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void getSupplier (){
     System.out.println("START VIEW SUPPLIER");

        DL_json_fromIP download = new DL_json_fromIP();
        String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/supplier/viewSupplier.php?";
        System.out.println("View Supplier PHP: Connection Success");
        new JavaHTTPUrlConnectionReader(myUrl);
        System.out.println(myUrl);
        try {
            download.downloadData("http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/supplier/viewSupplier.json", "viewSupplier");
        } catch (IOException ex) {
            //Logger.getLogger(Medication_list.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void deleteEmp(int empID){
        EmployeeModel em = new EmployeeModel();
         
        em.setEmployee_id(empID);
         
        if (em.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
    }
    
    public void deleteSupplier(int supplierID){
        SupplierModel sm = new SupplierModel();
         
        sm.setSupplier_id(supplierID);
         
        if (sm.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
    }
}
