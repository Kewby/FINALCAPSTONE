/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productpage;

//import function.Temp;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ProductModel;

/**
 *
 * @author 
 */
public class ProductPageController {
    
     public ResultSet test(){
         ProductModel pm = new ProductModel();
            ResultSet rs = pm.viewAll();
            
            return rs;
     }
    
     public ResultSet viewAll (){
        Vector row;
        ProductModel pm = new ProductModel();
        ResultSet rs = pm.viewAll();
        
        DefaultTableModel dm;
        //dm = (DefaultTableModel) prp.getTblProduct().getModel();
        //dm. setRowCount(0);
        
        try {
            while (rs.next()) {
                row = new Vector();
                
                row.add(rs.getInt("product_code"));
                row.add(rs.getInt("product_name"));
                row.add(rs.getInt("product_category"));
                row.add(rs.getInt("product_type"));
                row.add(rs.getInt("product_price"));
                row.add(rs.getInt("product_stock"));
                
                //dm.addRow(row);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger (ProductPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     
     public void deleteProduct(String id) {
         ProductModel pm = new ProductModel();
         
         pm.setProduct_code(id);
         
         if (pm.delete() == 1){
             JOptionPane.showMessageDialog(null, "Successfully Deleted!");
         } else {
             JOptionPane.showMessageDialog(null, "Failed!");
         }
     }

    
}
    
    
    

