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
import sng.ApplyPassSng;

/**
 *
 * @author User
 */
public class ApplyPassDao implements ObjectDao<ApplyPassSng> {

    @Override
    public boolean add(ApplyPassSng aps) {
        try {
            if (!"".equals(aps.getVisitorName()) && !"".equals(aps.getCarPlate()) && !"".equals(aps.getUnitNo()) && !"".equals(aps.getDateIn()) && !"".equals(aps.getDuration())) {
                File f = new File("src/textFiles/visitorPass.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int passid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    passid = Integer.parseInt(row[0]);

                }
                int passID = passid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(passID + "," + aps.getUserID() + "," + aps.getVisitorName() + "," + aps.getCarPlate() + "," + aps.getUnitNo() + "," + aps.getDateIn() + "," + aps.getDuration() + ",");
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
