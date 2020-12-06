package com.example.mysubmission_keyboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerViewMain;
    public ArrayList<ItemData> itemDataArrayList = new ArrayList<>();
    private String title = "Mechanical Keyboard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetActionBarTitle(title);

        recyclerViewMain = findViewById(R.id.recycler_view_main);
        recyclerViewMain.setHasFixedSize(true);

        itemDataArrayList.addAll(Data.GetListData());
        SetRecyclerListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, AboutMe.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    private void SetRecyclerListView(){
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        AdapterListView adapterListView = new AdapterListView(itemDataArrayList);
        recyclerViewMain.setAdapter(adapterListView);
    }

    private void SetActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }


}
