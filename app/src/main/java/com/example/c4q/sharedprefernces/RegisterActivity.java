package com.example.c4q.sharedprefernces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private SharedPreferences registerPrefs;
    private EditText userName;
    private EditText password;
    private EditText confirmPassword;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.register_username_edittext);
        password = (EditText) findViewById(R.id.register_password_edittext);
        confirmPassword = (EditText) findViewById(R.id.confirm_password_edittext);
        submitButton = (Button) findViewById(R.id.submit_button);

        Intent intent = getIntent();
        registerPrefs = getApplicationContext().getSharedPreferences(intent.getStringExtra("testKey"), MODE_PRIVATE);
// So we name the sharedpreference, since in here we are getting save things from another activity in the name part
//I will put intent.getStringExtra("name of the intent we put in the other activity")
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = registerPrefs.edit();//A good way to remember is that the editor does most of the work
                //so with the Editor we are able to make changes to the data we recieved.
                if (userName.getText() != null &&
                        password.getText() != null &&
                        confirmPassword.getText() != null &&
                        password.getText().toString().equals(
                                confirmPassword.getText().toString()
                        )) {
                    editor.putString("user" + userName.getText().toString(), userName.getText().toString());
                    editor.putString("password" + userName.getText().toString(), password.getText().toString());
                    editor.commit();
                    onBackPressed();//this destroys the activity since it is added to shared preferences.
                }
            }
        });
    }
}
/*
SharedPreferences are great for storing data but not for organizing data
 */
