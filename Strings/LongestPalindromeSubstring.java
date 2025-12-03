package Strings;

/*
 * Given a string s, find the longest substring which is a palindrome. If there are multiple answers, then find the first appearing substring.
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindromeUsingDP(s));
    }

    /*
     * The main idea behind the approach is that if we know the status (i.e., palindrome or not) of the substring ranging [i, j], we can find the status of the substring ranging [i-1, j+1] by only matching the character str[i-1] and str[j+1].
     */
    public static String longestPalindromeUsingDP(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        // All substrings of length 1 are palindromes
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = true;
        }

        // All substrings of length 2
        int maxLength = 1;
        int start = 0;

        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Substrings of length greater than 2
        for (int length=3; length <= s.length(); length++) {
            for (int i=0; i< s.length()-length; i++) {
                int j = i + length - 1; // Ending index of substring from starting index i and length

                // Check for palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;

                    if (length > maxLength) {
                        start = i;
                        maxLength = length;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

}
