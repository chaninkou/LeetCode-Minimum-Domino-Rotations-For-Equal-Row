package leetcode1007;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] A = {2,3,2,5,2,2};
		
		int[] B = {6,2,5,2,4,2};
		
		System.out.println("A: " + Arrays.toString(A));
		
		System.out.println("B: " + Arrays.toString(B));
		
		FindMinSwapToEqualRowFunction solution = new FindMinSwapToEqualRowFunction();
		
		System.out.println("Solution: " + solution.minDominoRotations(A, B));
	}
}
