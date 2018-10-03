package com.example.arizz.simpleblackjack;

import java.util.ArrayList;

/**
 * A class that represents a card Hand.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class Hand {

    protected ArrayList<Card> hand;
    private int maxHandSize;

    /**
     * Hand parameterized constructor.
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

    /**
     * Determines sum of values of the cards in the Hand.
     * @return sum of the Hand
     */
    public int sumHand() {
        int sumHand = 0;
        int numAces = 0;

        for (Card c: this.hand) {

            if (c.rank == Rank.ACE) {
                numAces++;
                sumHand += 11;
            } else if (c.value == 10) {
                sumHand += 10;
            } else {
                sumHand += c.value;
            }
        }

        while (sumHand > 21 && numAces > 0) {
            sumHand -= 10;
            numAces--;
        }

        return sumHand;
    }

    /**
     * Checks if the Hand contains a natural Blackjack
     * @return true if the first two cards make a Blackjack
     */
    public boolean hasBlackjack() {
        return (hand.get(0).value + hand.get(1).value) == 21;
    }

    /**
     * Checks if there is an Ace in the Hand.
     * @return true if there is at least one Ace in the Hand.
     */
    public boolean checkAce() {
        boolean aceInHand = false;

        for (Card c: this.hand) {
            if (c.rank == Rank.ACE) {
                aceInHand = true;
            }
        }

        return aceInHand;
    }
}
