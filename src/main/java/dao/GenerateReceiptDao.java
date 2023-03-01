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
import PropertyManagement.Invoice;

/**
 *
 * @author User
 */
public class GenerateReceiptDao implements ObjectDao<Invoice> {

    public boolean add(Invoice gis) {
        try {
            if (!"".equals(gis.getPaymentID()) && !"".equals(gis.getUserID()) && !"".equals(gis.getPaymentType()) && !"".equals(gis.getAmountPaid()) && !"".equals(gis.getPaidDate())) {
                File f = new File("src/textFiles/receipt.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int receiptid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    receiptid = Integer.parseInt(row[0]);

                }
                int receiptID = receiptid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(receiptID + "," + gis.getPaymentID() + "," + gis.getUserID() + "," + gis.getPaymentType() + "," + gis.getAmountPaid() + "," + gis.getPaidDate() + "," );
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
