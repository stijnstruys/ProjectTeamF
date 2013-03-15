package be.kdg.teamf.dao;

import be.kdg.teamf.model.BroadcastMessage;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 12/03/13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class BroadcastMessageDAOImpl implements BroadcastMessageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBroadcastMessage(BroadcastMessage broadcastMessage) {
        sessionFactory.getCurrentSession().save(broadcastMessage);
    }

    @Override
    public List<BroadcastMessage> getBroadcastMessages(int tripID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from BroadcastMessage where trip = :tripId");
       q.setInteger("tripId", tripID);
        return  q.list();
    }

    @Override
    public BroadcastMessage findBroadcastMessage(int broadcastMessageID) {
        Query q = sessionFactory.getCurrentSession().createQuery("from BroadcastMessage where broadcastMessageID = :broadcastMessageID");
                q.setInteger("broadcastMessageID", broadcastMessageID);
                if(q.list().size()> 0){
                return (BroadcastMessage) q.list().get(0);
                }else{
                    return null;
                }
    }
}
