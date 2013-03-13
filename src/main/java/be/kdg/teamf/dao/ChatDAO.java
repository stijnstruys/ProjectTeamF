package be.kdg.teamf.dao;

import be.kdg.teamf.model.Chat;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 7/03/13
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public interface ChatDAO {

    public void addChat(Chat c);
    ArrayList<Chat> getChats(int tripID);
    ArrayList<Chat> getChats(int tripID, int lastid);
}
