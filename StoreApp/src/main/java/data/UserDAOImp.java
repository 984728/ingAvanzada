/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.User;

@Stateless
public class UserDAOImp implements UserDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public User validateUser(String user, String pwd) {
        Query query;
        query = em.createQuery("SELECT u FROM User u WHERE u.user = :user AND u.pwd = :pwd");
        query.setParameter("user", user);
        query.setParameter("pwd", pwd);
        return (User)query.getSingleResult();
    }
    
}
