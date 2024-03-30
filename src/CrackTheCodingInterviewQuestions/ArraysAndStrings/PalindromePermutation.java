package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

import static Helper.Helper.db;

public class PalindromePermutation {
    public static void main(String[] args) {
        db("Value: ", isPermutationOfAPalindrome("hellohe"));
    }

    static boolean isPermutationOfAPalindrome(String str) {

        /**
         * Approach: At most one character has an odd count (the middle character of the palindrome).
         * If more than one character has an odd count, the string cannot be a permutation of a palindrome.
         * */

        Map<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int count = 0;
        for(int i: map.values()) {
            if(i % 2 != 0) ++count;
        }

        return count <= 1;
    }
}
