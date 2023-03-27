package com.example.assignmenttm1.ui.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignmenttm1.R;


public class DetailGameActivity extends AppCompatActivity {

    public static final String detGame = "detGame";
    AlertDialog.Builder builder;


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
        EditText gameComment = findViewById(R.id.et_gameComment);
        Button btn_comment = findViewById(R.id.btn_comment);

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

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Game Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = gameComment.getText().toString();
                if (comment.isEmpty()) {
                    Toast.makeText(DetailGameActivity.this, "Please enter your comment", Toast.LENGTH_SHORT).show();
                } else {
                    builder = new AlertDialog.Builder(DetailGameActivity.this);
                    builder.setMessage("Do you want to add this comment?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes", (dialog, which) -> {
                        Toast.makeText(DetailGameActivity.this, "Comment added", Toast.LENGTH_SHORT).show();
                    });
                    builder.setNegativeButton("No", (dialog, which) -> {
                        dialog.cancel();
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }


            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}