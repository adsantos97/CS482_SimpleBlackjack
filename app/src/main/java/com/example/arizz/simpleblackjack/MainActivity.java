package com.example.arizz.simpleblackjack;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * This is the Controller.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */

public class MainActivity extends AppCompatActivity{

    public final static String MA = "MainActivity";
    private SimpleBlackjack game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new SimpleBlackjack("Dealer", "Player");
        Configuration config = getResources().getConfiguration();
        modifyLayout(config);
    }

    /**
     * Checks the orientation when the user rotates the device
     * @param newConfig Configuration object that specifies the new
     *                  device configuration
     */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.w(MA, "Height: " + newConfig.screenHeightDp);
        Log.w(MA, "Width: " + newConfig.screenWidthDp);

        /** Checks the device orientation using Logcat */
        Log.w(MA, "Orientation: " + newConfig.orientation);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.w(MA, "Horizontal position.");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.w(MA, "Portrait position.");
        } else {
            Log.w(MA, "Undetermined position.");
        }

        modifyLayout(newConfig);
    }

    public void modifyLayout(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_landscape);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
    }

    public void run(View view) {

    }
}
