package com.example.foododering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Signing_Activity extends AppCompatActivity {
    View btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signining);

        getSupportActionBar().setTitle("Sign in");

        btn = findViewById(R.id.caccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents = new Intent(Signing_Activity.this,Signup_Activity.class);
                startActivity(intents);
            }
        });

    }
}