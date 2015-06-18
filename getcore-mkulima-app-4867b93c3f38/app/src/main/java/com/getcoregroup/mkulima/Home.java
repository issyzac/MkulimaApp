package com.getcoregroup.mkulima;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gc.materialdesign.views.ProgressBarIndeterminate;
import com.getcoregroup.mkulima.adapters.gridViewAdapter;
import com.getcoregroup.mkulima.models.Farmer;
import com.getcoregroup.mkulima.models.Location;
import com.getcoregroup.mkulima.services.SiteClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Home extends ActionBarActivity {

    Button list, add, upload, location;

    private static ProgressBarIndeterminate progressBar;

    public static ProgressDialog progress;

    public GridView gridView;

    public String[] gridList;

    public gridViewAdapter adapter;

    public static Typeface Athletic, Fun_Raiser, Roboto_Condensed, Roboto_Black, Roboto_Light, Roboto_BoldCondensedItalic, Roboto_BoldCondensed, Rosario_Regular, Rosario_Bold, Rosario_Italic, Roboto_Regular, Roboto_Medium;

    public static final String MyPREFERENCES = "MyPrefs";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Log.d("pref", "Home here.... App Started");

        sharedPreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES,
                MODE_PRIVATE);
        if (sharedPreferences.getBoolean("my_first_time", true)) {
            Log.d("pref", "app running for the first time");

            ArrayList<Farmer> FL = new ArrayList<Farmer>();

            FL.add(new Farmer("Amos Lukokweli", "ME","","","","5","50","0","0","0","0","",""));
            FL.add(new Farmer("Amos Hamsa", "ME","","","","2","20","0","0","0","0","",""));
            FL.add(new Farmer("Amos George", "ME","","","","2","30","0","0","0","0","",""));
            FL.add(new Farmer("Amos Dotto", "ME","","","","2","30","0","0","0","0","",""));
            FL.add(new Farmer("Amos Charles", "ME","","","","2","30","0","0","0","0","",""));
            FL.add(new Farmer("Amos Bukelele", "ME","","","","3","30","0","0","0","0","",""));
            FL.add(new Farmer("Amon Punguja", "ME","","","","6","0","0","0","0","0","",""));
            FL.add(new Farmer("Amon P Mashauri", "ME","","","","8","0","0","0","0","0","",""));
            FL.add(new Farmer("Amon Kitlabya", "ME","","","","3","40","0","0","0","0","",""));
            FL.add(new Farmer("Amon Kitilabya", "ME","","","0752800892","3","40","0","0","0","0","",""));
            FL.add(new Farmer("AMISA MRISHO", "KE","","","","0.5","10","0","0","0","0","",""));
            FL.add(new Farmer("AMINI SHINGA", "ME","","","0785325770","1","6","0","0","0","0","",""));
            FL.add(new Farmer("AMINI KITANYOLA", "ME","","","","1","20","0","0","0","0","",""));
            FL.add(new Farmer("AMINI KAKULILO", "ME","","","","1","10","0","0","0","0","",""));
            FL.add(new Farmer("AMINA BUNDALA", "ME","","","0688113565","2","30","0","0","0","0","",""));
            FL.add(new Farmer("MASALU LUPIMO", "ME","","","0688113565","3","60","0","0","0","0","",""));
            FL.add(new Farmer("AMANDUS THOMAS", "ME","","","","2","20","0","0","0","0","",""));
            FL.add(new Farmer("ALY MABULA", "ME","","","","3","40","0","0","0","0","",""));
            FL.add(new Farmer("ALPHONCE THOMAS", "ME","","","","5","50","0","0","0","0","",""));
            FL.add(new Farmer("ALPHONCE SHEDRAK", "ME","","","","2","10","0","0","0","0","",""));
            FL.add(new Farmer("RICHARD BWISO", "ME","","","0682465787","2","20","0","0","0","0","",""));
            FL.add(new Farmer("ALOYCE NDOMBEZI", "ME","","","","1","20","0","0","0","0","",""));
            FL.add(new Farmer("ALOYCE LUCHENYA", "ME","","","","9","90","0","0","0","0","",""));
            FL.add(new Farmer("ALOYCE KIBERITI", "ME","","","","2","30","0","0","0","0","",""));
            FL.add(new Farmer("ALOYCE JOSEPH", "ME","","","","1","18","0","0","0","0","",""));
            FL.add(new Farmer("ALON LUBINZA", "ME","","","0755540831","5","50","0","0","0","0","",""));
            FL.add(new Farmer("ALMASI LINGANISA", "ME","","","","2","20","0","0","0","0","",""));
            FL.add(new Farmer("ALMASI KEREBE", "ME","","","","3","32","0","0","0","0","",""));
            FL.add(new Farmer("ALLY SWET", "ME","","","","1","10","0","0","0","0","",""));
            FL.add(new Farmer("ALLY MATIMBWA", "ME","","","","5","50","0","0","0","0","",""));
            FL.add(new Farmer("MANDAGO SHIJA", "ME","","","0684757909","1.5","60","0","0","0","0","",""));
            FL.add(new Farmer("ALON MISTA", "ME","","","","2","40","0","0","0","0","",""));
            FL.add(new Farmer("ALIZABETHI MAHUNGA", "","","","","4","20","0","0","0","0","",""));
            FL.add(new Farmer("ALIPHONCE ZAMBWA", "ME","","","0685382007","5","60","0","0","0","0","",""));
            FL.add(new Farmer("ALIPHONCE PHILIPO", "ME","","","","5","50","0","0","0","0","",""));
            FL.add(new Farmer("ALIPHONCE JUSTINE", "ME","","","","2","20","0","0","0","0","",""));
            FL.add(new Farmer("ALIPHONCE ANDREA", "ME","","","","5","50","0","0","0","0","",""));
            FL.add(new Farmer("ALIMASI LUHINDA", "ME","","","","1","30","0","0","0","0","",""));
            FL.add(new Farmer("ALIFRED SOLO", "ME","","","0687064193","2","2","0","0","0","0","",""));
            FL.add(new Farmer("ALEX MARANGA", "ME","","","","2","30","0","0","0","0","",""));
            FL.add(new Farmer("ALEX KATINGO", "ME","KURA","100","0687958259","1.25","20","0","0","0","0","",""));
            FL.add(new Farmer("DAUDI LUCAS", "ME", "", "", "","2", "12", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALAH CHARLES", "ME", "", "", "","3", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALAH LUSHONA", "ME", "", "", "","8", "168", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALAH MAJURA", "ME", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALAH MOHAMED", "ME", "", "", "","1", "25", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALAH MOHAMED", "ME", "", "", "","3", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALAH RAMADHAN", "ME", "", "", "","6", "120", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALA LUTOMBEJA", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDALA MASHALA", "ME", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABDU RESWETURA", "ME", "", "", "","2", "10", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL BUSWELI", "ME", "", "", "","3", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL CHARLES", "ME", "", "", "","3", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL EMANUAEL MAGUBU", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI CHARLES MISUNGW", "ME", "", "", "","5", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI JUMA", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI KATEMI", "ME", "", "", "","8", "9", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI KITWANGA", "ME", "", "", "","4", "40", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI LUCAS", "ME", "", "", "","2", "40", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI SHAGI", "ME", "", "", "","3", "10", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI SHIDOLO", "ME", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI MAKOYE", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI MASHAURI", "ME", "", "", "","5", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI MATHIAS", "ME", "", "", "","5", "60", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELI MAZANZA", "ME", "", "", "","3", "60", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL MAZURI", "ME", "", "", "","5", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL NTEMIYANDA", "ME", "", "", "0783377195","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL SERIKALI", "ME", "", "", "0788285271","4", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL SERIKALI", "KE", "", "", "","3", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABEL SOSPETER", "ME", "", "", "","4", "40", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABELY EMANUEL", "ME", "", "", "","6", "60", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABERY HUNGWI", "ME", "", "", "","3", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABERY KABILIMWANZA", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABERY LUCAS", "ME", "", "", "","1", "10", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABERY WADOSA", "ME", "", "", "0788626039","2", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABERYY HINDIA", "ME", "", "", "","7", "10", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABIBU RAMADHAN", "ME", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABROCE FRANCIS", "ME", "", "", "","2", "60", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABUBAKARI RASHID", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ABUDU LUSWETULA", "ME", "", "", "","1", "10", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("A BUSALU", "ME", "", "", "","7", "9", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ADAM DANIELI", "ME", "", "", "","4", "40", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ADAM LUGATA", "ME", "", "", "","0", "3", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ALEX JOSEPH", "ME", "", "", "","1", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ALES PETRO", "ME", "", "", "","1", "10", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ALASTO NGELEJA", "ME", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ALASTO LUGAGANYA", "ME", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("ALAN MASANYIWA", "ME", "", "", "","4", "60", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AKILI AGUSTINE", "ME", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AJILI YOHANA", "KE", "", "", "","7", "74", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AJELINA TINI", "KE", "", "", "","2", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AJELINA NGOMBEJAKE", "KE", "", "", "","2", "20", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AGUSTINE MATHIAS", "ME", "", "", "","3", "50", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AGUSTINE LUSANA", "ME", "", "", "","3", "30", "0", "0", "0", "0", "0", ""));
            FL.add(new Farmer("AGUSTINE LUBIGISA", "ME", "", "", "","3", "30", "0", "0", "0", "0", "0", ""));

            FL.add(new Farmer("ADAM LUGATA", "ME", "", "", "", "0", "3", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADAM HANGA", "ME", "", "", "", "1", "50", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADAM SHIKOKWA", "ME", "", "", "", "1", "50", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADEFAL MWENU", "ME", "", "", "", "1", "10", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADOFU JOSEPH", "ME", "", "", "", "1", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADOFU JOSEPH", "", "", "", "", "1", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADOFU JOSEPH", "ME", "", "", "", "1", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADREA CELEMENT", "ME", "", "", "0755270757", "1", "10", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADREA MCHELE", "ME", "", "", "", "4", "40", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADREA MCHELE", "ME", "", "", "", "4", "40", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("ADVENTINA COSMAS", "KE", "", "", "", "1.5", "15", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AFREDI BUNDALA", "ME", "", "", "", "4", "40", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AFRED MAKOLIGO", "ME", "", "", "", "0", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGATHA COSMAS", "KE", "", "", "0687215639", "2", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGINES AGUSTINE", "ME", "", "", "", "6", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGINES MATHAYO NGOMBA", "KE", "", "", "", "5", "50", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES ELIAS", "KE", "", "", "0688729694", "2", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES GEREVAS", "KE", "", "", "", "1", "10", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES KAHALUZI", "KE", "", "", "", "1", "10", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES KAHALUZI", "KE", "", "", "", "1", "10", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES KASUBI", "KE", "", "", "", "3", "30", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("JULIUS MASINI", "ME", "", "", "0685035716", "1", "60", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES MASHIKO", "KE", "", "", "", "2", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES MASHIKU", "KE", "", "", "0782534174", "4", "50", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES PATRICE", "ME", "", "", "", "2", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES STANLAUS", "KE", "", "", "", "2", "60", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES STANLAUS", "KE", "", "", "", "2", "60", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES STANLAUS", "KE", "", "", "", "2", "60", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGNES ZACHARIA", "KE", "", "", "", "3", "50", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGRENA MALELEMBA", "KE", "", "", "", "1", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGRICOLA TITO", "KE", "", "", "", "3", "30", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGUSTINE JOSEPH", "ME", "", "", "", "2", "20", "0", "0", "0", "0", "", ""));
            FL.add(new Farmer("AGUSTINE JUMA", "ME", "", "", "", "3", "30", "0", "0", "0", "0", "", ""));

            for(int i=0; i<FL.size(); i++){
                FL.get(i).save();
            }

            sharedPreferences.edit().putBoolean("my_first_time", false).apply();
        }


        Roboto_Light = Typeface.createFromAsset(this.getAssets(), "Roboto-Light.ttf");
        Roboto_Black = Typeface.createFromAsset(this.getAssets(), "Roboto-Black.ttf");
        Roboto_Condensed = Typeface.createFromAsset(this.getAssets(), "Roboto-Condensed.ttf");
        Roboto_BoldCondensedItalic = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensedItalic.ttf");
        Roboto_BoldCondensed = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensed.ttf");
        Roboto_Regular = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
        Roboto_Medium = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        Rosario_Regular = Typeface.createFromAsset(getAssets(), "Rosario-Regular.ttf");
        Rosario_Italic = Typeface.createFromAsset(getAssets(), "Rosario-Italic.ttf");
        Rosario_Bold = Typeface.createFromAsset(getAssets(), "Rosario-Bold.ttf");
        Fun_Raiser = Typeface.createFromAsset(getAssets(), "Fun-Raiser.ttf");
        Athletic = Typeface.createFromAsset(getAssets(), "athletic.ttf");

        upload = (Button) findViewById(R.id.upload);
        location = (Button) findViewById(R.id.btn_set_location);

        progressBar = (ProgressBarIndeterminate) findViewById(R.id.progressBar);

//        progress = new ProgressDialog(this);
//        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progress.setIndeterminate(true);
        /**
         * Grid View initialization
         */
        gridList = getResources().getStringArray(R.array.list);
        gridView = (GridView)findViewById(R.id.items_grid);
        adapter = new gridViewAdapter(gridList, this);
        gridView.setAdapter(adapter);


        // Checking camera availability
        if (!isDeviceSupportCamera()) {
            add.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            finish();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Checking device has camera hardware or not
     * */
    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
    public static void uploadFarmers(Context mContext) {

        final List<Farmer> farmers = Farmer.listAll(Farmer.class);

        for (int i = 0; i < farmers.size(); i++) {
            final Farmer farmer = farmers.get(i);


            if (farmer.sent) continue;

            RequestParams params = new RequestParams();
            params.put("name", farmer.name);
            params.put("gender", farmer.gender);
            params.put("identification_type", farmer.id_type);
            params.put("identification_number", farmer.id_number);
            params.put("phone", farmer.phone);
            params.put("seeds", farmer.seeds);
            params.put("pesticides", farmer.pesticides);
            params.put("fertilizers", farmer.fertilizers);
            params.put("cotton", farmer.cotton);
            params.put("comment", farmer.comment);

            try {
                params.put("image", new File(farmer.image));
            } catch (FileNotFoundException e) {
                Toast.makeText(mContext, "Image for " + farmer.getPreview() + " was not found", Toast.LENGTH_LONG).show();
                continue;
            }

            final int finalI = i++;
            SiteClient.post(params, new AsyncHttpResponseHandler() {

                @Override
                public void onStart() {
//                    progress.setMessage(
//                            "Uploading farmers " + finalI + " / " + farmers.size()
//                    );
                    progressBar.setVisibility(View.VISIBLE);

                    super.onStart();
                }

                @Override
                public void onProgress(int bytesWritten, int totalSize) {
                    super.onProgress(bytesWritten, totalSize);

//                    progress.setProgress(bytesWritten);
//                    progress.setMax(totalSize);
//                    progress.show();
                    progressBar.setVisibility(View.VISIBLE);
//                    updating progress bar value
                    progressBar.setProgress(bytesWritten);
                    progressBar.setMax(totalSize);


                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    farmer.setSent();
                    Log.i("Mkulima", "Success: " + farmer.getPreview() + " sent!");
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    Log.e("Mkulima", Arrays.toString(headers));
                    Log.e("Mkulima", String.valueOf(statusCode));
                    Log.e("Mkulima", Arrays.toString(responseBody));

                }

                @Override
                public void onFinish() {
//                    progress.dismiss();
                    progressBar.setVisibility(View.GONE);
                    super.onFinish();
                }
            });
        }



        Toast.makeText(mContext, "Uploading ......",Toast.LENGTH_LONG).show();

    }

    public void setLocation(View view){
        // Start uploading
        // / setup a dialog window

        LayoutInflater layoutInflater = LayoutInflater.from(Home.this);
        View promptView;
        promptView = layoutInflater.inflate(R.layout.location, null);

        AlertDialog.Builder alertDialogBuilder;

        alertDialogBuilder = new AlertDialog.Builder(Home.this);
        alertDialogBuilder.setView(promptView);

        final EditText district = (EditText) promptView.findViewById(R.id.et_district);
        final EditText division = (EditText) promptView.findViewById(R.id.et_division);
        final EditText ward = (EditText) promptView.findViewById(R.id.et_ward);
        final EditText village = (EditText) promptView.findViewById(R.id.et_village);
        final EditText hamlet = (EditText) promptView.findViewById(R.id.et_hamlet);

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
