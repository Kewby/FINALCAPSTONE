/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import Connection.DBIPAddress;
import JavaHttpUrlConnectionReader.JavaHTTPUrlConnectionReader;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.EmployeeModel;

/**
 *
 * @author
 */
public class AddEmpController {
    DBIPAddress dbip = new DBIPAddress();
    String IP = dbip.getIP();
    
    public void clear (AddEmp ae) {
        ae.getTxtFname().setText("");
        ae.getTxtLname().setText("");
        ae.getTxtUsername().setText("");
        ae.getTxtPassword().setText("");
        ae.getTxtEmail().setText("");
        ae.getTxtContactNo().setText("");
        ae.getTxtAddress().setText("");
       
    }    
    
    public void add(String firstName,String lastName,String username,String password,String email,String contactNumber,String address) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println(firstName+", "+lastName+", "+username+", "+password+", "+email+", "+contactNumber+", "+address);

          String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/employee/addEmployee.php?firstName="+firstName+"&lastName="+lastName+"&username="+username+""
                  + "&password="+password+"&email="+email+"&contactNumber="+contactNumber+"&address="+address+"";

          new JavaHTTPUrlConnectionReader(myUrl);
          JOptionPane.showMessageDialog(null, "Successfully Added!");
    }
    
    public void passwordValidation(AddEmp ae, String username, String password)
        {
                boolean valid = true;
                if (password.length() > 15 || password.length() < 8)
                {
                        System.out.println("Password should be less than 15 and more than 8 characters in length.");
                        valid = false;
                }
                if (password.indexOf(username) > -1)
                {
                        System.out.println("Password Should not be same as user name");
                        valid = false;
                }
                String upperCaseChars = "(.*[A-Z].*)";
                if (!password.matches(upperCaseChars ))
                {
                        System.out.println("Password should contain atleast one upper case alphabet");
                        valid = false;
                }
                String lowerCaseChars = "(.*[a-z].*)";
                if (!password.matches(lowerCaseChars ))
                {
                        System.out.println("Password should contain atleast one lower case alphabet");
                        valid = false;
                }
                String numbers = "(.*[0-9].*)";
                if (!password.matches(numbers ))
                {
                        System.out.println("Password should contain atleast one number.");
                        valid = false;
                }
                String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
                if (!password.matches(specialChars ))
                {
                        System.out.println("Password should contain atleast one special character");
                        valid = false;
                }
                if (valid)
                {
                        System.out.println("Password is valid.");
                }
        }
    
    
    
    
}
