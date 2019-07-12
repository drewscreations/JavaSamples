/*David Olson*/
package blackjack_game;


public class Card {

	private int suit;
	private int rank;
	private String srank;
	private String ssuit;
	Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	public int getSuit(){
		return this.suit;
	}
	public int getRank(){
		return this.rank;
		
	}
	public int getValue(){
		return rank<10?(rank+1):10;
	}
	public String toString(){
		if(rank == 0){
			srank="ace";
		} else if (rank==1){
			srank="two";
		} else if (rank==2){
			srank="three";
		} else if (rank==3){
			srank="four";
		} else if (rank==4){
			srank="five";
		} else if (rank==5){
			srank="six";
		} else if (rank==6){
			srank="seven";
		} else if (rank==7){
			srank="eight";
		} else if (rank==8){
			srank="nine";
		} else if (rank==9){
			srank="ten";
		} else if (rank==10){
			srank="jack";
		} else if (rank==11){
			srank="queen";
		} else if (rank==12){
			srank="king";
		}
		if (suit==0){
			ssuit = "hearts";
		} else if (suit==1){
			ssuit = "diamonds";
		} else if (suit==2){
			ssuit = "spades";
		}else if (suit==3){
			ssuit = "clubs";
		}
		return srank+" of "+ssuit;
	}
}
