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
import sng.RecordVisitorEntrySng;

/**
 *
 * @author User
 */
public class RecordVisitorEntryDaoImpl implements RecordVisitorEntryDao{
        public boolean recordVisitorEntry(RecordVisitorEntrySng rves) {
        try {
            if (!"".equals(rves.getVisitorName()) && !"".equals(rves.getUnitNo()) && !"".equals(rves.getDateIn()) && !"".equals(rves.getTimeIn())){
                File f = new File("src/textFiles/visitorEntry.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int entryid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    entryid = Integer.parseInt(row[0]);

                }
                int entryID = entryid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(entryID + "," + rves.getVisitorName() + "," + rves.getUnitNo() + "," + rves.getDateIn() + "," + rves.getTimeIn() + ",");
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
