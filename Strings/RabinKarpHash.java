package Strings;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpHash {
    int mod = 1000000007; // large prime
    int base = 31;
    int[] hash;
    int[] power;

    public RabinKarpHash(String s) {
        int n = s.length();
        hash = new int[n];
        power = new int[n];

        hash[0] = charToInt(s.charAt(0));
        power[0] = 1;

        for (int i=1; i<n; i++) {
            hash[i] = add(mul(hash[i-1], base), charToInt(s.charAt(i))); // hash[i-1] * base + s.charAt(i)
            power[i] = mul(power[i-1], base);
        }
    }

    public int getHash(int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        return sub(hash[r], mul(hash[l-1], power[r-l+1]));
    }

    private int charToInt(char c) {
        return c - 'a' + 1; // assuming lowercase letters
    }

    private int add(int a, int b) {
        a += b;
        if (a > mod) a -= mod;
        return a;
    }

    private int sub(int a, int b) {
        a -= b;
        if (a < 0) a += mod;
        return a;
    }

    private int mul(int a, int b) {
        return (int)((long)a * b % mod);
    }

    public static class main {
        public static void main(String[] args) {
            String s = "ababcdacdeab";
            int[] result = searchPattern(s, "ab");
            System.out.println("Pattern found at indices: " + java.util.Arrays.toString(result));
        }

        public static int[] searchPattern(String text, String pattern) {
            List<Integer> resultIndices = new ArrayList<>();
            RabinKarpHash rabinKarpHashForText = new RabinKarpHash(text);
            RabinKarpHash rabinKarpHashForPattern = new RabinKarpHash(pattern);

            int pHash = rabinKarpHashForPattern.getHash(0, pattern.length() - 1);

            for (int i = 0; i <= text.length() - pattern.length(); i++) {
                int tHash = rabinKarpHashForText.getHash(i, i + pattern.length() - 1);
                if (tHash == pHash && matches(text.substring(i, i+pattern.length()-1), pattern)) {
                    resultIndices.add(i);
                }
            }
            return resultIndices.stream().mapToInt(Integer::intValue).toArray();
        }

        private static boolean matches(String textSegment, String pattern) {
            int i = 0, j=0;
            while (i < textSegment.length() && j < pattern.length()) {
                if (textSegment.charAt(i) != pattern.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
            return true;
        }
    }

}

