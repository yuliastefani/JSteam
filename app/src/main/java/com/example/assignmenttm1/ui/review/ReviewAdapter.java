package com.example.assignmenttm1.ui.review;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmenttm1.R;
import com.example.assignmenttm1.ui.game.GameAdapter;

import java.util.Vector;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{

    Context ctx;
    Vector<Review> vReview;
    Dialog dialog;
    AlertDialog.Builder builder;


    public ReviewAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setvReview(Vector<Review> vReview) {
        this.vReview = vReview;
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.review_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String gameImageIDName = vReview.get(position).getGameImageID();
        int gameImageID = ctx.getResources().getIdentifier(gameImageIDName, "drawable", ctx.getPackageName());
        holder.gameImageIDTxt.setImageResource(gameImageID);
        holder.gameNameTxt.setText(vReview.get(position).getGameName());
        holder.userNameTxt.setText(vReview.get(position).getUserName());
        holder.gameCommentTxt.setText(vReview.get(position).getGameComment());
        holder.btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(ctx);
                dialog.setContentView(R.layout.update_dialog);

                EditText edt_gameComment = dialog.findViewById(R.id.edt_gameComment);
                Button btn_update = dialog.findViewById(R.id.btn_update_dialog);

                btn_update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edt_gameComment.getText().toString().isEmpty()) {
                            Toast.makeText(ctx, "Please enter your comment update!", Toast.LENGTH_SHORT).show();

                        }else {
                            String gameComment = edt_gameComment.getText().toString();
                            vReview.get(position).setGameComment(gameComment);
                        }

                        notifyDataSetChanged();
                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Delete Review");
                builder.setCancelable(true);
                builder.setMessage("Are you sure you want to delete this review?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    vReview.remove(position);
                    notifyDataSetChanged();
                });
                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return vReview.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gameImageIDTxt;
        TextView gameNameTxt, userNameTxt, gameCommentTxt;
        CardView cardView;
        EditText edt_gameComment;
        Button btn_update, btn_update_dialog, btn_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImageIDTxt = itemView.findViewById(R.id.gameImageIDTxt);
            gameNameTxt = itemView.findViewById(R.id.gameNameTxt);
            userNameTxt = itemView.findViewById(R.id.userNameTxt);
            gameCommentTxt = itemView.findViewById(R.id.gameCommentTxt);
            edt_gameComment = itemView.findViewById(R.id.edt_gameComment);
            btn_update = itemView.findViewById(R.id.btn_update);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_update_dialog = itemView.findViewById(R.id.btn_update_dialog);
            builder = new AlertDialog.Builder(ctx);
            cardView = itemView.findViewById(R.id.reviewCV);
        }
    }
}
