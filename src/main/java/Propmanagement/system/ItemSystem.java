/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.Item;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ItemSystem {
    
            public ItemSystem() {
    }
            
    public void create(Item item) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/unitManage.txt", true))) {
            pw.println(item.getPID() + "," + item.getPType() + "," + item.getPOwnerID() + "," + item.getPPrice() + "," + item.getPRentBuy());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
