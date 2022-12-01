package leetcodequestions;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		System.out.println(longestPalindrome("babad"));
		
		System.out.println(longestPalindrome("cbbd"));

	}

	private static String longestPalindrome(String s) {

		String result = "";
		int resultLen = 0;

		for (int i = 0; i < s.length(); i++) {

			// for odd palindrome
			int left = i;
			int right = i;
			while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > resultLen) {
					resultLen = right - left + 1;
					result = s.substring(left, right + 1);
				}
				left--;
				right++;
			}

			// for even palindrome
			left = i;
			right = i + 1;
			while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > resultLen) {
					resultLen = right - left + 1;
					result = s.substring(left, right + 1);
				}
				left--;
				right++;
			}

		}
		return result;
	}

}
