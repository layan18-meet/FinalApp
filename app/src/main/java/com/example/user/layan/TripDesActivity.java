package com.example.user.layan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class TripDesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ImageButton addDayToList;

    ArrayList<TripDay> tripDays2 = new ArrayList<>();

    ListView plannedDaysLV;
    CustomAdapter customAdapter;

    TextView plannedDaysTV, tripName2TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_des);

        addDayToList= (ImageButton) findViewById(R.id.addDayToList);
        addDayToList.setOnClickListener(this);

        plannedDaysLV= (ListView) findViewById(R.id.plannedDaysLV);
        plannedDaysLV.setOnItemClickListener(this);

        plannedDaysTV= (TextView) findViewById(R.id.plannedDaysTV);
        tripName2TV= (TextView) findViewById(R.id.tripName2TV);

        customAdapter = new CustomAdapter(this, R.layout.custom_row,tripDays2);
        plannedDaysLV.setAdapter(customAdapter);

        Trip trip = (Trip) getIntent().getSerializableExtra("trip");
        if(trip != null){
            tripName2TV.setText(trip.getName());
            tripDays2= trip.getDays();

        }
        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference myRef= database.getReference("Users/Trip/days");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Map<String, String> map= (Map<String, String>) dataSnapshot.getValue();
                Log.v("E_VALUE", "DATA: "+ dataSnapshot.getValue());


                String country= map.get("country");
                String cities= map.get("cities");
            //    String image= (String)map.get("image");
                String description= map.get("description");
                TripDay tripDay = new TripDay(country, cities, description, R.drawable.flag);
                tripDays2.add(tripDay);
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {
        if (v== addDayToList){
            Intent i= new Intent(this, PlanDayActivity.class);
            startActivity(i);
        }
    }
}
