package be.kdg.teamf.service;

import be.kdg.teamf.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 6/02/13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public void addUser(User u);
    public List<User> listUsers();

    void deleteUser(User user);

    User findUser(int userID);
    User findUser(String userName);
    void updateUser(User user);
}
