package com.example.assignmenttm1.ui.game;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttm1.R;

import java.util.Vector;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder>{

    Context ctx;
    Vector<Game> vGame;

    public GameAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setvGame(Vector<Game> vGame) {
        this.vGame = vGame;
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.game_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position) {
        String gameImageIDName = vGame.get(position).getGameImageID();
        int gameImageID = ctx.getResources().getIdentifier(gameImageIDName, "drawable", ctx.getPackageName());
        holder.gameImageIDTxt.setImageResource(gameImageID);
        holder.gameNameTxt.setText(vGame.get(position).getGameName());
        holder.gameGenreTxt.setText(vGame.get(position).getGameGenre());
        holder.gamePriceTxt.setText(String.valueOf(vGame.get(position).getGamePrice()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailGameIntent = new Intent(ctx, DetailGameActivity.class);
                detailGameIntent.putExtra(DetailGameActivity.detGame, vGame.get(position));
                ctx.startActivity(detailGameIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vGame.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gameImageIDTxt;
        TextView gameNameTxt, gameGenreTxt, gamePriceTxt;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImageIDTxt = itemView.findViewById(R.id.gameImageIDTxt);
            gameNameTxt = itemView.findViewById(R.id.gameNameTxt);
            gameGenreTxt = itemView.findViewById(R.id.gameGenreTxt);
            gamePriceTxt = itemView.findViewById(R.id.gamePriceTxt);
            cardView = itemView.findViewById(R.id.gameCV);
        }
    }

}
