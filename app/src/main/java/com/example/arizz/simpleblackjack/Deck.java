package com.example.arizz.simpleblackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that represents a Deck object.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class Deck {

    /** Stores Cards to form a Deck */
    private ArrayList<Card> deck;

    /**
     * Initializes a Deck and shuffles
     * @param numofDecks number of decks being created/used together
     */
    public Deck(int numofDecks) {
        this.deck = new ArrayList<Card>();
        createDeck(numofDecks);
        shuffleDeck();
    }

    /**
     * Creates a deck based on the number of decks
     * being used
     * @param numofDecks number of decks being used
     */
    public void createDeck(int numofDecks) {
        for (int i = 0; i < numofDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    this.deck.add(new Card(suit, rank));
                }
            }
        }
    }

    /**
     * Shuffles the Deck
     */
    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    /**
     * Deals a card from the Deck
     * @return top Card from the Deck
     */
    public Card dealCard() {
        Card card = this.deck.remove(0);
        return card;
    }

}
