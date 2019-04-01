package com.example.onlineshopandroid;

import android.content.Context;
import android.hardware.Sensor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SensorListAdapter extends ArrayAdapter<Sensor>
{
    private Context context;
    private LayoutInflater inflater;
    private List<Sensor> sensorList;

    public SensorListAdapter(Context context, List<Sensor> sensors)
    {
        super(context, 0, sensors);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.sensorList = sensors;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = this.inflater.inflate(R.layout.sensor_info, parent, false);
        Sensor sensor = this.sensorList.get(position);

        TextView title = (TextView) listItem.findViewById(R.id.sensor_name);
        title.setText(sensor.getName());

        TextView type = (TextView) listItem.findViewById(R.id.sensor_type);
        type.setText("Type " + sensor.getStringType());

        TextView power = (TextView) listItem.findViewById(R.id.sensor_power);
        power.setText("Power " + new Float(sensor.getPower()).toString() + "mA");

        TextView vendor = (TextView) listItem.findViewById(R.id.sensor_vendor);
        vendor.setText("Vendor " + sensor.getVendor());

        return listItem;
    }
}
