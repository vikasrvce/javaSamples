package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeal {
	
	int numHands = 4;
    int cardsPerHand = 13;

    List<String> deck;
    // Make a normal 52-card deck.
    String[] suit = new String[] {
        "spades", "hearts", 
        "diamonds", "clubs" 
    };
    String[] rank = new String[] {
        "ace", "2", "3", "4",
        "5", "6", "7", "8", "9", "10", 
        "jack", "queen", "king" 
    };
    
    public CardDeal() {
    	List<String> deck = new ArrayList<String>();
        for (int i = 0; i < suit.length; i++)
            for (int j = 0; j < rank.length; j++)
                deck.add(rank[j] + " of " + suit[i]);
    
        // Shuffle the deck.
        Collections.shuffle(deck);
    }
    
    public List<String> dealHand(int n) {
    	int deckSize = deck.size();
        List<String> handView = deck.subList(deckSize - n, deckSize);
        List<String> hand = new ArrayList<String>(handView);
        handView.clear();
        return hand;
    }

}
