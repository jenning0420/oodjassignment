/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Propmanagement.function.TeamStruc;
import Propmanagement.system.TeamStrucSystem;
import buildingmanager.buildingTeamStrucAdd;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */

public class TeamStructure extends TeamStrucSystem {
    public TeamStrucSystem teamstrucsystem;
    
//    public void addTeamStruc(JComboBox Role, JTextField Amount){
//        buidingTeamStrucAdd.teamstrucsystem = new TeamStrucSystem();  
//        System.out.println(this.teamstrucsystem);
//        String TSRole = (String)Role.getSelectedItem();
//        String TSAmount = Amount.getText();
//
//        if(TSRole.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter a valid Role");
//            return;
//        }
//
//        if(TSAmount.isEmpty() || !TSAmount.chars().allMatch( Character::isDigit) 
//                || Integer.parseInt(TSAmount) <=0) {                
//            JOptionPane.showMessageDialog(null, "Please enter a valid Amount");
//            return;
//        }
//
//        TeamStruc item = new TeamStruc(TSRole,
//            Integer.parseInt(Amount.getText()));
//        
//        teamstrucsystem.create(item);
//
//        Role.setSelectedItem("");
//        Amount.setText("");
//        JOptionPane.showMessageDialog(null, "Item has been added");
//
//        
//    }

}
