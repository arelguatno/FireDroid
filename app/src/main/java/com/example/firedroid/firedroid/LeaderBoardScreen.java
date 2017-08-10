package com.example.firedroid.firedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.firedroid.firedroid.adapter.LeaderBoardRecyclerAdapter;
import com.example.firedroid.firedroid.adapter.RecyclerAdapter;
import com.example.firedroid.firedroid.java_objects.Questions;
import com.example.firedroid.firedroid.java_objects.User;
import com.example.firedroid.firedroid.utility.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderBoardScreen extends BaseActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board_screen);

        final ArrayList<User> users = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        recyclerView =
                (RecyclerView) findViewById(R.id.leader_recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mDatabase.child(Constants.DB_NODE_USERS_PROFILE).orderByChild("stars").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users.clear();
                Log.d("arel", String.valueOf(dataSnapshot.getChildrenCount()));
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User r = postSnapshot.getValue(User.class);
                    users.add(r);
                }

                Collections.reverse(users);
                adapter = new LeaderBoardRecyclerAdapter(users, LeaderBoardScreen.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
