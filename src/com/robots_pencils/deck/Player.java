package com.robots_pencils.deck;

import java.util.ArrayList;
import java.util.List;

public class Player {
	//name of the player
    private String player_name;
    //cards that the player holds
    private List<Card> cardList = new ArrayList<Card>();

    /**
     * construct a player with a giving name
     * @param player_name
     */
    public Player(String player_name){
    	this.player_name = player_name;
    }
    
    /**
     * receive card while handing out cards
     * @param card
     * @param cardAmount
     */
    public void receiveCard(Card card){
    	cardList.add(card);
    }
	
	public int getCardCount(){
		return cardList.size();
	}
	
	public void printMyCards(){
		System.out.println(player_name);
		for(Card card:cardList){
			System.out.print(card.getCard_type_desc() + ":" +card.getNumber() + "   ");
		}
		System.out.println();
	}
}
