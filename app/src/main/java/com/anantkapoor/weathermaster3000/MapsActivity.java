package com.anantkapoor.weathermaster3000;
import android.content.Intent;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.services.params.Geocode;


import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.io.IOException;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener{

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "beP7yuStvV83UmZhfISOKucJD";
    private static final String TWITTER_SECRET = "4lD0uSswEd8JlVDB92Y4kkBZVOVRrGxuS2y5LPg25RTbzoiVUY";

    TwitterLoginButton loginButton;

    private GoogleMap mMap;

    private customActivity customActivityA;

    Button button3;
    Button button4;
    TextView jsonTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_maps);

        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);

        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                String UserName = result.data.getUserName();
                Toast.makeText(MapsActivity.this,UserName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(TwitterException exception) {

            }
        });



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this,Activity2.class));


            }

        });

        button3= (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4= (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);

        /*-------------------------ERROR HERE-------------------------*/
        /*java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.Switch.setOnCheckedChangeListener(android.widget.CompoundButton$OnCheckedChangeListener)' on a null object reference*/

        /*Switch location= (Switch)findViewById(R.id.locationSwitch);
        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                   mMap.setMyLocationEnabled(true);
                    Toast.makeText(getApplicationContext(),"Location on",Toast.LENGTH_LONG).show();

                }else{
                    mMap.setMyLocationEnabled(false);
                    Toast.makeText(getApplicationContext(),"Location off",Toast.LENGTH_LONG).show();

                }
            }
        }) ;*/

        if (Activity3.locationBool=true){
            /*mMap.setMyLocationEnabled(true);*/
            Toast.makeText(getApplicationContext(),"Location on",Toast.LENGTH_LONG).show();
        }
        else {
            /*mMap.setMyLocationEnabled(false);*/
            Toast.makeText(getApplicationContext(),"Location off",Toast.LENGTH_LONG).show();
        }

        /*customActivityA=new customActivity();
        ArrayList<HashMap<String, String>> statusList=customActivityA.getStatusList();
        jsonTextview=(TextView)findViewById(R.id.textView4);*/
        /*------------------Method 1------------------*/
       /* for (int i = 0; i < statusList.size(); i++) {

            HashMap<String, String> tmpData = (HashMap<String, String>) statusList.get(i);

            Set<String> key = tmpData.keySet();
            Iterator itr = key.iterator();
            while (itr.hasNext()) {
                String hmKey = (String) itr.next();
                String hmData = (String) tmpData.get(hmKey);

                System.out.println("Key:" + hmKey + "\nData:" + hmData);
                jsonTextview.append(hmKey);
                jsonTextview.append(hmData);

            }
        }*/

        /*Iterator itr = statusList.iterator();
        while(itr.hasNext()){
            HashMap hashMap=(HashMap)itr.next();
            System.out.println("Date:"+hashMap.date+"\nText:"+hashMap.text);*/


        }




    public interface SearchService{
        @GET("/1.1/search/tweets.json?"+
                "tweet_mode=extended&include_cards&cards_platform=TwitterKit-13")
        Call<Search>tweets(@Query("q") String query,
                           @Query(value="geocode",encoded = true) Geocode latLng,
                           @Query("result_type") String resultType,
                           @Query("count")Integer count);

        public static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.twitter.com/1.1/search/tweets.json")
                .addConverterFactory(GsonConverterFactory.create())
                .build();




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }


    private void button3Click()
    {
        startActivity(new Intent("options.Activity3"));

    }


    private void button4Click()
    {
        startActivity(new Intent("customActivity"));
    }

    public void onSearch(View view)
    {
        EditText location_tf = (EditText)findViewById(R.id.TFaddress) ;
        String location=location_tf.getText().toString();
        List<android.location.Address> addressList = null;

        if (location != null) {
            Geocoder geocoder = new Geocoder(this);

            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (addressList != null) {
                android.location.Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Search Query", Toast.LENGTH_LONG).show();
            }

                    /*-------------------------ERROR HERE-------------------------*/

            /*SearchService searchService = SearchService.retrofit.create(SearchService.class);
            final Call<Search> call = searchService.tweets(null,null,null,null);

            call.enqueue(new Callback<List<Search>>() {

                @Override
                public void success(Result<List<Search>> result) {
                    final TextView textView = (TextView) findViewById(R.id.textView4);
                    textView.setText(result.data.);

                }

                @Override
                public void failure(TwitterException exception) {
                    final TextView textView = (TextView) findViewById(R.id.textView4);
                    String stringFailure="Something went wrong";
                    textView.setText(stringFailure);

                }
            });*/
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this,R.raw.style_json));
        LatLng england = new LatLng(54.5497, 3.5892);
        LatLng latLng1 = new LatLng(52.4324,-1.8931);
        LatLng latLng2 = new LatLng(52.4608,-1.9149);
        LatLng latLng3 = new LatLng(52.4460,-1.8842);
        LatLng latLng4 = new LatLng(52.4408,-1.9385);
        LatLng latLng5 = new LatLng(52.4287,-1.8426);
        LatLng latLng6 = new LatLng(52.4494,-1.8630);
        LatLng latLng7 = new LatLng(52.5703,-1.8240);
        LatLng latLng8 = new LatLng(52.4924,-1.9652);
        LatLng latLng9 = new LatLng(52.5143,-1.9392);
        LatLng latLng10 = new LatLng(52.4752,-1.8871);
        LatLng latLng11 = new LatLng(52.4767,-1.8442);
        LatLng latLng12 = new LatLng(52.5319,-1.8611);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(england));
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("Kings Heath, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng2).title("Edgbaston, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng3).title("Moseley, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng4).title("Selly Oak, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng5).title("Hall Green, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng6).title("Sparkhill, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng7).title("Sutton Coldfield, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.umbrella)));
        mMap.addMarker(new MarkerOptions().position(latLng8).title("Smethwick, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.windy)));
        mMap.addMarker(new MarkerOptions().position(latLng9).title("Handsworth, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.windy)));
        mMap.addMarker(new MarkerOptions().position(latLng10).title("Digbeth, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng11).title("Bordesley Green, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.sun)));
        mMap.addMarker(new MarkerOptions().position(latLng12).title("Perry Common, UK").icon(BitmapDescriptorFactory.fromResource(R.mipmap.umbrella)));

    }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button3:
                    button3Click();
                    break;
                case R.id.button4:
                    button4Click();
                    break;
            }
        }


}

