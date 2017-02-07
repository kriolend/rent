package org.ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ua.dao.ApartamentDao;
import org.ua.model.realEstate.Apartament;

import java.util.List;

/**
 * Created by u0100 on 04.07.2016.
 */
@Service("apartamentService")
@Transactional
public class ApartamentServiceImpl implements ApartamentService {

    @Autowired
    ApartamentDao apartmentApartamentDao;

    @Override
    public Apartament findById(int id) {
        return apartmentApartamentDao.findById(id);
    }

    @Override
    public Apartament findByDataId(String dataId) {
        Apartament apartament = apartmentApartamentDao.findByDataId(dataId);
        return apartament;
    }


    @Override
    public void save(Apartament apartament) {
        apartmentApartamentDao.save(apartament);
    }

    @Override
    public void update(Apartament apartament) {
        Apartament entity = apartmentApartamentDao.findById(apartament.getId());
        if(entity!=null){
            entity.setDataId(apartament.getDataId());
            entity.setLink(apartament.getLink());
            entity.setTitle(apartament.getTitle());
            entity.setRaion(apartament.getRaion());
            entity.setNameBoss(apartament.getNameBoss());
            entity.setAddTime(apartament.getAddTime());
            entity.setPrice(apartament.getPrice());
            entity.setKollKomnat(apartament.getKollKomnat());
            entity.setTelephon(apartament.getTelephon());
        }
    }

    @Override
    public void deleteByDataId(String dataId) {
        apartmentApartamentDao.deliteByDataId(dataId);
    }

    @Override
    public List<Apartament> findAll() {
        return apartmentApartamentDao.findAllApartaments();
    }

    @Override
    public boolean isDataIdUnique(Integer id, String dataId) {
        Apartament apartament = findByDataId(dataId);
        return (apartament == null || ((id != null) && (apartament.getId() == id)));
    }

}
