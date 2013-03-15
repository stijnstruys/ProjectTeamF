package be.kdg.teamf.service;

import be.kdg.teamf.dao.KostDAO;
import be.kdg.teamf.model.Kost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
@Service
public class KostServiceImpl implements KostService {
    @Autowired
    KostDAO kostDAO;

    @Override
    @Transactional
    public void addKost(Kost kost) {
        kostDAO.addKost(kost);
    }

    @Override
    @Transactional
    public void updateKost(Kost kost) {
        kostDAO.updateKost(kost);
    }

    @Override
    @Transactional
    public void deleteKost(Kost kost) {
        kostDAO.deleteKost(kost);
    }

    @Override
    @Transactional
    public Kost findKost(int kostId) {
        return kostDAO.findKost(kostId);
    }
}
