import java.text.DecimalFormat;
import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double price = askPrice(kb);
		System.out.println(price);
		System.out.println();
		double payment = amountTendered(kb);
		System.out.println(payment);
		verifyPayment(price, payment);

	}

	public static double askPrice(Scanner kb) {
		System.out.println("How much does this item cost? (x.xx)");
		double price = kb.nextDouble();
		return price;
	}

	public static double amountTendered(Scanner kb) {
		System.out.print("Amount paid: ");
		double amountTendered = kb.nextDouble();
		return amountTendered;
	}

	public static void verifyPayment(double price, double payment) {
		int scaledPrice = makeInt(price);
		int scaledPayment = makeInt(payment);
		int changeDifference;
		double insufficientPaymentBalance = price - payment;
		
		if (scaledPrice > scaledPayment) {
			System.out.println();
			System.out.print("Insufficient payment. Customer owes: $");
			changeDifference = remainderInCents(scaledPrice, scaledPayment);
			double result = (double)Math.round(insufficientPaymentBalance * 100d) / 100d;
			System.out.println(result);
			
		}	else if (scaledPrice < scaledPayment) {
			System.out.println("Thank you. Pay customer: ");
			changeDifference = remainderInCents(scaledPrice, scaledPayment);
			coinsBreakDown(changeDifference);
			
		}	else {
			System.out.println();
			System.out.println("Thank you. Come again.");	
			
		}
	}
	
	public static int makeInt(double amount) {
		return (int)(amount * 100);
	}
	
	public static int remainderInCents(int price, int payment) {
		int change = price - payment;
		if (price < payment) {
			change = payment - price;
		}

		return change;
	}
	
	public static void coinsBreakDown(int sum) {
		String coins = "";
		
		while (sum > 0) {
			int billsOrCoins;
			if (sum >= 10000) {
				billsOrCoins = sum / 10000;
				sum = sum % 10000;
				coins += " " +billsOrCoins + " one-hundred dollar bill"; 
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 5000) {
				billsOrCoins = sum / 5000;
				sum = sum % 5000;
				coins += " " + billsOrCoins + " fifty dollar bill";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 2000) {
				billsOrCoins = sum / 2000;
				sum = sum % 2000;
				coins += " " + billsOrCoins + " twenty dollar bill";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 1000) {
				billsOrCoins = sum / 1000;
				sum = sum % 1000;
				coins += " " + billsOrCoins + " ten dollar bill";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 500) {
				billsOrCoins = sum / 500;
				sum = sum % 500;
				coins += " " + billsOrCoins + " five dollar bill";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 100) {
				billsOrCoins = sum / 100;
				sum = sum % 100;
				coins += " " + billsOrCoins + " one dollar bill";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 25) {
				billsOrCoins = sum / 25;
				sum = sum % 25;
				coins += " " + billsOrCoins + " quarter";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 10) {
				billsOrCoins = sum / 10;
				sum = sum % 10;
				coins += " " + billsOrCoins + " dime";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 5) {
				billsOrCoins = sum / 5;
				sum = sum % 5;
				coins += " " + billsOrCoins + " nickel";
				if (billsOrCoins > 1) {
					coins += "s";
				}
				
			}	else if (sum >= 1) {
				billsOrCoins = sum / 1;
				sum = sum % 1;
				coins += " " + billsOrCoins;	
				String penny = (billsOrCoins > 1) ?  " pennies" : " penny";
				coins += penny;
				
			}
		}
		System.out.println();
		System.out.println(coins);
	}

}
