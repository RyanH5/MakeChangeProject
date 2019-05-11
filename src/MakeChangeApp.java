import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double price = askPrice(kb);
		System.out.println(price);
		System.out.println();
		double amounPaid = amountTendered(kb);
		System.out.println(amounPaid);

	}
	
	public static double askPrice(Scanner kb) {
		System.out.println("How much does this item cost? ");
		double price = kb.nextDouble();
		return price;
	}
	
	public static double amountTendered(Scanner kb) {
		System.out.print("Amount paid: ");
		double amountTendered = kb.nextDouble();
		return amountTendered;
	}

}
