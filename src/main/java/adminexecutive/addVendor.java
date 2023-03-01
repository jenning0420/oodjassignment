/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminexecutive;

import PropertyManagement.AdminExecutive;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class addVendor extends addUserRoleAcc{
    public addVendor() {
        super("Add New Vendor Account");
    }
    
    @Override
    protected void addRole(){
        Usernamefinal = Username.getText();
        Namefinal = Name.getText();
        ContactNumberfinal = ContactNumber.getText();
        Genderfinal = (String) Gender.getSelectedItem();
        Passwordfinal = Password.getText();
        vrs.setUsername(Usernamefinal);
        vrs.setName(Namefinal);
        vrs.setContactNumber(ContactNumberfinal);
        vrs.setGender(Genderfinal);
        vrs.setPassword(Passwordfinal);
        vrs.setTextFile("src/textFiles/vendorLogin.txt");
        AdminExecutive ae = new AdminExecutive();

        if (ae.AddVendor(vrd, vrs) == true) {
            JOptionPane.showMessageDialog(this, "Vendor registered SUCCESSFULLY.");

            aum.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill up ALL the information.");
        }
    }
    
    
}
