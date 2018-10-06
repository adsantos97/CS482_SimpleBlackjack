package com.example.arizz.simpleblackjack;

/**
 * A class that represents a SimpleBlackjack.
 * If lowercase "player" is used, it is referencing the private instance variable.
 * Otherwise, uppercase "Player" is referencing the Player class.
 * @author Arizza Santos
 * @version 1.0 10/4/2018
 */
public class SimpleBlackjack {

    private Deck deck;
    private Player player1;
    private Player player2;
    private boolean player1Done;
    private boolean player2Done;

    /**
     * Initialize SimpleBlackjack.
     * @param player1Name the player 1's name -- for our game, dealer is first
     * @param player2Name the player 2's name -- for our game, player is second
     */
    public SimpleBlackjack (String player1Name, String player2Name) {
        deck = new Deck(2); // playing with 2 decks (i.e. 104 cards)
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        player1Done = false;
        player2Done = false;
    }

    /**
     * Getter for the Deck
     */
    public Deck getDeck() { return this.deck; }

    /**
     * Getter for player 1
     */
    public Player getPlayer1() { return this.player1; }

    /**
     * Getter for player 2
     */
    public Player getPlayer2() { return this.player2; }

    /**
     * Deals cards for the beginning of the game.
     */
    public void dealTheGame() {
        /** initial states */
        boolean blackjack;

        /** The first four cards dealt from the Deck */
        Card card1 = this.deck.dealCardFromDeck();
        Card card2 = this.deck.dealCardFromDeck();
        Card card3 = this.deck.dealCardFromDeck();
        Card card4 = this.deck.dealCardFromDeck();

        player1.getHand().addToHand(card1);
        player1.getHand().addToHand(card3);
        player2.getHand().addToHand(card2);
        player2.getHand().addToHand(card4);

        /** check if initial cards are Blackjacks */
        blackjack = checkIfBlackjack(player1.getHand(), player2.getHand());

        if(blackjack) {
            decideWinner();
        }
    }

    /**
     * Checks if natural Blackjack on initial cards.
     * @param player1 player 1's Hand
     * @param player2 player 2's Hand
     */
    public boolean checkIfBlackjack(Hand player1, Hand player2) {
        boolean blackjack = false;

        if(player2.hasNaturalBlackjack()
                || player1.hasNaturalBlackjack()) {
            player2Done = true;
            player1Done = true;
            blackjack = true;
        }

        return blackjack;
    }

    /**
     * "Hit" method (for player) to ask for another card in an
     * attempt to get closer to a count of or exactly 21.
     */
    public void hit() {
        player2.getHand().addToHand(this.deck.dealCardFromDeck());

        if (player2.getHand().sumHand() > 21) {
            player2Done = true;
            player1Done = true;
            decideWinner();
        }
    }

    /**
     * Player stays and turn is over.
     */
    public void stand() {
        player2Done = true;
    }

    /**
     * Decides the winner.
     * @return Player that won
     */
    public void decideWinner() {
        int playerSum = player2.getHand().sumHand();
        int dealerSum = player1.getHand().sumHand();

        if (playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) {
            System.out.println(player2.getName());
        } else if (playerSum == dealerSum) {
            System.out.println("Tie");
        } else {
            System.out.println(player1.getName());
        }
    }
}
