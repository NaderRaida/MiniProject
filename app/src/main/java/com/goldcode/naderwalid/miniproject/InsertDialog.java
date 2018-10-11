package com.goldcode.naderwalid.miniproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class InsertDialog extends Fragment {
    ImageView img;
    Spinner spinner;
    EditText name;
    Button ok ,cancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.insert_dialog_layout, container, false);
        img = v.findViewById(R.id.img_dialog);
        spinner = v.findViewById(R.id.spinner);
        name = v.findViewById(R.id.edit_text_name_dialog);
        ok = v.findViewById(R.id.ok_dialog);
        cancel = v.findViewById(R.id.cancel_dialog);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.moods_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dismiss();
            }
        });

        return v;
    }

}
