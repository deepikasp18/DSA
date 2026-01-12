package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfDigits {
    public static void main(String[] args) {
        int[] digits = {2, 3};
        String[] result = letterCombinations(digits);
        for (String combination : result) {
            System.out.println(combination);
        }
    }

    private static String[] letterCombinations(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new String[0];
        }

        String[] mapping = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();
        backtrack(digits, mapping, 0, new StringBuilder(), result);
        return result.toArray(new String[0]); // For Object to String array conversion
    }

    private static void backtrack(int[] digits, String[] mapping, int index, StringBuilder current, List<String> result) {
        if (index == digits.length) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits[index]];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, mapping, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
