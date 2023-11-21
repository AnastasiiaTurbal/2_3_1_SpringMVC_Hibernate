package crud.dao;

import crud.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers(){
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User showUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) { entityManager.merge(user); }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("DELETE User where id=:id").setParameter("id", id).executeUpdate();
    }


}
