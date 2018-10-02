/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplepage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import login.Login;
import adminpage.AdminPage;
import adminpage.AdminPageController;
import java.sql.ResultSet;
import java.util.regex.PatternSyntaxException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.SupplierModel;
import models.EmployeeModel;
import net.proteanit.sql.DbUtils;

//
/**
 *
 * @author Allysha
 */
public class PeoplePage extends javax.swing.JFrame {

    /**
     * Creates new form PeoplePage
     */
    AdminPageController apc = new AdminPageController();
    //PeoplePageController ppl = new PeoplePageController();
    
    
    private String name;
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public PeoplePage() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    public PeoplePage(String name){
        initComponents();
        
        this.setLocationRelativeTo(null);
        setName(name);
        
        EmployeeModel em = new EmployeeModel();
        SupplierModel sm = new SupplierModel();
        ResultSet rs = em.viewAll(); //null;
        ResultSet rs2 = sm.viewAll();
        
        String val = em.determineBranch(name);
        if(val.compareTo("1")==0){
            comboBranch.setSelectedIndex(0);
            rs = em.viewLeyte("1");
        }else{
            comboBranch.setSelectedIndex(1);
            rs = em.viewLeyte("2");
        }
        
        tblEmp.setModel(DbUtils.resultSetToTableModel(rs));
        tblSupplier.setModel(DbUtils.resultSetToTableModel(rs2));
    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        company = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        AdminPage = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        AddEmp = new javax.swing.JButton();
        UpdateEmp = new javax.swing.JButton();
        DeleteEmp = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        searchUser = new javax.swing.JTextField();
        comboBranch = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        DeleteSupplier = new javax.swing.JButton();
        UpdateSupplier = new javax.swing.JButton();
        AddSupplier = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchSupplier = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        company.setText("Tanciong's General Merchandise");

        lblUser.setText("jLabel1");

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        AdminPage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmp.setRowHeight(25);
        tblEmp.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEmp);
        tblEmp.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        AddEmp.setText("ADD");
        AddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmpActionPerformed(evt);
            }
        });

        UpdateEmp.setText("UPDATE");
        UpdateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateEmpActionPerformed(evt);
            }
        });

        DeleteEmp.setText("DELETE");
        DeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmpActionPerformed(evt);
            }
        });

        jLabel.setText("Search:");

        searchUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchUserKeyReleased(evt);
            }
        });

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cebu Branch", "Leyte Branch" }));
        comboBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBranchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                        .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpdateEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteEmp)
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteEmp)
                    .addComponent(AddEmp)
                    .addComponent(UpdateEmp)
                    .addComponent(jLabel)
                    .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        AdminPage.addTab("EMPLOYEE", jPanel2);

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblSupplier);

        DeleteSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeleteSupplier.setText("DELETE");
        DeleteSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSupplierActionPerformed(evt);
            }
        });

        UpdateSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UpdateSupplier.setText("UPDATE");
        UpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSupplierActionPerformed(evt);
            }
        });

        AddSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddSupplier.setText("ADD");
        AddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search:");

        searchSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchSupplierKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpdateSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteSupplier)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DeleteSupplier)
                        .addComponent(UpdateSupplier)
                        .addComponent(AddSupplier)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AdminPage.addTab("SUPPLIER", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdminPage)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(company)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUser)))
                        .addGap(133, 133, 133))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(18, 18, 18)
                .addComponent(AdminPage)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Login l = new Login();
        l.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminPage ap = new AdminPage(this.getName());
        ap.getLblUser().setText("Welcome, "+this.getName());
        ap.setVisible(true);

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void AddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmpActionPerformed
        this.dispose();
        AddEmp ae = new AddEmp(this.getName());
        ae.setVisible(true);
    }//GEN-LAST:event_AddEmpActionPerformed

    private void DeleteEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmpActionPerformed
    if (tblEmp.getSelectedRow() != -1) {
            int empNumber;
            PeoplePageController peop = new PeoplePageController();            
            empNumber = Integer.parseInt(tblEmp.getModel().getValueAt(tblEmp.getSelectedRow(), 0).toString());
            peop.deleteEmp(empNumber);
            
            EmployeeModel em = new EmployeeModel();
            ResultSet rs = null;
            String val = em.determineBranch(name);

             if(val.compareTo("1")==0){
                comboBranch.setSelectedIndex(0);
                rs = em.viewLeyte("1");
            }else{
                comboBranch.setSelectedIndex(1);
                rs = em.viewLeyte("2");
            }

            tblEmp.setModel(DbUtils.resultSetToTableModel(rs));
            
            } 
    else {
            JOptionPane.showMessageDialog(null, "Please select a row first!");
        }
    }//GEN-LAST:event_DeleteEmpActionPerformed

    private void AddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierActionPerformed
        this.dispose();
        AddSupplier as = new AddSupplier(this.getName());
        as.setVisible(true);
    }//GEN-LAST:event_AddSupplierActionPerformed

    private void DeleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSupplierActionPerformed
       if (tblSupplier.getSelectedRow() != -1) {
            int supplierNumber;
            PeoplePageController peop = new PeoplePageController();            
            supplierNumber = Integer.parseInt(tblSupplier.getModel().getValueAt(tblSupplier.getSelectedRow(), 0).toString());
            peop.deleteSupplier(supplierNumber);
            
            SupplierModel sm = new SupplierModel();
            ResultSet rs = sm.viewAll();
            tblSupplier.setModel(DbUtils.resultSetToTableModel(rs));
            } 
    else {
            JOptionPane.showMessageDialog(null, "Please select a row first!");
        }
       
    }//GEN-LAST:event_DeleteSupplierActionPerformed

    private void comboBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBranchActionPerformed
        EmployeeModel em = new EmployeeModel();
        ResultSet rs = null;
        
        if(comboBranch.getSelectedItem().toString().compareTo("Cebu Branch")==0){
            rs = em.viewLeyte("1");
        }else{
            rs = em.viewLeyte("2");
        }
        
        tblEmp.setModel(DbUtils.resultSetToTableModel(rs)); 

        DefaultTableModel model = (DefaultTableModel) tblEmp.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        tblEmp.setRowSorter(tr);
        try {
            tr.setRowFilter(RowFilter.regexFilter("(?i)"+searchUser.getText()));
        } catch (PatternSyntaxException e) {
            
        }
    }//GEN-LAST:event_comboBranchActionPerformed

    private void UpdateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateEmpActionPerformed
        if (tblEmp.getSelectedRow() != -1) {
            UpdateEmp ue = new UpdateEmp(this.getName(), Integer.parseInt(tblEmp.getValueAt(tblEmp.getSelectedRow(), 0).toString()), tblEmp.getValueAt(tblEmp.getSelectedRow(), 1).toString(), tblEmp.getValueAt(tblEmp.getSelectedRow(), 2).toString(), tblEmp.getValueAt(tblEmp.getSelectedRow(), 3).toString(), tblEmp.getValueAt(tblEmp.getSelectedRow(), 4).toString(), tblEmp.getValueAt(tblEmp.getSelectedRow(), 5).toString(), tblEmp.getValueAt(tblEmp.getSelectedRow(), 6).toString(),  tblEmp.getValueAt(tblEmp.getSelectedRow(), 7).toString());
            ue.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Please select an item first!");
        }
    }//GEN-LAST:event_UpdateEmpActionPerformed

    private void searchUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchUserKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblEmp.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        tblEmp.setRowSorter(tr);
        try {
            tr.setRowFilter(RowFilter.regexFilter("(?i)"+searchUser.getText()));
        } catch (PatternSyntaxException e) {
            
        }
    }//GEN-LAST:event_searchUserKeyReleased

    private void searchSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchSupplierKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblSupplier.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        tblSupplier.setRowSorter(tr);
        try {
            tr.setRowFilter(RowFilter.regexFilter("(?i)"+searchSupplier.getText()));
        } catch (PatternSyntaxException e) {
            
        }
    }//GEN-LAST:event_searchSupplierKeyReleased

    private void UpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSupplierActionPerformed
        if (tblSupplier.getSelectedRow() != -1) {
            UpdateSupplier us = new UpdateSupplier(this.getName(), Integer.parseInt(tblSupplier.getValueAt(tblSupplier.getSelectedRow(), 0).toString()), tblSupplier.getValueAt(tblSupplier.getSelectedRow(), 1).toString(), tblSupplier.getValueAt(tblSupplier.getSelectedRow(), 2).toString(), tblSupplier.getValueAt(tblSupplier.getSelectedRow(), 3).toString(), tblSupplier.getValueAt(tblSupplier.getSelectedRow(), 4).toString(), tblSupplier.getValueAt(tblSupplier.getSelectedRow(), 5).toString());
            us.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Please select an item first!");
        }
    }//GEN-LAST:event_UpdateSupplierActionPerformed

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
            java.util.logging.Logger.getLogger(PeoplePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeoplePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeoplePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeoplePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeoplePage().setVisible(true);
            }
        });
    }
    
    public JLabel getLblUser() {
        return lblUser;
    }
    
    public JTextField getTxtSearch() {
        return searchUser;
    }
    
    public JTable getTblEmp() {
        return tblEmp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEmp;
    private javax.swing.JButton AddSupplier;
    private javax.swing.JTabbedPane AdminPage;
    private javax.swing.JButton DeleteEmp;
    private javax.swing.JButton DeleteSupplier;
    private javax.swing.JButton UpdateEmp;
    private javax.swing.JButton UpdateSupplier;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JLabel company;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField searchSupplier;
    private javax.swing.JTextField searchUser;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTable tblSupplier;
    // End of variables declaration//GEN-END:variables



}
