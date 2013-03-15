package be.kdg.teamf.dao;

import be.kdg.teamf.model.BroadcastMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 12/03/13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
public interface BroadcastMessageDAO {

    public void addBroadcastMessage(BroadcastMessage broadcastMessage);
    public List<BroadcastMessage> getBroadcastMessages(int tripID);
    public BroadcastMessage findBroadcastMessage(int broadcastMessageID);
}
