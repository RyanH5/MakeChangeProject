import java.util.Scanner;

public class MakeChangeApp {

	public boolean completed = false;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		MakeChangeApp register = new MakeChangeApp();
		while (!register.completed) {
			double price = askPrice(kb);
			System.out.println(price);
			System.out.println();
			
			double payment = register.amountTendered(kb);
			String verifiedPayment = register.verifyPayment(price, payment, register);
			System.out.println(verifiedPayment);
			System.out.println();
			register.doYouHaveItemsToBuy(kb, register);
		}
		kb.close();

	}

	public void doYouHaveItemsToBuy(Scanner kb, MakeChangeApp register) {
		System.out.println("Will that be all? (y/n)");
		String response = kb.next();
		if (response.equals("y")) {
			register.completed = true;
			System.out.println("Thank you. Come again");
		}
	}
	
	public static double askPrice(Scanner kb) {
		System.out.println("How much does this item cost? (x.xx)");
		double price = kb.nextDouble();
		return price;
	}

	public double amountTendered(Scanner kb) {
		System.out.print("Amount paid: ");
		double amountTendered = kb.nextDouble();
		return amountTendered;
	}

	public String verifyPayment(double price, double payment, MakeChangeApp register) {
		int scaledPrice = makeInt(price);
		int scaledPayment = makeInt(payment);
		int changeDifference;
		double insufficientPaymentBalance = price - payment;
		String response;

		if (scaledPrice > scaledPayment) {
			System.out.println();
			response = "Insufficient payment. Customer owes: $";
			changeDifference = register.remainderInCents(scaledPrice, scaledPayment);
			double result = (double) Math.round(insufficientPaymentBalance * 100d) / 100d;
			return response + result;

		} else if (scaledPrice < scaledPayment) {
			response = "Thank you. Pay customer: ";
			changeDifference = register.remainderInCents(scaledPrice, scaledPayment);
			return response + register.coinsBreakDown(changeDifference);

		} else {			
			return "Thank you. Come again.";

		}
	}

	public static int makeInt(double amount) {
		return (int) (amount * 100);
	}

	public int remainderInCents(int price, int payment) {
		int change = price - payment;
		if (price < payment) {
			change = payment - price;
		}

		return change;
	}

	public int[] updateBillsAndSum(int sum, int divisor) {
		int units = sum / divisor;
		sum = sum % divisor;
		int[] a = { units, sum };
		return a;
	}

	public String coinsBreakDown(int sum) {
		String coins = "";
		int[] currencies = new int[10];
		currencies[0] = 10000;
		currencies[1] = 5000;
		currencies[2] = 2000;
		currencies[3] = 1000;
		currencies[4] = 500;
		currencies[5] = 100;
		currencies[6] = 25;
		currencies[7] = 10;
		currencies[8] = 5;
		currencies[9] = 1;

		for (int i = 0; i < currencies.length; i++) {
			int billDivisor = currencies[i];
				while (sum > billDivisor) {
					int billsOrCoinsQuant;
					billsOrCoinsQuant = updateBillsAndSum(sum, billDivisor)[0];
					sum = updateBillsAndSum(sum, billDivisor)[1];
					coins += " " + billsOrCoinsQuant + printCurrency(billDivisor);
					if (billsOrCoinsQuant > 1 && billDivisor != 1) {
						coins += "s";
					}
					if (billsOrCoinsQuant > 1 && billDivisor == 1) {
						coins = coins.substring(0, coins.length() -1) + "ies";
					}
				}
		}
		return coins;
	}

	public String printCurrency(int currency) {
		switch (currency) {
		case 10000:
			return" one hundred dollar bill";
		case 5000:
			return " fifty dollar bill";
		case 2000:
			return " twenty dollar bill";
		case 1000:
			return " ten dollar bill";
		case 500:
			return " five dollar bill";
		case 100:
			return " one dollar bill";
		case 25:
			return " quarter";
		case 10:
			return " dime";
		case 5:
			return " nickel";
		case 1:
			return " penny";
		default:
			return "";
		}
	}
}
