package com.example.arizz.simpleblackjack;

/**
 * A class that represents a Card object.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class Card {

    /** Rank, Suit and value of this Card. */
    private Rank rank;
    private Suit suit;
    private int value;

    /**
     * Card parameterized constructor
     * @param suit the suit of the new card
     * @param rank the rank of the new card
     */
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Override toString() method
     * @return string representation of Card
     */
    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

}
