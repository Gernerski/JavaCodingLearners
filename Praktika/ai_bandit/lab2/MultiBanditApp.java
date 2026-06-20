/*
 * Objekt orientierte Programmierung - Marc Hensel
 * Praktikum 2: Spielhalle und Gewinn-Strategie
 * Leopold Schenk, Jan Gerner
 */

package ai_bandit.lab2;

import java.util.Scanner;

public class MultiBanditApp {
	
	public static final double pricePerRound = 1;
	public static final double avgWin = 0.5;
	public static final double stdDevWin = 1.0;
	public static final int numberOfBandits = 7;
	

	public static void main(String[] args) {
		MultiBandit multiBandit = new MultiBandit(numberOfBandits);
		
		Scanner inScanner = new Scanner(System.in);
		double win = 0;
		double net = 0;
		double eps = 0;
		int roundsToBePlayed = 0;
		
		System.out.println("--------Multi-armed-bandits ("+numberOfBandits+" of them)--------");
		System.out.println("Price per Game: " +multiBandit.getPricePerRound()+"€");
		System.out.println("How many Rounds would you like to play?	");
		roundsToBePlayed = inScanner.nextInt();
		
		System.out.println("Enter epsilon in [0,100] percent (typical value: 15) or any other number for random strategy: "); 
		eps = inScanner.nextInt() / 100.0;
		
		
		System.out.println("\n Round | Bandit |  Win [€] | Net [€]");
		System.out.println("-------|--------|----------|--------");
		
		MultiBanditSolver multiBanditSolver = new MultiBanditSolver(multiBandit);
		int currentBandit = 0;
		if (eps>=0 && eps<=1) {
			multiBanditSolver.setGreedyEpsilon(eps);
			for(int i = 0; i<roundsToBePlayed; i++) {
				currentBandit = multiBanditSolver.chooseGreedy();
				win = multiBandit.play(currentBandit);
				net += win - multiBandit.getPricePerRound();
				multiBanditSolver.addBanditResponse(currentBandit, win-multiBandit.getPricePerRound());
				System.out.printf("%5d  |%6d  |%8.2f  |%8.2f\n", i+1, currentBandit + 1, win, net);
			}
			System.out.println("");
			System.out.println("Applied strategy: epsilon-greedy (epsilon = "+ eps + ")");
			System.out.println("");

		} else {
			for(int i = 0; i<roundsToBePlayed; i++) {
				currentBandit = (int)(Math.random() * numberOfBandits)+1;
				win = multiBandit.play(currentBandit-1);
				net += win - multiBandit.getPricePerRound();
				
				System.out.printf("%5d  |%6d  |%8.2f  |%8.2f\n", i+1, currentBandit, win, net);
			}
			System.out.println("");
			System.out.println("Applied strategy: random");
			System.out.println("");
		}
		
		
		System.out.println("Multi-armed-bandit's statistics:");
		System.out.printf("Rounds played: %d rounds\n", multiBandit.getRoundsPlayed());
		System.out.printf("Profit: %.2f€ (%.2f€/round)\n",multiBandit.getOverallProfit(), multiBandit.getMeanProfitPerRound());
		
		inScanner.close();
		return;
	}
	
}