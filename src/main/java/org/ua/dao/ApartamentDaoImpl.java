package org.ua.dao;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.ua.model.realEstate.Apartament;

import java.util.List;

/**
 * Created by u0100 on 04.07.2016.
 */
@Repository("apartamentDao")
public class ApartamentDaoImpl extends AbstractDao<Integer, Apartament> implements ApartamentDao {

    static final Logger logger =LoggerFactory.getLogger(ApartamentDaoImpl.class);


    @Override
    public Apartament findById(Integer id) {
        Apartament apartament = getByKey(id);
        if (apartament != null) {
            Hibernate.initialize(apartament.getId());
        }
        return apartament;
    }

    @Override
    public Apartament findByDataId(String dataId) {
        logger.info("Data Id : {}", dataId);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("dataId", dataId));
        Apartament apartament = (Apartament) crit.uniqueResult();
        if (apartament != null) {
            Hibernate.initialize(apartament.getDataId());
        }
        return apartament;
    }


    @Override
    public void save(Apartament apartament) {
        persist(apartament);
    }


    @Override
    public void deliteByDataId(String dataId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dataId", dataId));
        Apartament apartament = (Apartament) criteria.uniqueResult();
        delete(apartament);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Apartament> findAllApartaments() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("dataId"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); //To avoid duplecated
        List<Apartament> apartamentList = (List<Apartament>) criteria.list();
        return apartamentList;
    }

}
