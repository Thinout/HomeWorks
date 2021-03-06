/**
Homework "Formatted output"
Course by EPAM Systems
"The complete development cycle using Java platform"

Task:
Train formatted output.

Written by Lydia Sokur, 2015
 */

package Lesson150303;

public class Printf {
	static int sum = 100;
	static int bytes = 123456789;
	static String string = "Sum";
	
	public static void main(String[] args) {
		System.out.printf("%s: %d\n", string, sum);
		int mask = 0b1111111;
		System.out.printf("%d --> %s %s %s %s\n",
				bytes, 
				Integer.toBinaryString(mask & bytes >>> 24),
				Integer.toBinaryString(mask & bytes >>> 16),
				Integer.toBinaryString(mask & bytes >>> 8),
				Integer.toBinaryString(mask & bytes));
	}
}
