# Quick Start
<li>Download the code
<li>Import the project to Eclipse
<li>Choose DeckDealer, choose "run".  Note that main method is located in DeckDealer.java.

# Description of main method
<pre>
//Start a game, cards will be sent out until nothing left.
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
</pre>
<li>Note that a card game can have multiple decks by setting deckCount in DeckDealer.java. It is easy to change the constructor to cover that.
<li>By spreading code into multiple classes, the structure gets clear, better for future improvement like adding comparators and rules. 
Testing gets straitforward as well.
