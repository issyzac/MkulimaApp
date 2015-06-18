package com.getcoregroup.mkulima.models;

import com.orm.SugarRecord;

/**
 * Created by ley on 4/9/15.
 */
public class Location extends SugarRecord<Location> {

    public String district = "";
    public String division = "";
    public String ward = "";
    public String village = "";
    public String hamlet = "";

    public Location(){

    }

    public Location(String district, String division, String ward, String village, String hamlet) {

        this.district = district;
        this.division = division;
        this.ward = ward;
        this.village = village;
        this.hamlet = hamlet;

        this.save();

    }


    public String getPreview(){

        return this.district;
    }
}
