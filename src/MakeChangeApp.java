import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		double price = askPrice();
		System.out.println(price);

	}
	
	public static double askPrice() {
		Scanner kb = new Scanner(System.in);
		System.out.println("How much does this item cost? ");
		double price = kb.nextDouble();
		return price;
	}

}
