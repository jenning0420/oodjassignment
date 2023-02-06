/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adminexecutive;

import Propmanagement.system.ManageUnitSystem;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author joowe
 */
public class adminExecUnitManage extends javax.swing.JFrame {

    /**
     * Creates new form adminexecunitmanage
     */
    public adminExecUnitManage() {
        initComponents();
        setTitle("Manage Unit MainPage");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AddPage = new javax.swing.JButton();
        ModifyPage = new javax.swing.JButton();
        SearchPage = new javax.swing.JButton();
        ViewPage = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Unit Management Page");

        AddPage.setText("Add");
        AddPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPageActionPerformed(evt);
            }
        });

        ModifyPage.setText("Modify");
        ModifyPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyPageActionPerformed(evt);
            }
        });

        SearchPage.setText("Search");
        SearchPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPageActionPerformed(evt);
            }
        });

        ViewPage.setText("View");
        ViewPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPageActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ModifyPage)
                            .addComponent(AddPage)
                            .addComponent(SearchPage)
                            .addComponent(ViewPage)
                            .addComponent(Back))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(AddPage)
                .addGap(18, 18, 18)
                .addComponent(ModifyPage)
                .addGap(18, 18, 18)
                .addComponent(SearchPage)
                .addGap(18, 18, 18)
                .addComponent(ViewPage)
                .addGap(18, 18, 18)
                .addComponent(Back)
                .addGap(0, 69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPageActionPerformed
        adminExecUnitManageAdd adminexecunitmanageadd = new adminExecUnitManageAdd();
        adminexecunitmanageadd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddPageActionPerformed

    private void ModifyPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyPageActionPerformed
        adminExecUnitManageEdit adminexecunitmanageedit = new adminExecUnitManageEdit();
        adminexecunitmanageedit.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_ModifyPageActionPerformed

    private void SearchPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPageActionPerformed
        adminExecUnitManageSearch adminexecunitmanagesearch = new adminExecUnitManageSearch();
        adminexecunitmanagesearch.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SearchPageActionPerformed

    private void ViewPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPageActionPerformed
        adminExecUnitManageView adminexecunitmanageview = new adminExecUnitManageView();
        adminexecunitmanageview.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewPageActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        adminexecmainpage adminexecmainpage = new adminexecmainpage();
        adminexecmainpage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(adminExecUnitManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminExecUnitManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminExecUnitManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminExecUnitManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminExecUnitManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPage;
    private javax.swing.JButton Back;
    private javax.swing.JButton ModifyPage;
    private javax.swing.JButton SearchPage;
    private javax.swing.JButton ViewPage;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
