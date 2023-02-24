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
import sng.GenerateInvoiceSng;

/**
 *
 * @author User
 */
public class GenerateStatementDao implements ObjectDao<GenerateInvoiceSng> {

    public boolean add(GenerateInvoiceSng gis) {
        try {
            if (!"".equals(gis.getUserID()) && !"".equals(gis.getTotAmtPaid())) {
                File f = new File("src/textFiles/statement.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int statementid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    statementid = Integer.parseInt(row[0]);

                }
                int statementID = statementid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(statementID + "," + gis.getUserID() + "," + gis.getTotAmtPaid() + ",");
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
