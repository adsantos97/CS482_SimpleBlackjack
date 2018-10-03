package com.example.arizz.simpleblackjack;

/**
 * Description of class
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SimpleBlackjack game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new SimpleBlackjack("Player", "Dealer");
        setContentView(R.layout.activity_main);
    }
}
