/*
 * Objekt orientierte Programmierung - Marc Hensel
 * Praktikum 2: Spielhalle und Gewinn-Strategie
 * Leopold Schenk, Jan Gerner
 */

package ai_bandit.lab2;

import java.util.Scanner;

public class WheelApp {
  public static final double pricePerRound = 1;
  public static final int[] winFieldAmounts = {
    15,
    10,
    4,
    1
  };
  public static final double[] winFieldChances = {
    00,
    01,
    2,
    5
  };

  public static void main(String[] args) {

    WheelOfFortune wheel = new WheelOfFortune(pricePerRound, winFieldAmounts, winFieldChances);
    Scanner scanRounds = new Scanner(System.in);

    System.out.println("Gambling: " + wheel.getName());
    System.out.println("Price per Game: " + wheel.getPricePerRound() + "€");
    System.out.println("Fields: " + wheel.getNumberFields());
    System.out.println("");
    System.out.println("How many Rounds would you like to play?	");

    int roundsToBePlayed = scanRounds.nextInt();

    double win = 0;
    double net = 0;

    System.out.println("\n Round |  Win [€] | Net [€]");
    System.out.println("-------|----------|--------");

    for (int i = 0; i < roundsToBePlayed; i++) {
      win = wheel.play();
      net += win - wheel.getPricePerRound();

      System.out.printf("%5d  |%8.2f  |%8.2f\n", i + 1, win, net);
    }

    System.out.println(wheel.getName() + "'s statistics :");
    System.out.printf("Rounds played: %d rounds\n", wheel.getRoundsPlayed());
    System.out.printf("Profit: %.2f€ (%.2f€/round)", wheel.getOverallProfit(), wheel.getMeanProfitPerRound());

    scanRounds.close();
    return;
  }
}