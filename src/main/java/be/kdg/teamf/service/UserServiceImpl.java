package be.kdg.teamf.service;

import be.kdg.teamf.dao.UserDAO;
import be.kdg.teamf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 6/02/13
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addUser(User u) {
        userDAO.addUser(u);
    }

    @Transactional
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public User findUser(int userID) {
        return userDAO.findUser(userID);
    }

    @Override
    public User findUser(String userName) {
        return userDAO.findUser(userName);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
            String userName = userDetails.getUsername();
            return findUser(userName);
        }
        else {
            return null;
        }



    }
}
