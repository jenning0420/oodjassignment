/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import dao.ResidentLoginDao;

/**
 *
 * @author User
 */
public class Vendor {
    public boolean login(ResidentLoginDao rld, Resident rls){
        return rld.add(rls);
    }
}
