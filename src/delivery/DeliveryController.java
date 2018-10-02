/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.BranchModel;
import models.DeliveryModel;
import models.EmployeeModel;
import models.SupplierModel;
import productpage.ProductPageController;
import delivery.DeliveryPage;


/**
 *
 * @author Allysha
 */
public class DeliveryController {
    
    public void clear(DeliveryForm df) { //clear the jtextfields from the delivery form
        df.getTxtProductCode().setText("");
        df.getTxtUnitPrice().setText("");
        df.getTxtNumberUnits().setText("");
        df.getTxtUnitMeasure().setText("");
        df.getcomboSupplier().setSelectedIndex(0);
        df.getcomboEmployee().setSelectedIndex(0);
    }
    
    public void addForm(DeliveryForm df) { //submits to the query to the database: delivery table
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        
        DeliveryModel dm = new DeliveryModel();
        
        dm.setProduct_code(dm.determineProduct(df.getTxtProductCode().getText()));
        System.out.println("Product ID: "+dm.getProduct_code());
        
        dm.setDelivery_unitprice(Float.parseFloat(df.getTxtUnitPrice().getText().trim()));
        dm.setDelivery_numberofunits(Integer.parseInt(df.getTxtNumberUnits().getText().trim()));
        dm.setDelivery_unitofmeasure(df.getTxtUnitMeasure().getText().trim());
        
        dm.setSupplier_name(dm.determineSupplier(df.getcomboSupplier().getSelectedItem().toString()));
        System.out.println("Supplier ID: "+dm.getSupplier_name());
        
        dm.setUsername(dm.determineEmployee(df.getcomboEmployee().getSelectedItem().toString()));
        System.out.println("Employee ID: "+dm.getUsername());
        
        
        if (dm.addForm() >= 1) {
            JOptionPane.showMessageDialog(null, "Successfully Added!");
            df.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
          
    }
    
    /*public ResultSet showAll(){
        Vector row;
        DeliveryModel dm = new DeliveryModel();
        ResultSet rs = showAll();
        
        DefaultTableModel model;
        
          try {
            while (rs.next()) {
                row = new Vector();
                
                row.add(rs.getInt("product_code"));
                row.add(rs.getInt("product_name"));
                row.add(rs.getInt("product_category"));
                row.add(rs.getInt("product_type"));
                row.add(rs.getInt("list_price"));
                
                //model.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger (ProductPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }*/
    
   
    
   
    
    
    
    
  
    
    public ResultSet getSupplier(){
        SupplierModel sm = new SupplierModel();
        return sm.getSupplier();
    }
    
    public ResultSet getBranch() {
        BranchModel bm = new BranchModel();
        return bm.getBranch();
    }
    
    public ResultSet getEmployee(){
        EmployeeModel em = new EmployeeModel();
        return em.getEmployee();
    }
    
}
