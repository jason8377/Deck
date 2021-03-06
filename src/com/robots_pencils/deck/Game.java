package com.robots_pencils.deck;

import java.util.ArrayList;
import java.util.List;

public class Game {
	//card amount per player for this round
	private int cardCount = -1;
	
	//players ArrayList,they are disorder
	private List<Player> players = new ArrayList<Player>();
	
	public Game(){}
	
	/**
	 * constructor with a card number parameter
	 * @param cardAmount
	 */
	public Game(int cardCount){
		this.cardCount = cardCount;
		//negative is not allowed
    	if(this.cardCount<=0){
    		this.cardCount = 5;
    	}
	}
    
	/**
	 * add player
	 * @param player
	 */
    public void addPlayer(Player player){
    	//add player to list
    	players.add(player);
    }
    
    /**
     * get amount of player of this round
     * @return
     */
    public int getPlayerCount(){
    	return players.size();
    }
    
    public Player getPlayer(int playerIndex){
    	return players.get(playerIndex);
    }
    
    public List<Player> getAllPlayer(){
    	return players;
    }
    
    /**
     * get card amount this round
     * @return
     */
    public int getCardCount(){
    	return this.cardCount;
    }
    
    /**
     * deal card to player
     * @param playerIndex
     * @param card
     */
    public void deal(int playerIndex,Card card){
    	players.get(playerIndex).receiveCard(card);
    }
}
