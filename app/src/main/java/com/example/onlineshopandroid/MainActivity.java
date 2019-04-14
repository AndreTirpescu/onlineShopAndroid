package com.example.onlineshopandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.onlineshopandroid.product.Product;
import com.example.onlineshopandroid.product.ProductCollection;
import com.example.onlineshopandroid.product.ProductCollectionBuilder;
import android.view.Menu;


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.home_menu:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("You are already home")
                        .setTitle("Alert");
                alertDialogBuilder.create().show();
                break;
            case R.id.about_menu:
                Intent intent = new Intent(getApplicationContext(), AppInfoActivity.class);
                getApplicationContext().startActivity(intent);
                break;
            case R.id.login_menu:
                AlertDialog.Builder secondAlertBuilder = new AlertDialog.Builder(this);
                LayoutInflater layoutInflater = getLayoutInflater();

                secondAlertBuilder.setView(layoutInflater.inflate(R.layout.login_dialog, null))
                    .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

                secondAlertBuilder.create().show();
                break;
            case R.id.settings_menu:
                Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                getApplicationContext().startActivity(settingsIntent);
                break;
            case R.id.notes_menu:
                Intent notesIntent = new Intent(getApplicationContext(), NotesActivity.class);
                getApplicationContext().startActivity(notesIntent);
                break;
            case R.id.sensors_menu:
                Intent sensorsIntent = new Intent(getApplicationContext(), SensorActivity.class);
                getApplicationContext().startActivity(sensorsIntent);
                break;
            case R.id.camera_menu:
                Intent cameraIntent = new Intent(getApplicationContext(), CameraActivity.class);
                getApplicationContext().startActivity(cameraIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}
