/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

import JavaHttpUrlConnectionReader.JavaHTTPUrlConnectionReader;
import Connection.DBIPAddress;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.CategoryModel;
import productpage.AddProduct;

/**
 *
 * @author
 */
public class AddProductController {
    DBIPAddress dbip = new DBIPAddress();
    String IP = dbip.getIP();
    
    public void clear(AddProduct ap) {
        ap.getTxtProductCode().setText("");
        ap.getTxtProductName().setText("");
        ap.getcomboProductType().setSelectedIndex(0);
        ap.getcomboCategory().setSelectedIndex(0);
        ap.getTxtStandardCost().setText("");
        ap.getTxtMarkupCost().setText("");
        ap.getTxtProductCode().requestFocus();
    }
//
    public void add(String productCode, String productName, int productType, String category, float standardCost, float markupCost) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          System.out.println(productCode+", "+productName+", "+productType+", "+category+", "+standardCost+", "+markupCost);

          String myUrl = "http://"+IP+"/CapstoneProject/projectTanciongs/phpTanciongs/product/addProduct.php?productCode="+productCode+"&productName="+productName+"&productType="+productType+""
                  + "&category="+category+"&standardCost="+standardCost+"&markupCost="+markupCost+"";

          new JavaHTTPUrlConnectionReader(myUrl);
          JOptionPane.showMessageDialog(null, "Successfully Added!");
          
    }
//    
    public ResultSet getCategories() {
        CategoryModel cm = new CategoryModel();
        return cm.getCategory();
    }
}
