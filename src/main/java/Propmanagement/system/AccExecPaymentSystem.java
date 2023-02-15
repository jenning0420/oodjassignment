/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.AccExecPayment;
import accountexecutive.accPaymentEdit;
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
public class AccExecPaymentSystem {
    
            public AccExecPaymentSystem() {
    }    

    public List<AccExecPayment> getAll() {
        List<AccExecPayment> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/accPayment.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                AccExecPayment item = new AccExecPayment(itemInfo[0], Double.parseDouble(itemInfo[1]), itemInfo[2]);

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageUnitSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
    
    public AccExecPayment getItemByIndex(int index) {
        List<AccExecPayment> listOfItem = getAll();

        if (listOfItem.size() >= index) {
            return listOfItem.get(index - 1);
        }

        return null;
    }

    public void create(AccExecPayment item) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/accPayment.txt", true))) {
            pw.println(item.getAccUnitNo() + "," + item.getAccAmount() + "," + item.getAccStatus());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccExecPaymentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized boolean update(String srcAccUnitNo, AccExecPayment updatedItem) {
        List<AccExecPayment> itemList = new ArrayList<>();

        // Read all the items
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/accPayment.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                AccExecPayment item = new AccExecPayment(itemInfo[0], Double.parseDouble(itemInfo[1]), itemInfo[2]);
                itemList.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accPaymentEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        int itemIndexToUpdate = -1;

        for (int i = 0; i < itemList.size(); i++) {
            AccExecPayment item = itemList.get(i);

            if (item.getAccUnitNo().equalsIgnoreCase(srcAccUnitNo)) {
                itemIndexToUpdate = i;
            }
        }

        if (itemIndexToUpdate == -1) {
            return false;
        }

        itemList.set(itemIndexToUpdate, updatedItem);

        try {
            Files.delete(Paths.get("src/textFiles/accPayment.txt"));
        } catch (IOException ex) {
            Logger.getLogger(accPaymentEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/accPayment.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getAccUnitNo() + "," + item.getAccAmount() + "," + item.getAccStatus());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accPaymentEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }    
}
    
