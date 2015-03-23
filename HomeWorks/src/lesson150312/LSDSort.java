package lesson150312;

import java.util.Arrays;
import java.util.Random;

public class LSDSort {
	private static final int MAX = 1000000;

	public static void main(String[] args) {
		
		int[] data = generate();
		
		long start = System.currentTimeMillis();
		Arrays.sort(data);
		long stop = System.currentTimeMillis();
		System.out.printf("Quick Sort: %d ms\n", (stop - start));
		
		data = generate();
		start = System.currentTimeMillis();
		LSDsort(data);
		stop = System.currentTimeMillis();
		System.out.printf("LSD Sort: %d ms\n", (stop - start));
				
	}

	private static void LSDsort(int[] data) {
		int R = 256;
		int bytes = 4;
		int mask = 0b11111111;
		int N = data.length;
		int [] aux = new int[N];
		
		for (int b = 0; b < bytes; b++) {
			int [] count = new int[R+1];
			for (int i = 0; i < N; i++)
				count[(mask & data[i] >>> 8*b) + 1]++;
			for (int r = 0; r < R; r++)
				count[r+1] += count[r];
			for (int i = 0; i < N; i++)
				aux[count[mask & data[i] >>> 8*b]++] = data[i];
			for (int i = 0; i < N; i++) {
				data[i] = aux[i];
			}
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
