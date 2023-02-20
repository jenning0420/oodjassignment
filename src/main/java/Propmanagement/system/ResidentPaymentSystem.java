/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ResidentPaymentSystem {
    
            public ResidentPaymentSystem() {
    }
            
    public List<Unit> getAll() {
        List<Unit> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/unitManage.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Unit item = new Unit(itemInfo[0], itemInfo[1], itemInfo[2], Double.parseDouble(itemInfo[3]));

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageUnitSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }            
            
}
