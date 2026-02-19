/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deckofcards;

/**
 *
 * @author PHellmann2026
 */
 
public class DeckOfCards {

    public static void main(String[] args) {
        
        //Create 2D array for deck 
        String[][] cardDeck = new String[4][13];
        
        String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        //Fill deck with rank of suit
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank ++) { 
                cardDeck[suit][rank] = ranks[rank] + " of " + suits[suit]; 
            }
        }
        
        //Flatten 2D array into 1D for shuffling  
        String[] flatDeck = new String[52];
        int index = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                flatDeck[index++] = cardDeck[suit][rank];
            }
        }

        //Shuffle deck
        for (int i = 0; i < flatDeck.length; i++) {
            int randomIndex = (int)(Math.random() * flatDeck.length);
            String temp = flatDeck[i];
            flatDeck[i] = flatDeck[randomIndex];
            flatDeck[randomIndex] = temp;
        }

        //Deal four hands of five cards
        String[][] hands = new String[4][5];
        int cardIndex = 0;
        for (int player = 0; player < 4; player++) {
            for (int card = 0; card < 5; card++) {
                hands[player][card] = flatDeck[cardIndex++];
            }
        }

        //Show (print) dealt hands 
        for (int player = 0; player < 4; player++) {
            System.out.println("Hand " + (player + 1) + ":");
            for (int card = 0; card < 5; card++) {
                System.out.println("  " + hands[player][card]);
            }
            System.out.println();
        }
    }
}
