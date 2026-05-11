package ai_bandit.lab1;

import java.util.Random;

public class Bandit {

		private Random random = new Random();
		private String name;
		private double pricePerRound;
		private double averageWin;
		private double stdDevWin;
		private double overallProfit;
		private int roundsPlayed;
		
		public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
			super();
			this.name = name;
			this.pricePerRound = pricePerRound;
			this.averageWin = averageWin;
			this.stdDevWin = stdDevWin;
		}

		public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
			super();
			this.pricePerRound = pricePerRound;
			this.averageWin = averageWin;
			this.stdDevWin = stdDevWin;
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

		public int getRoundsPlayed() {
			return roundsPlayed;
		}
		
		public double getMeanProfitPerRound() {
			
			if(roundsPlayed <= 0)
				return 0;
			else
				return overallProfit/roundsPlayed;
		}
		
		public double play() {
			double win = this.determineWin();
			this.overallProfit += this.pricePerRound - win;
			this.roundsPlayed++;
			return win;
		}
		
		private double determineWin() {

			double win = this.averageWin + this.random.nextGaussian() * this.stdDevWin;
			double rest = win % 0.1;
			win -= rest;
			
			if(win<0) {
				win = 0;
			}
			
			return win;
			
		}
		
	}