package com.goldcode.naderwalid.miniproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<SpinnerRowItem> {
    LayoutInflater iflater;

    public SpinnerAdapter(Activity context, int resouceId, int textviewId, List<SpinnerRowItem> list) {

        super(context, resouceId, textviewId, list);
        iflater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SpinnerRowItem rowItem = getItem(position);
        View rowview = iflater.inflate(R.layout.spinner_list_item_layout, null, true);

        if (convertView != null) {
            TextView txtTitle = convertView.findViewById(R.id.title_list_item);
            txtTitle.setText(rowItem.getTitle());

            ImageView imageView = convertView.findViewById(R.id.icon);
            imageView.setImageResource(rowItem.getImageId());
            return convertView;
        } else {


            TextView txtTitle = rowview.findViewById(R.id.title_list_item);
            txtTitle.setText(rowItem.getTitle());

            ImageView imageView = rowview.findViewById(R.id.icon);
            imageView.setImageResource(rowItem.getImageId());

        }


        return rowview;


    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = iflater.inflate(R.layout.spinner_list_item_layout,parent, false);
        }
        SpinnerRowItem rowItem = getItem(position);
        TextView txtTitle =  convertView.findViewById(R.id.title_list_item);
        txtTitle.setText(rowItem.getTitle());
        ImageView imageView =  convertView.findViewById(R.id.icon);
        imageView.setImageResource(rowItem.getImageId());
        return convertView;
    }
}
