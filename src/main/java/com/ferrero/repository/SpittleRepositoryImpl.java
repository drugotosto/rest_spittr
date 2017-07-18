package com.ferrero.repository;

import com.ferrero.model.Spittle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by drugo on 31/05/2017.
 */
@Repository
/*
All public methods of the class become transactional
 */
@Transactional
public class SpittleRepositoryImpl implements SpittleRepositoryOther{

    /*
    At run time, Spring Container creates an EntityManager bound to the currently
    active transaction and injects that instance into this field.
    */
    @PersistenceContext
    private EntityManager em;

    public List<Spittle> trovaSpittles(long max, int count) {
        // Utilizzo del linguaggio di interrogazione JPA QL
        return null;
    }

    public List<Spittle> findRecentSpittles(int count) {
        // Utilizzo del linguaggio di interrogazione JPA QL
        return null;
    }

    public List<Spittle> findFirst5ByOrderByTimeDesc() {
        // Utilizzo del linguaggio di interrogazione JPA QL
        TypedQuery<Spittle> query = em.createQuery("select s from Spittle as  s order by s.time desc", Spittle.class).setFirstResult(0).setMaxResults(5);
        List<Spittle> results = query.getResultList();
        return results;
    }
}
