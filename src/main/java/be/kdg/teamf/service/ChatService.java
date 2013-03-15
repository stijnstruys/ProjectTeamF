package be.kdg.teamf.service;

import be.kdg.teamf.model.Chat;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 7/03/13
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
public interface ChatService {
    public void addChat(Chat c);
    public ArrayList<Chat> getChats(int tripID);
    public ArrayList<Chat> getChats(int tripID, int lastID);
}
