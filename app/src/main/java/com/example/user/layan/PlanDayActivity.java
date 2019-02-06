package com.example.user.layan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PlanDayActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    Button countryButton, citiesButton, addPinButton;
    EditText descriptionDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_day);

        countryButton= (Button) findViewById(R.id.countryButton);
        citiesButton= (Button) findViewById(R.id.citiesButton);
        descriptionDay= (EditText) findViewById(R.id.descriptionDay);
        addPinButton= (Button) findViewById(R.id.addPinButton);

        countryButton.setOnClickListener(this);
        citiesButton.setOnClickListener(this);
        addPinButton.setOnClickListener(this);


    }


    public void showCountryAlertDialogButtonClicked(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a country");

        // add a radio button list
        String[] countries = {"flag", "Spain", "France", "Portugal", "Greece", "United States", "China", "Turkey", "Germany", "South Africa", "Thailand"};
        int checkedItem = 1; // flag
        builder.setSingleChoiceItems(countries, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user checked an item
            }
        });

        // add OK and Cancel buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user clicked OK
            }
        });
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showCityAlertDialogButtonClicked(View view) {

        // setup the alert builder
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Choose a city");

        // add a radio button list
        String[] cities = {"Paris", "London", "Berlin", "Tokyo", "Oslo", "Madrid", "Rome", "Jericho"};
        int checkedItem = 1; // flag
        builder2.setSingleChoiceItems(cities, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user checked an item
            }
        });

        // add OK and Cancel buttons
        builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user clicked OK
            }
        });
        builder2.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog2 = builder2.create();
        dialog2.show();
    }

    @Override
    public void onClick(View v) {
        if(v==addPinButton) {
            Intent i = new Intent(this, PlanTripActivity.class);
            TripDay tripDay = new TripDay("country", "city", "day1", R.drawable.flag);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("Users");
            reference.child("Trip").child("days").push().setValue(tripDay);
            startActivity(i);
        }
        if(v==countryButton){
            showCountryAlertDialogButtonClicked(v);
        }
        if(v==citiesButton){
            showCityAlertDialogButtonClicked(v);
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
