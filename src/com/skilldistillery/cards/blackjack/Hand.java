package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Hand {
	private List<Card> hand = new ArrayList<>();

	public void addCard(Card card) {
		hand.add(card);

	}

	public List<Card> getCardsInHand() {
		return hand;
	}

	public int getValueOfHand() {
	int counter = 0; 
		for (Card card : hand) {
			counter += card.getValue();	
		}
		return counter;
		
	}
	public void clearHand() {
		hand = new ArrayList<>();
	}
	
	public Card showTopCard() {
		return hand.get(0);
	}

	@Override
	public String toString() {
		return hand.toString();
	}
	
}