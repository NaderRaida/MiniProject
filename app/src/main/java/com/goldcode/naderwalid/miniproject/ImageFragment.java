package com.goldcode.naderwalid.miniproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {

    public static final String RES_ID = "res_id";
    public static final String POS = "position";

    private String mPos;
    private int mID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final Bundle args = getArguments();
        mPos = args.getString(POS);
        mID = args.getInt(RES_ID);

        ImageView imageView = (ImageView) inflater.inflate(R.layout.pager_item, container, false);

        // Set the Image for the ImageView
        imageView.setImageResource(mID);

        // Set an setOnItemClickListener on the Gallery
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Display a Toast message indicate the selected item
//                Toast.makeText(getActivity(), mPos, Toast.LENGTH_SHORT).show();
            }
        });

        return imageView;
    }
}
