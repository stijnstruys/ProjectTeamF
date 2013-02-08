package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 8/02/13
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoMock implements UserDAO{

    public List<User> users;

    public UserDaoMock() {
        users = new ArrayList<User>();
    }

    public void addUser(User u) {
        boolean duplicate = false;
        for (User user1 : users) {
           if(user1.getUsername().equals(u.getUsername())) {
               duplicate = true;
               return;
           }
        }

        if(!duplicate) {
            this.users.add(u);
        }
    }

    public List<User> listUsers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public User getUser(String tester) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
