/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import peoplepage.PeoplePage;

/**
 *
 * @author Client
 */
public class AddSupplier extends javax.swing.JFrame {
    /**
     * Creates new form AddSupplier
     */
    AddSupplierController asc = new AddSupplierController();
    
    private String name; 
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public AddSupplier() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    public AddSupplier(String name){
        initComponents();
        
        this.setLocationRelativeTo(null);
        setName(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtSupplierName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtContactPerson = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        background_addSupplier = new javax.swing.JLabel();
        AddSupplierAdd = new javax.swing.JButton();
        AddSupplierClear = new javax.swing.JButton();
        AddSupplierCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(null);

        txtSupplierName.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtSupplierName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtSupplierName);
        txtSupplierName.setBounds(270, 170, 290, 40);

        txtAddress.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtAddress);
        txtAddress.setBounds(270, 250, 290, 40);

        txtEmail.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtEmail);
        txtEmail.setBounds(270, 330, 290, 40);

        txtContactPerson.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtContactPerson.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        txtContactPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactPersonActionPerformed(evt);
            }
        });
        jPanel2.add(txtContactPerson);
        txtContactPerson.setBounds(270, 480, 290, 40);

        txtContactNumber.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        txtContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 158, 9), 2));
        jPanel2.add(txtContactNumber);
        txtContactNumber.setBounds(270, 400, 290, 40);

        background_addSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FORMADJUSTED-06.png"))); // NOI18N
        jPanel2.add(background_addSupplier);
        background_addSupplier.setBounds(0, 0, 600, 690);

        AddSupplierAdd.setText("ADD");
        AddSupplierAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierAddActionPerformed(evt);
            }
        });
        jPanel2.add(AddSupplierAdd);
        AddSupplierAdd.setBounds(273, 560, 80, 40);

        AddSupplierClear.setText("CLEAR");
        AddSupplierClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierClearActionPerformed(evt);
            }
        });
        jPanel2.add(AddSupplierClear);
        AddSupplierClear.setBounds(360, 560, 80, 30);

        AddSupplierCancel.setText("CANCEL");
        AddSupplierCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierCancelActionPerformed(evt);
            }
        });
        jPanel2.add(AddSupplierCancel);
        AddSupplierCancel.setBounds(460, 560, 100, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddSupplierClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierClearActionPerformed
        asc.clear(this);
    }//GEN-LAST:event_AddSupplierClearActionPerformed

    private void AddSupplierAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierAddActionPerformed
        if (txtSupplierName.getText().trim().equals("") || txtAddress.getText().trim().equals("")
            || txtEmail.getText().trim().equals("") || txtContactNumber.getText().trim().equals("") 
            || txtContactPerson.getText().trim().equals(""))  {
            JOptionPane.showMessageDialog(null, "Failed! Please fill up!");
        } else {
            String supplierName = txtSupplierName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            String contactNumber = txtContactNumber.getText();
            String contactPerson = txtContactPerson.getText();
            
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to add supplier?", "Confirm Adding",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    asc.add(supplierName, address, email, contactNumber, contactPerson);
                    
                    this.dispose();
                    PeoplePage peop = new PeoplePage(this.getName());
                    peop.getLblUser().setText("Welcome "+this.getName());
                    peop.setVisible(true);
                    peop.setExtendedState(JFrame.MAXIMIZED_BOTH);
                } catch (IOException ex) {
                    Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }//GEN-LAST:event_AddSupplierAddActionPerformed

    private void AddSupplierCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierCancelActionPerformed
        try {
            this.dispose();
            PeoplePage peop = new PeoplePage(this.getName());
            peop.getLblUser().setText("Welcome "+this.getName());
            peop.setVisible(true);
            peop.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (IOException ex) {
            Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddSupplierCancelActionPerformed

    private void txtContactPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactPersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactPersonActionPerformed

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
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSupplier().setVisible(true);
            }
        });
    }
    
    public JTextField getTxtSupplierName(){
        return txtSupplierName;
    }
    
    public JTextField getTxtAddress(){
        return txtAddress;
    }
    
    public JTextField getTxtEmail(){
        return txtEmail;
    }

    public JTextField getTxtContactNo(){
        return txtContactNumber;
    }
    
    public JTextField getTxtContactPerson(){
        return txtContactPerson;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSupplierAdd;
    private javax.swing.JButton AddSupplierCancel;
    private javax.swing.JButton AddSupplierClear;
    private javax.swing.JLabel background_addSupplier;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtContactPerson;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}