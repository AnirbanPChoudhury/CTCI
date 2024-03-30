package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static Helper.Helper.db;

public class CheckPermutation {
    public static void main(String[] args) {
        String str1 = "poekmon3", str2 = "pkoenom";

        db("Check Permutation -> ", checkPermutation(str1, str2));
        db("Check Permutation using HashSet -> ", checkPermutationUsingHashSet(str1, str2));

    }

    static boolean checkPermutation(String str1, String str2) {
        /**
         * Time Complexity: O(nlogn)
         * Space Complexity: O(1)
         * */

        if(str1.length() != str2.length()) return false;

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        db("S1 = ", s1);
        db("S2 = ", s2);

        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.toString(s1).equals(Arrays.toString(s2));
    }

    static boolean checkPermutationUsingHashSet(String s1, String s2) {
        /**
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         * */

        if(s1.length() != s2.length()) return false;
        else {
            Set<Character> set = new HashSet<>();
            for(char c: s1.toCharArray()) set.add(c);

            for(char c: s2.toCharArray()) {
                if(!set.contains(c)) return false;
            }
        }
        return true;
    }
}
