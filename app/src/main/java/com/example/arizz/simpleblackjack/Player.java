package com.example.arizz.simpleblackjack;

/**
 * A class that represents a Player.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class Player {

    protected Hand hand;
    protected String name;

    /**
     * Player parameterized constructor.
     * @param name name of player
     */
    public Player(String name) {
        this.hand = new Hand(5);
        this.name = name;
    }
}
