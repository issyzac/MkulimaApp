package com.getcoregroup.mkulima;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.getcoregroup.mkulima.models.Farmer;
import com.getcoregroup.mkulima.services.CameraPreview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ley on 3/29/15.
 */
public class AddFarmerActivity extends ActionBarActivity {

    protected Farmer farmer;
    EditText name, id_number, acres, seeds, phone, pesticide, sprayers,fertilizers, cotton, comments, image_path;

    RadioGroup gender, id_type;

    ImageView imgFavorite;

    RelativeLayout addImage;

    private Uri fileUri; // file url to store image/video

    File file;

    Button submit;

    private Camera mCamera;
    private CameraPreview mCameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_create);

        ArrayList<Farmer> FL = new ArrayList<Farmer>();
        FL.add(new Farmer("name", "gender", "id_type", "id_number", "phone","land", "seeds", "pesticides", "sprayers", "fertilizers", "cotton", "comment"));


        addImage = (RelativeLayout)findViewById(R.id.add_image);

        name = (EditText) findViewById(R.id.name);
        id_number = (EditText) findViewById(R.id.id_number);
        acres = (EditText) findViewById(R.id.acres);
        seeds = (EditText) findViewById(R.id.seeds);
        phone = (EditText) findViewById(R.id.phone);
        pesticide = (EditText) findViewById(R.id.pesticide);
        sprayers = (EditText) findViewById(R.id.sprayers);
        pesticide = (EditText) findViewById(R.id.pesticide);
        fertilizers = (EditText) findViewById(R.id.fertilizers);
        cotton = (EditText) findViewById(R.id.cotton);
        comments = (EditText) findViewById(R.id.comments);
        imgFavorite = (ImageView) findViewById(R.id.iv_farmer);

        image_path = (EditText) findViewById(R.id.et_image_path);

        gender = (RadioGroup) findViewById(R.id.radio_gender);
        id_type = (RadioGroup) findViewById(R.id.radio_id_type);

        submit = (Button) findViewById(R.id.farmer_create_submit);


        file = new File(Environment.getExternalStorageDirectory(), name + ".jpg");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFarmerForm();
            }
        });

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//              fileUri = getOutputMediaFileUri(1);
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile( file ));
                Intent intent = new Intent(AddFarmerActivity.this, CameraClass.class);
                startActivityForResult(intent, 2);
            }
        });

    }

    public void RegisterFarmerForm() {

        // get selected radio button from radioGroup
        int selectedGenderId = gender.getCheckedRadioButtonId();
        int selectedTypeId = id_type.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton selectedGender = (RadioButton) findViewById(selectedGenderId);
        RadioButton selectedType = (RadioButton) findViewById(selectedTypeId);

        farmer = new Farmer(
                this.name.getText().toString(),
                selectedGender.getHint().toString(),
                selectedType.getHint().toString(),
                this.id_number.getText().toString(),
                this.phone.getText().toString(),
                this.acres.getText().toString(),
                this.seeds.getText().toString(),
                this.pesticide.getText().toString(),
                this.sprayers.getText().toString(),
                this.fertilizers.getText().toString(),
                this.cotton.getText().toString(),
                this.comments.getText().toString()
        );

        farmer.setImage(this.image_path.getText().toString());

        farmer.save();

        Toast.makeText(getApplicationContext(),"Farmer: " + this.name.getText().toString(), Toast.LENGTH_SHORT).show();

        finish();

    }

    /**
     * Here we store the file url as it will be null after returning from camera
     * app
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on screen orientation
        // changes
        outState.putParcelable("file_uri", fileUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        fileUri = savedInstanceState.getParcelable("file_uri");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Bitmap bp = (Bitmap) data.getExtras().get("data");
//        imgFavorite.setImageBitmap(bp);

        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            addImage.setVisibility(View.GONE);
            String imagePath = data.getStringExtra("imageUri");
            image_path.setText(imagePath);
            imgFavorite.setImageBitmap(BitmapFactory.decodeFile(imagePath));
        }

//        FileInputStream in = null;
//        try {
//            in = new FileInputStream(file);
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inSampleSize = 10;
//            String imagePath = file.getAbsolutePath();
//            image_path.setText(imagePath);
//            Bitmap bmp = BitmapFactory.decodeStream(in, null, options);
//            imgFavorite.setImageBitmap(bmp);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }


    ///**  ------------ Helper Methods ---------------------- **/
    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)  ,
                "Mkulima");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Mkulima", "Oops! Failed create "
                        + "Mkulima" + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == 1) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == 2) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }
}
