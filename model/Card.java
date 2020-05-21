package model;
// Author: Alex Wong
// Purpose: Class Card creates a new Card object that has a rank and suit

public class Card {
	
	Suit suit;
	Rank rank;
	
	public Card(Rank rank, Suit suit){
		this.suit = suit;
		this.rank = rank;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public void printSuitSymbol(Suit suit) {
		 char suitClub = '\u2663'; // ♣   
		 char suitDiamond = '\u2666'; // ♦    
		 char suitHeart = '\u2665'; // ♥
		 char suitSpade = '\u2660'; // ♠

		 if(this.suit == Suit.SPADES) {
			 System.out.print(suitClub);
		 }
		 else if(this.suit == Suit.DIAMONDS) {
			 System.out.print(suitDiamond);
		 }
		 else if(this.suit == Suit.HEARTS) {
			 System.out.print(suitHeart);
		 }
		 else {
			 System.out.print(suitSpade);
		 }
		
	}
}
