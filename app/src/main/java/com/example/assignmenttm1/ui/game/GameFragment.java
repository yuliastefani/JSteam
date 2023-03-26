package com.example.assignmenttm1.ui.game;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.assignmenttm1.R;
import com.example.assignmenttm1.database.DatabaseHelper;
import com.example.assignmenttm1.database.GamesHelper;

import java.util.Vector;

public class GameFragment extends Fragment {

    GamesHelper helper;
    RecyclerView gameRecycler;
    Vector<Game> games;
    GameAdapter gameAdapter;
    ImageView gameImageIDTxt;
    TextView gameNameTxt, gameGenreTxt, gamePriceTxt;

    public GameFragment() {
        // Required empty public constructor
    }


    public static GameFragment newInstance() {
        GameFragment fragment = new GameFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helper = new GamesHelper(getContext());
        helper.open();
        games = helper.viewGames();
        helper.close();

        gameRecycler = view.findViewById(R.id.gameRv);
        gameAdapter = new GameAdapter(getContext());
        gameAdapter.setvGame(games);
        gameRecycler.setAdapter(gameAdapter);
        gameRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        // Inflate the layout for this fragment

        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}