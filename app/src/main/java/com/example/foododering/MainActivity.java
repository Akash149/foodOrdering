package com.example.foododering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, signup;
    View skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        login = findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login has been clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Signing_Activity.class);
                startActivity(intent);
            }
        });

        signup = findViewById(R.id.btnregister);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signup_Activity.class);
                startActivity(intent);
            }
        });

        skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("Food ordering","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Food ordering");
                    builder.setContentTitle("Food ordering");
                    builder.setContentText("You can order food from here");
                    builder.setSmallIcon(R.drawable.fblogo);
                    builder.setAutoCancel(false);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                    managerCompat.notify(1,builder.build());
                }
                Toast.makeText(MainActivity.this, "skip has been clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Welcome_Activity.class);
                startActivity(intent);
            }
        });
    }
}