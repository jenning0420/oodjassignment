/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sng;

import dao.ApplyPassDao;
import dao.FacilityBookingManagementDao;
import dao.ObjectDao;
import dao.ResidentLoginDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author User
*/

public class Resident extends User implements ObjectDao<FacilityBookingManagement> {

    private String propID;

//    public ResidentLoginSng(String string, String Usernamefinal, String passwordfinal, String srctextFilesresidentLogintxt) {
//        super(string, Usernamefinal, passwordfinal, srctextFilesresidentLogintxt);
//    }

    public String getPropID() {
        return propID;
    }

    public void setPropID(String propID) {
        this.propID = propID;
    }

    @Override
    public boolean add(FacilityBookingManagement fbmd) {

        try {
            if (!"".equals(this.getUserId()) && !"".equals(fbmd.getFacility()) && !"".equals(fbmd.getDateIn()) && !"".equals(fbmd.getDuration()) && !"".equals(fbmd.getTime())) {
                File f = new File("src/textFiles/facilityBooking.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int faciBookingid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    faciBookingid = Integer.parseInt(row[0]);

                }
                int faciBookingID = faciBookingid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(faciBookingID + "," + this.getUserId() + "," + fbmd.getFacility() + "," + fbmd.getDateIn() + "," + fbmd.getDuration() + "," + fbmd.getTime() + ",");
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

  


    public boolean applyPass(ApplyPassDao apd, PassApplication aps) {
        return apd.add(aps);
    }

    public Resident() {

    }

    public Resident(String userID) {
        setUserId(userID);
    }
    
    public boolean login(ResidentLoginDao rld, Resident rls){
        return rld.add(rls);
    }

}
