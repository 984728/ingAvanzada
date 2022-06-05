/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import models.Customer;
import models.User;

public interface UserService {
    public User validateUser(String user, String pwd);
     public List<User> findAllUser();
     public List<User> findAllUser( String filtro);

    public void insertUser(User c);

    public User findUserbyId(User c);

    public void deleteUser(User c);

    public List<User> findId(int parseInt);
    
      public void updateUser(User c);
}
