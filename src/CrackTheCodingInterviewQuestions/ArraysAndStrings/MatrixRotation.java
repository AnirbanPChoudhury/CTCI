package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import static Helper.Helper.*;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateBy90(arr);

        printMatrix(arr);
    }

    static void rotateBy90(int[][] arr) {
        transpose(arr);
        reverseRow(arr);
    }

    static int[][] transpose(int[][] arr) {

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr[i].length; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }

    static int[][] reverseRow(int[][] mat) {
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat.length / 2; ++j) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length - j - 1];
                mat[i][mat.length - j - 1] = temp;
            }
        }
        return mat;
    }
}
