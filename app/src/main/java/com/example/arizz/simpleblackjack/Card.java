package com.example.arizz.simpleblackjack;

/**
 * A class that represents a Card.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class Card {

    /** Rank, Suit and value of this Card. */
    protected Rank rank;
    protected Suit suit;
    protected int value;

    /**
     * Card parameterized constructor.
     * @param suit the suit of the new card
     * @param rank the rank of the new card
     */
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
        this.value = determineValue();
    }

    /**
     * Determines the value of card based on Rank.
     * @return value value based on Rank of the card
     */
    public int determineValue() {
        int value = 0;

        switch (rank) {
            case ACE:
                value = 1;
                break;
            case TWO:
                value = 2;
                break;
            case THREE:
                value = 3;
                break;
            case FOUR:
                value = 4;
                break;
            case FIVE:
                value = 5;
                break;
            case SIX:
                value = 6;
                break;
            case SEVEN:
                value = 7;
                break;
            case EIGHT:
                value = 8;
                break;
            case NINE:
                value = 9;
                break;
            case TEN:
                value = 10;
                break;
            case JACK:
                value = 10;
                break;
            case QUEEN:
                value = 10;
                break;
            case KING:
                value = 10;
                break;
        }

        return value;
    }

    /**
     * Override toString() method.
     * @return string representation of Card
     */
    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
