package Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abcabc";
        int[] result = KMPSearch(text, pattern);
        System.out.println("Pattern found at indices: " + Arrays.toString(result));
    }

    public static int[] KMPSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        List<Integer> resultIndices = new ArrayList<>();

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    resultIndices.add(i-j);
                    j = lps[j-1];
                }
            } else {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return resultIndices.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0; // base case

        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len != 0) {
                len = lps[len-1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
