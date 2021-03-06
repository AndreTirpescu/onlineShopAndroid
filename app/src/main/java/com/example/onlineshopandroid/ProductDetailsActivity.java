package com.example.onlineshopandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        String name = getIntent().getStringExtra("PROD_NAME");
        String price = getIntent().getStringExtra("PROD_PRICE");
        String description = getIntent().getStringExtra("PROD_DESCRIPTION");
        String hype = getIntent().getStringExtra("PROD_HYPE");

        TextView nameView = (TextView) findViewById(R.id.name);
        nameView.setText(name);

        TextView priceView = (TextView) findViewById(R.id.price);
        priceView.setText(price);

        TextView descriptionView = (TextView) findViewById(R.id.description);
        descriptionView.setText(description);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
