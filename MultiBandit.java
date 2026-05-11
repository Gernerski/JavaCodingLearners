package ai_bandit.lab1;

public class MultiBandit {

  private Bandit[] bandits;  

  public MultiBandit(int numberBandits) {
    this.bandits = new Bandit[numberBandits];
    for (int i = 0; i < numberBandits; i++) {
    	bandits[i] = new Bandit(1.0, 1.0, 0.2);
    }

  }

  public int getNumberBandits() {
    return bandits.length;
  }
  
  public double getPricePerRound() {
	  return bandits[0].getPricePerRound();
  }
  
  public double getOverallProfit() {
	double overallProfit = 0.0;
	  for (Bandit bandit : bandits)
          overallProfit += bandit.getOverallProfit();
	  return overallProfit;
  }
  
  public double getMeanProfitPerRound() {
	  int roundsPlayed = getRoundsPlayed();
	  	if (roundsPlayed == 0)
            return 0.0;
        return getOverallProfit() / roundsPlayed;

  }
  
  public int getRoundsPlayed() {
	  int RoundsPlayed = 0;
	  for (Bandit bandit : bandits) {
		  RoundsPlayed += bandit.getRoundsPlayed();
	  }
	  return RoundsPlayed;
  }
  
  public double play(int banditIndex) {
	  return bandits[banditIndex].play();
  }

}
