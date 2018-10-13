package com.goldcode.naderwalid.miniproject;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InsertDialog extends android.support.v4.app.DialogFragment {
    ImageView img;
    Spinner spinner;
    EditText name;
    Button ok, cancel;
    insertToListInterface mCallback;
    int image = 0;
    int index=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.insert_dialog_layout, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        img = v.findViewById(R.id.img_dialog);
        spinner = v.findViewById(R.id.spinner);
        name = v.findViewById(R.id.edit_text_name_dialog);
        ok = v.findViewById(R.id.ok_dialog);
        cancel = v.findViewById(R.id.cancel_dialog);
//        View itemLayout = getLayoutInflater().inflate(R.layout.spinner_list_item_layout,null);
        ArrayList<SpinnerRowItem> rowItemList = new ArrayList<>();
        addToList(rowItemList);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getActivity(), R.layout.spinner_list_item_layout, R.id.title_list_item, rowItemList);
        spinner.setAdapter(spinnerAdapter);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.moods_names, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                img.setImageResource(DrawabelsListClass.drawables[position]);
                image = DrawabelsListClass.drawables[position];
                index= position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()){
                    mCallback.onOkClickListener(new Person(image, name.getText().toString(),index));
                    dismiss();
                }else{
                    name.setError("Required Field ");
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });

        return v;
    }

    void addToList(List<SpinnerRowItem> list) {
        for (int i = 0; i < 13; i++) {
            list.add(new SpinnerRowItem(getActivity().getResources().getStringArray(R.array.moods_names)[i], DrawabelsListClass.drawables[i]));
        }
    }

    public interface insertToListInterface {
        public void onOkClickListener(Person person);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (insertToListInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }
}

