/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.Unit;
import dao.ObjectDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class ManageUnit implements ManagingUnit<Unit>{
    
    @Override
    public boolean add(Unit uit) {
        try {
            if (!"".equals(uit.getPID()) && !"".equals(uit.getPUnitNo()) && !"".equals(uit.getPType()) && !"".equals(uit.getPPrice())) {
                File f = new File("src/textFiles/unitManage.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int invoiceid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    invoiceid = Integer.parseInt(row[0]);

                }
                int invoiceID = invoiceid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(uit.getPID() + "," + uit.getPUnitNo() + "," + uit.getPType() + "," + uit.getPPrice());
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
