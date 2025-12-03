package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "floight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
           int len = longestCommonPrefixLength(prefix, strs[i]);
           prefix = prefix.substring(0, len);
        }
        return prefix;
    }

    public static int longestCommonPrefixLength(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }
}
