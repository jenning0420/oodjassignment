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
import PropertyManagement.Resident;

/**
 *
 * @author User
 */
public class ResidentLoginDao implements ObjectDao<Resident> {

    @Override
    public boolean add(Resident rls) {
        try {
            File f = new File("src/textFiles/activeUser.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(rls.getTextFile());
            try ( BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                String[] splt = null;

                while ((line = br.readLine()) != null) {
                    splt = line.split(",");
                    rls.setUserId(splt[0]);
                    rls.setPropID(splt[6]);

                    if (splt[1].equals(rls.getUsername()) && splt[5].equals(rls.getPassword())) {
                        
                        pw.println(rls.getUserId() + "," + rls.getUsername() + "," + rls.getPropID());
                        pw.flush();
                        pw.close();
                        return true;
                    }

                }

            }
        } catch (IOException e) {
            System.out.println("FileNotFound");
        }
        return false;
    }
}
