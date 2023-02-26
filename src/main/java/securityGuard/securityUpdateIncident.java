/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package securityGuard;

import file.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import sng.UpdateIncidentSng;

/**
 *
 * @author User
 */
public class securityUpdateIncident extends javax.swing.JFrame {
    
    String timeInFinal;
    UpdateIncidentSng uis = new UpdateIncidentSng();
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

    /**
     * Creates new form securityUpdateIncident
     */
    public securityUpdateIncident() {
        initComponents();
        
        try {
            FileReader fr1 = new FileReader("src/textFiles/activeUser.txt");
            try ( BufferedReader br1 = new BufferedReader(fr1)) {
                String line1 = null;
                String[] splt1 = null;

                while ((line1 = br1.readLine()) != null) {
                    splt1 = line1.split(",");
                    uis.setUserID1(splt1[0]);

                }

            }
        } catch (IOException e) {
            System.out.println("FileNotFound");
        }

        String filePath = "src/textFiles/incident.txt";
        File file = new File(filePath);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] colHeadings = line.trim().split(",");

            DefaultTableModel model = (DefaultTableModel) incidentTable.getModel();
            model.setColumnIdentifiers(colHeadings);
            Object[] lines = br.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split(",");
                uis.setUserID(row[1]);
//                String number = ("17");
//                System.out.println(rucs.getUserID().getClass());
//                System.out.println(number.getClass());
                if (uis.getUserID().equals(uis.getUserID1())) {
                    model.addRow(row);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(securityUpdateIncident.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(securityUpdateIncident.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateIncident(){
        int item = incidentTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) incidentTable.getModel();

        if (item >= 0) {
            model.setValueAt(incidentID.getText(), item, 0);
            model.setValueAt(userID.getText(), item, 1);
            model.setValueAt(description.getText(), item, 2);
            model.setValueAt(((JTextField) dateIn.getDateEditor().getUiComponent()).getText(), item, 3);
            Date time = (Date) timeIn.getValue();
            timeInFinal = formatter.format(time);
            model.setValueAt(timeInFinal, item, 4);

            ArrayList<String[]> tableArray = new ArrayList<>();
            for (int i = 0; i < incidentTable.getRowCount(); i++) {
                String[] tempArray = new String[5];
                for (int j = 0; j < incidentTable.getColumnCount(); j++) {
                    tempArray[j] = incidentTable.getValueAt(i, j).toString();
                }
                tableArray.add(tempArray);
            }

            String filePath = "src/textFiles/incident.txt";
            ArrayList<String[]> array = FileService.readFile(filePath);
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount(); i++) {
                    colHeadings = colHeadings + model.getColumnName(i) + ",";
                }
                bw.write(colHeadings + "\n");
                String content = "";
                boolean change = false;
                for (String[] tempArray : array) {
                    for (String[] tempTableArray : tableArray) {
                        if (tempTableArray[0].equals(tempArray[0]) && tempTableArray[1].equals(tempArray[1])) {
                            content += String.join(",", tempTableArray) + ",\n";
                            change = true;
                            break;
                        }
                    }
                    if (change) {
                        change = false;
                        continue;
                    }
                    content += String.join(",", tempArray) + ",\n";
                }
                bw.write(content);
                bw.close();

            } catch (IOException ex) {
                Logger.getLogger(securityUpdateVisitorEntry.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(this, "Visitor Entry UPDATED!");
            new securityVisitorEntryManagement().setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please fill up ALL details!");
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

        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        incidentTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        incidentID = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        dateIn = new com.toedter.calendar.JDateChooser();
        clear = new javax.swing.JButton();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timeIn = new javax.swing.JSpinner(sm);
        jLabel12 = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back.setForeground(java.awt.Color.black);
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Incident");

        incidentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Incident ID", "User ID", "Description", "Date In", "Time In"
            }
        ));
        incidentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                incidentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(incidentTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Incident ID :");

        incidentID.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                incidentIDComponentShown(evt);
            }
        });
        incidentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidentIDActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(java.awt.Color.black);
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Date In :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Description :");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane4.setViewportView(description);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Time In :");

        dateIn.setDateFormatString("dd-MM-yyyy");

        clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clear.setForeground(java.awt.Color.black);
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(timeIn, "HH:mm");
        timeIn.setEditor(de);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("User ID :");

        userID.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                userIDComponentShown(evt);
            }
        });
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incidentID, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incidentID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(dateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new securityIncidentManagement().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void incidentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incidentTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) incidentTable.getModel();
        int selectedInfo = incidentTable.getSelectedRow();

        incidentID.setText(model.getValueAt(selectedInfo, 0).toString());
        userID.setText(model.getValueAt(selectedInfo, 1).toString());
        description.setText(model.getValueAt(selectedInfo, 2).toString());
        ((JTextField) dateIn.getDateEditor().getUiComponent()).setText(model.getValueAt(selectedInfo, 3).toString());

        String timeValue = (String) model.getValueAt(selectedInfo, 4);
        Date dateValue;
        try {
            dateValue = dateFormat.parse(timeValue);
            //            SpinnerDateModel spinnerModel = new SpinnerDateModel(dateValue, null, null, Calendar.DAY_OF_MONTH);
            //            JSpinner spinner = new JSpinner(spinnerModel);
            timeIn.setValue(dateValue);
        } catch (ParseException ex) {
            Logger.getLogger(securityUpdateVisitorEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_incidentTableMouseClicked

    private void incidentIDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_incidentIDComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_incidentIDComponentShown

    private void incidentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incidentIDActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateIncident();
    }//GEN-LAST:event_updateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        description.setText(null);
        dateIn.setDate(null);
        //duration.setText(null);
    }//GEN-LAST:event_clearActionPerformed

    private void userIDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_userIDComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDComponentShown

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

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
            java.util.logging.Logger.getLogger(securityUpdateIncident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(securityUpdateIncident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(securityUpdateIncident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(securityUpdateIncident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new securityUpdateIncident().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser dateIn;
    private javax.swing.JTextArea description;
    private javax.swing.JTextField incidentID;
    private javax.swing.JTable incidentTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner timeIn;
    private javax.swing.JButton update;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables
}
