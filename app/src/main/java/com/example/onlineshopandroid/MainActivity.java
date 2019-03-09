package com.example.onlineshopandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductCollection products = new ProductCollectionBuilder().build();

        ListView productListView = (ListView) findViewById(R.id.products);
        productListView.setAdapter(new ProductTitleAndHypeAdapter(getApplicationContext(), products));
        productListView.setOnItemClickListener(new ProductHypeClickListener(getApplicationContext(), products));
    }
}
