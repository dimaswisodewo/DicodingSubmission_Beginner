package com.example.mysubmission_keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AboutMe extends AppCompatActivity {

    private ImageView photo;
    private TextView name;
    private TextView email;
    private String title = "About Me";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        SetActionBarTitle(title);
            photo = findViewById(R.id.photo_about);
            name = findViewById(R.id.name_about);
            email = findViewById(R.id.email_about);

            Glide.with(this).load(R.drawable.profile_pic).into(photo);
            name.setText(R.string.about_name);
            email.setText(R.string.about_email);

    }

    private void SetActionBarTitle (String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
