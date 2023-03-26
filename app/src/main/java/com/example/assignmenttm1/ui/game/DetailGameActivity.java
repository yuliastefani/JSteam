package com.example.assignmenttm1.ui.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignmenttm1.R;

import java.time.Instant;

public class DetailGameActivity extends AppCompatActivity {

    public static final String detGame = "detGame";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_game);

        ImageView gameImageIDTxt = findViewById(R.id.gameImageIDTxt);
        TextView gameNameTxt = findViewById(R.id.gameNameTxt);
        TextView gameGenreTxt = findViewById(R.id.gameGenreTxt);
        TextView gameRatingTxt = findViewById(R.id.gameRatingTxt);
        TextView gamePriceTxt = findViewById(R.id.gamePriceTxt);
        TextView gameDescTxt = findViewById(R.id.gameDescTxt);

        if (getIntent().getExtras() != null) {
            Game game = getIntent().getParcelableExtra(detGame, Game.class);
            String gameImageIDName = game.getGameImageID();
            int gameImageID = getResources().getIdentifier(gameImageIDName, "drawable", getPackageName());
            gameImageIDTxt.setImageResource(gameImageID);
            gameNameTxt.setText(game.getGameName());
            gameGenreTxt.setText(game.getGameGenre());
            gameRatingTxt.setText(game.getGameRating());
            gamePriceTxt.setText(String.valueOf(game.getGamePrice()));
            gameDescTxt.setText(game.getGameDesc());
        }


    }
}