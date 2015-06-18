package com.getcoregroup.mkulima.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.getcoregroup.mkulima.Home;
import com.getcoregroup.mkulima.R;
import com.getcoregroup.mkulima.models.Farmer;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 *  Created by issymac on 4/25/15.
 *  constructor List<Farmer>
 */
public class FarmersListAdapter extends BaseAdapter{

    public List<Farmer> mList;



    public FarmersListAdapter(List<Farmer> farmerList){

        mList = farmerList;

    }

    public List<Farmer> getData(){
        return mList;
    }

    @Override public int getCount() {
        return mList.size();
    }

    @Override public Object getItem(int i) {
        return mList.get(i);
    }

    @Override public long getItemId(int i) {
        return i;
    }

    @Override public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.farmers_list_item, viewGroup, false);
        }

        ImageView farmerImage = (ImageView) view.findViewById(R.id.farmer_image);
        String imagePath = mList.get(i).getImage();
//      farmerImage.setImageBitmap(BitmapFactory.decodeFile(imagePath));
        Uri uri = Uri.fromFile(new File(imagePath));

        Picasso.with(view.getContext())
                .load(uri)
                .resize(400, 400)
                .centerCrop()
                .into(farmerImage);
        view.setTag(""+uri);

        View uploadTag = (View)view.findViewById(R.id.upload_tag);
        TextView farmerName = (TextView) view.findViewById(R.id.farmer_names);
        farmerName.setTypeface(Home.Rosario_Regular);
        TextView farmerDistrict = (TextView) view.findViewById(R.id.farmer_district);
        farmerDistrict.setTypeface(Home.Roboto_Medium);
        TextView farmerWard = (TextView) view.findViewById(R.id.farmer_ward);
        farmerWard.setTypeface(Home.Roboto_Medium);
        TextView farmerVillage = (TextView) view.findViewById(R.id.farmer_village);
        farmerVillage.setTypeface(Home.Roboto_Medium);
        farmerName.setText(mList.get(i).getPreview());
        if(farmerName.getText().toString().length()>6){
            uploadTag.setVisibility(View.GONE);
        }
        uploadTag.setVisibility(View.VISIBLE);

        return view;
    }

}
