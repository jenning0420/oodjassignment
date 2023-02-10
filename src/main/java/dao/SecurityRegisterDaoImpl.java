/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import sng.EmployeeRegisterSng;

/**
 *
 * @author User
 */
public class SecurityRegisterDaoImpl implements EmployeeRegisterDao{
    public boolean employeeRegister(EmployeeRegisterSng ers){
        try {
            if (!"".equals(ers.getUsername()) && !"".equals(ers.getName()) && !"".equals(ers.getContactNumber()) && !"".equals(ers.getGender()) && !"".equals(ers.getPassword())) {
                File f = new File(ers.getTextFile());
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int userid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    userid = Integer.parseInt(row[0]);

                }
                int userID = userid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(userID + "," + ers.getUsername() + "," + ers.getName() + "," + ers.getContactNumber() + "," + ers.getGender() + "," + ers.getPassword() + "," + ers.getEmpType() + ",");
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
