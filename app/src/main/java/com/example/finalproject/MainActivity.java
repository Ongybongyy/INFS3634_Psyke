package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.game.GameList;

public class MainActivity extends AppCompatActivity {
    public static final String NAME_TAG = "playerName";
    boolean inWide;
    Button startButton;
    Button helpButton;
    Button profileButton;
    private ImageView mImageView;

    public static final String EXTRA_MESSAGE = "com.example.finalproject.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        inWide = findViewById(R.id.scroll_view) != null;
        TextView title = findViewById(R.id.appName);
//        mImageView = findViewById(R.id.imageView);
        startButton = findViewById(R.id.enter_button);
        helpButton = findViewById(R.id.help_button);
        profileButton = findViewById(R.id.profile_button);
        final EditText nametext = (EditText) findViewById(R.id.input_name);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = nametext != null ? nametext.getText().toString() : "Player 1";
                Intent intent = new Intent(MainActivity.this, GameList.class);
                intent.putExtra(NAME_TAG, playerName);
                startActivity(intent);
            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = nametext != null ? nametext.getText().toString() : "Player 1";
                Intent intent = new Intent(MainActivity.this, HelpPage.class);
                intent.putExtra(NAME_TAG, playerName);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = nametext != null ? nametext.getText().toString() : "Player 1";
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra(NAME_TAG, playerName);
                startActivity(intent);
            }
        });
    }


}
