package com.android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private Button Signup; // the signup button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Signup = (Button) findViewById(R.id.Signup); // find the signup button

        EditText username = (EditText) findViewById(R.id.Username); // enter the user name

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup_page();
            }

            private void openSignup_page() {
                Intent intent = new Intent(LoginPage.this, Signup_page.class);
                startActivity(intent);
            }
        });



    }
}

