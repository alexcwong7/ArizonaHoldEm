package tests;

// Author: Alex Wong
// Purpose: Testing class for PokerHand

import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the PokerHand class and the enums
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test
 * methods)
 * 
 * There are also some additional test cases here. But this is in no way
 * complete. Many more are needed
 */
public class PokerHandTest {

	@Test
	public void testSuitEnum() {
		String result = "";
		for (Suit suit : Suit.values())
			result += suit + " ";
		assertEquals("CLUBS DIAMONDS HEARTS SPADES", result.trim());
	}

	@Test
	public void testRankEnum() {
		String result = "";
		for (Rank rank : Rank.values())
			result += rank + " ";
		assertEquals("DEUCE THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE", result.trim());
	}

	// Do not allow duplicate cards, throw an exception
	/*@Test(expected = DuplicateCardException.class)
	public void tryToAddTheSameCardTwiceA() {
		new PokerHand(C2, C3, C4, C5, C5);
	}

	@Test(expected = DuplicateCardException.class)
	public void testPair2() {
		PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
		a.toString();
		PokerHand b = new PokerHand(H3, C5, HA, SA, C6);
		assertTrue(a.compareTo(b) < 0);
	}*/

	@Test
	public void testTwoPairWhenOnePairIsEqual() {
		PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
		PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testAceLowStraight() {
		PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
		PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
		boolean answer = a.compareTo(b) < 0;
		assertTrue(answer);
	}

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce,
	// Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	// TEST CARD HGH HANDS

	private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
	private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
	private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
	private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
	private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
	private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);

	@Test
	public void testNothing0() {
		assertTrue(nothing73.compareTo(nothing72) > 0);
	}

	@Test
	public void testNothing1() {
		assertTrue(nothingJ.compareTo(nothing73) > 0);
	}

	@Test
	public void testNothing2() {
		assertTrue(nothingK8.compareTo(nothingJ) > 0);
	}

	@Test
	public void testNothing3() {
		assertTrue(nothingK9.compareTo(nothingK8) > 0);
	}

	@Test
	public void testNothing4() {
		assertTrue(nothingA.compareTo(nothingK8) > 0);
	}

	// Many more tests needed
	@Test
	public void testSort() {
		PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
		assertEquals(DA, a.pokerHand[4]);
		assertEquals(CA, a.pokerHand[3]);
		assertEquals(H6, a.pokerHand[2]);
		assertEquals(D4, a.pokerHand[1]);
		assertEquals(H3, a.pokerHand[0]);
	}
	
	// Method tests
	
	@Test
	public void testAce() {
		Card ace = new Card(Rank.ACE, Suit.SPADES);
		Card ace2 = new Card(Rank.ACE, Suit.DIAMONDS);
		Card notAce = new Card(Rank.TEN, Suit.CLUBS);
		Card notAce2 = new Card(Rank.FOUR, Suit.HEARTS);
		Card notAce3 = new Card(Rank.KING, Suit.CLUBS);
		PokerHand aceHand = new PokerHand(ace, ace2, notAce, notAce2, notAce3);
		assertTrue(aceHand.isAce(ace));
		assertTrue(aceHand.isAce(ace2));
		assertFalse(aceHand.isAce(notAce));
		assertFalse(aceHand.isAce(notAce2));
		assertFalse(aceHand.isAce(notAce3));
	}
	
	@Test
	public void testHighCard() {
		PokerHand high = new PokerHand(DJ, D7, C2, C8, SA);
		PokerHand high2 = new PokerHand(CA, S8, C4, D2, H3);
		PokerHand notHigh = new PokerHand(C6, D3, D6, CA, S9);
		PokerHand notHigh2 = new PokerHand(C8, D7, D4, H5, H6);
		assertEquals(1, high.determineRankVal(high.pokerHand));
		assertEquals(1, high2.determineRankVal(high2.pokerHand));
		assertEquals(2, notHigh.determineRankVal(notHigh.pokerHand));
		assertEquals(5, notHigh2.determineRankVal(notHigh2.pokerHand));
	}
	
	@Test
	public void testPair() {
		PokerHand onePair = new PokerHand(C2, D4, C4, C5, D7);
		PokerHand onePair2 = new PokerHand(H2, C3, S2, C5, D7);
		PokerHand notPair = new PokerHand(C2, C3, C4, C5, D7);
		PokerHand notPair2 = new PokerHand(S2, C3, D4, CJ, D7);
		assertTrue(onePair.isPair(onePair.pokerHand));
		assertTrue(onePair2.isPair(onePair2.pokerHand));
		assertFalse(notPair.isPair(notPair.pokerHand));
		assertFalse(notPair2.isPair(notPair2.pokerHand));	
	}
	
	@Test
	public void testTwoPair() {
		PokerHand twoPair = new PokerHand(S5, D5, SQ, CQ, H3);
		PokerHand twoPair2 = new PokerHand(D9, D7, C9, H9, H6);
		PokerHand notTwoPair = new PokerHand(S8, SQ, H2, C5, S2);
		PokerHand notTwoPair2 = new PokerHand(DJ, CA, DA, H8, H7);
		assertTrue(twoPair.isTwoPair(twoPair.pokerHand));
		assertTrue(twoPair2.isTwoPair(twoPair2.pokerHand));
		assertFalse(notTwoPair.isTwoPair(notTwoPair.pokerHand));
		assertFalse(notTwoPair2.isTwoPair(notTwoPair2.pokerHand));
	}
	
	@Test
	public void testThreeOfAKind() {
		PokerHand three = new PokerHand(DQ, DA, CQ, HQ, S5);
		PokerHand three2 = new PokerHand(H6, C6, D2, D6, S9);
		PokerHand notThree = new PokerHand(CQ, CJ, D3, S4, HK);
		PokerHand notThree2 = new PokerHand(HJ, C4, H8, D5, D9);
		assertTrue(three.isThreeOfAKind(three.pokerHand));
		assertTrue(three2.isThreeOfAKind(three2.pokerHand));
		assertFalse(notThree.isThreeOfAKind(notThree.pokerHand));
		assertFalse(notThree2.isThreeOfAKind(notThree2.pokerHand));
	}
	
	@Test
	public void testStraight() {
		PokerHand straight = new PokerHand(H3, D4, H5, C7, S6);
		PokerHand straight2 = new PokerHand(DJ, H9, S10, C8, C7);
		PokerHand notStraight = new PokerHand(SQ, D7, CK, H2, H5);
		PokerHand notStraight2 = new PokerHand(D8, D9, DJ, C5, S2);
		assertTrue(straight.isStraight(straight.pokerHand));
		assertTrue(straight2.isStraight(straight2.pokerHand));
		assertFalse(notStraight.isStraight(notStraight.pokerHand));
		assertFalse(notStraight2.isStraight(notStraight2.pokerHand));
	}
	
	@Test
	public void testLowStraight() {
		PokerHand low = new PokerHand(C2, C5, DA, H3, S4);
		PokerHand low2 = new PokerHand(HA, H2, D4, S3, C5);
		PokerHand notLow = new PokerHand(D10, H3, HA, C10, S5);
		PokerHand notLow2 = new PokerHand(DQ, H10, H7, SJ, C2);
		assertTrue(low.isLowStraight(low.pokerHand));
		assertTrue(low2.isLowStraight(low2.pokerHand));
		assertFalse(notLow.isLowStraight(notLow.pokerHand));
		assertFalse(notLow2.isLowStraight(notLow2.pokerHand));
	}
	
	@Test
	public void testHighStraight() {
		PokerHand high = new PokerHand(CJ, CA, SK, DQ, H10);
		PokerHand high2 = new PokerHand(DA, CQ, HK, C10, CJ);
		PokerHand notHigh = new PokerHand(CA, H10, DA, DK, DQ);
		PokerHand notHigh2 = new PokerHand(C8, HA, DQ, HK, S9);
		assertTrue(high.isHighStraight(high.pokerHand));
		assertTrue(high2.isHighStraight(high2.pokerHand));
		assertFalse(notHigh.isHighStraight(notHigh.pokerHand));
		assertFalse(notHigh2.isHighStraight(notHigh2.pokerHand));
	}
	
	@Test
	public void testFlush() {
		PokerHand flush = new PokerHand(D4, DJ, D10, D8, DK);
		PokerHand flush2 = new PokerHand(S2, S5, SQ, S9, S6);
		PokerHand notFlush = new PokerHand(S8, D10, DJ, DQ, D4);
		PokerHand notFlush2 = new PokerHand(S7, S8, SA, C2, C8);
		assertTrue(flush.isFlush(flush.pokerHand));
		assertTrue(flush2.isFlush(flush2.pokerHand));
		assertFalse(notFlush.isFlush(notFlush.pokerHand));
		assertFalse(notFlush2.isFlush(notFlush2.pokerHand));
	}
	
	@Test
	public void testFullHouse() {
		PokerHand fullHouse = new PokerHand(D5, HJ, C5, CJ, H5);
		PokerHand fullHouse2 = new PokerHand(C8, D8, H9, D9, S8);
		PokerHand notFullHouse = new PokerHand(D2, CA, C2, H2, CJ);
		PokerHand notFullHouse2 = new PokerHand(HQ, H7, D7, CQ, S2);
		assertTrue(fullHouse.isFullHouse(fullHouse.pokerHand));
		assertTrue(fullHouse2.isFullHouse(fullHouse2.pokerHand));
		assertFalse(notFullHouse.isFullHouse(notFullHouse.pokerHand));
		assertFalse(notFullHouse2.isFullHouse(notFullHouse2.pokerHand));
		PokerHand fullHouse22 = new PokerHand(C2, D2, C4, D4, H4);
		assertTrue(fullHouse22.isFullHouse(fullHouse2.pokerHand));
	}
	
	@Test
	public void testFourOfAKind() {
		PokerHand four = new PokerHand(H6, D6, C6, S6, SK);
		PokerHand four2 = new PokerHand(SA, CA, DA, C5, HA);
		PokerHand notFour = new PokerHand(DQ, D8, S8, HQ, C9);
		PokerHand notFour2 = new PokerHand(C7, CJ, DJ, HJ, S9);
		assertTrue(four.isFourOfAKind(four.pokerHand));
		assertTrue(four2.isFourOfAKind(four2.pokerHand));
		assertFalse(notFour.isFourOfAKind(notFour.pokerHand));
		assertFalse(notFour2.isFourOfAKind(notFour2.pokerHand));
	}
	
	@Test
	public void testStraightFlush() {
		PokerHand straightFlush = new PokerHand(S7, S8, S6, S5, S9);
		PokerHand straightFlush2 = new PokerHand(CJ, CQ, C9, C10, CK);
		PokerHand notStraightFlush = new PokerHand(H8, S2, S4, C3, D5);
		PokerHand notStraightFlush2 = new PokerHand(CA, C2, HK, D3, SQ);
		assertTrue(straightFlush.isStraightFlush(straightFlush.pokerHand));
		assertTrue(straightFlush2.isStraightFlush(straightFlush2.pokerHand));
		assertFalse(notStraightFlush.isStraightFlush(notStraightFlush.pokerHand));
		assertFalse(notStraightFlush2.isStraightFlush(notStraightFlush2.pokerHand));
	}
	
	// Hand comparison tests
	
	@Test
	public void testAllRankingsNotSame() {
		PokerHand highCard = new PokerHand(DJ, D7, C2, C8, SA);
		PokerHand highCard2 = new PokerHand(CA, S8, C4, D2, H3);
		PokerHand onePair = new PokerHand(C2, D4, C4, C5, D7);
		PokerHand onePair2 = new PokerHand(H2, C3, S2, C5, D7);
		PokerHand twoPair = new PokerHand(S5, D5, SQ, CQ, H3);
		PokerHand twoPair2 = new PokerHand(D9, D7, C9, D6, H6);
		PokerHand three = new PokerHand(DQ, DA, CQ, HQ, S5);
		PokerHand three2 = new PokerHand(H6, C6, D2, D6, S9);
		PokerHand low = new PokerHand(C2, C5, DA, H3, S4);
		PokerHand low2 = new PokerHand(HA, H2, D4, S3, C5);
		PokerHand straight = new PokerHand(H3, D4, H5, C7, S6);
		PokerHand straight2 = new PokerHand(DJ, H9, S10, C8, C7);
		PokerHand high = new PokerHand(CJ, CA, SK, DQ, H10);
		PokerHand high2 = new PokerHand(DA, CQ, HK, C10, CJ);
		PokerHand flush = new PokerHand(D4, DJ, D10, D8, DK);
		PokerHand flush2 = new PokerHand(S2, S5, SQ, S9, S6);
		PokerHand fullHouse = new PokerHand(D5, HJ, C5, CJ, H5);
		PokerHand fullHouse2 = new PokerHand(C8, D8, H9, D9, S8);
		PokerHand four = new PokerHand(H6, D6, C6, S6, SK);
		PokerHand four2 = new PokerHand(SA, CA, DA, C5, HA);
		PokerHand straightFlush = new PokerHand(S7, S8, S6, S5, S9);
		PokerHand straightFlush2 = new PokerHand(CJ, CQ, C9, C10, CK);
		assertTrue(onePair.compareTo(twoPair) < 0);
		assertTrue(onePair.compareTo(three) < 0);
		assertTrue(onePair.compareTo(straight2) < 0);
		assertTrue(onePair2.compareTo(flush) < 0);
		assertTrue(onePair2.compareTo(fullHouse2) < 0);
		assertTrue(onePair.compareTo(four) < 0);
		assertTrue(onePair.compareTo(straightFlush) < 0);
		assertTrue(onePair2.compareTo(highCard2) > 0);
		assertTrue(twoPair2.compareTo(three) < 0);
		assertTrue(twoPair2.compareTo(low) < 0);
		assertTrue(twoPair2.compareTo(straight) < 0);
		assertTrue(twoPair2.compareTo(high) < 0);
		assertTrue(twoPair2.compareTo(flush) < 0);
		assertTrue(twoPair2.compareTo(fullHouse) < 0);
		assertTrue(twoPair2.compareTo(four2) < 0);
		assertTrue(twoPair2.compareTo(straightFlush) < 0);
		assertTrue(three.compareTo(low2) < 0);
		assertTrue(three.compareTo(straight) < 0);
		assertTrue(three2.compareTo(high2) < 0);
		assertTrue(three.compareTo(flush) < 0);
		assertTrue(three.compareTo(fullHouse) < 0);
		assertTrue(three.compareTo(four) < 0);
		assertTrue(three2.compareTo(straightFlush2) < 0);
		assertTrue(low2.compareTo(straight2) < 0);
		assertTrue(low.compareTo(high) < 0);
		assertTrue(low.compareTo(flush) < 0);
		assertTrue(low.compareTo(fullHouse2) < 0);
		assertTrue(low.compareTo(four) < 0);
		assertTrue(low.compareTo(straightFlush) < 0);
		assertTrue(straight.compareTo(high) < 0);
		assertTrue(straight2.compareTo(flush2) < 0);
		assertTrue(straight.compareTo(fullHouse2) < 0);
		assertTrue(straight.compareTo(four2) < 0);
		assertTrue(straight.compareTo(straightFlush2) < 0);
		assertTrue(high.compareTo(flush) < 0);
		assertTrue(high.compareTo(fullHouse2) < 0);
		assertTrue(high2.compareTo(four) < 0);
		assertTrue(high.compareTo(straightFlush) < 0);
		assertTrue(flush.compareTo(fullHouse) < 0);
		assertTrue(flush.compareTo(four) < 0);
		assertTrue(flush.compareTo(straightFlush) < 0);
		assertTrue(fullHouse.compareTo(four) < 0);
		assertTrue(fullHouse.compareTo(straightFlush) < 0);
		assertTrue(four.compareTo(straightFlush2) < 0);
		
		assertTrue(straightFlush.compareTo(fullHouse) > 0);
		assertTrue(flush2.compareTo(straight2) > 0);
		assertTrue(high.compareTo(low) > 0);
		assertTrue(four.compareTo(high2) > 0);
		assertTrue(straightFlush2.compareTo(highCard) > 0);
		assertTrue(three2.compareTo(low2) < 0);
		assertTrue(four2.compareTo(straight) > 0);	
		
		PokerHand fullHouse22 = new PokerHand(C2, D2, C4, D4, H4);
		PokerHand threeKindHigh = new PokerHand(CA, HA, DA, CK, CQ);
		assertEquals(7, fullHouse22.determineRankVal(fullHouse22.pokerHand));
		assertEquals(4, threeKindHigh.determineRankVal(threeKindHigh.pokerHand));
	    //assertTrue(fullHouse22.compareTo(threeKindHigh) > 0);

	}
	
	@Test
	public void testHighCardSameRank() {
		PokerHand high = new PokerHand(DJ, D7, C2, C8, SA);
		PokerHand high2 = new PokerHand(CA, S8, C4, D2, H3);
		PokerHand highSame = new PokerHand(CJ, C7, D2, D8, CA);
		assertTrue(high.compareTo(high2) > 0);
		assertTrue(high2.compareTo(high) < 0);
		assertTrue(high.compareTo(highSame) == 0);
	}
	
	@Test
	public void testPairSameRank() {
		PokerHand onePair = new PokerHand(C2, D4, C4, C5, D7);
		PokerHand onePair2 = new PokerHand(H2, C3, S2, C9, D8);
		PokerHand onePairSame = new PokerHand(D2, S4, H4, D5, C7);
		PokerHand onePairSamePairOnly = new PokerHand(H4, S4, CQ, H2, H3);
		assertTrue(onePair.compareTo(onePair2) > 0);
		assertTrue(onePair2.compareTo(onePair) < 0);
		assertTrue(onePair.compareTo(onePairSame) == 0);
		assertTrue(onePair.compareTo(onePairSamePairOnly) < 0);
		assertTrue(onePairSamePairOnly.compareTo(onePair) > 0);
	}
	
	@Test
	public void testTwoPairSameRank() {
		PokerHand twoPair = new PokerHand(S5, D5, SQ, CQ, H3);
		PokerHand twoPair2 = new PokerHand(D9, D7, C7, H9, H6);
		PokerHand twoPairSame = new PokerHand(C5, H5, DQ, HQ, S3);
		PokerHand twoPairSamePairOnly = new PokerHand(C6, H6, DQ, HQ, H4);
		PokerHand twoPairSamePair2 = new PokerHand(C5, H5, DQ, HQ, H4);
		assertTrue(twoPair.compareTo(twoPair2) > 0);
		assertTrue(twoPair2.compareTo(twoPair) < 0);
		assertTrue(twoPair.compareTo(twoPairSame) == 0);
		assertTrue(twoPair.compareTo(twoPairSamePairOnly) < 0);
		assertTrue(twoPairSamePairOnly.compareTo(twoPair) > 0);
		assertTrue(twoPair.compareTo(twoPairSamePair2) < 0);
		assertTrue(twoPairSamePair2.compareTo(twoPair) > 0);
	}
	
	@Test
	public void testThreeOfAKindSameRank() {
		PokerHand three = new PokerHand(DQ, DA, CQ, HQ, S5);
		PokerHand three2 = new PokerHand(H6, C6, D2, D6, S9);
		assertTrue(three.compareTo(three2) > 0);
		assertTrue(three2.compareTo(three) < 0);
	}
	
	@Test
	public void testLowStraightSameRank() {
		PokerHand low = new PokerHand(C2, C5, DA, H3, S4);
		PokerHand low2 = new PokerHand(HA, H2, D4, S3, S5);
		assertTrue(low.compareTo(low2) == 0);
		assertTrue(low2.compareTo(low) == 0);
	}
	
	@Test
	public void testStraightSameRank() {
		PokerHand straight = new PokerHand(H3, D4, H5, C7, S6);
		PokerHand straight2 = new PokerHand(DJ, H9, S10, C8, D7);
		PokerHand straightSame = new PokerHand(C3, H4, D5, H7, D6);
		assertTrue(straight.compareTo(straight2) < 0);
		assertTrue(straight2.compareTo(straight) > 0);
		assertTrue(straight.compareTo(straightSame) == 0);
		assertTrue(straightSame.compareTo(straight) == 0);
	}
	
	@Test
	public void testHighStraightSameRank() {
		PokerHand high = new PokerHand(CJ, CA, SK, DQ, H10);
		PokerHand high2 = new PokerHand(DA, CQ, HK, C10, DJ);
		assertTrue(high.compareTo(high2) == 0);
		assertTrue(high2.compareTo(high) == 0);
	}
	
	@Test
	public void testHighAndLowStraightSameRank() {
		PokerHand low = new PokerHand(C2, C5, DA, H3, S4);
		PokerHand neither = new PokerHand(DJ, H9, S10, C8, D7);
		PokerHand high = new PokerHand(CJ, CA, SK, DQ, H10);
		assertTrue(low.compareTo(neither) < 0);
		assertTrue(low.compareTo(high) < 0);
		assertTrue(neither.compareTo(low) > 0);
		assertTrue(neither.compareTo(high) < 0);
		assertTrue(high.compareTo(low) > 0);
		assertTrue(high.compareTo(neither) > 0);
	}
	
	@Test
	public void testFlushSameRank() {
		PokerHand flush = new PokerHand(D4, DJ, D10, D8, DK);
		PokerHand flush2 = new PokerHand(S2, S5, SQ, S9, S6);
		PokerHand flushSame = new PokerHand(C4, CJ, C10, C8, CK);
		assertTrue(flush.compareTo(flush2) > 0);
		assertTrue(flush2.compareTo(flush) < 0);
		assertTrue(flush.compareTo(flushSame) == 0);
	}
	
	@Test
	public void testFullHouseSameRank() {
		PokerHand fullHouse = new PokerHand(D5, HJ, C5, CJ, H5);
		PokerHand fullHouse2 = new PokerHand(C8, D8, H9, D9, S8);
		assertTrue(fullHouse.compareTo(fullHouse2) < 0);
		assertTrue(fullHouse2.compareTo(fullHouse) > 0);
	}
	
	@Test
	public void testFourOfAKindSameRank() {
		PokerHand four = new PokerHand(H6, D6, C6, S6, SK);
		PokerHand four2 = new PokerHand(SA, CA, DA, C5, HA);
		assertTrue(four.compareTo(four2) < 0);
		assertTrue(four2.compareTo(four) > 0);
	}
	
	@Test
	public void testLowStraightFlushSameRank() {
		PokerHand low = new PokerHand(CA, C2, C3, C4, C5);
		PokerHand low2 = new PokerHand(DA, D2, D3, D4, D5);
		assertTrue(low.compareTo(low2) == 0);
		assertTrue(low2.compareTo(low) == 0);
	}
	
	@Test
	public void testStraightFlushSameRank() {
		PokerHand straightFlush = new PokerHand(S7, S8, S6, S5, S9);
		PokerHand straightFlush2 = new PokerHand(CJ, CQ, C9, C10, CK);
		PokerHand straightFlushSame = new PokerHand(D7, D5, D6, D8, D9);
		assertTrue(straightFlush.compareTo(straightFlush2) < 0);
		assertTrue(straightFlush2.compareTo(straightFlush) > 0);
		assertTrue(straightFlush.compareTo(straightFlushSame) == 0);
		assertTrue(straightFlushSame.compareTo(straightFlush) == 0);
	}
	
	@Test
	public void testHighStraightFlushSameRank() {
		PokerHand high = new PokerHand(S10, SJ, SQ, SK, SA);
		PokerHand high2 = new PokerHand(H10, HJ, HQ, HK, HA);
		assertTrue(high.compareTo(high2) == 0);
		assertTrue(high2.compareTo(high) == 0);
	}
	
	@Test
	public void testLowAndHighStraightFlushSameRank() {
		PokerHand low = new PokerHand(CA, C2, C3, C4, C5);
		PokerHand neither = new PokerHand(H5, H6, H7, H8, H9);
		PokerHand high = new PokerHand(S10, SJ, SQ, SK, SA);
		assertTrue(low.compareTo(high) < 0);
		assertTrue(high.compareTo(low) > 0);
		assertTrue(neither.compareTo(high) < 0);
		assertTrue(neither.compareTo(low) > 0);
		assertTrue(low.compareTo(neither) < 0);
		assertTrue(high.compareTo(neither) > 0);
	}
	
}