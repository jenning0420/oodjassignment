/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildingmanager;

import javax.swing.JOptionPane;
import PropertyManagement.BuildingManager;

/**
 *
 * @author User
 */
public class AddAdmin extends addAccount {

    public AddAdmin() {
        super("Add Admin Executive User");
    }

    @Override
    protected void addUser() {
        Usernamefinal = Username.getText();
        Namefinal = Name.getText();
        ContactNumberfinal = ContactNumber.getText();
        Genderfinal = (String) Gender.getSelectedItem();
        Passwordfinal = Password.getText();
        aus.setUsername(Usernamefinal);
        aus.setName(Namefinal);
        aus.setContactNumber(ContactNumberfinal);
        aus.setGender(Genderfinal);
        aus.setPassword(Passwordfinal);
        aus.setTextFile("src/textFiles/adminLogin.txt");
        BuildingManager bm = new BuildingManager();

        if (bm.addAdmin(aud, aus) == true) {
            JOptionPane.showMessageDialog(this, "Admin Executive "
                    + "account added SUCCESSFULLY.");

            bum.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill up "
                    + "ALL the information.");
        }
    }
}
