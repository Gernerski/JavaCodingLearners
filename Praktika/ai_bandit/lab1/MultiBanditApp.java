package ai_bandit.lab1;

import java.util.Scanner;

public class MultiBanditApp {
	
	public static final double pricePerRound = 1;
	public static final double avgWin = 0.5;
	public static final double stdDevWin = 1.0;
	public static final int numberOfBandits = 7;
	

	public static void main(String[] args) {
		MultiBandit multiBandit = new MultiBandit(numberOfBandits);
		
		System.out.println("--------Multi-armed-bandits ("+numberOfBandits+" of them)--------");
		System.out.println("Price per Game: " +multiBandit.getPricePerRound()+"€");
		System.out.println("How many Rounds would you like to play?	");
		Scanner scanRounds = new Scanner(System.in);
		int roundsToBePlayed = scanRounds.nextInt();
		
		double win = 0;
		double net = 0;
		
		System.out.println("\n Round | Bandit |  Win [€] | Net [€]");
		System.out.println("-------|--------|----------|--------");
		
		int currentBandit = 0;
		
		for(int i = 0; i<roundsToBePlayed; i++) {
			currentBandit = (int)(Math.random() * numberOfBandits)+1;
			win = multiBandit.play(currentBandit-1);
			net += win - multiBandit.getPricePerRound();
			
			System.out.printf("%5d  |%6d  |%8.2f  |%8.2f\n", i+1, currentBandit, win, net);
		}
		
		System.out.println("Multi-armed-bandit's statistics:");
		System.out.printf("Rounds played: %d rounds\n", multiBandit.getRoundsPlayed());
		System.out.printf("Profit: %.2f€ (%.2f€/round)\n",multiBandit.getOverallProfit(), multiBandit.getMeanProfitPerRound());
		
		scanRounds.close();
		return;
	}
	
}