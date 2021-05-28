package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class call extends AppCompatActivity {
EditText edtcall;
String  num;
Button pcall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        edtcall =(EditText)findViewById(R.id.edtpncall);
        pcall =(Button)findViewById(R.id.btnphncall);
        pcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                num=edtcall.getText().toString();
                if(num.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(),"please inset phone number ", Toast.LENGTH_SHORT).show();
                }
                else{
                    intent.setData(Uri.parse("tel:"+num));
                }
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"please grant permision",Toast.LENGTH_SHORT).show();
                    requestPermission();

                }else{
                    startActivity(intent);
                }
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(call.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }

}
