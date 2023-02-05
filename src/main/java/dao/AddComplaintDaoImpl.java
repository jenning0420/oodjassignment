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
import sng.AddComplaintSng;

/**
 *
 * @author User
 */
public class AddComplaintDaoImpl implements AddComplaintDao{
    public boolean addComplaint(AddComplaintSng acs) {
        try {
            if (!"".equals(acs.getCompTitle()) && !"".equals(acs.getCompDate()) && !"".equals(acs.getCompDetails()) && !"".equals(acs.getSuggestion())) {
                File f = new File("src/textFiles/complaint.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int compid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    compid = Integer.parseInt(row[0]);

                }
                int compID = compid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(compID + "," + acs.getUserID() + "," + acs.getCompTitle() + "," + acs.getCompDate() + "," + acs.getCompDetails() + "," + acs.getSuggestion() + "," + acs.getComplainant() + "," + acs.getStatus() + ",");
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
