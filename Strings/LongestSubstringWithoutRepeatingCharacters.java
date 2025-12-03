package Strings;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of Longest Substring Without Repeating Characters: " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        // Sliding Window Approach
        // int maxLength = 0;
        // boolean[] visited = new boolean[26]; // Assuming only lowercase letters 'a' to 'z'

        // int left = 0, right = 0;
        // while (right < s.length()) {
        //     while (visited[s.charAt(right) -'a'] == true) {
        //         visited[s.charAt(left)-'a'] = false;
        //         left++;
        //     }
        //     visited[s.charAt(right)-'a'] = true;
        //     maxLength = Math.max(maxLength, right - left + 1);
        //     right++;
        // }

        // // Last Index of Each character
        int maxLength = 0;
        int[] lastIndex = new int[26]; // Assuming only lowercase letters 'a' to 'z'
        for (int index: lastIndex) {
            index = -1;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (lastIndex[currentChar - 'a'] >= left) {
                left = lastIndex[currentChar - 'a'] + 1;
            }
            lastIndex[currentChar - 'a'] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
