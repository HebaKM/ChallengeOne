package com.example.hebam.challengeone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutButton = findViewById(R.id.aboutButton);
        //adds a listener to the aboutButton
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starts ActivityB
                startActivity(new Intent(MainActivity.this, ActivityB.class));

            }
        });

        Button profileButton = findViewById(R.id.profileButton);
        //adds a listener to the profileButton
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starts ActivityC
                startActivity(new Intent(MainActivity.this, ActivityC.class));

            }
        });
    }
}
