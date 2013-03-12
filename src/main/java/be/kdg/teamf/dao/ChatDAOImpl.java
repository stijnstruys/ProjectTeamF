package be.kdg.teamf.dao;

import be.kdg.teamf.model.Chat;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 7/03/13
 * Time: 18:45
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class ChatDAOImpl implements ChatDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addChat(Chat c) {
        sessionFactory.getCurrentSession().save(c);
    }

    @Override
    public ArrayList<Chat> getChats(int tripID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Chat where trip.tripId = :tripID");
        q.setInteger("tripID", tripID);

        if(q.list().size() > 0){
            return (ArrayList<Chat>) q.list();
        }
        else{
            return null;
        }
    }
}
