/*
 * Objekt orientierte Programmierung - Marc Hensel
 * Praktikum 2: Spielhalle und Gewinn-Strategie
 * Leopold Schenk, Jan Gerner
 */

package ai_bandit.lab3;

import java.util.Random;

public class MultiBanditSolver {
	
	private Random random;
	private MultiBandit bandits;
	private int[] counts;
	private double[] wins;
	private double epsilon;
	
	public MultiBanditSolver(MultiBandit bandits) {
		this.bandits = bandits;
		this.random = new Random();
		
		int K = bandits.getNumberBandits();
		this.counts = new int[K]; //initialisiert automatisch mit 0
		this.wins = new double[K];
		
	}
	
	public void setGreedyEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
	
	public void addBanditResponse(int banditIndex, double win) {
		wins[banditIndex] += win;
		counts[banditIndex]++;
	}
	
	public double getAverageWin(int banditIndex) {
		if (counts[banditIndex] != 0)
		return wins[banditIndex]/counts[banditIndex];
		return 0;
	}
	
	public int chooseRandom() {
		return random.nextInt(counts.length);
	}
	
	public int chooseGreedy() {
		
		for (int i = 0; i < counts.length; i++) {
			
				if (counts[i] == 0) { //nicht teil der aufgabe, dachte aber es solle zuerst jeder getestet werden
					return i;
				}
		}
		
		this.epsilon *= 0.99; // nicht teil der aufgabe, epsilon reduktion
		if (random.nextDouble() <= epsilon) {
			return chooseRandom();

		} else {
			double maxVal = getAverageWin(0);
			int maxValPosition = 0;
			
			for (int i = 1; i < wins.length; i++) {
				if(maxVal < getAverageWin(i)) {
					maxVal = getAverageWin(i);
					maxValPosition = i;
				}
			}
			return maxValPosition;
		}
	}
}