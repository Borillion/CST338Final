package com.borillion.planets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        final Resources res = getResources();
        final String[] planetNames = res.getStringArray(R.array.planetNames);

        GridView gridView = (GridView) findViewById(R.id.glyphView);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));

        /**
         * On Click event for Single Gridview Item
         * */
         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Keep all Images in array
                 Integer[] mThumbIds = {
                        R.drawable.mercury,
                        R.drawable.venus,
                        R.drawable.earth,
                        R.drawable.mars,
                        R.drawable.ceres,
                        R.drawable.psyche,
                        R.drawable.jupiter,
                        R.drawable.saturn,
                        R.drawable.uranus,
                        R.drawable.neptune,
                        R.drawable.pluto
                };

                View toastView = getLayoutInflater().inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.toastLayout));

                ImageView imageView = (ImageView)toastView.findViewById(R.id.image);
                /* Set the correct image for each clicked glyph */
                imageView.setImageResource(mThumbIds[position]);
                TextView textView = (TextView)toastView.findViewById(R.id.text);
                textView.setText(planetNames[position]);
                Toast toast = new Toast(getBaseContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toastView);
                toast.show();
                //Toast.makeText(MainActivity.this, planetNames[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
