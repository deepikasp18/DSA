package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Grouped Anagrams: " + groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> hashIndexMap = new HashMap<>();
        
        for (String str: strs) {
            String hash = getHash(str);

            if (!hashIndexMap.containsKey(hash)) {
                hashIndexMap.put(hash, result.size());  // Map hash to current result size, hash and its index in the result
                result.add(new ArrayList<>());
            }

            result.get(hashIndexMap.get(hash)).add(str);
        }
        return result;
    }

    private static String getHash(String s) {
        int[] charCount = new int[26]; // Assuming only lowercase letters 'a' to 'z'
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        StringBuilder hashBuilder = new StringBuilder();
        for (int count : charCount) {
            hashBuilder.append('#'); // Delimiter to avoid ambiguity
            hashBuilder.append(count);
        }
        return hashBuilder.toString();
    }
}
