import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max_val = -1;
		int dem = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				dem += 1;
			}
			else {
				max_val = Math.max(max_val, dem);
				dem = 1;
			}
		}
		return max_val;
	}


	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length() - 1; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(i + 1);
			if (Character.isDigit(c1)) {
				int n = c1 - '0';
				if (n != 0) {
					for (int j = 1; j <= n; j++) {
						sb.append(Character.toString(c2));
					}
				}
			}
			else {
				sb.append(Character.toString(c1));
			}
		}
		if (!Character.isDigit(str.charAt(str.length() - 1))) {
			sb.append(Character.toString(str.charAt(str.length() - 1)));
		}
		return sb.toString();
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        int l = a.length(), r = b.length();
        int[][] dp = new int[l + 1][r + 1];
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j <= r; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        if (dp[l][r] >= len) return true;
        else return false;
	}
}
