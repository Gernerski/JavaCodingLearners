/*
 * Objekt orientierte Programmierung - Marc Hensel
 * Praktikum 2: Spielhalle und Gewinn-Strategie
 * Leopold Schenk, Jan Gerner
 */

package ai_bandit.lab2;

import java.util.Random;

abstract class Gambling {
	
	protected Random random = new Random();
	private String name;
	private double pricePerRound;
	private double overallProfit;
	private int roundsPlayed;
	
	public Gambling(String name, double pricePerRound) {
		super();
		this.name = name;
		this.pricePerRound = pricePerRound;
	}

	public String getName() {
		return name;
	}

	public double getPricePerRound() {
		return pricePerRound;
	}

	public double getOverallProfit() {
		return overallProfit;
	}

	
	public double getMeanProfitPerRound() {
		
		if(roundsPlayed <= 0)
			return 0;
		else
			return overallProfit/roundsPlayed;
	}
	
	public int getRoundsPlayed() {
		return roundsPlayed;
	}
	
	public double play() {
		double win = determineWin();
		this.overallProfit += this.pricePerRound - win;
		this.roundsPlayed++;
		return win;
	}
	
	abstract protected double determineWin();
	
}