package com.goldcode.naderwalid.miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoodDetails extends AppCompatActivity {
    ImageView img;
    TextView name, mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.mood));

        if (getIntent() != null) {
            Person person = (Person) getIntent().getParcelableExtra("person");
            img = findViewById(R.id.img_detail);
            name = findViewById(R.id.name_detail);
            mood = findViewById(R.id.mood_detail);

            img.setImageResource(person.getImage());
            name.setText(person.getName());
            mood.setText(getResources().getStringArray(R.array.moods_names)[person.getIndex() - 1]);

        } else {
            Toast.makeText(this, "no data found ", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
