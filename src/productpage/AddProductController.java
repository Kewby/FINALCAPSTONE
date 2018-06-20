/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.CategoryModel;
import models.ProductModel;

/**
 *
 * @author
 */
public class AddProductController {

    public void clear(AddProduct ap) {
        ap.getTxtItemCode().setText("");
        ap.getTxtProductName().setText("");
        ap.getcomboCategory().setSelectedIndex(0);
        ap.getcomboProductType().setSelectedIndex(0);
        ap.getTxtPrice().setText("");
        ap.getTxtItemCode().requestFocus();
    }

    public void add(AddProduct ap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        
        int productType  = 0;
        ProductModel pm = new ProductModel();
        
        pm.setProduct_code(ap.getTxtItemCode().getText().trim());
        pm.setProduct_name(ap.getTxtProductName().getText().trim());
        pm.setProduct_category(pm.determineCategory(ap.getcomboProductType().getSelectedItem().toString()));
        System.out.print("Category ID: "+pm.getProduct_category());
        productType = (ap.getcomboProductType().getSelectedItem().toString().compareToIgnoreCase("AGRICULTURE")==0)?1:0;
        pm.setProduct_type(productType);
        pm.setProduct_price(Float.parseFloat(ap.getTxtPrice().getText().trim()));
        pm.setBranch_id(Integer.parseInt(pm.determineBranch(ap.getName()))); //determines which branch the product will be added

        if (pm.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            ap.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
    
    public ResultSet getCategories() {
        CategoryModel cm = new CategoryModel();
        return cm.getCategory();
    }
}
