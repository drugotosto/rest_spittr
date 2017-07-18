package com.ferrero.service;


import com.ferrero.model.Spittle;
import com.ferrero.model.SpittleForm;

import java.util.List;

/**
 * Created by drugo on 13/06/2017.
 */
public interface SpittleService {

    List<Spittle> getRecentSpittles();

    void saveSpittle(SpittleForm spittleForm);

    List<Spittle> trovaSpittles(long max, int count);

    Spittle trovaSpittle(long spittleId);
}
