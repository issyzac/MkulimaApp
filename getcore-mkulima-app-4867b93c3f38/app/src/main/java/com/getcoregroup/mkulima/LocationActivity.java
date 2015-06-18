package com.getcoregroup.mkulima;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.getcoregroup.mkulima.models.Location;

/**
 *  Created by issymac on 4/25/15.
 */
public class LocationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        AlertDialog.Builder alertDialogBuilder;

        alertDialogBuilder = new AlertDialog.Builder(this);

        final EditText district = (EditText) findViewById(R.id.et_district);
        final EditText division = (EditText) findViewById(R.id.et_division);
        final EditText ward = (EditText) findViewById(R.id.et_ward);
        final EditText village = (EditText) findViewById(R.id.et_village);
        final EditText hamlet = (EditText) findViewById(R.id.et_hamlet);

        alertDialogBuilder.setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        String district1 = division.getText().toString();
                        String division1 = district.getText().toString();
                        String ward1 = ward.getText().toString();
                        String village1 = village.getText().toString();
                        String hamlet1 = hamlet.getText().toString();

                        if (!(division1 == "" || district1 == "" || ward1 == "" || village1 == "")) {
                            Location address =
                                    new Location(district1,
                                            division1,
                                            ward1,
                                            village1,
                                            hamlet1);

                            Toast.makeText(getApplicationContext(), "Bla's clicked" + address.getPreview(), Toast.LENGTH_SHORT).show();


                        }
                        Toast.makeText(getApplicationContext(), "" +
                                "District, Division, Ward or Village can't be empty" +
                                "", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

        // Set Addresses
        // Start Uploading

    }

}
