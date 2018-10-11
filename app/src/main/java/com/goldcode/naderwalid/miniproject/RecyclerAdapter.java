package com.goldcode.naderwalid.miniproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    ArrayList<Person> moods_list = new ArrayList<>();
    LayoutInflater inflater;
    Context thisContext;
    public RecyclerAdapter(Context context, ArrayList<Person> list/*, String[] imagesArray*/){
        this.moods_list = list;
        inflater = LayoutInflater.from(context);
        thisContext = context;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.people_list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final Person person = moods_list.get(position);

        holder.mood_name.setText(person.getName());
        holder.mood_index.setText(String.valueOf(person.getIndex()));
        holder.mood_img.setImageResource(person.getImage());
//        holder.event_img.setImageResource(images[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("ONCLICKCARD",position+"");
//                Log.d("CARDNAME",moods_list.get(position).getName());
                Intent intent = new Intent(thisContext,MoodDetails.class);
                intent.putExtra("person",person);
                thisContext.startActivity(intent);
//                Toast.makeText(thisContext,moods_list.get(position).getName()
//                        +" on :"+position , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return moods_list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView mood_name,mood_index;
        ImageView mood_img;
        CardView cardView;
        public MyHolder(View itemView) {
            super(itemView);
            mood_img = itemView.findViewById(R.id.mood_img);
            mood_name =  itemView.findViewById(R.id.mood_name);
            mood_index =  itemView.findViewById(R.id.mood_index);
            cardView = itemView.findViewById(R.id.mood_cardview);
        }
    }
}
