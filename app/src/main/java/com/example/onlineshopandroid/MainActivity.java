package com.example.onlineshopandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    static final String MAIN_ACTIVITY_TAG = "[MAIN_ACTIVITY]";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductCollection products = new ProductCollectionBuilder().build();

        ListView productListView = (ListView) findViewById(R.id.products);
        productListView.setAdapter(new ProductTitleAndHypeAdapter(getApplicationContext(), products));
        productListView.setOnItemClickListener(new ProductHypeClickListener(getApplicationContext(), products));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(MAIN_ACTIVITY_TAG, "onStart called");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(MAIN_ACTIVITY_TAG, "onResume called");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(MAIN_ACTIVITY_TAG, "onPause called");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(MAIN_ACTIVITY_TAG, "onStop called");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(MAIN_ACTIVITY_TAG, "onDestroy called");
    }
}
