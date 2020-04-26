package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Profile extends AppCompatActivity {

    private Button profileHomeButton;
    private Button profileHelpButton;
    private String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        Intent intent = getIntent();
        player = intent.getStringExtra(MainActivity.NAME_TAG);

        profileHomeButton = findViewById(R.id.phButton);
        profileHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        profileHelpButton = findViewById(R.id.phelpButton);
        profileHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelp();
            }
        });

        TextView playerText = findViewById(R.id.player);
        playerText.setText(player);

    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openHelp() {
        Intent intent = new Intent(this, HelpPage.class);
        startActivity(intent);
    }

}

