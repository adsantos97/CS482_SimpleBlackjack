package com.example.arizz.simpleblackjack;

import java.util.ArrayList;

/**
 * A class that represents a card Hand.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class Hand {

    private ArrayList<Card> hand;
    private int maxHandSize;

    /**
     * Initializes a Hand of cards.
     * @param maxHandSize maximum size of Hand
     */
    public Hand(int maxHandSize) {
        this.hand = new ArrayList<Card>();
        this.maxHandSize = maxHandSize;
    }

    /**
     * Adds a card to the Hand if Hand isn't full.
     * @param dealtCard the card dealt from the deck
     */
    public void addToHand(Card dealtCard) {
        if (!isHandFull()) {
            hand.add(dealtCard);
        }
    }

    /**
     * Checks if the Hand is full.
     * @return true if the number of cards in the Hand
     *         is equal to the maximum size of Hand
     */
    public boolean isHandFull () {
        return hand.size() == maxHandSize;
    }


}
