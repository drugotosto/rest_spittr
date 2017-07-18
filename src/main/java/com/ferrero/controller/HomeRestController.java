package com.ferrero.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by drugo on 18/07/2017.
 */
@RestController
@RequestMapping("/")
public class HomeRestController {

    private static Logger logger = Logger.getLogger(SpitterRestController.class);


    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String home(){
        logger.info("Richiesta di accesso alla homepage!");
        return "AUTENTICAZIONE AVVENUTA CON SUCCESSO!";
    }
}
