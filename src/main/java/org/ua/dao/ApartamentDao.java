package org.ua.dao;

import org.ua.model.realEstate.Apartament;

import java.util.List;

/**
 * Created by u0100 on 04.07.2016.
 */
public interface ApartamentDao {

    Apartament findById(Integer id);

    Apartament findByDataId(String dataId);

    void save(Apartament apartament);

    void deliteByDataId(String dataId);

    List<Apartament> findAllApartaments();

}
