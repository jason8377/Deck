package com.robots_pencils.deck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	//all cards in the PokerDeck
	private List<Card> cards = new ArrayList<Card>();
	
	/**
	 * <p>Default constructor
	 * There should be a factory to prevent creating Deck every time.
	 */
    public Deck(){
    	//initial Heart
    	for(int i=1;i<14;i++){
    		Card card = new Card(Constants.CARD_TYPE_HEART,i+1);
    		cards.add(card);
    	}
    	//initial Spade
    	for(int i=1;i<14;i++){
    		Card card = new Card(Constants.CARD_TYPE_SPADE,i+1);
    		cards.add(card);
    	}
    	//initial Club
    	for(int i=1;i<14;i++){
    		Card card = new Card(Constants.CARD_TYPE_CLUB,i+1);
    		cards.add(card);
    	}
    	//initial Diamond
    	for(int i=1;i<14;i++){
    		Card card = new Card(Constants.CARD_TYPE_DIAMOND,i+1);
    		cards.add(card);
    	}
    	//black kind
    	Card blackKing = new Card(Constants.CARD_TYPE_BLACK_KING,15);
    	cards.add(blackKing);
    	//red king
    	Card redKing = new Card(Constants.CARD_TYPE_RED_KING,16);
    	cards.add(redKing);
    }
    
    /**
     * get one Card then remove it from LinkedList
     * @return
     */
    public void transferToDealer(LinkedList<Card> cardDealer){
    	cardDealer.addAll(cards);
    }
}
