package com.example.assignmenttm1.ui.game;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
