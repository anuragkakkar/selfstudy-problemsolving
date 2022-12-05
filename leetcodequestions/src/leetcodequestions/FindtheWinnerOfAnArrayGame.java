package leetcodequestions;

public class FindtheWinnerOfAnArrayGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getWinner(int[] arr, int k) {

		int winner = 0;
		int winCount = 0;

		while (winCount <= k) {

			int temp = 0;
			if (arr[0] > arr[1]) {
				if (arr[0] != winner) {
					winCount = 0;
				}
				winner = arr[0];
				winCount++;
			} else {
				if (arr[1] != winner) {
					winCount = 0;
				}
				winner = arr[1];
				winCount++;
				temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}

			for (int i = 1; i < arr.length - 1; i++) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		return winCount;
	}

}
