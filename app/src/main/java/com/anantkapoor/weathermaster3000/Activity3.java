package com.anantkapoor.weathermaster3000;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    Switch locationSwitch;
    public static boolean locationBool=false;
    public static boolean sunBool=false;
    public static boolean rainBool=false;
    public static boolean cloudBool=false;
    public static boolean snowBool=false;
    public static boolean windBool=false;
    public static boolean stormBool=false;
    public static boolean fogBool=false;
    public static boolean floodBool=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Switch location= (Switch)findViewById(R.id.locationSwitch);
        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    locationBool=true;
                    Toast.makeText(getApplicationContext(),"Location on",Toast.LENGTH_LONG).show();

                }else{
                    locationBool=false;
                    Toast.makeText(getApplicationContext(),"Location off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch sun= (Switch)findViewById(R.id.sunSwitch);
        sun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sunBool=true;
                    Toast.makeText(getApplicationContext(),"Sun on",Toast.LENGTH_LONG).show();

                }else{
                    sunBool=false;
                    Toast.makeText(getApplicationContext(),"Sun off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch rain= (Switch)findViewById(R.id.rainSwitch);
        rain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rainBool=true;
                    Toast.makeText(getApplicationContext(),"Rain on",Toast.LENGTH_LONG).show();

                }else{
                    rainBool=false;
                    Toast.makeText(getApplicationContext(),"Rain off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch cloud= (Switch)findViewById(R.id.cloudSwitch);
        cloud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cloudBool=true;
                    Toast.makeText(getApplicationContext(),"Cloud on",Toast.LENGTH_LONG).show();

                }else{
                    cloudBool=false;
                    Toast.makeText(getApplicationContext(),"Cloud off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch snow= (Switch)findViewById(R.id.snowSwitch);
        snow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    snowBool=true;
                    Toast.makeText(getApplicationContext(),"Snow on",Toast.LENGTH_LONG).show();

                }else{
                    snowBool=false;
                    Toast.makeText(getApplicationContext(),"Snow off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch wind= (Switch)findViewById(R.id.windSwitch);
        wind.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    windBool=true;
                    Toast.makeText(getApplicationContext(),"Wind on",Toast.LENGTH_LONG).show();

                }else{
                    windBool=false;
                    Toast.makeText(getApplicationContext(),"Wind off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch storm= (Switch)findViewById(R.id.stormSwitch);
        storm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    stormBool=true;
                    Toast.makeText(getApplicationContext(),"Storms on",Toast.LENGTH_LONG).show();

                }else{
                    stormBool=false;
                    Toast.makeText(getApplicationContext(),"Storms off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch fog= (Switch)findViewById(R.id.fogSwitch);
        fog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    fogBool=true;
                    Toast.makeText(getApplicationContext(),"Fog on",Toast.LENGTH_LONG).show();

                }else{
                    fogBool=false;
                    Toast.makeText(getApplicationContext(),"Fog off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;

        Switch flood= (Switch)findViewById(R.id.floodSwitch);
        flood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    floodBool=true;
                    Toast.makeText(getApplicationContext(),"Floods on",Toast.LENGTH_LONG).show();

                }else{
                    floodBool=false;
                    Toast.makeText(getApplicationContext(),"Floods off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;
    }

}
