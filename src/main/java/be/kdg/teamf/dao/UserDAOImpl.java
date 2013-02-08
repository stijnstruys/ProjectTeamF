package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created with intellij idea.
 * user: bart.leemans
 * date: 6/02/13
 * time: 9:53
 * to change this template use file | settings | file templates.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User u) {
        sessionFactory.getCurrentSession().save(u);
    }

    public List<User> listUsers() {
       return sessionFactory.getCurrentSession().createQuery("from User").list();

    }

    @Override
    public void deleteUser(User user) {

        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findUser(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from User where userID = :id");
        q.setInteger("id",id);
        return (User) q.list().get(0);
    }
}
