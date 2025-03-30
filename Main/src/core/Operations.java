package core;

public class Operations {

    public static NumJava add(NumJava a, NumJava b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new IllegalArgumentException("Shape mismatch");
        }

        NumJava result = new NumJava(a.getRows(), a.getCols());
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getCols(); j++) {

                result.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }
        return result;
    }
    public static double[][] zeros(int row, int cols){
        double[][] arr_zeros = new double[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                arr_zeros[i][j]=0;
            }
        }
        return arr_zeros;
    }
    public static double[] zeros(int row){
        double[] arr_zeros = new double[row];
        for (int i = 0; i < row; i++) {
                arr_zeros[i]=0;
        }
        return arr_zeros;
    }
    public static double[][] ones(int rows, int cols) {
        double[][] data = new double[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0; j < cols; j++){
                data[i][j]=1;
            }
        }
        return data;
    }
    public static double[] ones(int rows) {
        double[] data = new double[rows];
        for(int i = 0; i <rows; i++){
            data[i]=1;
        }
        return data;
    }
    public static double[][] full(int rows, int cols, int value) {
        double[][] data = new double[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0; j < cols; j++){
                data[i][j]=value;
            }
        }
        return data;
    }
    public static double[] full(int rows, int value) {
        double[] data = new double[rows];
        for(int i = 0; i <rows; i++){
            data[i]=value;
        }
        return data;
    }
    public static double[] arange(int start, int stop, int step) {
        int rows = (stop - start) / step + 1;
        double[] data = new double[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = start;
            start += step;
        }
        return data;
    }
    public static double[][] eye(int N, int M, int k){
        double[][] matrix = new double[N][M];
        for (int i = 0; i < N; i++) {
            int j = i + k;
            if (j >= 0 && j < M) {
                matrix[i][j] = 1.0;
            }
        }
        return matrix;
    }
    public static double[][] eye(int N, int M){
        int k=0;
        double[][] matrix = new double[N][M];
        for (int i = 0; i < N; i++) {
            int j = i + k;
            if (j >= 0 && j < M) {
                matrix[i][j] = 1.0;
            }
        }
        return matrix;
    }
}
