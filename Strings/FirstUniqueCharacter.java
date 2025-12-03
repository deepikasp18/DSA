package Strings;

/*
 * Given a string s of lowercase English letters, the task is to find the first non-repeating character. If there is no such character, return '$'.
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println("First non-repeating character is: " + firstUniqueCharacter(s));
    }

    public static String firstUniqueCharacter(String s) {
        int[] charCount = new int[26]; // assuming only lowercase letters
        s  = s.toLowerCase();

        for (char ch: s.toCharArray()) {
            charCount[ch-'a']++;
        }

        for (char ch: s.toCharArray()) {
            if (charCount[ch-'a'] == 1) {
                return String.valueOf(ch);
            }
        }
        
        return "$";
    }

}
