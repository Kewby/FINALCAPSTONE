/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashierpage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ProductModel;
import adminpage.AdminPageController;

/**
 *
 * @author
 */
public class CashierPageController {
        
    public void viewAll (CashierPage cp) {
        Vector row;
        ProductModel pm = new ProductModel();
        ResultSet rs = pm.viewAll();
        
        DefaultTableModel dm = (DefaultTableModel) cp.getTblProduct().getModel();
        dm.setRowCount(0);
        
        try {
            while (rs.next()) {
                row = new Vector();
                
                row.add(rs.getInt("product_id"));
                row.add(rs.getString("product_number"));
                row.add(rs.getString("product_name"));
                row.add(rs.getString("product_category"));
                row.add(rs.getString("product_price"));
                row.add(rs.getString("product_stock"));
                row.add(rs.getString("product_image"));
                
                dm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addToCart (CashierPage cp) {
        float total = Float.parseFloat(cp.getLblTotal().getText().trim()), subtotal = 0;
        Vector row = new Vector();
        DefaultTableModel dm = (DefaultTableModel) cp.getTblCart().getModel();
        int sel = cp.getTblProduct().getSelectedRow();
        try {
            int qty = Integer.parseInt(cp.getTxtQuantity().getText().trim());
            float price = Float.parseFloat(cp.getTblProduct().getValueAt(sel, 4).toString());
            row.add(cp.getTblProduct().getValueAt(sel, 2));
            row.add(qty);
            row.add(price);
            subtotal = qty * price;
            row.add(String.format("%.2f", subtotal));
            
            cp.getLblTotal().setText(String.format("%.2f", total += subtotal));
            dm.addRow(row);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Invalid Qty!");
        }
    }
    
    public void remove (CashierPage cp) {
        DefaultTableModel dm = (DefaultTableModel) cp.getTblCart().getModel();
        
        int sel = cp.getTblCart().getSelectedRow();
        
        dm.removeRow(sel);
    }
    
}
