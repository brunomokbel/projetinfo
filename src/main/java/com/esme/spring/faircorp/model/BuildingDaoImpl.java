package com.esme.spring.faircorp.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BuildingDaoImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Building> findOnBuilding() {
        String jpql = "select lt from Light lt where lt.status = :value";
        return em.createQuery(jpql, Building.class)
                .setParameter("value", Status.ON)
                .getResultList();
    }


}
