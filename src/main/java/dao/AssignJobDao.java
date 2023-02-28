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
import sng.JobAssign;

/**
 *
 * @author User
 */
public class AssignJobDao implements ObjectDao<JobAssign>{
        @Override
        public boolean add(JobAssign ajs) {
        try {
            if (!"".equals(ajs.getUserID()) && !"".equals(ajs.getJobTitle()) && !"".equals(ajs.getJobDetails()) && !"".equals(ajs.getJobDate()) && !"".equals(ajs.getJobTime()) && !"".equals(ajs.getJobDuration())) {
                File f = new File("src/textFiles/jobAssigned.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int jobid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    jobid = Integer.parseInt(row[0]);

                }
                int jobID = jobid + 1;
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(jobID + "," + ajs.getUserID() + "," + ajs.getJobTitle() + "," + ajs.getJobDetails() + "," + ajs.getJobDate() + "," + ajs.getJobTime() + "," + ajs.getJobDuration() + "," + ajs.getStatus() + ",");
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
