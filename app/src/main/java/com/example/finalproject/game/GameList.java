package com.example.finalproject.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

import java.util.ArrayList;

public class GameList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        final String player = getIntent().getStringExtra(MainActivity.NAME_TAG);
        setTitle("Games");

        RecyclerView recyclerView = findViewById(R.id.gameList);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(GameList.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Game> gameList = new ArrayList<>(Game.getGames().values());
        RecyclerView.Adapter adapter = new GameListAdapter(this, gameList, player);
        recyclerView.setAdapter(adapter);
    }
}
