package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User showUser(long id);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long id);


}
