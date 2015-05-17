/**
Homework "Deep copy"
Course by EPAM Systems
"The complete development cycle using Java platform"

Task:
Realize a deep copy of matrix of integers:
--> with nested loop
--> with System.arraycopy
Add comparison of total time

Written by Lydia Sokur, 2015
*/

package lesson150305;

import java.util.Arrays;
import java.util.Random;

public class DeepCopy {
	
	private static final int MAX = 1000;
	private static final int ITERATIONS = 100;
	
	static long mineCopyTime = 0;
	static long systemCopytime = 0;
	
	public static void main(String[] args) {
		long start, stop;
		
		int[][] array;
		int[][] systemArray = new int[MAX][MAX];
		int[][] mineArray = new int[MAX][MAX];
		
		for(int i = 0; i < ITERATIONS; i++) {
			array = generate();
			
			start = System.nanoTime();
			mineArray = deepCopy(array);
			stop = System.nanoTime();
			mineCopyTime += stop - start;

			start = System.nanoTime();
			for (int j = 0; j < array.length; j++) {
				System.arraycopy(array[j], 0, systemArray[j], 0, array[j].length);
			}
			stop = System.nanoTime();
			systemCopytime += stop - start;			
			
			for (int j = 0; j < systemArray.length; j++) {
				if (!Arrays.equals(systemArray[j], mineArray[j])) {
					System.out.println("Copying is not right!");
					break;
				}				
			}
		}
		System.out.println("System average time: " + systemCopytime/ITERATIONS);
		System.out.println("Mine average time: " + mineCopyTime/ITERATIONS);
		System.out.println("Ratio: " + (double)mineCopyTime/(double)systemCopytime);
	}

	private static int[][] deepCopy(int[][] array) {
		int[][] newArray = new int[MAX][MAX];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				newArray[i][j] = array[i][j];
			}
		}
		return newArray;
	}
	
	private static int[][] generate() {
		int[][] data = new int[MAX][MAX];
		
		Random random = new Random();
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = random.nextInt(MAX);	
			}
		}		
		return data;
	}
}
