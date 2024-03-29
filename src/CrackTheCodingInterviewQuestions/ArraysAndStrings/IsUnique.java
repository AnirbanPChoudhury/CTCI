package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static Helper.Helper.db;

public class IsUnique {
    public static void main(String[] args) {
        String str1 = "Gtwuamcxks";
        String str2 = "VbhbV";

        /** Determine if a string has all unique characters 
         * Approach 1: Brute force comparisons of one character with every other characters using two for loops
         * Approach 2: Use of HashMaps or Sets
         * Approach 3: Sort by ASCII values of the characters, if we find adjacent same characters then string is not unique
         * Approach 4: Bit Vectors??
        */

        //Approach 2
        db("HASHMAP: ", isUniqueHash(str1));
        db("Sorting by ASCII: ", isUniqueSortByASCII(str1));
        db("By Bit Vector: ", isUniqueBitVector("ahdkijhk"));

    }

    static boolean isUniqueHash(String str) {
        db("String = ", str);
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); ++i) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if(map.get(str.charAt(i)) > 1) return false;
        }

        return true;
    }

    static boolean isUniqueSortByASCII(String str) {
        db("string = ", str);

        char[] arr = str.toCharArray();

        Arrays.sort(arr);

        for(int i = 1; i < arr.length; ++i) {
            if(arr[i - 1] == arr[i]) return false;
        }

        return true;
    }

    static boolean isUniqueBitVector(String str) {
        int check = 0;

        for(int i = 0; i < str.length(); ++i) {
            int idx = str.charAt(i);

            int mask = 1 << idx;

            if((check & mask) > 0) return false;

            check |= mask;
        }
        return true;
    }
}