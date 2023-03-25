package com.example.assignmenttm1.ui.game;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttm1.R;

import java.util.Vector;


public class GameActivity extends AppCompatActivity {

    RecyclerView gameRecycler;
    Vector<Game> games;
    GameAdapter gameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_game);

        gameRecycler = findViewById(R.id.gameRv);

        games = new Vector<>();
        games.add(new Game("ic_menu_noodle","Noodle Night","Horror",20000));
        games.add(new Game("ic_menu_chicken","Fried Chicken","Adventure",25000));
        games.add(new Game("ic_menu_rice","Fried Rice","Casual",22000));
        games.add(new Game("ic_menu_egg","Fried Egg","Casual",6000));

        gameAdapter = new GameAdapter(this);
        gameAdapter.setvGame(games);

        gameRecycler.setAdapter(gameAdapter);

        gameRecycler.setLayoutManager(new GridLayoutManager(this, 2));

    }


}