package com.example.foododering;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.foododering.R.id.alogin;

public class Signup_Activity extends AppCompatActivity {
    View log;
    EditText uname, ucontact, uaddress, uemail, upassword;
    Button register;
    DBHelper myDB;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().setTitle("Sign up");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        log = findViewById(R.id.alogin);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup_Activity.this, Signing_Activity.class);
                startActivity(intent);
            }
        });

        uname = findViewById(R.id.name);
        ucontact = findViewById(R.id.contact);
        uaddress = findViewById(R.id.address);
        uemail = findViewById(R.id.email);
        upassword = findViewById(R.id.password);
        register = findViewById(R.id.register);

        myDB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = uname.getText().toString();
                String contact = ucontact.getText().toString();
                String address = uaddress.getText().toString();
                String email = uemail.getText().toString();
                String password = upassword.getText().toString();

                if(name.equals("") || contact.equals("") ||
                address.equals("") || email.equals("") || password.equals("")) {
                    Toast.makeText(Signup_Activity.this,"fill all filed", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean usercheckResult = myDB.checkname(name);
                    if(usercheckResult == false) {
                        Boolean result = myDB.InsertData(name,contact,address,email,password);
                        if(result == true) {
                            Toast.makeText(Signup_Activity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            uname.setText("");
                            ucontact.setText("");
                            uaddress.setText("");
                            uemail.setText("");
                            upassword.setText("");
                        } else {
                            Toast.makeText(Signup_Activity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup_Activity.this, "user already exists.\n please sign in again",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}