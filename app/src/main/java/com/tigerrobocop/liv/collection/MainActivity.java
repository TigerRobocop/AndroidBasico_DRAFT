package com.tigerrobocop.liv.collection;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.tigerrobocop.liv.collection.Model.Item;

public class MainActivity extends AppCompatActivity implements OnItemClick
        , SearchView.OnQueryTextListener
        , MenuItemCompat.OnActionExpandListener{

    private FragmentManager mFragmentManager;
    private ItemListFragment mItemListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Item item = (Item)intent.getSerializableExtra(NewItemActivity.EXTRA_NEWITEM);

        mFragmentManager = getSupportFragmentManager();
        mItemListFragment = (ItemListFragment) mFragmentManager.findFragmentById(R.id.fragment_list_item);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Prepare intent which is triggered if the
                // notification is selected
                Intent intent =  getIntent(); //new Intent(getA, MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);

                // Build notification
                // Actions are just fake
                Notification noti = new Notification.Builder(MainActivity.this)
                        .setContentTitle("New mail from " + "test@gmail.com")
                        .setContentText("Subject").setSmallIcon(R.drawable.icon)
                        .setContentIntent(pIntent)
                        .addAction(R.drawable.icon, "Call", pIntent)
                        .addAction(R.drawable.icon, "More", pIntent)
                        .addAction(R.drawable.icon, "And more", pIntent).build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // hide the notification after its selected
                noti.flags |= Notification.FLAG_AUTO_CANCEL;

                notificationManager.notify(0, noti);


                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });
    }

    // LIST ITEM CLICKED
    @Override
    public void itemClick(Item i) {

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_ITEM_DETAILS, i);
        startActivity(intent);

    }



    /// btn click - new user?
    public void CreateNewUser() {
        // "http://developer.android.com/training/basics/fragments/communicating.html"
      //  Intent intent = new Intent(this, ImageUploadActivity.class);
        //startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint(getString(R.string.hint_search_by_title));
        MenuItemCompat.setOnActionExpandListener(searchItem, this);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        mItemListFragment.clearSearch();
        return true;
       // return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mItemListFragment.searchItem(newText);
        return false;
    }
}
