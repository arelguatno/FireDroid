package com.example.firedroid.firedroid.adapter;

/**
 * Created by aguatno on 8/9/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firedroid.firedroid.ChooseYourLevel;
import com.example.firedroid.firedroid.LeaderBoardScreen;
import com.example.firedroid.firedroid.MainActivity;
import com.example.firedroid.firedroid.R;
import com.example.firedroid.firedroid.java_objects.User;

import java.util.ArrayList;

public class LeaderBoardRecyclerAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerAdapter.ViewHolder> {

    ArrayList<User> users;
    private LeaderBoardScreen leaderBoardScreen;

    public LeaderBoardRecyclerAdapter(ArrayList<User> users, LeaderBoardScreen leaderBoardScreen) {
        this.users = users;
        this.leaderBoardScreen = leaderBoardScreen;
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public TextView currentStars;
        public TextView rank_number;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            currentStars = (TextView)itemView.findViewById(R.id.currentStars);
            rank_number = (TextView)itemView.findViewById(R.id.rank_number);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.leader_board_card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(users.get(i).getName());
        viewHolder.itemDetail.setText(users.get(i).getRank());

        Glide.with(leaderBoardScreen)
                .load(users.get(i).getPhotoUrl())
                .into(viewHolder.itemImage);
      //  viewHolder.itemImage.setImageResource(R.drawable.android);
        viewHolder.currentStars.setText(String.valueOf(users.get(i).getStars()));
        viewHolder.rank_number.setText(String.valueOf(i+1));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}