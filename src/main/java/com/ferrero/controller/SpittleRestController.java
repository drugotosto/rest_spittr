package com.ferrero.controller;

import com.ferrero.model.Spittle;
import com.ferrero.model.SpittleForm;
import com.ferrero.service.SpittleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by drugo on 13/07/2017.
 */
@RestController
@RequestMapping("/spittles")
public class SpittleRestController {

    private static Logger logger = Logger.getLogger(SpittleRestController.class);
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleService spittleService;

    @Autowired
    public SpittleRestController(SpittleService spittleService) {
        this.spittleService = spittleService;
    }

    @RequestMapping(method= RequestMethod.GET, produces="application/json")
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<Spittle> spittles() {
        logger.info(String.format("Recupero dei primi Spittles presenti nel DB"));
        List<Spittle> spittles = spittleService.getRecentSpittles();
        for (Spittle spit:  spittles) {
            logger.info(String.format("Messaggio: %s \n", spit.getMessage()));
        }
        return spittles;
    }

    @RequestMapping(method=RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    /*
        The @RequestBody tells Spring to find a message converter to convert a
        resource representation coming from a client into an object.
     */
    public SpittleForm processInsertSplittle(@RequestBody SpittleForm spittleForm) throws Exception {
        logger.info(String.format("Richiesta di inserimento di uno Spittle! MESSAGGIO: %s",spittleForm.getMessage()));
        spittleService.saveSpittle(spittleForm);
        return spittleForm;
    }
}

