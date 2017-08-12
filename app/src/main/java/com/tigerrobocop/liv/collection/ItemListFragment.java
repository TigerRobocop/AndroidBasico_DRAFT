package com.tigerrobocop.liv.collection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tigerrobocop.liv.collection.Model.Item;

import java.util.ArrayList;
import java.util.List;


public class ItemListFragment extends ListFragment {

    List<Item> mListItem;
    ItemAdapter mAdapter;

    public static final String TAG_NEWITEM = "newItem";

    public ItemListFragment() {
        // Required empty public constructor
    }

    public static ItemListFragment newInstance(Item item) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putSerializable(NewItemFragment.EXTRA_NEWITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListItem = ((CollectionApp)getActivity().getApplication()).getList(); //loadItems();

        Intent intent = getActivity().getIntent();
        Item item = (Item)intent.getSerializableExtra(NewItemActivity.EXTRA_NEWITEM);

        if (item != null) {
           // Item it = (Item) bundle.getSerializable(NewItemFragment.EXTRA_NEWITEM);
            mListItem.add(item);
        }

        clearSearch();
    }



    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_list_item, container, false);
        return layout;
    }
*/

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();
        if (activity instanceof OnItemClick) {
            Item it = (Item) l.getItemAtPosition(position);
            ((OnItemClick) activity).itemClick(it);
        }
    }

    public void clearSearch() {
        mAdapter = new ItemAdapter(getActivity(), mListItem);
        setListAdapter(mAdapter);
    }



    public void searchItem(String s) {
        if (s == null || s.trim().equals("")) {
            clearSearch();
            return;
        }

        List<Item> retorno = new ArrayList<Item>(mListItem);
        for (int i = retorno.size() - 1; i >= 0; i--) {
            Item it = retorno.get(i);
            String title = getActivity().getString(it.title);

            if (!title.toUpperCase().contains(s.toUpperCase())) {
                retorno.remove(it);
            }

            mAdapter = new ItemAdapter(getActivity(), retorno);

            setListAdapter(mAdapter);
        }
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
