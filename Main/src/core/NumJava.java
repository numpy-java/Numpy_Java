package core;

import java.util.Arrays;

public class NumJava extends NumArray {
    private int[] int1D;
    private int[][] int2D;

    private float[] float1D;
    private float[][] float2D;

    private double[] double1D;
    private double[][] double2D;

    private DType dtype = DType.INT; // Default dtype

    public NumJava() {}

    public NumJava(int[] data) {
        this.int1D = data;
        this.dtype = DType.INT;
    }

    public NumJava(int[][] data) {
        this.int2D = data;
        this.dtype = DType.INT;
    }

    public NumJava(float[] data) {
        this.float1D = data;
        this.dtype = DType.FLOAT;
    }

    public NumJava(float[][] data) {
        this.float2D = data;
        this.dtype = DType.FLOAT;
    }

    public NumJava(double[] data) {
        this.double1D = data;
        this.dtype = DType.DOUBLE;
    }

    public NumJava(double[][] data) {
        this.double2D = data;
        this.dtype = DType.DOUBLE;
    }

    public NumJava(String value) {
        this(value, DType.INT); // Default dtype is INT
    }

    public NumJava(String value, DType dtype) {
        this.dtype = dtype;
        Object result = NumArray.array(value, dtype);
        switch (dtype) {
            case INT:
                if (result instanceof int[][]) this.int2D = (int[][]) result;
                else this.int1D = (int[]) result;
                break;
            case FLOAT:
                if (result instanceof float[][]) this.float2D = (float[][]) result;
                else this.float1D = (float[]) result;
                break;
            case DOUBLE:
                if (result instanceof double[][]) this.double2D = (double[][]) result;
                else this.double1D = (double[]) result;
                break;
        }
    }

    public NumJava T() {
        switch (dtype) {
            case INT:
                if (int2D != null) {
                    int rows = int2D.length, cols = int2D[0].length;
                    int[][] transposed = new int[cols][rows];
                    for (int i = 0; i < rows; i++)
                        for (int j = 0; j < cols; j++)
                            transposed[j][i] = int2D[i][j];
                    this.int2D = transposed;
                    this.int1D = null;
                }
                break;
            case FLOAT:
                if (float2D != null) {
                    int rows = float2D.length, cols = float2D[0].length;
                    float[][] transposed = new float[cols][rows];
                    for (int i = 0; i < rows; i++)
                        for (int j = 0; j < cols; j++)
                            transposed[j][i] = float2D[i][j];
                    this.float2D = transposed;
                    this.float1D = null;
                }
                break;
            case DOUBLE:
                if (double2D != null) {
                    int rows = double2D.length, cols = double2D[0].length;
                    double[][] transposed = new double[cols][rows];
                    for (int i = 0; i < rows; i++)
                        for (int j = 0; j < cols; j++)
                            transposed[j][i] = double2D[i][j];
                    this.double2D = transposed;
                    this.double1D = null;
                }
                break;
        }
        return this;
    }

    public NumJava reshape(int rows, int cols) {
        switch (dtype) {
            case INT:
                if (int1D != null && rows * cols == int1D.length) {
                    int[][] reshaped = new int[rows][cols];
                    for (int i = 0; i < int1D.length; i++)
                        reshaped[i / cols][i % cols] = int1D[i];
                    this.int2D = reshaped;
                    this.int1D = null;
                }
                break;
            case FLOAT:
                if (float1D != null && rows * cols == float1D.length) {
                    float[][] reshaped = new float[rows][cols];
                    for (int i = 0; i < float1D.length; i++)
                        reshaped[i / cols][i % cols] = float1D[i];
                    this.float2D = reshaped;
                    this.float1D = null;
                }
                break;
            case DOUBLE:
                if (double1D != null && rows * cols == double1D.length) {
                    double[][] reshaped = new double[rows][cols];
                    for (int i = 0; i < double1D.length; i++)
                        reshaped[i / cols][i % cols] = double1D[i];
                    this.double2D = reshaped;
                    this.double1D = null;
                }
                break;
        }
        return this;
    }

    public NumJava reshape(int size) {
        switch (dtype) {
            case INT:
                if (int2D != null) {
                    int total = int2D.length * int2D[0].length;
                    if (size != total) throw new IllegalArgumentException("Invalid reshape size");
                    int[] flat = new int[size];
                    int idx = 0;
                    for (int[] row : int2D)
                        for (int val : row)
                            flat[idx++] = val;
                    this.int1D = flat;
                    this.int2D = null;
                }
                break;
            case FLOAT:
                if (float2D != null) {
                    int total = float2D.length * float2D[0].length;
                    if (size != total) throw new IllegalArgumentException("Invalid reshape size");
                    float[] flat = new float[size];
                    int idx = 0;
                    for (float[] row : float2D)
                        for (float val : row)
                            flat[idx++] = val;
                    this.float1D = flat;
                    this.float2D = null;
                }
                break;
            case DOUBLE:
                if (double2D != null) {
                    int total = double2D.length * double2D[0].length;
                    if (size != total) throw new IllegalArgumentException("Invalid reshape size");
                    double[] flat = new double[size];
                    int idx = 0;
                    for (double[] row : double2D)
                        for (double val : row)
                            flat[idx++] = val;
                    this.double1D = flat;
                    this.double2D = null;
                }
                break;
        }
        return this;
    }

    public NumJava flatten() {
        if (dtype == DType.INT && int2D != null) return reshape(int2D.length * int2D[0].length);
        if (dtype == DType.FLOAT && float2D != null) return reshape(float2D.length * float2D[0].length);
        if (dtype == DType.DOUBLE && double2D != null) return reshape(double2D.length * double2D[0].length);
        return this;
    }

    public void print() {
        switch (dtype) {
            case INT:
                if (int1D != null) NumArray.print(int1D);
                else if (int2D != null) NumArray.print(int2D);
                break;
            case FLOAT:
                if (float1D != null) NumArray.print(float1D);
                else if (float2D != null) NumArray.print(float2D);
                break;
            case DOUBLE:
                if (double1D != null) NumArray.print(double1D);
                else if (double2D != null) NumArray.print(double2D);
                break;
        }
    }


   /* public static Object ones(int size, DType dtype) {
        switch (dtype) {
            case INT:
                int[] iArr = new int[size];
                Arrays.fill(iArr, 1);
                return iArr;
            case FLOAT:
                float[] fArr = new float[size];
                Arrays.fill(fArr, 1f);
                return fArr;
            case DOUBLE:
                double[] dArr = new double[size];
                Arrays.fill(dArr, 1.0);
                return dArr;
        }
        throw new IllegalArgumentException("Unsupported dtype: " + dtype);
    }

    public static Object ones(int rows, int cols, DType dtype) {
        switch (dtype) {
            case INT:
                int[][] iArr2D = new int[rows][cols];
                for (int[] row : iArr2D) Arrays.fill(row, 1);
                return iArr2D;
            case FLOAT:
                float[][] fArr2D = new float[rows][cols];
                for (float[] row : fArr2D) Arrays.fill(row, 1f);
                return fArr2D;
            case DOUBLE:
                double[][] dArr2D = new double[rows][cols];
                for (double[] row : dArr2D) Arrays.fill(row, 1.0);
                return dArr2D;
        }
        throw new IllegalArgumentException("Unsupported dtype: " + dtype);
    }*/

    public DType getDType() {
        return dtype;
    }

    public Object getArray() {
        switch (dtype) {
            case INT:
                return int1D != null ? int1D : int2D;
            case FLOAT:
                return float1D != null ? float1D : float2D;
            case DOUBLE:
                return double1D != null ? double1D : double2D;
            default:
                return null;
        }
    }
}
