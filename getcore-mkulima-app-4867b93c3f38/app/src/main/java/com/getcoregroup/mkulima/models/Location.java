package com.getcoregroup.mkulima.models;

import com.orm.SugarRecord;

/**
 * Created by ley on 4/9/15.
 */
public class Location extends SugarRecord<Location> {

    public String district;
    public String division;
    public String ward;
    public String village;
    public String hamlet;

    public Location(){

    }

    public Location(String district, String division, String ward, String village, String hamlet) {

        this.district = district;
        this.division = division;
        this.ward = ward;
        this.village = village;
        this.hamlet = hamlet;

    }

    /**
     * Setters
     */
    public void setDistrict(String mDistrict){this.district = mDistrict;}
    public void setDivision(String mDivision){this.division = mDivision;}
    public void setWard(String mWard){this.ward = mWard;}
    public void setVillage(String mVillage){this.village = mVillage;}
    public void setHamlet(String mHamlet){this.hamlet = mHamlet;}


    /**
     * Getters
     */
    public String getDistrict(){ return district;}
    public String getDivision(){return division;}
    public String getWard(){return ward;}
    public String getVillage(){return village;}
    public String getHamlet(){return hamlet;}


}
