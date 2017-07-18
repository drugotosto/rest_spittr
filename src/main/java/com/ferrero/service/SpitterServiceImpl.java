package com.ferrero.service;

import com.ferrero.model.Spitter;
import com.ferrero.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by drugo on 13/06/2017.
 */
@Service
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterRepository spitterRepository;

    public Spitter saveUser(Spitter spitter) {
        return spitterRepository.save(spitter);
    }

    public Spitter trovaSpitter(String username) {
        return spitterRepository.findByUsername(username);
    }
}
