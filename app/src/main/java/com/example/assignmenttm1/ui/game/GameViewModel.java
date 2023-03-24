package com.example.assignmenttm1.ui.game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class GameViewModel extends ViewModel {

//    private final MutableLiveData<String> mText;

    public GameViewModel() {
        RecyclerView gameRecycler;
        Vector<Game> games;
        GameAdapter gameAdapter;

        gameRecycler = findViewById(R.id.foodRv);

        games = new Vector<>();
        games.add(new Game("ic_menu_noodle","Noodle Night","Horror",20000));
        games.add(new Game("ic_menu_chicken","Fried Chicken","Adventure",25000));
        games.add(new Game("ic_menu_rice","Fried Rice","Casual",22000));
        games.add(new Game("ic_menu_egg","Fried Egg","Casual",6000));

        gameAdapter = new GameAdapter(this);
        gameAdapter.setvGame(games);

        gameAdapter.setAdapter(gameAdapter);

        gameAdapter.setLayoutManager(new GridLayoutManager(this, 2));

    }

//    public LiveData<String> getText() {
//        return mText;
//    }
}