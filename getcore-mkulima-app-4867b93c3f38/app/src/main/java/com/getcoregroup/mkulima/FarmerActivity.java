package com.getcoregroup.mkulima;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.getcoregroup.mkulima.adapters.FarmersListAdapter;
import com.getcoregroup.mkulima.models.Farmer;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by ley on 3/28/15.
 */
public class FarmerActivity  extends ActionBarActivity {

    public ListView listView;

    public static FarmersListAdapter adapter;

    public View listHeader;

    public EditText farmerSearch;

    private String mSearchQuery;

    public List<Farmer> initialFarmerList;

    public List<Farmer> FarmerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmers);

        listView = (ListView) findViewById(R.id.farmer_lv);
        initialFarmerList = Select.from(Farmer.class).list();
        FarmerList = Select.from(Farmer.class).list();

        LayoutInflater inflater = LayoutInflater.from(this);
        listHeader = inflater.inflate(R.layout.list_header, null);

        listView.addHeaderView(listHeader);

        farmerSearch = (EditText)listHeader.findViewById(R.id.farmer_search);

        adapter = new FarmersListAdapter(FarmerList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Farmer clickedFarmer = FarmerList.get(position-1);
                Intent farmerDetails = new Intent(FarmerActivity.this, FarmerDetailsActivity.class);
                farmerDetails.putExtra("mFarmer", clickedFarmer);
                startActivity(farmerDetails);
            }
        });

        farmerSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mSearchQuery = farmerSearch.getText().toString();
                if(mSearchQuery.isEmpty()){
                    FarmerList = initialFarmerList;
                }
                List<Farmer> curentFarmersList = FarmerList;
                FarmerList = searchFarmers(curentFarmersList, mSearchQuery);
                Log.d("search", "List has "+FarmerList.size()+" items");
                adapter.getData().clear();
                adapter.getData().addAll(FarmerList);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    public List<Farmer> searchFarmers (List<Farmer> currentList, String query){

        // First we split the query so that we're able
        // to search word by word (in lower case).
        String[] queryByWords = query.toLowerCase().split("\\s+");

        // Empty list to fill with matches.
        List<Farmer> FilteredFarmerList = new ArrayList<Farmer>();

        // Go through initial releases and perform search.
        for (Farmer farmer : FarmerList) {

            // Content to search through (in lower case).
            String content = (
                    farmer.getPreview() + " "
            ).toLowerCase();

            for (String word : queryByWords) {

                // There is a match only if all of the words are contained.
                int numberOfMatches = queryByWords.length;

                // All query words have to be contained,
                // otherwise the release is filtered out.
                if (content.contains(word)) {
                    numberOfMatches--;
                } else {
                    break;
                }

                // They all match.
                if (numberOfMatches == 0) {
                    FilteredFarmerList.add(farmer);
                }

            }

        }

        return FilteredFarmerList;

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
}
