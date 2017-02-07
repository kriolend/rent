package org.ua.service;

import org.ua.model.realEstate.Apartament;

import java.util.List;

/**
 * Created by u0100 on 04.07.2016.
 */
public interface ApartamentService {

    Apartament findById(int id);

    Apartament findByDataId(String dataId);

    void save(Apartament apartament);

    void update(Apartament apartament);

    void deleteByDataId (String dataId);

    List<Apartament> findAll();

    boolean isDataIdUnique(Integer id, String dataId);
}
