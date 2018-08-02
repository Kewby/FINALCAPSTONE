/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashierpage;

import adminpage.AdminPageController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.ProductModel;
import models.SalesModel;

/**
 *
 * @author allysh@
 */
public class CashierPageController {
    
    public void addChangefund (ChangeFund cf){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyd-MM-dd");
        
        SalesModel salesm = new SalesModel();
        
        salesm.setChangefund(Float.parseFloat(cf.getTxtChangefund().getText().trim()));
        
        if (salesm.addChangefund() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added Start of the Day!");
            cf.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
        
    }
    
    public void addToCart (CashierPage cp){
       
        
        
    }
    
    
    
    /*
    public void viewAll (CashierPage cp) {
        Vector row;
        ProductModel pm = new ProductModel();
        ResultSet rs = pm.viewAll();
        
        DefaultTableModel dm = (DefaultTableModel) cp.getTblCart().getModel();
        dm.setRowCount(0);
        
        try {
            while (rs.next()) {
                row = new Vector();
                
                row.add(rs.getString("product_code"));
                row.add(rs.getString("product_name"));
                row.add(rs.getString("category_id"));
                row.add(rs.getString("product_type"));
                row.add(rs.getString("product_price"));
                row.add(rs.getString("branch_id"));
                
                dm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    /*
    public void addToCart (String itemCode, String name, String price, int qty, CashierPage cp) {
        //float total = Float.parseFloat(cp.getLblTotal().getText().trim()), subtotal = 0;
        Vector row = new Vector();
        DefaultTableModel dm = (DefaultTableModel) cp.getTblCart().getModel();
        ResultSet rs = null;
        
        row.add(name);
        row.add(price);
        row.add(qty);
        row.add(Float.parseFloat(price)*qty);
        dm.addRow(row);
        //cp.getTblCart().setModel(DbUtils.resultSetToTableModel(rs));
                
        try {
            int qty = Integer.parseInt(cp.getTxtQuantity().getText().trim());
            float price = Float.parseFloat(cp.getTblProduct().getValueAt(sel, 4).toString());
            
            row.add(cp.getTblProduct().getValueAt(sel, 2));
            row.add(qty);
            row.add(price);
            subtotal = qty * price;
            row.add(String.format("%.2f", subtotal));
            
            cp.getLblTotal().setText(String.format("%.2f", total += subtotal));
           
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Invalid Qty!");
        }
    }
    
    public void remove (CashierPage cp) {
        DefaultTableModel dm = (DefaultTableModel) cp.getTblCart().getModel();
        
        int sel = cp.getTblCart().getSelectedRow();
        
        dm.removeRow(sel);
    }
*/


    
}
