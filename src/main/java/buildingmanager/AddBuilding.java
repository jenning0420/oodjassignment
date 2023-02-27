/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildingmanager;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AddBuilding extends addAccount {

    public AddBuilding() {
        super("Add Building Executive User");
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
        aus.setTextFile("src/textFiles/buildingLogin.txt");

        if (aud.add(aus) == true) {
            JOptionPane.showMessageDialog(this, "Building Executive account "
                    + "added SUCCESSFULLY.");

            bum.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill up "
                    + "ALL the information.");
        }
    }

}
