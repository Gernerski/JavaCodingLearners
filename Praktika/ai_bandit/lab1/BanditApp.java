package ai_bandit.lab1;

public class BanditApp {
	
	public static final double pricePerRound = 1;
	public static final double avgWin = 0.8;
	public static final double stdDevWin = 0.7;

	public static void main(String[] args) {
		Bandit bandit = new Bandit(pricePerRound, avgWin, stdDevWin);
		
		System.out.println("--------Bandit 1--------");
		System.out.println("Price per Game: " +bandit.getPricePerRound()+"€");
		System.out.print("How many Rounds would you like to play?");
		System.in.read();
		
	}

}
