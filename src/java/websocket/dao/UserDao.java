package websocket.dao;

import java.util.List;
 
import websocket.model.User;
 
public interface UserDao {
    User findUserById(String username);
    void saveUser(User user);
    void deleteUser(String username);
    List<User> findAllUsers();
 }
