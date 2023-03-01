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
public class addResident extends addUserRoleAcc {

    public addResident() {
        super("Add New Resident Account");
    }

    @Override
    protected void addRole() {
        Usernamefinal = Username.getText();
        Namefinal = Name.getText();
        ContactNumberfinal = ContactNumber.getText();
        Genderfinal = (String) Gender.getSelectedItem();
        Passwordfinal = Password.getText();
        urs.setUsername(Usernamefinal);
        urs.setName(Namefinal);
        urs.setContactNumber(ContactNumberfinal);
        urs.setGender(Genderfinal);
        urs.setPassword(Passwordfinal);
        urs.setTextFile("src/textFiles/residentLogin.txt");
        AdminExecutive ae = new AdminExecutive();

        if (ae.AddResident(urd, urs) == true) {
            JOptionPane.showMessageDialog(this, "Resident registered SUCCESSFULLY.");

            aum.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill up ALL the information.");
        }
    }
    
}
