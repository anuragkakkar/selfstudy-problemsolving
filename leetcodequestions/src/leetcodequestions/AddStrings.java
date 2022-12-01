package leetcodequestions;

public class AddStrings {

	public static void main(String[] args) {
		
		System.out.println(addStrings("11", "123"));
		System.out.println(addStrings("456", "77"));
		System.out.println(addStrings("0", "0"));
		System.out.println(addStrings("9", "1"));

	}

	private static String addStrings(String num1, String num2) {

		int i = num1.length() - 1, j = num2.length() - 1;
		String result = "";
		boolean carry = false;
		while (i >= 0 && j >= 0) {

			int a = Integer.parseInt("" + num1.charAt(i));
			int b = Integer.parseInt("" + num2.charAt(j));

			int c = 0;
			if (carry == true) {
				c = a + b + 1;
				carry = false;
			} else {
				c = a + b;
			}

			if (c > 9) {
				carry = true;
				c = c - 10;
			}

			result = c + result;

			i--;
			j--;
		}

		while (i >= 0) {
			int a = Integer.parseInt("" + num1.charAt(i));
			int c = 0;
			if (carry == true) {
				c = a + 1;
				carry = false;
			} else {
				c = a;
			}

			if (c > 9) {
				carry = true;
				c = c - 10;
			}

			result = c + result;
			i--;
		}

		while (j >= 0) {
			int a = Integer.parseInt("" + num2.charAt(j));
			int c = 0;
			if (carry == true) {
				c = a + 1;
				carry = false;
			} else {
				c = a;
			}

			if (c > 9) {
				carry = true;
				c = c - 10;
			}

			result = c + result;
			j--;
		}

		return carry == true ? "1" + result : result;
	}

}
