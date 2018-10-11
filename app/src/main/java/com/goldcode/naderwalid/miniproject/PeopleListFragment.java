package com.goldcode.naderwalid.miniproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PeopleListFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Person> arrayList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem add = menu.add("add");
        add.setIcon(R.drawable.ic_add);
        add.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()){
            case "add":
//                InsertDialog insertDialog = new InsertDialog();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.add(insertDialog,"dialog");
//                ft.addToBackStack(null);


                return true;
        }
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        arrayList = new ArrayList<Person>();

        View view = inflater.inflate(R.layout.people_list_fragment_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerAdapter myRecyclerAdapter = new RecyclerAdapter(getContext(), arrayList);
        recyclerView.setAdapter(myRecyclerAdapter);

        addMoodsToList(arrayList);
        return view;
    }

    private void addMoodsToList(List<Person> list) {
         List listOfNames = new ArrayList();

        for (int i = 1; i <= 13; i++) {
            int indexOf = i -1 ;
            listOfNames.add(getResources().getStringArray(R.array.moods_names)[indexOf]);
        }


        for (int i = 1; i <= 13; i++) {
            int indexOf = i -1 ;
            list.add(new Person(MainActivity.drawables[indexOf], listOfNames.get(indexOf).toString(), i));
        }
    }
}
