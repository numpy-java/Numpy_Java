package core;

public class NumJava extends NumArray {
    private Object data;
    private DType dtype;

    public NumJava(Object data) {
        this.data = data;
        if (data instanceof int[] || data instanceof int[][]) dtype = DType.INT;
        else if (data instanceof float[] || data instanceof float[][]) dtype = DType.FLOAT;
        else if (data instanceof double[] || data instanceof double[][]) dtype = DType.DOUBLE;
        else throw new IllegalArgumentException("Unsupported array type.");
    }

    public NumJava() {
        // Empty constructor for instance-based API
    }

    public NumJava(String value) {
        this(value, DType.INT); // Default
    }

    public NumJava(String value, DType dtype) {
        this.dtype = dtype;
        this.data = NumArray.array(value, dtype);
    }

    public NumJava from(String input) {
        return new NumJava(input);
    }

    public NumJava reshape(int rows, int cols) {
        if (data instanceof int[]) {
            int[] d = (int[]) data;
            if (d.length != rows * cols) throw new IllegalArgumentException("Size mismatch");
            int[][] reshaped = new int[rows][cols];
            for (int i = 0; i < d.length; i++) reshaped[i / cols][i % cols] = d[i];
            data = reshaped;
        } else if (data instanceof float[]) {
            float[] d = (float[]) data;
            if (d.length != rows * cols) throw new IllegalArgumentException("Size mismatch");
            float[][] reshaped = new float[rows][cols];
            for (int i = 0; i < d.length; i++) reshaped[i / cols][i % cols] = d[i];
            data = reshaped;
        } else if (data instanceof double[]) {
            double[] d = (double[]) data;
            if (d.length != rows * cols) throw new IllegalArgumentException("Size mismatch");
            double[][] reshaped = new double[rows][cols];
            for (int i = 0; i < d.length; i++) reshaped[i / cols][i % cols] = d[i];
            data = reshaped;
        }
        return this;
    }

    public NumJava flatten() {
        if (data instanceof int[][]) {
            int[][] d = (int[][]) data;
            int[] flat = new int[d.length * d[0].length];
            int idx = 0;
            for (int[] row : d) for (int val : row) flat[idx++] = val;
            data = flat;
        } else if (data instanceof float[][]) {
            float[][] d = (float[][]) data;
            float[] flat = new float[d.length * d[0].length];
            int idx = 0;
            for (float[] row : d) for (float val : row) flat[idx++] = val;
            data = flat;
        } else if (data instanceof double[][]) {
            double[][] d = (double[][]) data;
            double[] flat = new double[d.length * d[0].length];
            int idx = 0;
            for (double[] row : d) for (double val : row) flat[idx++] = val;
            data = flat;
        }
        return this;
    }

    public NumJava T() {
        if (data instanceof int[][]) {
            int[][] a = (int[][]) data;
            int[][] t = new int[a[0].length][a.length];
            for (int i = 0; i < a.length; i++) for (int j = 0; j < a[0].length; j++) t[j][i] = a[i][j];
            data = t;
        } else if (data instanceof float[][]) {
            float[][] a = (float[][]) data;
            float[][] t = new float[a[0].length][a.length];
            for (int i = 0; i < a.length; i++) for (int j = 0; j < a[0].length; j++) t[j][i] = a[i][j];
            data = t;
        } else if (data instanceof double[][]) {
            double[][] a = (double[][]) data;
            double[][] t = new double[a[0].length][a.length];
            for (int i = 0; i < a.length; i++) for (int j = 0; j < a[0].length; j++) t[j][i] = a[i][j];
            data = t;
        }
        return this;
    }

    public void print() {
        NumArray.print(data);
    }

    public Object getArray() {
        return data;
    }

    public DType getDType() {
        return dtype;
    }

    // Delegated instance methods for array creation
    public static double[] zeros(int size) {
        return (double[]) NumArray.zeros(size);
    }

    public static double[][] zeros(int rows, int cols) {
        return (double[][]) NumArray.zeros(rows, cols);
    }

    public static double[] ones(int size) {
        return (double[]) NumArray.ones(size);
    }

    public static double[][] ones(int rows, int cols) {
        return (double[][]) NumArray.ones(rows, cols);
    }

    public double[] full(int size, double value) {
        return (double[]) NumArray.full(size, (int) value);
    }

   /* public double[][] full(int rows, int cols, double value) {
        return NumArray.full(rows, cols, value);
    }*/

    public static int[] arange(int start, int stop, int step) {
        return NumArray.arange(start, stop, step);
    }

    public static float[] linspace(float start, float end, int num) {
        return NumArray.linspace(start, end, num);
    }

    public double[] logspace(double start, double end, int num, int base) {
        return NumArray.logspace(start, end, num, base);
    }

    public static float[][] eye(int rows, int cols, int k) {
        return NumArray.eye(rows, cols, k);
    }

    public static float[][] eye(int size, int k) {
        return NumArray.eye(size, k);
    }

    public static float[][] identity(int size) {
        return NumArray.identity(size);
    }

    public static int[][] random_randint(int low, int high, int rows, int cols) {
        return NumArray.random_randint(low, high, rows, cols);
    }

    public static float[][] ltri(int rows, int cols, int k) {
        return NumArray.ltri(rows, cols, k);
    }
/*
    public double[] empty(int size) {
        return NumArray.empty(size);
    }

    public double[][] empty(int rows, int cols) {
        return NumArray.empty(rows, cols);
    }*/
}
