package model;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Author: Alex Wong
// Purpose: Defines a player class that holds their balance and cards

public class Player {
	double balance;
	Card givenCard1;
	Card givenCard2;
	
	public Player() {
		balance = 100.0;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String balanceFormatted(double bal) {	
	    NumberFormat formatter = DecimalFormat.getCurrencyInstance();
		return formatter.format(bal);
	}
	
	public PokerHand bestHand(Card[] community) {
		PokerHand[] hands = new PokerHand[21];
		// 2 Givens, 3 Community
		hands[0] = new PokerHand(givenCard1, givenCard2, community[0], community[1], community[2]);
		hands[1] = new PokerHand(givenCard1, givenCard2, community[0], community[1], community[3]);
		hands[2] = new PokerHand(givenCard1, givenCard2, community[0], community[1], community[4]);
		hands[3] = new PokerHand(givenCard1, givenCard2, community[0], community[2], community[3]);
		hands[4] = new PokerHand(givenCard1, givenCard2, community[0], community[2], community[4]);
		hands[5] = new PokerHand(givenCard1, givenCard2, community[0], community[3], community[4]);
		hands[6] = new PokerHand(givenCard1, givenCard2, community[1], community[2], community[3]);
		hands[7] = new PokerHand(givenCard1, givenCard2, community[1], community[2], community[4]);
		hands[8] = new PokerHand(givenCard1, givenCard2, community[1], community[3], community[4]);
		hands[9] = new PokerHand(givenCard1, givenCard2, community[2], community[3], community[4]);
		
		// 1 Given, 4 Community
		hands[10] = new PokerHand(givenCard1, community[0], community[1], community[2], community[3]);
		hands[11] = new PokerHand(givenCard1, community[0], community[1], community[2], community[4]);
		hands[12] = new PokerHand(givenCard1, community[0], community[1], community[3], community[4]);
		hands[13] = new PokerHand(givenCard1, community[0], community[2], community[3], community[4]);
		hands[14] = new PokerHand(givenCard1, community[1], community[2], community[3], community[4]);
		
		hands[15] = new PokerHand(givenCard2, community[0], community[1], community[2], community[3]);
		hands[16] = new PokerHand(givenCard2, community[0], community[1], community[2], community[4]);
		hands[17] = new PokerHand(givenCard2, community[0], community[1], community[3], community[4]);
		hands[18] = new PokerHand(givenCard2, community[0], community[2], community[3], community[4]);
		hands[19] = new PokerHand(givenCard2, community[1], community[2], community[3], community[4]);
		
		// 0 Given, 5 Community
		hands[20] = new PokerHand(community[0], community[1], community[2], community[3], community[4]);
		
		PokerHand best = hands[0];
		for(int i = 0; i < 21; i++) {
			if(best.compareTo(hands[i]) < 0) {
				best = hands[i];
			}
		}
		
		return best;
	}
}
