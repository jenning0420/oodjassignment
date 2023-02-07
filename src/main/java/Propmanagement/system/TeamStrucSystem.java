/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.TeamStruc;
import buildingmanager.buildingTeamStrucEdit;
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
public class TeamStrucSystem {
    
            public TeamStrucSystem() {
    }    

    public List<TeamStruc> getAll() {
        List<TeamStruc> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/teamStruc.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                TeamStruc item = new TeamStruc(itemInfo[0], Integer.parseInt(itemInfo[1]));

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageUnitSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
    
    public TeamStruc getItemByIndex(int index) {
        List<TeamStruc> listOfItem = getAll();

        if (listOfItem.size() >= index) {
            return listOfItem.get(index - 1);
        }

        return null;
    }

    public void create(TeamStruc item) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/teamStruc.txt", true))) {
            pw.println(item.getTSRole() + "," + item.getTSAmount());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageUnitSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized boolean update(String srcTSRole, TeamStruc updatedItem) {
        List<TeamStruc> itemList = new ArrayList<>();

        // Read all the items
        try (Scanner scanner = new Scanner(new FileInputStream("src/textFiles/teamStruc.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                TeamStruc item = new TeamStruc(itemInfo[0],
                        Integer.parseInt(itemInfo[1]));
                itemList.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(buildingTeamStrucEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        int itemIndexToUpdate = -1;

        for (int i = 0; i < itemList.size(); i++) {
            TeamStruc item = itemList.get(i);

            if (item.getTSRole().equalsIgnoreCase(srcTSRole)) {
                itemIndexToUpdate = i;
            }
        }

        if (itemIndexToUpdate == -1) {
            return false;
        }

        itemList.set(itemIndexToUpdate, updatedItem);

        try {
            Files.delete(Paths.get("src/textFiles/teamStruc.txt"));
        } catch (IOException ex) {
            Logger.getLogger(buildingTeamStrucEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/teamStruc.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getTSRole() + "," + item.getTSAmount());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(buildingTeamStrucEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }    
}
