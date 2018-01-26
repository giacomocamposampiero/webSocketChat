package websocket.service;
 
import java.util.List;
 
import websocket.model.User;
 
public interface UserService {
    User findUserById(String username);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(String username);
    List<User> findAllUsers(); 
}