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
import sng.FacilityManagementSng;

/**
 *
 * @author User
 */
public class FacilityManagementDaoImpl implements FacilityManagementDao{
        public boolean facilityManagement(FacilityManagementSng fms) {
        try {
            if (!"".equals(fms.getFacility()) && !"".equals(fms.getEquipment()) && !"".equals(fms.getQuantity()) && !"".equals(fms.getCondition())){
                File f = new File("src/textFiles/facility.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                //int facilityid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    //facilityid = Integer.parseInt(row[0]);

                }
                //int facilityID = facilityid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(fms.getFacility() + "," + fms.getEquipment() + "," + fms.getQuantity() + "," + fms.getCondition() + ",");
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
