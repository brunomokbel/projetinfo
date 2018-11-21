package com.esme.spring.faircorp.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class RoomDaoImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;



    @Override
    public List<Room> findOnRoom() {
        String jpql = "select lt from Light lt where lt.status = :value";
        return em.createQuery(jpql, Room.class)
                .setParameter("value", Status.ON)
                .getResultList();
    }


}
