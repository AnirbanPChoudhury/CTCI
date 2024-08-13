package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import java.util.Arrays;

import static Helper.Helper.db;

public class URLify {
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        db("String: ", s);
        db("String length: ", s.length());

        db("\nFinal String: ", urlify(s, s.length()));
    }

    static String urlify(String str, int length) {
        char[] s = str.toCharArray();

        for(int i = 0; i < s.length; ++i) {
            if(s[i] == ' ') {
                shiftCharacter(s, i);
                db("String = ", Arrays.toString(s));
            }
        }

        return new String(s);
    }

    private static void shiftCharacter(char[] str, int idx) {

        for(int k = 0 ; k < 2; ++k)
            for(int i = str.length - 1; i > idx; --i) {
            str[i] = str[i-1];
        }
        placeCharacters(str, idx);
    }

    private static void placeCharacters(char[] str, int spaceIdx) {
        char[] p = {'%', '2', '0'};
        int pLen = 0;
        db("Space Idx = ", spaceIdx);

        for(int i = spaceIdx; i < p.length + spaceIdx; ++i) {
            str[i] = p[pLen++];
        }

        db("Place Characters: ", Arrays.toString(str));
    }
}
