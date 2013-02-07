package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;
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

    public void addUser(User u) {
        sessionFactory.getCurrentSession().save(u);
    }

    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
}
