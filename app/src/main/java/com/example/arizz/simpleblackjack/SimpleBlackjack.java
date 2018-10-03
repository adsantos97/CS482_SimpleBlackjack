package com.example.arizz.simpleblackjack;

import java.util.ArrayList;

/**
 * A class that represents a SimpleBlackjack.
 * If lowercase "player" is used, it is referencing the private instance variable.
 * Otherwise, uppercase "Player" is referencing the Player class.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class SimpleBlackjack {

    private Deck newDeck;
    private Player player;
    private Player dealer;
    private boolean playerDone;
    private boolean dealerDone;

    /**
     * Initialize SimpleBlackjack.
     * @param playerName the player's name
     * @param dealerName the dealer's name
     */
    public SimpleBlackjack (String playerName, String dealerName) {
        player = new Player(playerName);
        dealer = new Player(dealerName);
        newDeck = new Deck(2); // playing with 2 decks (i.e. 104 cards)
    }

    /**
     * Deals cards for the beginning of the game.
     */
    public void dealTheGame() {
        /** initial states */
        boolean blackjack = false;
        playerDone = false;
        dealerDone = false;

        /** The first four cards dealt from the Deck */
        Card card1 = newDeck.dealCard();
        Card card2 = newDeck.dealCard();
        Card card3 = newDeck.dealCard();
        Card card4 = newDeck.dealCard();

        dealer.hand.addToHand(card1);
        player.hand.addToHand(card2);
        dealer.hand.addToHand(card3);
        player.hand.addToHand(card4);

        /** check if initial cards are Blackjacks */
        blackjack = checkIfBlackjack();

        if(blackjack) {
            decideWinner();
        }
    }

    /**
     * Checks if natural Blackjack on initial cards.
     */
    public boolean checkIfBlackjack() {
        boolean blackjack = false;

        if(player.hand.hasBlackjack() || dealer.hand.hasBlackjack()) {
            playerDone = true;
            dealerDone = true;
            blackjack = true;
        }

        return blackjack;
    }

    /**
     * Get the player's hand.
     * @param p the player
     */
    public ArrayList<Card> getHand(Player p) {
        return p.hand.hand;
    }

    /**
     * "Hit" method (for player) to ask for another card in an
     * attempt to get closer to a count of or exactly 21.
     */
    public void hit() {
        player.hand.addToHand(newDeck.dealCard());

        if (player.hand.sumHand() > 21) {
            playerDone = true;
            dealerDone = true;
        }
    }

    /**
     * Player stays and turn is over.
     */
    public void stand() {
        playerDone = true;
    }

    /**
     * Decides the winner.
     * @return Player that won
     */
    public String decideWinner() {
        int playerSum = player.hand.sumHand();
        int dealerSum = dealer.hand.sumHand();

        if (playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) {
            return player.name;
        } else if (playerSum == dealerSum) {
            return "Tie";
        } else {
            return dealer.name;
        }
    }
}
