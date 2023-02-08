package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import resident.residentUpdateComplaint;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class FileService {

    public static ArrayList<String[]> readFile(String filename) {
        ArrayList<String[]> array = new ArrayList<>();
        try {
            FileReader fr1 = new FileReader(filename);
            BufferedReader br1 = new BufferedReader(fr1);
            
            String line = null;
            String[] splt = null;
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                splt = line.split(",");
                array.add(splt);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileNotFound");
        }
        return array;
    
    }
}
