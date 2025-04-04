package core;

import java.util.Arrays;
import java.util.Random;

public class Operations {

    // Temporary reusable arrays to reduce object creation
    protected static double[] temp1D;
    protected static double[][] temp2D;
    protected static float[] temp1DFloat;
    protected static float[][] temp2DFloat;
    protected static int[] temp1DInt;
    protected static int[][] temp2DInt;

    // Returns a 2D array filled with zeros
    public static double[][] zeros(int row, int cols) {
        ensure2DTemp(row, cols);
        for (double[] r : temp2D) Arrays.fill(r, 0);
        return deepCopy(temp2D);
    }

    // Returns a 1D array filled with zeros
    public static double[] zeros(int row) {
        if (temp1D == null || temp1D.length != row) temp1D = new double[row];
        Arrays.fill(temp1D, 0);
        return Arrays.copyOf(temp1D, temp1D.length);
    }

    // Returns a 2D array filled with ones
    public static double[][] ones(int rows, int cols) {
        ensure2DTemp(rows, cols);
        for (double[] r : temp2D) Arrays.fill(r, 1);
        return deepCopy(temp2D);
    }

    // Returns a 1D array filled with ones
    public static double[] ones(int rows) {
        if (temp1D == null || temp1D.length != rows) temp1D = new double[rows];
        Arrays.fill(temp1D, 1);
        return Arrays.copyOf(temp1D, temp1D.length);
    }

    // Returns a 2D array filled with a specific value
    public static double[][] full(int rows, int cols, int value) {
        ensure2DTemp(rows, cols);
        for (double[] r : temp2D) Arrays.fill(r, value);
        return deepCopy(temp2D);
    }

    // Returns a 1D array filled with a specific value
    public static double[] full(int rows, int value) {
        if (temp1D == null || temp1D.length != rows) temp1D = new double[rows];
        Arrays.fill(temp1D, value);
        return Arrays.copyOf(temp1D, temp1D.length);
    }

    // Returns a 1D array with values from start to stop with a specific step
    public static double[] arange(int start, int stop, int step) {
        int size = (stop - start) / step + 1;
        if (temp1D == null || temp1D.length != size) temp1D = new double[size];
        for (int i = 0; i < size; i++) {
            temp1D[i] = start;
            start += step;
        }
        return Arrays.copyOf(temp1D, size);
    }

    // Returns a 2D empty float array (uninitialized values)
    public static float[][] empty(int row, int cols) {
        return new float[row][cols];
    }

    // Returns a 1D empty float array (uninitialized values)
    public static float[] empty(int row) {
        return new float[row];
    }

    // Returns a 1D array with evenly spaced numbers between start and stop
    public static double[] linspace(double start, double stop, int num) {
        if (temp1D == null || temp1D.length != num) temp1D = new double[num];
        double step = (stop - start) / (num - 1);
        for (int i = 0; i < num; i++) {
            temp1D[i] = start;
            start += step;
        }
        return Arrays.copyOf(temp1D, num);
    }

    // Returns a 1D array with logarithmically spaced values
    public static double[] logspace(double start, double stop, int num, double base) {
        if (temp1D == null || temp1D.length != num) temp1D = new double[num];
        double s = Math.pow(base, start);
        double e = Math.pow(base, stop);
        double step = (e - s) / (num - 1);
        for (int i = 0; i < num; i++) {
            temp1D[i] = s;
            s += step;
        }
        return Arrays.copyOf(temp1D, num);
    }

    // Returns a 2D identity-like matrix with diagonal offset by k
    public static float[][] eye(int row, int cols, int k) {
        float[][] arr = new float[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = (i == j - k) ? 1 : 0;
            }
        }
        return deepCopyFloat(arr);
    }

    // Returns a square identity-like matrix with diagonal offset by k
    public static float[][] eye(int row, int k) {
        return eye(row, row, k);
    }

    // Returns a square identity matrix (diagonal 1s)
    public static float[][] identity(int row) {
        float[][] arr = new float[row][row];
        for (int i = 0; i < row; i++) {
            arr[i][i] = 1;
        }
        return deepCopyFloat(arr);
    }

    // Returns a 2D array of random integers between low and high
    public static int[][] random_randint(int low, int high, int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(high - low) + low;
        return deepCopyInt(matrix);
    }

    // Returns a 1D array of random integers from 0 to high
    public static int[] random_randint(int high, int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = rand.nextInt(high);
        return Arrays.copyOf(array, array.length);
    }

    // Returns a lower triangular 2D matrix with diagonal offset by k
    public static float[][] ltri(int row, int cols, int k) {
        float[][] arr = new float[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = (i >= j - k) ? 1 : 0;
            }
        }
        return deepCopyFloat(arr);
    }



    //Utility Methods
    // Utility: ensures temp2D is the correct size before reuse
    protected static void ensure2DTemp(int rows, int cols) {
        if (temp2D == null || temp2D.length != rows || temp2D[0].length != cols)
            temp2D = new double[rows][cols];
    }

    // Utility: creates a deep copy of a float 2D array
    protected static float[][] deepCopyFloat(float[][] source) {
        float[][] copy = new float[source.length][];
        for (int i = 0; i < source.length; i++)
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        return copy;
    }

    // Utility: creates a deep copy of an int 2D array
    protected static int[][] deepCopyInt(int[][] source) {
        int[][] copy = new int[source.length][];
        for (int i = 0; i < source.length; i++)
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        return copy;
    }

    // Utility: creates a deep copy of a double 2D array
    protected static double[][] deepCopy(double[][] source) {
        double[][] copy = new double[source.length][];
        for (int i = 0; i < source.length; i++)
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        return copy;
    }
}
