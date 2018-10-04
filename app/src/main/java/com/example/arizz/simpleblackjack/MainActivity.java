package com.example.arizz.simpleblackjack;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    public final static String MA = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        modifyLayout(config);
        //setContentView(R.layout.activity_main);
    }

    /**
     * Checks the orientation and screen dimension when
     * the user rotates the device
     * @param newConfig Configuration object that specifies the new
     *                  device configuration
     */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.w(MA, "Height: " + newConfig.screenHeightDp);
        Log.w(MA, "Width: " + newConfig.screenWidthDp);

        Log.w(MA, "Orientation: " + newConfig.orientation);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.w(MA, "Horizontal position.");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.w(MA, "Portrait position.");
        } else {
            Log.w(MA, "Undetermined position.");
        }
    }

    public void run(View view) {

    }
}
