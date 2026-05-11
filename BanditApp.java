package ai_bandit.lab1;

import java.util.Scanner;

public class BanditApp {
	
	public static final double pricePerRound = 1;
	public static final double avgWin = 0.8;
	public static final double stdDevWin = 0.7;

	public static void main(String[] args) {
		Bandit bandit = new Bandit("One armed Bandit", pricePerRound, avgWin, stdDevWin);
		
		System.out.println("--------"+bandit.getName()+"--------");
		System.out.println("Price per Game: " +bandit.getPricePerRound()+"€");
		System.out.println("How many Rounds would you like to play?	");
		Scanner scanRounds = new Scanner(System.in);
		int roundsToBePlayed = scanRounds.nextInt();
		
		double win = 0;
		double net = 0;
		
		System.out.println("Round\t|\tWin [€]\tNet [€]");
		System.out.println("_____________________________");
		
		for(int i = 0; i<roundsToBePlayed; i++) {
			win = bandit.play();
			net = win - bandit.getPricePerRound();
			
			double rest = net % 0.1;
			net -= rest;
			
			System.out.printf("\t%d  |\t");
		}
		
		scanRounds.close();
		return;
	}

}