/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package accountexecutive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class accLogin extends javax.swing.JFrame {

    File accLoginFile = new File("C:\\Users\\User\\OneDrive - Asia Pacific University\\Desktop\\OODJ\\Assignment\\oodjassignment\\textfiles");
    int line;
    String Username, Password;

    /**
     * Creates new form accLogin
     */
    public accLogin() {
        initComponents();
    }

    void createFolder() {
        if (!accLoginFile.exists()) {
            accLoginFile.mkdirs();
        }
    }

    void readFile() {
        try {
            FileReader fr = new FileReader(accLoginFile + "\\accLogin.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(accLoginFile + "\\accLogin.txt");
                System.out.println("file created!");
            } catch (IOException ex1) {
                Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    void addData(String accUsername, String accPassword) {
        try {
            RandomAccessFile raf = new RandomAccessFile(accLoginFile + "\\accLogin.txt", "rw");
            for (int i = 0; i < line; i++) {
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("accUsername:" + accUsername + "\r\n");
            raf.writeBytes("accPassword:" + accPassword + "\r\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void checkData(String accUsername, String accPassword) {
        try {
            RandomAccessFile raf = new RandomAccessFile(accLoginFile + "\\accLogin.txt", "rw");
            String line = raf.readLine();
            Username = line.substring(12);
            Password = raf.readLine().substring(12);

            if (accUsername.equals(Username) & accPassword.equals(Password)) {
                JOptionPane.showMessageDialog(null, "Login Successful. Welcome Back ACCOUNT EXECUTIVE!");
            } else {
                JOptionPane.showMessageDialog(null, "Login UNSUCCESSFUL. Please try again!");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void logic(String accUsername, String accPassword) {
        try {
            RandomAccessFile raf = new RandomAccessFile(accLoginFile + "\\accLogin.txt", "rw");
            for (int i = 0; i < line; i += 3) {System.out.println("count" + i);
                String forUsername = raf.readLine().substring(12);
                String forPassword = raf.readLine().substring(12);
                if (accUsername.equals(forUsername) & accPassword.equals(forPassword)) {
                    JOptionPane.showMessageDialog(null, "Login Successful. Welcome Back ACCOUNT EXECUTIVE!");
                    break;
                } else if (i == (line - 2)) {
                    JOptionPane.showMessageDialog(null, "Login UNSUCCESSFUL. Please try again!");
                    break;
                }
                for (int k = 1; k <= 1; k++) {
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void countLines() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile(accLoginFile + "\\accLogin.txt", "rw");
            for (int i = 0; raf.readLine() != null; i++) {
                line++;
            }
            System.out.println("Number of lines:" + line);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(accLogin.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        accUsername = new javax.swing.JTextField();
        accPassword = new javax.swing.JTextField();
        accLogin = new javax.swing.JButton();
        accRegister = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome to PARKHILL RESIDENCE");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(Account Executive)");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password:");

        accUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accUsernameActionPerformed(evt);
            }
        });

        accPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accPasswordActionPerformed(evt);
            }
        });

        accLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        accLogin.setText("LOGIN");
        accLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accLoginActionPerformed(evt);
            }
        });

        accRegister.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        accRegister.setText("REGISTER");
        accRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accRegisterActionPerformed(evt);
            }
        });

        jButton3.setText("BACK");

        jButton2.setText("test");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(accRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(accLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(accUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(accPassword)))))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accUsernameActionPerformed

    private void accPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accPasswordActionPerformed

    private void accRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accRegisterActionPerformed
        createFolder();
        readFile();
        countLines();
        addData(accUsername.getText(), accPassword.getText());
    }//GEN-LAST:event_accRegisterActionPerformed

    private void accLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accLoginActionPerformed
        createFolder();
        readFile();
        countLines();
        logic(accUsername.getText(), accPassword.getText());
    }//GEN-LAST:event_accLoginActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//    checkData("robird", "123456");

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(accLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accLogin;
    private javax.swing.JTextField accPassword;
    private javax.swing.JButton accRegister;
    private javax.swing.JTextField accUsername;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
