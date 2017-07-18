package com.ferrero.service;


import com.ferrero.model.Spitter;

/**
 * Created by drugo on 13/06/2017.
 */
public interface SpitterService {

    Spitter saveUser(Spitter spitter);

    Spitter trovaSpitter(String username);
}
