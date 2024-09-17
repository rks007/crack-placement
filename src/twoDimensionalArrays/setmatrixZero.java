package twoDimensionalArrays;

public class setmatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] copy = matrix;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = copy[i][j];
            }
            System.out.println();
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(copy[i][j] == 0){
                    setMatrix(i, j, matrix);
                }
            }
        }
    }

    private static void setMatrix(int row, int col, int[][] matrix){
        setRow(col, matrix);
        setCol(row, matrix);
    }

    private static void setRow(int col, int[][] matrix){
        for(int i = 0; i < matrix.length;i++){
            if(matrix[i][col] != 0){
                matrix[i][col] = 0;
            }
        }
    }

    private static void setCol(int row, int[][] matrix){
        for(int i = 0; i < matrix.length;i++){
            if(matrix[row][i] != 0){
                matrix[row][i] = 0;
            }
        }
    }
}
