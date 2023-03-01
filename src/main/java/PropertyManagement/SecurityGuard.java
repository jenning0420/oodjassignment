/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import dao.UserLoginDao;

/**
 *
 * @author User
 */
public class SecurityGuard {
    public boolean login(UserLoginDao uld, User uls) {
        return uld.add(uls);
    }

}
