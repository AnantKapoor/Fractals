package com.anantkapoor.weathermaster3000;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class Activity2 extends MapsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.245));

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity2.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter{
        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }

        public int getCount(){
            return mThumbsIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId (int position) {
            return 0;
        }

        public  View getView (int position, View convertView, ViewGroup parent){
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,8,0,8);
            imageView.setImageResource(mThumbsIds[position]);
            return imageView;

        }


        private Integer[] mThumbsIds = {
                R.drawable.sun,
                R.drawable.rain,
                R.drawable.clouds,
                R.drawable.storm,
                R.drawable.fog,
                R.drawable.snow,
                R.drawable.wind,
                R.drawable.flood,


        };
    };

}
