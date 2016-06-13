package com.borillion.planets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.mercury_symbol,
            R.drawable.venus_symbol,
            R.drawable.earth_symbol,
            R.drawable.mars_symbol,
            R.drawable.ceres_symbol,
            R.drawable.psyche_symbol,
            R.drawable.jupiter_symbol,
            R.drawable.saturn_symbol,
            R.drawable.uranus_symbol,
            R.drawable.neptune_symbol,
            R.drawable.pluto_symbol
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new GridView.LayoutParams(320, 320));
        return imageView;
    }

}
