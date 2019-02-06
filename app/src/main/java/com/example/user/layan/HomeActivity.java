package com.example.user.layan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button goToSignInButton, goToSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        goToSignInButton = (Button) findViewById(R.id.goToSignInButton);
        goToSignUpButton = (Button) findViewById(R.id.goToSignUpButton);

        goToSignInButton.setOnClickListener(this);
        goToSignUpButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;
        if (v == goToSignInButton) {
            i = new Intent(this, SignInActivity.class);
            startActivity(i);
        }
        else if (v==goToSignUpButton){
            i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }
}