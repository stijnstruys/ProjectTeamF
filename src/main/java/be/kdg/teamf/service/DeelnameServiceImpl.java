package be.kdg.teamf.service;

import be.kdg.teamf.dao.DeelnameDAO;
import be.kdg.teamf.model.Deelname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 14/02/13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DeelnameServiceImpl implements DeelnameService {

    @Autowired
    private DeelnameDAO deelnameDAO;

    @Transactional
    public void addDeelname(Deelname deelname) {
        deelnameDAO.addDeelname(deelname);
    }

    @Override
    @Transactional
    public void updateDeelname(Deelname deelname) {
        deelnameDAO.updateDeelname(deelname);
    }

    @Transactional
    public void deleteDeelname(Deelname deelname) {
        deelnameDAO.deleteDeelname(deelname);
    }

    @Override
    public Deelname findDeelname(int deelnameID) {
        return deelnameDAO.findDeelname(deelnameID);
    }
}
