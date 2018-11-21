/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import JavaHttpUrlConnectionReader.JavaHTTPUrlConnectionReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cathy
 */
public class PatientInformation {
     public static void main(String[] args)
  {     
      PatientInformation x = new PatientInformation();
      
  }
    
    public void getPatient()
    {
        System.out.println("hi");

        DL_json_fromIP download = new DL_json_fromIP();
        String myUrl = "http://192.168.8.101/HIMSv2/patient_info/patient.php?";
        System.out.println("hi");
        new JavaHTTPUrlConnectionReader(myUrl);// naa cyay error ari
        System.out.println(myUrl);
        try {
            download.downloadData("http://192.168.8.101/HIMSv2/patient_info/retrieve_all.json", "retrieve_all");
        } catch (IOException ex) {
            //Logger.getLogger(Medication_list.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public void addPatient(String Fname, String Lname, String Mname, String Diagnosis){
        System.out.println(Fname+","+Lname+","+Mname+","+Diagnosis);
        System.out.println("hi");
        String myUrl = "http://192.168.8.101/HIMSv2/patient_info/Addpatient.php?ptFname="+Fname+"&ptLname="+Lname+"&ptMname="+Mname+"&ptDiagnos="+Diagnosis+"";
        new JavaHTTPUrlConnectionReader(myUrl);
        System.out.println(myUrl);
    }
}

