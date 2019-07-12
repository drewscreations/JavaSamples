package blackjack_game;

public class junk {
	public static void main(String[] args){
		squareUp(3);
	}
	public static void squareUp(int n) {
		int count =1;
		for (int i=0, j=0; i<n*n; i++){
			j=i%n;
			System.out.println("n-j = "+(n-j)+", j = "+j+", count =  "+(count));
			if(n-j==1)count++;
			}
		
	}
}
