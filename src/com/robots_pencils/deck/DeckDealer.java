package com.robots_pencils.deck;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>
 * Deck dealer, also the main entrance of the test.
 * @author Jason
 *
 */
public class DeckDealer {
	public static void main(String[] args){
        Game game = new Game();
        //Or if you want each player get 5 cards in a game
        //Game game = new Game(5);
    	game.addPlayer(new Player("Jack"));
    	game.addPlayer(new Player("Tonny"));
    	
    	//create a card dealer
    	DeckDealer dealer = new DeckDealer(game);
    	
    	//Shuffle and cut cards before dealing
    	dealer.shuffle();
    	dealer.cut();
    	
    	//deal cards
    	dealer.deal();
    	
    	//Print cards for each player
    	List<Player> players = game.getAllPlayer();
    	if(players != null){
    		for(Player player:players){
    			player.printMyCards();
    		}
    	}
	}
	
	
	
	/**
	 * Deck amount, a game can have one or more decks
	 * Note that one deck contains 54 cards
	 */
	private int deckCount = 2;
	private Game game;
	/**
	 * Card list
	 * Why using LinkedList is for shuffling and cutting consideration.
	 */
	private LinkedList<Card> cards = new LinkedList<Card>();
    
    public DeckDealer(Game game){
    	this.game = game;
    	//initial cards via the number of deck
    	for(int i=0;i<deckCount;i++){
    	    Deck deck = new Deck();
    		deck.transferToDealer(cards);
    	}
    }
    
    /**
     * <p>
     * We can use shuffle method in Collections or mimic the shuffling of a card dealer.
     * <pre>
     * For example, there are 6 cards:ABCDEF(followed by index for better understanding):
     * A  0
     * B  1
     * C  2
     * D  3
     * E  4
     * F  5
     * Step 1: Get a random number indexA between 1 and 5, for example 2
     * Step 2: Get a random number indexB between 1 and 5 and larger than indexA, for example 3
     * Step 3: Move elements above C, and insert them before E, the result will be: C D A B E F
     * Do above steps multiple times as needed.
     * </pre>
     */
    private void shuffle(){
    	/**
    	 * We can use shuffle method in Collections
    	 */
    	Collections.shuffle(cards);
    	
    	/**
    	 * Or mimic the shuffling of a card dealer by below method
    	 */
    	int indexA = 2; //Get a random number indexA between 1 and 4, for example 2
		int indexB = 3; //Get a random number indexB between 1 and 4 and larger than indexA, for example 3
		//Move all elements above C and add them before E 
		for(int i=0;i<indexA;i++){
			Card first = cards.removeFirst();
			cards.add(indexB, first);
		}
		//Do above steps multiple times.
    }
    /**
     * <p>
     * cut is similar with shuffle
     * The difference is that indexB is always the last element in the list.
     * <pre>
     * A  0
     * B  1
     * C  2
     * D  3
     * E  4
     * F  5
     * If the cut index is 2, the result after cutting will be: C D E F A B
     * </pre>
     */
    private void cut(){}
    
    /**
     * deal the cards to players.
     */
    private void deal(){
        int playerIndex = 0;
        Card card = popCard();
        while(card != null){
        	game.deal(playerIndex, card);
    		
        	playerIndex ++;
    		if(playerIndex == game.getPlayerCount()){  //Roll back to 0 if reaches the end of players
    			playerIndex = 0;
    		}

        	/**
        	 * Cards can be all sent out or each player can have a given number of cards.
        	 */
    		if(game.getCardCount() > 0){
        	    if(game.getPlayer(game.getPlayerCount() -1).getCardCount() == game.getCardCount()){
        		    break;
        	    }
    		}
    		
    		card = popCard();
        }
    }
    private Card popCard(){
    	try{
    	    return cards.removeLast();
    	}catch(NoSuchElementException e){
    		return null;
    	}
    }
}