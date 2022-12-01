package leetcodequestions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {

		// Output: [1,2,3,6,9,8,7,4,5]
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));

		// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(spiralOrder(matrix));
		
		matrix = new int[][] { { 1, 2, 3, 4 } };
		System.out.println(spiralOrder(matrix));
		
		matrix = new int[][] { { 5 }, { 6 }, { 7 }, { 8 } };
		System.out.println(spiralOrder(matrix));
		
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		System.out.println(spiralOrder(matrix));

	}

	private static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < matrix.length / 2 + 1; i++) {
			
			boolean checkIfTraverseMissing = true;
			int j = i;
			while (j < matrix[i].length - i) {
				result.add(matrix[i][j]);
				j++;
				checkIfTraverseMissing = false;
			}
			if(checkIfTraverseMissing) return result;
			else checkIfTraverseMissing = true;
			j--;
			int k = i + 1;
			while (k < matrix.length - i) {
				result.add(matrix[k][j]);
				k++;
				checkIfTraverseMissing = false;
			}
			j--;
			if(checkIfTraverseMissing) return result;
			else checkIfTraverseMissing = true;
			while (j >= i) {
				result.add(matrix[matrix.length - i - 1][j]);
				j--;
				checkIfTraverseMissing = false;
			}
			j++;
			k -= 2;
			if(checkIfTraverseMissing) return result;
			else checkIfTraverseMissing = true;
			while (k > i) {
				result.add(matrix[k][j]);
				k--;
				checkIfTraverseMissing = false;
			}
			if(checkIfTraverseMissing) return result;
			else checkIfTraverseMissing = true;
		}

		return result;
	}

}
