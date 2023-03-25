package com.example.assignmenttm1.ui.game;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private GamesHelper helper;
    RecyclerView gameRecycler;
    Vector<Game> games;
    GameAdapter gameAdapter;
    DatabaseHelper DB;

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
        gameRecycler = view.findViewById(R.id.gameRv);
        gameRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        gameAdapter = new GameAdapter(getContext());
        gameRecycler.setAdapter(gameAdapter);

        DB = new DatabaseHelper(getContext());


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