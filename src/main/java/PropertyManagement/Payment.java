/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import resident.residentHome;
import resident.residentPayment;

/**
 *
 * @author User
 */
public class Payment {
    public void MakePayment(JTextField finalamount, JTextField totalamount, JTextField disInvoiceID, JTextField disUserID, JTextField disUnitNo, JTextField disPaymentType, JTextField disDueDate, residentPayment rp){
        double money = 0;
        money = Double.parseDouble(finalamount.getText());

        if (money < Double.parseDouble(totalamount.getText())) {
            JOptionPane.showMessageDialog(null, "Sorry, You Don't Have Enough Money To Pay !!!");
        } else if (money == 0) {
            JOptionPane.showMessageDialog(null, "You Have Already Paid !!!");
        } else if (money > Double.parseDouble(totalamount.getText())) {
            JOptionPane.showMessageDialog(null, "Please Pay The Correct Amount !!!");
        } else {
            money = money - Double.parseDouble(totalamount.getText());

            String filepath = "src/textFiles/invoice.txt";
            String invoiceid = disInvoiceID.getText();
            String userid = disUserID.getText();
            String unitno = disUnitNo.getText();
            String paymenttype = disPaymentType.getText();
            String amount = totalamount.getText();
            String duedate = disDueDate.getText();

            JOptionPane.showMessageDialog(null, "Thank you and have a nice day");
                  
            try {     
                
                BufferedReader br = new BufferedReader(new FileReader("src/textFiles/residentPayment.txt"));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int paymentid = 0;
                for (i = 1; i < Lines.length; i++) {
                    String line = Lines[i].toString().trim();
                    String[] row = line.split(",");
                    paymentid = Integer.parseInt(row[0]);
                }
                int paymentID = paymentid + 1;
                FileWriter writer = new FileWriter("src/textFiles/residentPayment.txt", true);
                writer.write(paymentID + "," + userid + "," + unitno + "," + paymenttype + "," + amount + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Your receipt will be generated soon!");
                new residentHome().setVisible(true);
                rp.setVisible(false);                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error generating receipt!");
            }            

            String tempFile = "src/textFiles/invoicetemp.txt";
            File oldFile = new File(filepath);
            File newFile = new File(tempFile);
            String field = "";
            String InvoiceID = "";
            String UserID = "";
            String UnitNo = "";
            String PaymentType = "";
            String Amount = "";
            String DueDate = "";

            try {
                FileWriter rd = new FileWriter(tempFile, false);
                BufferedWriter bw = new BufferedWriter(rd);
                PrintWriter pw = new PrintWriter(bw);
                Scanner x = new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");

                while (x.hasNext()) {
                    InvoiceID = x.next();
                    UserID = x.next();
                    UnitNo = x.next();
                    PaymentType = x.next();
                    Amount = x.next();
                    DueDate = x.next();

                    if (invoiceid.equals(InvoiceID)) {
                        pw.println(invoiceid + "," + UserID + "," + UnitNo + "," + PaymentType + "," + money + "," + DueDate);
                    } else {
                        pw.println(InvoiceID + "," + UserID + "," + UnitNo + "," + PaymentType + "," + Amount + "," + DueDate);
                    }
                }
                x.close();
                pw.flush();
                pw.close();
                Scanner y = new Scanner(new File(tempFile));
                FileWriter fw = new FileWriter(filepath, false);
                BufferedWriter bb = new BufferedWriter(fw);
                PrintWriter pp = new PrintWriter(bb);

                while (y.hasNext()) {
                    pp.println(y.next());
                }
                y.close();
                pp.flush();
                pp.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error...");
            }
        }
    }
}
