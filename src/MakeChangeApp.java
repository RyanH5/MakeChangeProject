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
		System.out.println(scaledPrice);
		System.out.println(scaledPayment);
		if (scaledPrice > scaledPayment) {
			System.out.print("Insufficient payment. Customer owes: Cents:");
			remainderInCents(scaledPrice, scaledPayment);
		}	else if (scaledPrice < scaledPayment) {
			System.out.print("Thank you. Pay customer: Cents: ");
			remainderInCents(scaledPrice, scaledPayment);
			
		}	else {
			System.out.println("Thank you. Come again.");				
		}
	}
	
	public static int makeInt(double amount) {
		return (int)(amount * 100);
	}
	
	public static double remainderInCents(int price, int payment) {
		double newPrice = price;
		double newPayment = payment;
		double change = newPrice % newPayment;
		if (price < payment) {
			change = newPayment - newPrice;
		}
		System.out.print(change);
		return change;
	}

}
