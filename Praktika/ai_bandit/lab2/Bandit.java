/*
 * Objekt orientierte Programmierung - Marc Hensel
 * Praktikum 2: Spielhalle und Gewinn-Strategie
 * Leopold Schenk, Jan Gerner
 */

package ai_bandit.lab2;

public class Bandit extends Gambling {
	
	private double averageWin;
	private double stdDevWin;
	
	public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
		super(name, pricePerRound);
		this.averageWin = averageWin;
		this.stdDevWin = stdDevWin;
	}

	public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
		super("", pricePerRound);
		this.averageWin = averageWin;
		this.stdDevWin = stdDevWin;
	}
	
	protected double determineWin() {

		double win = this.averageWin + this.random.nextGaussian() * this.stdDevWin;
		double rest = win % 0.1;
		win -= rest;
		
		return win;
		
	}
	
}