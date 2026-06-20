/*
 * Objekt orientierte Programmierung - Marc Hensel
 * Praktikum 2: Spielhalle und Gewinn-Strategie
 * Leopold Schenk, Jan Gerner
 */

package ai_bandit.lab2;

public class MultiBandit {
	
  private Bandit[] bandits;

  public MultiBandit(int numberBandits) {
	int rigged = (int)((double)Math.random() * numberBandits);
    this.bandits = new Bandit[numberBandits];
    for (int i = 0; i < numberBandits; i++) {
    	double mu;
    	if(i == rigged) {
    		mu = Math.random() * 0.2 + 1.1;
    	}
    	else {
    		mu = Math.random() * 0.3 + 0.5;
    	}
    		bandits[i] = new Bandit("Bandit "+i, 1.0, mu, 1.0);
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