package model;

// Author: Alex Wong
// Purpose: Creates the poker hands and the gaming system

public class PokerHand implements Comparable<PokerHand>{
	// Instance variables
	public Card[] pokerHand;
	
	// Constructor that creates a hand with 5 cards
	public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		pokerHand = new Card[5];
		pokerHand[0] = card1;
		pokerHand[1] = card2;
		pokerHand[2] = card3;
		pokerHand[3] = card4;
		pokerHand[4] = card5;
		sortCards(pokerHand);
		
		// Check for duplicates
		for(int i = 1; i < 5; i++) {
			if(pokerHand[i-1] == pokerHand[i]) {
				
			}
		}
	}
	
	// Method that sorts cards
	public void sortCards(Card[] hand) {
		boolean isSwapped = true;
	    int j = 0;
	    Card temp;
	    while (isSwapped) {
	        isSwapped = false;
	        j++;
	        for (int i = 0; i < 5 - j; i++) {
	            if (hand[i].getRank().getValue() > hand[i + 1].getRank().getValue()) {
	                temp = hand[i];
	                hand[i] = hand[i + 1];
	                hand[i + 1] = temp;
	                isSwapped = true;
	            }
	        }
	    }
	}
	
	// Determines the ranking of the player's hand
 	// rankVal 9: Straight flush
	// rankVal 8: Four of a kind
	// rankVal 7: Full house
	// rankVal 6: Flush
	// rankVal 5: Straight
	// rankVal 4: Three of a kind
	// rankVal 3: Two pair
	// rankVal 2: One pair
	// rankVal 1: High card
	// rankVal 0: Unassigned
	public int determineRankVal(Card[] hand) {
		if(isStraightFlush(hand)) {
			return 9;
		}
		else if(isFourOfAKind(hand)) {
			return 8;
		}
		else if(isFullHouse(hand)) {
			return 7;
		}
		else if(isFlush(hand)) {
			return 6;
		}
		else if(isStraight(hand)) {
			return 5;
		}
		else if(isThreeOfAKind(hand)) {
			return 4;
		}
		else if(isTwoPair(hand)) {
			return 3;
		}
		else if(isPair(hand)) {
			return 2;
		}
		else {
			return 1;
		}
	}
	// FLUSH: Determine if cards are same suit
	public boolean isFlush(Card[] hand) {
		boolean sameSuit = true;
		Suit startSuit = hand[0].getSuit();
		for(int i = 1; i < 5; i++) {
			if(startSuit != hand[i].getSuit()) {
				sameSuit = false;
			}
		}
		if(sameSuit == true) {
			return true;
		}
		return false;
	}
	
	// STRAIGHT: Determine if cards are one rank away from each other
	public boolean isStraight(Card[] hand) {		
		if(isLowStraight(hand)) {
			return true;
		}
		if(isHighStraight(hand)) {
			return true;
		}
		// Normal straight
		boolean straight = true;
		for(int i = 1; i < 5; i++) {
			if(hand[i-1].getRank().getValue() != hand[i].getRank().getValue()-1) {
				straight = false;
			}
		}
		if(straight == true) {
			return true;
		}
		return false;
	}
	
	// LOW STRAIGHT: Determine if the straight has an ace and is the lowest possible straight
	public boolean isLowStraight(Card[] hand) {
		// Checks lowest straight
		boolean isLowStraight = true;
		if(isAce(hand[4]) && hand[0].getRank().getValue() == 2) {
			for(int i = 1; i < 4; i++) {
				if(hand[i-1].getRank().getValue() != hand[i].getRank().getValue()-1) {
					isLowStraight = false;
				}
			}
			if(isLowStraight == true) {
				return true;
			}
		}
		return false;
	}
	
	// HIGH STRAIGHT: Determine if the straight has an ace and is the highest possible straight
	public boolean isHighStraight(Card[] hand) {
		// Checks highest straight
		boolean isHighStraight = true;
		if(isAce(hand[4]) && hand[0].getRank().getValue() == 10) {
			for(int i = 1; i < 4; i++) {
				if(hand[i-1].getRank().getValue() != hand[i].getRank().getValue()-1) {
					isHighStraight = false;
				}
			}
			if(isHighStraight == true) {
				return true;
			}
		}
		return false;
	}
	
	// FOUR OF A KIND: Determine if there are 4 cards of the same rank
	public boolean isFourOfAKind(Card[] hand) {
		for(int i = 3; i < 5; i++) {
			if(hand[i-3].getRank().getValue() == hand[i-2].getRank().getValue() && 
			   hand[i-3].getRank().getValue() == hand[i-1].getRank().getValue() && 
			   hand[i-3].getRank().getValue() == hand[i].getRank().getValue()) {
				return true;
			}
		}
		return false;
	}
	
	// FULL HOUSE: Determine if there is a three of a kind and a pair
	public boolean isFullHouse(Card[] hand) {
		for(int i = 2; i < 5; i++) {
			if(hand[i-2].getRank().getValue() == hand[i-1].getRank().getValue() && 
			   hand[i-2].getRank().getValue() == hand[i].getRank().getValue()) {
				if(i == 2 && hand[3].getRank().getValue() == hand[4].getRank().getValue() ||
				   i == 4 && hand[0].getRank().getValue() == hand[1].getRank().getValue()) {
					return true;
				}
			}
		}
		return false;
		/*if(isThreeOfAKind(hand) == true) {
			if(hand[3].getRank().getValue() == hand[4].getRank().getValue()) {
				return true;
			}
		}
		
		return false;*/
	}
	
	// THREE OF A KIND: Determine if there are 3 cards of the same rank
	public boolean isThreeOfAKind(Card[] hand) {
		for(int i = 2; i < 5; i++) {
			if(hand[i-2].getRank().getValue() == hand[i-1].getRank().getValue() && 
			   hand[i-2].getRank().getValue() == hand[i].getRank().getValue()) {
				return true;
			}
		}
		return false;
	}
	
	// STRAIGHT FLUSH: Determine if the hand is both a straight and a flush
	public boolean isStraightFlush(Card[] hand) {
		if(isStraight(hand) && isFlush(hand)) {
			return true;
		}
		return false;
	}
	
	// TWO PAIR: Determine if there are 2 different pairs in the hand
	public boolean isTwoPair(Card[] hand) {
		int count = 0;
		for(int i = 1; i < 5; i++) {
			if(hand[i-1].getRank().getValue() == hand[i].getRank().getValue()) {
				count++;
			}
		}
		if(count == 2) {
			return true;
		}
		return false;
	}
	
	// PAIR: Determine if the hand contains 1 pair
	public boolean isPair(Card[] hand) {
		int count = 0;
		for(int i = 1; i < 5; i++) {
			if(hand[i-1].getRank().getValue() == hand[i].getRank().getValue()) {
				count++;
			}
		}
		if(count == 1) {
			return true;
		}
		return false;
	}
	
	// Determines if the card is an ace
	public boolean isAce(Card card) {
		if(card.getRank().getValue() == 14) {
			return true;
		}
		return false;
	}

	// Method that compares hands
	// Equivalent: 0
	// Greater: 1
	// Smaller: -1
	@Override
	public int compareTo(PokerHand hand) {
		// Check for duplicates
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(pokerHand[i] == hand.pokerHand[j]) {
					//throw new DuplicateCardException();
				}
			}
		}
		double rankVal1 = determineRankVal(pokerHand);
		double rankVal2 = determineRankVal(hand.pokerHand);
		// Hand is bigger
		if(rankVal1 > rankVal2) {
			return 1;
		}
		// Hand is smaller
		else if(rankVal1 < rankVal2) {
			return -1;
		}
		// Same hand value, look at high card(s)
		else {
			// One pair
			if(rankVal1 == 2) {
				// Check high card of the pair first
				int pairHighCard1 = 0;
				int pairHighCard2 = 0;
				for(int i = 1; i < 5; i++) {
					if(pokerHand[i-1].getRank().getValue() == pokerHand[i].getRank().getValue()) {
						pairHighCard1 = pokerHand[i-1].getRank().getValue();
					}
				}
				for(int i = 1; i < 5; i++) {
					if(hand.pokerHand[i-1].getRank().getValue() == hand.pokerHand[i].getRank().getValue()) {
						pairHighCard2 = hand.pokerHand[i-1].getRank().getValue();
					}
				}
				// Bigger
				if(pairHighCard1 > pairHighCard2) {
					return 1;
				}
				// Smaller
				else if(pairHighCard1 < pairHighCard2) {
					return -1;
				}
				// Check other cards
				else {
					for(int i = 0; i < 5; i++) {
						// Bigger
						if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
							return 1;
						}
						// Smaller
						else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
							return -1;
						}
					}
					return 0;
				}
			}
			// Two pair
			else if(rankVal1 == 3) {
				// Index 1 has to be part of a pair and index 3 has to part of another pair
				int smallerPair1 = pokerHand[1].getRank().getValue();
				int smallerPair2 = hand.pokerHand[1].getRank().getValue();
				int biggerPair1 = pokerHand[3].getRank().getValue();
				int biggerPair2 = hand.pokerHand[3].getRank().getValue();
				// Bigger
				if(biggerPair1 > biggerPair2) {
					return 1;
				}
				// Smaller
				else if(biggerPair1 < biggerPair2) {
					return -1;
				}
				// Biggest pair is the same
				else {
					// Bigger
					if(smallerPair1 > smallerPair2) {
						return 1;
					}
					// Smaller
					else if(smallerPair1 < smallerPair2) {
						return -1;
					}
					// Smaller pair is the same, check last card
					else {				
						for(int j = 0; j < 5; j++) {
							// Bigger
							if(pokerHand[4-j].getRank().getValue() > hand.pokerHand[4-j].getRank().getValue()) {
								return 1;
							}
							// Smaller
							else if(pokerHand[4-j].getRank().getValue() < hand.pokerHand[4-j].getRank().getValue()) {
								return -1;
							}
						}
						return 0;
					}
				}	
			}
			
			// Three of a kind
			else if(rankVal1 == 4) {
				// Middle index has to be part of the three of a kind
				int threeOfAKindValue1 = pokerHand[2].getRank().getValue();
				int threeOfAKindValue2 = hand.pokerHand[2].getRank().getValue();
				// Bigger
				if(threeOfAKindValue1 > threeOfAKindValue2) {
					return 1;
				}
				// Must be smaller
				return -1;
				/*else if(threeOfAKindValue1 < threeOfAKindValue2) {
					return -1;
				}*/
				// Check other cards
				/*else {
					for(int i = 0; i < 5; i++) {
						// Bigger
						if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
							return 1;
						}
						// Smaller
						else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
							return -1;
						}
					}
					return 0;
				}*/
			}
			
			// Straight
			else if(rankVal1 == 5) {
				// High and low straight checks
				if(isLowStraight(pokerHand) && isLowStraight(hand.pokerHand)) {
					return 0;
				}
				else if(!isLowStraight(pokerHand) && isLowStraight(hand.pokerHand)) {
					return 1;
				}
				else if(isLowStraight(pokerHand) && !isLowStraight(hand.pokerHand)) {
					return -1;
				}
				else if(isHighStraight(pokerHand) && isHighStraight(hand.pokerHand)) {
					return 0;
				}
				else if(isHighStraight(pokerHand) && !isHighStraight(hand.pokerHand)) {
					return 1;
				}
				else if(!isHighStraight(pokerHand) && isHighStraight(hand.pokerHand)) {
					return -1;
				}
				// None are a high or low straight
				else {
					for(int i = 0; i < 5; i++) {
						if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
							return 1;
						}
						else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
							return -1;
						}
					}
					return 0;
				}
			}
			
			// Flush
			else if(rankVal1 == 6) {
				for(int i = 0; i < 5; i++) {
					if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
						return 1;
					}
					else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
						return -1;
					}
				}
				return 0;
			}
			
			// Full house
			else if(rankVal1 == 7) {
				// Check three of a kind first, then check two of a kind
				// Middle index has to be part of the three of a kind
				int threeOfAKindValue1 = pokerHand[2].getRank().getValue();
				int threeOfAKindValue2 = hand.pokerHand[2].getRank().getValue();
				// Bigger
				if(threeOfAKindValue1 > threeOfAKindValue2) {
					return 1;
				}
				// Must be smaller
				return -1;
				/*else if(threeOfAKindValue1 < threeOfAKindValue2) {
					return -1;
				}*/
				// Check two of a kind (other cards)
				/*else {
					for(int i = 0; i < 5; i++) {
						// Bigger
						if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
							return 1;
						}
						// Smaller
						else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
							return -1;
						}
					}
					return 0;
				}*/
			}
			
			// Four of a kind
			else if(rankVal1 == 8) {
				// Middle index has to be in the four of a kind
				int fourOfAKindValue1 = pokerHand[2].getRank().getValue();
				int fourOfAKindValue2 = hand.pokerHand[2].getRank().getValue();
				// Bigger
				if(fourOfAKindValue1 > fourOfAKindValue2) {
					return 1;
				}
				// Must be smaller
				return -1;
				/*else if(fourOfAKindValue1 < fourOfAKindValue2) {
					return -1;
				}
				// Check other cards
				else {
					for(int i = 0; i < 5; i++) {
						// Bigger
						if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
							return 1;
						}
						// Smaller
						else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
							return -1;
						}
					}
					return 0;
				}*/
			}
			
			// Straight flush
			else if(rankVal1 == 9) {
				// High and low straight checks
				if(isLowStraight(pokerHand) && isLowStraight(hand.pokerHand)) {
					return 0;
				}
				else if(!isLowStraight(pokerHand) && isLowStraight(hand.pokerHand)) {
					return 1;
				}
				else if(isLowStraight(pokerHand) && !isLowStraight(hand.pokerHand)) {
					return -1;
				}
				else if(isHighStraight(pokerHand) && isHighStraight(hand.pokerHand)) {
					return 0;
				}
				else if(isHighStraight(pokerHand) && !isHighStraight(hand.pokerHand)) {
					return 1;
				}
				else if(!isHighStraight(pokerHand) && isHighStraight(hand.pokerHand)) {
					return -1;
				}
				// None are a high or low straight
				else {
					for(int i = 0; i < 5; i++) {
						if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
							return 1;
						}
						else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
							return -1;
						}
					}
					return 0;
				}
			}
			// Must be high card
			else {
				for(int i = 0; i < 5; i++) {
					if(pokerHand[4-i].getRank().getValue() > hand.pokerHand[4-i].getRank().getValue()) {
						return 1;
					}
					else if(pokerHand[4-i].getRank().getValue() < hand.pokerHand[4-i].getRank().getValue()) {
						return -1;
					}					
				}
				return 0;		
			}
		}
	}
	
	// rankVal 9: Straight flush
	// rankVal 8: Four of a kind
	// rankVal 7: Full house
	// rankVal 6: Flush
	// rankVal 5: Straight
	// rankVal 4: Three of a kind
	// rankVal 3: Two pair
	// rankVal 2: One pair
	// rankVal 1: High card
	// rankVal 0: Unassigned
	public String rankStr(PokerHand hand) {
		int rank = determineRankVal(hand.pokerHand);
		if(rank == 9) {
			return "Straight Flush";
		}
		else if(rank == 8) {
			return "Four of a Kind";
		}
		else if(rank == 7) {
			return "Full House";
		}
		else if(rank == 6) {
			return "Flush";
		}
		else if(rank == 5) {
			return "Straight";
		}
		else if(rank == 4) {
			return "Three of a Kind";
		}
		else if(rank == 3) {
			return "Two Pair";
		}
		else if(rank == 2) {
			return "One Pair";
		}
		else if(rank == 1) {
			return "High Card";
		}
		else {
			return null;
		}
	}
}
