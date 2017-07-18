package com.ferrero.repository;

import com.ferrero.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drugo on 18/05/2017.
 */

/*
    The key to writing a Spring Data JPA repository is to extend one of a handful of interfaces.
    You won’t be writing any implementations of SpitterRepository. Instead, you’ll let Spring Data do it for you.
    It creates an implementation of SpitterRepository, including an implementation of all 18 methods inherited from:
    - JpaRepository
    - PagingAndSortingRepository
    - CrudRepository
*/
public interface SpittleRepository extends JpaRepository<Spittle,Long>, SpittleRepositoryOther {

//    public List<Spittle> findFirst5ByOrderByTimeDesc();

    Spittle findById(long id);

}
