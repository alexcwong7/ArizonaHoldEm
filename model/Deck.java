package model;
// Author: Alex Wong
// Purpose: Class Deck creates the deck and stores cards

import java.util.Arrays;
import java.util.Collections;

public class Deck {
	Card[] deck = new Card[52];
	int index;
	
	public Deck() {
		index = 0;
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				Card card = new Card(rank, suit);
				deck[index] = card;
				index++;
			}
		}
		this.shuffleCards();
	}
	
	public int size() {
		int n = deck.length;
		return n;
	}
	
	public void shuffleCards() {
		Collections.shuffle(Arrays.asList(deck));
	}
	
	public Card drawCard() {
		Card card = deck[size()-1];
		Card[] temp = new Card[size()-1];
		for(int i = 0; i < size()-1; i++) {
			temp[i] = deck[i];
		}
		deck = temp;
		return card;
	}
}
