package com.example.helper;


import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class SignupActivity extends AppCompatActivity {


    private EditText inputEmail, inputPassword ,inputfname,inputlname,inputphone,inputcity , inputtype ,cpassword;

    private Button btnSignIn, btnSignUp, btnResetPassword;
    String fname,lname,phonenumber,type,city,email,password;

    Firebase firebase;
    public static final String Firebase_Server_URL = "https://helper-9c15a.firebaseio.com/";
    DatabaseReference databaseReference;
    public static final String Database_Path = "client_Details";
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    TextView mail ;
    AwesomeValidation awesomeValidation;
    private static final String[] jobs = {"electrician, computer maintainer , mobile maintainer ,doctor ,lecturer , police , driver , mechanic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Firebase.setAndroidContext(SignupActivity.this);

awesomeValidation = new AwesomeValidation(BASIC);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.type);
        ImageView imageView = (ImageView)findViewById(R.id.image1);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,jobs);
        autoCompleteTextView.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextView.showDropDown();
            }
        });
        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputfname = (EditText) findViewById(R.id.firstname);
        inputlname = (EditText) findViewById(R.id.last_name);
        inputphone = (EditText) findViewById(R.id.phone);
        inputcity = (EditText) findViewById(R.id.city);
        inputEmail = (EditText) findViewById(R.id.email);
        inputtype = (EditText) findViewById(R.id.type);
        inputPassword = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);

        awesomeValidation.addValidation(SignupActivity.this, R.id.firstname, "[a-zA-Z\\s]+", R.string.fnameerr);
        awesomeValidation.addValidation(SignupActivity.this, R.id.last_name, "[a-zA-Z\\s]+", R.string.lnameerr);
        awesomeValidation.addValidation(SignupActivity.this, R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.enameerr);
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(SignupActivity.this, R.id.password, regexPassword, R.string.passerr);
        awesomeValidation.addValidation(SignupActivity.this, R.id.cpassword, R.id.password, R.string.ppnameerr);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(awesomeValidation.validate()) {
                   city = inputcity.getText().toString().trim();
                   phonenumber = inputphone.getText().toString().trim();
                   lname = inputlname.getText().toString().trim();
                   fname = inputfname.getText().toString().trim();
                   type = inputtype.getText().toString().trim();
                   email = inputEmail.getText().toString().trim();
                   password = inputPassword.getText().toString().trim();

                   if (TextUtils.isEmpty(fname)) {
                       Toast.makeText(getApplicationContext(), "Enter First name!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   char[] chars = fname.toCharArray();

                   if (TextUtils.isEmpty(fname)) {
                       Toast.makeText(getApplicationContext(), "Enter First name!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   if (TextUtils.isEmpty(lname)) {
                       Toast.makeText(getApplicationContext(), "Enter last name!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   if (TextUtils.isEmpty(phonenumber)) {
                       Toast.makeText(getApplicationContext(), "Enter Phone number!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   if (TextUtils.isEmpty(city)) {
                       Toast.makeText(getApplicationContext(), "Enter your city name!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   if (TextUtils.isEmpty(type)) {
                       Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   if (TextUtils.isEmpty(email)) {
                       Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                       return;
                   }

                   if (TextUtils.isEmpty(password)) {
                       Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   if (phonenumber.length() != 10) {
                       Toast.makeText(getApplicationContext(), "incorrect phone number!", Toast.LENGTH_SHORT).show();
                       return;
                   }

                   if (password.length() < 6) {
                       Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                       return;
                   }


                   Client_details studentDetails = new Client_details();
                   // Adding name into class function object.
                   studentDetails.setStudentFName(fname);
                   studentDetails.setStudentLName(lname);
                   studentDetails.setStudentPhoneNumber(phonenumber);
                   studentDetails.setStudentType(type);
                   studentDetails.setStudentCity(city);
                   studentDetails.setStudentEmail(email);
                   studentDetails.setStudentPassword(password);

                   //create user
                   progressBar.setVisibility(View.VISIBLE);
                   auth.createUserWithEmailAndPassword(email, password)
                           .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   progressBar.setVisibility(View.GONE);
                                   if (task.isSuccessful()) {
                                       auth.getCurrentUser().sendEmailVerification()
                                               .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                   @Override
                                                   public void onComplete(@NonNull Task<Void> task) {
                                                       if (task.isSuccessful()) {
                                                           // Getting the ID from firebase database.
                                                           String StudentRecordIDFromServer = databaseReference.push().getKey();
                                                           FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                                           databaseReference = firebaseDatabase.getReference(StudentRecordIDFromServer);
                                                           // Adding the both name and number values using student details class object using ID.

                                                           Toast.makeText(SignupActivity.this, "Reigsterd successfully , please check your email for verification", Toast.LENGTH_SHORT).show();
                                                           inputEmail.setText("");
                                                           inputPassword.setText("");
                                                       } else {
                                                           Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                                       }

                                                   }
                                               });
                                   } else {
                                       Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                   }
                                   // If sign in fails, display a message to the user. If sign in succeeds
                                   // the auth state listener will be notified and logic to handle the
                                   // signed in user can be handled in the listener.
                                   if (!task.isSuccessful()) {
                                       Toast.makeText(SignupActivity.this, "incorrect email." + task.getException(),
                                               Toast.LENGTH_SHORT).show();
                                   } else {
                                       startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                       finish();
                                   }
                               }
                           });


                   // Showing Toast message after successfully data submit.
               }
               else{
                   Toast.makeText(SignupActivity.this, "Error." ,
                           Toast.LENGTH_SHORT).show();
               }
                }

                    });
                }








    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}