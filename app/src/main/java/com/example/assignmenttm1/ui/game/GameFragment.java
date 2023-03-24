package com.example.assignmenttm1.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.assignmenttm1.R;

import java.util.Vector;

public class GameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    RecyclerView gameRecycler;
    Vector<Game> games;
    GameAdapter gameAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        // Inflate the layout for this fragment

        gameRecycler = rootView.findViewById(R.id.gameRv);

        games = new Vector<>();
        games.add(new Game("ic_menu_noodle","Noodle Night","Horror",20000));
        games.add(new Game("ic_menu_chicken","Fried Chicken","Adventure",25000));
        games.add(new Game("ic_menu_rice","Fried Rice","Casual",22000));
        games.add(new Game("ic_menu_egg","Fried Egg","Casual",6000));

        gameAdapter = new GameAdapter(this);
        gameAdapter.setvGame(games);

        gameAdapter.setAdapter(gameAdapter);

        gameAdapter.setLayoutManager(new GridLayoutManager(this, 2));

        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}