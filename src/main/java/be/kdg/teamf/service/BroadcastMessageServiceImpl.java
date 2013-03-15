package be.kdg.teamf.service;

import be.kdg.teamf.dao.BroadcastMessageDAO;
import be.kdg.teamf.model.BroadcastMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BroadcastMessageServiceImpl implements BroadcastMessageService {

    @Autowired
    private BroadcastMessageDAO broadcastMessageDAO;

    @Override
    @Transactional
    public void addBroadcastMessage(BroadcastMessage broadcastMessage) {
        broadcastMessageDAO.addBroadcastMessage(broadcastMessage);
    }



    @Override
    @Transactional
    public List<BroadcastMessage> getBroadcastMessages(int tripID) {
        return broadcastMessageDAO.getBroadcastMessages(tripID);
    }

    @Override
    @Transactional
    public BroadcastMessage findBroadcastMessage(int broadcastMessageID) {
        return broadcastMessageDAO.findBroadcastMessage(broadcastMessageID);
    }
}
