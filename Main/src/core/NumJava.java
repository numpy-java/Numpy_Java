package core;

public class NumJava extends NumArray {
    private double[][] data2D;
    private double[] data1D;

    public NumJava(double[] data) {
        this.data1D = data;
    }

    public NumJava(double[][] data) {
        this.data2D = data;
    }


    public NumJava() {}

    public NumJava(String value) {
        Object result = NumArray.array(value);
        if (result instanceof double[][]) {
            this.data2D = (double[][]) result;
        } else if (result instanceof double[]) {
            this.data1D = (double[]) result;
        }
    }

    // Inside NumJava class

    public NumJava T() {
        if (data2D != null) {
            int rows = data2D.length;
            int cols = data2D[0].length;
            double[][] transposed = new double[cols][rows];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposed[j][i] = data2D[i][j];
                }
            }

            this.data2D = transposed;
            this.data1D = null; // Clear 1D since we're now working with 2D
        } else {
            System.out.println("Transpose is only supported for 2D arrays.");
        }

        return this;
    }
    public NumJava reshape(int rows, int cols) {
        if (data1D != null) {
            if (rows * cols != data1D.length) {
                throw new IllegalArgumentException("Reshape dimensions do not match array size.");
            }

            double[][] reshaped = new double[rows][cols];
            for (int i = 0; i < data1D.length; i++) {
                reshaped[i / cols][i % cols] = data1D[i];
            }

            this.data2D = reshaped;
            this.data1D = null; // Converted to 2D
        } else {
            System.out.println("Reshape is only supported for 1D arrays.");
        }

        return this;
    }
    public NumJava reshape(int size) {
        if (data2D != null) {
            int totalElements = data2D.length * data2D[0].length;
            if (size != totalElements) {
                throw new IllegalArgumentException("Reshape size does not match array size.");
            }

            double[] flattened = new double[size];
            int index = 0;
            for (double[] row : data2D) {
                for (double val : row) {
                    flattened[index++] = val;
                }
            }

            this.data1D = flattened;
            this.data2D = null; // Converted to 1D
        } else {
            System.out.println("Reshape(int) is only supported for 2D arrays.");
        }

        return this;
    }
    public NumJava flatten() {
        if (data2D != null) {
            int totalElements = data2D.length * data2D[0].length;
            return this.reshape(totalElements);
        } else {
            System.out.println("Flatten is only supported for 2D arrays.");
            return this;
        }
    }


    public static NumJava from(String value) {
        return new NumJava(value);
    }

    public double[] get1D() {
        return data1D;
    }

    public double[][] get2D() {
        return data2D;
    }

    public void print() {
        if (data1D != null) {
            NumArray.print(data1D);
        } else if (data2D != null) {
            NumArray.print(data2D);
        } else {
            System.out.println("Array is empty.");
        }
    }
}