import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; ++i) {

            int input = sc.nextInt();

            int num = Integer.parseInt(getNumberfromDigits(input));

            System.out.println(requiredNum(num));
        }
    }

    static int requiredNum(int num) {
        for (int i = num; i < num * 10; ++i) {
            if (i % 3 == 0 && i % 9 != 0 && i % 2 != 0) {
                return i;
            } else continue;
        }
        return 0;
    }

    static String getNumberfromDigits(int n) {

        StringBuffer s = new StringBuffer("1");

        for (int i = 1; i < n; ++i) {
            s.append("0");
        }

        return s.toString();
    }
}