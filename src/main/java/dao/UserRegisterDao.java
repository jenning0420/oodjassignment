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
import sng.ResidentRegistration;

/**
 *
 * @author User
 */
public class UserRegisterDao implements ObjectDao<ResidentRegistration>{

    @Override
    public boolean add(ResidentRegistration urs) {
        try {
            if (!"".equals(urs.getUsername()) && !"".equals(urs.getName()) && !"".equals(urs.getContactNumber()) && !"".equals(urs.getGender()) && !"".equals(urs.getPassword())) {
                File f = new File(urs.getTextFile());
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int id = 0;
                int propid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    id = Integer.parseInt(row[0]);
                    propid = Integer.parseInt(row[0]);

                }
                int userID = id + 1;
                int propID = propid + 1001;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(userID + "," + urs.getUsername() + "," + urs.getName() + "," + urs.getContactNumber() + "," + urs.getGender() + "," + urs.getPassword() + "," + propID + ",");
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
