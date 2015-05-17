/**
Homework "Guessing game"
Course by EPAM Systems
"The complete development cycle using Java platform"

Task:
--> computer guessing the number in a range (1 - 100)
--> number of guesses must be less than 7

Written by Lydia Sokur, 2015
 */

package Lesson150303;

public class Guessing {

	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		int max = 100;
		int min = 1;
		int number = 0, counter = 0;
		String playersAnswer = "n";
		
		System.out.println("Let's play a game.");
		System.out.println("Put forth a number between 1 and 100.");
		System.out.println("Type:");
		System.out.println("'y' if my guess is right,");
		System.out.println("'h' if your number is higner,");
		System.out.println("'l' if your number is less.");
		
		while (!playersAnswer.equals("y")) {
			counter++;
			number = min + (max - min)/2;
			System.out.println("It is " + number + "?");
			playersAnswer = scanner.next();
			if (playersAnswer.equals("l")) max = max - (max - min)/2;
			else if (playersAnswer.equals("h")) min = min + (max - min)/2;
			else if (playersAnswer.equals("y")) break;
		}
		System.out.println("Hooray! Only " + counter + " moves!");
		scanner.close();
	}
}
