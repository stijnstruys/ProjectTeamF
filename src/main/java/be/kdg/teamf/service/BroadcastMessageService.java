package be.kdg.teamf.service;

import be.kdg.teamf.model.BroadcastMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public interface BroadcastMessageService {
    public void addBroadcastMessage(BroadcastMessage broadcastMessage);
        public void updateBroadcastMessage(BroadcastMessage broadcastMessage);
        public void removeBroadcastMessage(BroadcastMessage broadcastMessage);
        public List<BroadcastMessage> getBroadcastMessages(int tripID);
        public BroadcastMessage findBroadcastMessage(int broadcastMessageID);
}
