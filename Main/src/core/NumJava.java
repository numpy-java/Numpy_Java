package core;

public class NumJava {
    private double[][] data;
    private int rows, cols;

    public NumJava(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }


    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    public double get(int row, int col) {
        return data[row][col];
    }

    public void print() {
        for (double[] row : data) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
