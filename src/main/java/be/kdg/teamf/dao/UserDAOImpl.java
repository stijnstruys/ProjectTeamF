package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created with intellij idea.
 * user: bart.leemans
 * date: 6/02/13
 * time: 9:53
 * to change this template use file | settings | file templates.
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User u) {
        sessionFactory.getCurrentSession().save(u);
    }

    @Override
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

    @Override
    public User findUser(String userName) {
        Query q = sessionFactory.getCurrentSession().createQuery("from User where username = :username");
        q.setString("username",userName);
        try {
             return (User) q.list().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
