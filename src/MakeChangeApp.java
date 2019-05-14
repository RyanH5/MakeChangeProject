import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double price = askPrice(kb);
		System.out.println(price);
		System.out.println();

		MakeChangeApp register = new MakeChangeApp();

		double payment = register.amountTendered(kb);
		System.out.println(payment);
		register.verifyPayment(price, payment, register);

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

	public void verifyPayment(double price, double payment, MakeChangeApp register) {
		int scaledPrice = makeInt(price);
		int scaledPayment = makeInt(payment);
		int changeDifference;
		double insufficientPaymentBalance = price - payment;

		if (scaledPrice > scaledPayment) {
			System.out.println();
			System.out.print("Insufficient payment. Customer owes: $");
			changeDifference = register.remainderInCents(scaledPrice, scaledPayment);
			double result = (double) Math.round(insufficientPaymentBalance * 100d) / 100d;
			System.out.println(result);

		} else if (scaledPrice < scaledPayment) {
			System.out.println("Thank you. Pay customer: ");
			changeDifference = register.remainderInCents(scaledPrice, scaledPayment);
			register.coinsBreakDown(changeDifference);

		} else {
			System.out.println();
			System.out.println("Thank you. Come again.");

		}
	}

	public static int makeInt(double amount) {
		return (int) (amount * 100);
	}

//	why can remainderInCents be called NOT on instance. ????????
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

	public void coinsBreakDown(int sum) {
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
//			if (sum > billDivisor) {
				while (sum > billDivisor) {
					int billsOrCoins;
					billsOrCoins = updateBillsAndSum(sum, billDivisor)[0];
					sum = updateBillsAndSum(sum, billDivisor)[1];
					coins += " " + billsOrCoins + printCurrency(billDivisor);
					if (billsOrCoins > 1 && billDivisor != 1) {
						coins += "s";
					}
					if (billsOrCoins > 1 && billDivisor == 1) {
						coins += "ies";
					}
				}
//			}
		}
		System.out.println(coins);
	}

	public String printCurrency(int currency) {
		String currStr = "";

		switch (currency) {
		case 10000:
			currStr = " one hundred dollar bill";
			break;
		case 5000:
			currStr = " fifty dollar bill";
			break;
		case 2000:
			currStr = " twenty dollar bill";
			break;
		case 1000:
			currStr = " ten dollar bill";
			break;
		case 500:
			currStr = " five dollar bill";
			break;
		case 100:
			currStr = " one dollar bill";
			break;
		case 25:
			currStr = " quarter";
			break;
		case 10:
			currStr = " dime";
			break;
		case 5:
			currStr = " nickel";
			break;
		case 1:
			currStr = " penny";
			break;
		default:
			currStr = "";
		}
		return currStr;
	}
}
