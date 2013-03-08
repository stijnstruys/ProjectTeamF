package be.kdg.teamf.service;

import be.kdg.teamf.dao.ChatDAO;
import be.kdg.teamf.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 7/03/13
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatDAO ChatDao;


    @Override
    public void addChat(Chat c) {
        ChatDao.addChat(c);
    }

    @Override
    public ArrayList<Chat> getChats(int tripID) {
        return ChatDao.getChats(tripID);
    }
}
