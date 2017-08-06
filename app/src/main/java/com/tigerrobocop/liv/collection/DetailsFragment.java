package com.tigerrobocop.liv.collection;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tigerrobocop.liv.collection.Model.Item;


public class DetailsFragment extends Fragment {


    public static final String EXTRA_ITEM_DETAILS = "itemDetails";
    public static final String TAG_DETAILS = "itemDetails";
    Item mItem;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(Item item) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEM_DETAILS, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItem = (Item) getArguments().getSerializable(EXTRA_ITEM_DETAILS);
            setHasOptionsMenu(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_details, container, false);

        /*mTxtName = (TextView) layout.findViewById(R.id.textView_name);
        mTxtBrand = (TextView) layout.findViewById(R.id.textView_brand);
        mTxtColor = (TextView) layout.findViewById(R.id.textView_color);
        mImgPolish = (ImageView)layout.findViewById(R.id.imageView_polish);

        if (mPolish != null) {
            mTxtName.setText(mPolish.name);
            mTxtBrand.setText(mPolish.brand);
            mTxtColor.setText(mPolish.color);
            Picasso.with(getContext()).load(mPolish.imageUrl).into(mImgPolish);
            //    mImgPolish.setima
        }*/
        return layout;
    }

    //"http://developer.android.com/training/basics/fragments/communicating.html"

}
