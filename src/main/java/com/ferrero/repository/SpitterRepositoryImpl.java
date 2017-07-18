package com.ferrero.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by drugo on 29/05/2017.
 */
@Repository
@Transactional
public class SpitterRepositoryImpl implements SpitterRepositoryOther{

    @PersistenceContext
    private EntityManager em;

    public int eliteSweep() {
        String update =
                "UPDATE Spitter spitter " +
                        "SET spitter.status = 'Elite' " +
                        "WHERE spitter.status = 'Newbie' " +
                        "AND spitter.id IN (" +
                        "SELECT s FROM Spitter s WHERE (" +
                        "SELECT COUNT(spittles) FROM s.spittles spittles) > 10000" +
                        ")";
        return em.createQuery(update).executeUpdate();
    }

}
