package websocket.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import websocket.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Repository("categoriaDao")
public class UserDaoImplementation implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findUserById(String username) {
            return (User) getSession().get(User.class, username);
        
    }

    @Override
    public void saveUser(User user) {
        getSession().persist(user);
    }

    @Override
    public void deleteUser(String username) {
        User e = (User) getSession().load(User.class, username);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }
  
}
