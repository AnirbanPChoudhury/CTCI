package Helper;


public class Helper {
    public static void db(String str, Object ob) {
        System.out.println(str + ob);
    }

    public static void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[i].length; ++j) {
                System.out.print(mat[i][j]);
                if(j != mat[i].length - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}

