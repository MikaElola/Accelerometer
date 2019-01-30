package com.example.accelerometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm=(SensorManager)this.getSystemService(Context.SENSOR_SERVICE);

        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){}

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            float value[]=event.values;
            float x=value[0];
            float y=value[1];
            float z=value[2];

            float movement_shake=((x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*
                    SensorManager.GRAVITY_EARTH));

            if(movement_shake>=2)
            {

                Toast.makeText(this, "Shake detected" + "X value:" +  x  + "Y value: " + y +
                "Z value: " + z, Toast.LENGTH_SHORT).show();
            }
            else{
            }
        }
    }
}

