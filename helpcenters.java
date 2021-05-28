package com.example.helper;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class helpcenters extends AppCompatActivity {
   private TextView ambulance, firehouse, traffic;
    private Context mContext;
    private Activity mActivity;


    private TextView mBtnDoTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpcenters);
        // Get the application context
        mContext = getApplicationContext();
        mActivity =helpcenters.this;
        ambulance = (TextView) findViewById(R.id.ambulance);
        firehouse = (TextView) findViewById(R.id.firehouse);
        traffic = (TextView) findViewById(R.id.traffic);
        // Get the widget reference from xml layout

        mBtnDoTask = findViewById(R.id.police);

        // Set a click listener for the button
        mBtnDoTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialer();
            }
        });
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDia();
            }
        });
        traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openD();
            }
        });







    }
    protected void openDialer(){
        /*
            Intent
                An intent is an abstract description of an operation to be performed. It can be
                used with startActivity to launch an Activity, broadcastIntent to send it to any
                interested BroadcastReceiver components, and startService(Intent) or
                bindService(Intent, ServiceConnection, int) to communicate with a background Service.

                An Intent provides a facility for performing late runtime binding between the code
                in different applications. Its most significant use is in the launching of
                activities, where it can be thought of as the glue between activities.
                It is basically a passive data structure holding an abstract description
                of an action to be performed.
        */
        /*
            String ACTION_DIAL
                Activity Action: Dial a number as specified by the data. This shows a UI with
                the number being dialed, allowing the user to explicitly initiate the call.

                Input: If nothing, an empty dialer is started; else getData() is URI of a phone
                number to be dialed or a tel: URI of an explicit phone number.

                Output: nothing.

                Constant Value: "android.intent.action.DIAL"
        */
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        intent.setData(Uri.parse("tel:" + "+954"));
        // Start the dialer app activity with number
        startActivity(intent);
    }
    protected void openDia(){
        /*
            Intent
                An intent is an abstract description of an operation to be performed. It can be
                used with startActivity to launch an Activity, broadcastIntent to send it to any
                interested BroadcastReceiver components, and startService(Intent) or
                bindService(Intent, ServiceConnection, int) to communicate with a background Service.

                An Intent provides a facility for performing late runtime binding between the code
                in different applications. Its most significant use is in the launching of
                activities, where it can be thought of as the glue between activities.
                It is basically a passive data structure holding an abstract description
                of an action to be performed.
        */
        /*
            String ACTION_DIAL
                Activity Action: Dial a number as specified by the data. This shows a UI with
                the number being dialed, allowing the user to explicitly initiate the call.

                Input: If nothing, an empty dialer is started; else getData() is URI of a phone
                number to be dialed or a tel: URI of an explicit phone number.

                Output: nothing.

                Constant Value: "android.intent.action.DIAL"
        */
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        intent.setData(Uri.parse("tel:" + "+991"));
        // Start the dialer app activity with number
        startActivity(intent);
    }
    protected void openDi(){
        /*
            Intent
                An intent is an abstract description of an operation to be performed. It can be
                used with startActivity to launch an Activity, broadcastIntent to send it to any
                interested BroadcastReceiver components, and startService(Intent) or
                bindService(Intent, ServiceConnection, int) to communicate with a background Service.

                An Intent provides a facility for performing late runtime binding between the code
                in different applications. Its most significant use is in the launching of
                activities, where it can be thought of as the glue between activities.
                It is basically a passive data structure holding an abstract description
                of an action to be performed.
        */
        /*
            String ACTION_DIAL
                Activity Action: Dial a number as specified by the data. This shows a UI with
                the number being dialed, allowing the user to explicitly initiate the call.

                Input: If nothing, an empty dialer is started; else getData() is URI of a phone
                number to be dialed or a tel: URI of an explicit phone number.

                Output: nothing.

                Constant Value: "android.intent.action.DIAL"
        */
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        intent.setData(Uri.parse("tel:" + "+912"));
        // Start the dialer app activity with number
        startActivity(intent);
    }
    protected void openD(){
        /*
            Intent
                An intent is an abstract description of an operation to be performed. It can be
                used with startActivity to launch an Activity, broadcastIntent to send it to any
                interested BroadcastReceiver components, and startService(Intent) or
                bindService(Intent, ServiceConnection, int) to communicate with a background Service.

                An Intent provides a facility for performing late runtime binding between the code
                in different applications. Its most significant use is in the launching of
                activities, where it can be thought of as the glue between activities.
                It is basically a passive data structure holding an abstract description
                of an action to be performed.
        */
        /*
            String ACTION_DIAL
                Activity Action: Dial a number as specified by the data. This shows a UI with
                the number being dialed, allowing the user to explicitly initiate the call.

                Input: If nothing, an empty dialer is started; else getData() is URI of a phone
                number to be dialed or a tel: URI of an explicit phone number.

                Output: nothing.

                Constant Value: "android.intent.action.DIAL"
        */
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        intent.setData(Uri.parse("tel:" + "+965"));
        // Start the dialer app activity with number
        startActivity(intent);
    }}