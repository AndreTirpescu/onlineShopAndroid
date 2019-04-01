package com.example.onlineshopandroid;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

public class GpsLocationListener implements LocationListener
{
    private TextView gpsInfo;

    public GpsLocationListener(TextView text)
    {
        this.gpsInfo = text;
    }

    @Override
    public void onLocationChanged(Location location)
    {
        gpsInfo.setText( "Latitude " + location.getLatitude() + " Longitude: " +
                location.getLongitude() + " Altitude " + location.getAltitude() );
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }
}
