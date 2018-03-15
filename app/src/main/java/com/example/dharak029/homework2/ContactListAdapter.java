package com.example.dharak029.homework2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dharak029 on 9/14/2017.
 */

public class ContactListAdapter extends BaseAdapter {

    private ArrayList<Contacts> items;
    private Context context;
    private int numItems = 0;

    public ContactListAdapter(ArrayList<Contacts> items, Context context, int numItems) {
        this.items = items;
        this.context = context;
        this.numItems = numItems;
    }

    @Override
    public int getCount() {
        return numItems;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the current list item
        final Contacts item = items.get(position);
        // Get the layout for the list item
        final RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        // Set the icon as defined in our list item
        ImageView imgIcon = (ImageView) itemLayout.findViewById(R.id.contactImg);
        if(item.getImage()!=null) {
            Bitmap image = BitmapFactory.decodeByteArray(
                    item.getImage(), 0, item.getImage().length);
            imgIcon.setImageBitmap(image);
        }
        else {
            imgIcon.setImageResource(R.drawable.default_image);
        }

        // Set the text label as defined in our list item
        TextView txtFirst = (TextView) itemLayout.findViewById(R.id.txtName);
        txtFirst.setText(item.getFirst().toString()+" "+item.getLast().toString());
        TextView txtNumber = (TextView) itemLayout.findViewById(R.id.txtNumber);
        txtNumber.setText(item.getPhone());

        return itemLayout;
    }
}
