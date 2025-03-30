package core;

import java.util.Random;

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
    public static float[][] empty(int row, int cols){
        float[][] arr_empty = new float[row][cols];
       // for (int i = 0; i < row; i++) {
       //     for (int j = 0; j < cols; j++) {
       //         arr_empty[i][j]= 0;
       //     }
       // }
        return arr_empty;
    }
    public static float[] empty(int row){
        float[] arr_empty = new float[row];
        //for (int i = 0; i < row; i++) {
        //    arr_empty[i]= 0;
        //}
        return arr_empty;
    }
    public static double[] linspace(double start, double stop, int num) {
        double diff = (stop - start) / (num - 1);
        double[] data = new double[num];
        for (int i = 0; i < num; i++) {
            data[i] = start;
            start += diff;
        }
        return data;
    }
    public static double[] logspace(double start, double stop, int num, double base) {

        double diff = (Math.pow(base,stop)- Math.pow(base,start)) / (num - 1);
        double st=Math.pow(base,start);
        double[] data = new double[num];
        for (int i = 0; i < num; i++) {
            data[i] = st;
            st += diff;
        }
        return data;
    }
    public static float[][] eye(int row, int cols, int k){
        float[][] arr_eye = new float[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (k==0){
                    if (i==j){
                        arr_eye[i][j]=1;
                    }
                    else {
                        arr_eye[i][j]=0;
                    }
                }
                if (k>0){
                    if (i==j-k){
                        arr_eye[i][j]=1;
                    }
                    else {
                        arr_eye[i][j]=0;
                    }
                }
                if (k<0){
                    if (i==j-k){
                        arr_eye[i][j]=1;
                    }
                    else {
                        arr_eye[i][j]=0;
                    }
                }
            }
        }
        return arr_eye;
    }
    public static float[][] eye(int row, int k){
        float[][] arr_eye = new float[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (k==0){
                    if (i==j){
                        arr_eye[i][j]=1;
                    }
                    else {
                        arr_eye[i][j]=0;
                    }
                }
                if (k>0){
                    if (i==j-k){
                        arr_eye[i][j]=1;
                    }
                    else {
                        arr_eye[i][j]=0;
                    }
                }
                if (k<0){
                    if (i==j-k){
                        arr_eye[i][j]=1;
                    }
                    else {
                        arr_eye[i][j]=0;
                    }
                }
            }
        }
        return arr_eye;
    }
    public static float[][] identity(int row){
        float[][] arr_identity = new float[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (i==j){
                    arr_identity[i][j]=1;
                }
                else {
                    arr_identity[i][j]=0;
                }
            }
        }
        return arr_identity;
    }
    public static int[][] random_randint(int low, int high, int rows, int cols){
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(high - low) + low;
        }
        return matrix;
    }
    public static int[] random_randint(int high, int size) {
        Random rand = new Random();
        int[] matrix = new int[size];

        for (int i = 0; i < size; i++) {
            matrix[i] = rand.nextInt(high);
        }
        return matrix;
    }
    public static float[][] ltri(int row, int cols, int k){
        float[][] arr_ltri = new float[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (k==0){
                    if (i>=j){
                        arr_ltri[i][j]=1;
                    }
                    else {
                        arr_ltri[i][j]=0;
                    }
                }
                if (k>0){
                    if (i>=j-k){
                        arr_ltri[i][j]=1 ;
                    }
                    else {
                        arr_ltri[i][j]=0;
                    }
                }
                if (k<0){
                    if (i>=j-k){
                        arr_ltri[i][j]=1;
                    }
                    else {
                        arr_ltri[i][j]=0;
                    }
                }
            }
        }
        return arr_ltri;
    }
}
