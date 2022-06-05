
package data;

import models.User;


public interface UserDAO {
    public User validateUser(String user, String pwd);
    
}
