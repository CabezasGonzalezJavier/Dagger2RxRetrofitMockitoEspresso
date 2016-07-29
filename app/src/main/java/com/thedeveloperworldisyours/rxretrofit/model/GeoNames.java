package com.thedeveloperworldisyours.rxretrofit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javierg on 28/07/16.
 */
public class GeoNames {

    private List<Geoname> geonames = new ArrayList<Geoname>();

    /**
     *
     * @return
     *     The geonames
     */
    public List<Geoname> getGeonames() {
        return geonames;
    }

}
