package com.example.c4q.sharedprefernces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);// here we want to access the intent that brought us here.
        TextView textView=(TextView) findViewById(R.id.session_message_textview);
        Intent intent= getIntent();// step 1 is to get the intent
        String User= intent.getStringExtra("currentUSer");//we get the string
        textView.setText("you are currently signed in as "  + User);



    }
}
