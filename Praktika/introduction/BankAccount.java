package introduction;

public class BankAccount {

	public static void main(String[] args) {
		
		double balance = 1000;
		double balanceGoal = balance * 2;
		double intrest = 0.35;
		intrest *= 0.01;
		int jahr;
		
		for (jahr = 0; balance < 2000; jahr++) {
			balance *= 1 + intrest;
		}
		
		System.out.println("Nach " + jahr + " Jahre(n) verdoppelt sich das Guthaben von " + balanceGoal/2 +" auf " + balance + " Euronen.");

	}

}
