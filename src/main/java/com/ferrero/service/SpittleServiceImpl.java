package com.ferrero.service;

import com.ferrero.model.Spittle;
import com.ferrero.model.SpittleForm;
import com.ferrero.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by drugo on 13/06/2017.
 */
@Service
public class SpittleServiceImpl implements SpittleService {

    @Autowired
    private SpittleRepository spittleRepository;

    public List<Spittle> getRecentSpittles(){
        return spittleRepository.findFirst5ByOrderByTimeDesc();
    }

    public void saveSpittle(SpittleForm spittleForm) {
        spittleRepository.save(new Spittle(null, spittleForm.getMessage(),new Date(), spittleForm.getLatitude(), spittleForm.getLongitude()));
    }

    public List<Spittle> trovaSpittles(long max, int count) {
        return null;
    }

    public Spittle trovaSpittle(long spittleId) {
        return spittleRepository.findById(spittleId);
    }
}
