package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import static Helper.Helper.db;

public class StringCompression {
    public static void main(String[] args) {
        db("String: ", compress("aaaabb"));
    }

    static String compress(String str) {
        int count = 1;
        char pointer = str.charAt(0);
        StringBuilder builder = new StringBuilder();

        for(int i = 1; i < str.length(); ++i) {
            if(pointer != str.charAt(i) || i == str.length() - 1) {
                builder.append(pointer + String.valueOf(count));
                count = 0;
            }
            ++count;
            pointer = str.charAt(i);
        }

        return builder.toString();
    }
}
