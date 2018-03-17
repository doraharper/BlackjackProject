package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class Dealer {
	
	private Deck deck = new Deck();
	private Hand dealerHand = new Hand();

	public Hand getDealerHand() {
		return dealerHand;
	}

	
	public Deck getDeck() {
		return deck;
	}
	
	
	
	// Dealer deals hand
	

}
