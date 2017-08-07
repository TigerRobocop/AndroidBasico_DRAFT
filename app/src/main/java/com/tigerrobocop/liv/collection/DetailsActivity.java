package com.tigerrobocop.liv.collection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.tigerrobocop.liv.collection.Model.Item;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_DETAILS = "itemDetails";
    public static final String TAG_DETAILS = "itemDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Item item = (Item)intent.getSerializableExtra(EXTRA_ITEM_DETAILS);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getString(item.title));

        DetailsFragment detailsFragment = DetailsFragment.newInstance(item);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.details, detailsFragment, DetailsFragment.TAG_DETAILS);
        ft.commit();
    }

    /*
    *
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }
    *
    * */


}
