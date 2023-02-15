/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.system;

import Propmanagement.function.AccExecPayment;
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


    public void create(AccExecPayment item) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/textFiles/accPayment.txt", true))) {
            pw.println(item.getAccUnitNo() + "," + item.getAccAmount() + "," + item.getAccStatus());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccExecPaymentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
}
