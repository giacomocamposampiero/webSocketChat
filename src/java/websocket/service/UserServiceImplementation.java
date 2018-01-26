package websocket.service;
 
import java.util.List;
import websocket.dao.UserDao;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import websocket.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImplementation implements UserService {
 
    @Autowired
    private UserDao dao;
     
    @Override
    public User findUserById(String username) {
        return dao.findUserById(username);
    }
 
    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }
 
    @Override
    public void updateUser(User user) {
        User entity = dao.findUserById(user.getUsername());
        if(entity!=null){
            entity.setPasswd(user.getPasswd());
            entity.setMail(user.getMail());
        }
    }
 
    @Override
    public void deleteUser(String username) {
        dao.deleteUser(username);
    }
     
    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
    
}