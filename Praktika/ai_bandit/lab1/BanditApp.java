package ai_bandit.lab1;

import java.util.Scanner;

public class BanditApp {
	
	public static final double pricePerRound = 1;
	public static final double avgWin = 0.5;
	public static final double stdDevWin = 1.0;

	public static void main(String[] args) {
		Bandit bandit = new Bandit("One armed Bandit", pricePerRound, avgWin, stdDevWin);
		
		System.out.println("--------"+bandit.getName()+"--------");
		System.out.println("Price per Game: " +bandit.getPricePerRound()+"€");
		System.out.println("How many Rounds would you like to play?	");
		Scanner scanRounds = new Scanner(System.in);
		int roundsToBePlayed = scanRounds.nextInt();
		
		double win = 0;
		double net = 0;
		
		System.out.println("\n Round |  Win [€] | Net [€]");
		System.out.println("-------|----------|--------");
		
		for(int i = 0; i<roundsToBePlayed; i++) {
			win = bandit.play();
			net += win - bandit.getPricePerRound();
			
			System.out.printf("%5d  |%8.2f  |%8.2f\n", i+1, win, net);
		}
		
		System.out.println(bandit.getName()+"'s statistics :");
		System.out.printf("Rounds played: %d rounds\n", bandit.getRoundsPlayed());
		System.out.printf("Profit: %.2f€ (%.2f€/round)",bandit.getOverallProfit(), bandit.getMeanProfitPerRound());
		
		scanRounds.close();
		return;
	}

}