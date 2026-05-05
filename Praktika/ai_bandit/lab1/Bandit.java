package ai_bandit.lab1;

public class Bandit {
	private static Random random;
	private String name;
	private double pricePerRound;
	private double averageWin;
	private double stdDevWin;
	private double overallProfit;
	private int roundsPlayerd;
	
	public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
		this.name = name;
		this(pricePerRound, averageWin, stdDevWin);
	}
	public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
		this.pricePerRound = pricePerRound;
		this.averageWin = averageWin;
		this.stdDevWin = stdDevWin;
	}
}
