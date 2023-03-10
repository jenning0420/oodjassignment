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
import PropertyManagement.VendorRegistration;

/**
 *
 * @author User
 */
public class VendorRegisterDao implements ObjectDao<VendorRegistration>{

    @Override
    public boolean add(VendorRegistration vrs) {
        try {
            if (!"".equals(vrs.getUsername()) && !"".equals(vrs.getName()) && !"".equals(vrs.getContactNumber()) && !"".equals(vrs.getGender()) && !"".equals(vrs.getPassword())) {
                File f = new File(vrs.getTextFile());
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int id = 200;
                int propertyid = 2000;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    id = Integer.parseInt(row[0]);
                    propertyid = Integer.parseInt(row[6]);

                }
                int userID = id + 1;
                int propID = propertyid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(userID + "," + vrs.getUsername() + "," + vrs.getName() + "," + vrs.getContactNumber() + "," + vrs.getGender() + "," + vrs.getPassword() + "," + propID + ",");
                pw.flush();
                pw.close();
                bw.close();
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            System.out.println("FileNotFound");
        }

        return false;
    }
}
