/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.Item;
import adminexecutive.adminexecunitmanageedit;
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

/**
 *
 * @author Admin
 */
public class ItemSystem {
    
            public ItemSystem() {
    }

    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/unitManage.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Item item = new Item(itemInfo[0], Integer.parseInt(itemInfo[1]), itemInfo[2], Integer.parseInt(itemInfo[3]), itemInfo[4]);

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
    
        public Item getItemByIndex(int index) {
        List<Item> listOfItem = getAll();

        if (listOfItem.size() >= index) {
            return listOfItem.get(index - 1);
        }

        return null;
    }
            
    public void create(Item item) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/unitManage.txt", true))) {
            pw.println(item.getPOwnerName() + "," + item.getPID() + "," + item.getPType() + "," + item.getPPrice() + "," + item.getPRentBuy());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized boolean update(String srcOwnerName, Item updatedItem) {
        List<Item> itemList = new ArrayList<>();

        // Read all the items
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/unitManage.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Item item = new Item(itemInfo[0], Integer.parseInt(itemInfo[1]), itemInfo[2], Integer.parseInt(itemInfo[3]), itemInfo[4]);
                itemList.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminexecunitmanageedit.class.getName()).log(Level.SEVERE, null, ex);
        }

        int itemIndexToUpdate = -1;

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            
            if (item.getPOwnerName().equalsIgnoreCase(srcOwnerName)) {
                itemIndexToUpdate = i;
            }            
        }
        
           
        if (itemIndexToUpdate == -1) {
            return false;
        }

        itemList.set(itemIndexToUpdate, updatedItem);

        try {
            Files.delete(Paths.get("src/textFiles/unitManage.txt"));
        } catch (IOException ex) {
            Logger.getLogger(adminexecunitmanageedit.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/unitManage.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getPOwnerName() + "," + item.getPID() + "," + item.getPType() + "," + item.getPPrice() + "," + item.getPRentBuy());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminexecunitmanageedit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    
    
}
