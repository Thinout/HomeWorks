package lesson150312;

import java.util.Arrays;
import java.util.Random;

public class ModifiedLSDSort {
	
	private static final int MAX = 1000000;
	private static final int ITERATIONS = 100;
	private static final int R = 256;
	private static final int bytes = 4;
	private static final int mask = 0b11111111;
	
	public static void main(String[] args) {
		
		long quickSortTime = 0, lsdSortTime = 0;
		
		long total = 0;
		long totalOriginal = 0;
		
		for(int i = 0; i < ITERATIONS; i++) {
			
			long start, stop;
			
			int[] dataQ = generate();
			// Здесь клонирование
			int[] dataLSD = new int[dataQ.length];
			System.arraycopy(dataQ, 0, dataLSD, 0, dataQ.length);
			
			start = System.nanoTime();
			Arrays.sort(dataQ);
			stop = System.nanoTime();
			quickSortTime += stop - start;

			start = System.nanoTime();
			LSDsort(dataLSD);
			stop = System.nanoTime();
			lsdSortTime += stop - start;
			
			// Проверка на правильность сортировки
			if (!Arrays.equals(dataQ, dataLSD)) {
				System.out.println("Arrays are not equal!");
				break;
			}
			
		}
		
		System.out.println("Quick Sort average time: " + quickSortTime/ITERATIONS);
		System.out.println("LSD Sort average time: " + lsdSortTime/ITERATIONS);
		System.out.println("Ratio: " + (double)quickSortTime/(double)lsdSortTime);
		
	}

	private static void LSDsort(int[] data) {
		
		int[] aux = new int[data.length];
		int[] count = new int[R+1];
		
		for (int b = 0; b < bytes << 3; b += 8) {
				
			for (int i = 0; i < data.length; i++)
				count[(data[i] >>> b & mask) + 1]++;
			for (int r = 0; r < R; r++)
				count[r+1] += count[r];
			for (int i = 0; i < data.length; i++)
				aux[count[data[i] >>> b & mask]++] = data[i];
			
			// Копирование указателей
			int temp[] = data;
			data = aux;
			aux = temp;
			
			Arrays.fill(count, 0);
		}
	}
	
	private static int[] generate() {
		int[] data = new int[MAX];
		
		Random random = new Random();
		
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(MAX); // 0 - 999999
		}
		
		return data;
	}
	
}
