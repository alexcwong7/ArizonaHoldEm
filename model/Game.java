package model;
// Author: Alex Wong
// Purpose: Contains a main method that coordinates activity

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Enter number of players (2-10)
		System.out.print("How many players? ");
		int playerCount = scan.nextInt();
		
		// Create deck
		Deck deck = new Deck();
		
		// Create players and give cards
		Player[] players = new Player[playerCount];
		for(int i = 0; i < playerCount; i++) {
			players[i] = new Player();
			players[i].givenCard1 = deck.drawCard();
			players[i].givenCard2 = deck.drawCard();
		}
		
		// Get ante and put in pot
		double pot = 0;
		for(int i = 0; i < playerCount; i++) {
			players[i].balance -= 2.00;
			pot += 2.00;
		}
		
		// Create community cards
		Card[] community = new Card[5];
		for(int i = 0; i < 5; i++) {
			community[i] = deck.drawCard();
		}
		
		// Print community cards
		System.out.print("\nCommunity Cards:");
		for(int i = 0; i < 5; i++) {
			System.out.print(" "+community[i].getRank().getValue());
			community[i].printSuitSymbol(community[i].getSuit());
		}
		System.out.println("\n++++++++++++++++++++++++++++++++++++");
		
		// Print players money and initial cards
		for(int i = 0; i < playerCount; i++) {
			int playerNum = i+1;
			System.out.print("Player "+ playerNum + ": " + players[i].balanceFormatted(players[i].getBalance()) + " -");
			System.out.print(" "+players[i].givenCard1.getRank().getValue());
			players[i].givenCard1.printSuitSymbol(players[i].givenCard1.getSuit());
			System.out.print(" "+players[i].givenCard2.getRank().getValue());
			players[i].givenCard2.printSuitSymbol(players[i].givenCard2.getSuit());
			
			// Print best hand
			System.out.println();
			System.out.print("   Best hand: ");
			PokerHand bestHand = players[i].bestHand(community);
			for(int j = 0; j < 5; j++) {
				System.out.print(" "+bestHand.pokerHand[j].getRank().getValue());
				bestHand.pokerHand[j].printSuitSymbol(bestHand.pokerHand[j].getSuit());
			}
			System.out.println(" - "+bestHand.rankStr(bestHand)+"\n");
		}
		
		// Find winner
		Player winning = players[0];
		int playerNum = 1;
		int index = 0;
		for(int i = 0; i < playerCount; i++) {
			if(winning.bestHand(community).compareTo(players[i].bestHand(community)) < 0) {
				winning = players[i];
				playerNum = i+1;
				index = i;
			}
		}
		// Look for ties
		int[] tieIndex = new int[playerCount];
		int tieCount = 0;
		for(int i = 0; i < playerCount; i++) {
			if(winning.bestHand(community).compareTo(players[i].bestHand(community)) == 0) {
				tieIndex[tieCount] = i;
				tieCount++;
			}
		}
		
		if(tieCount <= 1) {
			// Print winner and hand 
			players[index].balance += pot;
			System.out.println("Winner: Player "+ playerNum +" "+players[index].balanceFormatted(players[index].getBalance()));
			System.out.println("++++++++++++++++++++++++++++++++++++");
			PokerHand bestHand = players[index].bestHand(community);
			System.out.print("   " + bestHand.rankStr(bestHand)+ " ");
			for(int i = 0; i < 5; i++) {
				System.out.print(" "+bestHand.pokerHand[i].getRank().getValue());
				bestHand.pokerHand[i].printSuitSymbol(bestHand.pokerHand[i].getSuit());
			}
			System.out.println();
		}
		
		else {
			System.out.println("Winning hands (tie)");
			double splitPot = pot/tieCount;
			for(int x = 0; x < tieCount; x++) {
				int playerIndex = tieIndex[x]+1;
				players[tieIndex[x]].balance += splitPot;
				// Print winner's cards and balance
				PokerHand bestHand = players[index].bestHand(community);
				for(int y = 0; y < 5; y++) {
					System.out.print(" "+bestHand.pokerHand[y].getRank().getValue());
					bestHand.pokerHand[y].printSuitSymbol(bestHand.pokerHand[y].getSuit());
				}
				// Print hand type, player number and balance
				System.out.print(" "+bestHand.rankStr(bestHand));
				System.out.println(" Player " + playerIndex + " " + players[tieIndex[x]].balanceFormatted(players[tieIndex[x]].getBalance()));
			}
		}
		
		// While there is still input
		System.out.print("\nPlay another game? y or n ");
		while(scan.next().charAt(0) == 'y' ) {
			// Create deck
			deck = new Deck();
			
			// Create players and give cards
			//players = new Player[playerCount];
			for(int i = 0; i < playerCount; i++) {
				
				players[i].givenCard1 = deck.drawCard();
				players[i].givenCard2 = deck.drawCard();
			}
			
			// Get ante and put in pot
			pot = 0;
			for(int i = 0; i < playerCount; i++) {
				players[i].balance -= 2.00;
				pot += 2.00;
			}
			
			// Create community cards
			community = new Card[5];
			for(int i = 0; i < 5; i++) {
				community[i] = deck.drawCard();
			}
			
			// Print community cards
			System.out.print("\nCommunity Cards:");
			for(int i = 0; i < 5; i++) {
				System.out.print(" "+community[i].getRank().getValue());
				community[i].printSuitSymbol(community[i].getSuit());
			}
			System.out.println("\n++++++++++++++++++++++++++++++++++++");
			
			// Print players money and initial cards
			for(int i = 0; i < playerCount; i++) {
				playerNum = i+1;
				System.out.print("Player "+ playerNum + ": " + players[i].balanceFormatted(players[i].getBalance()) + " -");
				System.out.print(" "+players[i].givenCard1.getRank().getValue());
				players[i].givenCard1.printSuitSymbol(players[i].givenCard1.getSuit());
				System.out.print(" "+players[i].givenCard2.getRank().getValue());
				players[i].givenCard2.printSuitSymbol(players[i].givenCard2.getSuit());
				
				// Print best hand
				System.out.println();
				System.out.print("   Best hand: ");
				PokerHand bestHand = players[i].bestHand(community);
				for(int j = 0; j < 5; j++) {
					System.out.print(" "+bestHand.pokerHand[j].getRank().getValue());
					bestHand.pokerHand[j].printSuitSymbol(bestHand.pokerHand[j].getSuit());
				}
				System.out.println(" - "+bestHand.rankStr(bestHand)+"\n");
			}
			
			// Find winner
			winning = players[0];
			playerNum = 1;
			index = 0;
			for(int i = 0; i < playerCount; i++) {
				if(winning.bestHand(community).compareTo(players[i].bestHand(community)) < 0) {
					winning = players[i];
					playerNum = i+1;
					index = i;
				}
			}
			// Look for ties
			tieIndex = new int[playerCount];
			tieCount = 0;
			for(int i = 0; i < playerCount; i++) {
				if(winning.bestHand(community).compareTo(players[i].bestHand(community)) == 0) {
					tieIndex[tieCount] = i;
					tieCount++;
				}
			}
			
			if(tieCount <= 1) {
				// Print winner and hand 
				players[index].balance += pot;
				System.out.println("Winner: Player "+ playerNum +" "+players[index].balanceFormatted(players[index].getBalance()));
				System.out.println("++++++++++++++++++++++++++++++++++++");
				PokerHand bestHand = players[index].bestHand(community);
				System.out.print("   " + bestHand.rankStr(bestHand)+ " ");
				for(int i = 0; i < 5; i++) {
					System.out.print(" "+bestHand.pokerHand[i].getRank().getValue());
					bestHand.pokerHand[i].printSuitSymbol(bestHand.pokerHand[i].getSuit());
				}
				System.out.println();
			}
			
			else {
				System.out.println("Winning hands (tie)");
				double splitPot = pot/tieCount;
				for(int x = 0; x < tieCount; x++) {
					int playerIndex = tieIndex[x]+1;
					players[tieIndex[x]].balance += splitPot;
					// Print winner's cards and balance
					PokerHand bestHand = players[index].bestHand(community);
					for(int y = 0; y < 5; y++) {
						System.out.print(" "+bestHand.pokerHand[y].getRank().getValue());
						bestHand.pokerHand[y].printSuitSymbol(bestHand.pokerHand[y].getSuit());
					}
					// Print hand type, player number and balance
					System.out.print(" "+bestHand.rankStr(bestHand));
					System.out.println(" Player " + playerIndex + " " + players[tieIndex[x]].balanceFormatted(players[tieIndex[x]].getBalance()));
				}
			}
			System.out.print("\nPlay another game? y or n ");
		}
		scan.close();
	}
}
