/*David Olson*/	
package blackjack_game;
import java.util.ArrayList;
public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> discard;
	
	public Deck(){
		this.cards = new ArrayList<>();
		this.discard = new ArrayList<>();
		
		for(int i = 0; i < 52; i++){
			this.cards.add(new Card(i / 13,i % 13));
		}
	}

	public void printCards(){
		for(Card c : this.cards){
			System.out.println(c);
		}
	}
	
	public void shuffle(){
		//reorganizes the cards randomly in the card 
		//list and makes it so no cards are discarded anymore.
		System.out.printf("\n-----------shuffling deck------------\n");
		for (Card c : this.cards){
			int p = (int)(Math.random()*52);
			discard.add(Math.min(p, discard.size()),c);
		}
		//System.out.printf("\nfinished for loop\n\n");
		cards.clear();
		cards.addAll(discard);
		discard.clear();
	}
	
	public Card dealCard(){
		//moves the top card in your list to the discard 
		//list and returns the Card object to the calling function
		discard.add(0,cards.get(0));
		cards.remove(0);
		return discard.get(0);
		
	}
	
	public static void main(String[] args){
		//new Deck().printCards();
		Deck deck = new Deck();
		deck.printCards();
		deck.shuffle();
		deck.printCards();
	}
}
