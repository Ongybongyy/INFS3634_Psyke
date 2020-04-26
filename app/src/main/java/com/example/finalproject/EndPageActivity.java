package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.game.GameLevelsActivity;
import com.example.finalproject.game.GameList;
import com.example.finalproject.game.GameListAdapter;

import java.util.logging.Level;

public class EndPageActivity extends AppCompatActivity {
    private Button mButton,mRestart;
    private TextView mScoreDisplay,mMarking;
    private int score;
    private int numCorrect;
    private int numQuestions;
    private String player;
    private String gameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);
        Intent intent = getIntent();
        score = intent.getIntExtra(GameLevelsActivity.SCORE_TAG, 0);
        numQuestions = intent.getIntExtra(GameLevelsActivity.NUM_Q_TAG, 10);
        numCorrect = intent.getIntExtra(GameLevelsActivity.MARK_TAG, 0);
        gameName = intent.getStringExtra(GameListAdapter.GAME_NAME_TAG);
        player = intent.getStringExtra(MainActivity.NAME_TAG);
        updateUi();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, GameList.class);
        intent.putExtra(MainActivity.NAME_TAG, player);
        startActivity(intent);
    }

    private void updateUi(){
        mScoreDisplay = findViewById(R.id.scoreEP);
        mMarking = findViewById(R.id.markingEP);
        mButton = findViewById(R.id.menuButton);
        mRestart = findViewById(R.id.restartGamebtn);

        StringBuffer markMessage = new StringBuffer();
        markMessage.append("You got " + numCorrect + "/" + numQuestions + " questions correct!\n");

        mScoreDisplay.setText("" + score);
        mMarking.setText(markMessage);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra(MainActivity.NAME_TAG, player);
                intent.putExtra(GameListAdapter.GAME_NAME_TAG, gameName);
                startActivity(intent);
            }
        });
    }
}
