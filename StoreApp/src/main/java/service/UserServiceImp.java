/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import data.UserDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.User;

@Stateless
public class UserServiceImp implements UserService{
    
    @Inject
    UserDAO userDAO;

    @Override
    public User validateUser(String user, String pwd) {
        return userDAO.validateUser(user, pwd);
        
    }
    
}
