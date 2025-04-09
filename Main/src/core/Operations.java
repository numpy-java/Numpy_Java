package core;

import java.util.Arrays;
import java.util.Random;

public class Operations {

    public static Object zeros(int rows, int cols) {
        return zeros(rows, cols, DType.INT);
    }

    public static Object zeros(int rows, int cols, DType dtype) {
        switch (dtype) {
            case FLOAT:
                float[][] fz = new float[rows][cols];
                for (float[] row : fz) Arrays.fill(row, 0f);
                return fz;
            case DOUBLE:
                double[][] dz = new double[rows][cols];
                for (double[] row : dz) Arrays.fill(row, 0.0);
                return dz;
            case INT:
            default:
                int[][] iz = new int[rows][cols];
                for (int[] row : iz) Arrays.fill(row, 0);
                return iz;
        }
    }

    public static Object zeros(int rows) {
        return zeros(rows, DType.INT);
    }

    public static Object zeros(int rows, DType dtype) {
        switch (dtype) {
            case FLOAT:
                float[] fz = new float[rows];
                Arrays.fill(fz, 0f);
                return fz;
            case DOUBLE:
                double[] dz = new double[rows];
                Arrays.fill(dz, 0.0);
                return dz;
            case INT:
            default:
                int[] iz = new int[rows];
                Arrays.fill(iz, 0);
                return iz;
        }
    }

    public static Object ones(int rows, int cols) {
        return ones(rows, cols, DType.INT);
    }

    public static Object ones(int rows, int cols, DType dtype) {
        switch (dtype) {
            case FLOAT:
                float[][] fz = new float[rows][cols];
                for (float[] row : fz) Arrays.fill(row, 1f);
                return fz;
            case DOUBLE:
                double[][] dz = new double[rows][cols];
                for (double[] row : dz) Arrays.fill(row, 1.0);
                return dz;
            case INT:
            default:
                int[][] iz = new int[rows][cols];
                for (int[] row : iz) Arrays.fill(row, 1);
                return iz;
        }
    }

    public static Object ones(int rows) {
        return ones(rows, DType.INT);
    }

    public static Object ones(int rows, DType dtype) {
        switch (dtype) {
            case FLOAT:
                float[] fz = new float[rows];
                Arrays.fill(fz, 1f);
                return fz;
            case DOUBLE:
                double[] dz = new double[rows];
                Arrays.fill(dz, 1.0);
                return dz;
            case INT:
            default:
                int[] iz = new int[rows];
                Arrays.fill(iz, 1);
                return iz;
        }
    }

    public static Object full(int rows, int cols, int value) {
        return full(rows, cols, value, DType.INT);
    }

    public static Object full(int rows, int cols, int value, DType dtype) {
        switch (dtype) {
            case FLOAT:
                float[][] fz = new float[rows][cols];
                for (float[] row : fz) Arrays.fill(row, (float) value);
                return fz;
            case DOUBLE:
                double[][] dz = new double[rows][cols];
                for (double[] row : dz) Arrays.fill(row, (double) value);
                return dz;
            case INT:
            default:
                int[][] iz = new int[rows][cols];
                for (int[] row : iz) Arrays.fill(row, value);
                return iz;
        }
    }

    public static Object full(int rows, int value) {
        return full(rows, value, DType.INT);
    }

    public static Object full(int rows, int value, DType dtype) {
        switch (dtype) {
            case FLOAT:
                float[] fz = new float[rows];
                Arrays.fill(fz, (float) value);
                return fz;
            case DOUBLE:
                double[] dz = new double[rows];
                Arrays.fill(dz, (double) value);
                return dz;
            case INT:
            default:
                int[] iz = new int[rows];
                Arrays.fill(iz, value);
                return iz;
        }
    }

    public static int[] arange(int start, int stop, int step) {
        int size = (stop - start) / step + 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = start;
            start += step;
        }
        return arr;
    }

    public static float[] linspace(float start, float stop, int num) {
        float[] arr = new float[num];
        float step = (stop - start) / (num - 1);
        for (int i = 0; i < num; i++) {
            arr[i] = start;
            start += step;
        }
        return arr;
    }

    public static double[] logspace(double start, double stop, int num, double base) {
        double[] arr = new double[num];
        double step = (stop - start) / (num - 1);
        for (int i = 0; i < num; i++) {
            arr[i] = Math.pow(base, start + i * step);
        }
        return arr;
    }

    public static int[][] random_randint(int low, int high, int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(high - low) + low;
        return matrix;
    }

    public static int[] random_randint(int high, int size) {
        Random rand = new Random();
        int[] matrix = new int[size];
        for (int i = 0; i < size; i++)
            matrix[i] = rand.nextInt(high);
        return matrix;
    }

    public static float[][] eye(int rows, int cols, int k) {
        float[][] eye = new float[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (i - k >= 0 && i - k < cols) eye[i][i - k] = 1f;
        }
        return eye;
    }

    public static float[][] eye(int rows, int k) {
        return eye(rows, rows, k);
    }

    public static float[][] identity(int rows) {
        return eye(rows, 0);
    }

    public static float[][] ltri(int rows, int cols, int k) {
        float[][] tri = new float[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tri[i][j] = i >= j - k ? 1f : 0f;
            }
        }
        return tri;
    }
}
