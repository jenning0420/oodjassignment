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
import PropertyManagement.Incident;

/**
 *
 * @author User
 */
public class SecurityRecordIncidentDao implements ObjectDao<Incident> {

    @Override
    public boolean add(Incident sris) {
        try {
            if (!"".equals(sris.getDescription()) && !"".equals(sris.getDateIn()) && !"".equals(sris.getTimeIn())) {
                File f = new File("src/textFiles/incident.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int incidentid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    incidentid = Integer.parseInt(row[0]);

                }
                int incidentID = incidentid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(incidentID + "," + sris.getUserID() + "," + sris.getDescription() + "," + sris.getDateIn() + "," + sris.getTimeIn() + ",");
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
