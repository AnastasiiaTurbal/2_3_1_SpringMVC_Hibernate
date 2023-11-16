package crud.service;

import crud.dao.UserDao;
import crud.dao.UserDaoImpl;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getUsers(){
        return userDao.getUsers();
    }
    public User showUser(Long id){ return userDao.showUser(id); }
    public void addUser(User user) {
        userDao.addUser(user);
    }
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
