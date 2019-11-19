public class MatrixSnaky {

    public static void main(String[] args) {
        int n = 5;

        int[][] matrix = buildMatrix(n);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] buildMatrix(int n) {
        boolean toRight = true;
        int i = 0;
        int j = 0;
        int[][] matrix = new int[n][n];
        int num = 0;
        while (i < n && j < n) {
            matrix[i][j] = ++num;
            if (toRight) {
                if (j < n - 1 && i == 0) {
                    ++j;
                    toRight = false;
                } else if (j == n - 1) {
                    ++i;
                    toRight = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i < n - 1 && j == 0) {
                    ++i;
                    toRight = true;
                } else if (i == n - 1) {
                    ++j;
                    toRight = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return matrix;
    }

}
