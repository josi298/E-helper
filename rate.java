package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class rate extends AppCompatActivity {
    float myrating = 0;
    private EditText mSearchField;
    private TextView mSearchBtn;

    private RecyclerView mResultList;

    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        mUserDatabase = FirebaseDatabase.getInstance().getReference("client_Details");


        mSearchField = (EditText) findViewById(R.id.search_field);
        mSearchBtn = (TextView) findViewById(R.id.search_btn);

        mResultList = (RecyclerView) findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String searchText = mSearchField.getText().toString();

                firebaseUserSearch(searchText);

            }
        });
        Button button = findViewById(R.id.ratebn);
        RatingBar ratingStars = findViewById(R.id.rs);


        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                int rating = (int) v;
                String message = null;
                myrating = ratingBar.getRating();
                switch (rating) {
                    case 1:
                        message = "sorry to hear that! :(";
                        break;
                    case 2:
                        message = "you always accept suggestion! ";
                        break;
                    case 3:
                        message = "Good enough! ";
                        break;
                    case 4:
                        message = "great thank you! ";
                        break;
                    case 5:
                        message = "Awesome! you are the best! ";
                        break;
                }
                Toast.makeText(rate.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rate.this, String.valueOf(myrating), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void firebaseUserSearch(String searchText) {

        Toast.makeText(rate.this, "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mUserDatabase.orderByChild("FName").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Users, rate.UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, rate.UsersViewHolder>(

                Users.class,
                R.layout.list,
                rate.UsersViewHolder.class,
                firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(rate.UsersViewHolder viewHolder, Users model, int position) {


                viewHolder.setDetails(model.getFName(),model.getLname());

            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);
    }
        public static class UsersViewHolder extends RecyclerView.ViewHolder {

            View mView;

            public UsersViewHolder(View itemView) {
                super(itemView);

                mView = itemView;

            }

            public void setDetails(String studentFName,String lname) {

                TextView user_name = (TextView) mView.findViewById(R.id.p);
                TextView ln =(TextView) mView.findViewById(R.id.e);

                user_name.setText(studentFName);
                ln.setText(lname);

            }


        }
    }
