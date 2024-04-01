package CrackTheCodingInterviewQuestions.ArraysAndStrings;

import static Helper.Helper.*;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        zeroMatrix(arr);
        printMatrix(arr);
    }

    static int[][] zeroMatrix(int[][] mat) {

        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[i].length; ++j) {
                if(mat[i][j] == 0) {
                    setRowAndColumn(mat, i, j);
                    return mat;
                }
            }
        }

        return mat;
    }

    static int[][] setRowAndColumn(int[][] mat, int r, int c) {

        //clear row
        for(int j = 0; j < mat[r].length; ++j) {
            mat[r][j] = 0;
        }

        //clear column
        for(int i = 0; i < mat.length; ++i) {
            mat[i][c] = 0;
        }

        return mat;
    }
}
