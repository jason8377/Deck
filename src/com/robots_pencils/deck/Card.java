package com.robots_pencils.deck;

/**
 * Card object
 * @author Jason
 *
 */
public class Card {
	/**
	 * type of the Card(heart,spade,club,diamond,red king,black king)
	 */
    private int card_type;
    /**
     * the number of the card
     * the number from 11 to 14 stand for:J Q K A, 15 sands for black king, 16 stands for red king
     */
    private int number;
    
    /**
     * 
     * @param card_type
     * @param number
     */
    public Card(int card_type,int number){
    	this.card_type = card_type;
    	this.number = number;
    }
    
    
    /**
     * getter for card_type
     * @return
     */
    public int getCard_type(){
    	return this.card_type;
    }
    /**
     * getter for number
     * @return
     */
    public int getNumber(){
    	return this.number;
    }
    
    /**
     * This method is only for print purpose.
     * @return
     */
    public String getCard_type_desc(){
    	switch(card_type){
    	    case Constants.CARD_TYPE_HEART:
    	    	return Constants.STR_CARD_TYPE_HEART;
    	    case Constants.CARD_TYPE_SPADE:
    	    	return Constants.STR_CARD_TYPE_SPADE;
    	    case Constants.CARD_TYPE_CLUB:
    	    	return Constants.STR_CARD_TYPE_CLUB;
    	    case Constants.CARD_TYPE_DIAMOND:
    	    	return Constants.STR_CARD_TYPE_DIAMOND;
    	    case Constants.CARD_TYPE_RED_KING:
    	    	return Constants.STR_CARD_TYPE_RED_KING;
    	    case Constants.CARD_TYPE_BLACK_KING:
    	    	return Constants.STR_CARD_TYPE_BLACK_KING;
    	    default:
    	    	return card_type + "";
    	}
    }
}
