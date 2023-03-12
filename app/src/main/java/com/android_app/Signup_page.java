package com.android_app;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.BreakIterator;


public class Signup_page extends AppCompatActivity {

    private ImageView imageView;
    private Button button;

    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        imageView = findViewById(R.id.capturedImage);// find the image location
        button = findViewById(R.id.OpenCamera); // find the button of camara
        Login = (Button) findViewById(R.id.Login); // back to login page button

        EditText username = (EditText) findViewById(R.id.Username);// put the user name for the first time

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                someActivityResultLauncher.launch(open_camera);

                String username1 = username.getText().toString();
                Toast.makeText(Signup_page.this,"Registration Successful"+username1, Toast.LENGTH_LONG).show();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }

            private void openLoginPage() {
                Intent intent = new Intent(Signup_page.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }


    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        Bitmap photo = (Bitmap)data.getExtras().get("data");
                        imageView.setImageBitmap(photo);
                    }
                }
            });



}

