/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

//import function.Temp;
import JavaHttpUrlConnectionReader.JavaHTTPUrlConnectionReader;
import Connection.DBIPAddress;
import javax.swing.JOptionPane;
import models.ProductModel;
import Connection.DL_json_fromIP;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allysha, Kirby
 */
public class ProductPageController {
    DBIPAddress dbip = new DBIPAddress();
    String IP = dbip.getIP();
    
    public void getProduct()
    {
        System.out.println("START VIEW PRODUCT");

        DL_json_fromIP download = new DL_json_fromIP();
        String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/product/viewProduct.php?";
        System.out.println("View Product PHP: Connection Success");
        new JavaHTTPUrlConnectionReader(myUrl);
        
        
        try {
            download.downloadData("http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/product/viewProduct.json", "viewProduct");
        } catch (IOException ex) {
            Logger.getLogger(ProductPage.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
     
     public void delete(String productCode) {

        System.out.println(productCode);

          String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/product/deleteProduct.php?productCode="+productCode+"";

          new JavaHTTPUrlConnectionReader(myUrl);
          JOptionPane.showMessageDialog(null, "Successfully Deleted!");
     }
      
}
    
    
    

