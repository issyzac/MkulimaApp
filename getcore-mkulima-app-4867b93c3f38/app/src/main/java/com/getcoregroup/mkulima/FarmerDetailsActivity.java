package com.getcoregroup.mkulima;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import com.gc.materialdesign.views.ButtonRectangle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.getcoregroup.mkulima.adapters.FarmersListAdapter;
import com.getcoregroup.mkulima.models.Farmer;
import com.orm.query.Select;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

/**
 *  Created by issymac on 5/6/15.
 */
public class FarmerDetailsActivity extends ActionBarActivity {

    public Farmer currentFarmer;

    /**
     * district, ward and village spinners
     */

    public Spinner districtSpinner;
    public Spinner wardSpinner;
    public Spinner villageSpinner;

    /**
     * ArrayAdapter connects the spinner widget to array-based data.
     */
    protected ArrayAdapter<CharSequence> districtAdapter;
    protected ArrayAdapter<CharSequence> wardAdapter;
    protected ArrayAdapter<CharSequence> villageAdapter;

    EditText names, phone, accres, seeds, pesticides, sprayers, fertilizers, cottons;

    TextView phone_title,name_title, acres_title, seeds_title, pesticides_title, sprayer_title, fertilizer_title, cottons_title, title;

    Button update;

    String mPhone, mAcres, mSeeds, mPesticides, mSprayer, mFertilizer, mCotton, mName;

    ImageView dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_details);

        dp = (ImageView)findViewById(R.id.farmer_dp);

        /*
         getting the titles of the text fields so as to style them
        */
        name_title = (TextView)findViewById(R.id.name_title);
        name_title.setTypeface(Home.Rosario_Regular);
        phone_title = (TextView)findViewById(R.id.phone_title);
        phone_title.setTypeface(Home.Rosario_Regular);
        acres_title = (TextView)findViewById(R.id.acres_title);
        acres_title.setTypeface(Home.Rosario_Regular);
        seeds_title = (TextView)findViewById(R.id.seeds_title);
        seeds_title.setTypeface(Home.Rosario_Regular);
        pesticides_title = (TextView)findViewById(R.id.pesticide_title);
        pesticides_title.setTypeface(Home.Rosario_Regular);
        sprayer_title = (TextView)findViewById(R.id.sprayers_title);
        sprayer_title.setTypeface(Home.Rosario_Regular);
        fertilizer_title = (TextView)findViewById(R.id.fertilizers_title);
        fertilizer_title.setTypeface(Home.Rosario_Regular);
        cottons_title = (TextView)findViewById(R.id.cotton_title);
        cottons_title.setTypeface(Home.Rosario_Regular);
        title = (TextView)findViewById(R.id.title_text);
        title.setTypeface(Home.Roboto_Black);


        names = (EditText)findViewById(R.id.farmer_names);
        phone = (EditText)findViewById(R.id.phone);
        accres = (EditText)findViewById(R.id.acres);
        seeds = (EditText)findViewById(R.id.seeds);
        pesticides = (EditText)findViewById(R.id.pesticide);
        sprayers = (EditText)findViewById(R.id.sprayers);
        fertilizers = (EditText)findViewById(R.id.fertilizers);
        cottons = (EditText)findViewById(R.id.cotton);

        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String mPhone, mAcres, mSeeds, mPesticides, mSprayer, mFertilizer, mCotton;
                mName = names.getText().toString();
                mPhone = phone.getText().toString();
                mAcres = accres.getText().toString();
                mSeeds = seeds.getText().toString();
                mPesticides = pesticides.getText().toString();
                mSprayer = sprayers.getText().toString();
                mFertilizer = fertilizers.getText().toString();
                mCotton = cottons.getText().toString();

                List<Farmer> farmer = Farmer.find(Farmer.class, "name = ?", currentFarmer.getPreview());
                long id = farmer.get(0).getId();
                Log.d("VALUE", farmer.get(0).getPhone()+"");
                Farmer mFarmer = farmer.get(0);

                mFarmer.name = mName;
                mFarmer.phone = mPhone;
                mFarmer.land = mAcres;
                mFarmer.seeds = mSeeds;
                mFarmer.pesticides = mPesticides;
                mFarmer.sprayer = mSprayer;
                mFarmer.fertilizers = mFertilizer;
                mFarmer.cotton = mCotton;

                mFarmer.save();

                Log.d(
                        "VALUE",
                        mFarmer.getPhone()+"**********\n"+
                        mFarmer.getPreview()+"**********\n"+
                        mFarmer.getAcres()+"**********\n"+
                        mFarmer.getCotton()+"**********\n"+
                        mFarmer.getFertilizers()+"**********\n"+
                        mFarmer.getPesticides()+"**********\n"+
                        mFarmer.getSeeds()+"**********\n"+
                        mFarmer.getSprayer()+"**********\n"+
                        "**********"
                );

                finish();

            }
        });

        Intent intent = getIntent();
        currentFarmer = (Farmer)intent.getSerializableExtra("mFarmer");

        this.districtSpinner = (Spinner)findViewById(R.id.sp_district);
        this.wardSpinner = (Spinner)findViewById(R.id.sp_ward);
        this.villageSpinner = (Spinner)findViewById(R.id.sp_village);

        this.names.setText(currentFarmer.getPreview());
        this.phone.setText(currentFarmer.getPhone());
        this.accres.setText(currentFarmer.getAcres());
        this.seeds.setText(currentFarmer.getSeeds());
        this.pesticides.setText(currentFarmer.getPesticides());
        this.sprayers.setText(currentFarmer.getSprayer());
        this.fertilizers.setText(currentFarmer.getFertilizers());
        this.cottons.setText(currentFarmer.getCotton());

        String imagePath = currentFarmer.getImage();
        Uri uri = Uri.fromFile(new File(imagePath));
        Picasso.with(this)
                .load(uri)
                .resize(400, 400)
                .centerCrop()
                .into(dp);

                /*
         * Create a backing mLocalAdapter for the Spinner from a list of the
         * planets. The list is defined by XML in the strings.xml file.
         */

        this.districtAdapter = ArrayAdapter.createFromResource(this, R.array.districts,
                android.R.layout.simple_spinner_dropdown_item);

        this.wardAdapter = ArrayAdapter.createFromResource(this, R.array.ward,
                android.R.layout.simple_spinner_dropdown_item);

        this.villageAdapter = ArrayAdapter.createFromResource(this, R.array.village,
                android.R.layout.simple_spinner_dropdown_item);

         /*
         * Attach the mLocalAdapter to the spinner.
         */

        districtSpinner.setAdapter(this.districtAdapter);
        wardSpinner.setAdapter(this.wardAdapter);
        villageSpinner.setAdapter(this.villageAdapter);

    }

    public void finish(){
        super.finish();

        List<Farmer> FarmerList = Select.from(Farmer.class).list();
        FarmerActivity.adapter.getData().clear();
        FarmerActivity.adapter.getData().addAll(FarmerList);
        FarmerActivity.adapter.notifyDataSetChanged();


    }

}
