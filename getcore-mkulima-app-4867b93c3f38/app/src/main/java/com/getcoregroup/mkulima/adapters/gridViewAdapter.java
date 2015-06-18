package com.getcoregroup.mkulima.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getcoregroup.mkulima.AddFarmerActivity;
import com.getcoregroup.mkulima.FarmerActivity;
import com.getcoregroup.mkulima.Home;
import com.getcoregroup.mkulima.LocationActivity;
import com.getcoregroup.mkulima.R;
import com.squareup.picasso.Picasso;

/**
 *  Created by issymac on 4/25/15.
 */

public class gridViewAdapter extends BaseAdapter {

    public String[] mItemsList;

    public Context mContext;

    public int position;

    public gridViewAdapter(String[] listArray, Context context){

        mContext = context;
        mItemsList = listArray;

    }

    @Override public int getCount() {
        return mItemsList.length;
    }

    @Override public Object getItem(int i) {
        return mItemsList[i];
    }

    @Override public long getItemId(int i) {
        return i;
    }

    @Override public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView image = (ImageView) view.findViewById(R.id.grid_image);
        TextView title = (TextView)view.findViewById(R.id.grid_text);
        //title.setTypeface(MediaActivity.Rosario_Regular);
        title.setTypeface(Home.Rosario_Regular);

        if(i==0){
            Picasso.with(view.getContext())
                    .load(R.drawable.ic_farmer)
                    .resize(800, 800)
                    .centerCrop()
                    .into(image);
            view.setTag(""+R.drawable.ic_farmer);
            title.setText(mItemsList[0]);


        }
        else if(i==1){

            Picasso.with(view.getContext())
                    .load(R.drawable.ic_register)
                    .resize(800, 800)
                    .centerCrop()
                    .into(image);

            title.setText(mItemsList[1]);
            view.setTag(""+R.drawable.ic_register);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,
                            "Clicked 1..... ",
                            Toast.LENGTH_LONG).show();
                }
            });

        }
        else if(i==2){

            Picasso.with(view.getContext())
                    .load(R.drawable.ic_upload)
                    .resize(800, 800)
                    .centerCrop()
                    .into(image);

            title.setText(mItemsList[2]);
            view.setTag(""+R.drawable.ic_upload);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,
                            "Clicked 2..... ",
                            Toast.LENGTH_LONG).show();
                }
            });

        }
        else {

            Picasso.with(view.getContext())
                    .load(R.drawable.ic_location)
                    .resize(800, 800)
                    .centerCrop()
                    .into(image);
            title.setText(mItemsList[3]);
            view.setTag(""+R.drawable.ic_location);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,
                            "Clicked 3..... ",
                            Toast.LENGTH_LONG).show();
                }
            });

        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i == 0){
                    Intent objIndent = new Intent(mContext, FarmerActivity.class);
                    mContext.startActivity(objIndent);
                }
                else if(i == 1){
                    Intent objIndent = new Intent(mContext, AddFarmerActivity.class);
                    mContext.startActivity(objIndent);
                }
                else if(i == 2){
                    Home.uploadFarmers(mContext);
                }
                else{
                    Intent locationActivity = new Intent(mContext, LocationActivity.class);
                    mContext.startActivity(locationActivity);
                }

            }
        });

        return view;
    }

}
