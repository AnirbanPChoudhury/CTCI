package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import static Helper.Helper.db;

public class StringRotation {
    public static void main(String[] args) {
        db("Answer: ", isRotation("waterbottle", "erbottlewat"));
    }

    static boolean isRotation(String s1, String s2) {

        if(s1.length() != s2.length()) return false;

        char c = s1.charAt(0);

        for(int i = 0; i < s1.length(); ++i) {
            if(c == s2.charAt(i)) {
                int from = i - 1;
                int to = s1.length();

                String x = s1.substring(0, i);
                db("X = ", x);
                String y = s1.substring(i, to);
                db("Y = ", y);

                String xy = x + y;
                db("XY: ", xy);
                String yx = y + x;
                db("YX: ", yx);

                if(xy.equals(s1) || yx.equals(s1)) return true;

            }
        }
        return false;
    }
}
