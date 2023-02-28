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
import sng.Patrol;

/**
 *
 * @author User
 */
public class SetupPatrolDao implements ObjectDao<Patrol> {

    @Override
    public boolean add(Patrol sps) {
        try {
            if (!"".equals(sps.getUserID()) && !"".equals(sps.getPatrolVenue()) && !"".equals(sps.getPatrolDetails()) && !"".equals(sps.getPatrolDate()) && !"".equals(sps.getPatrolTime()) && !"".equals(sps.getPatrolStatus())) {
                File f = new File("src/textFiles/securityPatrol.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int patrolid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    patrolid = Integer.parseInt(row[0]);

                }
                int patrolID = patrolid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(patrolID + "," + sps.getUserID() + "," + sps.getPatrolVenue() + "," + sps.getPatrolDetails() + "," + sps.getPatrolDate() + "," + sps.getPatrolTime() + "," + sps.getPatrolStatus() + ",");
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
