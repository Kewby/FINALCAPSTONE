/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import peoplepage.PeoplePage;
import models.SupplierModel;

/**
 *
 * @author kirbp
 */
public class UpdateSupplier extends javax.swing.JFrame {

    UpdateSupplierController usc = new UpdateSupplierController();
    
    private String name;
    private int supplierId;
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getSupplierId(){
        return supplierId;
    }
    
    public void setSupplierId(int supplierId){
        this.supplierId = supplierId;
    }
    
    public UpdateSupplier() {
        initComponents();
        this.setLocationRelativeTo(null);
        
            //DATA U CAN ONLY UPDATE
            txtSupplierName.setText("");
            txtAddress.setText("");
            txtEmail.setText("");
            txtContactNumber.setText("");
            txtContactPerson.setText("");
    }
    
    public UpdateSupplier(String name, int supplierId, String supplierName, String address, String email, String contactnumber,  String contactperson) {
        initComponents();
        SupplierModel sm = new SupplierModel();
        this.setLocationRelativeTo(null);
        setName(name);
        setSupplierId(supplierId);
        System.out.println("Supplier ID:"+supplierId);
        
        txtSupplierName.setText(supplierName);
        txtAddress.setText(address);
        txtEmail.setText(email);
        txtContactNumber.setText(contactnumber);
        txtContactPerson.setText(contactperson);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSupplierName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtContactPerson = new javax.swing.JTextField();
        background_updateSupplier = new javax.swing.JLabel();
        UpdateSupplierClear = new javax.swing.JButton();
        UpdateSupplierUpdate = new javax.swing.JButton();
        UpdateSupplierCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(null);

        txtSupplierName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtSupplierName);
        txtSupplierName.setBounds(270, 180, 290, 40);

        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel1.add(txtAddress);
        txtAddress.setBounds(270, 250, 290, 40);

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel1.add(txtEmail);
        txtEmail.setBounds(270, 330, 290, 40);

        txtContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel1.add(txtContactNumber);
        txtContactNumber.setBounds(270, 410, 290, 40);

        txtContactPerson.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel1.add(txtContactPerson);
        txtContactPerson.setBounds(270, 480, 290, 40);

        background_updateSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FORMADJUSTED-07.png"))); // NOI18N
        jPanel1.add(background_updateSupplier);
        background_updateSupplier.setBounds(0, 0, 600, 700);

        UpdateSupplierClear.setText("CLEAR");
        UpdateSupplierClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSupplierClearActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateSupplierClear);
        UpdateSupplierClear.setBounds(370, 550, 80, 40);

        UpdateSupplierUpdate.setText("UPDATE");
        UpdateSupplierUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSupplierUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateSupplierUpdate);
        UpdateSupplierUpdate.setBounds(260, 550, 100, 30);

        UpdateSupplierCancel.setText("CANCEL");
        UpdateSupplierCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSupplierCancelActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateSupplierCancel);
        UpdateSupplierCancel.setBounds(460, 550, 100, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateSupplierClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSupplierClearActionPerformed
        usc.clear(this);
    }//GEN-LAST:event_UpdateSupplierClearActionPerformed

    private void UpdateSupplierUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSupplierUpdateActionPerformed
        if(txtSupplierName.getText().trim().equals("") || txtAddress.getText().trim().equals("")
            || txtEmail.getText().trim().equals("") || txtContactNumber.getText().trim().equals("")
            || txtContactPerson.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Failed! Please fill up!");
        }else {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to update this?", "Confirm Update",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                usc.update(this);
                PeoplePage peop = new PeoplePage(this.getName());
                peop.getLblUser().setText("Welcome, "+this.getName());
                peop.setVisible(true);             
                peop.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            
        }
    }//GEN-LAST:event_UpdateSupplierUpdateActionPerformed

    private void UpdateSupplierCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSupplierCancelActionPerformed
        this.dispose();
        PeoplePage peop = new PeoplePage(this.getName());
        
        peop.getLblUser().setText("Welcome, "+this.getName());
        peop.setVisible(true);             
        peop.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_UpdateSupplierCancelActionPerformed

    private void txtSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSupplier().setVisible(true);
            }
        });
    }
    
     public JTextField getTxtSupplierName() {
        return txtSupplierName;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtContactNumber() {
        return txtContactNumber;
    }
    
    public JTextField getTxtContactPerson(){
        return txtContactPerson;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateSupplierCancel;
    private javax.swing.JButton UpdateSupplierClear;
    private javax.swing.JButton UpdateSupplierUpdate;
    private javax.swing.JLabel background_updateSupplier;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtContactPerson;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
