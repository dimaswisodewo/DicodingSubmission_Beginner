package com.example.mysubmission_keyboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ItemDetails extends AppCompatActivity {

    private ImageView imageDetail;
    private TextView titleDetail;
    private TextView descriptionDetail;
    private TextView priceDetail;

    public static String imageUrl = "image url";
    public static String title = "title";
    public static String description = "description";
    public static String price = "price";
    private String actionBarTitle = "Details";

    private Bundle bundle;
//    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        SetActionBarTitle(actionBarTitle);

//        if(savedInstanceState != null){
//            savedInstanceState.getBundle(bundle);
//        }

        imageDetail = findViewById(R.id.image_detail);
        titleDetail = findViewById(R.id.title_detail);
        descriptionDetail = findViewById(R.id.description_detail);
        priceDetail = findViewById(R.id.price_detail);

        imageUrl = getIntent().getStringExtra(imageUrl);
        Glide.with(this).load(imageUrl).into(imageDetail);
        titleDetail.setText(getIntent().getStringExtra(title));
        descriptionDetail.setText(getIntent().getStringExtra(description));
        priceDetail.setText(getIntent().getStringExtra(price));

    }

    private void SetActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);

        }
    }

    private void SetDisplay(){
        imageUrl = getIntent().getStringExtra(imageUrl);
        Glide.with(this).load(imageUrl).into(imageDetail);
        titleDetail.setText(getIntent().getStringExtra(title));
        descriptionDetail.setText(getIntent().getStringExtra(description));
        priceDetail.setText(getIntent().getStringExtra(price));
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
//        outState.putString(STATE_RESULT, SetDisplay());
        bundle.putAll(outState);
    }


}
