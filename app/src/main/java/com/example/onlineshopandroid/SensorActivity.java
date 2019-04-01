package com.example.onlineshopandroid;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private List<Sensor> sensorList;
    private ListView sensorListView;
    private LocationManager locationManager;
    private TextView gpsInfo;
    private LocationListener gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorListView = (ListView) findViewById(R.id.sensor_layout_list);
        sensorListView.setAdapter(new SensorListAdapter(getApplicationContext(), sensorList));
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        gpsInfo = (TextView) findViewById(R.id.gps_info);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET}, 10);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, new GpsLocationListener(gpsInfo));
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            gpsInfo.setText( "Latitude " + lastKnownLocation.getLatitude() + " Longitude: " + lastKnownLocation.getLongitude() + " Altitude " + lastKnownLocation.getAltitude() );
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
