/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import PropertyManagement.StaffRegistration;

/**
 *
 * @author User
 */
public class AddUserDao implements ObjectDao<StaffRegistration>{
    @Override
    public boolean add(StaffRegistration aus){
        try {
            if (!"".equals(aus.getUsername()) && !"".equals(aus.getName()) && !"".equals(aus.getContactNumber()) && !"".equals(aus.getGender()) && !"".equals(aus.getPassword())) {
                File f = new File(aus.getTextFile());
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int id = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    id = Integer.parseInt(row[0]);

                }
                int userID = id + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(userID + "," + aus.getUsername() + "," + aus.getName() + "," + aus.getContactNumber() + "," + aus.getGender() + "," + aus.getPassword() + ",");
                pw.flush();
                pw.close();
                bw.close();
                return true;
            } else{
                return false;
            }

        } catch (IOException e) {
            System.out.println("FileNotFound");
        }

        return false;

    }
}
