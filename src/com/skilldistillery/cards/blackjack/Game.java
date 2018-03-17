package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class Game {

	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Scanner sc = new Scanner(System.in);

	public void playGame() {
		System.out.println("Do you want to play? Yes/No");
		String answer = sc.next();
		dealer.getDeck().shuffle();

		if (answer.equalsIgnoreCase("Yes")) {
			player.getPlayerHand().addCard(dealer.getDeck().dealCard());
			dealer.getDealerHand().addCard(dealer.getDeck().dealCard());
			player.getPlayerHand().addCard(dealer.getDeck().dealCard());
			dealer.getDealerHand().addCard(dealer.getDeck().dealCard());
		} else {
			System.out.println("Bye");
			System.exit(0);
		}
		System.out.println("PlayerHand: " + player.getPlayerHand());
		System.out.println("Dealer is showing: " + dealer.getDealerHand().showTopCard());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println("Would you like to hit or stay? ");
		String answerHitStay = sc.next();

		while (answerHitStay.equalsIgnoreCase("Hit")) {
			player.getPlayerHand().addCard(dealer.getDeck().dealCard());
			System.out.println("PlayerHand: " + player.getPlayerHand() + " \nThe value of your hand is "
					+ player.getPlayerHand().getValueOfHand());

			if (player.getPlayerHand().getValueOfHand() > 21) {
				System.out.println("You lose!");
				resetRound();
			}
			System.out.println("Would you like to hit or stay? ");
			answerHitStay = sc.next();
		}
		while (dealer.getDealerHand().getValueOfHand() <17 ) {
			dealer.getDealerHand().addCard(dealer.getDeck().dealCard());
			if (dealer.getDealerHand().getValueOfHand() > 21) {
				System.out.println("Woooo Hooooo! You beat the dealer!");
				System.out.println("Player's hand: " + player.getPlayerHand() + " \nThe value of your hand is "
						+ player.getPlayerHand().getValueOfHand());
				System.out.println("Dealer's hand: " + dealer.getDealerHand() + " \nThe value of the dealer's hand is "
						+ dealer.getDealerHand().getValueOfHand());
				resetRound();
				
			}
		}
		checkIfPlayerWon();
		
	} 
	
	
	/// player stays
	private void resetRound() {
		dealer.getDealerHand().clearHand();
		player.getPlayerHand().clearHand();
		playGame();
	}
	
	private void checkIfPlayerWon() {
		if(player.getPlayerHand().getValueOfHand() == 21 && dealer.getDealerHand().getValueOfHand() == 21) {
			System.out.println("You and the dealer tie");
			resetRound();
		}
		else if(player.getPlayerHand().getValueOfHand()<= 21 && dealer.getDealerHand().getValueOfHand() < player.getPlayerHand().getValueOfHand()) {
			System.out.println("WOOOOOOOO YOU BEAT THE DEALER!!!!!");
			resetRound();
		}
		else {
			System.out.println("Learn how to count and come back again next pay period.");
			resetRound();
		}
		
	}
}
