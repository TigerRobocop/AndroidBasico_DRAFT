package com.tigerrobocop.liv.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tigerrobocop.liv.collection.Model.Item;

import java.util.List;

/**
 * Created by Livia on 31/07/2017.
 */

public class ItemAdapter  extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_item, null);
            viewHolder = new ViewHolder();

            viewHolder.imgThumb = (ImageView)convertView.findViewById(R.id.imageView_thumb);
            viewHolder.txtTitle = (TextView)convertView.findViewById(R.id.textView_title);
            viewHolder.txtDescription = (TextView)convertView.findViewById(R.id.textView_description);

            convertView.setTag(viewHolder);
        }else  {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Item item = getItem(position);

        if(item != null){
           // Picasso.with(getContext()).load(polish.imageUrl).into(viewHolder.imgThumb);
            viewHolder.txtTitle.setText(item.title);
            viewHolder.txtDescription.setText(item.description);
        }

        return convertView;
    }
}

class ViewHolder {
    ImageView imgThumb;
    TextView txtTitle;
    TextView txtDescription;
}
