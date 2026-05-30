package ai_bandit.lab2;

//import java.util.Random;

public class WheelOfFortune extends Gambling {
	//private Random random = new Random();
	private int numberFields;
	private double categoryWins[];
	private double categoryChances[];
	
	public WheelOfFortune(double pricePerRound, int categoryNumberFields[], double categoryWins[]) {
		super("Wheel of fortune", pricePerRound);
		
		int numberCategories = categoryNumberFields.length;
		categoryChances = new double[numberCategories];
		
		this.numberFields = 0; //absolute number (all categories combined)
		for (int number : categoryNumberFields) {
			this.numberFields += number;
		}
		this.categoryWins = categoryWins;
		
		for(int i = 0; i < numberCategories; i++) {
			this.categoryChances[i] = (double)categoryNumberFields[i] / (double)this.numberFields;
		}
		
	}

	public int getNumberFields() {
		return numberFields;
	}
	
	protected double determineWin() {
		double randNum = random.nextDouble();
		double selection = 0;
		int i = 0;
		while(selection < randNum) {
			selection += categoryChances[i];
			i++;
		}
		return categoryWins[i - 1];
	}
}