package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

import static Helper.Helper.db;

public class OneAway {
    public static void main(String[] args) {
        db("OneAway: ", oneAway("pale", "ple"));
        db("OneAway: ", oneAway("pales", "pale"));
        db("OneAway: ", oneAway("pale", "bale"));
        db("OneAway: ", oneAway("pale", "bake"));
        db("OneAway: ", oneAway("pales", "ple"));
        db("OneAway: ", oneAway("abcd", "bcde"));
        db("OneAway: ", oneAway("abc", "ac"));
    }

    static boolean oneAway(String s1, String s2) {

        if(Math.abs(s1.length() - s2.length()) > 1) return false;

        Set<Character> set1 = new HashSet<>();

        for(char c: s1.toCharArray()) set1.add(c);

        int commonCharacterCount = 0;

        for(char c: s2.toCharArray()) {
            if(set1.contains(c)) ++commonCharacterCount;
        }
        db("Count of " + s1 + ", " + s2 + ": ", commonCharacterCount);

        int maxLen = Math.max(s1.length(), s2.length());

        return (maxLen - commonCharacterCount) == 1;
    }
}
