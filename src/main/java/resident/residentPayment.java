/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package resident;
//import Propmanagement.function.ResidentPayment;
//import Propmanagement.function.Unit;
//import Propmanagement.function.getInvoiceID;
//import Propmanagement.system.ManageUnitSystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sng.Modification;

/**
 *
 * @author Admin
 */
public class residentPayment extends javax.swing.JFrame {

    Modification rucs = new Modification();
    
    /**
     * Creates new form residentPayment
     */
    public residentPayment() {
        initComponents();
        
        try {
            FileReader fr1 = new FileReader("src/textFiles/activeUser.txt");
            try ( BufferedReader br1 = new BufferedReader(fr1)) {
                String line1 = null;
                String[] splt1 = null;

                while ((line1 = br1.readLine()) != null) {
                    splt1 = line1.split(",");
                    rucs.setUserID1(splt1[0]);

                }

            }
        } catch (IOException e) {
            System.out.println("FileNotFound");
        }

        String filePath = "src/textFiles/invoice.txt";
        File file = new File(filePath);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] colHeadings = line.trim().split(",");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(colHeadings);
            Object[] lines = br.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split(",");
                rucs.setUserID(row[1]);
                if (rucs.getUserID().equals(rucs.getUserID1())) {
                    model.addRow(row);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(residentPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(residentPayment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void payButton(){
        
        double money = 0;
        money = Double.parseDouble(finalamount.getText());

        if (money < Double.parseDouble(totalamount.getText())) {
            JOptionPane.showMessageDialog(null, "Sorry, You Didn't Have Enough Money To Pay !!!");
        } else if (money == 0) {
            JOptionPane.showMessageDialog(null, "You Have Already Pay !!!");
        } else if (money > Double.parseDouble(totalamount.getText())) {
            JOptionPane.showMessageDialog(null, "Please Pay The Correct Amount !!!");
        } else {
            money = money - Double.parseDouble(totalamount.getText());

            String filepath = "src/textFiles/invoice.txt";
            String invoiceid = disInvoiceID.getText();
            String userid = disUserID.getText();
            String unitno = disUnitNo.getText();
            String paymenttype = disPaymentType.getText();
            String amount = totalamount.getText();
            String duedate = disDueDate.getText();

            JOptionPane.showMessageDialog(null, "Thank you and have a nice day");
                  
            try {     
                
                BufferedReader br = new BufferedReader(new FileReader("src/textFiles/residentPayment.txt"));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int paymentid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    paymentid = Integer.parseInt(row[0]);
                }
                int paymentID = paymentid + 1;
                FileWriter writer = new FileWriter("src/textFiles/residentPayment.txt", true);
                writer.write(paymentID + "," + userid + "," + unitno + "," + paymenttype + "," + amount + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Your receipt will be generated soon!");
                new residentHome().setVisible(true);
                this.setVisible(false);                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error generating receipt!");
            }            

            String tempFile = "src/textFiles/invoicetemp.txt";
            File oldFile = new File(filepath);
            File newFile = new File(tempFile);
            String field = "";
            String InvoiceID = "";
            String UserID = "";
            String UnitNo = "";
            String PaymentType = "";
            String Amount = "";
            String DueDate = "";

            try {
                FileWriter rd = new FileWriter(tempFile, false);
                BufferedWriter bw = new BufferedWriter(rd);
                PrintWriter pw = new PrintWriter(bw);
                Scanner x = new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");

                while (x.hasNext()) {
                    InvoiceID = x.next();
                    UserID = x.next();
                    UnitNo = x.next();
                    PaymentType = x.next();
                    Amount = x.next();
                    DueDate = x.next();

                    if (invoiceid.equals(InvoiceID)) {
                        pw.println(invoiceid + "," + UserID + "," + UnitNo + "," + PaymentType + "," + money + "," + DueDate);
                    } else {
                        pw.println(InvoiceID + "," + UserID + "," + UnitNo + "," + PaymentType + "," + Amount + "," + DueDate);
                    }
                }
                x.close();
                pw.flush();
                pw.close();
                Scanner y = new Scanner(new File(tempFile));
                FileWriter fw = new FileWriter(filepath, false);
                BufferedWriter bb = new BufferedWriter(fw);
                PrintWriter pp = new PrintWriter(bb);

                while (y.hasNext()) {
                    pp.println(y.next());
                }
                y.close();
                pp.flush();
                pp.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error...");
            }
        }
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Pay = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        finalamount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalamount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        disUnitNo = new javax.swing.JTextField();
        disPaymentType = new javax.swing.JTextField();
        disDueDate = new javax.swing.JTextField();
        disInvoiceID = new javax.swing.JTextField();
        disUserID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Resident Payment Page");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Below shows all your pending payment that needed to be payed");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "User ID", "Unit No", "Payment Type", "Amount (RM)", "Due Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        Pay.setText("Pay");
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });

        jLabel4.setText("Please enter the payable amount:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Please select the row that you want to pay below");

        jLabel6.setText("Total amount selected:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Please confirm your selected information below");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(37, 37, 37)
                                .addComponent(Pay)
                                .addGap(175, 175, 175)
                                .addComponent(disUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(disUnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(disPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(disDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(disInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(106, 106, 106)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(finalamount)
                                            .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(155, 155, 155)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel7)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel7)
                        .addContainerGap(123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(disUnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(finalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Pay)
                                    .addComponent(jButton1))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(disUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(disInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        disInvoiceID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        disUserID.setText(model.getValueAt(selectedRowIndex, 1).toString());
        disUnitNo.setText(model.getValueAt(selectedRowIndex, 2).toString());
        disPaymentType.setText(model.getValueAt(selectedRowIndex, 3).toString());
        totalamount.setText(model.getValueAt(selectedRowIndex, 4).toString());
        disDueDate.setText(model.getValueAt(selectedRowIndex, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        payButton();
    }//GEN-LAST:event_PayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new residentHome().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(residentPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(residentPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(residentPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(residentPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new residentPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pay;
    private javax.swing.JTextField disDueDate;
    private javax.swing.JTextField disInvoiceID;
    private javax.swing.JTextField disPaymentType;
    private javax.swing.JTextField disUnitNo;
    private javax.swing.JTextField disUserID;
    private javax.swing.JTextField finalamount;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField totalamount;
    // End of variables declaration//GEN-END:variables
}
