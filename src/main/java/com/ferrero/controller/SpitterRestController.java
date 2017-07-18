package com.ferrero.controller;

import com.ferrero.model.Spitter;
import com.ferrero.service.SpitterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * Created by drugo on 19/05/2017.
 */
@RestController
@RequestMapping("/spitter")
public class SpitterRestController {

    private static Logger logger = Logger.getLogger(SpitterRestController.class);

    private SpitterService spitterService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SpitterRestController(SpitterService spitterService, PasswordEncoder passwordEncoder) {
        this.spitterService = spitterService;
        this.passwordEncoder = passwordEncoder;
    }


    @RequestMapping(value="/{username}", method=RequestMethod.GET, produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public Spitter showSpitterProfile(@PathVariable String username) {
        logger.info(String.format("Visualizzazione pagina dell'utente %s",username));
        return spitterService.trovaSpitter(username);
    }


    @RequestMapping(value="/register", method=RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    /*
        The @RequestBody tells Spring to find a message converter to convert a
        resource representation coming from a client into an object.
     */
    public Spitter processRegistration(@RequestBody Spitter spitter) {
        logger.info(String.format("Salvataggio utente NOME: %s COGNOME: %s FIRSTNAME: %s" ,spitter.getUsername(),spitter.getFirst_name(), spitter.getLast_name()));
        // Faccio uso del bean "passwordEncoder" per memorizzare nel DB la password scelta dall'utente come DIGEST SHA-256 e successivo confronto poi in fase di logging
        spitter.setPassword(passwordEncoder.encode(spitter.getPassword()));
        spitterService.saveUser(spitter);
        return spitter;
    }
}

