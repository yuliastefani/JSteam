package com.example.assignmenttm1.ui.review;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttm1.R;
import com.example.assignmenttm1.User;
import com.example.assignmenttm1.database.GamesHelper;
import com.example.assignmenttm1.database.ReviewHelper;
import com.example.assignmenttm1.database.UserHelper;
import com.example.assignmenttm1.databinding.FragmentReviewBinding;
import com.example.assignmenttm1.ui.about.AboutFragment;
import com.example.assignmenttm1.ui.game.Game;
import com.example.assignmenttm1.ui.game.GameAdapter;

import java.util.Vector;

public class ReviewFragment extends Fragment {

    RecyclerView reviewRecycler;
    Vector<Review> vReview;
    ReviewAdapter reviewAdapter;
    String user;
    Intent intent;
    Button btn_update, btn_delete;

    public ReviewFragment() {
        // Required empty public constructor
    }

    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intent = getActivity().getIntent();
        user = intent.getStringExtra("username");
        reviewRecycler = view.findViewById(R.id.reviewRV);

        Vector<Review> vReview = new Vector<>();
        ReviewHelper reviewHelper = new ReviewHelper(getContext());
        reviewHelper.open();
        vReview = reviewHelper.viewReview();
        reviewHelper.close();
        int viewId = vReview.get(0).getReviewID();
        int userId = vReview.get(0).getUserID();
        int gameId = vReview.get(0).getGameID();
        String reviewComment = vReview.get(0).getReviewComment();

        vReview = new Vector<>();
        vReview.add(new Review(viewId, gameId, userId, reviewComment));

        reviewAdapter = new ReviewAdapter(getContext());
        reviewAdapter.setvReview(vReview);
        reviewRecycler.setAdapter(reviewAdapter);
        reviewRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false);
    }
}