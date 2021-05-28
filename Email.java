package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
EditText receip,sub,email;
Button sendemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        receip=(EditText)findViewById(R.id.edtemalto);
        sub=(EditText)findViewById(R.id.edtemalsub);
        email=(EditText)findViewById(R.id.edtemalmsg);
        sendemail=(Button) findViewById(R.id.btnemail);
        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to =receip.getText().toString();
                String subject =sub.getText().toString();
                String message =email.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_SUBJECT,subject);
                intent.putExtra(intent.EXTRA_TEXT,message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"choose an email client:"));
            }
        });
    }
}
