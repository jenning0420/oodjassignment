/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adminexecutive.adminManageEmp;
import adminexecutive.adminModifyEmployee;
import adminexecutive.adminModifyResident;
import adminexecutive.adminModifySecurity;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sng.EmployeeRegistration;
import sng.ResidentRegistration;
import sng.User;
import sng.VendorRegistration;

/**
 *
 * @author User
 */
public class AdminExecutive {

    public boolean login(UserLoginDao uld, User uls) {
        return uld.add(uls);
    }

    public boolean AddResident(UserRegisterDao urd, ResidentRegistration urs) {
        return urd.add(urs);
    }

    public boolean AddVendor(VendorRegisterDao vrd, VendorRegistration vrs) {
        return vrd.add(vrs);
    }

    public boolean AddEmployee(EmployeeRegisterDao erd, EmployeeRegistration ers) {
        return erd.add(ers);
    }

    public void modifyEmployee(JLabel userID, JTextField Username, JTextField Name, JTextField ContactNumber, JComboBox Gender, JTextField Password, JComboBox empType, JTable userTable, adminModifyEmployee am) {
        adminManageEmp ame = new adminManageEmp();
        int item = userTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();

        if (item >= 0) {
            model.setValueAt(userID.getText(), item, 0);
            model.setValueAt(Username.getText(), item, 1);
            model.setValueAt(Name.getText(), item, 2);
            model.setValueAt(ContactNumber.getText(), item, 3);
            model.setValueAt(Gender.getSelectedItem(), item, 4);
            model.setValueAt(Password.getText(), item, 5);
            model.setValueAt(empType.getSelectedItem(), item, 6);

            String filePath = "src/textFiles/employeeLogin.txt";
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount(); i++) {
                    colHeadings = colHeadings + model.getColumnName(i) + ",";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < userTable.getRowCount(); i++) {
                    for (int j = 0; j < userTable.getColumnCount(); j++) {
                        bw.write(userTable.getValueAt(i, j).toString() + ",");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(adminModifyEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Employee Account Updated SUCCESSFULLY!");
            ame.setVisible(true);
            am.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up ALL details!");
        }
    }

    public void removeEmployee(JTable userTable, adminModifyEmployee am) {
        adminManageEmp ame = new adminManageEmp();
        int item = userTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();

        if (item >= 0) {
            model.removeRow(item);
            String filePath = "src/textFiles/employeeLogin.txt";
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount(); i++) {
                    colHeadings = colHeadings + model.getColumnName(i) + ",";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < userTable.getRowCount(); i++) {
                    for (int j = 0; j < userTable.getColumnCount(); j++) {
                        bw.write(userTable.getValueAt(i, j).toString() + ",");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(adminModifyResident.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Employee Account Removed SUCCESSFULLY!");
            ame.setVisible(true);
            am.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select the fill to Delete!");
        }
    }

    public boolean AddSecurity(EmployeeRegisterDao erd, EmployeeRegistration ers) {
        return erd.add(ers);
    }

    public void modifySecurity(JLabel userID, JTextField Username, JTextField Name, JTextField ContactNumber, JComboBox Gender, JTextField Password, JComboBox empType, JTable userTable, adminModifySecurity ams) {
        int item = userTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        adminManageEmp ame = new adminManageEmp();
//        adminModifySecurity ams = new adminModifySecurity();

        if (item >= 0) {
            model.setValueAt(userID.getText(), item, 0);
            model.setValueAt(Username.getText(), item, 1);
            model.setValueAt(Name.getText(), item, 2);
            model.setValueAt(ContactNumber.getText(), item, 3);
            model.setValueAt(Gender.getSelectedItem(), item, 4);
            model.setValueAt(Password.getText(), item, 5);
            model.setValueAt(empType.getSelectedItem(), item, 6);

            String filePath = "src/textFiles/securityLogin.txt";
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount(); i++) {
                    colHeadings = colHeadings + model.getColumnName(i) + ",";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < userTable.getRowCount(); i++) {
                    for (int j = 0; j < userTable.getColumnCount(); j++) {
                        bw.write(userTable.getValueAt(i, j).toString() + ",");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(adminModifySecurity.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Security Guard Account Updated SUCCESSFULLY!");
            ame.setVisible(true);
            ams.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up ALL details!");
        }

    }
    
    public void removeSecurity(JTable userTable, adminModifySecurity ams) {
        adminManageEmp ame = new adminManageEmp();
        int item = userTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();

        if (item >= 0){
            model.removeRow(item);
            String filePath = "src/textFiles/securityLogin.txt";
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount();i++){
                    colHeadings = colHeadings + model.getColumnName(i) + ",";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < userTable.getRowCount(); i++) {
                    for (int j = 0; j < userTable.getColumnCount(); j++) {
                        bw.write(userTable.getValueAt(i, j).toString() + ",");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(adminModifyResident.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Security Guard Account Removed SUCCESSFULLY!");
            ame.setVisible(true);
            ams.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select the fill to Delete!");
        }
        
    }

}
