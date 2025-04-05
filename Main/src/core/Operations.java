package core;

import java.util.Arrays;
import java.util.Random;

public class Operations {

    protected double[] temp1D;
    protected double[][] temp2D;
    protected float[] temp1DFloat;
    protected float[][] temp2DFloat;
    protected int[] temp1DInt;
    protected int[][] temp2DInt;

    public double[][] zeros(int row, int cols) {
        ensure2DTemp(row, cols);
        for (double[] r : temp2D) Arrays.fill(r, 0);
        return deepCopy(temp2D);
    }

    public double[] zeros(int row) {
        if (temp1D == null || temp1D.length != row) temp1D = new double[row];
        Arrays.fill(temp1D, 0);
        return Arrays.copyOf(temp1D, temp1D.length);
    }

    public double[][] ones(int rows, int cols) {
        ensure2DTemp(rows, cols);
        for (double[] r : temp2D) Arrays.fill(r, 1);
        return deepCopy(temp2D);
    }

    public double[] ones(int rows) {
        if (temp1D == null || temp1D.length != rows) temp1D = new double[rows];
        Arrays.fill(temp1D, 1);
        return Arrays.copyOf(temp1D, temp1D.length);
    }

    public double[][] full(int rows, int cols, int value) {
        ensure2DTemp(rows, cols);
        for (double[] r : temp2D) Arrays.fill(r, value);
        return deepCopy(temp2D);
    }

    public double[] full(int rows, int value) {
        if (temp1D == null || temp1D.length != rows) temp1D = new double[rows];
        Arrays.fill(temp1D, value);
        return Arrays.copyOf(temp1D, temp1D.length);
    }

    public double[] arange(int start, int stop, int step) {
        int rows = (stop - start) / step + 1;
        temp1D = new double[rows];
        for (int i = 0; i < rows; i++) {
            temp1D[i] = start;
            start += step;
        }
        return Arrays.copyOf(temp1D, rows);
    }

    public float[][] empty(int row, int cols) {
        return new float[row][cols];
    }

    public float[] empty(int row) {
        return new float[row];
    }

    public double[] linspace(double start, double stop, int num) {
        temp1D = new double[num];
        double diff = (stop - start) / (num - 1);
        for (int i = 0; i < num; i++) {
            temp1D[i] = start;
            start += diff;
        }
        return Arrays.copyOf(temp1D, num);
    }

    public double[] logspace(double start, double stop, int num, double base) {
        temp1D = new double[num];
        double s = Math.pow(base, start);
        double e = Math.pow(base, stop);
        double diff = (e - s) / (num - 1);
        for (int i = 0; i < num; i++) {
            temp1D[i] = s;
            s += diff;
        }
        return Arrays.copyOf(temp1D, num);
    }

    public float[][] eye(int row, int cols, int k) {
        float[][] arr_eye = new float[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                arr_eye[i][j] = (i == j - k) ? 1 : 0;
            }
        }
        return arr_eye;
    }

    public float[][] eye(int row, int k) {
        return eye(row, row, k);
    }

    public float[][] identity(int row) {
        float[][] arr_identity = new float[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                arr_identity[i][j] = (i == j) ? 1 : 0;
            }
        }
        return arr_identity;
    }

    public int[][] random_randint(int low, int high, int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(high - low) + low;
        return matrix;
    }

    public int[] random_randint(int high, int size) {
        Random rand = new Random();
        int[] matrix = new int[size];
        for (int i = 0; i < size; i++)
            matrix[i] = rand.nextInt(high);
        return matrix;
    }

    public float[][] ltri(int row, int cols, int k) {
        float[][] arr_ltri = new float[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                arr_ltri[i][j] = (i >= j - k) ? 1 : 0;
            }
        }
        return arr_ltri;
    }

    private void ensure2DTemp(int rows, int cols) {
        if (temp2D == null || temp2D.length != rows || temp2D[0].length != cols) {
            temp2D = new double[rows][cols];
        }
    }

    private double[][] deepCopy(double[][] source) {
        double[][] copy = new double[source.length][source[0].length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return copy;
    }
}