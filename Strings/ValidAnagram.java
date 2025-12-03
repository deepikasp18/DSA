package Strings;

/*
 * Given two non-empty strings s1 and s2 of lowercase letters, determine if they are anagrams — i.e., if they contain the same characters with the same frequencies.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "anagraesm";
        String s2 = "nagaraewm";
        System.out.println("Are anagrams: " + isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[26]; // assuming only lowercase letters

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (int i=0; i<s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        // Implementation using HashMap

        // Map<Character, Integer> charCountMap = new HashMap<>();

        // for(int i=0; i< s1.length(); i++) {
        //     charCountMap.put(s1.charAt(i), charCountMap.getOrDefault(s1.charAt(i), 0) + 1);
        //     charCountMap.put(s2.charAt(i), charCountMap.getOrDefault(s2.charAt(i), 0) - 1);
        // }

        // for (int count : charCountMap.values()) {
        //     if (count != 0) {
        //         return false;
        //     }
        // }

        return true;
    }
}