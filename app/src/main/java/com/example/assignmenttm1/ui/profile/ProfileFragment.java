package com.example.assignmenttm1.ui.profile;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignmenttm1.MainActivity;
import com.example.assignmenttm1.R;
import com.example.assignmenttm1.ui.about.AboutFragment;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    TextView tv_user, tv_em, tv_phone, tv_reg;
    String user, pass, em, phone, reg;
    Intent intent;
    Button btn_logout;
    AlertDialog.Builder builder;


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intent = getActivity().getIntent();
        user = intent.getStringExtra("username");
        em = intent.getStringExtra("email");
        phone = intent.getStringExtra("phoneNumber");
        reg = intent.getStringExtra("region");

        tv_user = view.findViewById(R.id.tv_user);
        tv_em = view.findViewById(R.id.tv_em);
        tv_phone = view.findViewById(R.id.tv_phone);
        tv_reg = view.findViewById(R.id.tv_reg);

        tv_user.setText("Username     : " + user);
        tv_em.setText("Email        : "+  em);
        tv_phone.setText("Phone Number : " + phone);
        tv_reg.setText("Region       : " + reg);

        btn_logout = view.findViewById(R.id.btn_logout);
        builder = new AlertDialog.Builder(getContext());

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Are you sure you want to logout?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    Intent toLanding = new Intent(getContext(), MainActivity.class);
                    startActivity(toLanding);
                });
                builder.setNegativeButton("No", (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}