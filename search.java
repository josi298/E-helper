package com.example.helper;

import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

public class search extends AppCompatActivity {

    private EditText mSearchField;
    private TextView mSearchBtn;

    private RecyclerView mResultList;

    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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

    }

    private void firebaseUserSearch(String searchText) {

        Toast.makeText(search.this, "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mUserDatabase.orderByChild("type").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Users, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, UsersViewHolder>(

                Users.class,
                R.layout.lists,
                UsersViewHolder.class,
               firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder viewHolder, Users model, int position) {


                viewHolder.setDetails(model.getFName(),model.getPassword(), model.getEmail(), model.getPhoneNumber(), model.getCity(),model.getType(),model.getLname());

            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);

    }


    // View Holder Class

    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDetails(String studentFName, String studentEmail , String studentType ,String studentPhoneNumber , String studentCity , String lname , String password ){

            TextView user_name = (TextView) mView.findViewById(R.id.fname);
            TextView user_status = (TextView) mView.findViewById(R.id.phone_number);
            TextView email = (TextView) mView.findViewById(R.id.email);
            TextView city = (TextView) mView.findViewById(R.id.city);
            TextView type = (TextView) mView.findViewById(R.id.type);




            user_name.setText(studentFName);
            email.setText(studentEmail);
            type.setText(studentType);
            user_status.setText(studentPhoneNumber);
            city.setText(studentCity);





        }




    }

}