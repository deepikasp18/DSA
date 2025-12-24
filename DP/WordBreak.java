package DP;

/**
 * Given a string s and y a dictionary of n words dictionary, check if s can be segmented into a sequence of valid words from the dictionary, separated by spaces.

Examples:

Input:  s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true
Explanation: The string can be segmented as "i like".

Input:  s = "ilikegfg", dictionary[] = ["i", "like", "man", "india", "gfg"]
Output: true
Explanation: The string can be segmented as "i like gfg".

Input: "ilikemangoes", dictionary = ["i", "like", "gfg"]
Output: false
Explanation: The string cannot be segmented.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "ilikegfg";
        String[] dictionary = {"i", "like", "man", "india", "gfg"};
        System.out.println("Can the string be segmented? " + wordBreak(s, dictionary));
    }

    private static boolean wordBreak(String s, String[] dictionary) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; // Empty string can be segmented

        for (int i=1; i<=n; i++) {
            for (int j=0; j<i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && contains(dictionary, word)) {
                    dp[i] = true;
                    break;

                }
            }
        }
        return dp[n];
    }

    private static boolean contains(String[] dictionary, String word) {
        for (String dictWord : dictionary) {
            if (dictWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
