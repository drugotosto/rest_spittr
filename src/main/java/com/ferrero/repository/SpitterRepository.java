package com.ferrero.repository;

import com.ferrero.model.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by drugo on 19/05/2017.
 */
/*
    The key to writing a Spring Data JPA repository is to extend one of a handful of interfaces.
    You won’t be writing any implementations of SpitterRepository. Instead, you’ll let Spring Data do it for you.
    It creates an implementation of SpitterRepository, including an implementation of all 18 methods inherited from
    JpaRepository, PagingAndSortingRepository, and CrudRepository
*/
public interface SpitterRepository extends JpaRepository<Spitter,Long>, SpitterRepositoryOther {

    /*
        Repository methods are composed of a verb, an optional subject, the word By, and a predicate.
        In the case of findByUsername(), the verb is find and the predicate is Username;
        the subject isn’t specified and is implied to be a Spitter.
    */
    Spitter findByUsername(String username);

    // Find all Spitters whose email address is a Gmail address
    @Query("select s from Spitter s where s.email like '%gmail.com'")
    List<Spitter> findAllGmailSpitters();
}

/*
    Spring Data allows for four verbs in the method name: get, read, find, and count.
    The get, read, and find verbs are synonymous; all three result in repository methods that query for data and return objects.
    The count verb, on the other hand, returns a count of matching objects, rather than the objects themselves.
*/
