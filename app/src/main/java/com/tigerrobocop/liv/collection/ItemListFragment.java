package com.tigerrobocop.liv.collection;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tigerrobocop.liv.collection.Model.Item;

import java.util.ArrayList;
import java.util.List;


public class ItemListFragment extends ListFragment {

    List<Item> mListItem;
    ItemAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListItem = loadItems();
        clearSearch();
    }

    public void clearSearch() {
        mAdapter = new ItemAdapter(getActivity(), mListItem);
        setListAdapter(mAdapter);
    }


    private List<Item> loadItems() {
        List<Item> retorno = new ArrayList<Item> ();
        retorno.add(new Item(1,
                R.string.item_1_title,
                R.string.item_1_description,
                "",
                ""));

        retorno.add(new Item(2,
                R.string.item_2_title,
                R.string.item_2_description,
                "",
                ""));

        retorno.add(new Item(3,
                R.string.item_3_title,
                R.string.item_3_description,
                "",
                ""));

        retorno.add(new Item(4,
                R.string.item_1_title,
                R.string.item_1_description,
                "",
                ""));

        retorno.add(new Item(5,
                R.string.item_2_title,
                R.string.item_2_description,
                "",
                ""));

        retorno.add(new Item(6,
                R.string.item_3_title,
                R.string.item_3_description,
                "",
                ""));

        retorno.add(new Item(7,
                R.string.item_1_title,
                R.string.item_1_description,
                "",
                ""));

        retorno.add(new Item(8,
                R.string.item_2_title,
                R.string.item_2_description,
                "",
                ""));

        retorno.add(new Item(9,
                R.string.item_3_title,
                R.string.item_3_description,
                "",
                ""));

        return retorno;
    }
}