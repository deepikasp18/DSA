package Strings;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefixUsingTrie {
    
    public static class TrieNode {
        List<TrieNode> children;
        public int childCount;
        public boolean isEndOfWord; // is Leaf

        public TrieNode() {
            children = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
                children.add(null);
            }
            childCount = 0;
            isEndOfWord = false;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        TrieNode root = new TrieNode();

        // insert all strings into the Trie
        for (String str : strs) {
            insertIntoTrie(root, str);
        }

        // Find the longest common prefix
        StringBuilder lcp = new StringBuilder();
        TrieNode current = root;

        int i = 0;
        while (current.childCount == 1 && !current.isEndOfWord) {
            lcp.append(strs[0].charAt(i));
            current = current.children.get(getIndex(strs[0].charAt(i)));
            i++;
        }

        return lcp.toString();
    }

    private static void insertIntoTrie(TrieNode root, String str) {
        TrieNode current = root;
        for (char ch: str.toCharArray()) {
            int idx = getIndex(ch);
            if (current.children.get(idx) == null) {
                current.children.set(idx, new TrieNode());
                current.childCount++;
            }
            current = current.children.get(idx);
        }
        current.isEndOfWord = true;
    }

    private static int getIndex(char ch) {
        return ch - 'a';
    }
}
