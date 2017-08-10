package com.tigerrobocop.liv.collection;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tigerrobocop.liv.collection.Model.Item;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewItemFragment extends Fragment {

    public static final String TAG_NEWITEM = "newItem";
    public static final String EXTRA_NEWITEM = "newItem";
    Button mBtnSubmit;

    public NewItemFragment() {
        // Required empty public constructor
    }

    public static NewItemFragment newInstance() {
        NewItemFragment fragment = new NewItemFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View layout = inflater.inflate(R.layout.fragment_new_item, container, false);

        mBtnSubmit = (Button) layout.findViewById(R.id.button_newItem_submit);

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent(getActivity(), MainActivity.class);

                Item it = new Item(10,
                        R.string.item_4_title,
                        R.string.item_4_description,
                        "",
                        "");

                Bundle bundle = new Bundle();
                bundle.putSerializable(TAG_NEWITEM, it);
                returnIntent.putExtras(bundle);

                getActivity().startActivity(returnIntent);

               // returnIntent.putExtra(EXTRA_NEWITEM, mCurrentChoice);
               // setResult(RESULT_OK, returnIntent);
               // finish();
            }
        });

        return layout;
    }

}
