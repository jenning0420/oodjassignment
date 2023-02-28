/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sng;

import buildingmanager.buildingModifyAccount;
import buildingmanager.buildingModifyBuilding;
import dao.AddOperationDao;
import dao.AddUserDao;
import dao.ApplyPassDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class BuildingManager {
    String filePath;
    public boolean addBuilding(AddUserDao aud, StaffRegistration aus){
        return aud.add(aus);
    }    
    
    public boolean addAdmin(AddUserDao aud, StaffRegistration aus){
        return aud.add(aus);
    }   
    
    public boolean addAccountExec(AddUserDao aud, StaffRegistration aus){
        return aud.add(aus);
    }  
    
    
    public void displayTable(JTable userTable, String filePath){
        this.filePath = filePath;
        File file = new File(filePath);
        

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] colHeadings = line.trim().split(",");

            DefaultTableModel model = (DefaultTableModel) userTable.getModel();
            model.setColumnIdentifiers(colHeadings);
            Object[] lines = br.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split(",");
                model.addRow(row);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(buildingModifyBuilding.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(buildingModifyBuilding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
