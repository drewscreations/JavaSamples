/*David Olson*/
package blackjack_game;

import java.util.ArrayList;

public class Player {
	int points;
	int startingPoints;
	int highestPoints;
	int handValue;
	boolean addAcePoints;
	private ArrayList<Card> hand;
	Card card = new Card(0,0);
	public int getPoints(int points){
		this.points += points;
		highestPoints = Math.max(highestPoints, this.points);
		return this.points;
	}
	public Player(int startingPoints){
		this.points = startingPoints;
		this.startingPoints = startingPoints;
		this.hand = new ArrayList<>();
		this.addAcePoints = false;
	}
	public void addCard(Card card){
		this.card = card;
		hand.add(card);
	}
	public void printCards(){
		System.out.println(card.toString());
	}
	public void printHand(){
		for (Card c:hand){
			System.out.println(c);
		}
	}
	public int getHandValue(){
		handValue = 0;
		addAcePoints = false;
		for (Card c : hand){
		handValue += c.getValue();
		}
		if(checkAce()&&handValue<12){
			handValue+=10;
			addAcePoints = true;
		}
		return handValue;
	}
	public boolean checkAce(){
		for (Card c: this.hand){
			if (c.getRank()==0){
				return true;
			}
		}
		return false;
	}
	public void clearHand(){
		hand.clear();
	}
}
