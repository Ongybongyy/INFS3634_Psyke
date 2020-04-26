package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.finalproject.game.Game;
import com.example.finalproject.game.GameListAdapter;


public class LevelDetailFragment extends Fragment {
    public static final String TAG = "LevelDetailFragment";
    public static Game game;

    private String player;
    private String level;

    public LevelDetailFragment() {
        // Required empty public constructor
    }

//    public static LevelDetailFragment newInstance(String param1, String param2) {
//        return new LevelDetailFragment();
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = Game.getGames().get(getArguments().getString(GameListAdapter.GAME_NAME_TAG));
        player = getArguments().getString(MainActivity.NAME_TAG);
        if (player == null) player = "";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.math_level_detail, container, false);
        ((TextView) v.findViewById(R.id.playerNameDetail)).setText("Welcome " + player + "!");

        ImageView gameImage = (ImageView) v.findViewById(R.id.detailImageView);
        Glide.with(this)
                .load(game.getImageId())
                .fitCenter()
                .into(gameImage);

        v.findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(MainActivity.NAME_TAG, player);
                intent.putExtra(GameListAdapter.GAME_NAME_TAG, game.getName());
                startActivity(intent);
            }
        });
        return v;
    }

}
