package leetcodequestions;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		
		System.out.println(countSubstrings("abc"));
		
		System.out.println(countSubstrings("aaa"));

	}

	private static int countSubstrings(String s) {

		int numPalin = 0;
		for (int i = 0; i < s.length(); i++) {

			// for odd palindrome
			int left = i;
			int right = i;
			while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
				numPalin++;
				left--;
				right++;
			}

			// for even palindrome
			left = i;
			right = i + 1;
			while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
				numPalin++;
				left--;
				right++;
			}
		}
		return numPalin;
	}

}
