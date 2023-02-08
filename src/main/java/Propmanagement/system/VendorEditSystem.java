/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.Vendor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendor.vendorViewUpdateProfile;

/**
 *
 * @author Admin
 */
public class VendorEditSystem {
    
            public VendorEditSystem() {
    }    
    
        public synchronized boolean update(String srcUsername, Vendor updatedItem) {
        List<Vendor> itemList = new ArrayList<>();

        // Read all the items
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/vendorLogin.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Vendor item = new Vendor(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                itemList.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(vendorViewUpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        int itemIndexToUpdate = -1;

        for (int i = 0; i < itemList.size(); i++) {
            Vendor item = itemList.get(i);
            
            if (item.getUsername().equalsIgnoreCase(srcUsername)) {
                itemIndexToUpdate = i;
            }
                    
        }
        
           
        if (itemIndexToUpdate == -1) {
            return false;
        }

        itemList.set(itemIndexToUpdate, updatedItem);

        try {
            Files.delete(Paths.get("src/textFiles/vendorLogin.txt"));
        } catch (IOException ex) {
            Logger.getLogger(vendorViewUpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/vendorLogin.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getUsername() + "," + item.getName() + "," + item.getContact() + "," + item.getGender()+ "," + item.getPassword());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(vendorViewUpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
}
