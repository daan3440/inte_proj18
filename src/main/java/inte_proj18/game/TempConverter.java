package inte_proj18.game;

import java.util.Scanner;

public class TempConverter {

	public static double celsiusToFarenheit(double c) {
		return c * 9 / 5 + 32;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Ange temperaturen i grader celsius: ");
		double c = scan.nextDouble();
		double f = celsiusToFarenheit(c);
		System.out.println(String.format("%.1f grader celsius är %.1f grader farenheit", c, f));

		scan.close();
	}

}