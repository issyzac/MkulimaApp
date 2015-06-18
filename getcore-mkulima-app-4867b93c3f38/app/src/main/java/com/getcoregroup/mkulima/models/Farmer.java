package com.getcoregroup.mkulima.models;

import android.util.Log;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 *  Created by ley on 3/30/15.
 */
public class Farmer extends SugarRecord<Farmer> implements Serializable{
    public String name;
    public String gender;
    public String id_type;
    public String id_number;
    public String phone;
    public String land; //in acres
    public String seeds;
    public String pesticides;
    public String sprayer;
    public String fertilizers;
    public String cotton;
    public String comment;
    public Boolean sent = false;
    public String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Farmer(){

    }

    /**
     * Farmer Entity
     *
     * @param name
     * @param gender
     * @param id_type
     * @param id_number
     * @param phone
     * @param land
     * @param seeds
     * @param pesticides
     * @param sprayer
     * @param fertilizers
     * @param cotton
     * @param comment
     */
    public Farmer(String name, String gender, String id_type, String id_number, String phone, String land, String seeds, String pesticides, String sprayer, String fertilizers, String cotton, String comment) {
        this.name = name;
        this.gender = gender;
        this.id_type = id_type;
        this.id_number = id_number;
        this.phone = phone;
        this.land = land;
        this.seeds = seeds;
        this.pesticides = pesticides;
        this.sprayer = sprayer;
        this.fertilizers = fertilizers;
        this.cotton = cotton;
        this.comment = comment;
    }




    public Farmer(String name, String gender, String id_type, String id_number, String phone, String land, String seeds, String pesticides, String sprayer, String fertilizers, String cotton, String comment, String imagePath) {
        this.name = name;
        this.gender = gender;
        this.id_type = id_type;
        this.id_number = id_number;
        this.phone = phone;
        this.land = land;
        this.seeds = seeds;
        this.pesticides = pesticides;
        this.sprayer = sprayer;
        this.fertilizers = fertilizers;
        this.cotton = cotton;
        this.comment = comment;
        this.image = imagePath;
    }

    /*
     public String gender;
     public String id_type;
     public String id_number;
     public String phone;
     public String land; //in acres
     public String seeds;
     public String pesticides;
     public String sprayer;
     public String fertilizers;
     public String cotton;
     public String comment;
     public Boolean sent = false;
     public String image;
     */
    public Farmer setSent(){
       this.sent = true;
       return this;
    }

    /*
    variable Setters
     */
    public void setName(String mName){ this.name = mName; }
    public void setPhone(String mPhone){ this.phone = mPhone; }
    public void setLand(String mLand){ this.land = mLand; }
    public void setSeeds(String mSeeds){
        this.seeds = mSeeds;
        Log.d("farmerseeds", "value set to "+mSeeds);
    }
    public void setPesticides(String mPesticides){ this.pesticides = mPesticides; }
    public void setSprayer(String mSprayer){ this.sprayer = mSprayer; }
    public void setFertilizers(String mFertilizer){ this.fertilizers = mFertilizer; }
    public void setCotton(String mCotton){ this.cotton = mCotton; }


    /*
    Variable getters
     */
    public String getPhone(){ return this.phone; }
    public String getAcres(){ return this.land; }
    public String getSeeds(){ return this.seeds; }
    public String getPesticides(){ return this.pesticides; }
    public String getSprayer(){ return this.sprayer; }
    public String getFertilizers(){ return this.fertilizers; }
    public String getCotton(){ return this.cotton; }
    public String getPreview(){ return this.name; }

    @Override
    public String toString() {
        return this.name;
    }
}
