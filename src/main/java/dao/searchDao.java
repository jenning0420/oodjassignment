/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import buildingmanager.buildingModifyAccount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class searchDao {

    public void search(DefaultTableModel model, javax.swing.JTable userTable, javax.swing.JTextField searchText) {
        String filePath = "src/textFiles/accountLogin.txt";
        File file = new File(filePath);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] colHeadings = line.trim().split(",");

            model.setColumnIdentifiers(colHeadings);
            Object[] lines = br.lines().toArray();

            if (model != null) {
                int row123 = userTable.getRowCount();
                for (int n = row123 - 1; n >= 0; n--) {
                    model.removeRow(n);
                }
            }

            String searchInfo = searchText.getText().toLowerCase();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split(",");
                if (row[0].contains(searchInfo) || row[1].contains(searchInfo) || row[2].contains(searchInfo) || row[3].contains(searchInfo) || row[4].contains(searchInfo) || row[5].contains(searchInfo)) {
                    model.addRow(row);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(buildingModifyAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(buildingModifyAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
