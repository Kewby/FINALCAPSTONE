/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.ProductModel;
import models.UserModel;

/**
 *
 * @author
 */
public class AddProductController {

    public void clear(AddProduct ap) {
        ap.getTxtItemCode().setText("");
        ap.getTxtProductName().setText("");
        ap.getcomboCategory().setSelectedItem("");
        ap.getcomboProductType().setSelectedItem("");
        ap.getTxtPrice().setText("");
        ap.getTxtStock().setText("");
    }

    public void add(AddProduct ap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");

        ProductModel pm = new ProductModel();

        pm.setProduct_code(ap.getTxtItemCode().getText().trim());
        pm.setProduct_name(ap.getTxtProductName().getText().trim());
        pm.setProduct_category((String) ap.getcomboCategory().getSelectedItem());
        pm.setProduct_type((int) ap.getcomboProductType().getSelectedItem());
        pm.setProduct_price(Float.parseFloat(ap.getTxtPrice().getText().trim()));
        pm.setProduct_stock(Integer.parseInt(ap.getTxtStock().getText().trim()));

        if (pm.add() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            ap.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
    }
}
