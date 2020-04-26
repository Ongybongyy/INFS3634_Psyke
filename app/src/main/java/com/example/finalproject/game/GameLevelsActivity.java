package com.example.finalproject.game;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.finalproject.LevelDetailFragment;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

public class GameLevelsActivity extends AppCompatActivity {
    public static final String SCORE_TAG = "score";
    public static final String MARK_TAG = "marks";
    public static final String NUM_Q_TAG = "numQs";
    private String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_levels);

        Intent intent = getIntent();

        if (intent.getBooleanExtra("API_ERROR", false)){
            Toast.makeText(getApplicationContext(), "Please wait a minute and try again.", Toast.LENGTH_SHORT).show();
        }

        final String gameName = intent.getStringExtra(GameListAdapter.GAME_NAME_TAG);
        setTitle(gameName);

        Fragment fragment = new LevelDetailFragment();
        player = intent.getStringExtra(MainActivity.NAME_TAG);

        Bundle args = new Bundle();
        args.putString(MainActivity.NAME_TAG, player);
        args.putString(GameListAdapter.GAME_NAME_TAG, gameName);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.game_view, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, GameList.class);
        intent.putExtra(MainActivity.NAME_TAG, player);
        startActivity(intent);
    }
}
