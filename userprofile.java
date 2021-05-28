package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userprofile extends AppCompatActivity {
    private TextView inputEmail, inputPassword ,inputfname,inputlname,inputphone,inputcity , inputtype;

private FirebaseDatabase firebaseDatabase;
private FirebaseAuth firebaseauth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);


        inputfname = (EditText) findViewById(R.id.firstname);
        inputlname = (EditText) findViewById(R.id.last_name);
        inputphone = (EditText) findViewById(R.id.phone);
        inputcity = (EditText) findViewById(R.id.city);
        inputEmail = (EditText) findViewById(R.id.email);
        inputtype = (EditText) findViewById(R.id.type);
        inputPassword = (EditText) findViewById(R.id.password);

        firebaseauth = FirebaseAuth.getInstance();

        String StudentRecordIDFromServer = databaseReference.push().getKey();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference(StudentRecordIDFromServer);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Client_details info = dataSnapshot.getValue(Client_details.class);
                inputfname.setText(info.getStudentFName());
                inputlname.setText(info.getStudentLName());
                inputcity.setText(info.getStudentCity());
                inputphone.setText(info.getStudentPhoneNumber());
                inputtype.setText(info.getStudentType());
                inputEmail.setText(info.getStudentEmail());
                inputPassword.setText(info.getStudentPassword());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(userprofile.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
