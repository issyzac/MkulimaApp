package com.getcoregroup.mkulima;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getcoregroup.mkulima.models.Location;

import java.util.List;

/**
 *  Created by issymac on 4/25/15.
 */
public class LocationActivity extends ActionBarActivity {

    public Button locationSaveButton;

    public static String dist, div, war, vil, ham;

    public Location mLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

//        AlertDialog.Builder alertDialogBuilder;
//        alertDialogBuilder = new AlertDialog.Builder(this);
        final List<Location> mLocationList = Location.listAll(Location.class);
        mLocation = mLocationList.get(0);

        final EditText district = (EditText) findViewById(R.id.et_district);
        district.setText(mLocation.getDistrict());
        district.setTypeface(Home.Rosario_Regular);
        final EditText division = (EditText) findViewById(R.id.et_division);
        division.setText(mLocation.getDivision());
        division.setTypeface(Home.Rosario_Regular);
        final EditText ward = (EditText) findViewById(R.id.et_ward);
        ward.setText(mLocation.getWard());
        ward.setTypeface(Home.Rosario_Regular);
        final EditText village = (EditText) findViewById(R.id.et_village);
        village.setText(mLocation.getVillage());
        village.setTypeface(Home.Rosario_Regular);
        final EditText hamlet = (EditText) findViewById(R.id.et_hamlet);
        hamlet.setText(mLocation.getHamlet());
        hamlet.setTypeface(Home.Rosario_Regular);

        locationSaveButton = (Button) findViewById(R.id.location_save_button);

        locationSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dist = district.getText().toString();
                div = division.getText().toString();
                war = ward.getText().toString();
                vil = village.getText().toString();
                ham = hamlet.getText().toString();

                mLocation.district = dist;
                mLocation.division = div;
                mLocation.ward = war;
                mLocation.village = vil;
                mLocation.hamlet = ham;

                mLocation.save();

                Toast.makeText(getBaseContext(), "Set", Toast.LENGTH_LONG).show();

            }
        });

//        alertDialogBuilder.setCancelable(true)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//
//                        String district1 = division.getText().toString();
//                        String division1 = district.getText().toString();
//                        String ward1 = ward.getText().toString();
//                        String village1 = village.getText().toString();
//                        String hamlet1 = hamlet.getText().toString();
//
//                        if (!(division1 == "" || district1 == "" || ward1 == "" || village1 == "")) {
//                            Location address =
//                                    new Location(district1,
//                                            division1,
//                                            ward1,
//                                            village1,
//                                            hamlet1);
//
//                            Toast.makeText(getApplicationContext(), "Bla's clicked" + address.getDistrict(), Toast.LENGTH_SHORT).show();
//
//
//                        }
//                        Toast.makeText(getApplicationContext(), "" +
//                                "District, Division, Ward or Village can't be empty" +
//                                "", Toast.LENGTH_SHORT).show();
//
//                    }
//                })
//                .setNegativeButton("Cancel",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });

//        // create an alert dialog
//        AlertDialog alert = alertDialogBuilder.create();
//        alert.show();

        // Set Addresses
        // Start Uploading

    }

}
