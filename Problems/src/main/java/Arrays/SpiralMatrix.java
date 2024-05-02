package Arrays;

public class SpiralMatrix {
    public static void spiralMatrix(int [][] matrix) {
        int colStart = 0;
        int rowStart = 0;
        int colEnd = matrix.length -1;
        int rowEnd = matrix[0].length - 1;
        StringBuilder res = new StringBuilder();

        while (colStart != (colEnd - 1) && rowStart != (rowEnd - 1)) {
            for (int i = colStart; i <= colEnd; ++i) {
                res.append(matrix[i][rowStart]).append(" ");
//                System.out.println(matrix[i][rowStart]);
            }
            ++rowStart;

            for (int i = rowStart; i <= rowEnd; ++i) {
                res.append(matrix[colEnd][i]).append(" ");
//                System.out.println(matrix[colEnd][i]);
            }
            --colEnd;

            for (int i = colEnd; i >= colStart; --i) {
                res.append(matrix[i][rowEnd]).append(" ");
//                System.out.println(matrix[i][rowEnd]);
            }
            --rowEnd;

            for (int i = rowEnd; i >= rowStart; --i) {
                res.append(matrix[colStart][i]).append(" ");
//                System.out.println(matrix[colStart][i]);
            }
            ++colStart;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {

        int [][] matrix = {
                {1, 12, 11, 10},
                {2, 13, 16, 9},
                {3, 14, 15, 8},
                {4, 5,  6,  7}
        };

        spiralMatrix(matrix);
    }
}
