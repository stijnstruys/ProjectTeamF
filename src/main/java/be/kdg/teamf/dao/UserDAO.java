package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 6/02/13
 * Time: 9:51
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    public void addUser(User u);
    void updateUser(User user);
    public List<User> listUsers();
    void deleteUser(User user);
    User findUser(int id);
    User findUser(String userName);


}
