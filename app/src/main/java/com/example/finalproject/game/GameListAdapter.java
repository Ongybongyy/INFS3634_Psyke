package com.example.finalproject.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {
    private Context parentActivity;
    private List<Game> gameList;
    public static final String GAME_NAME_TAG = "gameName";
    private View.OnClickListener mListener;


    public GameListAdapter(Activity activity, List<Game> gameList, String player) {
        this.parentActivity = activity;
        this.gameList = gameList;
        this.mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game game = (Game) v.getTag();
                Context context = v.getContext();
                Intent intent = new Intent(context, GameLevelsActivity.class);
                intent.putExtra(GAME_NAME_TAG, game.getName());
                intent.putExtra(MainActivity.NAME_TAG, player);
                context.startActivity(intent);
            }
        };
    }


    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_list_item, viewGroup, false);
        return new GameViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final GameViewHolder holder, int pos) {
        Game game = gameList.get(pos);
        Glide.with(holder.itemView)
                .load(game.getImageId())
                .fitCenter()
                .into(holder.gameImage);
        holder.name.setText(game.getName());
        holder.itemView.setTag(game);
        holder.itemView.setOnClickListener(mListener);
    }


    public static class GameViewHolder extends RecyclerView.ViewHolder {

        ImageView gameImage;    //image of game
        TextView name, score, gameLevels;

        public GameViewHolder(@NonNull View v) {
            super(v);

            name = v.findViewById(R.id.topicName);
            score = v.findViewById(R.id.currentScore);
            gameLevels = v.findViewById(R.id.topicLevel);
            gameImage = v.findViewById(R.id.levelImage);
        }
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }
}
