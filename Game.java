/*David Olson
 * Cs 141
 * Blackjack game
 */
//may need to change package names
package blackjack_game;

import java.util.Scanner;

public class Game {
	//make new players with starting points
	static Player player = new Player(100);
	static Player dealer = new Player(100);
	//new deck
	static Deck deck = new Deck();
	//starting values
	public static int wager;
	public static int numRounds = 0;
	public static int numWins = 0;
	public static int bust = 0;
	public static boolean roundComplete = false;
	//how I do while loops
	public static boolean playing = true;
	static Scanner myScanner = new Scanner(System.in);
	public static void main(String[] args){
		printIntro();
		while (playing){
			//if new hand...
			if(player.getHandValue()==0){
				startBet();
				deck.shuffle();
				roundComplete=false;
			}
			while (!roundComplete){
				//until you bust or descide to stop hitting
				dealCards();
			}
			numRounds +=1;
			if(player.points>0){
				//only asks to play again if you have points to spend
				playAgain();
			}else {
				System.out.println("you're all out of points");
				playing = false;
			}
			
		}
		myScanner.close();
		printStats();
	}
	public static void printIntro(){
		System.out.println("Welcome to the blackjack game");
	}
	public static void startBet(){
		System.out.println("you have "+player.points+" points");
		System.out.println("place ya bet: ");
		wager = myScanner.nextInt();
		while(wager>player.points){
			//checks that you dont bet more than you have
			System.out.println("cannot bet more than "+player.points);
			wager = myScanner.nextInt();
		}
	}
	public static void dealCards(){
		//add cards
		player.addCard(deck.dealCard());
		/*
		System.out.print("your new card is: ");
		player.printCards();
		*/
		System.out.println("your hand is now: ");
		player.printHand();
		if(dealer.getHandValue()<17){
			dealer.addCard(deck.dealCard());
			//prints for debugging
			/*
			System.out.print("dealer's new card is: ");
			dealer.printCards();
			*/
			System.out.println("dealer's hand is now: ");
			dealer.printHand();
		}
		if (player.checkAce()){
			player.getHandValue();
			if(player.addAcePoints){
				System.out.print("an ace! your hand is either: "+player.getHandValue());
				System.out.println(" or: "+(player.getHandValue()-10));
				}else{
					System.out.println("your hand value with no ace points: "+player.getHandValue());
				}
		}else{
		System.out.println("your hand value: "+player.getHandValue());
		}
		if(player.getHandValue()>21){
			//catch for busting
			bust++;
			System.out.println("you a bustah");
			loseHand();
		}
		if (dealer.checkAce()){
			dealer.getHandValue();
			if(dealer.addAcePoints){
				System.out.print("an ace! dealer's hand is either: "+dealer.getHandValue());
				System.out.println(" or: "+(dealer.getHandValue()-10));
			}else{
				System.out.println("dealer's hand value with no ace points: "+dealer.getHandValue());
			}
		}
		else{
		System.out.println("dealer's hand value: "+dealer.getHandValue());
		}
		if(dealer.getHandValue()>21){
			//check for busting
			System.out.println("dealer a bustah");
			winHand();
		}
		if(player.handValue<21){
			System.out.println("hit me one more time?");
			if (!myScanner.next().equals("y")){
				while(dealer.getHandValue()<16){
					//dealer hits with you if less than 16
					dealer.addCard(deck.dealCard());
					System.out.println("new dealer card!");
					dealer.printCards();
				}
				checkDealer();
				//compares hand to dealers hand
			}
		}
		
	}
	public static void checkDealer(){
		System.out.println("you got: "+player.getHandValue()+", dealer got: "+dealer.getHandValue());
		//ties go to the player cause I'm nice
		if(player.getHandValue()>=dealer.getHandValue()&&player.handValue<22||dealer.getHandValue()>21){
			winHand();
		} else {
			loseHand();
		}
	}
	public static void winHand(){
		player.getPoints(wager);
		numWins ++;
		System.out.println("you won "+wager+" points this round");
		roundComplete=true;
	}
	public static void loseHand(){
		player.getPoints(-wager);
		System.out.println("you lost this round");
		roundComplete=true;
	}
	public static void playAgain(){
		System.out.println("Play again?");
		if (!myScanner.next().equals("y")){
			//stops playing
			playing = false;
		} else {
			//clears both hands
			player.clearHand();
			dealer.clearHand();
		}
	}
	public static void printStats(){
		System.out.println("stats:");
		System.out.println("total points: "+player.points);
		//put in the starting point value
		System.out.println("average points per round: "+(player.points-player.startingPoints)/numRounds);
		System.out.println("highest points "+player.highestPoints);
		System.out.println("wins:losses "+numWins+":"+(numRounds-numWins));
	}
}
