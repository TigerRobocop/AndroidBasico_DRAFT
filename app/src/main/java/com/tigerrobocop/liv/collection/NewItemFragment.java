package com.tigerrobocop.liv.collection;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import static android.content.Context.NOTIFICATION_SERVICE;


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

                createNotification(it);

                Bundle bundle = new Bundle();
                bundle.putSerializable(TAG_NEWITEM, it);
                returnIntent.putExtras(bundle);

                getActivity().startActivity(returnIntent);
            }
        });

        return layout;
    }

    public void createNotification(Item newItem) {

        // Prepare intent which is triggered if the
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_ITEM_DETAILS, newItem);

        PendingIntent pIntent = PendingIntent.getActivity(getActivity()
                , (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(getActivity())
                .setContentTitle("New Item Added!!")
                .setContentText("Subject").setSmallIcon(R.drawable.icon)
                .setContentIntent(pIntent)
                .addAction(R.drawable.icon, "Call", pIntent)
                .addAction(R.drawable.icon, "More", pIntent)
                .addAction(R.drawable.icon, "And more", pIntent).build();


        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);
    }
}
