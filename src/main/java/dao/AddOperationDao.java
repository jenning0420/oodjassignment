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
import sng.Operation;

/**
 *
 * @author User
 */
public class AddOperationDao implements ObjectDao<Operation>{
    @Override
    public boolean add(Operation aos) {
        try {
            if (!"".equals(aos.getOperationType()) && !"".equals(aos.getOperationTitle()) && !"".equals(aos.getOperationDetails()) && !"".equals(aos.getFundAllocated()) && !"".equals(aos.getUrgencyLevel())) {
                File f = new File("src/textFiles/fundAllocation.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int id = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    id = Integer.parseInt(row[0]);

                }
                int operationID = id + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(operationID + "," + aos.getOperationType() + "," + aos.getOperationTitle() + "," + aos.getOperationDetails() + "," + aos.getFundAllocated() + "," + aos.getUrgencyLevel() + ",");
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
